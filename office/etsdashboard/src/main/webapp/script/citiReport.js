	var reportEvent = "reportEvent";
	var appCsi="";
	$(document).ready(
			function() {
				$("#Daily,#Monthly,#Weekly,#ApplicationName,.FREQUENCY,.submit_button").hide();
				var response = $.ajax({
					type : 'GET',
					async : false,
					dataType : 'json',
					data : {
						eventType : reportEvent
					},
					url : 'dashboardServlet',
					success : function(data) {
					}
				}).responseText;
				var ResponseJSON = $.parseJSON(response);
				for ( var i = 0; i < ResponseJSON.length; i++) {
					$('#select_id').append(
							'<option value='+ResponseJSON[i]+'>'
									+ ResponseJSON[i] + '</option>');
				}
				$('.selectpicker').selectpicker({});
				var windowSize=($(window).height()-200);
				$('#table_container').css({'height':windowSize});
				$(window).resize(function() {
					var windowSize=($(window).height()-200);
					$('#table_container').css({'height':windowSize});
				});
			});
	function getAppName() {
		if($("#select_id").val()=="csi_id"){
			$("#Daily,#Monthly,#Weekly,#ApplicationName,.FREQUENCY,.submit_button").hide();
		}else{
		$("#ApplicationName").show();
		appCsi = $("#select_id").val();
		var response = $.ajax({
			type : 'GET',
			async : false,
			dataType : 'json',
			data : {
				eventType : reportEvent,
				appCsi : appCsi
			},
			url : 'dashboardServlet',
			success : function(data) {
			}
		}).responseText;
		var ResponseJSON = $.parseJSON(response);
		$('#ApplicationName').empty();
		$('#ApplicationName').append(
				'<option value="Application Name">Application Name</option>');
		for ( var i = 0; i < ResponseJSON.length; i++) {
			console.log(ResponseJSON[i]);
			$('#ApplicationName').append(
					'<option value='+ResponseJSON[i]+'>' + ResponseJSON[i]
							+ '</option>');
		}
	}
	}
	function getSelectedValue() {
		$("#Daily,#Monthly,#Weekly").hide();
		var a = $("#Frequency").val();
		if(a!="Frequency"){
		$("#" + a).show();
		$("#month,#week,#from,#to").val("");
		$(".submit_button").show();
		}else{
		$("#" + a).show();
		$(".submit_button").hide();
		}
	}
	function calculate_Date() {
		if ($("#week").val() != "") {
			fetchTableData($("#week").val(),"WEEKLY");
		} else if ($("#month").val() != "") {
			fetchTableData($("#month").val(),"MONTHLY");
		} else if ($("#from").val() != "" && $("#to").val() != "") {
			if ($("#from").val() > $("#to").val()) {
			alert("please enter Valid Date");
			} else {
			fetchTableDataDaily($("#from").val(),$("#to").val());
			}
		} else {
			alert("please enter Valid Date");
		}

	}
	function fetchTableData(date,type){
		var dateRange=date;
		var frequency =type;
		//$("#month,#week,#from,#to").val("");
		var response = $.ajax({
			type : 'GET',
			async : false,
			dataType : 'json',
			data : {
				eventType : reportEvent,
				appCsi : appCsi,
				frequency : frequency,
				date : dateRange
			},
			url : 'dashboardServlet',
			success : function(data) {
			}
		}).responseText;
		createReportTable(response);
	}
	function fetchTableDataDaily(start_date,end_date){
		var from=start_date;
		var to=end_date;
		var event="DAILY";
		//$("#month,#week,#from,#to").val("");
		var response = $.ajax({
			type : 'GET',
			async : false,
			dataType : 'json',
			data : {
				eventType : reportEvent,
				appCsi : appCsi,
				frequency : event,
				startDate : from,
				endDate : to
			},
			url : 'dashboardServlet',
			success : function(data) {
			}
		}).responseText;
		createReportTable(response);
	}
	function show_frequency(){
		if($("#ApplicationName").val()=="Application_Name"){
			$("#Daily,#Monthly,#Weekly,.FREQUENCY,.submit_button").hide();
			$("#month,#week,#from,#to,#Frequency").val("");
		}else{
			$(".FREQUENCY").show();
		}
	}
	function createReportTable(jsonTableData){
		var ResponseJSON = $.parseJSON(jsonTableData);
		console.log(ResponseJSON);
		$('#reportTable,#reportHeader').empty();
		if(ResponseJSON.length>0){
		$('#reportHeader').append('<tr class="history_th"><td>Component</td><td>Timestamp</td><td>Status</td></tr>');
		for ( var i = 0; i < ResponseJSON.length; i++) {
			$('#reportTable').append('<tr><td>'+ResponseJSON[i].component+'</td><td>'+ResponseJSON[i].timestamp+'</td><td><div class="colorcode" style="background-color:'+ResponseJSON[i].status+';"</div></td></tr>');
			}
		}else{
			$('#reportTable').append('<tr class="history_th" style="font-weight:700;"><td>No Data Found</td></tr>');	
			}
	}
