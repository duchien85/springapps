<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator"  %>
<%@ taglib prefix="sitemesh" uri="http://www.opensymphony.com/sitemesh/page" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
  	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title><decorator:title default="Sakila" /></title>
	<link rel="stylesheet" type="text/css" href="<c:url value='/yui_2.6.0/build/reset-fonts-grids/reset-fonts-grids.css'/>">  
	<link rel="stylesheet" type="text/css" href="<c:url value='/yui_2.6.0/build/base/base-min.css'/>">  
	<link rel="stylesheet" type="text/css" href="<c:url value='/css/style.css'/>">
	<link rel="stylesheet" type="text/css" href="<c:url value='/css/css_box/message_box.css'/>">  
	<script type="text/javascript" src="<c:url value='/js/prototype-1.6.0.3.js'/>"></script>
    <decorator:head/>
</head>

<body class="yui-skin-sam">
<div id="doc2" class="yui-t2">

	<div id="hd">
        <%@ include file="/WEB-INF/jsp/include/header.jsp"%>
	</div>

	<div id="bd">
		
		<div id="yui-main">
			<div class="yui-b">
				<div class="yui-g">
                    <decorator:body />
				</div><!-- end .yui-g -->
			</div><!-- end #yui-main .yui-b -->
		</div><!-- end #yui-main -->

		<div class="yui-b">
            <%@ include file="/WEB-INF/jsp/include/sidebar_left.jsp"%>
		</div><!-- end .yui-b -->
		
	</div><!-- end #bd -->
	
	<div id="ft">
        <%@ include file="/WEB-INF/jsp/include/footer.jsp"%>
	</div>

</div><!-- end #doc2 .yui-t2 -->
</body>
</html>