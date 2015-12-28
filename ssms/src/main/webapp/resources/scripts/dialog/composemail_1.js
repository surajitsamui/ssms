function composeMail() {
    $('#compose').click(function() {
        $('#composemail').remove('div');
        $(document.createElement('div'));
        $('<div id="composemail"></div>').appendTo('body');
        $('#composemail').load('/mail/compose.htm', function() {
            $('#composemail').dialog(
                    {autoopen: true, modal: true, title: 'New Message', minHeight: 440, minWidth: 670, height: 460, width: 670,
                        position: {'my': 'left-100', 'at': 'bottom'}, resizable: false, draggable: false,
                        buttons: {
                            SEND: function() {
                                var nicE = new nicEditors.findEditor('message');
                                var msg = nicE.getContent();
                                document.composeform.message.value = msg;
                                document.composeform.method = 'POST';
                                document.composeform.action = '/mail/compose.htm';
                                document.composeform.submit();
                            }
                        },
                        close: function() {
                            $(this).remove();
                        }
                    }).dialogExtend({
                closable: true,
                maximizable: true,
                minimizable: true,
                dblclick: "minimize"
            });
        });
    });
}


