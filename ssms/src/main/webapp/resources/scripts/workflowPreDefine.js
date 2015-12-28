/* 
 * Used to define workflow
 */

var graph = new Springy.Graph();
var maxLevel = 1;
var selectedNode = null;
var maxLvlId = 1;
var initiatorNode = null;
var data = [];

function initNode(userId, userDesc) {
    graph = new Springy.Graph();
    maxLevel = 1;
    selectedNode = null;
    maxLvlId = 1;
    initiatorNode = null;
    data = [];
    initiatorNode = graph.newNode({
        lvlId: 1,
        nextLvl: 2,
        userId: userId,
        label: userDesc, image: {src: "/images/face.jpg", height: 30, width: 30},
        ondoubleclick: function(node) {
            selectedNode = node;
            showRoles();
        }
    });
    selectedNode = initiatorNode;
}

function validateNode(val, direction) {
    var duplicate = false;
//    if (selectedNode.id == 0)
//    {
//        if (direction == "replace")
//        {
//            alert("Initiator Can not be Replaced");
//            return false;
//        }
//    }
    graph.nodes.forEach(function(e) {

        if (e.data.userId == val.userId) {
            alert("Already Exsist");
            duplicate = true;
            return false;
        }
    });
    if (duplicate) {
        return false;
    }
    return true;
}
function addNewNodes(val, direction) {
    node = selectedNode;
    if (selectedNode.id == 0) {
        if (selectedNode.data.userId == 0) {
            direction = "replace";
        }
    }
    if (direction != 'edit') {
        if (!validateNode(val, direction)) {
            return;
        }
    } else {
        direction = 'after';
    }
    if (direction == "replace")
    {
        selectedNode.data.userId = val.userId;
        selectedNode.data.label = val.userId + "(" + val.userName + ")" + "#" + val.desig;
        graph.notify();
        return;
    }
    var newNode = graph.newNode({lvlId: val.lvl, nextLvl: val.nextlvl, userId: val.userId, label: val.userId + "(" + val.userName + ")" + "#" + val.desig, image: {src: "/images/face.jpg", height: 30, width: 30}, ondoubleclick: function(node) {
            selectedNode = node;
            showRoles();
        }});
    var removedNode = null;
    graph.edges.forEach(function(e) {
        if (direction === 'after') {
            if (e.source.id === node.id) {
                removedNode = e;
                graph.removeEdge(e);
            }
        } else {//before
            if (e.target.id === node.id) {
                removedNode = e;
                graph.removeEdge(e);
            }
        }
    });
    if (direction === 'after') {
        graph.newEdge(node, newNode, {color: '#00A0B0'});
        if (removedNode !== null) {
            graph.newEdge(newNode, removedNode.target, {color: '#00A0B0'});
        }
    }
    else {
        if (removedNode !== null) {
            graph.newEdge(removedNode.source, newNode, {color: '#00A0B0'});
        }
        graph.newEdge(newNode, node, {color: '#00A0B0'});
    }
    node = null;
    selectedNode = newNode;
}

function saveWorkflow() {

    graph.edges.forEach(function(e) {
        data.push({lvl: e.source.data.lvlId, userId: e.source.data.userId, nextlvl: e.target.data.lvlId});
    });
    graph.edges.forEach(function(e) {
        var found = false;
        for (var i = 0; i < data.length; i++) {
            if (data[i].lvl == e.target.data.lvlId) {
                found = true;
            }
        }
        if (!found) {
            data.push({lvl: e.target.data.lvlId, userId: e.target.data.userId, nextlvl: 0});
        }
    });
    return data;
}

function showRoles() {
    if ($("#__workflow_user_div__").hasClass('ui-dialog-content')) { // in case a dialog is not defined not show
        $("#__workflow_user_div__").dialog("open");
    }
}

