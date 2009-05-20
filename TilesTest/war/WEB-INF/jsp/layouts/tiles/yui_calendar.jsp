<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- CSS -->
<link rel="stylesheet" type="text/css" href="<c:url value='/yui_2.6.0/build/button/assets/skins/sam/button.css'/>"/>
<link rel="stylesheet" type="text/css" href="<c:url value='/yui_2.6.0/build/container/assets/skins/sam/container.css'/>"/>
<link rel="stylesheet" type="text/css" href="<c:url value='/yui_2.6.0/build/calendar/assets/skins/sam/calendar.css' />"/>

<!-- Javascript -->
<script type="text/javascript" src="<c:url value='/yui_2.6.0/build/yahoo-dom-event/yahoo-dom-event.js'/>"></script>
<script type="text/javascript" src="<c:url value='/yui_2.6.0/build/dragdrop/dragdrop-min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/yui_2.6.0/build/element/element-beta-min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/yui_2.6.0/build/button/button-min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/yui_2.6.0/build/container/container-min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/yui_2.6.0/build/calendar/calendar-min.js'/>"></script>

<!-- Style -->
<style type="text/css">
    /* Clear calendar's float */
    #container .bd:after {content:".";display:block;clear:left;height:0;visibility:hidden; position: relative;}

    /* Have calendar squeeze upto bd bounding box */
    #container .bd {padding:0;}

    /* Remove calendar's border and set padding in ems instead of px, so we can specify an width in ems for the container */
    #cal {border:none;padding:1em}

    .datefield input,
    .datefield button,
    .datefield label  {vertical-align:middle}

    .datefield label  {font-weight:bold}
    .datefield input  {width:15em}
    .datefield button  {padding:0 5px 0 5px; margin-left:2px;}
    .datefield button img {padding:0;margin:0;vertical-align:middle}

</style>
