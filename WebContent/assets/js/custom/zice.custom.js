var getUrl = "";

// options cookie 10 days
var options = {
	path : '/',
	expires : 10
};


$(document).ready(function() {

					getUrl = $('.getUrl').attr('id');
					// filter panel
					$("#thecontent").hide();

					$("#showContent")
							.click(
									function() {
										if ($("#thecontent").is(":visible")) {
											$("#thecontent").hide(0);
											$("#buttonShowContent").remove();
											$(
													"<a href=# id=buttonShowContent ><img src="+getUrl+"/assets/images/icon/color_18/directional_down.png /></a>")
													.appendTo("#showContent");
										} else {
											$("#thecontent").show(500);
											$("#buttonShowContent").remove();
											$(
													"<a href=# id=buttonShowContent ><img src="+getUrl+"/assets/images/icon/color_18/directional_up.png /></a>")
													.appendTo("#showContent");
										}

									});
					
					
					$('.Delete').click(function(){
							if( confirm("Be careful if you want to delete! This data is might being used, continue?") ){
								return true;
							}else{
								return false;
							}
					   });
					
			

				});

$(function() {
	LResize();
	$(window).resize(function() {
		LResize();
	});
	$(window).scroll(function() {
		scrollmenu();
	});

	// datepicker
	$("input.datepicker").datepicker({
		autoSize : true,
		appendText : '(dd-mm-yyyy)',
		dateFormat : 'yy-mm-dd'
	});
	$("div.datepickerInline").datepicker({
		dateFormat : 'dd-mm-yy',
		numberOfMonths : 1
	});

	$("input.birthday").datepicker({
		changeMonth : true,
		changeYear : true,
		dateFormat : 'yy-mm-dd',
		yearRange: '-90:+0'
	});

	// datetimepicker
	$("input.datetimepicker").datetimepicker({
		changeMonth : true,
		changeYear : true,
		dateFormat : 'yy-mm-dd',
		yearRange: '-90:+0'
	});
	$('.timepicker').timepicker({});

	// tipsy tootip
	$('.tip a ').tipsy({
		gravity : 's',
		live : true
	});
	$('.ntip a ').tipsy({
		gravity : 'n',
		live : true
	});
	$('.wtip a ').tipsy({
		gravity : 'w',
		live : true
	});
	$('.etip a,.Base').tipsy({
		gravity : 'e',
		live : true
	});
	$('.netip a ').tipsy({
		gravity : 'ne',
		live : true
	});
	$('.nwtip a , .setting').tipsy({
		gravity : 'nw',
		live : true
	});
	$('.swtip a,.iconmenu li a ').tipsy({
		gravity : 'sw',
		live : true
	});
	$('.setip a ').tipsy({
		gravity : 'se',
		live : true
	});
	$('.wtip input').tipsy({
		trigger : 'focus',
		gravity : 'w',
		live : true
	});
	$('.etip input').tipsy({
		trigger : 'focus',
		gravity : 'e',
		live : true
	});
	$('.iconBox, div.logout').tipsy({
		gravity : 'ne',
		live : true
	});

	// icon gray Hover
	$('.iconBox.gray').hover(
			function() {
				var name = $(this).find('img').attr('alt');
				$(this).find('img').animate(
						{
							opacity : 0.5
						},
						0,
						function() {
							$(this).attr('src',
									getUrl +'/assets/images/icon/color_18/' + name + '.png')
									.animate({
										opacity : 1
									}, 700);
						});
			},
			function() {
				var name = $(this).find('img').attr('alt');
				$(this).find('img').attr('src',
						getUrl +'/assets/images/icon/gray_18/' + name + '.png');
			})
	// icon Logout
	$('div.logout').hover(function() {
		var name = $(this).find('img').attr('alt');
		$(this).find('img').animate({
			opacity : 0.4
		}, 200, function() {
			$(this).attr('src', getUrl+'/assets/images/' + name + '.png').animate({
				opacity : 1
			}, 500);
		});
	}, function() {
		var name = $(this).find('img').attr('name');
		$(this).find('img').animate({
			opacity : 0.5
		}, 200, function() {
			$(this).attr('src', getUrl+'/assets/images/' + name + '.png').animate({
				opacity : 1
			}, 500);
		});
	})
	// icon setting
	$('div.setting').hover(function() {
		$(this).find('img').addClass('gearhover');
	}, function() {
		$(this).find('img').removeClass('gearhover');
	})

});

function ResetForm() {
	$('form').each(function(index) {
		var form_id = $('form:eq(' + index + ')').attr('id');
		if (form_id) {
			$('#' + form_id).get(0).reset();
			$('#' + form_id).validationEngine('hideAll');
			var editor = $('#' + form_id).find('#editor').attr('id');
			if (editor) {
				$('#editor').cleditor()[0].clear();
			}
		}
	});
}

