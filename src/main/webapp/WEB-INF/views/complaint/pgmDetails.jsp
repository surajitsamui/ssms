<%-- 
    Document   : pgmDetails
    Created on : Apr 11, 2013, 3:33:29 PM
    Author     : Sintu Pal
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
        <title>Programmer details</title>
    </head>
    <body  bgcolor='#E6E6E6'>
        <h1 align="center"><img src="http://www.nlcindia.com/images/nlc_logo3.jpg" width="75" height="70"><div style="font-family:verdana;padding:20px;border-radius:10px;border:10px solid #EE872A;"> <font color="grey">Welcome <u>${homePageS.name}</u> to NLC Programmer Update Detail Page</font></h1></div><hr>

    <br>
    <table align="center" >
        <tbody >
            <%@include file="../common/header.jsp" %>
            <%--tr><td bgcolor="#FF9E0E" colspan="40" height="20" >
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
                </td></tr--%>
        </tbody></table>
    <hr>
    <table align="center">
        <sf:form commandName="pgm">        



            <td><sf:hidden path="ProgrammerName" value="${userProgrLink.name}"/> <font color="red"> <sf:errors path="ProgrammerName"/> </font></td>

            <tr>
                <th>Programmer Specialization</th>
                <td><sf:input path="ProgrammerSpecl" /><font color="red"> <sf:errors path="ProgrammerSpecl"/> </font></td>
            </tr>
            <tr>
                <th>Programmer Experience</th>
                <td><sf:input path="ProgrammerExperience" /><font color="red"> <sf:errors path="ProgrammerExperience"/> </font></td>
            </tr>


            <td><sf:hidden path="ProgrammerMobileNo" value="${userProgrLink.mobile}"/><font color="red"> <sf:errors path="ProgrammerMobileNo">Enter Valid Mobile No</sf:errors> </font></td>



            <sf:hidden path="ProgrammerEmailId" value="${userProgrLink.eMail}"/><font color="red"> <sf:errors path="ProgrammerEmailId"/> </font>

            <tr><td bgcolor="#FF9E0E" colspan="40" height="20">
                    <input type="submit" value="Save"/></td>
                <td bgcolor="#FF9E0E" colspan="40" height="20">
                    <input type="button" value="Home" onclick="location = 'programmerHomePage.htm';"/></td>
                <td bgcolor="#FF9E0E" colspan="40" height="20">
                    <input type="reset" value="Clear" onclick="location = 'pgmDetails.htm';"/></td></tr>



        </sf:form>
    </table>
    <hr>

    <%--table>
        <thead>
            <tr>
                <th>Programmer Name</th>
                <th>Programmer Specl</th>
                <th>Programmer Experience</th>
                <th>Programmer MobileNo</th>
                <th>Programmer EmailId</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${list}" var="eachPgm">
                <tr>
                    <td><a href="/pgmDetails.htm?name=${eachPgm.ProgrammerName}">${eachPgm.ProgrammerName}</a></td>
                    <td>${eachPgm.ProgrammerSpecl}</td>
                     <td>${eachPgm.ProgrammerExperience}</td> 
                     <td>${eachPgm.ProgrammerMobileNo}</td> 
                    <td>${eachPgm.ProgrammerEmailId}</td>
                    </tr>
            </c:forEach>
        </tbody--%>


</table>




</body>
</html>
