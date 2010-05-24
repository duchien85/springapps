<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta name="decorator" content="blank">
<title>Oracle Map Server (Blank) Test</title>
<script type="text/javascript" src="<c:url value='/js/oraclemaps.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/mapserver.js'/>"></script>
<style type="text/css">
#theMap {
    left: 1%;
    top: 1%;
    width: 99%;
    height: 99%;
}
</style>
</head>
<body>
    <div>
        <div id="theMap"></div>
    </div>
</body>

</html>


