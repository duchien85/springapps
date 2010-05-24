<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator"  %>
<%@ taglib prefix="sitemesh" uri="http://www.opensymphony.com/sitemesh/page" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><decorator:title default="The Map" /></title>
        <link rel="stylesheet" type="text/css" href="<c:url value='/js/ext/resources/css/ext-all.css'/>">
        <script type="text/javascript" src="<c:url value='/js/ext/adapter/ext/ext-base.js' />"></script>
        <script type="text/javascript" src="<c:url value='/js/ext/ext-all-debug.js'/>"></script>
        <script>
         Ext.onReady(function(){
              Ext.BLANK_IMAGE_URL = "<c:url value='/images/s.gif'/>";
              var myMask = new Ext.LoadMask(Ext.getBody(), {msg:"Please wait..."});
              //Ext.Ajax.on('beforerequest', myMask.show, myMask);
              //Ext.Ajax.on('requestcomplete', myMask.hide, myMask);
              //Ext.Ajax.on('requestexception', myMask.hide, myMask);

         });
         </script>
        <decorator:head/>
    </head>
    <body>
        <decorator:body />
    </body>
</html>
