<%-- 
    Document   : userMaster
    Created on : Oct 27, 2012, 10:20:24 AM
    Author     : Deogharia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="/css/jqgrid-ccms.css" type="text/css">
        <link rel="stylesheet" href="/css/ui.jqgrid.css" type="text/css">
        <link rel="stylesheet" href="/css/jquery-ui.css">
        <script type="text/javascript" language="javascript" src="/scripts/jquery-ui-1.10.3.custom.js"></script>
        <script type="text/javascript" language="javascript" src="/scripts/jquery-ui-min.js"></script>
        <script type="text/javascript" src="/scripts/jquery.jqGrid.src.js"></script>
        <script type="text/javascript" src="/scripts/grid.locale-en.js"></script>
        <script type="text/javascript">
            $(function() {
                var designation = {"value":${des}};
                var location = {"value": ${loc}};
                var unit = {"value": ${unitList}};
                $("#jQGrid").jqGrid({
                    url: "/admin/userMasterAll.htm",
                    datatype: "json",
                    mtype: "GET",
                    colNames: ['User Id', 'First Name', 'Last Name', 'UserName', 'EmailId', 'Password', 'Active', 'Designation', 'Location', 'Unit'],
                    colModel: [
                        {name: 'userId', index: 'userId', width: 10, searchoptions: {sopt: (['eq'])}, editrules: {edithidden: true, required: true}},
                        {name: 'firstName', editable: true, hidden: true, search: false, editrules: {required: true, edithidden: true}},
                        {name: 'lastName', editable: true, hidden: true, search: false, editrules: {required: true, edithidden: true}},
                        {name: 'userName', width: 30, editable: true, searchoptions: {sopt: (['bw', 'cn', 'ne', 'eq', 'ew'])}, editrules: {required: true}},
                        {name: 'emailId', editable: true, hidden: true, search: false, editoptions: {size: 25}, editrules: {email: true, required: true, edithidden: true}},
                        {name: 'userPass', width: 100, editable: true, search: false, hidden: true, edittype: 'password', editrules: {edithidden: true, required: true}},
                        {name: 'active', width: 100, search: false, edittype: 'checkbox', hidden: true, editrules: {edithidden: false}},
                        {name: 'designation.id', width: 20, index: 'designation.id',
                            editable: true, viewable: true, edittype: 'select', search: false, editrules: {edithidden: true, required: true},
                            formatter: 'select',
                            editoptions: designation

                        },
                        {name: 'location.id', index: 'location.id', width: 20, viewable: true, search: false, editrules: {edithidden: true, required: true},
                            editable: true, edittype: 'select', formatter: 'select',
                            editoptions: location

                        },
                        {name: 'unit.id', index: 'unit.id', width: 20,
                            editable: true, viewable: true, edittype: 'select', search: false, editrules: {edithidden: true, required: true},
                            formatter: 'select',
                            editoptions: unit

                        }
                    ],
                    jsonReader: {repeatitems: false, id: "userId"},
                    multiselect: false,
                    paging: true,
                    rowNum: 20,
                    rowList: [20, 25],
                    pager: $('#sandgrid'),
                    caption: '',
                    sortname: 'userId',
                    sortorder: 'asc',
                    viewrecords: true,
                    height: 'auto',
                    autowidth: true,
                    width: 800,
                    loadtext: "Loading...",
                    sortable: true,
                    ondblClickRow: function(id) {
                        if (isRowEditable(id)) {
                            $("#jQGrid").jqGrid('editRow', id, true, null, null, '/admin/editUser.htm');
                        }
                    },
                    onSelectRow: function(id) {
                        if (id && id !== lastSel) {
                            $("#jQGrid").jqGrid('restoreRow', lastSel);
                            lastSel = id;
                        }
                    }
                })
                        .navGrid('#sandgrid', {
                            'search': true
                        },
                        {
                            url: "/admin/editUser.htm",
                            closeAfterEdit: true,
                            beforeShowForm: function(form) {
                                $('#userId', form).attr('readonly', 'readonly');
                            },
                            width: '370', height: '300'
                        },
                        {
                            url: "/admin/addUser.htm",
                            afterSubmit: function(serverResponse) {
                                if (serverResponse.responseText == '"new user"') {
                                    return [true, "NEW USER ", null];
                                } else {
                                    return [false, serverResponse.responseText, null];
                                }
                            },
                            width: '370', height: '300',
                            closeAfterAdd: true,
                            closeOnEscape: true
                        },
                        {
                            url: "/admin/deleteUser.htm",
                            width: '350'
                        },
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
            });</script>

    </head>
    <body ><br>

        <table id="tablecss" width="90%">
            <caption>UserMaster List</caption>
            <br/>
            <tr align="center">
                <td>
                    <table id="jQGrid"></table>
                    <div id="sandgrid"></div>
                </td>
            </tr>
        </table>
    </body>
</html>
