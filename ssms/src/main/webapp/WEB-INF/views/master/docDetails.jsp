<%-- 
    Document   : docDetails
    Created on : Jul 31, 2013, 10:05:53 AM
    Author     : Sudipta
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
        <link rel="stylesheet" href="/css/jqgrid-ccms.css" type="text/css"/>
        <link rel="stylesheet" type="text/css" href="/css/jquery-ui.css" />
        <link rel="stylesheet" type="text/css" href="/css/ui.jqgrid.css" />
        <script type="text/javascript" src="/scripts/jquery.min.js"></script>
        <script type="text/javascript" src="/scripts/jquery-ui-min.js"></script>
        <script type="text/javascript" src="/scripts/grid.locale-en.js"></script>
        <script type="text/javascript" src="/scripts/jquery.jqGrid.src.js"></script>
        <script type="text/javascript">
            $(function() {
                $("#jQGrid").jqGrid({
                    url: "/docEntries.htm",
                    datatype: "json",
                    mtype: "GET",
                    colNames: ['Document Id', 'Short Description', 'Full Description', 'Created Date', 'Created UserID', 'Workflow Required'],
                    colModel: [
                        {name: 'docId', width: 100, editable: true, editoptions: {readonly: false}, align: 'center'},
                        {name: 'shortDesc', width: 130, editable: true, edittype: 'textarea', editrules: {required: true}, align: 'center'},
                        {name: 'fullDesc', width: 150, editable: true, edittype: 'textarea', editrules: {required: true}, align: 'center'},
                        {name: 'createdDate', width: 90, formatter: 'date', formatoptions: {srcformat: 'ISO8601Long', newformat: 'd/m/Y g:i:s A'}, align: 'center', hidden: false},
                        {name: 'createUserId', width: 120, align: 'center', hidden: false},
                        {name: 'workflowRequired', width: 120, editable: true, edittype: 'checkbox', align: 'center'}
                    ],
                    jsonReader: {repeatitems: false, id: "docId"},
                    multiselect: false,
                    paging: true,
                    rowNum: 10,
                    rowList: [10, 20, 30],
                    pager: $('#sandgrid'),
                    loadonce: false,
                    sortname: 'docId',
                    sortorder: 'asc',
                    viewrecords: true,
                    caption: "Document Details",
                    autowidth: true,
                    height: "auto",
                    width: 750,
                    loadtext: "Loading...",
                    sortable: true
                    //shrinkToFit:true
                })

                        .navGrid('#sandgrid', {'edit': true, 'edittext': "Edit", 'add': true, "addtext": "Add", 'del': true, 'deltext': "Delete", 'search': true, 'searchtext': "Search", 'refresh': true},
                        {url: "/editDoc.htm",
                            closeAfterEdit: true,
                            afterComplete: function(serverResponse, postdata, formid) {
                                if (serverResponse.status === 200)
                                {
                               //$("#jQGrid").trigger("reloadGrid");
                                    $("#jQGrid").setRowData(postdata.id, postdata);

                                }
                                else
                                {
                                    alert("Not Edited");
                                }

                            }
                        },
                        {url: "/newDocEntry.htm",
                            closeAfterAdd: true,
//                    onSelectRow: function(id) {
//    if (id && id !== lastSel) {
//       $("#jQGrid").jqGrid('restoreRow',lastSel);
//        var cm = $("#jQGrid").jqGrid('getColProp','Document Id');
//        cm.editable = false;
//        $("#jQGrid").editRow(id,true);
//        cm.editable = true;
//        lastSel = id;
//    }
//},
//onSelectRow: function(id){ 
//        var ret = $("#jQGrid").jqGrid('getRowData',id);
//        if (ret.Arrived==='Yes')
//         {
//            $("#jQGrid").setColProp('Document Id',{editable:false});}
//        else { $("#jQGrid").setColProp('Document Id',{editable:true});}},
                            afterComplete: function(serverResponse, postdata, formid)
                            {
                                if (serverResponse.status === 200)
                                {
//                            alert("hi");
                                    postdata:{
                                        'createdDate';
                                        newDate();
                                    }
                                    ;
//                            $("#jQGrid").trigger("reloadGrid");
                                    $("#jQGrid").addRowData(postdata.docId, postdata);
                                }
                                else
                                {
                                    alert("Item is not Entered");
                                }

                            }
                        },
                        {url: "/deleteDoc.htm"}
                        );

            });
        </script>
    </head>
    <body ><br>
        <table id="jQGrid"></table>
        <div id="sandgrid" align="center"></div>
    </body>
</html>