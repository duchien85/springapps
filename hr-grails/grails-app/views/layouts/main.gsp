<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
    <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <title><g:layoutTitle default="HR App" /></title>
      <link rel="stylesheet" href="${resource(dir:'css',file:'main.css')}">
      <link rel="stylesheet" type="text/css" href="${resource(dir:'yui_2.8/build/reset-fonts-grids', file:'reset-fonts-grids.css')}">
      <link rel="stylesheet" type="text/css" href="${resource(dir:'yui_2.8/build/base', file:'base.css')}">
      <link rel="stylesheet" type="text/css" href="${resource(dir:'yui_2.8/build/menu/assets/skins/sam', file:'menu.css')}">
      <link rel="stylesheet" type="text/css" href="${resource(dir:'css', file:'style.css')}">
      ${pageProperty(name:'page.extra_css')}
      <script type="text/javascript" src="${resource(dir:'yui_2.8/build/yahoo-dom-event/', file='yahoo-dom-event.js')}"></script>
      <script type="text/javascript" src="${resource(dir:'yui_2.8/build/container/', file='container-min.js')}"></script>
      <script type="text/javascript" src="${resource(dir:'yui_2.8/build/menu/', file='menu-min.js')}"></script>
      ${pageProperty(name:'page.extra_js')}
      <script type="text/javascript" src="${resource(dir:'js/', file='main.js')}"></script>
      <style type="text/css">
      ${pageProperty(name:'page.extra_style')}
      </style>
      <g:layoutHead />
    </head>
    <body class="yui-skin-sam">
      <div id="doc2" class="yui-t2">
	<div id="hd">
          <div id="hd_logo">
	    <a href="${request.contextPath}">Yui doc2 yui-t2</a>
          </div>
          <!-- end hd_logo -->
	  <g:render template="/menu_top" />
            </div>
            <!--end hd -->
            <div id="bd">
                <div id="yui-main">
                    <div class="yui-b">
	              <g:layoutBody />		
                    </div>
                    <!-- end yui-b (main)-->
                </div>
                <!-- end yui-main -->
                <div class="yui-b">
                    <div id="sidebar">
		      <g:render template="/menu_left" />
                    </div>
                    <!-- end sidebar -->
                </div>
                <!-- end yui-b -->
            </div>
            <!-- end bd -->
      	    <g:render template="/ft" />
        </div>
        <!-- end #doc -->
    </body>
</html>
