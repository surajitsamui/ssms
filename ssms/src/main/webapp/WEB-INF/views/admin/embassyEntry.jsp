<%-- 
    Document   : embassyEntry
    Created on : Dec 26, 2014, 10:32:03 AM
    Author     : Suresh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Embassy Master page</title>
        <link rel="stylesheet" href="/css/olimms.css" type="text/css">
        <script type="text/javascript" language="javascript" src="/scripts/jquery.min.js"></script>
        <script type="text/javascript" language="javascript" src="/scripts/jquery-ui-min.js"></script>
        <link rel="stylesheet" type="text/css" href="/css/jquery-ui.css" />
        <link type="text/css" href="/css/ccms-style.css" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="/css/ui.jqgrid.css" />
        <script type="text/javascript" src="/scripts/grid.locale-en.js"></script>
        <script type="text/javascript" src="/scripts/jquery.jqGrid.src.js"></script> 
        <script type="text/javascript">
            $(function() {
                $("#embassyList").jqGrid({
                    url: '/embassy/embassyDeatils.htm',
                    datatype: 'json',
                    colNames: ['Embassy Id', 'Embassy Name', 'Embassy Address', 'Embassy EmailId'],
                    colModel: [
                        {name: 'embassyId', index: 'embassyId', width: 5, editable: true, key: true, sortable: false, hidden: true, editrules: {edithidden: false}, editoptions: {defaultValue: '0', readonly: 'readonly'}},
                        {name: 'embassyName', index: 'embassyName', width: 25, editable: true, sortable: false, align: 'center', editoptions: {size: 50}},
                        {name: 'embAddress', index: 'embAddress', width: 45, editable: true, edittype: 'textarea', sortable: false, align: 'center', editoptions: {rows: 3, cols: 60, maxlength: 32765}},
                        {name: 'embMailId', index: 'embMailId', width: 25, editable: true, align: 'center', hidden: false, search: false, editoptions: {size: 25}, editrules: {email: true, required: true, edithidden: true}}
                    ],
                    height: 'auto',
                    autowidth: true,
                    rowNum: 20,
                    rowList: [10, 20, 30],
                    pager: $("#sandgridp"),
                    viewrecords: true
                }).navGrid('#sandgridp', {edit: true, add: true, del: true, search: false, refresh: false, refreshtext: ''}, {addCaption: 'Edit Details', url: '/embassy/updateDetails.htm', width: '500', closeAfterEdit: true},
                {addCaption: 'Add New Details', url: '/embassy/addEmbassy.htm', width: '500', closeAfterAdd: true},
                {url: '/embassy/deleteDetails.htm', width: '500'});
            });
        </script>
    </head>
    <body>
        <table width="90%">
            <caption>Embassy Master Details</caption>
            <thead>
                <tr>
                    <td>
                        <table id="embassyList"></table>
                        <div id="sandgridp" ></div>
                    </td>
                </tr>
            </thead>
        </table>
    </body>
</html>
