
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
                $("#list1").jqGrid({
                    url: '/admin/locationGrid.htm',
                    datatype: 'json',
                    colNames: ['', 'Location id', 'Description', 'Short Description', 'Unit'],
                    colModel: [
                        {name: 'id', index: 'id', width: 100, resizable: false, sortable: false, editable: true, search: false, editoptions: {defaultValue: '0'}, hidden: true},
                        {name: 'divId', index: 'divId', width: 100, resizable: false, sortable: false, editable: true, search: false, editoptions: {defaultValue: '0'}, hidden: true, editrules: {required: true, edithidden: true}},
                        {name: 'description', index: 'description', width: 300, editable: true, resizable: false, edittype: 'text', sortable: false, editrules: {required: true}, searchoptions: {sopt: ['bw', 'cn', 'eq', 'ew', 'ne']}},
                        {name: 'shortDesc', index: 'shortDesc', width: 200, editable: true, resizable: false, edittype: 'text', sortable: false, editrules: {required: true}, searchoptions: {sopt: ['bw', 'cn', 'eq', 'ew', 'ne']}},
                        {name: 'unit.id', index: 'unit.id', width: 100, sortable: false, resizable: false, editable: true, search: false, edittype: 'select', formatter: 'select',
                            editoptions: dropdownvalue}
                    ],
                    height: 'auto',
                    rowNum: 20,
                    rowList: [10, 20, 30],
                    autowidth: true,
                    viewrecords: true,
                    pager: '#pager1',
                    ondblClickRow: function(id) {
                        if (isRowEditable(id)) {
                            $(this).jqGrid('editRow', id, true, null, null, '/admin/updatelocation.htm');
                        }
                    },
                    onSelectRow: function(id) {
                        if (id && id !== lastSel) {
                            $("#list1").jqGrid('restoreRow', lastSel);
                            lastSel = id;
                        }
                    }

                }).jqGrid('navGrid', '#pager1', {add: true, edit: true, delete: true, view: false, search: true, refresh: true},
                {
                    url: '/admin/updatelocation.htm',
                    closeAfterEdit: true
                },
                {
                    url: '/admin/addlocation.htm',
                    closeAfterAdd: true
                },
                {
                    url: '/admin/deletelocation.htm'
                }, {searchOnEnter: true, closeAfterSearch: true, savekey: [true, 13], closeOnEscape: true}
                ).jqGrid('navButtonAdd', '#pager1', {caption: '', buttonicon: 'ui-icon ui-icon-home', title: 'click to go home page', onClickButton: function() {
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
    <body>
        <table id="tablecss" width="90%">
            <caption>Location Master</caption>
            <tr style="height: 10px"><td></td></tr>
            <tr>
                <td>
                    <table id="list1"></table>
                    <div id="pager1"></div>
                </td>
            </tr>
        </table>
    </body>
</html>
