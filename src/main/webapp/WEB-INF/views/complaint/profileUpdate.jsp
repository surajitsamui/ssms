<%-- 
    Document   : profileUpdate
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

        
        <h1 align="center"><img src="http://www.nlcindia.com/images/nlc_logo3.jpg" width="75" height="70"><div style="font-family:verdana;padding:20px;border-radius:10px;border:10px solid #EE872A;"> <font color="grey">Welcome <u>${homePageS.name}</u> to NLC </font></h1></div><hr>

    <br>
    <table align="center" >
        <tbody >
            <%@include file="../common/header.jsp" %>
             
        <input type="button" value="Change Password" onclick="location='changePassword.htm';"/>${homePageS.name}
            
            <%--tr><td bgcolor="#FF9E0E" colspan="40" height="20" >
                    <input type="reset" value="Home" onclick="location = 'adminHomePage.htm';"/>
                </td>
                <td bgcolor="#FF9E0E" colspan="40" height="20">
                    <input type="reset" value="Complaints" onclick="location = 'adminViewCComplainDetails.htm';"/>
                </td>


                <td bgcolor="#FF9E0E" colspan="40" height="20">
                    <input type="reset" value="Log Out" onclick="location = 'index.jsp';"/>
                </td></tr--%>
        </tbody></table>
    <hr>

    <table  align="center">
        <tr><td><font color="grey"><u><b>Administrator ID:</b></u></font>      ${homePageS.userId}</td></tr>
<tr><td><font color="grey"><u><b>Administrator Name:</b></u></font>    ${homePageS.initial}${homePageS.name}</td></tr>
<tr><td><font color="grey"><u><b>Administrator Address : </b></u> </font>  ${homePageS.add}</td></tr>
<tr><td><font color="grey"><u><b>Administrator Mobile: </b></u> </font>${homePageS.mobile}</td></tr>
<tr><td><font color="grey"><u><b>Administrator E-Mail: </b></u></font> ${homePageS.eMail}</td></tr>
      
        <%--tr><td><font color="grey"><u><b>User Cat. : </b></u></font>  ${homePageS.adminUser}</td></tr--%>



</table><hr>

 <font color="red"><b><i> Change Your Detail ${homePageS.name}  </i></b></font>
        <table align="center">
          
            <sf:form commandName="userForm">


                <td><sf:hidden path="userId" value="${homePageS.userId}" />


                <tr><th>Name :</th>
                    <td> <sf:input path = "initial" value="${homePageS.initial}"/>
                            <%--sf:option value = "" label = ""/>
                            <sf:option value = "Mr." label = "Mr."/>
                            <sf:option value = "Ms." label = "Ms."/>
                            <sf:option value = "Mrs." label = "Mrs."/>
                        </sf:select--%>

                        <sf:input path="name" value="${homePageS.name}"/>
                        <sf:errors path="initial"/>
                        <sf:errors path="Name"/></td></tr>
                <tr><th>Address :</th>
                    <td><sf:input path="add" value="${homePageS.add}" rows="4" cols="20" />
                        <sf:errors path="add"/></td></tr>

                <tr><th>Mobile :</th>
                    <td><sf:input path="mobile" maxlength="10" value="${homePageS.mobile}"/>
                        <sf:errors path="mobile">Mobile No Should Be 10 Digit</sf:errors></td></tr>

                    <tr><th>E-Mail :</th>
                        <td><sf:input path="eMail" value="${homePageS.eMail}"/>
                        <sf:errors path="eMail"> Not Valid E mail</sf:errors></td></tr>
                
                    
                        <td><sf:hidden path="desiredPassWord" value="${homePageS.desiredPassWord}"/>
                        <sf:errors path="desiredPassWord"/></td></tr>
                
                    <td><sf:hidden path="tempPassWord" value="${homePageS.desiredPassWord}"/>
                        <sf:errors path="tempPassWord"/><sf:errors path="tempPassWord">Password Not Matching</sf:errors></td></tr>
                        <sf:hidden path="adminUser" value="${homePageS.adminUser}"/>


                <tr><td bgcolor="#FF9E0E" colspan="40" height="20" >
                        <input type="submit" value="Save"/></td>
                    
                    <td bgcolor="#FF9E0E" colspan="40" height="20" >
                        <input type="reset" value="Clear" onclick="location = 'adminProfileUpdate.htm';"/></td></tr>

            </sf:form>
                <td>${uupdatationComplete}</td>
                
           
        </table>
        <hr>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<font color="red" ><h3 align="right">~SSR</h3></font>
</body>
</html>