function deleteNode() {
    var srcNode = null;
    var tarNode = null;
    if (selectedNode == null)
        return;
    graph.edges.forEach(function(e) {
        if (e.source.data.userId === selectedNode.data.userId) {
            tarNode = e.target;
        } else if (e.target.data.userId === selectedNode.data.userId) {
            srcNode = e.source;
        }
    }
    );
    graph.removeNode(selectedNode);
    selectedNode = null;
    if (srcNode !== null && tarNode !== null) {
        graph.newEdge(srcNode, tarNode, {color: '#00A0B0'});
    }
}
//
//function dd() {
//
//    $("#dialog-form").dialog({
//        autoOpen: false,
//        height: 270,
//        width: 600
//    }
//    );
//    $("#userGrid").jqGrid({
//        url: "/admin/userMasterAll.htm",
//        datatype: "json",
//        colNames: ['CPF No.', 'Name', 'Designation'],
//        colModel: [
//            {name: 'userId', index: 'userId', sortable: false, width: 90, align: 'center'},
//            {name: 'userName', index: 'userName', sortable: false, width: 150, align: 'center'},
//            {name: 'desig', index: 'desg', sortable: false, width: 330, align: 'center'}
//
//        ],
//        ondblClickRow: function(rowId) {
//            var val = $('#userGrid').getRowData(rowId);
//            maxLevel++;
//            val.lvl = maxLevel;
//            addNewNodes(val, $('input[name=loc]:checked').val()); // todo            
//            $('#after').prop("checked", true);
//            $("#dialog-form").dialog("close");
//        }
//    });
//    var springy = window.springy = jQuery('#workflow').springy({
//        graph: graph,
//        nodeSelected: function(node) {
//            selectedNode = node;
//            console.log('Node selected: ' + JSON.stringify(node.data));
//        }
//    });
//    $(document).on("keydown", function(e) {
//        if (e.which === 46)
//            if (selectedNode != null && selectedNode.id != 0) {
//                if (window.confirm("delete node " + selectedNode.data.label)) {
//                    deleteNode();
//                }
//            }
//
//    });
//}

