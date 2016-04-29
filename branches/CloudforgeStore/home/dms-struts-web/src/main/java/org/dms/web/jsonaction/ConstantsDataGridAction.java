package org.dms.web.jsonaction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dms.web.bo.ConstantsService;
import org.dms.web.document.Constants;

import com.opensymphony.xwork2.ActionSupport;

import org.springframework.beans.factory.annotation.Autowired;

public class ConstantsDataGridAction extends ActionSupport {

	private static final long serialVersionUID = -4165314824096999147L;
	private static final Log log = LogFactory.getLog(ConstantsDataGridAction.class);
	
	@Autowired
	private ConstantsService constantsService;
	
	// Result List
    private List<Constants> gridConstantsList;

    // get how many rows we want to have into the grid - rowNum attribute in the
    // grid
    private Integer rows = 0;

    // Get the requested page. By default grid sets this to 1.
    private Integer page = 0;

    // sorting order - asc or desc
    private String sord;

    // get index row - i.e. user click to sort.
    private String sidx;

    // Search Field
    @SuppressWarnings("unused")
	private String searchField;

    // The Search String
    private String searchString;

    // Limit the result when using local data, value form attribute rowTotal
    private Integer totalrows;

    // he Search Operation
    // ['eq','ne','lt','le','gt','ge','bw','bn','in','ni','ew','en','cn','nc']
    private String searchOper;

    // Your Total Pages
    private Integer total = 0;

    // All Records
    private Integer records = 0;

    private boolean loadonce = false;
    
    public String execute() {
    	log.info("Started getting data for Constants Grid.");
    	this.clearErrorsAndMessages();
    	try {
    		
    		// get all constants records from db.
    		gridConstantsList = constantsService.findAllConstants();
			log.info("Built list with count of records = "+ gridConstantsList.size());
			
			// sort the list if required.
			if (sord != null && sord.equalsIgnoreCase("asc")) {
			    Collections.sort(gridConstantsList);
			}
			if (sord != null && sord.equalsIgnoreCase("desc")) {
			    Collections.sort(gridConstantsList);
			    Collections.reverse(gridConstantsList);
			}
    		
    		// get total number of records returned.    		
    		records = gridConstantsList.size();
    		
    		if (totalrows != null) {
    		    records = totalrows;
    		}
    		
    		// Calucalate until rows ware selected
    		int to = (rows * page);

    		// Calculate the first row to read
    		int from = to - rows;

    		// Set to = max rows
    		if (to > records)
    		    to = records;
    		
    		log.info("Load once = " + loadonce);
    		if (loadonce) {
    		    if (totalrows != null && totalrows > 0) {
    		    	setGridConstantsList(gridConstantsList.subList(0, totalrows));
    		    	log.info("Resizing list to view data from 'Zero' to '" +totalrows +"' .");
    		    } else {
    		    	// All Constants
    		    	setGridConstantsList(gridConstantsList);
    		    	log.info("Resizing list to view all data.");
    		    }
    		    log.info("List resized for view as " + gridConstantsList.size() + " row(s).");
    		    
    		} else {
    		    // Search Constants
    			log.info("Begin searching for constants - searchString = "+ searchString+", searchOper ="+searchOper);
    		    if (searchString != null && searchOper != null) {
    		    	String id = searchString;
        			if (searchOper.equalsIgnoreCase("eq")) {
        			    log.info("search id equals " + id);
        			    List<Constants> cList = new ArrayList<Constants>();
        			    Constants cons = findById(gridConstantsList, id);
        			    if (cons != null)
        			    	cList.add(cons);
        			    setGridConstantsList(cList);        			    
        			}    		    	
    		    } else {
    		    	// this is most important, it resizes list to display on grid
    		    	log.info("Resizing list to view data from - "+ from+" , to - "+ to+" .");
    				setGridConstantsList(gridConstantsList.subList(from, to));
    		    }
    		    log.info("Finished searching for constants");
    		}
    		
    		// Calculate total Pages(Important! as it finds of number of pages to display.)
    		total = (int) Math.ceil((double) records / (double) rows);
    		log.info("Total pages = "+ total);
    		
			
		} catch (Exception e) {
			this.addActionError("Problem getting Constants from db. MESSAGE: " + e.getMessage());
			log.error("Error in ConstantsDataGridAction.class -> execute() method: ", e);
		}
    	
    	log.info("Finished getting data for Constants Grid.");
    	return SUCCESS;
    	
    }

    public String getJSON() {
    	log.info("Processing getJSON() method.");
    	return execute();
    }
    
    /**
     * @return how many rows we want to have into the grid
     */
    public Integer getRows() {
    	return rows;
    }

    /**
     * how many rows we want to have into the grid
     */
    public void setRows(Integer rows) {
    	this.rows = rows;
    }

    /**
     * @return current page of the query
     */
    public Integer getPage() {
    	return page;
    }

    /**
     * @param page - current page of the query
     */
    public void setPage(Integer page) {
    	this.page = page;
    }

    /**
     * @return total pages for the query
     */
    public Integer getTotal() {
    	return total;
    }

    /**
     * @param total - total pages for the query
     */
    public void setTotal(Integer total) {
    	this.total = total;
    }

    /**
     * @return total number of records for the query. e.g. select count(*) from table
     */
    public Integer getRecords() {
    	return records;
    }

    /**
     * @param record - total number of records for the query. e.g. select count(*) from table
     */
    public void setRecords(Integer records) {

    	this.records = records;

    	if (this.records > 0 && this.rows > 0) {
    		this.total = (int) Math.ceil((double) this.records
    				/ (double) this.rows);
    	} else {
    		this.total = 0;
    	}
    }

    /**
     * @return an collection that contains the actual data
     */
    public List<Constants> getGridConstantsList() {
		return gridConstantsList;
	}

    /**
     * @param gridModel - an collection that contains the actual data
     */
    public void setGridConstantsList(List<Constants> gridConstantsList) {
		this.gridConstantsList = gridConstantsList;
	}

    /**
     * @return sorting order
     */
    public String getSord() {
    	return sord;
    }

    /**
     * @param sord - sorting order
     */
    public void setSord(String sord) {
    	this.sord = sord;
    }

    /**
     * @return get index row - i.e. user click to sort.
     */
    public String getSidx() {
    	return sidx;
    }

    /**
     * @param sidx - get index row - i.e. user click to sort.
     */
    public void setSidx(String sidx) {
    	this.sidx = sidx;
    }

    public void setSearchField(String searchField) {
    	this.searchField = searchField;
    }

    public void setSearchString(String searchString) {
    	this.searchString = searchString;
    }

    public void setSearchOper(String searchOper) {
    	this.searchOper = searchOper;
    }

    public void setLoadonce(boolean loadonce) {
    	this.loadonce = loadonce;
    }
    public void setTotalrows(Integer totalrows) {
    	this.totalrows = totalrows;
    }

	public Constants findById(List<Constants> list, String id){
		for (Constants c : list) {
			if (c.getId().equalsIgnoreCase(id)) {
				return c;
			}
		}
		return null;
	}

	

}
