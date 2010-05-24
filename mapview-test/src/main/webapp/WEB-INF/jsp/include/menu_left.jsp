<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
    <ul>
        <li><a href='<c:url value="/mapserver.htm" />'>Map Server Test</a></li>
        <li><a href='<c:url value="/mapserverblank.htm" />'>Map Server Blank Test</a></li>
        <li><a href="${request.contextPath}/openLayersTest.htm">Open Layers Test</a></li>
        <li><a href="${request.contextPath}/openLayersBlankTest.htm">Open Layers Blank Test</a></li>
        <li><a href='<c:url value="/geoExtTest.htm" />'>GeoExt Test</a></li>
    </ul>
</div>