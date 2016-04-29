var subSectorName = "";
var dynamicAppName = "";
var columnName = "";
$(document).ready(function() {
				var allcookies = document.cookie;
				cookiearray = allcookies.split(';');
				for ( var i = 0; i < cookiearray.length; i++) {
					name = cookiearray[i].split('=')[0];
					value = cookiearray[i].split('=')[1];
					if (name == " columnName") {
						columnName = value;
					} else if (name == "dynamicAppName") {
						dynamicAppName = value;
					} else if (name == " subSectorName") {
						subSectorName = value;
					}
				}
				console.log(subSectorName);
				console.log(dynamicAppName);
				console.log(columnName);
				var historyEvent = "historyEvent";
				$.ajax({
					type : 'GET',
					async : false,
					data : {
						eventType : historyEvent,
						applicationName : subSectorName,
						kpiCategory : dynamicAppName,
						kpiCategoryName : columnName
					},
					dataType : 'json',
					url : 'dashboardServlet',
					success : function(response) {						
						$('#dynamicHistoryTable').append(
								"<tr class='historyHeader'></tr>");
						$('#myModalLabel').text(response.historyTableHeader);
						$.each(response.historyContactDetails, function(key, value) {
							console.log(key + " " + value);
							if (key == "Application Name") {
								$("#applicationName").text("Appliation Name : " + value);
							} else if (key == "CSI ID" || key == "Acronym" || key == "Sector") {
								$("#appdetail tr:first").append("<td id='"+ key.replace(/[_&|\s]+/g, "")+ "'>" + key +" : "+ value + "</td>");
							} else if (key == "App Mgr" || key == "Supp Mgr") {
								$("#firstrow").append("<td id='"+ key.replace(/[_&|\s]+/g, "")+ "'>" + key +" : "+ value + "</td>");
							} else if (key == "Level 3 Org" || key == "Level 5 Org") {
								$("#secondrow").append("<td id='"+ key.replace(/[_&|\s]+/g, "")+ "'>" + key +" : "+ value + "</td>");
							}
						});
						$.each(response.historyTableDetails[0], function(key,
								value) {
							$("#dynamicHistoryTable tr:first").append(
									"<td class='history_th' id='"
											+ key.replace(/[_&|\s]+/g, "")
											+ "'>" + key + "</td>");
						});
						$.each(response.historyTableDetails, function(index,
								object) {
							var historyTableRow = "<tr>";
							$.each(object, function(key, value) {
								historyTableRow += "<td class='history_td'>"
										+ value + "</td>";
							});
							historyTableRow += "</tr>";
							$("#dynamicHistoryTable").append(historyTableRow);
						});
					}
});
});