<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table class="table">
  <thead class="thead-light">
    <tr>
      <th scope="col">#</th>
      <th scope="col">NOM</th>
      <th scope="col">DISCREPTION</th>
      <th scope="col">PRIX</th>
       <th scope="col">Quantite</th>
      
    </tr>
  </thead>
  <tbody>
<c:forEach var="product" items="${products}">
  
    <tr>
      <th scope="row">${product.Nompro}</th>
      <td>${product.description}</td>
      <td>${product.price}</td>
      <td>${product.qtestock}</td>
      <td>
                        <a href="/Pro/produits/removepro?id=<c:out value='${product.id}' />"  class="button-62">Delete</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="?id=<c:out value='${product.id}' />"  class="button-62">Edit</a>                     
                    </td>
    </tr>
    </c:forEach>
   
  </tbody>
</table>


</body>
</html>