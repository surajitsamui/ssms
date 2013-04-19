<%-- 
    Document   : changePassword
    Created on : Apr 19, 2013, 5:13:02 PM
    Author     : mmc-pc1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="st" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
        <script>
            function check(){
             var pdb= document.getElementById("${pass.desiredPassWord}").value;
             var pnow= document.getElementById("p").value;
             if(pdb!=pnow){
                 window.location="/changePassword.htm";
             }
            }
        </script>
    </head>
    <body bgcolor='#E6E6E6'>

        
        <h1 align="center"><img src="http://www.nlcindia.com/images/nlc_logo3.jpg" width="75" height="70"><div style="font-family:verdana;padding:20px;border-radius:10px;border:10px solid #EE872A;"> <font color="grey">Welcome <u>${pass.name}</u> to NLC Password Change Page</font></div></h1><hr>

    <br>
    <table align="center" >
        <tbody >
            <%@include file="../common/header.jsp" %>
        <hr>
         </tbody>
         <table align="center">
            
             <
             <tr><td>Old Password: <input type="password"  id ="p" onblur="check()"/></td>
             <sf:form commandName="pass">
                 <tr><td>New Password:
                         <sf:password path="desiredPassWord" maxlength="10" /></td></tr>
                 <tr><td>Confirm Password:
                         <sf:password path="tempPassWord" maxlength="10"/></td></tr>
             </sf:form>
                 <input type="submit" 
         </table>
    </table>
    </body>
</html>
