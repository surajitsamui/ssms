<%-- 
    Document   : searchDocLoc
    Created on : 28 Nov, 2012, 6:44:10 PM
    Author     : sintu
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
            function putValue(docLocId,docId,docName,locId,locName){     
                $("#docId",opener.document).val(docId);
                $("#docName",opener.document).val(docName);
                $("#locId",opener.document).val(locId);
                $("#locDesc",opener.document).val(locName);
                $("#docLocId",opener.document).val(docLocId);
                self.opener.document.forms[0].submit();
                self.close();
            }
        </script>
    </head>
    <body>
        <table class="searchResult1" align="center" border="1" cellspacing="0" cellpadding="0">
            <thead>
                <tr>
                    <th>Document Name </th>
                    <th>Location Description</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${docloclist}" var="doc">
                    <tr>
                        <td><a href="javascript:putValue('${doc.docLocId}','${doc.docId}','${doc.docName}','${doc.locId}','${doc.locName}')">${doc.docName}</a></td>
                        <td><a href="javascript:putValue('${doc.docLocId}','${doc.docId}','${doc.docName}','${doc.locId}','${doc.locName}')">${doc.locName}</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
