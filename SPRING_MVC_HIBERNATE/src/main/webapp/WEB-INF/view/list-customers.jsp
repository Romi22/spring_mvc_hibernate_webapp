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


        <input type="button" value="Add Customer" onclick="window.location.href='showFormForAdd';return false;"
        class="add-button"
        />


          <table>
             <tr>
               <th>ID</th>
               <th>NAME</th>
               <th>BALANCE</th>
               <th>ACCOUNT_ID</th>
               <th>Action</th>
             </tr>

             <c:forEach var="tempCustomer" item="${customer}">

             <c:url var="updateLink" value="/customer/showFormForUpdate">
                 <c:param name="customerId" value="${tempCustomer.id}"/>
             </c:url>

             <c:url var="deleteLink" value="/customer/delete">
                              <c:param name="customerId" value="${tempCustomer.id}"/>
             </c:url>

                 <tr>
                     <td>${tempCustomer.id}</td>
                      <td>${tempCustomer.name}</td>
                       <td>${tempCustomer.email}</td>
                       <td> <a href="${updateLink}">Update</a> </td>
                       |
                        <td> <a href="${deleteLink}" onclick="if(!(confirm('Are you sure you want to delete this customer?')))return false">Delete</a> </td>
                 </tr>
             </c:forEach>
          </table>


     </div>
  </div>

</body>
</html>