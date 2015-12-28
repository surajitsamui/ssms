<%-- 
    Document   : userContractForm
    Created on : 13 Dec, 2012, 10:10:59 AM
    Author     : samim
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Contract Entry Page</title>
        <script type="text/javascript" language="javascript" src="/scripts/jquery.min.js"></script>
        <link rel="stylesheet" href="/css/ccms.css" type="text/css">
        <link rel="stylesheet" href="/css/olimms.css" type="text/css">
        <script type="text/javascript">
            
            function deleteUserContract(user,contract){
                if(window.confirm("are you sure?")){
                    window.location="/admin/deleteUserContractMap.htm?userIde=" + user+"&contractId="+contract;
                }
                $('input:checkbox').removeAttr('checked');
            }
            
        </script>
    </head>
    <body>
        <sf:form commandName="userContract"><br><br>
            <table id="searchResult" border="1" align="center">
                <caption>User Contract</caption>
                <colgroup>
                    <col width="15%">
                    <col width="35%">
                    <col width="15%">
                    <col width="35%">
                </colgroup>
                <tr>
                    <th style="height: 31px;">User Name</th>
                    <td colspan="3">
                        <sf:select path="user.userId">
                            <sf:option value="0">-------Select User-------</sf:option>
                            <sf:options items="${users}"/>
                        </sf:select>
                    </td>
                    <th style="height: 31px;">Contract Type</th>
                    <td>
                        <sf:select path="contractType.conTypeId" >
                            <sf:option value="0">---------Select Contract Type--------</sf:option>
                            <c:forEach items="${contractTypes}" var="contractType" varStatus="rowid">
                                <sf:option value="${contractType.conTypeId}">${contractType.conTypeName}</sf:option>
                            </c:forEach>
                        </sf:select>
                    </td>
                </tr>
            </table><br>
            <p align="center">
                <input type="submit" value="Save" name="Save">
            </p><br>
        </sf:form>
        <table id="searchResult" width="90%" border="1" align="center">
            <colgroup>
                <col width="95%">
                <col width="5%">
            </colgroup>
            <thead>
                <tr>
                    <th>User Contract Map</th>
                    <th>Delete</th>
                </tr>
            </thead>    
            <c:choose>
                <c:when test="${not empty userConList}">
                    <c:forEach var="userCon" items="${userConList}" varStatus="row">
                        <tr> 
                            <td id="s1">${userCon.user.userId} : ${userCon.user.userName} - ${userCon.contractType.conTypeName}</td>
                            <td><input type="checkbox" name="deleted" id="deleted" onclick="deleteUserContract(${userCon.user.userId},${userCon.contractType.conTypeId})"> </td>
                        </tr>
                    </c:forEach>
                </c:when>
                <c:otherwise><td colspan="4" id="txtcols"><b style="font-size: 13px">No Record found </b></td></c:otherwise>
            </c:choose>
        </table><br>
    </body>
</html>