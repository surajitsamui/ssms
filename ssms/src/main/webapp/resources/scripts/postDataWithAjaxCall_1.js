function ajaxPost(message, postUrl, successUrl) {
    document.createElement('div')
    $('<div ></div>').appendTo('body')
            .html('<div style="color:#333;font-size:13px;">' + message + '</div>')
            .dialog({
                modal: true, autoOpen: true, title: 'Warning', width: '300', height: 'auto',
                buttons: {
                    Yes: function() {
                        $(this).dialog("close");
                        $.ajax({type: 'POST',
                            url: postUrl,
                            success: function(response) {
                                alert(response);
                                if (successUrl === null || successUrl === '' || successUrl === 'undefined') {
                                    return false;
                                } else {
                                    window.location = successUrl;
                                }
                            }});
                    },
                    No: function() {
                        $(this).dialog("close");
                    }
                },
                close: function(event, ui) {
                    $(this).remove();
                }
            });
}
function PostDataWithAjax(message, postUrl, data, successUrl) {
    document.createElement('div')
    $('<div ></div>').appendTo('body')
            .html('<div style="color:#333;font-size:13px;">' + message + '</div>')
            .dialog({
                modal: true, autoOpen: true, title: 'Warning', width: '300', height: 'auto',
                buttons: {
                    Yes: function() {
                        $(this).dialog("close");
                        $.ajax({type: 'POST',
                            url: postUrl,
                            data: data,
                            success: function(response) {
                                alert(response);
                                if (successUrl === null || successUrl === '' || successUrl === 'undefined') {
                                    return false;
                                } else {
                                    window.location = successUrl;
                                }
                            }});
                    },
                    No: function() {
                        $(this).dialog("close");
                    }
                },
                close: function(event, ui) {
                    $(this).remove();
                }
            });
}


