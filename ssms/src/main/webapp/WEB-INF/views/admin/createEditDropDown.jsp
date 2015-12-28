<%-- 
    Document   : createEditDropDown
    Created on : 21 May, 2013, 1:43:32 AM
    Author     : ratul
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="st" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="/css/olimms.css" type="text/css">
        <link rel="stylesheet" href="/css/ccms.css" type="text/css">
        <script type="text/javascript" language="javascript" src="/scripts/jquery.min.js"></script>
    </head>
    <body width="70%">
       
        <sf:form commandName="listDropDown" method="POST">
            <table id="searchResult" border="1">
                <caption>Choose your option for Drop Down </caption>
                <tbody align="center">
                    <th>Sl. No</th>
                <th>Drop Down</th>
                            <c:forEach items="${listDropDown}" var="lst" varStatus="idx">
                           <tr> <td>  ${idx.index+1} </td>
                            <td><a href="/dropDownForm/dCode/${lst.id}">${lst.dname}</a></td><br>
                </tr>            
                </c:forEach>
                        
                    
                </tbody>
            </sf:form>

        </table>
    </body>
</html>
