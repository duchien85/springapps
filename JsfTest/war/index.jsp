<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
   <f:view>
      <head>                  
         <title>A Simple JavaServer Faces Application</title>
      </head>
      <body>
      	<h:messages/>
         <h:form>
			<h:outputText value="#{msgs.someMessage}" />
            <h3>Please enter your name and password.</h3>
            <table>
               <tr>
                  <td>Name:</td>
                  <td>
                     <h:inputText required="true" id="userName" value="#{user.name}"/><h:message for="userName" />
                  </td>
               </tr>             
               <tr>
                  <td>Password:</td>
                  <td>
                     <h:inputSecret id="userPassword" value="#{user.password}"/><h:message for="userPassword"></h:message>
                  </td>
               </tr>
               <tr>
               	  <td>Number:</td>
               	  <td>
                     <h:inputText id="number" value="#{user.number}"/><h:message for="number"/>
                  </td>
               </tr>
               <tr>
               	  <td>User.Address.Street</td>
                  <td>
                     <h:inputText id="userAddressStreet" value="#{user.address.street}"/><h:message for="userAddressStreet" />
                  </td>
               </tr>
               <tr>
               		<td><h:commandLink immediate="true" actionListener="#{user.onClick}">User.onClick</h:commandLink></td>	
               		<td>&nbsp;</td>
               </tr>
            </table>
            <p>
               <h:commandButton value="Login" action="#{user.doSomething}">
               </h:commandButton>
               <h:commandLink>
               		<h:outputText value="Send SomeValue"/>
               		<f:param value="SOME_VALUE" name="SOME_PARAM"/>
               </h:commandLink>
            </p>
         </h:form>
      </body>
      <a href="<c:url value='/allUsers.faces' />">All Users</a>
   </f:view>
</html>