/* Ajax Call to get the internal apps status data to display */

$(document).ready(function() {
	var elementId  ='#appstatusdiv';
	$(elementId).empty();
	$.getJSON('internalapplist', function(jsonData) {
		for (var i = 0; i < jsonData.length; i++) {
			var jd = jsonData[i];
			var appname = jd.appName;
			var appid = jd.appId;
			var appstatus = new String();
			if (jd.appStatus == 1) {
				appstatus = '#d9534f'; // RED
			} else if (jd.appStatus == 2) {
				appstatus = '#f0ad4e'; // AMBER
			} else if (jd.appStatus == 3) {
				appstatus = '#5cb85c'; // GREEN
			}
			$(elementId).append('<div id="appBlock'+appid+'" class="appBlock">'
								+	'<div class="appstatus" style="background-color:'+ appstatus +';" onclick="displayAppDetails('+appid+',\''+appname+'\');"></div>'
								+	'<div class="appname">'+appname+'</div>'
								+	'<div style="float: right;">'
								+		'<img id="dataInter" src="resources/img/feed.png" title="Data Interface">'
								+		'<img id="infra" src="resources/img/infra.png" title="Infrastructure">'
								+	'</div>'
								+'</div>');			
		}		
	});	
});

/* Make the Activity Board scrollable*/
$(document).ready(function() {	 
    var div = $('.activity-board');
    var start = $(div).offset().top; 
    $.event.add(window, "scroll", function() {
        var p = $(window).scrollTop();
        $(div).css('position',((p)>start) ? 'fixed' : 'static');
        $(div).css('top',((p)>start) ? '0px' : '');
        $(div).css('margin-left',((p)>start) ? '310px' : '');
    }); 
});

/* Make the Activity Board slide Toggable*/
$(document).ready(function() {	
	$('.activity-board .panel-heading').click(function() {
		$('.activity-board .panel-body').slideToggle("fast");
	});
});

/* Make the Activity Board slide dissappear when clicked on 'X'*/
$(document).ready(function() {	
	$('.activity-board .panel-heading .close').click(function() {
		$('.activity-board').hide();
	});
});

/* Overall status of applications pie chart and marquee data*/
$(document).ready(function(){
	var criticalTotal = new Number();
	var warningTotal =  new Number();
	var normalTotal =  new Number();
	$.getJSON('internalapplist', function(jsonData) { 
		for (var i = 0; i < jsonData.length; i++) {
			var jd = jsonData[i];
			if (jd.appStatus == 1) {
				criticalTotal = criticalTotal + 1;
			} else if (jd.appStatus == 2) {
				warningTotal = warningTotal + 1;
			} else if (jd.appStatus == 3) {
				normalTotal = normalTotal + 1;
			}			
		}
		// Add marquee data
		$('#marqee-home').append('<span class="label label-success">Status - Normal, Application(s) - '+normalTotal +'</span><br><br>	'
								+'<span class="label label-warning">Status - Warning, Application(s) -'+warningTotal+'</span><br><br>'
								+'<span class="label label-danger"> Status - Critical, Application(s) - '+criticalTotal+'</span><br><br>');
		// Starting with the pie chart now
		var data = [
		    	    ['Critical', criticalTotal],['Warning', warningTotal], ['Normal', normalTotal]
		];
		var plot1 = jQuery.jqplot ('status-chart', [data], 
		    {  	seriesColors: [ "#d9534f", "#f0ad4e", "#5cb85c"],
		    	title: 'Overall Applications Status',
		    	seriesDefaults: {
		    		// Make this a pie chart.
		    		renderer: jQuery.jqplot.PieRenderer, 
		    		rendererOptions: {
		    			// Put data labels on the pie slices.
		    			// By default, labels show the percentage of the slice.
		    			showDataLabels: true
		    		}
		    	}, 
		    	legend: { show:true, location: 'e' }
		    });
	});	  
});

/* Display status for an application (Plot chart and add marquee) */
function displayAppDetails(appId , appName) {
	// show the activity-board if closed and slide down the panel body.
	$('.activity-board').show();
	$('.activity-board .panel-body').slideDown("fast");
	
	// Empty the marquee body and add the contents to display.
	$('#marqee-home').empty();
	$('#marqee-home').append('Work in progress... Displaying details for app id = ' + appId);
	
	// Empty the status-chart body and add the contents to display.
	$('#status-chart').empty();
	$(document).ready(function(){
        var s1 = [3, 1];
        var s2 = [17, 1];
        var s3 = [78, 5];
        var ticks = ['Data Interface', 'Infrastructure'];         
        plot2 = $.jqplot('status-chart', [s1, s2, s3], {
        	seriesColors: [ "#d9534f", "#f0ad4e", "#5cb85c"],
	    	title: 'Application : '+appName ,
            seriesDefaults: {            	
                renderer:$.jqplot.BarRenderer,
                pointLabels: { show: true }
            },
            axes: {
                xaxis: {
                    renderer: $.jqplot.CategoryAxisRenderer,
                    ticks: ticks
                }
            }
        });
    });	
}	
