<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta name="decorator" content="blank">
<title>Ext Geo Test</title>
    <script type="text/javascript" src="<c:url value='/js/openlayers/OpenLayers.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/js/GeoExt/script/GeoExt.js'/>"></script>
    <link rel="stylesheet" type="text/css" href="<c:url value='/js/GeoExt/resources/css/geoext-all.css'/>"></link>
    <script type="text/javascript" src="<c:url value='/js/geoSearchMap.js'/>"></script>
</head>
<body>
<div id="mappanel"></div>
<div><button name="show_map" title="Show The Map" id="show_map"/>Show the Map</button></div>
</body>
</html>

