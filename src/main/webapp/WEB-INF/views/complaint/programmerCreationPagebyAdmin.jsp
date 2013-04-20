<%-- 
    Document   : programmerCreationPagebyAdmin
    Created on : Apr 19, 2013, 9:23:57 AM
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
        <title>Detail User Information</title>
    </head>
    <body  bgcolor='#E6E6E6'>
         <h1 align="center"><img src="http://www.nlcindia.com/images/nlc_logo3.jpg" width="75" height="70"><div style="font-family:verdana;padding:20px;border-radius:10px;border:10px solid #EE872A;"> <font color="grey">Welcome <u>${homePageS.name}</u> to NLC Programmer Complaint Detail Page</font></div></h1><hr>
        <%@include file="../common/header.jsp" %>
        <h1><font color="grey">Fill Up The Form to Register a Programmer</font></h1><hr>

        <font color="red"><b><i> Welcome to NLC  </i></b></font>
        <table align="center">
            <sf:form commandName="userForm">


                <td><sf:hidden path="userId" value="${usrCont}" />


                <tr><th>Name :</th>
                    <td> <sf:select path = "initial" >
                            <sf:option value = "" label = ""/>
                            <sf:option value = "Mr." label = "Mr."/>
                            <sf:option value = "Ms." label = "Ms."/>
                            <sf:option value = "Mrs." label = "Mrs."/>
                        </sf:select>

                        <sf:input path="name" />
                        <sf:errors path="initial"/>
                        <sf:errors path="Name"/></td></tr>
                <tr><th>Address :</th>
                    <td><sf:textarea path="add" rows="4" cols="20"/>
                        <sf:errors path="add"/></td></tr>

                <tr><th>Mobile :</th>
                    <td><sf:input path="mobile" maxlength="10" />
                        <sf:errors path="mobile">Mobile No Should Be 10 Digit</sf:errors></td></tr>

                    <tr><th>E-Mail :</th>
                        <td><sf:input path="eMail" />
                        <sf:errors path="eMail"> Not Valid E mail</sf:errors></td></tr>
                    <tr><th>Password :</th>
                        <td><sf:password path="desiredPassWord" />
                        <sf:errors path="desiredPassWord"/></td></tr>
                <tr><th>Confirm :</th>
                    <td><sf:password path="tempPassWord" />
                        <sf:errors path="tempPassWord"/><sf:errors path="tempPassWord">Password Not Matching</sf:errors></td></tr>
                        <sf:hidden path="adminUser" value="1"/>


                <tr><td bgcolor="#FF9E0E" colspan="40" height="20" >
                        <input type="submit" value="Save"/></td>
                    
                    <td bgcolor="#FF9E0E" colspan="40" height="20" >
                        <input type="reset" value="Clear" onclick="location = 'programmerCreationPagebyAdmin.htm';"/></td></tr>

            </sf:form>
           ${userCountShow}
        </table>
        <hr>
        <%--table>
            <hr>
            <tr>
                <th>User ID </th>
                <th>User Name</th>
                <th>User_Name</th>
                <th>Password</th>
                <th>Address</th>
                <th>Age</th>
                <th>Sex</th>
                <th>Mobile No</th>
                <th>E-Mail</th>

            </tr>
            <c:forEach items="${userList}" var="userEach">
                <tbody>   
                <td> <a href="/userRegistration.htm?userId=${userEach.userId}">${userEach.userId}</a></td>

            </tbody>
        </c:forEach>
    </table--%>
    </body>
</html>
