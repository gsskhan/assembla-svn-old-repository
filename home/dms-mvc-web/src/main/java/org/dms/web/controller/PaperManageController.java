package org.dms.web.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.dms.web.bo.PaperService;
import org.dms.web.constants.ViewConstants;
import org.dms.web.core.JsonUtil;
import org.dms.web.entity.PaperStore;
import org.dms.web.exception.DmsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PaperManageController {

	private Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	private PaperService paperService;
	
	private String statusmsg = "";
	
	@RequestMapping(value="/upload-new-paper", method=RequestMethod.POST)
	public ModelAndView uploadNewPaper(MultipartHttpServletRequest request
			, @RequestParam(value="paper-title") String title
			, @RequestParam(value="uploader-name") String uploaderName
			, @RequestParam(value="assign-for-authorization", required= false) boolean assignForAuthorization
			, @RequestParam(value="auth-username") String authorizerName){
		ModelAndView mav = new ModelAndView(ViewConstants.ADMIN_HOME_PAGE.getValue());
		try {
			log.info("uploading new paper for user "+uploaderName+"...");
			Iterator<String> itr = request.getFileNames();
			while (itr.hasNext()) {
				MultipartFile mpf = request.getFile(itr.next());
				log.info("recieved file name= "+mpf.getOriginalFilename()+" , file size= "+mpf.getSize()/1024 +" Kb.");
				statusmsg = paperService.addNewPaperToStore(title,mpf.getOriginalFilename(), mpf.getBytes(), uploaderName, assignForAuthorization, authorizerName);
				FileCopyUtils.copy(mpf.getBytes(), new FileOutputStream("/tmp/"+mpf.getOriginalFilename()));
				log.info("saved to disk at /tmp/"+ mpf.getOriginalFilename());
				mav.getModel().put("statusmsg", "Paper upload successfull. "+statusmsg);
				mav.getModel().put("status", "success");
			}
		} catch (Exception e) {
			mav.getModel().put("statusmsg", "Paper upload un-successfull, please try again. "+ e.getMessage());
			mav.getModel().put("status", "error");
			log.error("Error in uploading new paper.", e);
		}				
		return mav;	
	}
	
	@ResponseBody
	@RequestMapping(value="/authorizerslist/{uname}")
	public String getAuthorizersNamesListFor(@PathVariable("uname") String uploaderName){
		log.info("searching all the possible system user names who could be authorizer, when uploader is "+ uploaderName+" .");
		List<String> names = new ArrayList<String>();
		try {
			names = paperService.getAuthorizerListWhenCreatorIs(uploaderName);
		} catch (Exception e) {
			log.error("error in getting authorizers name list.", e);
		}		
		return JsonUtil.getJsonAsString(names);
	}
	
	@RequestMapping(value="/download-paper", method=RequestMethod.POST)
	public void downloadPaper( @RequestParam(value="paper-title",required=false) String papertitle
							 , @RequestParam(value="paper-number",required=false) String papernumber
							 , HttpServletResponse response){
		try {
			log.info("searching paper with number["+papernumber+"] / title["+papertitle+"] ..." );
			PaperStore paper = paperService.getPaper(papertitle, papertitle);
			response.setHeader("Content-Disposition","attachment;filename="+paper.getOriginalFilename());
			response.getOutputStream().write(paper.getPaperData());
			log.info("paper found, returning for download ...");
		} catch (DmsException | IOException e) {
			log.error("error in getting paper details for download.", e);
		}
	}
	

}
