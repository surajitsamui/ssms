<%-- 
    Document   : documentGenerate
    Created on : Jan 18, 2014, 11:17:33 PM
    Author     : Asu
--%>

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
                $("#list").jqGrid({
                    url: '/admin/documentgrid.htm',
                    datatype: 'json',
                    colNames: ['Document No', 'Document', 'Token', 'Status'],
                    cmTemplate: {sortable: false, editable: true, search: false},
                    colModel: [
                        {name: 'docId', index: 'docId', width: 100, key: true, editoptions: {size: 30, defaultValue: '0'}, search: true, searchoptions: {sopt: ['eq']}},
                        {name: 'docName', index: 'docName', width: 500, search: true, editoptions: {size: 30}, searchoptions: {sopt: ['bw', 'cn', 'eq', 'ew', 'ne']}},
                        {name: 'token', index: 'token', width: 50, editoptions: {size: 30}},
                        {name: 'active', index: 'active', width: 50, edittype: 'checkbox', formatter: 'checkbox', align: 'center'}
                    ],
                    autowidth: true,
                    pager: '#pager',
                    viewrecords: true,
                    width: 'auto',
                    height: 'auto',
                    caption: 'Document List',
                    ondblClickRow: function(rowId) {
                        if (isRowEditable(rowId)) {
                            $(this).jqGrid('editRow', rowId, true, null, null, '/admin/updateexistdoucment.htm');
                        }
                    },
                    onSelectRow: function(id) {
                        if (id && id !== lastSel) {
                            $("#list").jqGrid('restoreRow', lastSel);
                            lastSel = id;
                        }
                    }
                }).jqGrid('navGrid', '#pager', {},
                        {url: '/admin/updateexistdoucment.htm', closeAfterEdit: true},
                {url: '/admin/addnewdoucment.htm', closeAfterAdd: true},
                {url: '/admin/deletedoucmentbyid.htm'}, {searchOnEnter: true, closeAfterSearch: true});
                var lastSel = -1;
                var isRowEditable = function(id) {
                    lastSel = id;
                    return true;
                };
            });
        </script>
    </head>
    <body>
        <table width="90%" id="tablecss">
            <tr>
                <td>
                    <table id="list"></table>
                    <div id="pager"></div>
                </td>
            </tr>
        </table>
    </body>
</html>
