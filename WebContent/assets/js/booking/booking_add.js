// JavaScript Document
// Davin Ardian

$(document).ready(function(){
	if($("#adult").val()==""){
		$("#adult").val(1);
	}
	if($("#kids").val()==""){
		$("#kids").val(0);
	}
	if($("#infants").val()==""){
		$("#infants").val(0);
	}
	$( "#asal" ).combogrid({
		width:"800px",
		url: 'get_stationList_list.html',
		debug:true,
		okIcon: true,
		showOn: true,
		colModel: [{'columnName':'shortName','width':'10','label':'Name'}, {'columnName':'countryCode','width':'30','label':'Stion Categori'}],
		select: function( event, ui ) {
			$( "#asal" ).val( ui.item.name );
			$( "#hiddenAsal" ).val( ui.item.code );
			$("#asalInfo").text("");
			return false;
		}
	});
	
	$( "#tujuan" ).combogrid({
		width:"800px",
		url: 'get_stationList_list.html',
		debug:true,
		okIcon: true,
		showOn: true,
		colModel: [{'columnName':'shortName','width':'10','label':'Name'}, {'columnName':'countryCode','width':'30','label':'Station Categori'}],
		select: function( event, ui ) {
			$( "#tujuan" ).val( ui.item.name );
			$( "#hiddenTujuan" ).val( ui.item.code );
			$("#tujuanInfo").text("");
			return false;
		}
	});
	
	var form = $("#booking_new");
	
	form.submit(function(){
		if(validateOrigin() & validateDistination() & validateDepart() & validateAdult() & validateKids() & validateInfants()){
			document.booking_new.action = getUrl+"/master/booking/booking_search.html";
			return true;
		}else{
			return false;
		}
		
				
			
	});
	
	

});

function validateOrigin(){
	var hiddenAsal=$("#hiddenAsal").val().length;
	
	if(hiddenAsal < 1){
		$("#asalInfo").text("This Field Required");
		$("#asalInfo").addClass("error");
		return false;
	}
	//if it's valid
	else{
		$("#asalInfo").addClass("error");
		$("#asalInfo").text("");
		return true;
	}
}

function validateDistination(){
	var hiddenTujuan=$("#hiddenTujuan").val().length;
	
	if(hiddenTujuan < 1){
		$("#tujuanInfo").text("This Field Required");
		$("#tujuanInfo").addClass("error");
		return false;
	}
	//if it's valid
	else{
		$("#tujuanInfo").addClass("error");
		$("#tujuanInfo").text("");
		return true;
	}
}

function validateDepart(){
	var depart=$("#depart").val().length;
	
	if(depart < 1){
		$("#departInfo").text("This Field Required");
		$("#departInfo").addClass("error");
		return false;
	}
	//if it's valid
	else{
		$("#departInfo").addClass("error");
		$("#departInfo").text("");
		return true;
	}
}

function validateAdult(){
	var adult=$("#adult").val().length;
	
	if(adult < 1){
		$("#adultInfo").text("This Field Required");
		$("#adultInfo").addClass("error");
		return false;
	}
	//if it's valid
	else{
		$("#adultInfo").addClass("error");
		$("#adultInfo").text("");
		return true;
	}
}

function validateKids(){
	var kids=$("#kids").val().length;
	
	if(kids < 1){
		$("#kidsInfo").text("This Field Required");
		$("#kidsInfo").addClass("error");
		return false;
	}
	//if it's valid
	else{
		$("#kidsInfo").addClass("error");
		$("#kidsInfo").text("");
		return true;
	}
}

function validateInfants(){
	var infants=$("#infants").val().length;
	
	if(infants < 1){
		$("#infantsInfo").text("This Field Required");
		$("#infantsInfo").addClass("error");
		return false;
	}
	//if it's valid
	else{
		$("#infantsInfo").addClass("error");
		$("#infantsInfo").text("");
		return true;
	}
}
