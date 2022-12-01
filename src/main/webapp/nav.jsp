<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <nav class="navbar navbar-expand-lg  navbar-dark bg-dark" style="background-color: #e3f2fd">
 <div class="container">
  <a class="navbar-brand" href="#">Market</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
    
      <li class="nav-item active">
        <a class="nav-link" href="<c:url value='/Pro' />">Products</a>
        
      </li>
         <c:choose>
      
       <c:when test="${iduser == null}">
       <li class="nav-item active">
        <a class="nav-link" href="<c:url value='/formlogin.jsp' />">login</a>
        
      </li>
           <li class="nav-item active">
        <a class="nav-link disabled" href="<c:url value='/formregister.jsp' />">register</a>
      </li>
     </c:when>
           <c:otherwise>
            <c:choose>
             <c:when test="${iduser ==6}">
             <li class="nav-item active">
        <a class="nav-link disabled" href="<c:url value='/user/users' />">Client</a>
      </li></c:when>
        <c:otherwise>
          <li class="nav-item active">
        <a class="nav-link disabled" href="<c:url value='/panier' />">Panier</a>
      </li>
        </c:otherwise></c:choose>
           <li class="nav-item active">
        <a class="nav-link disabled" href="<c:url value='/user/logout' />">Logout</a>
      </li>
   
     </c:otherwise>
     </c:choose>
 
    </ul>

  </div>
   </div>
</nav>
</body>
</html>