var y, d, f, c;
function openFiles(editor) {
    c = {
        context: d,
        callback: f,
        requiresImage: c
    };
    if (!y) {
        y = document.createElement("input");
        y.type = "file";
        y.style.overflow = "hidden";
        y.style.width = "1px";
        y.style.height = "1px";
        y.style.opacity = 0.1;
        y.multiple = "multiple";
        y.position = "absolute";
        y.zIndex = 1E3;
        document.body.appendChild(y);
        y.addEventListener("change", function () {
            var a = y.files.length;
            if (a) {
//                v.fire("saveSnapshot");
                for (var b = 0; b < a; b++) {
                    var c = y.files[b];
                    var formData = new FormData();
                    formData.append('file', c);
                    var i = new XMLHttpRequest;
                    i.open("POST", '/common/uploadFile');
                    i.onload = function () {                
                        if (i.status != 200) {
                            i.status == 413 ? alert('fileTooBig') : alert("Error posting the file to " + c.url + "\r\nResponse status: " + i.status);
                            window.console && console.log(i)
                        } else {
                            var retFile = JSON.parse(i.responseText);
                            d = new CKEDITOR.dom.element("a", editor.document);
                            d.setText(retFile[0].fileName);
                            d.setAttribute("href", retFile[0].tmpFile);
                            editor.insertElement(d);
                        }
                    };
                    i.onerror = function (a) {
                        alert("Error posting the file to " + c.url);
                        window.console && console.log(a);
                        (a = b.document.getById(c.id)) && (c.originalNode ? a.$.parentNode.replaceChild(c.originalNode, a.$) : a.remove());
                        b.fire("updateSnapshot")
                    };
                    i.onabort = function () {
                        if (c.callback)
                            c.callback.upload(null);
                        else {
                            var a = b.document.getById(c.id);
                            a && (c.originalNode ? a.$.parentNode.replaceChild(c.originalNode, a.$) : a.remove());

                        }
                    };
                    i.send(formData);

                }
            }
        })
    }
    y.value = "";
//    y.simpleUploadData = c;
//    if (CKEDITOR.env.webkit) {
//        var h = b.focusManager;
//        if (h && h.lock) {
//            h.lock();
//            setTimeout(function () {
//                h.unlock()
//            }, 500)
//        }
//    }
    y.click();
}

CKEDITOR.plugins.add('up',
        {
            init: function (editor)
            {
                var pluginName = 'up';

                editor.addCommand(pluginName,
                        {
                            exec: function (editor)
                            {
                                openFiles(editor);
                            },
                            canUndo: false
                        });

                editor.ui.addButton('up',
                        {
                            label: 'Add File',
                            command: pluginName,
                            icon: '/images/uploadIcon.png'
                        });
            }

        });
