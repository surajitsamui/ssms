<%-- 
    Document   : branchForm
    Created on : 1 Dec, 2012, 7:37:57 PM
    Author     : samim
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="/css/olimms.css" type="text/css">
        <link rel="stylesheet" href="/css/ccms.css" type="text/css">
        <title>JSP Page</title>
        <script type="text/javascript" src="/scripts/jquery.min.js"></script>
        <script type="text/javascript">
            function putValue(docLocId){  
                var index=self.opener.rowIndex;
                $("[id='wflst"+index+".branchDocLocId']",opener.document).val(docLocId);
                self.close();
            }
        </script>
    </head>
    <body>
        <table class="searchResult1" align="center" border="1" cellspacing="0" cellpadding="0">
            <thead>
                <tr>
                    <th>Role Name </th>
                    <th>Location Description</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${branchList}" var="doc">
                    <tr>
                        <td><a href="javascript:putValue('${doc.docLocId}')">${doc.docName}</a></td>
                        <td><a href="javascript:putValue('${doc.docLocId}')">${doc.locName}</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>

