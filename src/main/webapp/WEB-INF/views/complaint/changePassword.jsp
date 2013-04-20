<%-- 
    Document   : changePassword
    Created on : Apr 19, 2013, 5:13:02 PM
    Author     : Ratul
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
                var pdb= document.getElementById("p").value;
                var pnow= document.getElementById("desiredPassWord").value;
                if(pdb!=pnow){
                    alert('Pasword Not matching');
                }
            }
        </script>
    </head>
    <body background="https://lh5.googleusercontent.com/-IX-zJ1FhNl4/UXIyP04CJmI/AAAAAAAAAc4/8GjqT9_30-s/s902/image3.jpg" bgcolor='#E6E6E6'>
        <h1 align="center"><img src="http://www.nlcindia.com/images/nlc_logo3.jpg" width="75" height="70"><div style="font-family:verdana;padding:20px;border-radius:10px;border:10px solid #EE872A;"> <font color="grey">Welcome <u>${pass.name}</u> to NLC Password Change Page</font></div></h1><hr>
        <br>
        <table align="center" >
            <tbody >
                <%@include file="../common/header.jsp" %>
            <hr>
            </tbody>
            <table align="center">
                <sf:form commandName="pass">
                    <tr><td> Old Password:
                            <sf:password path="tempPassWord" maxlength="10" />${notUpdate}</td></tr>
                    <tr><td>New Password:
                            <input type="password"  name="po" id="p"/></td></tr>
                    <tr><td> Confirm Password:
                            <sf:password path="desiredPassWord" maxlength="10"/></td></tr>

                    <tr><td>   <input type="submit" value="Change" onclick="check()"/></td></tr>
                        </sf:form>
                <tr><td>${Update}<td></tr>
            </table>
        </table>
    </body>
</html>
