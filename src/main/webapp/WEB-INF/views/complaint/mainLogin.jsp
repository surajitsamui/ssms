<%-- 
    Document   : mainLogin
    Created on : Apr 11, 2013, 1:05:04 PM
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
        <title>Log In</title>

    </head>

    <body bgcolor='#E6E6E6'>
        <h1 align="center"><img src="http://www.nlcindia.com/images/nlc_logo3.jpg" width="75" height="70"><div style="font-family:verdana;padding:20px;border-radius:10px;border:10px solid #EE872A;"><font color="grey">Welcome To NLC Online Complaint Registration System </font></div></h1><hr>
    <table align="center">
        <sf:form commandName="login">

            <tr><td> User ID. :
                    <sf:input path="userId" /><font color='red' ><b><i> *</i></b></font></td> </tr> 
            <tr><td> Password:
                    <sf:password path="desiredPassWord" /><font color='red' ><b><i> *</i></b></font></td> </tr>
                            <%--tr><td>  Type : <sf:select path="adminUser">
                                        <sf:option value = "0" label = "User"/>
                                        <sf:option value = "1" label = "Programmer"/>
                                        <sf:option value = "2" label = "Admin"/>
                                        <sf:errors path="userId">Invalid UserId / Password</sf:errors>
                                    </sf:select><font color='red' ><b><i> *</i></b></font></td> </tr--%>
            <font color='red' ><b><i>   ${error}</i></b></font>
            <td bgcolor="#FF9E0E" colspan="40" height="20">
                <input type="submit" value="Log in" />  
                <input type="reset" value="User Sign Up" onclick="location = 'userRegistration.htm';"/>
                <input type="reset" value="Clear" onclick="location = 'mainLogin.htm';"/></td>

        </sf:form>
    </table>

</body>
</html>
