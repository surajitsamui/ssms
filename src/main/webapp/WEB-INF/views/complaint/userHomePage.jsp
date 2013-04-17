<%-- 
    Document   : userHomePage
    Created on : Apr 12, 2013, 11:58:59 AM
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
        
    <table  align="center">
                <tr><td><font color="grey"><u><b>User ID:</b></u></font>      ${homePageS.userId}</td></tr>
                <tr><td><font color="grey"><u><b>User Name:</b></u></font>    ${homePageS.initial}${homePageS.name}</td></tr>
                <tr><td><font color="grey"><u><b>User Add : </b></u> </font>  ${homePageS.add}</td></tr>
                <tr><td><font color="grey"><u><b>User Mobile: </b></u> </font>${homePageS.mobile}</td></tr>
                <tr><td><font color="grey"><u><b>User E-Mail: </b></u></font> ${homePageS.eMail}</td></tr>
                <%--tr><td><font color="grey"><u><b>User Cat. : </b></u></font>  ${homePageS.adminUser}</td></tr--%>

            
            
        </table><hr>
    </body>
</html>
