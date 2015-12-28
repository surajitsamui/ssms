<%-- 
    Document   : rolemaster
    Created on : Oct 19, 2013, 3:32:20 PM
    Author     : mmc-pc1
--%><%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="/css/style.css" type="text/css">
        <link rel="stylesheet" href="/css/jqgrid-ccms.css" type="text/css">
        <link rel="stylesheet" href="/css/jquery-ui.css" type="text/css">
        <link rel="stylesheet" href="/css/ui.jqgrid.css" type="text/css">
        <script type="text/javascript" language="javascript" src="/scripts/jquery.jqGrid.src.js"></script>
        <script type="text/javascript" language="javascript" src="/scripts/grid.locale-en.js"></script>
        <script type="text/javascript" language="javascript" src="/scripts/jquery-ui-min.js"></script>
        <script type="text/javascript">
            $(function() {
                var type = {value:${docIds}};
                $("#jQGrid").jqGrid({
                    url: "/admin/rolemasterGrid.htm",
                    datatype: "json",
                    mtype: "GET",
                    colNames: ['Role Id', 'Role Description', 'Document', 'Create Date', 'Resticted'],
                    colModel: [
                        {name: 'id', index: 'id', width: 100, editable: true, editoptions: {defaultValue: '0'}, hidden: true, search: false},
                        {name: 'roleDescr', index: 'roleDescr', width: 500, editable: true, editrules: {required: true}, editoptions: {size: 50}, searchoptions: {sopt: ['bw', 'eq', 'cn', 'ne']}},
                        {name: 'docId', index: 'docId', width: 500, editable: true, formatter: 'select', edittype: 'select', editoptions: type, searchoptions: {sopt: ['bw', 'eq', 'cn', 'ne']}},
                        {name: 'createdDate', index: 'createdDate', width: 100, editable: false, align: 'center', formatter: 'date', formatoptions: {srcformat: 'U/1000', newformat: 'd/m/Y'}, editrules: {required: true}, editoptions: {size: 25}, search: false},
                        {name: 'preDefinedRole', index: 'preDefinedRole', width: 100, editable: true, hidden: false, search: false,
                            formatter: "checkbox", formatoptions: {disabled: true}, align: 'center',
                            edittype: "checkbox", editoptions: {value: "Yes:No", defaultValue: "No"},
                            stype: "select", searchoptions: {sopt: ["eq", "ne"], value: ":Any;true:Yes;false:No"}},
                    ],
                    height: 'auto',
                    autowidth: true,
                    rowNum: 20,
                    rowList: [10, 20, 30, 100],
                    viewrecords: true,
                    loadonce: false,
                    caption: 'Role Entry',
                    pager: '#sandgrid',
                    ondblClickRow: function(id) {
                        if (isRowEditable(id)) {
                            $("#jQGrid").jqGrid('editRow', id, true, null, null, '/admin/updateRoles.htm');
                        }
                    },
                    onSelectRow: function(id) {
                        if (id && id !== lastSel) {
                            $("#jQGrid").jqGrid('restoreRow', lastSel);
                            lastSel = id;
                        }
                    }
                }).jqGrid('navGrid', '#sandgrid', {add: true, edit: true, del: true, 'search': true, refresh: true},
                {url: '/admin/updateRoles.htm', width: '500', closeAfterEdit: true}, {url: '/admin/addRoles.htm', width: '500', closeAfterAdd: true},
                {url: '/admin/deleteRoles.htm'},
                {searchOnEnter: true, closeAfterSearch: true, savekey: [true, 15], closeOnEscape: true}
                ).jqGrid('navButtonAdd', '#sandgrid', {caption: '', buttonicon: 'ui-icon ui-icon-home', title: 'click to go home page', onClickButton: function() {
                        window.location = '/home.htm';
                    }, position: "last"
                });
                var lastSel = -1;
                var isRowEditable = function(id) {
                    lastSel = id;
                    return true;
                };
            });
        </script>
    </head>
        <table id="tablecss">
            <tr>
                <td><br>
                    <table id="jQGrid"></table>
                    <div id="sandgrid" align="center"></div>
                </td></tr>
        </table>
    </body>
</html>
