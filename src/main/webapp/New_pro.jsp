<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head> 
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
</head>
<body>
<div class="container">
        <div class=" text-center mt-5 ">

            <h1 >New Product Form</h1>
                
            
        </div>

    
    <div class="row ">
      <div class="col-lg-7 mx-auto">
        <div class="card mt-2 mx-auto p-4 bg-light">
            <div class="card-body bg-light">
       
            <div class = "container">
            <form id="contact-form" role="form"  method="post" action="<c:url value='/Pro/produits/addpro' />" >

            

            <div class="controls">

                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="form_name">name *</label>
                            <input id="form_name" type="text" name="name" class="form-control" placeholder="Please enter your firstname *" required="required" data-error="Firstname is required.">
                            
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="form_lastname">qtestock</label>
                            <input id="form_lastname" type="number" name="qtestock" class="form-control" placeholder="Please enter your lastname *" required="required" data-error="Lastname is required.">
                                                            </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="form_email">price *</label>
                            <input id="form_email" type="number" name="price" class="form-control" placeholder="Please enter your email *" required="required" data-error="Valid email is required.">
                            
                        </div>
                    </div>
                     <div class="col-md-6">
                        <div class="form-group">
                            <label for="form_email">codeimge *</label>
                            <input id="form_email" type="text" name="codeimg" class="form-control" placeholder="Please enter your email *" required="required" data-error="Valid email is required.">
                            
                        </div>
                    </div>
               
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <div class="form-group">
                            <label for="form_message">description *</label>
                            <textarea id="form_message" name="description" class="form-control" placeholder="Write your message here." rows="4" required="required" data-error="Please, leave us a message."></textarea
                                >
                            </div>

                        </div>


                    <div class="col-md-12">
                        
                        <input type="submit" class="btn btn-success btn-send  pt-2 btn-block
                            " value="Send " >
                    
                </div>
          
                </div>


        </div>
         </form>
        </div>
            </div>


    </div>
        <!-- /.8 -->

    </div>
    <!-- /.row-->

</div>
</div>

</body>
</html>