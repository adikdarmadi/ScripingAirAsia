<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
		
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="description" content="" />
        <meta name="keywords" content="" />
        
        <title><tiles:insertAttribute name="title"/></title>
        <!-- Link shortcut icon-->
        <link rel="shortcut icon" type="image/ico" href="images/favicon2.html" /> 
        <!-- Link css-->

        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/assets/css/zice.style.css"/>
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/assets/css/icon.css"/>
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/assets/css/dropdown.css"/>
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/assets/css/ui-custom.css"/>
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/assets/css/timepicker.css"  />
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/assets/components/tipsy/tipsy.css" media="all" />
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/assets/css/smoothness/jquery.ui.combogrid.css"/>
		<!--  <link rel="stylesheet" href="http://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css" />  -->
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/assets/css/jquery-ui-1.9.2.css" />
		
        <script type="text/javascript" src="<%=request.getContextPath()%>/assets/js/custom/jquery.min.js"></script>
        <script type="text/javascript" src="<%=request.getContextPath()%>/assets/components/ui/jquery.ui.min.js"></script> 
        <script type="text/javascript" src="<%=request.getContextPath()%>/assets/components/ui/timepicker.js"></script>
        <script type="text/javascript" src="<%=request.getContextPath()%>/assets/components/scrolltop/scrolltopcontrol.js"></script>
        <script type="text/javascript" src="<%=request.getContextPath()%>/assets/components/tipsy/jquery.tipsy.js"></script>
        <script type="text/javascript" src="<%=request.getContextPath()%>/assets/js/custom/jquery.cookie.js"></script>
        <script type="text/javascript" src="<%=request.getContextPath()%>/assets/js/custom/zice.custom.js"></script>
        <script type="text/javascript" src="<%=request.getContextPath()%>/assets/js/pagination.js"></script> 

        
        <script type="text/javascript" language="javascript" src="<%=request.getContextPath()%>/assets/components/dropdown/hoverIntent.js"></script>
		<script type="text/javascript" language="javascript" src="<%=request.getContextPath()%>/assets/components/dropdown/jquery.dropdown.js"></script>   

		
       
        </head>        	
        <body>        
     		<!-- return url to js -->
            <div id="http://<%= request.getServerName() %>:<%= request.getServerPort() %>/ScripingAirAsia" class="getUrl"></div>   
          
        	<div id="header" >
        		<tiles:insertAttribute name="navigation"/>   
                
            </div> <!--//  header -->
			<div id="shadowhead" style="padding-top:20px;"></div>
    
            <div style="padding:10px;padding-top:5px">
                <div class="inner">
					<div class="topcolumn" style="padding-top:0px;padding-bottom:100px;">
						<!--//<div class="logo" style="padding-top:20px;"></div>-->
                            
					</div>
                    <div class="clear"></div>
                    	<tiles:insertAttribute name="content"/>
                    <div class="clear"></div>
                    <tiles:insertAttribute name="footer"/>
                </div> <!--// End inner -->
            </div> <!--// End content --> 
		</body>
</html>
