<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<LINK rel="STYLESHEET" type="text/css" href="nav.css">

<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
</head>
<body>
<jsp:include page="nav.jsp" />

<div class="container">
<div>
   <c:choose>
      <c:when test="${products == null}">
         <div class="page-header">
            <h1>No products found</h1>
         </div>
         <p>
            Unfortunately there are no product available for purchase right now.
            Please visit our shop later. 
         </p>
      </c:when>
      <c:otherwise>
         <div class="page-header centre-align">
         </div>
         <div class="row mt-4">
            <c:forEach var="product" items="${products}">
        <div class="col-sm-5 col-md-3">
               <div class="card shadow-none p-3 mb-2 bg-light rounded" style="width: 14rem;">
  <img src="images/${product.codeimg}.jpg" class="card-img-top" alt="...">
  <div class="card-body">
    <h5 class="card-title">${product.nompro}</h5>
    <p class="card-text">${product.description}</p>
        <p class="card-text">${product.price}</p>
    
  <form id="contact-form" role="form"  method="post"  action="<c:url value='/panier/${product.id}/addpanier' />" >
   <div class="form-inline">
    <div class="form-group mb-2">
    <label for="form_lastname">quantite:</label>
      
<input  class="form-outline w-25 ml-2" type="number" name="qtestock"  placeholder="quantité*" value=0 >
               </div>    </div>                
       <input type="submit" class="btn mt-2  btn-primary"
                            value="Panier" ></form>
  </div>
</div> 
</div>
            </c:forEach>
               </div>
 
      </c:otherwise>
   </c:choose>
   </div>
</div>
</body>
</html>