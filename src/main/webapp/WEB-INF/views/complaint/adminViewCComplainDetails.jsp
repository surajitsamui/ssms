<%-- 
    Document   : adminViewCComplainDetails
    Created on : Apr 13, 2013, 11:03:24 AM
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
    <body  bgcolor='#E6E6E6'>
        <h1 align="center"><img src="http://www.nlcindia.com/images/nlc_logo3.jpg" width="75" height="70"> <div style="font-family:verdana;padding:20px;border-radius:10px;border:10px solid #EE872A;"><font color="grey">Welcome <u>${homePageS.name}</u> to NLC Administrator Complaint Details View Page</font></h1></div<hr>
    <hr>

    <br><hr>
    <table align="center" >
        <tbody>
            <%@include file="../common/header.jsp" %> 
        </tbody></table>
    <hr><br>
    <table  align="left"  cellpadding="1" style="font-family:verdana;padding:20px;border-radius:10px;border:1px solid #EE872A;">

        <tbody>

            <%--div style="font-family:verdana;padding:20px;border-radius:10px;border:1px solid #EE872A;"--%>
            <tr>
                <td> <b> PENDING COMPLAINTS</b></td></tr>
            <tr>  <td>  <font color="grey"><u><b>Complained By</b></u></font></td>

    <td> <font color="grey"><u><b>Complaint No</b></u></font>  </td> 
<td>  <font color="grey"><u><b>Assigned To</b></u></font></td>
</tr>

<c:forEach items="${pending}" var="ff">
    <tr>  <td>  ${ff.name}</td>
        <td>  <a href="/adminViewCComplainDetails.htm?cId=${ff.complaintNo}">${ff.complaintNo}</a><br></td>
        <td>  ${ff.adminAsign}</td></tr>
    </c:forEach>
</tbody>       
</table>
<table  align="right"  cellpadding="1" style="font-family:verdana;padding:20px;border-radius:10px;border:1px solid #EE872A;">
    <tbody>

        
        <tr>
            <td>  <b> SOLVED COMPLAINTS</b></td></tr>
        <tr>

            <td>  <font color="grey"><u><b>Complained By</b></u></font></td>
<td> <font color="grey"><u><b>Complaint No</b></u></font>  </td> 
</tr>

<c:forEach items="${solved}" var="ff">
    <tr>  <td>  ${ff.name}</td>
        <td>  <a href="/adminViewCComplainDetails.htm?cId=${ff.complaintNo}">${ff.complaintNo}</a><br></td></tr>
        </c:forEach>
</tbody>       
</table>

<%--/div><div style="font-family:verdana;padding:20px;border-radius:10px;border:1px solid #EE872A;">shkdgfjdsf</div--%>


<table  align="center"  cellpadding="1" style="font-family:verdana;padding:20px;border-radius:10px;border:1px solid #EE872A;">
    <tbody>

        <%--div style="font-family:verdana;padding:20px;border-radius:10px;border:1px solid #EE872A;"--%>
        <tr>
            <td>  <b> UNSOLVED COMPLAINTS</b></td></tr>
        <tr>
            <td>  <font color="grey"><u><b>Complained By</b></u></font></td>
<td> <font color="grey"><u><b>Complaint No</b></u></font>  </td> 
</tr>

<c:forEach items="${unsolved}" var="ff">
    <tr>  <td>  ${ff.name}</td>
        <td>  <a href="/adminViewCComplainDetails.htm?cId=${ff.complaintNo}">${ff.complaintNo}</a><br></td></tr>
        </c:forEach>
</tbody>       
</table ><hr>
<table  align="center"  style="font-family:verdana;padding:20px;border-radius:10px;border:1px solid #EE872A;">


    <tr><td><font color="grey"><u><b>Complaint No : </b></u> </font>  ${detail.complaintNo}</td></tr>
<tr><td><font color="grey"><u><b>Complaint Type : </b></u> </font>  ${detail.complaintType}</td></tr>
<tr><td><font color="grey"><u><b>Complaint Description: </b></u> </font>${detail.complaintDesc}</td></tr>
<tr><td><font color="grey"><u><b>Complaint Date: </b></u></font> ${detail.complaintDate}</td></tr>
<tr><td><font color="grey"><u><b>Complaint Status: </b></u></font> ${detail.adminStatus}</td></tr>
        <%--tr><td><font color="grey"><u><b>Solved Date: </b></u></font> ${detail.complaintSolved}</td></tr--%>
        <c:if test="${detail.adminStatus ne 'S'}">
            <sf:form commandName="detail">
<tr><sf:hidden path="complaintNo" value="${detail.complaintNo}"/>
    <td><font color="grey"><u><b>Programmer to Assign: </b></u></font> 
        <sf:select path="adminAsign">
            <sf:options items="${prog}" />
        </sf:select>
</td>
</tr>

<tr><td><td><input type="submit" value="Asign"/></td></tr>
    </sf:form>
</c:if>
${mszz}
</table>

<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<font color="red" ><h3 align="right">~SSR</h3></font>

</body>
</html>

