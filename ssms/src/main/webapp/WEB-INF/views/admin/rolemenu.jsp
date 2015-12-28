
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="st" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="/css/ccms.css" type="text/css"/>
        <script src="/scripts/jquery-1.9.1.js"></script>
        <script src="/scripts/jquery.min.js.js"></script>
        <link rel="stylesheet" href="/css/IndeterminateCheckboxes.css" type="text/css">
        <script type="text/javascript">
            $(function() {
                $("#roleId").change(function() {
                    var roleId = $(this).val();
                    if (roleId != 0) {
                        $('input:checked').each(function() {
                            $(this).prop("checked", false);
                        });
                        loadMenuToUser(roleId);
                    }
                    else {
                        $('input:checked').each(function() {
                            $(this).prop("checked", false);
                        });
                    }
                });
            });
            function loadMenuToUser(roleId)
            {
                $.ajax({
                    url: "/admin/getrolemenu.htm?roleId=" + roleId,
                    success: function(data) {
                        $('input[type=checkbox]').each(function() {
                            var id = $(this).val();
                            for (var i = 0; i < data.length; i++) {
                                if (id == data[i].menuId) {
                                    $(this).prop("checked", true);
                                    break;
                                }
                            }
                        });
                    }});
            }
            function saveMenu() {
                var roleId = $('#roleId').val();
                if (roleId == 0) {
                    alert("choose role");
                }
                else
                {
                    var userMenus = [];
                    $('input:checked').each(function() {
                        userMenus.push($(this).val());
                    });
                    $.ajax({
                        url: '/admin/rolemenu.htm?roleId=' + $('#roleId').val(),
                        type: 'POST',
                        contentType: 'application/json',
                        data: JSON.stringify(userMenus), //stringify is important
                        success: function(data)
                        {
                            alert("save success");
                            window.location = '/admin/rolemenu.htm';
                        }
                    });
                }
            }
        </script>
        <script>
            $(function() {
                // Apparently click is better chan change? Cuz IE?
                $('input[type="checkbox"]').change(function(e) {
                    var checked = $(this).prop("checked"),
                            container = $(this).parent(),
                            siblings = container.siblings();
                    container.find('input[type="checkbox"]').prop({
                        indeterminate: false,
                        checked: checked
                    });
                    function checkSiblings(el) {
                        var parent = el.parent().parent(),
                                all = true;
                        el.siblings().each(function() {
                            return all = ($(this).children('input[type="checkbox"]').prop("checked") === checked);
                        });

                        if (all && checked) {
                            parent.children('input[type="checkbox"]').prop({
                                indeterminate: false,
                                checked: checked
                            });
                            checkSiblings(parent);
                        } else if (all && !checked) {
                            parent.children('input[type="checkbox"]').prop("checked", checked);
                            parent.children('input[type="checkbox"]').prop("indeterminate", (parent.find('input[type="checkbox"]:checked').length > 0));
                            checkSiblings(parent);
                        } else {
                            el.parents("li").children('input[type="checkbox"]').prop({
                                indeterminate: false,
                                checked: true
                            });
                        }
                    }
                    checkSiblings(container);
                });
            });
        </script>
        <style type="text/css" media="screen ">
            label{width:250px;margin-left: 5px}
            input[type="checkbox"]:checked+label{background: #F5F5DC; color:black;font: 'bold'}
        </style>

    </head>
    <body>
        <table width="100%" id="searchResult">
            <caption>Menu Access </caption>
            <colgroup>
                <col width="10%">
                <col width="90%">
            </colgroup>
            <tr style="background-color:#F5F5DC">
                <th>
                    <span style="color: #0099cc">Check Menu</span>
                </th>
                <th colspan="2" align="center" height="30">
                    <span style="color: #0099cc">Select Role:</span>
                    <select id="roleId" style="width: 300px"> 
                        <option value="0" selected>-------------------Choose Role -------------------</option>
                        <c:forEach items="${role}" var="role">
                            <option value="${role.id}">${role.roleDescr}</option>
                        </c:forEach>
                    </select>
                </th>
            </tr>
            <tbody id="col3">
                <tr>
                    <td align='left' style="background-color:#eef5f5" colspan="2">
                        ${menuList}
                    </td>
                </tr>
                <tr style="background-color: #eef5f5;height: 25px">
                    <td colspan="2" align="center" > 
                        <div><button  onclick="saveMenu();">Save</button></div>
                    </td>
                </tr>
            </tbody>
        </table>
    </body>
</html>