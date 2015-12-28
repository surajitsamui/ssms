
function showUserMaster(url, onClickHandler) {

    if (url == "") {
        url = "/admin/userMasterAll.htm";
    }
    
    if ($('#__showUserDiv__').length === 0) {
        console.log("new");
        $('<div id="__showUserDiv__" ></div>').appendTo('body');

        $('<table id="__userGrid__"></table>').appendTo($('#__showUserDiv__'));
        $('<div id="__userGridPager__" ></div>').appendTo($('#__showUserDiv__'));

        $("#__userGrid__").jqGrid({
            url: url,
            datatype: "json",
            colNames: ['CPF No.', 'Name'],
            colModel: [
                {name: 'userId', index: 'userId', width: 100, align: 'center', searchoptions: {sopt: (['eq'])}},
                {name: 'userName', index: 'userName', width: 460, searchoptions: {sopt: (['bw', 'cn', 'eq', 'ne'])}}
            ],
            height: '100%',
            jqModal: true,
            width: 'auto',
            pager: '#__userGridPager__',
            viewrecords: true,
            rowNum: 20,
            ondblClickRow: function(rowId) {
                var userObj = $(this).jqGrid('getRowData', rowId);
                if (onClickHandler != null && typeof onClickHandler == 'function') {                   ;                    
                    onClickHandler(userObj);
                }
                $("#__showUserDiv__").dialog("close");

            }
        }).jqGrid('navGrid', '#__userGridPager__', {edit: false, add: false, del: false, search: true, refresh: false},
        {}, {}, {}, {searchOnEnter: true, closeAfterSearch: true, savekey: [true, 13], closeOnEscape: true, jqModal: true});

        $("#__showUserDiv__").dialog({
            title: 'User Selection',
            width: 600,
            height: 470,
            draggable: false,
            resizable: false,
            autoResize: true,
            show: {
                effect: "blind",
                duration: 500
            },
            close: function() {
                 $("#__showUserDiv__").jqGrid('GridUnload');
                $("#__showUserDiv__").remove();
            }

        });
    } else {
        console.log("show");
        $('#__showUserDiv__').dialog('open');
    }
}