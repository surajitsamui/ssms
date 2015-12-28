
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
        <script src="/scripts/springy.js"></script>
        <script src="/scripts/springyui.js"></script>
        <script src="/scripts/workflowPreDefine.js"></script>

        <script type="text/javascript">
            $(function() {
                var users = {"value":${users}};
                var location = {"value": ${loc}};
                var docNames = {"value": ${docs}};
                $("#wflist").jqGrid({
                    url: '/admin/listOfPredefinedWorkflow',
                    datatype: 'json',
                    colNames: ['WorkflowId', 'Document', 'Location', 'User', 'Date'],
                    colModel: [
                        {name: 'workflowId', index: 'workflowId', width: 100, resizable: false, sortable: false, search: false, hidden: true},
                        {name: 'docId', width: 100, editype: 'select', formatter: 'select', editoptions: docNames, sortable: false},
                        {name: 'locId', width: 100, editype: 'select', formatter: 'select', editoptions: location, sortable: false},
//                        {name: 'name', index: 'name', width: 300, resizable: false, sortable: false, searchoptions: {sopt: ['bw', 'cn', 'eq', 'ew', 'ne']}},
                        {name: 'createUserId', index: 'createUserId', sortable: false, editype: 'select', formatter: 'select', width: 200, editoptions: users, searchoptions: {sopt: ['bw', 'cn', 'eq', 'ew', 'ne']}},
                        {name: 'createdDate', index: 'createdDate', sortable: false, width: 100}

                    ],
                    height: 'auto',
                    rowNum: 20,
                    rowList: [10, 20, 30],
                    autowidth: true,
                    viewrecords: true,
                    pager: '#wfpager',
                    ondblClickRow: function(rowId) {
                        var val = $('#wflist').getRowData(rowId);
                        tag_view_pre_workflow(val.workflowId, val.docId, val.locId);
                    }
                }).jqGrid('navGrid', '#wfpager', {edit: false, add: true, del: false, searchOnEnter: true, closeAfterSearch: true, savekey: [true, 13], closeOnEscape: true, addfunc: function() {
                        tag_view_pre_workflow(0, 0, 0);
                    }});
            });
        </script>
    </head>
    <body>
        <div class="div div-grid" style="width: 90%;">
            <div class="div-heading"><h3 class="div-title">Predefined Workflow</h3></div>
            <table id="wflist"></table>
            <div id="wfpager"></div>
        </div>

        <div id="__workflow_canvas_div__" width="850" height="630" style="display: none">
            <table>
                <tr>
                    <td>Document</td>
                    <td>
                        <select id="docId">
                            <option value="0">--Select--</option>
                            <c:forEach items="${docNames}" var="doc">
                                <option value="${doc.key}">${doc.value}</option>
                            </c:forEach>
                        </select>
                    </td>
                    <td>Location</td>
                    <td>
                        <select id="locId">
                            <option value="0">--Select--</option>
                            <c:forEach items="${location}" var="loc">
                                <option value="${loc.id}">${loc.description}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
            </table>

        </div>
        <div id="sandgrid"></div>
        <div id="__workflow_user_div__"></div>
    </div>


</body>
</html>
