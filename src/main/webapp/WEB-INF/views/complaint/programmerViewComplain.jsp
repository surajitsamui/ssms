<%-- 
    Document   : programmerViewComplain
    Created on : Apr 11, 2013, 3:44:22 PM
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
    <body bgcolor='#E6E6E6'>

        <h1 align="center"><img src="http://www.nlcindia.com/images/nlc_logo3.jpg" width="75" height="70"> <div style="font-family:verdana;padding:20px;border-radius:10px;border:10px solid #EE872A;"><font color="grey">Welcome <u>${homePageS.name}</u> to NLC Programmer Complaint View Page</font></h1><hr></div>

    <br>
    <table align="center" >
        <tbody >
            <tr><td bgcolor="#FF9E0E" colspan="40" height="20" >
                    <input type="reset" value="Home" onclick="location = 'programmerHomePage.htm';"/>
                </td>
                <td bgcolor="#FF9E0E" colspan="40" height="20">
                    <input type="reset" value="Profile Update" onclick="location = 'pgmDetails.htm';"/>
                </td>
                <td bgcolor="#FF9E0E" colspan="40" height="20">
                    <input type="reset" value="Complaints" onclick="location = 'programmerViewComplain.htm';"/>
                </td>


                <td bgcolor="#FF9E0E" colspan="40" height="20">
                    <input type="reset" value="Log Out" onclick="location = 'index.jsp';"/>
                </td></tr>
        </tbody></table>
    <hr>

    <table  align="center">
        ${msz} 
        <c:forEach items="${complaint}" var="pcoml">

            <tr><td><font color="grey"><u><b>Complaint No : </b></u> </font>
            <a href="/programmerViewComplainDetail.htm?cmId=${pcoml.complaintNo}">${pcoml.complaintNo}</a></td></tr>

</c:forEach>


</table><hr>

</body>
</html>


