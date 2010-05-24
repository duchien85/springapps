<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta name="decorator" content="blank">
<title>MAP Test Blank</title>
<script type="text/javascript" src="<c:url value='/openlayers/OpenLayers.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/openLayersTest.js'/>"></script>
<style type="text/css">
#theMap {
    left: 1%;
    top: 1%;
    width: 75%;
    /*height: 75%;*/
}
</style>
</head>
<body>
    <div>
        <div id="theMap"></div>
    </div>
</body>

</html>


