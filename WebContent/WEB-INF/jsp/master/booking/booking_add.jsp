<%@page import="org.springframework.jdbc.core.RowCallbackHandler"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"pageEncoding="ISO-8859-1"%>

<script type="text/javascript" src="<%=request.getContextPath() %>/assets/js/booking/booking_add.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/assets/js/custom/jquery.ui.combogrid-1.6.2.js"></script>
<style>
.tableSizeStyle {
	border: 1px solid #c9d0d0;
}

.tableSizeStyleTD {
	border: 1px solid #c9d0d0;
}
</style>
<script>
    $(function() {
    	var a=0;
        $( "#tabs" ).tabs({selected: a});
    });
    
  
   
    </script>
<div class="onecolumn" >
	<div class="header" align="right"><span ><span class="ico  gray arrow_bidirectional"></span>Web Scraping Air asia</span></div>
	<div class="clear"></div>
                
 	<form:form id="booking_new" class="booking_new" name="booking_new" method="post" modelAttribute="stationList">
		
		<table  border="0" width="600px" cellpadding="5px" cellspacing="5px">
        	<tr>
            	<td width="120"><strong>Origin</strong></td>
              	<td width="200"><input type="text" size="33" id="asal"/><input type="hidden" name="hiddenAsal" id="hiddenAsal"/></td>
                <td width="143"><span id="asalInfo" class="info1"/></td>
          	</tr>
          	<tr>
            	<td width="113"><strong>Distination</strong></td>
              	<td width="100"><input type="text" size="33"  id="tujuan"/><input type="hidden" name="hiddenTujuan" id="hiddenTujuan"/></td>
                <td width="143"><span id="tujuanInfo" class="info1"/></td>
          	</tr>
          	<tr>
				<td width="113"><strong>Depart</strong></td>
				<td width="100"><input type="text" readonly class="birthday" id="depart" name="depart" size="33" maxlength="50" /></td>
				<td width="143"><span id="departInfo" class="fromDateInfo"></span></td>
			</tr>
			<tr>
				<td width="113"><strong>Adult</strong></td>
				<td width="100"><input type="text"  id="adult" size="33" name="adult" maxlength="50" /></td>
				<td width="143"><span id="adultInfo" class="adultInfo"></span></td>
			</tr>
			<tr>
				<td width="113"><strong>Kids</strong></td>
				<td width="100"><input type="text"  id="kids" size="33" name="kids" maxlength="50" /></td>
				<td width="143"><span id="kidsInfo" class="kidsInfo"></span></td>
			</tr>
			<tr>
				<td width="113"><strong>Infants</strong></td>
				<td width="100"><input type="text"  id="infants" name="infants" size="33" maxlength="50" /></td>
				<td width="143"><span id="infantsInfo" class="infantsInfo"></span></td>
			</tr>
          	<tr>
            	<td width="113"></td>
              	<td width="100"><input name="submit" class="uibutton icon add " type="submit" value="submit"/></td>
                <td width="143"></td>
          	</tr>
          	
          	
          	
          	
          	
    	</table>
    </div>
    <div class="onecolumn" >
    <div id="tabs">
		<ul>
			<li><a href="#tabs-1">Result</a></li>

		</ul>	
    	<div id="tabs-1">

			<h5>${depart}</h5>
		
			<table width="100%" cellpadding="0" cellspacing="0" id="tableItem" class="bordered">
				<thead>
					<tr>
						<th align="center" width="200px">Depart/ Arrive</th>
						<th align="center" width="200px">Low fare</th>
						<th align="center" width="200px">Hi-Flyer(Flexi fare)</th>
					</tr>
					
						<c:forEach items="${resultList}" var="items" varStatus="counter">
							<tr>
								<td>${items.jadwalBerangkat}</td>
								<td>${items.lowFare}</td>
								<td>${items.hiFlyer}</td>
							</tr>
						</c:forEach>
				
				</thead>

			</table>
			
		</div>
	</div>
	</form:form>           
</div>
				                      
                
	
	
	