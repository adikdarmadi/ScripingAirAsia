<%@page import="org.springframework.jdbc.core.RowCallbackHandler"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"pageEncoding="ISO-8859-1"%>

<script type="text/javascript" src="<%=request.getContextPath() %>/assets/js/stationList/stationList_add.js"></script>
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
	<div class="header" align="right"><span ><span class="ico  gray arrow_bidirectional"></span>Master Sation List</span></div>
	<div class="clear"></div>
                
 	<form:form id="stationList_new" class="stationList_new" name="stationList_new" method="post" modelAttribute="stationList">
		<table width="100%" border="0" style="padding: 10px;">
        	<tr>
            	<td width="100"><strong>Station List Json</strong></td>
              	<td width="300"><textarea cols="120" rows="10" id="stationListJson" name="stationListJson"></textarea></td>
          	</tr>
          	<tr>
            	<td width="100"></td>
              	<td width="231"><input name="submit" class="uibutton icon add " type="submit" value="submit"/> <font color="red"><b>(filled with json from station list web airasia )</b></font></td>
                <td width="143"></td>
          	</tr>
    	</table>
    </form:form>
    </div>
    <div class="onecolumn" >
    <div id="tabs">
		<ul>
			<li><a href="#tabs-1">Station List </a></li>

		</ul>	
    	<div id="tabs-1">
			<br>
			<a href="<%=request.getContextPath() %>/master/stationList/stationList_delete.html" class="uibutton special">Delete all Station</a>
			<br/><br/>
			<h4>Data is retrieved from a database prepared from json taken from website airasia.com</h4>
			<table width="100%" cellpadding="0" cellspacing="0" id="tableItem" class="bordered">
				<thead>
					<tr>
						<th align="center" width="200px">Short Name</th>
						<th align="center" width="200px">Province State Code</th>
						<th align="center" width="200px">Country Code</th>
						<th align="center" width="200px">Sation Categories</th>
						<th align="center" width="200px">Name</th>
						<th align="center" width="200px">Mac Code</th>
						<th align="center" width="200px">Code</th>
						
					</tr>
					
					<c:forEach items="${stationList}" var="items" varStatus="counter">
						<tr>
							<td>${items.shortName}</td>
							<td>${items.countryCode}</td>
							<td>${items.provinceStateCode}</td>
							<td>${items.stationCategories}</td>
							<td>${items.name}</td>
							<td>${items.macCode}</td>						
							<td>${items.code}</td>
						</tr>
					</c:forEach>
				
				</thead>

			</table>
			
		</div>
	</div>
       
</div>
				                      
                
	
	
	