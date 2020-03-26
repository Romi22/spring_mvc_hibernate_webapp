<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
  <title>Save Account</title>
</head>
<body>
  <form:form action="saveBranch" modelAttribute="branch" method=POST>

<form:hidden path="id"/>

  <table>
      <tbody>
            <tr>
                <td><label>BranchName</label></td>
                <td><form:input path="branchName"/></td>
            </tr>

            <tr>
                  <td><label>BranchCode</label></td>
                   <td><form:input path="branchCode"/></td>
             </tr>

               <tr>
                      <td><input type="submit" value="Save"/></td>
                </tr>


      </tbody>
  </table>

  </form:form>

  <div style="clear;both"</div>

  <p>
     <a href="${pageContext.request.contextPath}/branch/list">Back to List</a>
  </p>
</body>
  </html>
