$(document).ready(function() {
	
	$( "#gudang" ).combogrid({
		width:"800px",
		url: 'get_gudang_list.html',
		debug:true,
		okIcon: true,
		showOn: true,
		colModel: [{'columnName':'id','width':'10','label':'ID'}, {'columnName':'nama','width':'30','label':'NAMA'}],
		select: function( event, ui ) {
			$( "#gudang" ).val( ui.item.nama );
			$( "#gudangId" ).val( ui.item.id );
			return false;
		}
	});
	
	$("#updateGudang").click(function() {
		var check = $("#gudangId").val();
		if(check == ""){
			alert("Please, Input Gudang Name");
			//return false;
		}else{
			window.location.href = getUrl+"/master/gudang/gudang_edit.html?id="+check;
			//return true;
		}
	});
	
	$("#deleteGudang").click(function() {
		var check = $("#gudangId").val();
		if(check == ""){
			alert("Please, Input Gudang Name");
		}else{
			var wannna = confirm("Do you really want to delete this ?");
			 if (wannna== true){
				 window.location.href = getUrl+"/master/gudang/gudang_delete.html?id="+check;
			 }
			//return true;
		}
	});
	
});

function setIdNull(e){
	if( e.keyCode == 13 ){
		
	}else{
		$( "#gudangId" ).val('');
	}
}