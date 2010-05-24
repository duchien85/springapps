<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator"  %>
<%@ taglib prefix="sitemesh" uri="http://www.opensymphony.com/sitemesh/page" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><decorator:title default="Hr Client" /></title>
        <link rel="stylesheet" type="text/css" href="<c:url value='/css/reset-fonts-grids.css'/>">
        <link rel="stylesheet" type="text/css" href="<c:url value='/css/base-min.css'/>">
        <link rel="stylesheet" type="text/css" href="<c:url value='/css/style.css'/>">
        <decorator:head/>
    </head>
    <body class="yui-skin-sam">
          <div id="doc2" class="yui-t2">
            <div id="hd">
                <div id="hd_logo">
                   <a href='<c:url value="/"/>'>MAP TEST</a>
                </div>
            </div>
            <!--end hd -->
            <div id="bd">
                <div id="yui-main">
                    <div class="yui-b">
                        <decorator:body />
                    </div>
                </div>
                <div class="yui-b">
                    <div id="sidebar">
                    <%@ include file="/WEB-INF/jsp/include/menu_left.jsp"%>
                    </div><!-- end sidebar -->
                </div><!-- end yui-b -->
            </div><!-- end bd -->
            <div id="ft">
                <div id="ft_links">
                    <ul>
                        <li><a href="/">Home</a>|</li>
                        <li><a href="/">Link 1</a>|</li>
                        <li><a href="/">Link 2</a>|</li>
                        <li><a href="/">Link 3</a></li>
                    </ul>
                </div><!-- end ft_links -->
                <div id="copyright">
                    Copyright &copy; SAIC 2010
                </div>
                <!-- end #copyright -->
            </div>
            <!-- end ft -->
        </div>
        <!-- end #doc -->
    </body>
</html>
