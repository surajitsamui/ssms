<%-- 
    Document   : workFlowUsers
    Created on : 7 Dec, 2012, 11:29:57 AM
    Author     : samim
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@taglib  uri="http://www.springframework.org/tags" prefix="st" %>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="/css/olimms.css" type="text/css">
        <link rel="stylesheet" href="/css/ccms.css" type="text/css">
        <script type="text/javascript" language="javascript" src="/scripts/jquery.min.js"></script>
        <title>JSP Page</title>
        <script type="text/javascript">
            
        </script>
    </head>
    <body>
        <sf:form  commandName="wfusers" action="/saveNextLevelWorkflowUsers.htm"><br>
            <table class="searchResult1" border="1" cellpadding="0" cellspacing="0">
                <caption></caption>
                <tr>
                    <th width="20%">Document: </th>
                    <td width="30%">${wfusers.documentName}</td>
                    <th width="20%">Document - Location</th>
                    <td width="30%">${wfusers.docLocDesc}</td>
                </tr>
            </table><br>
            <table class="searchResult1" border="1" cellpadding="0" cellspacing="0">
                <thead>
                    <tr>
                        <th style="width:  5%">Level</th>
                        <th>Role - Location</th>
                        <th style="width: 40%">Users</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${workflowList}" var="workflow" varStatus="rowid">
                        <st:nestedPath path="workflowUsers[${rowid.index}]">
                            <tr>
                                <td>${workflow.currentLevel}
                                    <input type="hidden" name="workflowUsers[${rowid.index}].levelId" size="3" value="${workflow.currentLevel}">
                                    <sf:hidden path="seqNo"/>
                                    <sf:hidden path="userName"/>
                                </td>
                                <td>${workflow.rolelocDesc}
                                    <input type="hidden" name="workflowUsers[${rowid.index}].roleLocDesc" value="${workflow.rolelocDesc}">
                                    <input type="hidden" name="workflowUsers[${rowid.index}].roleLocId" value="${workflow.roleLocId}"/>
                                </td>
                                <td>
                                    <c:choose>
                                        <c:when test="${view}">
                                            ${wfusers.workflowUsers[rowid.index].userId} : ${wfusers.workflowUsers[rowid.index].userName}
                                        </c:when>
                                        <c:otherwise>
                                            <sf:select path="userId">
                                                <sf:option value="0">--Select--</sf:option>
                                                <sf:options items="${roleUsers[workflow.roleLocId]}"></sf:options>
                                            </sf:select>
                                        </c:otherwise>
                                    </c:choose>

                                </td>
                            </tr>
                        </st:nestedPath>
                    </c:forEach>
                </tbody>
            </table>
            <c:if test="${!view}">
                <p>
                    <input type="submit" value="Save" name="Save">
                </p>
            </c:if>
        </sf:form>
    </body>
</html>
