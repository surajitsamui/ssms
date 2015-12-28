<%-- 
    Document   : contractForm
    Created on : 13 Dec, 2012, 11:47:48 AM
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
        <title>Contract Type Page</title>
        <script type="text/javascript" language="javascript" src="/scripts/jquery.min.js"></script>
        <link rel="stylesheet" href="/css/ccms.css" type="text/css">
        <link rel="stylesheet" href="/css/olimms.css" type="text/css">
        <script type="text/javascript">
            
            function deleteRole(cId){
                if(window.confirm("are you sure?")){
                    window.location="/admin/deleteContract.htm?conId=" + cId;
                }
                $('input:checkbox').removeAttr('checked');
            }
            
        </script>
    </head>
    <body>
        <sf:form commandName="contract">
            <br><br>
            <table id="searchResult" width="90%" border="1" align="center">
                <caption>Contract Type Entry</caption>
                <colgroup>
                    <col width="15%">
                    <col width="20%">
                    <col width="15%">
                    <col width="40%">
                </colgroup>
                <tr>
                    <th>Contract Description</th>
                    <td><sf:input path="conTypeName" size="80" /></td>
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
                    <th>Contract Id</th>
                    <th>Contract Description </th>
                    <th>Delete</th>
                </tr>
            </thead>   
            <tbody>
                <c:choose>
                    <c:when test="${not empty contractTypes}">
                        <c:forEach var="con" items="${contractTypes}" varStatus="row">
                            <tr>
                                <td>${con.conTypeId}</td>                            
                                <td>${con.conTypeName}</td>
                                <td><input type="checkbox" name="deleted" id="deleted" onclick="deleteRole(${con.conTypeId})"> </td>
                            </tr>
                        </c:forEach>
                    </c:when>
                    <c:otherwise><td colspan="3" id="txtcols"><b style="font-size: 13px">No Record found </b></td></c:otherwise>
            </c:choose>
        </tbody>
    </table><br>

</body>
</html>