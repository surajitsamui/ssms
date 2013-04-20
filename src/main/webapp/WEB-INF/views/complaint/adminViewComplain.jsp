<%-- 
    Document   : adminViewComplain
    Created on : Apr 11, 2013, 12:32:43 PM
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
        <title>Home Page</title>
    </head>
    <body  bgcolor='#E6E6E6'>
        <h1 align="center"><img src="http://www.nlcindia.com/images/nlc_logo3.jpg" width="75" height="70"> <div style="font-family:verdana;padding:20px;border-radius:10px;border:10px solid #EE872A;"><font color="grey">Welcome <u>${homePageS.name}</u> to NLC Administrator Complaints </font></h1></div><hr>

    <br>
    <table align="center" >
        <tbody >
            <tr><td bgcolor="#FF9E0E" colspan="40" height="20" >
                    <input type="reset" value="Home" onclick="location = 'adminHomePage.htm';"/>
                </td>
        <li>    <td bgcolor="#FF9E0E" colspan="40" height="20">
            <input type="reset" value="Complaints" onclick="location = 'adminViewComplain.htm';"/>
        </td></li>


    <td bgcolor="#FF9E0E" colspan="40" height="20">
        <input type="reset" value="Log Out" onclick="location = 'index.jsp';"/>
    </td></tr>
</tbody></table>
<hr>

<table  align="center">
    ${mszz}
    <td>  <font color="grey"><u><b>User ID</b></u></font></td>
<td>  <font color="grey"><u><b>Complaint No</b></u></font> </td>  
    <c:forEach items="${comp}" var="ff">
<tr>  <td>     ${ff.complaintUserId} </td>
    <td>    <a href="/adminViewCComplainDetails.htm?cId=${ff.complaintNo}">${ff.complaintNo}</a></td></tr>
        <%--tr><td><font color="grey"><u><b>Complaint Type : </b></u> </font>  ${ff.complaintType}</td></tr>
        <tr><td><font color="grey"><u><b>Complaint Description: </b></u> </font>${ff.complaintDesc}</td></tr>
        <tr><td><font color="grey"><u><b>Complaint Date: </b></u></font> ${ff.complaintDate}</td></tr>
        <%--tr><td><font color="grey"><u><b>User Cat. : </b></u></font>  ${homePageS.adminUser}</td></tr--%>


</c:forEach>
</table><hr>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<font color="red" ><h3 align="right">~SSR</h3></font>

</body>
</html>