function  tag_view_pre_workflow(id, docId, locId)
{
    var finalUrl = "/admin/exisitingPreWorkflow/id/" + id;
    if(docId!=0){
        $('#docId').val(docId);
    }
    if(locId!=0){
        $('#locId').val(locId);
    }
    if ($('#_workflow_canvas_').length == 0) {   //first time
//        $("<label for='wname'>Workflow Name</label>").appendTo($('#__workflow_canvas_div__'));
//        $("<input type='text' id='wname' size = '60' value='"+wname+"'>").appendTo($('#__workflow_canvas_div__'));
        
        $('<canvas id="_workflow_canvas_" width="820" height="530"></canvas>').appendTo($('#__workflow_canvas_div__'));
        $.ajax({url: finalUrl, cache: false})
                .done(function(wpath) {
                    var autoopen = false;
                    if (wpath == null || wpath.length == 0) {
                        initNode(0, 'New');
                        autoopen = true;
                    } else {
                        initNode(wpath[0].userId, wpath[0].nameDesig);
                    }
                    maxLevel = 1;
                    for (var i = 1; i < wpath.length; i++) {
                        addNewNodes({lvl: wpath[i].lvl, nextLvl: wpath[i].nextLvl, userId: wpath[i].userId, userName: wpath[i].nameDesig, desig: ''}, 'edit');
                        if (maxLevel < wpath[i].lvl) {
                            maxLevel = wpath[i].lvl;
                        }
                    }
                    var springy = window.springy = jQuery('#_workflow_canvas_').springy({
                        graph: graph,
                        nodeSelected: function(node) {
                            selectedNode = node;
                        }
                    });
                    $(document).on("keydown", function(e) {
                        if ($('#__workflow_canvas_div__').dialog("isOpen")) {
                            if (e.which === 46)
                                if (selectedNode != null && selectedNode.id != 0) {
                                    if (window.confirm("delete node " + selectedNode.data.label)) {
                                        deleteNode();
                                    }
                                }
                        }
                    });
                    $("<table id='__workflowuserGrid__'>").appendTo($("#__workflow_user_div__"));
                    $('<p id="__after__">').appendTo("#__workflow_user_div__");
                    $('<input />', {type: "radio", name: "loc", value: "after"}).appendTo("#__after__").after("After");
                    $('<input />', {type: "radio", name: "loc", value: "replace"}).appendTo("#__after__").after("Replace");
                    $('input[name=loc]:nth(' + (autoopen ? 1 : 0) + ')').attr("checked", "checked");
                    $("#__workflowuserGrid__").jqGrid({
                        url: "/admin/userMasterAll.htm",
                        datatype: "json",
                        colNames: ['CPF No.', 'Name', 'Designation'],
                        colModel: [
                            {name: 'userId', index: 'userId', sortable: false, width: 100, align: 'center', searchoptions: {sopt: ['eq']}},
                            {name: 'userName', index: 'userName', sortable: false, width: 220, align: 'center', searchoptions: {sopt: ['eq', 'bw', 'cn', 'ne']}},
                            {name: 'desig', index: 'desg', sortable: false, width: 200, align: 'center', searchoptions: {sopt: ['eq', 'ne']}}
                        ], rowNum: 20, height: 360, loadonce: false, rowList: [20, 30, 50], pager: $('#sandgrid'), paging: true, viewrecords: true,
                        ondblClickRow: function(rowId) {
                            var val = $('#__workflowuserGrid__').getRowData(rowId);
                            $("#__workflow_user_div__").dialog("close");
                            maxLevel++;
                            val.lvl = maxLevel;
                            addNewNodes(val, $('input[name=loc]:checked').val());// todo                                                        
                            $('input[name=loc]:nth(0)').attr("checked", "checked");
                        }
                    }).navGrid('#sandgrid', {'edit': false, 'edittext': "Edit", 'add': false, "addtext": "Add", 'del': false, 'deltext': "Delete", 'search': true, 'searchtext': "Search", 'refresh': false}, {multipleSearch: true})
                    $("#__workflow_user_div__").dialog({
                        title: "User Details",
                        autoOpen: autoopen,
                        height: 'auto',
                        width: 'auto',
                        modal: false

                    });

                }).fail(function(jqXHR, textStatus) {
            alert("Request failed: " + textStatus);
        });
    }
    $("#__workflow_canvas_div__").dialog({title: 'New Workflow',
        autoOpen: true,
        resizable: false,
        height: 630,
        width: 850,
        modal: false,
        close: function(event, ui) {
            $("#__workflow_user_div__").dialog("close");
            $("#_workflow_canvas_").remove();
            $('#__after__').remove();
        },
        buttons: {"Save": function() {
                var docId= $('#docId').val();
                var locId = $('#locId').val();
                if (docId == 0 || docId =='') {
                    alert("Please select the document for which this workflow is defined");
                    return;
                }
                if(locId==0||locId==''){
                    alert("Please select the location for which this workflow is defined");
                    return;
                }
                var data = saveWorkflow();
                $.ajax({
                    url: '/admin/saveWorkFlow/' + id,
                    type: 'POST',
                    data: JSON.stringify({docId:docId, locId:locId ,wpath: data, remarks: $("#remarkstext").val()}),
                    contentType: "application/json; charset=utf-8",
                    dataType: 'json'
                }).done(function(status) {
                    if (status == "Successfully Saved" ) {
//                        alert("Successfully Saved");
                        $('#__workflow_canvas_div__').dialog("close");
                    } else {
                        alert(status);
                    }
                }).fail(function(jqXHR, textStatus) {
                    alert("failed: " + textStatus);
                });
            }, "Cancel": function() {
                $(this).dialog("close");
                $("#remarkstext").val('');
            }}
    });
    $("#__workflow_canvas_div__").focus();

}

function newLine(cellvalue, options, rowObject) {
    return cellvalue.split("+").join('<br />');
}