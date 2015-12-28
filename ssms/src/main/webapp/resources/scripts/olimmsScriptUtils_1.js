function setDefaultInteger(obj){
    if(!isInteger(obj.value)){
        obj.value=0;
    }
}

function setAmount(obj){
    setValue(obj,2);
}

function setQuantity(obj){
    setValue(obj,4);
}

function setValue(obj, dec){
    if(isNaN(obj.value) || obj.value==''){
        obj.style.backgroundColor='pink';
        return;
    }else{
        obj.style.backgroundColor='white';
    }
    obj.value=roundNumber(obj.value,dec);
}
function checkAndSetDecimals(obj, dec){
    if(isNaN(obj.value) || obj.value==''){
        obj.style.backgroundColor='pink';
        return false;
    }else{
        obj.style.backgroundColor='white';
    }
    var objStr = String(obj.value);
    if(objStr.indexOf(".")<0){ // no decimal found so return
        return true;
    }

    if ((objStr.indexOf(".")+1) < (objStr.length - dec)) {

        if(!isNaN(objStr.substring(objStr.indexOf('.')+1))&& parseInt(objStr.substring(objStr.indexOf('.')+1))>0){

            if(confirm("Quantity can have only "+dec+" decimal places at most. Truncate to "+dec+" places")){
                obj.value=roundNumber(obj.value, dec);
                return true;
            }else{
                return false;
            }
        }
    }
    return true;
}
function roundNumber(num, dec) {
    return (parseFloat(num)).toFixed(dec);
}

/**
 * This method is checking whether given value is Integer.
 * If value is Integer, it will return true otherwise false.
 * @param value
 * @return Boolean
 */
function isInteger(value){
    return (value.toString().search(/^[0-9]+$/)==0);
}

/**
 * This method is checking whether given value is Float/Double.
 * If value is Float/Double, it will return true otherwise false.
 * @param value
 * @return Boolean
 */
function isFloat(value){
    return /\./.test(value);
}

/**
 * This method is checking whether given value is Alphabet.
 * If value is Alphabet, it will return true otherwise false.
 * @param value
 * @return Boolean
 */
function isAlphabet(value){
    if((value.toString().search(/^[a-zA-Z]+$/))==0){
        return true;
    }
    return false;
}
/**
 * Using this method you are checking Whether given date is valid date or not.
 * Date Format is dd/MM/yyyy
 * @param value
 * @return Boolean
 */
function isDate(value){
    var tmpDate = value.split("/");
    var day=tmpDate[0];
    var month=tmpDate[1];
    var year=tmpDate[2];
    if (isNaN(day) || isNaN(month) || isNaN(year)) {
        return false;
    }
    else if (month < 1 || month > 12) {
        return false;
    }else if ((month==4 || month==6 || month==9 || month==11) && day==31) {
        return false;
    }else if (month == 2) {
        var isLeapYear = (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0));
        if (day>29 || (day==29 && !isLeapYear)) {
            return false
        }
    }else if (day < 1 || day > 31) {
        return false;
    }
    return true;
}

function dateComparison(fromDate, toDate){
    var from = fromDate.split("/")
    var fDay=from[0];
    var fMonth=from[1];
    var fYear=from[2];

    var to = toDate.split("/");
    var tDay=to[0];
    var tMonth=to[1];
    var tYear=to[2];

    var fDate = new Date(fYear,fMonth-1,fDay);
    var tDate = new Date(tYear,tMonth-1,tDay);
    if(fDate>tDate){
        return true;
    }else{
        return false;
    }
}

function isEmpty(str){
    return ( null == str || "" == trim(str))
}
function trim(str) {
    return str.replace(/^\s+|\s+$/g,"");
}

function ltrim(str) {
    return str.replace(/^\s+/,"");
}

function rtrim(str) {
    return str.replace(/\s+$/,"");
}

function validEmail(email){
    var emailReg = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
    return emailReg.test(email);
}

function IsMaxLen(th,len){
    if(th.value.length >len){
        th.value=th.value.substring(0,len);
        return true;
    }else{
        return false;
    }

}
function getLastRow(tableID){
    var rowCount = document.getElementById(tableID).tBodies[0].rows.length-1;
    return rowCount;
}

/**
 * Clone a row and add it to the bottom of the table
 */
function cloneTableRow(tableID,rowNoToCopy) {
    //closeTableRowAt(tableID,rowNoToCopy,0);
    cloneTableRowAt(tableID,rowNoToCopy,0);
}


/**
 * clone a row and add it to the insertAt location
 */
function cloneTableRowAt(tableID,rowNoToCopy,insertAt ) {
    var table = document.getElementById(tableID);
    var body = table.tBodies[0];
    var row = body.rows[rowNoToCopy].cloneNode(true);
    var rowCount = table.rows.length-1;
    if(insertAt==0){//lastRow
        row = body.appendChild(row);
    }else { // insert before location
        var rowBefore = body.rows[insertAt];
        row = body.insertBefore(row,rowBefore);
    }
    
    var colCount = row.cells.length;
    // to get the current row newcell.parentNode.rowIndex;
    for(var i=0; i<colCount; i++) {
        var newcell	= row.cells[i];
        for(var x=0; x<newcell.childNodes.length;x++){
            var node = newcell.childNodes[x];
            
            if(  node.tagName == "SPAN" || node.tagName == "INPUT"  || node.tagName == "SELECT"){
                node.id = node.id.replace(rowNoToCopy+".",rowCount+".");
                node.id = node.id.replace("["+rowNoToCopy+"]","["+rowCount+"]");
                if( typeof(node.name)!="undefined"){
                    node.name = node.name.replace("["+rowNoToCopy+"]","["+rowCount+"]");
                    node.name = node.name.replace(rowNoToCopy+".",rowCount+".");
                }
            }
            
            if(node.tagName=="SPAN"){
                node.innerHTML="&nbsp;";
            }else{
                switch(node.type) {
                    case "hidden":
                        node.value="";
                    case "text":
                        node.value = "";
                        break;
                    case "checkbox":
                        node.checked = false;
                        break;
                    case "select-one":
                        node.selectedIndex = 0;
                        break;
                    case "radio":
                        break;
                }
            }
        }
    }
    //body.appendChild(row);
    return rowCount;
}

