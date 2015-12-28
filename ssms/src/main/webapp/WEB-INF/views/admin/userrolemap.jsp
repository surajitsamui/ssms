<%-- 
    Document   : usermenu
    Created on : Nov 22, 2013, 1:42:42 PM
    Author     : mmc-asu
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="st" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="/css/jquery-ui.css" />
        <link rel="stylesheet" type="text/css" href="/css/ui.jqgrid.css" />
        <script type="text/javascript" src="/scripts/jquery.min.js"></script>
        <script type="text/javascript" src="/scripts/jquery-ui.min.js"></script>
        <script type="text/javascript" src="/scripts/grid.locale-en.js"></script>
        <script type="text/javascript" src="/scripts/jquery-ui.js"></script>
        <link rel="stylesheet" href="/css/themes/jquery-ui.css">
        <link rel="stylesheet" href="/css/themes/ccms-style.css" type="text/css"/>
        <script type="text/javascript">
            $.jgrid.no_legacy_api = true;
            $.jgrid.useJSON = true;</script>
        <script type="text/javascript" src="/scripts/jquery.jqGrid.src.js"></script>
        <script type="text/javascript">
            $(function() {
                $("#userId").click(function() {
                    $("#userrolemap").dialog("open");
                });
                $("#opener").click(function() {
                    $("#userrolemap").dialog("open");
                });
                $("#userrolemap").dialog({
                    autoOpen: false,
                    width: 700,
                    height: 570,
                    title: 'User Details',
                    draggable: false,
                    resizable: false,
                    autoResize: true,
                    show: {
                        effect: "blind",
                        duration: 1000
                    },
                    hide: {
                        effect: "clip",
                        duration: 1000
                    }
                });
                $("#userGrid").jqGrid({
                    url: "/admin/userMasterAll.htm",
                    datatype: "json",
                    colNames: ['CPF No.', 'Name', 'Designation'],
                    colModel: [
                        {name: 'userId', index: 'userId', width: 100, sortable: false, key: true, align: 'center', searchoptions: {sopt: (['eq'])}},
                        {name: 'userName', index: 'userName', width: 350, sortable: false, searchoptions: {sopt: (['bw', 'cn', 'eq', 'ne'])}},
                        {name: 'desig', index: 'desg', width: 200, sortable: false, align: 'center', search: false}
                    ],
                    rowNum: 25,
                    height: 'auto',
                    viewrecords: true,
                    pager: '#upager',
                    ondblClickRow: function(userId) {
                        $('input:checked').each(function() {
                            $(this).prop("checked", false);
                        });
                        var user = $(this).jqGrid('getRowData', userId);
                        $("#userId").val(user.userId);
                        var html = '<span style="color:blue">CPF No. </span>: ' + user.userId + ',&nbsp<span style="color:blue">Name</span>: ' + user.userName + ' ( ' + user.desig + ')';
                        $('#userDtl').html(html);
                        $.ajax({
                            url: "/admin/getuserroles.htm?userId=" + user.userId,
                            success: function(data) {
                                $('input[type=checkbox]').each(function() {
                                    var id = $(this).val();
                                    for (var i = 0; i < data.length; i++) {
                                        if (id == data[i].roleId) {
                                            $(this).prop("checked", true);
                                            break;
                                        }
                                    }
                                });
                                if (data.length == 0) {
                                    $('input:checked').each(function() {
                                        $(this).prop("checked", false);
                                    });
                                }
                            }});
                        $("#userrolemap").dialog("close");
                        $("#userGrid").trigger('reloadGrid', [{page: 1}]);
                    },
                    width: 'auto',
                    height: '100%'
                }).jqGrid('navGrid', '#upager', {edit: false, add: false, del: false, search: true, refresh: false},
                {}, {}, {}, {searchOnEnter: true, closeAfterSearch: true, savekey: [true, 13], closeOnEscape: true, jqModal: true});
            });
            function saveUserRole() {
                var userId = $('#userId').val();
                if (userId == 0) {
                    alert("select user, please");
                }
                else
                {
                    var userRole = [];
                    $('input:checked').each(function() {
                        alert("role --" + $(this).val())
                        userRole.push($(this).val());
                    });
                    if (userRole.length !== 0) {
                        $.ajax({
                            url: '/admin/adduserrole.htm?userId=' + $('#userId').val(),
                            type: 'POST',
                            contentType: 'application/json',
                            data: JSON.stringify(userRole), //stringify is important
                            success: function(data)
                            {
                                alert("save success");
                                window.location = '/admin/userrolemap.htm';
                            }
                        });
                    }
                    else {
                        alert("Select atlease one Role !");
                    }
                }
            }
        </script>
    </head>
    <body>
        <table width="50%">
            <tr>
                <td>
                    <div class="cssdiv">
                        <h1 class="cssHeaderFont" align="center">User Role Mapping</h1>
                        <table width="100%" class="tablecss">
                            <!--<tbody>-->
                            <tr style="background-color: #C2E9FF;">
                                <td colspan="2" height="30" >
                                    <div id="userrolemap">
                                        <table id="userGrid"></table>
                                        <div id="upager"></div>
                                        <input type="hidden" name="userId" id="userId" size="50"/>
                                    </div>
                                    <div style="font-size: 13px;font-weight: bold" >
                                        <span>Select User</span><button id="opener"><span class="ui-icon ui-icon-person"></span></button>
                                        <span id="userDtl"></span>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td><h1 class="cssHeaderFont" align="center">Role</h1></td>
                                <td>
                                    <div class="cssdiv">
                                        <span class="ui-icon  ui-icon-circle-check"></span>
                                    </div>
                                </td>
                            </tr>
                            <c:forEach items="${role}" var="r">
                                <tr style="background-color: #f9f9f9;" class="">
                                    <td class="label4td">${r.roleDescr}</td>
                                    <td width="5%">
                                        <input type="checkbox" id="roleId" class="roleIds" value="${r.id}"/>
                                    </td>
                                </tr>
                            </c:forEach>
                            <tr>
                                <td colspan="2" align="center" > 
                                    <div style="margin-top: 20px"><input type="submit"  onclick="saveUserRole();"/></div>
                                </td>
                            </tr>
                        </table>
                    </div>
                </td>
            </tr>
        </table>
    </body>
</html>
