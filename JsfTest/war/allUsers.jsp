<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<html>
   <f:view>
      <head>                  
         <title>All Users Table</title>
      </head>
      <body>
      	<h:messages/>
      	<h1>All Users</h1>
        <h:dataTable value="#{user.allUsers}" var="userBean">
        	<h:column>
        		<f:verbatim>Name: </f:verbatim>
        		<h:outputText value="#{userBean.name}" />
        	</h:column>
        	<h:column>
        		<f:verbatim>Pass: </f:verbatim>
        		<h:outputText value="#{userBean.password}" />
        	</h:column>
        	<h:column>
        		<f:verbatim>Number: </f:verbatim>
        		<h:outputText value="#{userBean.number}" />
        	</h:column>
        </h:dataTable>
      </body>
   </f:view>
</html>