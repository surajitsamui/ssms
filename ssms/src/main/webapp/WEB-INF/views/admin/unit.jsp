
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
                    url: '/admin/unitGrid.htm',
                    datatype: 'json',
                    colNames: ['Unit id', 'Unit Name', 'Description'],
                    colModel: [
                        {name: 'id', index: 'id', width: 100, editable: true, editoptions: {defaultValue: '0'}, sortable: false, hidden: true, search: false, editrules: {edithidden: true}},
                        {name: 'unitName', index: 'unitName', width: 300, editable: true, sortable: false, searchoptions: {sopt: ['bw', 'cn', 'eq', 'ew', 'ne']}},
                        {name: 'description', index: 'description', width: 500, editable: true, sortable: false, editrules: {required: true}, search: false}
                    ],
                    height: 'auto',
                    autowidth: true,
                    rowNum: 20,
                    rowList: [10, 20],
                    viewrecords: true,
                    pager: '#pager',
                    ondblClickRow: function(id) {
                        if (isRowEditable(id)) {
                            $("#list").jqGrid('editRow', id, true, null, null, '/admin/updateunit.htm');
                        }
                    },
                    onSelectRow: function(id) {
                        if (id && id !== lastSel) {
                            $("#list").jqGrid('restoreRow', lastSel);
                            lastSel = id;
                        }
                    }
                }).jqGrid('navGrid', '#pager', {add: true, edit: true, del: true, search: true, refresh: true},
                {url: '/admin/updateunit.htm', closeAfterEdit: true}, {url: '/admin/addunit.htm', closeAfterAdd: true},
                {url: '/admin/deleteunit.htm'}, {searchOnEnter: true, closeAfterSearch: true, savekey: [true, 13], closeOnEscape: true})
                        .jqGrid('navButtonAdd', '#pager', {caption: '', buttonicon: 'ui-icon ui-icon-home', title: 'click to go home page', onClickButton: function() {
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
            <caption>Unit</caption>
            <tr style="height: 10px"><td></td></tr>
            <tr>
                <td style="background-color: white">
                    <table id="list"></table>
                    <div id="pager"></div>
                </td>
            </tr>
        </table>
    </body>
</html>
