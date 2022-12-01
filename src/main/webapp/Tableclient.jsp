<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="nav.jsp" />
<div class="container">

        <div class=" text-center mt-5 mb-5 ">

</div>
<table class="table table-bordered  w-50%">
  <thead class="thead-light">
    <tr>
      <th scope="col">NOM</th>
      <th scope="col">Email</th>
         <th scope="col">Action</th>
   
      
    </tr>
  </thead>
  <tbody>
<c:forEach var="client" items="${clients}">
  
    <tr>
      <th scope="row">${client.name}</th>
      <td>${client.email}</td>
   
      <td> 
                        <a href="<c:url value='/Pro/produits/${client.id}/removepro' />"  class="button-62">Delete</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="<c:url value='/Pro/produits/addpro' />"  class="button-62">Edit</a>                     
                    </td>
    </tr>
    </c:forEach>
   
  </tbody>
</table>

</div>
</body>
</html>