function imgRow() {
	var maxrow = $('.albumpics').width();
	if (maxrow) {
		maxItem = Math.floor(maxrow / 160);
		maxW = maxItem * 160;
		mL = (maxrow - maxW) / 2;
		$('.albumpics ul').css({
			'width' : maxW,
			'marginLeft' : mL
		})
	}
}
function scrollmenu() {
	if ($(window).scrollTop() >= 1) {
		$("#header ").css("z-index", "50");
	} else {
		$("#header ").css("z-index", "47");
	}
}

function LResize() {
	imgRow();
	scrollmenu();
	if ($.cookie("hide_")) {
		$('#hide_panel').show();
	}
	$("#shadowhead").show();

}

function newPopup(url) {
	popupWindow = window
			.open(
					url,
					'popUpWindow',
					'height=500,width=900,left=50,top=50,resizable=yes,scrollbars=yes,toolbar=yes,menubar=no,location=no,directories=no,status=yes')
}

function newNoResizePopup(url) {
	popupWindow = window
			.open(
					url,
					'popUpWindow',
					'height=300,width=300,left=50,top=50,resizable=no,scrollbars=no,toolbar=no,menubar=no,location=no,directories=no,status=yes')
}

function newPopupDUMMY(url) {
	popupWindow = window
			.open(
					url,
					'popUpWindow',
					'height=500,width=900,left=50,top=50,resizable=yes,scrollbars=yes,toolbar=yes,menubar=no,location=no,directories=no,status=yes')
}

function setValue(target, id,val){
	var object = window.opener.document.getElementById(target);
	object.options.length = 0;
	
	var opt = opener.document.createElement("option");
	opt.setAttribute("value", id);
	opt.innerHTML = val;
	
	object.appendChild(opt);
	window.close();
}

function setAttendanceTime(target, val, userId, dateId){
	window.opener.document.getElementById(target).value = val;
	var nameTextBox = "attin";
	if(target.indexOf("attout") == -1){
		nameTextBox = "attout";
	}
	if(val.indexOf("AM") == -1 && val.indexOf("PM") == -1){
		window.opener.document.getElementById(nameTextBox+userId+"-"+dateId).value = val;
	}
	window.close();
}

function setValueVendor(target, id,val){
	var object = window.opener.document.getElementById(target);
	object.options.length = 0;
	var opt = opener.document.createElement("option");
	opt.setAttribute("value", id);
	opt.innerHTML = val;
	object.appendChild(opt);
	
	var id_party = window.opener.document.getElementById('id_party');
	id_party.innerHTML = "<a id='selectVendor1' class='iconBox color' original-title='Chosee Vendor Contact'   href=JavaScript:newPopup('/WHM/master/vendor_contact_list_dialog.do?target=vendor1&partyTypeId=1&partyId="+id+"'); > <img width='13px;' height='13px;' alt='add' src='/WHM/assets/images/icon/color_18/add.png'></a>";
	
	var addmorevendor = window.opener.document.getElementById('addmorevendor');
	addmorevendor.innerHTML = "<span style='font:Arial, Helvetica, sans-serif;color:#0099FF;cursor:pointer' onClick='addVendor("+id+");' >Add More Vendor Contact</span>";
	
	var addfactory = window.opener.document.getElementById('addfactory');
	addfactory.innerHTML = "<a id='selectFactory' class='iconBox color' original-title='Chosee Vendor Contact'   href=JavaScript:newPopup('/WHM/master/party_list_dialog.do?target=factory&partyType=2&id="+id+"'); > <img width='13px;' height='13px;' alt='add' src='/WHM/assets/images/icon/color_18/add.png'></a>";
	
	
	
	window.close();
}

function setValueFactory(target, id,val){
	var object = window.opener.document.getElementById(target);
	object.options.length = 0;
	var opt = opener.document.createElement("option");
	opt.setAttribute("value", id);
	opt.innerHTML = val;
	object.appendChild(opt);
	
	var addfactorycontactlist = window.opener.document.getElementById('addfactorycontactlist');
	addfactorycontactlist.innerHTML = "<a class='iconBox color' original-title='Chosee Vendor Contact'   href=JavaScript:newPopup('/WHM/master/vendor_contact_list_dialog.do?target=factory1&partyTypeId=2&partyId="+id+"'); > <img width='13px;' height='13px;' alt='add' src='/WHM/assets/images/icon/color_18/add.png'></a>";
	
	var addmorefactory = window.opener.document.getElementById('addmorefactory');
	addmorefactory.innerHTML = "<span style='font:Arial, Helvetica, sans-serif;color:#0099FF;cursor:pointer' onClick='addFactory("+id+");' >Add More Vendor Contact</span>";
	removeErrorVendorContact(target);
	window.close();
}

function removeErrorDailyTrxAdd(){
	window.opener.$("#accountItemInfo").text("");
	window.opener.$("#accountItemInfo").removeClass("error");
}

function removeErrorVendorContact(id){
	window.opener.$("#"+id).removeClass("error");
}


function isNumberKey(evt)
{
   var charCode = (evt.which) ? evt.which : event.keyCode;
   if (charCode > 31 && (charCode < 48 || charCode > 57))
      return false;

   return true;
}
