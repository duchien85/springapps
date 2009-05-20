<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tt" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="jmesa" uri="http://code.google.com/p/jmesa" %>

<c:if test="${not empty flashScope.message}">
	<div class="clean-ok">${flashScope.message}</div>
</c:if>

<c:if test="${not empty flashScope.error}">
	<div class="clean-error">${flashScope.error}</div>
</c:if>

<div id="pageTitle">
<h2>Films</h2>
</div>

<form name="filmsForm" method="get" />
<div>
   <jmesa:tableFacade 
   		id="films" 
   		items="${films}" 
   		var="bean" 
   		limit="${limit}"
   		toolbar="com.studerb.web.util.FullPaginationToolbar" >
        <jmesa:htmlTable width="80%" border="1px">               
            <jmesa:htmlRow>     
                <jmesa:htmlColumn property="title" title="Title"/>
                <jmesa:htmlColumn property="releaseYear" title="Released"/>
                <jmesa:htmlColumn property="description" title="Description"/>
                <jmesa:htmlColumn property="length" title="Length (minutes"/>
                <jmesa:htmlColumn property="rating" title="Rating"/>
            </jmesa:htmlRow>
        </jmesa:htmlTable> 
    </jmesa:tableFacade>
</div>
</form>


<script type="text/javascript">
function onInvokeAction(id) {
    createHiddenInputFieldsForLimitAndSubmit(id);
}
</script>