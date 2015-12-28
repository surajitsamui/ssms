var validHTMLTags = /^(?:a|abbr|acronym|address|applet|area|article|aside|audio|b|base|basefont|bdi|bdo|bgsound|big|blink|blockquote|body|br|button|canvas|caption|center|cite|code|col|colgroup|data|datalist|dd|del|details|dfn|dir|div|dl|dt|em|embed|fieldset|figcaption|figure|font|footer|form|frame|frameset|h1|h2|h3|h4|h5|h6|head|header|hgroup|hr|html|i|iframe|img|input|ins|isindex|kbd|keygen|label|legend|li|link|listing|main|map|mark|marquee|menu|menuitem|meta|meter|nav|nobr|noframes|noscript|object|ol|optgroup|option|output|p|param|plaintext|pre|progress|q|rp|rt|ruby|s|samp|script|section|select|small|source|spacer|span|strike|strong|style|sub|summary|sup|table|tbody|td|textarea|tfoot|th|thead|time|title|tr|track|tt|u|ul|var|video|wbr|xmp)$/i;
function exportLandscapePdf(fileType, elementId) {
    $('.ui-jqgrid .ui-jqgrid-pager').remove('div');
    var content = document.getElementById(elementId).innerHTML.replace(/&nbsp;/, "&#160;").replace(/&amp;lt;br&amp;gt;/gi, "n").replace(/(&amp;lt;([^&amp;gt;]+)&amp;gt;)/gi, "");
    var replaceInvalid = function($0, tag, off, content) {
        var invalidTag = !validHTMLTags.test(tag);
        var isComplete = content.slice(off + 1).search(/^[^<]+>/) > -1;
        if (invalidTag) {
            alert(" invalidTag= " + tag + " :isComplete " + tag);
        }
        return invalidTag || !isComplete ? '&lt;' + tag : $0;
    };
    content = content.replace(/<(\w+)/g, replaceInvalid);
    document.formstyle.pdfBuffer.value = "<!DOCTYPE HTML><html xmlns='http://www.w3.org/1999/xhtml'>"
            + "<head>"
            + "<style type='css/text'>"
            + "@page { size:landscape; }"
            + "table{width:100% !important;border='" + (fileType === 'pdf' ? '0' : '1') + "' cellspacing='0' cellpadding='0'}"
            + "table th {border:1px solid #ddd; border-bottom:2px solid #a8da7f; text-align:center; vertical-align: middle; background:#e4fad0;}"
            + "table td {border:1px solid #ddd; text-align: left; vertical-align: top;}"
            + "</style>"
            + "</head>"
            + "<body>" + content + "</body>"
            + "</html>";
    document.formstyle.fileType.value = fileType;
    document.formstyle.method = 'POST';
    document.formstyle.action = '/report/generatereport.htm';
    document.formstyle.submit();
}