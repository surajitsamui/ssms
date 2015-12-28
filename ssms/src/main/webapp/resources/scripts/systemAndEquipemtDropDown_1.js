
function addSystemDropDown(loaNo) {
    if ($('#__showSysDiv__').length === 0) {
        $('<div id="__showSysDiv__"  style="width:400px;"></div>').appendTo('body');
        $('<table id="__sysGrid__"></table>').appendTo($('#__showSysDiv__'));
        $('<div id="__sysGridPager__" ></div>').appendTo($('#__showSysDiv__'));
        $("#__sysGrid__").jqGrid({
            url: '/edraw/getsystemdropvlaues/' + loaNo,
            datatype: 'json',
            colNames: ["id", "System"],
            colModel: [
                {name: 'id', index: 'id', editable: true, sortable: false, hidden: true, editoptions: {defaultValue: '0'}},
                {name: 'system', index: 'system', editable: true, sortable: false, width: 50}
            ],
            autowidth: true,
            height: '300',
            loadui: false,
            pager: '#__sysGridPager__',
            editurl: '/edraw/addSystemdropdownvalue.htm?loaNo=' + loaNo
        }).jqGrid('navGrid', '#__sysGridPager__', {edit: true, add: true, del: true, search: false, refresh: false}, {closeAfterEdit: true}, {closeAfterAdd: true});
        $("#__showSysDiv__").dialog({
            title: 'Add System Drop Down', width: 450, height: 450, modal: false, draggable: false, resizable: false, autoResize: true,
            close: function() {
                $("#__showSysDiv__").dialog("close");
                $("#__sysGrid__").jqGrid("setGridParam", {datatype: "json"}).trigger("reloadGrid");
            }
        });
    } else {
        $('#__showSysDiv__').dialog('open');
    }
}

function addEquipmentDropDown(loaNo) {
    if ($('#__showEquipmentDiv__').length === 0) {
        $('<div id="__showEquipmentDiv__"  style="width:400px;"></div>').appendTo('body');
        $('<table id="__equipmentGrid__"></table>').appendTo($('#__showEquipmentDiv__'));
        $('<div id="__equipmentGridPager__" ></div>').appendTo($('#__showEquipmentDiv__'));
        $("#__equipmentGrid__").jqGrid({
            url: '/edraw/getequipmentdropvlaues/' + loaNo,
            datatype: 'json',
            colNames: ["id", "Equipment"],
            colModel: [
                {name: 'id', index: 'id', editable: true, sortable: false, hidden: true, editoptions: {defaultValue: '0'}},
                {name: 'equipment', index: 'equipment', editable: true, sortable: false, width: 50}
            ],
            autowidth: true,
            height: '300',
            loadui: false,
            pager: '#__equipmentGridPager__',
            editurl: '/edraw/addEquipmentdropdownvalue.htm?loaNo=' + loaNo
        }).jqGrid('navGrid', '#__equipmentGridPager__', {edit: true, add: true, del: true, search: false, refresh: false}, {closeAfterEdit: true}, {closeAfterAdd: true});
        $("#__showEquipmentDiv__").dialog({
            title: 'Add Equipment Drop Down', width: 450, height: 450, modal: false, draggable: false, resizable: false, autoResize: true,
            close: function() {
                $("#__showEquipmentDiv__").dialog("close");
                $("#__equipmentGrid__").jqGrid("setGridParam", {datatype: "json"}).trigger("reloadGrid");
            }
        });
    } else {
        $('#__showEquipmentDiv__').dialog('open');
    }
}


