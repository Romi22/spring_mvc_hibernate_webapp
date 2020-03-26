<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
  <title>Save Customer</title>
</head>
<body>
  <form:form action="saveCustomer" modelAttribute="customer" method=POST>

<form:hidden path="id"/>

  <table>
      <tbody>
            <tr>
                <td><label>Id</label></td>
                <td><form:input path="id"/></td>
            </tr>

            <tr>
                  <td><label>Name</label></td>
                   <td><form:input path="name"/></td>
             </tr>

             <tr>
                   <td><label>Balance</label></td>
                   <td><form:input path="balance"/></td>
             </tr>
             <tr>
                    <td><label>AccountID</label></td>
                    <td><form:input path="accountID"/></td>
              </tr>

               <tr>
                      <td><input type="submit" value="Save"/></td>
                </tr>


      </tbody>
  </table>

  </form:form>

  <div style="clear;both"</div>

  <p>
     <a href="${pageContext.request.contextPath}/customer/list">Back to List</a>
  </p>
</body>
  </html>
