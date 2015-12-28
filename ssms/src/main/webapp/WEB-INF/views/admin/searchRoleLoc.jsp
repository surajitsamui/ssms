<%-- 
    Document   : searchRoleLoc
    Created on : 28 Nov, 2012, 6:44:36 PM
    Author     : sintu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <title>JSP Page</title>
        <script type="text/javascript" src="/scripts/jquery.min.js"></script>
        <script>
            function putValue(roleLocId,roleName,locName){
                var index=self.opener.rowIndex;                
                $("[id='wflst"+index+".rolelocDesc']",opener.document).val(roleName+" .... "+ locName);
                $("[id='wflst"+index+".roleLocId']",opener.document).val(roleLocId);
                self.close();
            }
        </script>
    </head>
    <body>
        <table>
            <thead width="80%" border="0">
                <tr>
                    <th>Role Name </th>
                    <th>Location Description</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${roleloclist}" var="doc">
                    <tr>
                        <td><a href="javascript:putValue('${doc.roleLocId}','${doc.roleDesc}','${doc.locDesc}')">${doc.roleDesc}</a></td>
                        <td><a href="javascript:putValue('${doc.roleLocId}','${doc.roleDesc}','${doc.locDesc}')">${doc.locDesc}</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
