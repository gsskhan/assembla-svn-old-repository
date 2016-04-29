var currentData="";
$(document).ready(function() {
	var dynamicAppName = "";
	var subSectorName = "";
	var columnName = "";
setInterval(refreshDiv, 30000);
$('#dynamicTable').append("<tr id='Header'><th id='ApplicationName'>Application Name<div>Application Name</div></th></tr>");
var dashboardEvent = "dashboardEvent";
var jsonData = $.ajax({
	type : 'GET',
	async : false,
	data:{
		eventType: dashboardEvent
	},
	dataType : 'json',
	url :'dashboardServlet',
	success : function(data) {
	  }
}).responseText;
currentData=jsonData;
var TableResponseJSON = $.parseJSON(jsonData);
$.each(TableResponseJSON[1],function(key,object){
	if(key=="columnDetails"){
		$.each(object,function(key,value){
			var columnValue=key;
			columnValue = columnValue.replace(/\b[a-z]/g, function(letter) {
			    return letter.toUpperCase();
			});
			columnValue=columnValue.replace(/([a-z])([A-Z])/g, '$1 $2');
			$("th:last").after("<th id='"+key.replace(/[_&|\s]+/g, "")+"'>" +columnValue+"<div>"+columnValue+"</div></th>");
		});
	}
});
var flagForSector=true;
var flagForSubSector=true;
var flagForDynAppName=true;
var flagForSubDynAppName=false;
var retainSectorName="";
var retainSubSectorName="";
var retainDynAppName="";
var retainSubDynAppName="";
var subSectorValue="";
$(TableResponseJSON).each(function(index,object){
	var tableRow="";
    $.each(object,function(key,value){
    	if (key == "sectorName"){
    		if (flagForSector){
    			var id=value.replace(/[_&|\s]+/g, "");
    			var valueToBeDisplayed = value.toLowerCase().replace(/\b[a-z]/g, function(letter) {
    			    return letter.toUpperCase();
    			});
    			tableRow+="<tr id='"+id+"_tr' class='SectorName'><td id="+id+"><div class='open' id='"+id+"_div'></div><a class='sector_font'>"+valueToBeDisplayed+"</a></td>";
    			retainSectorName=value;
    			flagForSector=false;
    		}else if(value!=retainSectorName){
    			var id=value.replace(/[_&|\s]+/g, "");
    			var valueToBeDisplayed = value.toLowerCase().replace(/\b[a-z]/g, function(letter) {
    			    return letter.toUpperCase();
    			});
        		tableRow+="<tr id='"+id+"_tr' class='SectorName'><td id="+id+"><div class='open' id='"+id+"_div'></div><a class='sector_font'>"+valueToBeDisplayed+"</a></td>";
        		retainSectorName=value;
    		}
    	}else if(key == "subSectorName" && value !=null){
    		if (flagForSubSector){
        		var id=value.replace(/[_&|\s]+/g, "");
        		subSectorValue=id;
        		if(value.length <= 4){
        			valueToBeDisplayed=value;
        		}else{
        		    valueToBeDisplayed = value.toLowerCase().replace(/\b[a-z]/g, function(letter) {
    			    return letter.toUpperCase();
    			});
        		}
        		tableRow+="<tr id='"+id+"_tr' class='SubSectorName'><td id="+id+"><div class='open' style='margin-left:13px;' id='"+id+"_div'></div><a class='subsector_name'>"+valueToBeDisplayed+"</a></td>";
        		retainSubSectorName=value;
        		flagForSubSector=false;
        		retainDynAppName="";
        		retainSubDynAppName="";
        	}else if(value!=retainSubSectorName){
        		var id=value.replace(/[_&|\s]+/g, "");
        		subSectorValue=id;
        		if(value.length <= 4){
        			valueToBeDisplayed=value;
        		}else{
        		    valueToBeDisplayed = value.toLowerCase().replace(/\b[a-z]/g, function(letter) {
    			    return letter.toUpperCase();
    			});
        		}
            	tableRow+="<tr id='"+id+"_tr' class='SubSectorName'><td id="+id+"><div class='open' style='margin-left:13px;' id='"+id+"_div'></div><a class='subsector_name'>"+valueToBeDisplayed+"</a></td>";
            	retainSubSectorName=value;
            	retainDynAppName="";
            	retainSubDynAppName="";
        	}
    	}else if(key == "dynamicAppName" && value !=null){
    		if (flagForDynAppName){
        		var id=value.replace(/[_&|\s]+/g, "");
        		var valueToBeDisplayed = value.toLowerCase().replace(/\b[a-z]/g, function(letter) {
    			    return letter.toUpperCase();
    			});
        		tableRow+="<tr id='"+subSectorValue+id+"_tr' class='DynamicAppName'><td id="+id+"><div class='open' style='margin-left:22px;' id='"+subSectorValue+id+"_div'></div><a class='appname'>"+valueToBeDisplayed+"</a></td>";
        		retainDynAppName=value;
        		retainSubDynAppName="";
        		flagForDynAppName=false;
        	}else if(value!=retainDynAppName){
        		var id=value.replace(/[_&|\s]+/g, "");
        		var valueToBeDisplayed = value.toLowerCase().replace(/\b[a-z]/g, function(letter) {
    			    return letter.toUpperCase();
    			});
            	tableRow+="<tr id='"+subSectorValue+id+"_tr' class='DynamicAppName'><td id="+id+"><div class='open' style='margin-left:22px;' id='"+subSectorValue+id+"_div'></div><a class='appname'>"+valueToBeDisplayed+"</a></td>";
            	retainDynAppName=value;
            	retainSubDynAppName="";
        	}
    	}
    	else if(key == "subDynamicAppName" && value !=null){
    		if (flagForSubDynAppName){
        		var id=value.replace(/[_&|\s]+/g, "");
        		var valueToBeDisplayed = value.toLowerCase().replace(/\b[a-z]/g, function(letter) {
    			    return letter.toUpperCase();
    			});
        		tableRow+="<tr id='"+subSectorValue+id+"_tr' class='SubDynamicAppName'><td id="+id+"><div class='child' id='"+id+"_div'></div><a class='subappname'>"+valueToBeDisplayed+"</a></td>";
        		retainSubDynAppName=value;
        		flagForSubDynAppName=false;
        	}else if(value!=retainSubDynAppName){
        		var id=value.replace(/[_&|\s]+/g, "");
        		var valueToBeDisplayed = value.toLowerCase().replace(/\b[a-z]/g, function(letter) {
    			    return letter.toUpperCase();
    			});
            	tableRow+="<tr id='"+subSectorValue+id+"_tr' class='SubDynamicAppName'><td id="+id+"><div class='child' id='"+id+"_div'></div><a class='subappname'>"+valueToBeDisplayed+"</a></td>";
            	retainSubDynAppName=value;
        	}
    	}
    	
    	else if(key == "columnDetails"){
	    		var columnDetailObject=value;
			$.each(columnDetailObject,function(key,Object){
				var valueTobeDisplayed=Object.value;
				var descriptionValue=Object.description;
				var colorCodeToBeDisplayed=Object.colorCode;
				if(valueTobeDisplayed != null){
					var id=key.replace(/[_&|\s]+/g, "");
					tableRow+="<td id="+id+"><div class='colored-div tableValue_div' style='background-color:"+colorCodeToBeDisplayed+";font-weight: bold;'><div class='popoverOption' style='padding-left:2px;font-weight:700;cursor: pointer;height:17px;' href='#' data-content=\""+descriptionValue+"<a class='tooltip_link' href='history.html' target='_blank' >More ></a>\"  rel='popover' data-placement='bottom' data-original-title=''>"+valueTobeDisplayed+"</div></div></td>"; 						
				}
				else{
					var id=key.replace(/[_&|\s]+/g, "");
    				tableRow+="<td id="+id+"><div class='colored-div' style='background-color:"+colorCodeToBeDisplayed+"'></div></td>";
				}
			});
    	}
  });
    $('#dynamicTable').append(tableRow);
});
$('.SectorName').each(function(){
    var sectorNameId=$(this).attr('id');
    $("#"+sectorNameId+">td>div:gt(1)").each(function(){
            $(this).css('background-color','');
    });
});
var windowSize=($(window).height()-200);
$('.table_container').css({'height':windowSize});
$(window).resize(function() {
	var windowSize=($(window).height()-200);
	$('.table_container').css({'height':windowSize});
});
hidden_Th();
$('.popoverOption').popover({
	offset: 10,
	trigger: 'manual',
	html: true,
	placement: 'right',
	template: '<div class="popover" onmouseover="$(this).mouseleave(function() {$(this).hide();});"><div class="arrow"></div><div class="popover-inner"><h3 class="popover-title"></h3><div class="popover-content"><p></p></div></div></div>'
	}).mouseenter(function(e) {
	$(this).popover('show');
	}).mouseleave(function(e) {
	var _this = this;
	setTimeout(function() {
	if (!$(".popover:hover").length) {
	  $(_this).popover("hide");
	 }
	}, 100);
	});
$(".tftable tr:not(.SectorName)").hide();
$(".tftable tr:first-child").show();
$(".tftable tr.SectorName>td>div.open").click(function() {
	$(this).toggleClass("close");
	var SectorVisiblity=$(this).parent().parent().nextUntil(".SectorName").is(':visible');
	if(SectorVisiblity==false)
	{
		var rowId=$(this).parent().parent().attr('id');
		var sectorName="";
		var sectorRowId=null;
		$(TableResponseJSON).each(function(index,object){
		    $.each(object,function(key,value){
		    	if (key == "sectorName"){
		    		sectorName = value;
		    		sectorRowId=null;
		    	}else if(key == "subSectorName" && value == null){
		    		sectorRowId = sectorName.replace(/[_&|\s]+/g, "")+"_tr";
		    	}else if(key == "columnDetails" && sectorRowId!=null){
		    		if(sectorRowId == rowId ){
		    			var columnDetailObject=value;
		    			var count=1;
		    			$.each(columnDetailObject,function(key,Object){
							$.each(Object,function(Key,Value){
								if(Key == "colorCode"){
									$("#"+rowId+">td").find('div').eq(count).css({'background-color':Value});
									count++;
								}
							});
		    			});
		    		}
		    	}
		    });
		});
		$(this).parent().parent().nextUntil(".SectorName").not(".DynamicAppName,.SubDynamicAppName").show();
		var width=$('#dynamicTable').width();
		if(width<500){
			show_TH();
			}else{
			hidden_Th();
			}
	}
	else{
		$(this).parent().parent().find('div:gt(1)').each(function(){
			$(this).css('background-color','');
		});
		$(this).parent().parent().nextUntil(".SectorName").hide();
		$(this).parent().parent().nextUntil(".SectorName").find(".close").removeClass().addClass("open");
		var width=$('#dynamicTable').width();
		if(width<500){
			show_TH();
			}else{
			hidden_Th();
			}
	}
});

$(".tftable tr.SubSectorName>td>div.open").click(function() {
	var SubSectorVisiblity=$(this).parent().parent().nextUntil(".SubSectorName,.SectorName").is(':visible');
	$(this).toggleClass("close");
	if(SubSectorVisiblity==false){
	$(this).parent().parent().nextUntil(".SubSectorName,.SectorName").not(".SubDynamicAppName").show();
	}else{
	$(this).parent().parent().nextUntil(".SubSectorName,.SectorName").hide();
	$(this).parent().parent().nextUntil(".SubSectorName,.SectorName").find(".close").removeClass().addClass("open");
	}
});

$(".tftable tr.DynamicAppName>td>div.open").click(function() {
    $(this).parent().parent().nextUntil(".DynamicAppName,.SubSectorName,.SectorName").slideToggle();
    $(this).toggleClass("close");
});


$('.tableValue_div').mouseover(function(){
    dynamicAppName = $(this).parent().parent().find('td').eq(0).text().toUpperCase();
    var dynamicAppNameID = $(this).parent().parent().find('td').eq(0).attr('id');
    var subSectorDynamicApp_tr =$(this).parent().parent().attr('id');
    subSectorName=$("#"+subSectorDynamicApp_tr.replace(dynamicAppNameID+"","")).text().toUpperCase();
    var columnNameID = $(this).parent().attr('id');
    columnNameData=$("#"+columnNameID).text().toUpperCase();
    var lengthOfData=columnNameData.length/2;
    columnName=columnNameData.substring(0, lengthOfData);
    document.cookie = "dynamicAppName=; expires=Thu, 01 Jan 1970 00:00:00 GMT";
    document.cookie = "subSectorName=; expires=Thu, 01 Jan 1970 00:00:00 GMT";
    document.cookie = "columnName=; expires=Thu, 01 Jan 1970 00:00:00 GMT";
	var cookievalue=dynamicAppName;
	var cookievalueSS=subSectorName;
	var cookievalueS=columnName;
	document.cookie="dynamicAppName=" + cookievalue;
	document.cookie="subSectorName=" + cookievalueSS;
	document.cookie="columnName=" + cookievalueS;
});

$('td#overall>.colored-div').each(function(index){
	if("rgba(0, 0, 0, 0)"==$(this).css('background-color')){
		if($('td#overall>.colored-div').parent().parent().parent().find('tr').eq(index+1).attr('class')=="DynamicAppName"){
		
		var sector_name=$('td#overall>.colored-div').parent().parent().parent().find('tr').eq(index+1).attr('id');
		if($("#"+sector_name).text()!="Feeds"){
			$("#"+sector_name).find('div').eq(0).removeClass("open");
            $("#"+sector_name).find('td').eq(0).find('a').css({'padding-left':'28px'});
            }
    }
	}
	else if("rgb(51, 204, 0)"==$(this).css('background-color')){
		$('td#overall>.colored-div').parent().parent().parent().find('tr').eq(index+1).find('td').eq(0).find('div').removeClass('open');
		$('td#overall>.colored-div').parent().parent().parent().find('tr').eq(index+1).find('td').eq(0).find('a').css({'padding-left':'30px'});
	}
});
});


