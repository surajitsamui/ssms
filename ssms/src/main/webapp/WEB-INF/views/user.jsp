<%-- 
    Document   : user
    Created on : Dec 8, 2015, 2:53:03 AM
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
        <title>JSP Page</title>
    </head>
    <body>
        <h1></h1>
        <sf:form commandName="user" action="/user/user.htm">
            <table align="center">
                <tr>
                    <td>User ID</td><td><sf:input path="userId"/></td>
                    <td>Initial</td><td><sf:input path="initial"/></td>
                </tr>
                <tr>
                    <td>Name</td><td><sf:input path="name"/></td>
                    <td>Address</td><td><sf:input path="add"/></td>
                </tr>
                <tr> 
                    <td>Mobile No</td><td><sf:input path="mobile"/></td>
                    <td>Email Id</td><td><sf:input path="eMail"/></td>
                </tr>
                <tr>
                    <td>Password</td><td><sf:input path="desiredPassWord"/></td>
                    <td>Confirm PassWord</td><td><sf:input path="tempPassWord"/></td></tr> 
                <tr>  
                    <td>User Type</td><td><sf:input path="adminUser"/></td>
                </tr>
            </table>
        <center><input type="submit" value="save"></center>
        </sf:form>
    </body>
</html>