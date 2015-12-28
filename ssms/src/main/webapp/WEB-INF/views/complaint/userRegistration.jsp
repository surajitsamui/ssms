<%-- 
    Document   : userRegistration
    Created on : Apr 10, 2013, 3:08:06 PM
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
        <h1><img src="http://2.bp.blogspot.com/-3W2_broPZDU/UBH122OZhYI/AAAAAAAABPA/kTfjX1isTMk/s1600/NLC-India-Logo.png" width="75" height="50"><font color="grey">Fill Up The Form to Register</font></h1><hr>

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
                        <sf:hidden path="adminUser" value="0"/>


                <tr><td bgcolor="#FF9E0E" colspan="40" height="20" >
                        <input type="submit" value="Save"/></td>
                    <td bgcolor="#FF9E0E" colspan="40" height="20" >
                        <input type="reset" value="Home" onclick="location = 'index.jsp';"/></td>
                    <td bgcolor="#FF9E0E" colspan="40" height="20" >
                        <input type="reset" value="Clear" onclick="location = 'userRegistration.htm';"/></td></tr>

            </sf:form>
            <h3 align="center">${userCountShow}</h3>
        </table>
        <hr>
        
    </body>
</html>