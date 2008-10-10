<?xml version="1.0" encoding="UTF-8"?>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html >
<head>
	<title><tiles:getAsString name="title" /></title>
	<link rel="stylesheet" type="text/css" href="<c:url value='/css/reset-fonts-grids-min.css'/>"/> 
	<link rel="stylesheet" type="text/css" href="<c:url value='/css/base-min.css'/>"/> 
	<link rel="stylesheet" type="text/css" href="<c:url value='/css/style.css'/>"/> 
</head>
<body>

<div id="doc2" class="yui-t2">

	<div id="hd">
        <tiles:insertAttribute name="header" />
	</div>

	<div id="bd">
		<div id="yui-main">
			<div class="yui-b">
				<div class="yui-g">
					<tiles:insertAttribute name="content" />
				</div><!-- end .yui-g -->
			</div><!-- end #yui-main .yui-b -->
		</div><!-- end #yui-main -->

		<div class="yui-b">
			<tiles:insertAttribute name="sidebar_left" />
		</div><!-- end .yui-b -->
		
	</div><!-- end #bd -->
	
	<div id="ft">
        <tiles:insertAttribute name="footer" />		
	</div>

</div><!-- end #doc2 .yui-t2 -->
</body>
</html>