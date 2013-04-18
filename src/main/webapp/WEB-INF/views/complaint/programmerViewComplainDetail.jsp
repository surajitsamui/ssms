<%-- 
    Document   : programmerViewComplainDetail
    Created on : Apr 13, 2013, 12:04:04 PM
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
    </head>
    <body bgcolor='#E6E6E6'>
        <h1 align="center"><img src="http://www.nlcindia.com/images/nlc_logo3.jpg" width="75" height="70"><div style="font-family:verdana;padding:20px;border-radius:10px;border:10px solid #EE872A;"> <font color="grey">Welcome <u>${homePageS.name}</u> to NLC Programmer Complaint Detail Page</font></h1></div><hr>

    <br>
    <table align="center" >
        <tbody >
            <%@include file="../common/header.jsp" %>
            <%--tr><td bgcolor="#FF9E0E" colspan="40" height="20" >
                    <input type="reset" value="Home" onclick="location = 'programmerHomePage.htm';"/>
                </td>
                <td bgcolor="#FF9E0E" colspan="40" height="20">
                    <input type="reset" value="Complaint" onclick="location = 'programmerViewComplain.htm';"/>
                </td>


                <td bgcolor="#FF9E0E" colspan="40" height="20">
                    <input type="reset" value="Log Out" onclick="location = 'index.jsp';"/>
                </td></tr--%>
        </tbody></table>
    <hr>

    <table  align="center">

        <c:forEach items="${complaint}" var="pcoml">

            <tr><td><font color="grey"><u><b>Complaint No : </b></u> </font>
            <a href="/programmerViewComplainDetail.htm?cmId=${pcoml.complaintNo}">${pcoml.complaintNo}</a></td></tr>

</c:forEach>
</table><hr>
<table align="center">
    <tr><td><font color="grey"><u><b>Complaint No : </b></u> </font>  ${detail.complaintNo}</td></tr>
<tr><td><font color="grey"><u><b>Complaint Type : </b></u> </font>  ${detail.complaintType}</td></tr>
<tr><td><font color="grey"><u><b>Complaint Description: </b></u> </font>${detail.complaintDesc}</td></tr>
<tr><td><font color="grey"><u><b>Complaint Date: </b></u></font> ${detail.complaintDate}</td></tr>
        <c:if test="${detail.adminStatus eq 'P'}">
        <tr><td><font color="grey"><u><b>Complaint Status: </b></u></font> Pending</td></tr>
        </c:if> 
            <c:if test="${detail.adminStatus eq 'S'}">
        <tr><td><font color="grey"><u><b>Complaint Status: </b></u></font> Solved</td></tr>
        </c:if> 

            <c:if test="${detail.adminStatus eq 'R'}">
        <tr><td><font color="grey"><u><b>Complaint Status: </b></u></font> Returned To Administrator</td></tr>
        </c:if> 


        <sf:form commandName="setval">
<tr><sf:hidden path="complaintNo" value="${detail.complaintNo}"/>
    <td>   <font color="grey"><u><b> Status: </b></u>
        <sf:select path="adminStatus">
            <sf:option value="S" label="Solved"/>
            <sf:option value="R" label="Return"/>
        </sf:select>
<input type="submit" value="Update"/>
</td></tr>
</sf:form>
</table>
</body>
</html>
