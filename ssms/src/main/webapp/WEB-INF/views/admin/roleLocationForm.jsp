<%-- 
    Document   : roleLocationForm
    Created on : Oct 27, 2012, 3:14:53 PM
    Author     : mmc-pc1
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
        <title>Role Location Entry Page</title>
        <script type="text/javascript" language="javascript" src="/scripts/jquery.min.js"></script>
        <link rel="stylesheet" href="/css/ccms.css" type="text/css">
        <link rel="stylesheet" href="/css/olimms.css" type="text/css">
        <script type="text/javascript">
            
            function deleteRoleLoc(rlId){
                if(window.confirm("are you sure?")){
                    window.location="/admin/deleteRoleLoc.htm?rolelocId=" + rlId;
                }
                $('input:checkbox').removeAttr('checked');
            }
            
        </script>
    </head>
    <body>
        <sf:form commandName="roleLoc"><br>
            <table id="searchResult" border="1" align="center">
                <caption>Role Location</caption>
                <colgroup>
                    <col width="15%">
                    <col width="30%">
                    <col width="15%">
                    <col width="30%">
                </colgroup>
                <tr>
                    <th style="height: 31px;">Role</th>
                    <td>
                        <sf:select path="roleId" >
                            <sf:option value="0">------------------Select Role-----------------</sf:option>
                            <c:forEach items="${roleList}" var="role" varStatus="rowid">
                                <sf:option value="${role.roleId}">${role.roleDesc}</sf:option>
                            </c:forEach>
                        </sf:select>
                        <sf:hidden path="roleLocId"/>
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
            <colgroup>
               
                <col width="95%">
                <col width="5%">
            </colgroup>
            <thead>
                <tr>
                    <th>Role Location Map</th>
                    <th>Delete</th>
                </tr>
            </thead>    
            <c:choose>
                <c:when test="${not empty roleLocList}">
                    <c:forEach var="roleLoc" items="${roleLocList}" varStatus="row">
                        <tr> 
                            <td id="s1"><fmt:formatNumber type="number" pattern="0000" value="${roleLoc.roleLocId}" /> - ${roleLoc.roleLocDesc}</td>
                            <td><input type="checkbox" name="deleted" id="deleted" onclick="deleteRoleLoc(${roleLoc.roleLocId})"> </td>
                        </tr>
                    </c:forEach>
                </c:when>
                <c:otherwise><td colspan="4" id="txtcols"><b style="font-size: 13px">No Record found </b></td></c:otherwise>
            </c:choose>
        </table><br>
    </body>
</html>
