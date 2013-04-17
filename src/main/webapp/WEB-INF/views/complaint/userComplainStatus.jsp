<%-- 
    Document   : userComplainStatus
    Created on : Apr 11, 2013, 1:23:05 PM
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
        <title>Complaint status Page</title>
    </head>
    <body bgcolor='#E6E6E6'>
        <h1 align="center"><img src="http://www.nlcindia.com/images/nlc_logo3.jpg" width="75" height="70"> <div style="font-family:verdana;padding:20px;border-radius:10px;border:10px solid #EE872A;"><font color="grey">Welcome <u>${homePageS.name}</u> to NLC User Home Page</font></h1></div><hr>

    <br>
    <table align="center" >
        <tbody >
            <tr><td bgcolor="#FF9E0E" colspan="40" height="20" >
                    <input type="reset" value="Home" onclick="location = 'userHomePage.htm';"/>
                </td>
                <td bgcolor="#FF9E0E" colspan="40" height="20">
                    <input type="reset" value="New Complaint" onclick="location = 'userComplaint.htm';"/>
                </td>
                <td bgcolor="#FF9E0E" colspan="40" height="20">
                    <input type="reset" value="Status" onclick="location = 'userComplainStatus.htm';"/>
                </td>

                <td bgcolor="#FF9E0E" colspan="40" height="20">
                    <input type="reset" value="Log Out" onclick="location = 'index.jsp';"/>
                </td></tr>
        </tbody></table>
    <hr>
    <%--<c:forEach items="${status}" var="ss">
        ${ss.complaintDesc}
</c:forEach>--%>


<font color="grey"><u><h2>PENDING COMPLAINTS :</h2></u></font>
<table  align="center">

    <tr> <td>  <font color="grey"><u><b>Complaint No</b></u></font> </td>
<td>  <font color="grey"><u><b>Complaint Description</b></u></font> </td>
<td>  <font color="grey"><u><b>Complaint type</b></u></font> </td></tr>


<c:forEach items="${statusPendingUnsolved}" var="ss">
    <tr>  <td>${ss.complaintNo}</td>
        <td>     ${ss.complaintDesc}</td>
        <td>     ${ss.complaintType}</td>


        <%--sf:form commandName="feedback">
            
            <td> <sf:input path="userFeedback"/></td>
            
            <sf:hidden path="complaintNo" value="${ss.complaintNo}"/>
            <td><input type="submit" value="Submit Feedback"/></td>
        </sf:form--%>

    </tr>

</c:forEach>

</table><hr><br>
<font color="grey"><u><h2>SOLVED COMPLAINTS :</h2></u></font>

<table  align="center">

    <tr> <td>  <font color="grey"><u><b>Complaint No</b></u></font> </td>
<td>  <font color="grey"><u><b>Complaint Description</b></u></font> </td>
<td>  <font color="grey"><u><b>Complaint type</b></u></font> </td>

<td>  <font color="grey"><u><b>Feedback</b></u></font> </td></tr>

${msgz}
<c:forEach items="${statusSolved}" var="sss">
    <tr>  <td>${sss.complaintNo}</td>
        <td>     ${sss.complaintDesc}</td>
        <td>     ${sss.complaintType}</td>



        <sf:form commandName="feedback">

            <td> <sf:input path="userFeedback"/></td>

            <sf:hidden path="complaintNo" value="${ss.complaintNo}"/>
            <td><input type="submit" value="Submit Feedback"/></td>
            </sf:form>

    </tr>

</c:forEach>

</table><hr>

</body>
</html>
