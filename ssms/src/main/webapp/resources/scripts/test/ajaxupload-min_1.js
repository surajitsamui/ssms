(function(d){function g(a){return l?l[a]||a:a}var p={it_IT:{"Add files":"Aggiungi file","Start upload":"Inizia caricamento","Remove all":"Rimuvi tutti",Close:"Chiudi","Select Files":"Seleziona",Preview:"Anteprima","Remove file":"Rimuovi file",Bytes:"Bytes",KB:"KB",MB:"MB",GB:"GB","Upload aborted":"Interroto","Upload all files":"Carica tutto","Select Files or Drag&Drop Files":"Seleziona o Trascina qui i file","File uploaded 100%":"File caricato 100%"},sq_AL:{"Add files":"Shto file","Start upload":"Fillo karikimin", "Remove all":"Hiqi te gjith\u00eb",Close:"Mbyll","Select Files":"Zgjith filet",Preview:"Miniatur\u00eb","Remove file":"Hiqe file-in",Bytes:"Bytes",KB:"KB",MB:"MB",GB:"GB","Upload aborted":"Karikimi u nd\u00ebrpre","Upload all files":"Kariko t\u00eb gjith\u00eb","Select Files or Drag&Drop Files":"Zgjith ose Zvarrit dokumentat k\u00ebtu","File uploaded 100%":"File u karikua 100%"},nl_NL:{"Add files":"Bestanden toevoegen","Start upload":"Start uploaden","Remove all":"Verwijder alles",Close:"Sluiten", "Select Files":"Selecteer bestanden",Preview:"Voorbeeld","Remove file":"Verwijder bestand",Bytes:"Bytes",KB:"KB",MB:"MB",GB:"GB","Upload aborted":"Upload afgebroken","Upload all files":"Upload alle bestanden","Select Files or Drag&Drop Files":"Selecteer bestanden of Drag&Drop bestanden","File uploaded 100%":"Bestand ge\u00fcpload 100%"},de_DE:{"Add files":"Dateien hinzuf\u00fcgen","Start upload":"Hochladen","Remove all":"Alle entfernen",Close:"Schliessen","Select Files":"Dateien w\u00e4hlen",Preview:"Vorschau", "Remove file":"Datei entfernen",Bytes:"Bytes",KB:"KB",MB:"MB",GB:"GB","Upload aborted":"Upload abgebrochen","Upload all files":"Alle hochgeladen","Select Files or Drag&Drop Files":"W\u00e4hlen Sie Dateien oder f\u00fcgen Sie sie mit Drag & Drop hinzu.","File uploaded 100%":"Upload 100%"},fr_FR:{"Add files":"Ajouter","Start upload":"Envoyer","Remove all":"Tout supprimer",Close:"Fermer","Select Files":"Parcourir",Preview:"Visualiser","Remove file":"Supprimer fichier",Bytes:"Bytes",KB:"Ko",MB:"Mo",GB:"Go", "Upload aborted":"Envoi annul\u00e9","Upload all files":"Tout envoyer","Select Files or Drag&Drop Files":"Parcourir ou Glisser/D\u00e9poser","File uploaded 100%":"Fichier envoy\u00e9 100%"}},l={},j=function(a,b,c,e,f){this.file=a;this.status=this.currentByte=0;this.name=b;this.size=c;this.info=this.xhr=null;this.ext=e;this.pos=f.files.length;this.AU=f;e=f.settings;c=this.sizeFormat();this.li=d("<li />").appendTo(this.AU.fileList).attr("title",b);e.bootstrap&&(this.li=d("<a />").appendTo(this.li)); this.prevContainer=d('<a class="ax-prev-container" />').appendTo(this.li);this.prevImage=d('<img class="ax-preview" src="" alt="'+g("Preview")+'" />').appendTo(this.prevContainer);this.details=d('<div class="ax-details" />').appendTo(this.li);this.nameContainer=d('<div class="ax-file-name">'+b+"</div>").appendTo(this.details);this.sizeContainer=d('<div class="ax-file-size">'+c+"</div>").appendTo(this.details);this.progressInfo=d('<div class="ax-progress" />').appendTo(this.li);this.progressBar=d('<div class="ax-progress-bar" />').appendTo(this.progressInfo); this.progressPer=d('<div class="ax-progress-info">0%</div>').appendTo(this.progressInfo);this.buttons=d('<div class="ax-toolbar" />').appendTo(this.li);this.uploadButton=d('<a title="'+g("Start upload")+'" class="ax-upload ax-button" />').appendTo(this.buttons).append('<span class="ax-upload-icon ax-icon"></span>');this.removeButton=d('<a title="Remove file" class="ax-remove ax-button" />').appendTo(this.buttons).append('<span class="ax-clear-icon ax-icon"></span>');e.bootstrap&&(this.li.addClass("media thumbnail"), this.prevContainer.addClass("pull-left"),this.prevImage.addClass("img-rounded media-object"),this.details.addClass("label label-info").css({"border-bottom-left-radius":0}),this.progressInfo.addClass("progress progress-striped active").css({"margin-bottom":0}),this.progressBar.addClass("bar"),this.buttons.addClass("label label-info").css({"border-top-left-radius":0,"border-top-right-radius":0}),this.uploadButton.addClass("btn btn-success btn-small").find("span").addClass("icon-play"),this.removeButton.addClass("btn btn-danger btn-small").find("span").addClass("icon-minus-sign")); f.hasHtml4&&(c=f.getUrl(b,0),c=d('<form action="'+c+'" method="post" target="ax-main-frame" encType="multipart/form-data" />').hide().appendTo(this.li),c.append(a),c.append('<input type="hidden" value="'+encodeURIComponent(b)+'" name="ax-file-name" />'),this.xhr=c);this.bindEvents();this.doPreview()};j.prototype.sizeFormat=function(){var a=this.size;"undefined"==typeof precision&&(precision=2);for(var b=[g("Bytes"),g("KB"),g("MB"),g("GB")],c=0;1024<=a&&c<b.length-1;)a/=1024,c++;var d=Math.round(a), f=Math.pow(10,precision),a=Math.round(a*f%f);return d+"."+a+" "+b[c]};j.prototype.bindEvents=function(){this.uploadButton.bind("click",this,function(a){a.data.AU.settings.enable&&(2!=a.data.status?(a.data.startUpload(!1),d(this).addClass("ax-abort")):(a.data.stopUpload(),d(this).removeClass("ax-abort")))});this.removeButton.bind("click",this,function(a){a.data.AU.settings.enable&&a.data.AU.removeFile(a.data.pos)});this.AU.settings.editFilename&&this.nameContainer.bind("dblclick",this,function(a){if(a.data.AU.settings.enable){a.stopPropagation(); var b=a.data.ext;a=a.data.name.replace("."+b,"");d(this).html('<input type="text" value="'+a+'" />.'+b)}}).bind("blur focusout",this,function(a){a.stopPropagation();var b=d(this).children("input").val();"undefined"!=typeof b&&(b=b.replace(/[|&;$%@"<>()+,]/g,"")+"."+a.data.ext,d(this).html(b),a.data.name=b,a.data.AU.hasAjaxUpload||a.data.xhr.children('input[name="ax-file-name"]').val(b))})};j.prototype.doPreview=function(){if(this.AU.hasAjaxUpload&&this.file.type.match(/image.*/)&&("jpg"==this.ext|| "gif"==this.ext||"png"==this.ext)&&"undefined"!==typeof FileReader){var a=this.name,b=this;this.prevContainer.css("background","none");var c=this.prevImage,e=new FileReader;e.onload=function(f){c.css("cursor","pointer").attr("src",f.target.result).click(function(){var c=new Image;c.onload=function(){var c=Math.min(d(window).width()/this.width,(d(window).height()-100)/this.height),e=1>c?this.width*c:this.width,c=1>c?this.height*c:this.height,g=d(window).scrollTop()-20+(d(window).height()-c)/2,q=(d(window).width()- e)/2,g=d("#ax-box").css({top:g,height:c,width:e,left:q});g.children("img").attr({width:e,height:c,src:f.target.result});d("#ax-box-fn").find("span").html(a+" ("+b.sizeFormat()+")");g.fadeIn(500);d("#ax-box-shadow").css("height",d(document).height()).show()};c.src=f.target.result;d("#ax-box-shadow").css("z-index",1E4);d("#ax-box").css("z-index",10001)})};e.readAsDataURL(this.file)}else this.prevContainer.addClass("ax-filetype-"+this.ext).children("img:first").remove()};j.prototype.startUpload=function(a){this.AU.upload_all= a;this.AU.settings.beforeUpload.call(this,this.name,this.file)&&(this.progressBar.css("width","0%"),this.progressPer.html("0%"),this.uploadButton.addClass("ax-abort"),this.status=2,this.AU.hasAjaxUpload?this.uploadAjax():this.AU.hasFlash?this.AU.flashObj.uploadFile(this.pos):this.uploadStandard(a))};j.prototype.uploadAjax=function(){var a=this.AU.settings,b=this.file,c=this.currentByte,d=this.name,f=this.size,g=a.chunkSize,n=g+c,j=0>=f-n,h=b,l=n/g;this.xhr=new XMLHttpRequest;0==c&&this.AU.slots++; 0==g?(h=b,j=!0):b.mozSlice?h=b.mozSlice(c,n):b.webkitSlice?h=b.webkitSlice(c,n):b.slice?h=b.slice(c,n):(h=b,j=!0);var k=this;this.xhr.upload.addEventListener("abort",function(){k.AU.slots--},!1);this.xhr.upload.addEventListener("progress",function(a){a.lengthComputable&&(a=Math.round(100*(a.loaded+l*g-g)/f),k.onProgress(a))},!1);this.xhr.upload.addEventListener("error",function(){k.onError(this.responseText)},!1);this.xhr.onreadystatechange=function(){if(4==this.readyState&&200==this.status)try{var a= JSON.parse(this.responseText);0==c&&(k.name=a.name,k.nameContainer.html(a.name));if(-1==parseInt(a.status))throw a.info;j?(k.AU.slots--,k.onFinish(a.name,a.size,a.status,a.info)):(k.currentByte=n,k.uploadAjax())}catch(b){k.AU.slots--,k.onError(b)}};b=this.AU.getUrl(d,f);this.xhr.open("POST",b+("&ax-start-byte="+c+"&isLast="+j),a.async);a=navigator.userAgent.match(/Firefox\/(\d+)?/);a=null!==a&&void 0!==a[1]&&!isNaN(a[1])?parseInt(a[1]):7;void 0!==window.FormData&&6<a?(a=new FormData,a.append("ax_file_input", h),this.xhr.send(a)):(this.xhr.setRequestHeader("Cache-Control","no-cache"),this.xhr.setRequestHeader("X-Requested-With","XMLHttpRequest"),this.xhr.setRequestHeader("Content-Type","application/octet-stream"),this.xhr.send(h))};j.prototype.uploadStandard=function(a){this.progressBar.css("width","50%");this.progressPer.html("50%");d("#ax-main-frame").unbind("load").bind("load",this,function(b){var c;this.contentDocument?c=this.contentDocument:this.contentWindow&&(c=this.contentWindow.document);var e= null;try{e=d.parseJSON(c.body.innerHTML),b.data.onProgress(100),b.data.onFinish(e.name,e.size,e.status,e.info)}catch(f){b.data.onError(c.body.innerHTML)}void 0!==a&&void 0!==b.data.AU.files[b.data.pos+1]&&b.data.AU.files[b.data.pos+1].startUpload(a)});this.xhr.submit()};j.prototype.stopUpload=function(){if(this.AU.hasAjaxUpload)null!==this.xhr&&(this.xhr.abort(),this.xhr=null);else if(this.AU.hasFlash)this.AU.flashObj.stopUpload(this.pos);else{var a=document.getElementById("ax-main-frame");try{a.contentWindow.document.execCommand("Stop")}catch(b){a.contentWindow.stop()}}this.uploadButton.removeClass("ax-abort"); this.status=this.currentByte=0;this.progressBar.css("width",0);this.progressPer.html(g("Upload aborted"))};j.prototype.onError=function(a){this.currentByte=0;this.status=-1;this.info=a;this.progressPer.html(a);this.progressBar.css("width","0%");this.uploadButton.removeClass("ax-abort");this.AU.settings.error.call(this,a,this.name);this.AU.settings.removeOnError&&this.AU.removeFile(this.pos)};j.prototype.onFinish=function(a,b,c,d){this.name=a;this.status=parseInt(c);this.info=d;!this.AU.hasAjaxUpload&& !this.AU.hasFlash&&(this.size=b,b=this.sizeFormat(),this.sizeContainer.html(b));this.currentByte=0;this.nameContainer.html(a);this.li.attr("title",a);this.onProgress(100);this.uploadButton.removeClass("ax-abort");this.progressBar.width(0);this.progressPer.html(g("File uploaded 100%"));this.AU.settings.success.call(this,a);a=!0;for(b=0;b<this.AU.files.length;b++)1!=this.AU.files[b].status&&-1!=this.AU.files[b].status&&(a=!1);a&&!this.AU.finis_has_run&&(this.AU.finish(),this.AU.finis_has_run=!0);this.AU.settings.removeOnSuccess&& this.AU.removeFile(this.pos)};j.prototype.onProgress=function(a){this.progressBar.css("width",a+"%");this.progressPer.html(a+"%")};var h=function(a,b){var c=document.createElement("input");c.type="file";this.hasAjaxUpload="multiple"in c&&"undefined"!=typeof File&&"undefined"!=typeof(new XMLHttpRequest).upload;this.hasFlash=!1;/Safari/.test(navigator.userAgent)&&(/Apple Computer/.test(navigator.vendor)&&/Version\/5\./.test(navigator.userAgent)&&/Win/.test(navigator.platform))&&(this.hasAjaxUpload= !1);if(!this.hasAjaxUpload)try{new ActiveXObject("ShockwaveFlash.ShockwaveFlash")&&(this.hasFlash=!0)}catch(e){void 0!=navigator.mimeTypes["application/x-shockwave-flash"]&&(this.hasFlash=!0)}this.hasHtml4=!this.hasFlash&&!this.hasAjaxUpload;this.$this=a;this.files=[];this.slots=0;this.settings=b;this.fieldSet=d("<fieldset />").append('<legend class="ax-legend">'+g("Select Files")+"</legend>").appendTo(a);this.form_submit_event=this.form=null;this.finis_has_run=!1;this.flashObj=null;this.upload_all= !1;this.max_size=b.maxFileSize;c=b.maxFileSize.slice(-1);if(isNaN(c))switch(this.max_size=this.max_size.replace(c,""),c){case "T":this.max_size*=1024;case "G":this.max_size*=1024;case "M":this.max_size*=1024;case "K":this.max_size*=1024}var f="ax-browse-c ax-button",c="ax-upload-all ax-button",h="ax-clear ax-button",j="ax-plus-icon ax-icon",l="ax-upload-icon ax-icon",m="ax-clear-icon ax-icon";b.bootstrap&&(f+=" btn btn-primary",c+=" btn btn-success",h+=" btn btn-danger",j+=" icon-plus-sign",l+=" icon-play", m+=" icon-remove-sign");this.browse_c=d('<a class="'+f+'" title="'+g("Add files")+'" />').append('<span class="'+j+'"></span> <span class="ax-text">'+g("Add files")+"</span>").appendTo(this.fieldSet);this.browseFiles=d('<input type="file" class="ax-browse" name="ax_file_input" />').attr("multiple",this.hasAjaxUpload).appendTo(this.browse_c);b.uploadDir&&this.browseFiles.attr({directory:"directory",webkitdirectory:"webkitdirectory",mozdirectory:"mozdirectory"});this.hasFlash&&(this.browse_c.children(".ax-browse").remove(), f=a.attr("id")+"_flash",j='\x3c!--[if !IE]> --\x3e<object style="position:absolute;width:150px;height:100px;left:0px;top:0px;z-index:1000;" id="'+f+'" type="application/x-shockwave-flash" data="'+b.flash+'" width="150" height="100">\x3c!-- <![endif]--\x3e\x3c!--[if IE]><object style="position:absolute;width:150px;height:100px;left:0px;top:0px;z-index:1000;" id="'+f+'" classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,0,0" width="150" height="100"><param name="movie" value="'+ b.flash+'" />\x3c!--\x3e\x3c!--dgx--\x3e<param name="flashvars" value="instance_id='+a.attr("id")+'"><param name="allowScriptAccess" value="always" /><param value="transparent" name="wmode"></object>\x3c!-- <![endif]--\x3e',this.browse_c.append('<div style="position:absolute;overflow:hidden;width:150px;height:100px;left:0px;top:0px;z-index:0;">'+j+"</div>"),this.flashObj=document.getElementById(f));this.uploadFiles=d('<a class="'+c+'" title="'+g("Upload all files")+'" />').append('<span class="'+ l+'"></span> <span>'+g("Start upload")+"</span>").appendTo(this.fieldSet);this.removeFiles=d('<a class="'+h+'" title="'+g("Remove all")+'" />').append('<span class="'+m+'"></span> <span>'+g("Remove all")+"</span>").appendTo(this.fieldSet);this.fileList=d('<ul class="ax-file-list" />').appendTo(this.fieldSet);b.bootstrap&&this.fileList.addClass("media-list");b.onInit.call(this,this);this.bindEvents(a)};h.prototype.bindEvents=function(a){var b=this.settings;this.browseFiles.bind("change",this,function(a){a.data.settings.enable&& !a.data.hasFlash&&(a.data.addFiles(a.data.hasAjaxUpload?this.files:Array(this)),a.data.hasAjaxUpload||d(this).clone(!0).val("").appendTo(a.data.browse_c),this.value="")});this.uploadFiles.bind("click",this,function(a){a.data.settings.enable&&a.data.uploadAll();return!1});this.removeFiles.bind("click",this,function(a){a.data.settings.enable&&a.data.clearQueue();return!1});0<d(b.form).length?this.form=d(b.form):"parent"==b.form&&(this.form=a.parents("form:first"));if(null!==this.form&&void 0!==this.form){var c= this.form.data("events");null!==c&&void 0!==c&&(null!==c.submit&&void 0!==c.submit)&&(this.form_submit_event=c.submit);this.form.unbind("submit");this.form.bind("submit.ax",this,function(a){if(0<a.data.files.length)return a.data.uploadAll(),!1})}if(this.hasAjaxUpload){a="self"==b.dropArea?a[0]:d(b.dropArea)[0];var e=this;"self"==b.dropArea&&this.fieldSet.find(".ax-legend").html(g("Select Files or Drag&Drop Files"));a.addEventListener("dragenter",function(a){a.stopPropagation();a.preventDefault()}, !1);a.addEventListener("dragover",function(a){a.stopPropagation();a.preventDefault();e.settings.enable&&(this.style.backgroundColor=b.dropColor)},!1);a.addEventListener("dragleave",function(a){a.stopPropagation();a.preventDefault();e.settings.enable&&(this.style.backgroundColor="")},!1);a.addEventListener("drop",function(a){e.settings.enable&&(a.stopPropagation(),a.preventDefault(),e.addFiles(a.dataTransfer.files),this.style.backgroundColor="",b.autoStart&&e.uploadAll())},!1);d(document).unbind(".ax").bind("keyup.ax", function(a){27==a.keyCode&&d("#ax-box-shadow, #ax-box").fadeOut(500)})}this.enable(this.settings.enable)};h.prototype.finish=function(){for(var a=[],b=0;b<this.files.length;b++)a.push(this.files[b].name);this.settings.finish.call(this,a,this.files);if(null!==this.form&&void 0!==this.form){for(var c="function"==typeof this.settings.remotePath?this.settings.remotePath():this.settings.remotePath,b=0;b<a.length;b++)this.form.append('<input name="ax-uploaded-files[]" type="hidden" value="'+(c+a[b])+'" />'); this.form.unbind("submit.ax");null!==this.form_submit_event&&void 0!==this.form_submit_event&&this.form.bind("submit",this.form_submit_event);a=this.form.find('[type="submit"]');0<a.length?a.trigger("click"):this.form.submit()}};h.prototype.addFiles=function(a){for(var b=0;b<a.length;b++){var c,e,f;this.hasAjaxUpload||this.hasFlash?(e=a[b].name,f=a[b].size):(e=a[b].value.replace(/^.*\\/,""),f=0);c=e.split(".").pop().toLowerCase();this.checkFile(e,f)?(c=new j(a[b],e,f,c,this),this.files.push(c)):(this.settings.error.call(this, "Max files number or extension or size not allowed",e),console.log("Max files number or extension or size not allowed"))}this.settings.onSelect.call(this,this.files);this.settings.sortable&&jQuery().sortable&&d(this.fileList).sortable({items:"li",cursor:"move"});this.settings.autoStart&&this.uploadAll()};h.prototype.checkFile=function(a,b){var c=a.split(".").pop().toLowerCase();return this.files.length<this.settings.maxFiles&&(0<=d.inArray(c,this.settings.allowExt)||0==this.settings.allowExt.length)&& b<=this.max_size};h.prototype.uploadAll=function(){if(!1!==this.settings.beforeUploadAll.call(this,this.files)){for(var a=!1,b=0;b<this.files.length;b++)0==this.files[b].status&&(a=!0);if(a)if(this.hasAjaxUpload){var c=this;setTimeout(function(){for(var a=!0,b=0;b<c.files.length;b++)0==c.files[b].status&&(a=!1,c.slots<=c.settings.maxConnections&&c.files[b].startUpload(!1));a||c.uploadAll()},300)}else 0<this.files.length&&this.files[0].startUpload(!0)}};h.prototype.clearQueue=function(){for(;0<this.files.length;)this.removeFile(0)}; h.prototype.getUrl=function(a,b){var c=this.settings,d="function"==typeof c.remotePath?c.remotePath():c.remotePath,f=[];f.push("ax-file-path="+encodeURIComponent(d));f.push("ax-allow-ext="+encodeURIComponent(c.allowExt.join("|")));f.push("ax-file-name="+encodeURIComponent(a));f.push("ax-thumbHeight="+c.thumbHeight);f.push("ax-thumbWidth="+c.thumbWidth);f.push("ax-thumbPostfix="+encodeURIComponent(c.thumbPostfix));f.push("ax-thumbPath="+encodeURIComponent(c.thumbPath));f.push("ax-thumbFormat="+encodeURIComponent(c.thumbFormat)); f.push("ax-maxFileSize="+encodeURIComponent(c.maxFileSize));f.push("ax-fileSize="+b);d="function"==typeof c.data?c.data():c.data;if("object"==typeof d)for(var g in d)f.push(g+"="+encodeURIComponent(d[g]));else"string"==typeof d&&""!=d&&f.push(d);g=-1==c.url.indexOf("?")?"?":"&amp;";return c.url+g+f.join("&")};h.prototype.removeFile=function(a){var b=this.files[a];b.stopUpload();b.li.remove();b.file=null;this.files.splice(a,1);this.hasFlash&&this.flashObj.removeFile(a);for(a=0;a<this.files.length;a++)this.files[a].pos= a};h.prototype.options=function(a,b){if(void 0!==b&&null!==b)this.settings[a]=b,"enable"==a&&this.enable(b);else return this.settings[a]};h.prototype.enable=function(a){(this.settings.enable=a)?this.$this.removeClass("ax-disabled").find("input").attr("disabled",!1):this.$this.addClass("ax-disabled").find("input").attr("disabled",!0)};var r={remotePath:"uploads/",url:"upload.php",flash:"uploader.swf",data:"",async:!0,maxFiles:9999,allowExt:[],success:function(){},finish:function(){},error:function(){}, enable:!0,chunkSize:1048576,maxConnections:3,dropColor:"red",dropArea:"self",autoStart:!1,thumbHeight:0,thumbWidth:0,thumbPostfix:"_thumb",thumbPath:"",thumbFormat:"",maxFileSize:"10M",form:null,editFilename:!1,sortable:!1,beforeUpload:function(){return!0},beforeUploadAll:function(){return!0},onSelect:function(){},onInit:function(){},language:"auto",uploadDir:!1,removeOnSuccess:!1,removeOnError:!1,infoBox:!1,bootstrap:!1},m={init:function(a){return this.each(function(){var b=d.extend({},r,a),c=d(this).html(""), e=c.data("AU");if(!(void 0!==e&&null!==e)){"auto"==b.language&&(b.language=(window.navigator.userLanguage||window.navigator.language).replace("-","_"));l=p[b.language];c.addClass("ax-uploader").data("author","http://www.albanx.com/");0==d("#ax-main-frame").length&&d('<iframe name="ax-main-frame" id="ax-main-frame" />').hide().appendTo("body");0==d("#ax-box").length&&d('<div id="ax-box"><div id="ax-box-fn"><span></span></div><img /><a id="ax-box-close" title="'+g("Close")+'"></a></div>').appendTo("body"); 0==d("#ax-box-shadow").length&&d('<div id="ax-box-shadow"/>').appendTo("body");d("#ax-box-close, #ax-box-shadow").click(function(a){a.preventDefault();d("#ax-box").fadeOut(500);d("#ax-box-shadow").hide()});b.bootstrap&&d("#ax-box-close").addClass("btn btn-danger").html('<span class="ax-clear-icon ax-icon icon-remove-sign"></span>');for(e="AX_"+Math.floor(100001*Math.random());0<d("#"+e).length;)e="AX_"+Math.floor(100001*Math.random());this.id=this.id?this.id:e;b.allowExt=d.map(b.allowExt,function(a){return a.toLowerCase()}); c.data("AU",new h(c,b))}})},clear:function(){return this.each(function(){d(this).data("AU").clearQueue()})},start:function(){return this.each(function(){d(this).data("AU").uploadAll()})},addFlash:function(a){d(this).data("AU").addFiles(a)},progressFlash:function(a,b){d(this).data("AU").files[b].onProgress(a)},onFinishFlash:function(a,b){var c=d(this).data("AU");try{var e=jQuery.parseJSON(a);if(-1==parseInt(e.status))throw e.info;c.files[b].onFinish(e.name,e.size,e.status,e.info)}catch(f){console.log(a), c.files[b].onError(f)}if(c.upload_all)for(e=!0;e;)b++,void 0!==c.files[b]&&0==c.files[b].status?(e=!1,c.files[b].startUpload(c.upload_all)):e=void 0!==c.files[b]&&0!=c.files[b].status?!0:!1},getUrlFlash:function(a,b){var c=d(this).data("AU"),e=c.getUrl(a,b),c=c.settings.flash.match(/\//g),f="";if(null!==c&&c)for(var g=0;g<c.length;g++)f+="../";-1!=navigator.appVersion.indexOf("MSIE")&&(f="");return f+e},getAllowedExt:function(a){var b=d(this).data("AU").settings.allowExt;return!0===a?b:b.join("|")}, getMaxFileNum:function(){return d(this).data("AU").settings.maxFiles},checkFile:function(a,b){return d(this).data("AU").checkFile(a,b)},getFiles:function(){return d(this).data("AU").files},enable:function(){return this.each(function(){d(this).data("AU").enable(!0)})},disable:function(){return this.each(function(){d(this).data("AU").enable(!1)})},destroy:function(){return this.each(function(){var a=d(this);a.data("AU").clearQueue();a.removeData("AU").html("")})},option:function(a,b){return this.each(function(){return d(this).data("AU").options(a, b)})},debug:function(){}};d.fn.ajaxupload=function(a,b){if(m[a])return m[a].apply(this,Array.prototype.slice.call(arguments,1));if("object"===typeof a||!a)return m.init.apply(this,arguments);d.error("Method "+a+" does not exist on jQuery.AjaxUploader")}})(jQuery);