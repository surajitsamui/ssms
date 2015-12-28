<%-- 
    Document   : vendor
    Created on : 23 Sep, 2012, 2:26:33 PM
    Author     : srini
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
        <sf:form commandName="ven" action="/vendor/vendor.htm">
            <table>
                <tr>
                    <td>Code</td><td><sf:input path="code"/></td>
                    <td>name</td><td><sf:input path="name"/></td>
                    <td>address</td><td><sf:input path="address"/></td>
                    <td>city</td><td><sf:input path="city"/></td>                
                </tr>
            </table>
            <input type="submit" value="save">
        </sf:form>
    </body>
</html>

