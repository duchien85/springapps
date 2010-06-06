<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
    <ul>
        <li><a href='<c:url value="/app/mapserver.htm" />'>Map Server Test</a></li>
        <li><a href='<c:url value="/app/mapserverblank.htm" />'>Map Server Blank Test</a></li>
        <li><a href="${request.contextPath}/app/openlayersblanktest.htm">Open Layers Blank Test</a></li>
        <li><a href='<c:url value="/app/geoexttest.htm" />'>GeoExt Test</a></li>
        <li><a href='<c:url value="/app/geosearchmap.htm" />'>GeoSearchMap (OO)</a></li>
    </ul>
</div>