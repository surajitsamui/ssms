<%-- 
    Document   : userComplaint
    Created on : Apr 10, 2013, 4:27:03 PM
    Author     : Samim
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
        <title>Complaint Page</title>
    </head>
    <body bgcolor='#E6E6E6'>
        <h1 align="center"><img src="http://www.nlcindia.com/images/nlc_logo3.jpg" width="75" height="70"> <font color="grey">Welcome <u>${userId.name}</u> to NLC User Home Page</font></h1><hr>

        <br>
        <table align="center" >

            <tbody >
                <%@include file="../common/header.jsp" %>
                <%--tr>
                    <td bgcolor="#FF9E0E" colspan="40" height="20" >   <c:forEach items="${menu}" var="map">
                <input type="button" value="${map.key}" onclick="location ='${map.value}';"/>
                        </c:forEach></td></tr--%>
            <%--td bgcolor="#FF9E0E" colspan="40" height="20" >
                <input type="reset" value="Home" onclick="location = 'userHomePage.htm';"/>
            </td--%>

            <%--td bgcolor="#FF9E0E" colspan="40" height="20">
                <input type="reset" value="Status" onclick="location = 'userComplainStatus.htm';"/>
            </td--%>

            <%--td bgcolor="#FF9E0E" colspan="40" height="20">
                <input type="reset" value="Log Out" onclick="location = 'index.jsp';"/>
            </td></tr--%>
    </tbody></table>
<hr>
<sf:form commandName="usercompl">
    <table align="center">
        <tr>

            <td>
                <sf:hidden path="complaintNo" value="${complno}"/>
            </td>
        </tr>

        <sf:hidden path="complaintUserId" value="${userId.userId}" />


        <tr>
            <th>Complaint Type</th>
            <td>
                <sf:select path = "complaintType" >
                    <sf:option value = "" label = ""/>
                    <sf:option value = "HARDWARE" label = "HARDWARE"/>
                    <sf:option value = "SOFTWARE" label = "SOFTWARE"/>
                    <sf:option value = "BATTERY" label = "BATTERY"/>
                </sf:select>
                <sf:errors path="complaintType"/>
            </td>
        </tr>

        <tr>
            <th>Complaint Description</th>
            <td>
                <sf:textarea path="complaintDesc" rows="5" cols="15"/>
                <sf:errors path="complaintDesc"/>
            </td>
        </tr>

        <tr><td bgcolor="#FF9E0E" colspan="40" height="20">  
                <input type="submit" value="Submit"> </td>
            <td bgcolor="#FF9E0E" colspan="40" height="20">
                <input type="reset" value="Clear" onclick="location = 'userComplaint.htm';"></td>
        </tr> 

    </table>
</sf:form>
<h3 align="center">  ${comNoGen}</h3>
</body>
</html>
