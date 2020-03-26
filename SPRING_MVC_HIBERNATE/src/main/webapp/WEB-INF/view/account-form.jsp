<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
  <title>Save Account</title>
</head>
<body>
  <form:form action="saveAccount" modelAttribute="account" method=POST>

<form:hidden path="id"/>

  <table>
      <tbody>
            <tr>
                <td><label>AccountID</label></td>
                <td><form:input path="accountId"/></td>
            </tr>

            <tr>
                  <td><label>AccountType</label></td>
                   <td><form:input path="acountType"/></td>
             </tr>

             <tr>
                   <td><label>AccountNo</label></td>
                   <td><form:input path="accountNo"/></td>
             </tr>

               <tr>
                      <td><input type="submit" value="Save"/></td>
                </tr>


      </tbody>
  </table>

  </form:form>

  <div style="clear;both"</div>

  <p>
     <a href="${pageContext.request.contextPath}/account/list">Back to List</a>
  </p>
</body>
  </html>