function refreshDiv(){
	var values = []; 
	var id_value=[];
	var class_value=[];
	var sectorRowID = [];
	$('tr:hidden').each(function(){
	    values.push($(this).attr('id'));
	});
	$('tr:visible').each(function(){
	    id_value.push($(this).find('div').attr('id'));
	    class_value.push($(this).find('div').attr('class'));
	});
	
	$('.SectorName').find('td>div').each(function(){
		if($(this).attr('class')=="open close"){
			sectorRowID.push($(this).parent().parent().attr('id'));
		}
	});
	var dashboardEvent = "dashboardEvent";
	var jsonData = $.ajax({
		type : 'GET',
		async : false,
		data:{
			eventType: dashboardEvent
		},
		dataType : 'json',
		url :'dashboardServlet',
		success : function(data) {
			
		}
	}).responseText;
	if(currentData == "" || currentData != jsonData){
	currentData=jsonData;
	$('#dynamicTable').empty();
	$('#dynamicTable').append("<tr id='Header'><th id='ApplicationName'>Application Name<div>Application Name</div></th></tr>");
	var TableResponseJSON = $.parseJSON(jsonData);
	$.each(TableResponseJSON[1],function(key,object){
		if(key=="columnDetails"){
			$.each(object,function(key,value){
				var columnValue=key;
				columnValue = columnValue.replace(/\b[a-z]/g, function(letter) {
				    return letter.toUpperCase();
				});
				columnValue=columnValue.replace(/([a-z])([A-Z])/g, '$1 $2');
				$("th:last").after("<th id='"+key.replace(/[_&|\s]+/g, "")+"'>" +columnValue+"<div>"+columnValue+"</div></th>");
			});
		}
    });
	var flagForSector=true;
	var flagForSubSector=true;
	var flagForDynAppName=true;
	var flagForSubDynAppName=true;
	var retainSectorName="";
	var retainSubSectorName="";
	var retainDynAppName="";
	var retainSubDynAppName="";
	$(TableResponseJSON).each(function(index,object){
		var tableRow="";
	    $.each(object,function(key,value){
	    	if (key == "sectorName"){
	    		if (flagForSector){
	    			var id=value.replace(/[_&|\s]+/g, "");
	    			var valueToBeDisplayed = value.toLowerCase().replace(/\b[a-z]/g, function(letter) {
	    			    return letter.toUpperCase();
	    			});
	    			tableRow+="<tr id='"+id+"_tr' class='SectorName'><td id="+id+"><div class='open' id='"+id+"_div'></div><a class='sector_font'>"+valueToBeDisplayed+"</a></td>";
	    			retainSectorName=value;
	    			flagForSector=false;
	    		}else if(value!=retainSectorName){
	    			var id=value.replace(/[_&|\s]+/g, "");
	    			var valueToBeDisplayed = value.toLowerCase().replace(/\b[a-z]/g, function(letter) {
	    			    return letter.toUpperCase();
	    			});
	        		tableRow+="<tr id='"+id+"_tr' class='SectorName'><td id="+id+"><div class='open' id='"+id+"_div'></div><a class='sector_font'>"+valueToBeDisplayed+"</a></td>";
	        		retainSectorName=value;
	    		}
	    	}else if(key == "subSectorName" && value !=null){
	    		if (flagForSubSector){
	        		var id=value.replace(/[_&|\s]+/g, "");
	        		subSectorValue=id;
	        		if(value.length <= 4){
	        			valueToBeDisplayed=value;
	        		}else{
	        		    valueToBeDisplayed = value.toLowerCase().replace(/\b[a-z]/g, function(letter) {
	    			    return letter.toUpperCase();
	    			});
	        		}
	        		tableRow+="<tr id='"+id+"_tr' class='SubSectorName'><td id="+id+"><div class='open' style='margin-left:13px;' id='"+id+"_div'></div><a class='subsector_name'>"+valueToBeDisplayed+"</a></td>";
	        		retainSubSectorName=value;
	        		flagForSubSector=false;
	        		retainDynAppName="";
	        		retainSubDynAppName="";
	        	}else if(value!=retainSubSectorName){
	        		var id=value.replace(/[_&|\s]+/g, "");
	        		subSectorValue=id;
	        		if(value.length <= 4){
	        			valueToBeDisplayed=value;
	        		}else{
	        		    valueToBeDisplayed = value.toLowerCase().replace(/\b[a-z]/g, function(letter) {
	    			    return letter.toUpperCase();
	    			});
	        		}
	            	tableRow+="<tr id='"+id+"_tr' class='SubSectorName'><td id="+id+"><div class='open' style='margin-left:13px;' id='"+id+"_div'></div><a class='subsector_name'>"+valueToBeDisplayed+"</a></td>";
	            	retainSubSectorName=value;
	            	retainDynAppName="";
	            	retainSubDynAppName="";
	        	}
	    	}else if(key == "dynamicAppName" && value !=null){
	    		if (flagForDynAppName){
	        		var id=value.replace(/[_&|\s]+/g, "");
	        		var valueToBeDisplayed = value.toLowerCase().replace(/\b[a-z]/g, function(letter) {
	    			    return letter.toUpperCase();
	    			});
	        		tableRow+="<tr id='"+subSectorValue+id+"_tr' class='DynamicAppName'><td id="+id+"><div class='open' style='margin-left:22px;' id='"+subSectorValue+id+"_div'></div></div><a class='appname'>"+valueToBeDisplayed+"</a></td>";
	        		retainDynAppName=value;
	        		retainSubDynAppName="";
	        		flagForDynAppName=false;
	        	}else if(value!=retainDynAppName){
	        		var id=value.replace(/[_&|\s]+/g, "");
	        		var valueToBeDisplayed = value.toLowerCase().replace(/\b[a-z]/g, function(letter) {
	    			    return letter.toUpperCase();
	    			});
	            	tableRow+="<tr id='"+subSectorValue+id+"_tr' class='DynamicAppName'><td id="+id+"><div class='open' style='margin-left:22px;' id='"+subSectorValue+id+"_div'></div><a class='appname'>"+valueToBeDisplayed+"</a></td>";
	            	retainDynAppName=value;
	            	retainSubDynAppName="";
	        	}
	    	}
	    	else if(key == "subDynamicAppName" && value !=null){
	    		if (flagForSubDynAppName){
	        		var id=value.replace(/[_&|\s]+/g, "");
	        		var valueToBeDisplayed = value.toLowerCase().replace(/\b[a-z]/g, function(letter) {
	    			    return letter.toUpperCase();
	    			});
	        		tableRow+="<tr id='"+subSectorValue+id+"_tr' class='SubDynamicAppName'><td id="+id+"><div class='child' id='"+id+"_div'></div><a class='subappname'>"+valueToBeDisplayed+"</a></td>";
	        		retainSubDynAppName=value;
	        		flagForSubDynAppName=false;
	        	}else if(value!=retainSubDynAppName){
	        		var id=value.replace(/[_&|\s]+/g, "");
	        		var valueToBeDisplayed = value.toLowerCase().replace(/\b[a-z]/g, function(letter) {
	    			    return letter.toUpperCase();
	    			});
	            	tableRow+="<tr id='"+subSectorValue+id+"_tr' class='SubDynamicAppName'><td id="+id+"><div class='child' id='"+id+"_div'></div><a class='subappname'>"+valueToBeDisplayed+"</a></td>";
	            	retainSubDynAppName=value;
	        	}
	    	}
	    	
	    	else if(key == "columnDetails"){
		    		var columnDetailObject=value;
				$.each(columnDetailObject,function(key,Object){
					var valueTobeDisplayed=Object.value;
					var descriptionValue=Object.description;
					var colorCodeToBeDisplayed=Object.colorCode;
					if(valueTobeDisplayed != null){
						var id=key.replace(/[_&|\s]+/g, "");
						tableRow+="<td id="+id+"><div class='colored-div tableValue_div' style='background-color:"+colorCodeToBeDisplayed+";font-weight: bold;'><div class='popoverOption' style='padding-left:2px;font-weight:700;cursor: pointer;height:17px;' href='#' data-content=\""+descriptionValue+"<a class='tooltip_link' href='history.html' target='_blank' >More ></a>\"  rel='popover' data-placement='bottom' data-original-title=''>"+valueTobeDisplayed+"</div></div></td>"; 						
					}
					else{
						var id=key.replace(/[_&|\s]+/g, "");
	    				tableRow+="<td id="+id+"><div class='colored-div' style='background-color:"+colorCodeToBeDisplayed+"'></div></td>";
					}
				});
	    	}
	  });
	    $('#dynamicTable').append(tableRow);
});
	$('.SectorName').each(function(index){
	    var sectorNameId=$(this).attr('id');
	    $(sectorRowID).each(function(){
	    	var flagForRowVisible= false;
	    	for (var iCount=0;iCount<=sectorRowID.length;iCount++){
	    		if(sectorNameId==sectorRowID[iCount]){
	    			flagForRowVisible=true;
	    			break;
		    	}
	    	}
	    	if(flagForRowVisible){

	    	}else{
	    		$("#"+sectorNameId+">td>div:gt(1)").each(function(){
		            $(this).css('background-color','');
	    		});		
	    	}
	    });
	    
	});
	$('.popoverOption').popover({
    	offset: 10,
    	trigger: 'manual',
    	html: true,
    	placement: 'right',
    	template: '<div class="popover" onmouseover="$(this).mouseleave(function() {$(this).hide();});"><div class="arrow"></div><div class="popover-inner"><h3 class="popover-title"></h3><div class="popover-content"><p></p></div></div></div>'
    	}).mouseenter(function(e) {
    	$(this).popover('show');
    	}).mouseleave(function(e) {
    	var _this = this;
    	setTimeout(function() {
    	if (!$(".popover:hover").length) {
    	  $(_this).popover("hide");
    	 }
    	}, 100);
    	});
	$('.tableValue_div').mouseover(function(){
	    dynamicAppName = $(this).parent().parent().find('td').eq(0).text().toUpperCase();
	    var dynamicAppNameID = $(this).parent().parent().find('td').eq(0).attr('id');
	    var subSectorDynamicApp_tr =$(this).parent().parent().attr('id');
	    subSectorName=$("#"+subSectorDynamicApp_tr.replace(dynamicAppNameID+"","")).text().toUpperCase();
	    var columnNameID = $(this).parent().attr('id');
	    columnNameData=$("#"+columnNameID).text().toUpperCase();
	    var lengthOfData=columnNameData.length/2;
	    columnName=columnNameData.substring(0, lengthOfData);
	    document.cookie = "dynamicAppName=; expires=Thu, 01 Jan 1970 00:00:00 GMT";
	    document.cookie = "subSectorName=; expires=Thu, 01 Jan 1970 00:00:00 GMT";
	    document.cookie = "columnName=; expires=Thu, 01 Jan 1970 00:00:00 GMT";
		var cookievalue=dynamicAppName;
		var cookievalueSS=subSectorName;
		var cookievalueS=columnName;
		document.cookie="dynamicAppName=" + cookievalue;
		document.cookie="subSectorName=" + cookievalueSS;
		document.cookie="columnName=" + cookievalueS;
	});

	
	for(var i=0;i<values.length;i++){
		var id="[id^="+values[i]+"]";
	$(id).hide();	
	}
	if($('section').width() < 500){
		hidden_Th();
	}
	$("div").removeClass(".close");
	$(".tftable tr:first-child").show();
	$(".tftable tr.SectorName>td>div.open").click(function() {
		$(this).toggleClass("close");
		var SectorVisiblity=$(this).parent().parent().nextUntil(".SectorName").is(':visible');
		if(SectorVisiblity==false)
		{
			var rowId=$(this).parent().parent().attr('id');
			var sectorName="";
			var sectorRowId=null;
			$(TableResponseJSON).each(function(index,object){
			    $.each(object,function(key,value){
			    	if (key == "sectorName"){
			    		sectorName = value;
			    		sectorRowId=null;
			    	}else if(key == "subSectorName" && value == null){
			    		sectorRowId = sectorName.replace(/[_&|\s]+/g, "")+"_tr";
			    	}else if(key == "columnDetails" && sectorRowId!=null){
			    		if(sectorRowId == rowId ){
			    			var columnDetailObject=value;
			    			var count=1;
			    			$.each(columnDetailObject,function(key,Object){
								$.each(Object,function(Key,Value){
									if(Key == "colorCode"){
										$("#"+rowId+">td").find('div').eq(count).css({'background-color':Value});
										count++;
									}
								});
			    			});
			    		}
			    	}
			    });
			});
			$(this).parent().parent().nextUntil(".SectorName").not(".DynamicAppName").show();
			var width=$('#dynamicTable').width();
			if(width<500){
				show_TH();
				}else{
				hidden_Th();
				}
		}
		else{
			$(this).parent().parent().find('div:gt(1)').each(function(){
				$(this).css('background-color','');
			});
			$(this).parent().parent().nextUntil(".SectorName").hide();
			$(this).parent().parent().nextUntil(".SectorName").find(".close").removeClass().addClass("open");
			var width=$('#dynamicTable').width();
			if(width<500){
				show_TH();
				}else{
				hidden_Th();
				}
		}
	});
	$(".tftable tr.SubSectorName>td>div.open").click(function() {
		var SubSectorVisiblity=$(this).parent().parent().nextUntil(".SubSectorName,.SectorName").is(':visible');
		$(this).toggleClass("close");
		if(SubSectorVisiblity==false){
		$(this).parent().parent().nextUntil(".SubSectorName,.SectorName").not(".SubDynamicAppName").show();
		}else{
		$(this).parent().parent().nextUntil(".SubSectorName,.SectorName").hide();
		$(this).parent().parent().nextUntil(".SubSectorName,.SectorName").find(".close").removeClass().addClass("open");
		}
	});
	$(".tftable tr.DynamicAppName>td>div.open").click(function() {
	    $(this).parent().parent().nextUntil(".DynamicAppName,.SubSectorName,.SectorName").slideToggle();
	    $(this).toggleClass("close");
	});
	for(var i=1;i<id_value.length;i++){
	var idName="#"+id_value[i];	
	var className=class_value[i];
	if(className!="child"){
	$(idName).removeClass("open").removeClass("close").addClass(className);
	}
	}
	//Removing "open" image when overall status is Green
	$('td#overall>.colored-div').each(function(index){
		if("rgba(0, 0, 0, 0)"==$(this).css('background-color')){
			if($('td#overall>.colored-div').parent().parent().parent().find('tr').eq(index+1).attr('class')=="DynamicAppName"){
			
			var sector_name=$('td#overall>.colored-div').parent().parent().parent().find('tr').eq(index+1).attr('id');
			if($("#"+sector_name).text()!="Feeds"){
				$("#"+sector_name).find('div').eq(0).removeClass("open");
	            $("#"+sector_name).find('td').eq(0).find('a').css({'padding-left':'28px'});
	            }
			}
		}
		else if("rgb(51, 204, 0)"==$(this).css('background-color') || null == $(this).css('background-color')){
			$('td#overall>.colored-div').parent().parent().parent().find('tr').eq(index+1).find('td').eq(0).find('div').removeClass('open close');
			$('td#overall>.colored-div').parent().parent().parent().find('tr').eq(index+1).find('td').eq(0).find('a').css({'padding-left':'15px'});
		}
		else if($('td#overall>.colored-div').parent().parent().parent().find('tr').eq(index+1).find('td').eq(0).find('div').attr('class')=="child"){
		}
		else{
			$('td#overall>.colored-div').parent().parent().parent().find('tr').eq(index+1).find('td').eq(0).find('div').addClass('open');
		}
	});
	}
}

function hidden_Th(){
	if($('#dynamicTable .close').val()=="")
	{}else{
	var thvalue=[];
	$('th').each(function(){
	    thvalue.push($(this).attr('id'));
	});
	for(var i=2;i<thvalue.length;i++){
		var id="[id^="+thvalue[i]+"]";
		$(id).hide();
		$('section').css('width','290px');
		$('.colored-div').css('width','75px');
		$('.colored-div').css('padding-left','8px');
	}
	}
	}
function show_TH(){
	var thvalue=[];
	$('th').each(function(){
	thvalue.push($(this).attr('id'));
	});
	for(var i=2;i<thvalue.length;i++){
		var id="[id^="+thvalue[i]+"]";
		$(id).fadeIn();
		$('section').css('width','auto');
		$('.colored-div').css('width','auto');
		$('.colored-div').css('padding-left','');
	}
}
