<%-- 
    Document   : roleDefine
    Created on : 6 Aug, 2013, 11:34:58 AM
    Author     : ratul
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib  uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>Document List</title>        
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/jquery-ui.css">
        <link rel="stylesheet" href="css/ui.jqgrid.css">
        <!--        <script type="text/javascript" src="/scripts/grid.locale-en-GB.js"></script>-->
        <script type="text/javascript" src="/scripts/grid.locale-en.js"></script>
        <script type="text/javascript" src="/scripts/jquery.jqGrid.src.js"></script>
        <script type="text/javascript" src="/scripts/jquery-ui-1.10.3.custom_1.js"></script>
        <script type="text/javascript" src="/scripts/grid.setcolumns.js"></script>

        <script type="text/javascript">
            $(function() {
                $("#jQGrid").jqGrid({
                    url: "/roleGrid.htm",
                    datatype: "json",
                    colNames: ['Role Id', 'Description', 'Modified on', 'Modified by'],
                    colModel: [
                        {name: 'roleId', index: 'roleId', width: 90, editable: false, align: 'center', sorttype: 'int', sortable: true},
                        {name: 'description', index: 'desc', width: 520, editable: true, align: 'center', edittype: 'textarea'},
                        {name: 'createdDate', formatter: 'date', hidden: true, editable: false, formatoptions: {srcformat: 'ISO8601Long', newformat: 'd/m/Y g:i:s A'}, width: 100},
                        {name: 'createUserId', width: 100, editable: false, hidden: true}
                    ],
                    jsonReader: {repeatitems: false, id: "roleId"},
                    multiselect: false,
                    paging: true,
                    rowNum: 10,
                    autowidth: false,
                    height: 'auto',
                    sortname: 'roleId',
                    sortorder: "asc",
                    sortable: true,
                    rowList: [10, 20, 30, 60],
                    pager: $('#sandgridp'),
                    rownumbers: true,
                    ondblClickRow: function(rowId) {
                        var val = $('#jQGrid').getRowData(rowId);
                        alert("Role no" + val.roleId + " was last modified on :" + val.createdDate + " by " + val.createUserId);
                    },
                    loadonce: false,
                    viewrecords: true,
//                    pgtext :"/",
                    caption: "Role Details ~ NLC",
                    loadtext: "Role Data Loading...."
//                    loadComplete: function() {
//
//                    }
                }).navGrid('#sandgridp', {add: true, addtext: 'New', center: true, 'edit': true, edittext: 'Edit', 'delete': true, deltext: 'Delete', 'search': true, searchtext: 'Find', refresh: true, refreshtext: 'Refresh'},
                {url: '/roleGridEdit.htm',
                    closeAfterEdit: true,
                    afterComplete: function(serverResponse, postdata, formid) {
                        $("#jQGrid").setRowData(postdata.id, postdata);
                    }
                },
                //add options
                {url: "/newRoleDefine.htm",
                    afterSubmit: function(serverResponse) {
//                        alert(serverResponse.responseText);
                        var errorText;
//                        $.ajax({url: '/newRoleDefine.htm', async: false}).done(function(data) {
//                    errorText = data;
//                });
//                alert(errorText);
                        serverResponse.done(function(data) {
                            errorText = data;
                        });
                        alert(errorText);
                        if (serverResponse.responseText != '{"default":0}') {
//                            alert("DONE");
//                             = $.parseJSON(serverResponse.responseText);

                            return [false, errorText.desc, null];
                        } else {
//                            alert("NOT DONE");
                            return [true, serverResponse.responseText, null];
                        }

                    },
                    closeAfterAdd: true,
//                    afterComplete: function(serverResponse, postdata, formid) {
//                $("tr.jqgrow:even").css("background", "grey");
//                    }
                },
                        //if add is not open then del wil not work
                                //delete options
                                        {url: '/roleGridDelete.htm'},
                                {closeAfterSearch: true,
                                    drag: true,
                                    closeOnEscape: true,
                                    afterSearch: function() {
                                        alert('postdata');
                                        jQuery("#jQGrid").searchGrid("clear");
                                    }
                                }
                                )
//                                        .extend(
//    $.jgrid.search,
//    {
//        multipleSearch: true,
//        multipleGroup: true,
//        recreateFilter: true,
//        closeOnEscape: true,
//        overlay: 0
//    }
//);
                            });


//            function errorChk(serverResponse, postdata){
//            if (serverResponse.responseText.toString() == '"__OK__"') {
////                            alert("DONE");
//                            return [true," ",null];
//                        } else {
////                            alert("NOT DONE");
//                            return [false,"Description cant be blank ",null];
//                        }
//            }

        </script>
    </head>
    <body >
        <h1 style="color: orange">Role Description</h1>
        <table id="jQGrid" style="width:90%"></table>
        <div id="sandgridp" >
        </div>
    </body>
</html>
