
function showVendorMaster(tenderNo, vendorIds, isSaved) {

    if ($('#__showVendorDiv__').length === 0 && tenderNo !== 'undefined') {
        $('<div id="__showVendorDiv__" style="width:600px;"></div>').appendTo('body');

        $('<table id="__vendorGrid__"></table>').appendTo($('#__showVendorDiv__'));
        $('<div id="__vendorGridPager__" ></div>').appendTo($('#__showVendorDiv__'));

        $("#__vendorGrid__").jqGrid({
            url: "/vendor/vendorMasterAll.htm",
            datatype: "json",
            colNames: ['ID', 'Company Name'],
            colModel: [
                {name: 'id', index: 'id', width: 100, sortable: false, align: 'center', searchoptions: {sopt: (['eq'])}},
                {name: 'companyName', index: 'companyName', sortable: false, width: 460, searchoptions: {sopt: (['bw', 'cn', 'eq', 'ne'])}}
            ],
            multiselect: true,
            height: '400',
            autowidth: true,
            pgbuttons: false,
            pgtext: null,
            pager: '#__vendorGridPager__',
            viewrecords: false,
            rowNum: 1000,
            gridComplete: function() {
                $.each(vendorIds, function(i, rowId) {
                    $("#__vendorGrid__").jqGrid('setSelection', rowId, false);
                });
            }
        }).jqGrid('navGrid', '#__vendorGridPager__', {edit: false, add: false, del: false, search: false, refresh: false},
        {}, {}, {}, {searchOnEnter: true, closeAfterSearch: true, savekey: [true, 13], closeOnEscape: true, jqModal: true});

        $("#__showVendorDiv__").dialog({
            title: 'Vendor Selection',
            width: 640,
            height: 500,
            modal: true,
            draggable: false,
            resizable: false,
            autoResize: true,
            close: function() {
                $("#__showVendorDiv__").jqGrid('GridUnload');
                $("#__showVendorDiv__").remove();
            },
            buttons: {
                SUBMIT: function() {
                    var ids = $("#__vendorGrid__").jqGrid('getGridParam', 'selarrrow');
                    if (ids.length == 0) {
                        alert("please, select at least one vendor");
                        return false;
                    }
                    $.ajax({type: 'POST',
                        url: '/tenderAssign/tenderNo/' + tenderNo + '/vendorIds/' + ids,
                        success: function(reponse) {
                            alert(reponse);
                            window.location = '/nib/Entry/tender/' + tenderNo;
                        }});
                    $(this).dialog("close");
                }},
            open: function() {
                if (!isSaved) {
                    $(this).dialog('widget').parent().find('.ui-dialog-buttonset').empty();
                }
            }
        });
    } else {
        $('#__showVendorDiv__').dialog('open');
    }
}