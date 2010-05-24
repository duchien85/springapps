<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta name="decorator" content="yui_doc2_t2_1grid">
<title>Open Layers Test</title>
<script type="text/javascript" src="<c:url value='/js/openlayers/OpenLayers.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/openLayersTest.js'/>"></script>
<style type="text/css">
#theMap{
    width: 100%;
    height: 500px;
}
</style>
</head>

<body>
    <div class="content" >
        <div id="theMap"></div>
    </div>
</body>

</html>


