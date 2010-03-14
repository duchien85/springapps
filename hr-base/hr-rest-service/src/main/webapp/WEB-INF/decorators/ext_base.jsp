<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator"  %>
<%@ taglib prefix="sitemesh" uri="http://www.opensymphony.com/sitemesh/page" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><decorator:title default="Hr Client" /></title>
        <link rel="stylesheet" type="text/css" href="<c:url value='/ext/resources/css/ext-all.css'/>">    
        <script type="text/javascript" src="<c:url value='/ext/adapter/ext/ext-base.js' />"></script>
        <script type="text/javascript" src="<c:url value='/ext/ext-all-debug.js'/>"></script>
        <link rel="stylesheet" type="text/css" href="<c:url value='/css/style_ext.css'/>">    
        <script>
         Ext.onReady(function(){
              Ext.BLANK_IMAGE_URL = "<c:url value='/images/s.gif'/>";
              Ext.Ajax.url = '${initParam["hrRestServiceUrl"]}';
         });
         </script>
        <decorator:head/>
    </head>
	<body>
        <div id="content">
    <decorator:body />
        </div>
      </body>
</html>
