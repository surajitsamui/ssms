<%-- 
    Document   : docLocMapForm
    Created on : 28 Nov, 2012, 10:54:18 AM
    Author     : samim
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Document Location Entry Page</title>
        <script type="text/javascript" language="javascript" src="/scripts/jquery.min.js"></script>
        <link rel="stylesheet" href="/css/ccms.css" type="text/css">
        <link rel="stylesheet" href="/css/olimms.css" type="text/css">
        <script type="text/javascript">
            
            function deleteDocLoc(rlId){
                if(window.confirm("are you sure?")){
                    window.location="/admin/deleteDocLoc.htm?doclocId=" + rlId;
                }
                $('input:checkbox').removeAttr('checked');
            }
            
        </script>
    </head>
    <body>
        <sf:form commandName="docLoc"><br><br>
            <table id="searchResult" border="1" align="center">
                <caption>Document Location Map</caption>
                <colgroup>
                    <col width="15%">
                    <col width="30%">
                    <col width="15%">
                    <col width="30%">
                </colgroup>
                <tr>
                    <th style="height: 31px;">Document</th>
                    <td>
                        <sf:select path="docId" >
                            <sf:option value="0">------------------Select Document-----------------</sf:option>
                            <c:forEach items="${docList}" var="doc" varStatus="rowid">
                                <sf:option value="${doc.docId}">${doc.docName}</sf:option>
                            </c:forEach>
                        </sf:select>
                        <sf:hidden path="docLocId"/>
                    </td>
                    <th style="height: 31px;">Location</th>
                    <td>
                        <sf:select path="locId" >
                            <sf:option value="0">------------------Select Location-----------------</sf:option>
                            <c:forEach items="${locList}" var="loc" varStatus="rowid">
                                <sf:option value="${loc.locId}">${loc.locDesc}</sf:option>
                            </c:forEach>
                        </sf:select>
                    </td>
                </tr>
            </table><br>
            <p align="center">
                <input type="submit" value="Save" name="Save">
                <input type="reset" value="Reset" name="Reset">
            </p>
        </sf:form>
        <table id="searchResult" width="90%" border="1" align="center">
           
            <thead>
                <tr>
                    <th>Doc Location Map</th>
                    <th style="width: 5%">Delete</th>
                </tr>
            </thead>    
            <c:choose>
                <c:when test="${not empty docLocList}">
                    <c:forEach var="docLoc" items="${docLocList}" varStatus="row">
                        <tr> 
                            <td id="s1"><fmt:formatNumber type="number" pattern="0000" value="${docLoc.docLocId}" /> - ${docLoc.docLocDesc}</td>
                            <td><input type="checkbox" name="deleted" id="deleted" onclick="deleteDocLoc(${docLoc.docLocId})"> </td>
                        </tr>
                    </c:forEach>
                </c:when>
                <c:otherwise><td colspan="4" id="txtcols"><b style="font-size: 13px">No Record found </b></td></c:otherwise>
            </c:choose>
        </table><br>
    </body>
</html>