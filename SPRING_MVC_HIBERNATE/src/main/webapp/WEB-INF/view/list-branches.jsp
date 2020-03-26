<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<body>

    <div id="wrapper">
       <div id="header">
           <h2>*****************CRM*********************</h2>
       </div>
    </div>

  <div id="container">
     <div id="content">


        <input type="button" value="Add Branch" onclick="window.location.href='showFormForAdd';return false;"
        class="add-button"
        />


          <table>
             <tr>
               <th>BRANCH_NAME</th>
               <th>BRANCH_CODE</th>
               <th>Action</th>
             </tr>

             <c:forEach var="tempBranch" item="${branch}">

             <c:url var="updateLink" value="/branch/showFormForUpdate">
                 <c:param name="branchCode" value="${tempBranch.Code}"/>
             </c:url>

             <c:url var="deleteLink" value="/branch/delete">
                              <c:param name="branchCode" value="${tempBranch.branchCode}"/>
             </c:url>

                 <tr>
                     <td>${tempBranch.branchName}</td>
                      <td>${tempBranch.branchCode}</td>
                       <td> <a href="${updateLink}">Update</a> </td>
                       |
                        <td> <a href="${deleteLink}" onclick="if(!(confirm('Are you sure you want to close this branch?')))return false">Delete</a> </td>
                 </tr>
             </c:forEach>
          </table>


     </div>
  </div>

</body>
</html>