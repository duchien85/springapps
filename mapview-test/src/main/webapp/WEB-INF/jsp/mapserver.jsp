<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta name="decorator" content="yui_doc2_t2_1grid">
<title>Oracle Map Server Test</title>
<script type="text/javascript" src="<c:url value='/js/oraclemaps.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/mapserver.js'/>"></script>
<style type="text/css">
#theMap {
    width: 75%;
    height: 75%;
    position: relative;
}
</style>
</head>

<body>
    <div class="content" class="container">
        <div id="theMap"></div>
    </div>
</body>

</html>


