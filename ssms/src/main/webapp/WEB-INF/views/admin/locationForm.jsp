<%-- 
    Document   : locationForm
    Created on : Oct 26, 2012, 6:21:15 PM
    Author     : mmc-pc1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Location Master-JSP Page</title>
        <script type="text/javascript" language="javascript" src="/scripts/jquery.min.js"></script>
        <link rel="stylesheet" href="/css/ccms.css" type="text/css">
        <link rel="stylesheet" href="/css/olimms.css" type="text/css">
        <script type="text/javascript">
            
            function deleteLocation(lId){
                if(window.confirm("are you sure?")){
                    window.location="/admin/DeleteLocation.htm?locnId=" + lId;
                }
                $('input:checkbox').removeAttr('checked');
            }
            
        </script>
        <style type="text/css">
            @import url("/css/ccms-menu.css");
            .sf-menu li.pad2:hover, .sf-menu li.pad2 a:active{
                width:998px;
                height:33px;
                background:#5ec1e0;
                float:left;
            }
            .pad2 {
                width:998px;
                height:33px;
                background:#86CFFB;
                /* display:inline;*/
                float:left;

            }
        </style>
    </head>
    <body>
        <sf:form commandName="location">
            <br><br>
            <table id="searchResult" width="90%" border="1" align="center">
                <caption>Location Master</caption>
                <colgroup>
                    <col width="15%">
                    <col width="20%">
                    <col width="15%">
                    <col width="40%">
                </colgroup>
                <tr>
                    <th>Location Id</th>
                    <td><sf:input path="locId" size="30"/></td>
                    <th>Location Description</th>
                    <td><sf:input path="locDesc" size="80" /></td>
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
                    <th>LOCATION ID</th>
                    <th>LOCATION DESCRIPTION </th>
                    <th>DELETE</th>
                </tr>
            </thead>    
            <c:choose>
                <c:when test="${not empty locationList}">
                    <c:forEach var="locList" items="${locationList}" varStatus="row">
                        <tr>
                            <td>${locList.locId}</td>                            
                            <td>${locList.locDesc}</td>
                            <td><input type="checkbox" name="deleted" id="deleted" onclick="deleteLocation(${locList.locId})"> </td>
                        </tr>
                    </c:forEach>
                </c:when>
                <c:otherwise><td colspan="3" id="txtcols"><b style="font-size: 13px">No Record found </b></td></c:otherwise>
            </c:choose>
        </table><br>

    </body>
</html>
