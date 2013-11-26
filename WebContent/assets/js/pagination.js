function step(page){
	var url = document.getElementById('requesturl').value;
	url = url + "page=" + page;
	
	document.filterForm.action = url;
	document.filterForm.submit();
}

function getUrlVars() {
	var vars = {};
	var parts = window.location.href.replace(/[?&]+([^=&]+)=([^&]*)/gi, function(m,key,value) {
		vars[key] = value;
	});
	return vars;
}