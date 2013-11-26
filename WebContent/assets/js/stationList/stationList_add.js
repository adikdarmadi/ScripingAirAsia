// JavaScript Document
// Davin Ardian

$(document).ready(function(){
		

	
	var form = $("#stationList_new");
	
	form.submit(function(){
		document.stationList_new.action = getUrl+"/master/stationList/stationList_add_save.html";
				
			return true;
	});

});
