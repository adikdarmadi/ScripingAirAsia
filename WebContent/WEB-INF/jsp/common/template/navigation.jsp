<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ page
	import="org.springframework.security.core.context.SecurityContextHolder"%>


<table width="100%" border="0" class="tableheader">
	<tr>
		<td class="tdheading">

			<ul class="dropdown" id="modul">
				<li><a href="<%=request.getContextPath()%>/master/booking/booking_add.html" id="homelink">Search Fly</a></li>
				<li><a href="<%=request.getContextPath()%>/master/stationList/stationList_add.html" id="settinglink">Master Station</a></li>
			</ul>
		</td>


		<td class="tdheading"><span id="account_info" style="float: left">
				<div class="setting">
					<b>Welcome,</b> <b class="red"> <font color="red"> <b>

						</b> </font> </a> </b> <img
						src="<%=request.getContextPath()%>/assets/images/gear.png" />
				</div> </span>
		</td>
	</tr>
</table>
