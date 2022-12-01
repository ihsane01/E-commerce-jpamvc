<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

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

                        <a href="<c:url value='/Pro/produits/formpro' />"  class="button-62">Ajouter produit</a>                     
</div>
<table class="table table-bordered  w-50%">
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
      <th scope="row">${product.nompro}</th>
      <td>${product.description}</td>
      <td>${product.price}</td>
      <td>${product.qtestock}</td>
      <td> 
                        <a href="<c:url value='/Pro/produits/${product.id}/removepro' />"  class="button-62">Delete</a>
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