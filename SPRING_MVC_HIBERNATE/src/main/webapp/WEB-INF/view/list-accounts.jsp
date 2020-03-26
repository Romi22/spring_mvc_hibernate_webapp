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


        <input type="button" value="Add Account" onclick="window.location.href='showFormForAdd';return false;"
        class="add-button"
        />


          <table>
             <tr>
               <th>ACCOUNT_ID</th>
               <th>ACCOUNT_TYPE</th>
               <th>ACCOUNT_NO</th>
               <th>Action</th>
             </tr>

             <c:forEach var="tempAccount" item="${account}">

             <c:url var="updateLink" value="/account/showFormForUpdate">
                 <c:param name="accountID" value="${tempAccount.accountID}"/>
             </c:url>

             <c:url var="deleteLink" value="/account/delete">
                              <c:param name="accountID" value="${tempAccount.id}"/>
             </c:url>

                 <tr>
                     <td>${tempAccount.accountId}</td>
                      <td>${tempAccount.accountType}</td>
                       <td>${tempAccount.accountNo}</td>
                       <td> <a href="${updateLink}">Update</a> </td>
                       |
                        <td> <a href="${deleteLink}" onclick="if(!(confirm('Are you sure you want to close this account?')))return false">Delete</a> </td>
                 </tr>
             </c:forEach>
          </table>


     </div>
  </div>

</body>
</html>