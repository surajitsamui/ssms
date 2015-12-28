<%-- 
    Document   : documentForm
    Created on : 28 Nov, 2012, 10:29:48 AM
    Author     : samim
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Location Master-JSP Page</title>
        <script type="text/javascript" language="javascript" src="/scripts/jquery.min.js"></script>
        <link rel="stylesheet" href="/css/ccms.css" type="text/css">
        <link rel="stylesheet" href="/css/olimms.css" type="text/css">
        <script type="text/javascript">
            
            function deletedocument(lId){
                if(window.confirm("are you sure?")){
                    window.location="/admin/DeleteDocument.htm?docId=" + lId;
                }
                $('input:checkbox').removeAttr('checked');
            }
            
        </script>
    </head>
    <body>
        <sf:form commandName="doc"> <br><br>
            <table id="searchResult" border="1" align="center">
                <caption>Document Master</caption>
                <colgroup>
                    <col width="15%">
                    <col width="20%">
                    <col width="15%">
                    <col width="40%">
                </colgroup>
                <tr>
                    <th>Document Id</th>
                    <td><sf:input path="docId" size="30"/></td>
                    <th>Document Name</th>
                    <td><sf:input path="docName" size="80" /></td>
                </tr>
            </table><br>
            <p align="center">
                <input type="submit" value="Save" name="Save">
                <input type="reset" value="Reset" name="Reset">
            </p>
        </sf:form>
        <table id="searchResult" width="90%" border="1" align="center">
            <br><br>
            <colgroup>
                <col width="10%">
                <col width="75%">
                <col width="5%">
            </colgroup>
            <thead>
                <tr>
                    <th>Document Id</th>
                    <th>Document Name </th>
                    <th>DELETE</th>
                </tr>
            </thead>    
            <c:choose>
                <c:when test="${not empty docList}">
                    <c:forEach var="document" items="${docList}" varStatus="row">
                        <tr>
                            <td>${document.docId}</td>                            
                            <td>${document.docName}</td>
                            <td><input type="checkbox" name="deleted" id="deleted" onclick="deletedocument(${document.docId})"> </td>
                        </tr>
                    </c:forEach>
                </c:when>
                <c:otherwise><td colspan="3" id="txtcols"><b style="font-size: 13px">No Record found </b></td></c:otherwise>
            </c:choose>
        </table><br>

    </body>
</html>