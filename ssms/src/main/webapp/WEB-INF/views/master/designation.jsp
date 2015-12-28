
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
        <script type="text/javascript" src="/scripts/jquery-ui.min.js"></script>
        <script type="text/javascript" src="/scripts/grid.locale-en.js"></script>
        <script type="text/javascript">
            $.jgrid.no_legacy_api = true;
            $.jgrid.useJSON = true;</script>
        <script type="text/javascript" src="/scripts/jquery.jqGrid.src.js"></script>
        <script type="text/javascript">
            //grid 1
            $(function() {
                $("#list").jqGrid({
                    url: '/master/designationGrid.htm',
                    datatype: 'json',
                    colNames: ['Designation id', 'Designation', 'Designation Short Description'],
                    colModel: [
                        {name: 'id', index: 'id', width: 200, editable: true, editoptions: {defaultValue: '0'}, sortable: false, hidden: true, search: false, editrules: {required: true}},
                        {name: 'desgDesc', index: 'desgDesc', width: 500, sortable: false, editable: true, editrules: {required: true}, searchoptions: {sopt: ['bw', 'eq', 'cn', 'ne']}},
                        {name: 'desgShortDesc', index: 'desgShortDesc', width: 300, editable: true, sortable: false, editrules: {required: true}, search: false}
                    ],
                    height: 'auto',
                    autowidth: true,
                    rowNum: 20,
                    rowList: [10, 20, 30],
                    viewrecords: true,
                    loadonce: false,
                    pager: '#pager',
                    ondblClickRow: function(id) {
                        if (isRowEditable(id)) {
                            $("#list").jqGrid('editRow', id, true, null, null, '/master/updatedesignation.htm');
                        }
                    },
                    onSelectRow: function(id) {
                        if (id && id !== lastSel) {
                            $("#list").jqGrid('restoreRow', lastSel);
                            lastSel = id;
                        }
                    }
                }).jqGrid('navGrid', '#pager', {add: true, edit: true, del: true, 'search': true, refresh: true},
                {url: '/master/updatedesignation.htm', width: '500', closeAfterEdit: true}, {url: '/master/adddesignation.htm', width: '500', closeAfterAdd: true},
                {url: '/master/deletedesignation.htm'},
                {searchOnEnter: true, closeAfterSearch: true, savekey: [true, 13], closeOnEscape: true}
                ).jqGrid('navButtonAdd', '#pager', {caption: '', buttonicon: 'ui-icon ui-icon-home', title: 'click to go home page', onClickButton: function() {
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
            <caption>Designation</caption>
            <tr style="height: 10px"><td></td></tr>
            <tr>
                <td>
                    <table id="list"></table>
                    <div id="pager"></div>
                </td>
            </tr>
        </table>
    </body>
</html>
