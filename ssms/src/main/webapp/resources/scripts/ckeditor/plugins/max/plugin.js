function openDiv(parentEditor) {
    $('<div id="divck" style="width:100%;height:10%;"></div>').appendTo('body');
   // var remarks = $('#remarks__').val();
   var remarks = parentEditor.getData();
    var e = CKEDITOR.replace('divck', {
        toolbar: [
            ['Bold', 'Italic', 'Underline', 'TextColor', 'BGColor', 'NumberedList', 'BulletedList', 'JustifyLeft', 'JustifyCenter', 'JustifyRight', 'Format', 'Font', 'FontSize', 'Table', 'Maximize', 'up']
        ],
        on: {
            'instanceReady': function (evt) {
                new CKEDITOR.focusManager(evt.editor).focus();

                evt.editor.execCommand('maximize');

            },
            'maximize': function (evt) {
                if (evt.data == 2) { // closing
                    parentEditor.setData(evt.editor.getData().replace(/(\r\n|\n|\r)/gm, ""));
                    evt.editor.updateElement();
                    evt.editor.destroy();
                    $('#divck').remove();
                    var focusManager = new CKEDITOR.focusManager(parentEditor);
                    focusManager.focus();
                   
                }
            }
        },
        enterMode: 2, forceEnterMode: false, shiftEnterMode: 1
    });
    CKEDITOR.instances.divck.setData(remarks);
    e.config.extraPlugins = 'up';
//            .dialog({
//                modal: true, autoOpen: true, width: '800', height: 'auto', resizable: false,
//                open: function () {
//                    var remarks = $('#remarks__').val();
//                    var e = CKEDITOR.replace('divck', {
//                        height: 120,
//                        toolbar: [
//                            ['Bold', 'Italic', 'Underline', 'TextColor', 'BGColor', 'NumberedList', 'BulletedList', 'JustifyLeft', 'JustifyCenter', 'JustifyRight', 'Format', 'Font', 'FontSize', 'Table', 'Maximize', 'up']
//                        ],
//                        on: {
//                            'instanceReady': function (evt) {
//                                evt.editor.execCommand('maximize');                                
//                            },
//                            'maximize' : function (evt){
//                                if(evt.data==2){ // closing
//                                    CKEDITOR.instances.remarks__.setData(evt.editor.getData().replace(/(\r\n|\n|\r)/gm, ""));
//                                    $('divck').remove();
//                                }
//                            }
//                        },
//                        enterMode: 2, forceEnterMode: false, shiftEnterMode: 1
//                    });
//                    CKEDITOR.instances.divck.setData(remarks);
//                    e.config.extraPlugins = 'up';
//                },
//                close: function () {
//                    $(this).remove();
//                },
//                buttons: {
//                    Save: function () {
//                        var editor = CKEDITOR.instances.divck;
//                        CKEDITOR.instances.remarks__.setData(editor.getData().replace(/(\r\n|\n|\r)/gm, ""));
//                        $(this).dialog("close");
//                    },
//                    Cancel: function () {
//                        $(this).dialog("close");
//                    }}
//            });
}

CKEDITOR.plugins.add('max',
        {
            init: function (editor)
            {
                var pluginName = 'max';

                editor.addCommand(pluginName,
                        {
                            exec: function (editor)
                            {
                                openDiv(editor);
                            },
                            canUndo: false
                        });

                editor.ui.addButton('Max',
                        {
                            label: 'PopUp',
                            command: pluginName,
                            icon: '/images/ckpopup.png'
                        });
            }
        });
