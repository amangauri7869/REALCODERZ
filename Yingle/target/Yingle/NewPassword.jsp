<%-- 
    Document   : NewPassword
    Created on : 29 May, 2020, 5:44:42 PM
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
         <h2>New Password</h2>
<%
String email=(String)session.getAttribute("email");
        System.out.println(email);
%>
<form action="CheckPassword" method="post">
  

  <div class="container">
    <label for="uname"><b>New Password</b></label>
    <input type="password" placeholder="Enter New Password" name="pass1" required>
    
    <label for="uname"><b>Confirm New Password</b></label>
    <input type="password" placeholder="Enter Confirm Password" name="pass2" required>

    <button type="submit" onclick="cnf()">Submit</button>
    
  </div>
</form>
          
    </body>
</html>
