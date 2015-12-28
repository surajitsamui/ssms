    
<%-- 
    Document   : menu
    Created on : Sep 25, 2013, 6:04:44 PM
    Author     : mmc-pc1
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title>Menu page</title>
        <link rel="stylesheet" href="/css/jqgrid-ccms.css" type="text/css"/>
        <link rel="stylesheet" type="text/css" href="/css/jquery-ui.css" />
        <link rel="stylesheet" type="text/css" href="/css/ui.jqgrid.css" />
        <script type="text/javascript" src="/scripts/jquery.min.js"></script>
        <script type="text/javascript" src="/scripts/grid.locale-en.js"></script>
        <script type="text/javascript">
            $.jgrid.no_legacy_api = true;
            $.jgrid.useJSON = true;</script>
        <script type="text/javascript" src="/scripts/jquery.jqGrid.src.js"></script>
        <script type="text/javascript">
            $(function() {
                var dropdownvalue = {value:${menus}, readonly: 'readonly'};
                $("#list3").jqGrid({
                    url: '/admin/allmenu.htm',
                    datatype: 'json',
                    colNames: ['Menu Id', 'Menu Name', 'URL', 'Parent Name'],
                    colModel: [
                        {name: 'menuId', index: 'menuId', width: 100, editable: true, key: true, search: false, sortable: false, hidden: true, editrules: {edithidden: false}, editoptions: {defaultValue: '0', readonly: 'readonly'}},
                        {name: 'name', index: 'name', width: 220, editable: true, sortable: false, search: true, editrules: {required: true}, editoptions: {size: 40}, searchoptions: {sopt: ['cn', 'bw', 'eq', 'ew', 'ne']}},
                        {name: 'url', index: 'description', width: 450, editable: true, sortable: false, search: true, editoptions: {size: 40}, searchoptions: {sopt: ['cn', 'bw', 'eq', 'ew', 'ne']}},
                        {name: 'parentId', index: 'parentId', width: 180, editable: true, sortable: false, search: false, edittype: 'select',
                            formatter: 'select', editoptions: dropdownvalue}
                    ],
                    height: 'auto',
                    autowidth: true,
                    rowNum: 20,
                    rowList: [5, 10, 20],
                    pager: '#pager',
                    viewrecords: true,
                    ondblClickRow: function(id) {
                        if (isRowEditable(id)) {
                            $("#list3").jqGrid('editRow', id, true, null, null, '/admin/updatemenu.htm');
                        }
                    },
                    onSelectRow: function(id) {
                        if (id && id !== lastSel) {
                            $("#list3").jqGrid('restoreRow', lastSel);
                            lastSel = id;
                        }
                    }
                }).jqGrid('navGrid', '#pager', {add: true, edit: true, del: true, 'search': true, refresh: true},
                {url: '/admin/updatemenu.htm', closeAfterEdit: true, width: 400},
                {url: '/admin/addmenu.htm', closeAfterAdd: true, width: 400}, {url: '/admin/deletemenu.htm'}
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
        <table id="tablecss">            
            <caption>Menu Define</caption>
            <thead>
                <sf:form commandName="menu">
                    <sf:hidden path="menuId"/>
                    <tr>
                        <td style="background-color: #C2E9FF">Name</td>
                        <td>
                            <sf:input path="name" size="35" placeholder="Enter Menu Name"/>
                            <span style="color: red;font-size: 15px "><sf:errors path="name"/></span>
                        </td>
                        <td align="left">
                            <sf:select path="parentId">
                                <sf:options items="${parentIdLists}" itemValue="menuId" itemLabel="name"/>
                                <sf:option value="0" label="----------------Root----------------"/>
                            </sf:select>                           
                        </td>
                        <td style="background-color: #C2E9FF">URL</td>
                        <td><sf:input path="url" size="50" placeholder="Enter URL"/></td>
                        <td align="right"><input id="Button1" type="submit" value="Save"/></td>
                    </tr>

                </sf:form>
                <tr style="background-color: #003366;height: 25px;color: red">
                    <td align="center" colspan="6">
                        <b><span style="font-family:arial;color: #FFFFFF;;font-size:20px;">Menu List</span></b></td>
                </tr>
                <tr>
                    <td colspan="6">
                        <table id="list3"></table>
                        <div id="pager"></div>
                    </td>
                </tr>
            </thead>
        </table>
    </body>
</html>
