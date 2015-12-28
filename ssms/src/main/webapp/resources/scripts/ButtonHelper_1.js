/* 
 * helper methods for button panel
 * 
 */

var __ButtonClicked__ = '';
var __workflowSaveURL__ = '';
var _finallevel_ = true;

function _view_history_info(url_key) {
    if ($("#__view-remarks__").length == 0) { // first time so create the div
        $('<div id="__view-remarks__" title="View Remarks"></div>"').appendTo('body');

        $("#__view-remarks__").dialog({
            title: "Remarks",
            autoOpen: false,
            height: 600,
            width: 955,
            modal: true
        });
    }
    if ($('#__historyGrid__').length != 0) {
        $("#__historyGrid__").jqGrid('GridUnload');
        $("#__historyGrid__").remove();
    }
    tag_view_history(url_key);
}

function tag_view_history(url_key) {
    var finalUrl = "/workflow/common/history/" + url_key;
    $(document.createElement('div'));
    $('<div id="__view-history__"></div>').appendTo('body')
            .dialog({
                modal: true, autoOpen: false, height: 600, width: 955
            });
    if ($('#__historyGrid__').length === 0) {
        $("<table id='__historyGrid__'>").appendTo($("#__view-history__"));
        $("#__historyGrid__").jqGrid({
            url: finalUrl,
            datatype: "json",
            colNames: ['Date', 'CPF No.', 'User', 'Status', 'Remarks'],
            colModel: [
                {name: 'date', index: 'date', sortable: false, formatter: 'date', formatoptions: {srcformat: 'U/1000', newformat: 'd/m/Y g:i:s A'}, width: 90, align: 'center'},
                {name: 'userId', index: 'userId', sortable: false, width: 70, align: 'center'},
                {name: 'userName', index: 'userName', sortable: false, width: 200, align: 'center'},
                {name: 'dispStatus', index: 'dispStatus', sortable: false, width: 70, align: 'center'},
                {name: 'remarks', index: 'remarks', sortable: false, formatter: linkformatter, width: 480, align: 'center'}
            ], rowNum: '', height: 500
        });
    }
    $("#__view-history__").dialog("open");
    $("#__historyGrid__").jqGrid("setGridParam", {url: finalUrl, datatype: "json"}).trigger("reloadGrid");

}
function linkformatter(cellvalue, options, rowObject) {
    var finalTxt = rowObject.remarks;
    if (rowObject.filenames != null) {
        for (i = 0; i < rowObject.filenames.length; i++) {
            finalTxt = finalTxt + '<br/><a href=/common/viewfile/fileId/' + rowObject.filenames[i].fileId + '>' +
                    rowObject.filenames[i].fileName + "</a>";
        }
    }
    else if (rowObject.remarks == null)
    {
        return "";
    }
    return finalTxt;
}

