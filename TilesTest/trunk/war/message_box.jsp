<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Message Box Examples</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/css/css_box/message_box.css'/>">  
<style type="text/css">
/* --------------------------------- */
/* CSS RESET	  					*/
body{margin:0; border:0; padding:0;}

/* --------------------------------- */
/* STANDARD TAG  					*/
body{
	font-family:"Lucida Grande", "Lucida Sans Unicode", Verdana, Arial, Helvetica, sans-serif; 
	font-size:12px;
}

/* --------------------------------- */
/*CONTAINER		  					*/
#container{ 
	margin:0 auto;
	margin-top:40px;
	width:260px;
}
</style>
</head>

<body>
<div id="container">

<!-- Clean -->
<h1>Clean</h1>
<div class="clean-gray">Clean message box</div>				<br />

<div class="clean-yellow">Clean message box</div>			<br />
<div class="clean-ok">Clean Ok! message box</div>			<br />
<div class="clean-error">Clean error message box</div>		<br /><br /><br />

<!-- Iconized  -->
<h1>Iconized</h1>
<div class="icon-yellow">Clean message box</div>			<br />
<div class="icon-ok">Clean Ok! message box</div>			<br />

<div class="icon-error">Clean error message box</div>		<br /><br /><br />

<!-- SOLID -->
<h1>Solid</h1>
<div class="solid-gray">Solid message box</div>				<br />
<div class="solid-yellow">Solid message box</div>			<br />
<div class="solid-ok">Solid Ok message box</div>			<br />
<div class="solid-error">Solid error message box</div>		<br /><br /><br />

<!-- ROUNDED ALTERNATE -->
<h1>Rounded Alternate</h1>
<div class="round-a-gray"><div>Solid message box</div></div>			<br />
<div class="round-a-gray"><div>
<strong>Solid message box tips</strong><br />
This box adapts automatically the rounded borders to the box size
</div></div>    		

<br />

<div class="round-a-ok"><div>Solid Ok message box</div></div>			<br />

<div class="round-a-ok"><div>
<strong>Solid Ok message box tips</strong><br />
This box adapts automatically the rounded borders to the box size
</div></div>			

<br />

<div class="round-a-error"><div>Solid error message box</div></div>		<br />
<div class="round-a-error"><div>
<strong> Solid error message tips</strong><br />
This box adapts automatically the rounded borders to the box size
</div></div>																	

<br /><br /><br />

<!-- Tooltips -->
<h1>Tooltips</h1>
<div class="tooltips-gray">Solid message box<div></div></div>			<br />
<div class="tooltips-ok">Solid message box<div></div></div>				<br />
<div class="tooltips-error">Solid message box<div></div></div>

</div>
</body>
</html>
