<%-- 
    Document   : forgotpass
    Created on : 27 May, 2020, 8:55:30 AM
    Author     : AMAN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
body {font-family: Arial, Helvetica, sans-serif;}
form {border: 3px solid #f1f1f1;}

input[type=text], input[type=password] {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  box-sizing: border-box;
}

button {
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
}

button:hover {
  opacity: 0.8;
}




.container {
  padding: 16px;
}

span.psw {
  float: right;
  padding-top: 16px;
}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
  span.psw {
     display: block;
     float: none;
  }

}
</style>
    </head>
    <body>
        <h2>Forgot password</h2>

<form action="FPcode" method="post">
  

  <div class="container">
    <label for="uname"><b>Email</b></label>
    <input type="email" placeholder="Enter email" name="email" required>

    <button type="submit" onclick="display()">Submit</button>
    <p style="color: tomato;">*If email not received please check your email and try again</p>
  </div>
</form>
        <%
        String email=(String)session.getAttribute("email");
        System.out.println(email);
        
        %>
        <form action="Code" method="post">
<div class="container">
    <label for="uname"><b>code</b></label>
    <input type="text" placeholder="Enter code" name="code" required>

    <button type="submit">Submit</button>
    
  </div>
  
</form>
        <script>
            function display()
            {
                alert("Kindly check your email ");
            }
            
          
        </script>
    </body>
</html>