function setupRefer(formId, repoKey, docStatus) {
    $('<div id="__referTouserPopup__"></div> title="User to be Refered"').appendTo('body');
    $('<div id="__view-remarks__" title="View Remarks"></div>"').appendTo('body');
    if (docStatus != 0) {
        $('<div id="__workflow_canvas_div__" class="cssdiv"><div style="position: absolute; bottom:0px;"><textarea name="remarkstext" id="remarkstext" cols="138" rows="3" placeholder="Enter Remarks"></textarea></div></div>"').appendTo('body');
    } else
    {
        $('<div id="__workflow_canvas_div__" class="parent"></div>"').appendTo('body');
    }
    var saveandcancel = {"Save": function() {
            var data = saveWorkflow();
            $.ajax({
                url: '/workflow/common/workflow/save/' + repoKey,
                type: 'POST',
                data: JSON.stringify({doc: repoKey, id: '0', wpath: data, remarks: $("#remarkstext").val()}),
                contentType: "application/json; charset=utf-8",
                dataType: 'json'
            }).done(function(status) {
                if (status == "OK" || status == "finalLevel") {
                    if (status != "finalLevel") {
                        _finallevel_ = false;
                    }
                    workflow_defined__=true; // defined in the jstl 
                    $('#__workflow_canvas_div__').dialog("close");
                } else {
                    alert(status);
                }
            }).fail(function(jqXHR, textStatus) {
                alert("failed: " + textStatus);
            });
        },
//        "Cancel": function() {
//            $(this).dialog("close");
//            $("#remarkstext").val('');
//        },
        "History": function() {
            tag_view_workflow_history(repoKey);
        },
    };
    var cancelonly = {"History": function() {
            tag_view_workflow_history(repoKey);
        },
        "Cancel": function() {
            $(this).dialog("close");
        }};
    $("#__workflow_canvas_div__").dialog({
        title: "WorkFlow",
        autoOpen: false,
        height: 680,
        width: 900,
        modal: false,
        buttons: docStatus == 0 || docStatus == 1 || docStatus == -1 ? saveandcancel : cancelonly
    });
    $("#__view-remarks__").dialog({
        title: "Remarks",
        autoOpen: false,
        height: 600,
        width: 955,
        modal: true
    });
    $("#__referTouserPopup__").dialog({
        title: "Refered User Details",
        autoOpen: false,
        height: 400,
        width: 'auto',
        modal: true
    });
    $("<table id='__referTouserGrid__'>").appendTo($("#__referTouserPopup__"));
    $("<div id='__pager__'></div>").appendTo($("#__referTouserPopup__"));
    var height = ($(window).height() * .30);
    $("#__referTouserGrid__").jqGrid({
        url: "/admin/userMasterAll.htm",
        datatype: "json",
        colNames: ['CPF No.', 'Name', 'Designation'],
        colModel: [
            {name: 'userId', index: 'userId', sortable: false, width: 90, align: 'center'},
            {name: 'userName', index: 'userName', sortable: false, width: 200, align: 'center'},
            {name: 'desig', index: 'desg', sortable: false, width: 180, align: 'center'}
        ],
        ondblClickRow: function(rowId) {
            var val = $('#__referTouserGrid__').getRowData(rowId);
            $("#__referTouserPopup__").dialog("close");
            $("#referTo").val(val.userId);
            $('<input/>').attr({type: 'hidden', id: 'Refer', name: 'refer'}).appendTo($('form:first'));
            __ButtonClicked__ = 'refer';
            document.forms[0].submit();
        },
        rowNum:10,
       pager: '#__pager__',
       height:height
    }).jqGrid('navGrid', '#__pager__', {edit: false, add: false, del: false, search: true, refresh: false},
        {}, {}, {}, {searchOnEnter: true, closeAfterSearch: true, savekey: [true, 13], closeOnEscape: true, jqModal: false});
}

function tag_button_clicked(buttonText) {
    try {
        if (typeof __hook_custom_func == 'function') {
            __hook_custom_func();
        }
    } catch (err) {
        console.log(" no custom function" + err);
    }

    if (buttonText === 'refer') {
        $("#__referTouserPopup__").dialog("open");
    } else {
        __ButtonClicked__ = buttonText;
    }
    _hide_buttonPannel();
}
function tag_reject() {
    var str = new String(document.forms[0].remarks.value);
    if (str == null || "" == str.replace(/^\\s+|\\s+$/g, "")) {
        alert("Enter Remarks");
        return false;
    }
    document.forms[0].onsubmit = null;
    _hide_buttonPannel();
    tag_button_clicked('reject');
    return true;
}

function tag_delete_click() {
    if (confirm('Are you sure you want to delete this document')) {
        document.forms[0].onsubmit = null;
        _hide_buttonPannel();
        return true;
    }
    tag_button_clicked('delete');
    return false;
}
;
function tag_cancel_click() {
    var h = document.createElement("input");
    document.forms[0].onsubmit = null;
    window.location = "/home.htm";
}

function tag_cancel_close_click() {
    if (self.opener != null) {
        window.close();
    } else {
        window.location = "/home.htm";
    }
}

function attachOnSubmitHook() {
    var oldSubmitHandler = null;
    if (typeof document.forms[0].onsubmit == 'function') {
        oldSubmitHandler = document.forms[0].onsubmit;
    }
    document.forms[0].onsubmit = function() {
        if (oldSubmitHandler != null) {
            if (!oldSubmitHandler()) {
                return false;
            }
        }
        _hide_buttonPannel();
    }
}

function _hide_buttonPannel(id) {
    $('#buttonPanel').hide();
}



function tag_verifySubmit_click() {
    try {
        if (typeof __hook_custom_func == 'function') {
            if(!__hook_custom_func()){
                return false;
            }
        }
    } catch (err) {
        console.log(" no custom function" + err);
    }
    if(!workflow_defined__){
        alert("Please define workflow");
        return false;
    }
    if (confirm('Are you sure you want to Submit this document')) {
        tag_button_clicked('submit');
        return true;
    }
    return false;
}

function tag_verifyApprove_click() {
    if (_finallevel_) {
        if (!confirm('You are the final person in the workflow,Do you want to Approve this document')) {
            return false;
        }
    }
    tag_button_clicked('approve');
    return true;
}
//$(function() {
//    setupRefer("ft");
//    attachOnSubmitHook();
//});