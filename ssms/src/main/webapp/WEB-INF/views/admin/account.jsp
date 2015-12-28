
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="st" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="/css/jqgrid-ccms.css" type="text/css"/>
        <link rel="stylesheet" type="text/css" href="/css/jquery-ui.css" />
        <link rel="stylesheet" type="text/css" href="/css/ui.jqgrid.css" />
        <script type="text/javascript" src="/scripts/jquery.min.js"></script>
        <script type="text/javascript" src="/scripts/jquery-ui-min.js"></script>
        <script type="text/javascript" src="/scripts/grid.locale-en.js"></script>
        <script type="text/javascript" src="/scripts/jquery.jqGrid.src.js"></script>
        <script type="text/javascript">
            $(function() {
                var dropdownvalue = {value:${dropDownValue}};
                $("#list2").jqGrid({
                    url: '/admin/accountGrid.htm',
                    datatype: 'json',
                    colNames: ['Account id', 'Description', 'Unit'],
                    colModel: [
                        {name: 'id', index: 'id', width: 100, editable: true, editoptions: {defaultValue: '0'}, hidden: false},
                        {name: 'description', index: 'description', width: 500, editable: true, sortable: false, editrules: {required: true}},
                        {name: 'unit.id', index: 'unit.id', width: 100, editable: true, edittype: 'select', align: 'center', formatter: 'select',
                            editoptions: dropdownvalue}
                    ],
                    height: 'auto',
                    autowidth: true,
                    pager: '#pager2',
                    ondblClickRow: function(id) {
                        if (isRowEditable(id)) {
                            $(this).jqGrid('editRow', id, true, null, null, '/admin/updateaccount.htm');
                        }
                    },
                    onSelectRow: function(id) {
                        if (id && id !== lastSel) {
                            $("#list2").jqGrid('restoreRow', lastSel);
                            lastSel = id;
                        }
                    }
                }).jqGrid('navGrid', '#pager2', {add: true, edit: true, del: true, search: false, refresh: false},
                {
                    url: '/admin/updateaccount.htm',
                    closeAfterEdit: true
                },
                {
                    url: '/admin/addaccount.htm',
                    closeAfterAdd: true,
                    recreateForm: true

                },
                {
                    url: '/admin/deleteaccount.htm'
                });
                var lastSel = -1;
                var isRowEditable = function(id) {
                    lastSel = id;
                    return true;
                };
            });
        </script>
    </head>
    <body>
        <table id="tablecss" width="90%">
            <caption>Account</caption>
            <tr style="height: 10px"><td></td></tr>
            <tr>
                <td>
                    <table id="list2"></table>
                    <div id="pager2"></div>
                </td>
            </tr>
            <c:if test="${empty dropDownValue}">
                <tr><td style="color:  #ff9999;font-weight: bold" align="center">No Account Found</td></tr>
            </c:if>
            <tr><td align="right"><button><a href="/home.htm" style="text-decoration: none">Close</a></button></td></tr>
        </table>
    </body>
</html>
