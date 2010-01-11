<%@ include file="/WEB-INF/jsp/includes.jsp"%>
<html>
<head>
<meta name="decorator" content="yui_doc2_t2_1grid">
<title>ABCD - C</title>
</head>
<body>

<h1>C</h1>
<h2>${flowExecutionUrl}</h2>

<p>Maecenas nec tellus. Suspendisse potenti. Donec tincidunt tortor. Donec scelerisque purus id lectus. Duis gravida
metus. Morbi facilisis sodales nunc. Praesent interdum, tellus ut malesuada facilisis, diam justo posuere purus, a
semper justo felis quis turpis. Aliquam ac lacus. Phasellus quam ante, ultricies eu, euismod et, malesuada quis, sem.
Proin lacus ligula, sollicitudin quis, tincidunt non, venenatis non, nisl. In hac habitasse platea dictumst. Nulla
facilisi. Vivamus non eros. Curabitur tempor justo sed lacus. Vestibulum ante ipsum primis in faucibus orci luctus et
ultrices posuere cubilia Curae; Proin venenatis tempus odio. Phasellus lacinia elit vitae orci. Praesent metus ipsum,
blandit vel, interdum vitae, tristique eu, augue. Quisque luctus bibendum velit. In ultrices vehicula lorem.
Pellentesque ut lectus in nisi sollicitudin adipiscing. In interdum vestibulum lectus. Aliquam erat volutpat. Phasellus
sagittis. Proin augue tortor, ultricies eget, tincidunt ultrices, tempor nec, risus. Aenean nec enim id lorem rhoncus
convallis. Sed pede dui, congue mollis, auctor volutpat, mollis at, nisl. Nunc mollis pharetra nibh. Donec placerat,
enim et imperdiet ullamcorper, tellus nisi vulputate enim, et congue dolor risus nec libero. In fringilla ante. Aenean
libero neque, suscipit et, dignissim et, pharetra vitae, libero. Aliquam erat nulla, vehicula ac, mattis eu, viverra et,
arcu.</p>

<tt:pageDebug debugPage="false" debugRequest="true" />

<c:if test="${not empty flashMessage}">
  <div class="clean-ok">${flashMessage}</div>
</c:if>

<c:if test="${not empty flashError}">
  <div id="clean-error">${flashError}</div>
</c:if>

<form method="post" /><input type="submit" name="_eventId_submitB" value="Go to B" /><br />
<input type="submit" name="_eventId_submitD" value="Go to D" /></form>

</body>
</html>