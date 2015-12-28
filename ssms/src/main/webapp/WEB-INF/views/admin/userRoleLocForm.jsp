<%-- 
    Document   : userRoleLocForm
    Created on : Oct 29, 2012, 4:10:05 PM
    Author     : mmc-pc1
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
        <title>Role Location Entry Page</title>
        <script type="text/javascript" language="javascript" src="/scripts/jquery.min.js"></script>
        <link rel="stylesheet" href="/css/ccms.css" type="text/css">
        <link rel="stylesheet" href="/css/olimms.css" type="text/css">
        <script type="text/javascript">
            
            function validate(){
                var roleLocs="";
                if($('[id="emdId.userId"]').val()==0){
                    alert("Please select userId first");
                    return false;
                }
                $("input[type=checkbox]:checked").each(function(){
                    roleLocs=roleLocs + $(this,this.parent).nextAll('input[type=hidden]').val()+",";
                });
                roleLocs=roleLocs.slice(0,-1);
                $('#roleLocIds').val(roleLocs);
            }
            
            $().ready(function(){
                $('[id="emdId.userId"]').change(function(){
                    window.location="/admin/userRoleLocForm.htm?userIde="+$('[id="emdId.userId"]').val();
                });
            });
            
        </script>
    </head>
    <body>
        <sf:form commandName="userRoleLoc" onsubmit="return validate();"><br><br>
            <table id="searchResult" border="1" align="center">
                <caption>User Role Location</caption>
                <colgroup>
                    <col width="30%">
                    <col width="60%">
                </colgroup>
                <tr>
                    <th style="height: 31px;">User Name</th>
                    <td colspan="3">
                        <sf:select path="emdId.userId">
                            <sf:option value="0">------------------Select User-----------------</sf:option>
                            <sf:options items="${users}"/>
                        </sf:select>
                    </td>
                </tr>
            </table><br>
            <table id="searchResult1" border="1" align="center">
                <colgroup>
                    <col width="10%">
                    <col width="80%">
                </colgroup>
                <thead>
                    <tr>
                        <th>SELECT</th>
                        <th>Role Loation</th>
                    </tr>
                </thead> 
                <tbody>
                    <c:forEach var="roleloc" varStatus="rowid"  items="${roleLocs}">
                        <tr>
                            <td id="s2">
                                <input align="middle" type="checkbox" id="selected" ${roleloc.selected? 'checked':''}/>
                                <input type="hidden" value="${roleloc.roleLocId}"/>
                            </td>
                            <td>${roleloc.roleLocId} - ${roleloc.roleLocDesc}</td>
                        </tr>
                    </c:forEach>
                <input type="hidden" name="roleLocIds" id="roleLocIds" value="">
                </tbody>
            </table><br>
            <p align="center">
                <!--<input type="submit" value="Search" name="Search">-->
                <input type="submit" value="Save" name="Save">
            </p><br>
        </sf:form>
    </body>
</html>
