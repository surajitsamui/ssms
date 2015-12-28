<%-- 
    Document   : mainLogin
    Created on : Apr 11, 2013, 1:05:04 PM
    Author     : mmc-pc1
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="st" %>
<html>
    <head>
        <link rel="stylesheet" href="/css/jqgrid-ccms.css" type="text/css"/>
        <link rel="stylesheet" type="text/css" href="/css/jquery-ui.css" />
        <link rel="stylesheet" type="text/css" href="/css/ui.jqgrid.css" />
        <link rel="stylesheet" href="/css/olimms.css" type="text/css">
        <script type="text/javascript" language="javascript" src="/scripts/jquery.min.js"></script>
        <link rel="stylesheet" href="/css/ui.jqgrid.css" type="text/css">
        <link rel="stylesheet" href="/css/jquery-ui.css">
        <script type="text/javascript" src="/scripts/jquery.min.js"></script>
        <script type="text/javascript" src="/scripts/jquery-ui-min.js"></script>
        <script type="text/javascript" src="/scripts/grid.locale-en.js"></script>
        <script type="text/javascript" src="/scripts/jquery.jqGrid.src.js"></script>
        <script type="text/javascript" src="scripts/jquery-1.6.min.js"></script>
        <script type="text/javascript" src="scripts/jquery.easyui.min.js"></script> 
        <script type="text/javascript" src="http://www.jeasyui.com/easyui/jquery.edatagrid.js"></script>
        <link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/default/easyui.css">
        <link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/icon.css">
        <script type="text/javascript">
            $(function () {
                $("#maincontent > div:gt(0)").hide();
                $("#menu a").on("click", function (e) {
                    var href = $(this).attr("href");
                    $("#maincontent > " + href).show();
                    $("#maincontent > :not(" + href + ")").hide();
                });
            });
            $(function () {
                $("#list1").jqGrid({
                    url: '/tenderGridlink.htm',
                    datatype: 'json',
//                    colNames: ['Sl No', 'Tender No', 'Tender Type','Closing Date','Opening Date', 'Description'],
                    colNames: ['Tender Type', 'Description', 'Closing Date'],
                    colModel: [
                        //  {name: 'tenderId', index: 'tenderId', width:50,align:'center', resizable: false, sortable: false, editable: true, search: false, editoptions: {defaultValue: '0'}, hidden: false},
                        // {name: 'tenderNo', index: 'tenderNo', width: 120,align:'center', resizable: false, sortable: false, editable: true, search: false, editoptions: {defaultValue: '0'}, hidden: false, editrules: {required: true, edithidden: true}},
                        {name: 'tenderType', index: 'tenderType', width: 120, align: 'center', editable: true, resizable: false, edittype: 'text', sortable: false, editrules: {required: true}, searchoptions: {sopt: ['bw', 'cn', 'eq', 'ew', 'ne']}},
                        {name: 'description', index: 'description', width: 500, align: 'center', editable: true, resizable: false, edittype: 'text', sortable: false, editrules: {required: true}, searchoptions: {sopt: ['bw', 'cn', 'eq', 'ew', 'ne']}},
                        {name: "closingDate", index: "closingDate", width: 150, align: 'center', formatter: 'date', formatoptions: {newformat: 'd-M-Y'}, editable: true, datefmt: 'd-M-Y', editrules: {required: true}, editoptions: {dataInit: function (elm) {
                                    $(elm).datepicker();
                                }}}
//                      /  {name: 'openingDate', index: 'openingDate', width: 150,align:'center', sortable: false,formatter:'date', formatoptions:{srcformat: 'U/1000'},editable: true, newformat: 'd/m/Y',editrules: {required: true}, editoptions: {dataInit:function(elm){$(elm).datepicker();}}},
//                        {name: 'description', index: 'description', width: 500,align:'center', editable: true, resizable: false, edittype: 'text', sortable: false, editrules: {required: true}, searchoptions: {sopt: ['bw', 'cn', 'eq', 'ew', 'ne']}}
                    ],
                    height: 'auto',
                    rowNum: 5,
                    rowList: [5, 10, 20, 30],
                    autowidth: true,
                    viewrecords: true,
                    pager: '#pager1'
//                    ondblClickRow: function (id) {
//                        if (isRowEditable(id)) {
//                            $(this).jqGrid('editRow', id, true, null, null, '/admin/updatetender.htm');
//                        }
//                    },
//                    onSelectRow: function (id) {
//                        if (id && id !== lastSel) {
//                            $("#list1").jqGrid('restoreRow', lastSel);
//                            lastSel = id;
//                        }
//                    }

                }).jqGrid('navGrid', '#pager1', {edit: false, add: false, del: false, search: true, refresh: true}, {}, {}, {}, {searchOnEnter: true, closeAfterSearch: true, savekey: [true, 13], closeOnEscape: true});
            });
//              }).jqGrid('navGrid', '#pager1', {add: false, edit: false, delete: false, view: false, search: true, refresh: false},
//                        {
//                            url: '/admin/updatetender.htm',
//                            closeAfterEdit: true
//                        },
//                        {
//                            url: '/addtender.htm',
//                            closeAfterAdd: false
//                        },
//                        {
//                            url: '/deletetender.htm'
//                        },
//                        {
//                            searchOnEnter: true,
//                            closeAfterSearch: true,
//                            savekey: [true, 13], closeOnEscape: true});
////                ).jqGrid('navButtonAdd', '#pager1', {caption: '', buttonicon: 'ui-icon ui-icon-home', title: 'click to go home page', onClickButton: function () {
////                        window.location = '/home.htm';
////                    }, position: "last"
////                });
//                var lastSel = -1;
//                var isRowEditable = function (id) {
//                    lastSel = id;
//                    return true;
//                };
//            });
        </script>
        <style>
            #header{
                position:static;
                background-color:#ffffff;
                height: 4em;
                padding-left: 0em;
                margin-top: 10px;
                margin-left: 50px;
                margin-right:50px;
            }
            #footer{
                position:static;
                background-color:#FFFFFF;  
                height: 6em;
                padding-left: 0em;
                margin-top:-12px;
                margin-left: 50px;
                margin-right:50px;
            }
            body {
                font: small sans-serif;
                margin-top:10px;
                background-color:black;
                /*// background-image:url("http://pre11.deviantart.net/9a78/th/pre/f/2011/147/0/7/background_for_web__bright_by_ivegotswagger-d3hc844.png");*/
            }
            #page {
                margin-top:0px;
                margin-left:250px;
                margin-right:250px;
            }
            #maincontent {
                float: right;
                width: 100%;
            }
            #menuleftcontent {
                float: left;
                height:34em;
                width: 230px; 
                margin-right:12px;
                margin-left: -200px;
                background-color:#FFFFFF; 
                margin-top:-11px;
            }
            #menurightcontent {
                float: right;
                height: 34em;
                width: 240px;
                margin-right:-200px;
                margin-top:-11px;
                background-color:#FFFFFF;    
            }
            #clearingdiv {
                clear: both;
            }
            #welcomecontent {
                position:static;
                background-color:#FFFFFF;       
                padding-left: 0em;
                height: 5em;
                margin-top:-10px;
                margin-left: 50px;
                margin-right:50px;
                margin-bottom:-10px;
            }
            #tender {
                height: 34em;
                background-color:#FFFFFF;
            }
            p.small {
                line-height:100%;
                font-size: 10px;
                text-align: left;
                color:green;
            }
            ul{
                list-style-type: none;
                margin: 0;
                padding:.10px 1px;
                overflow: hidden;
                background-color:#EE872A;
            }

            li{
                float:left;
                color:white;
                text-align:center;
                padding:.10px 1px;
            }
            li a{
                display:block;
                color:white;
                text-align:center;
                padding:3px 5px;
                text-decoration: none;
            } 
            li a:hover{
                background-color:yellow;
                color:blue;
            }
        </style>
    </head>
    <body>
        <h1 id="header" align="center">
            <table border="0" cellpadding="0" cellspacing="0" align="top" width="100%">
                <tr>
                    <td width="10%"><img src="http://www.nlcindia.com/images/nlclogo.png" width="55" height="55"></td>
                    <td width="35%">
                        <p class="small">
                            <b>नेयवेली लिग्नाइट कार्पोरेशन लिमिटेड</b><br>
                            NEYVELI LIGNITE CORPORATION LIMITED<br>									
                            ('Navratna' - A Government of India Enterprise)<br>
                            Neyveli-607801, Tamilnadu, India. <br> 
                        </p>
                    </td>
                    <td width="35%">
                        <p class="small">
                            <b>Registered Office:</b><br>
                            No.135, Periyar E.V.R. High Road, Kilpauk,<br>OK
                            Chennai - 600 010. Tamil Nadu,India. <br>
                            Ph No.91-44-28364613 - 616, Fax. 91-44-28364625 <br>
                            CIN:L93090TN1956GOI003507
                        </p>
                    </td>
                    <td width="20%" align="center"><img src="http://www.nlcindia.com/images/digitalindia.png">
                    </td> 
                </tr>
                <tr>
                    <td colspan="4" style="background-color:green;">
                        <c:set var="now" value='<%=new java.util.Date()%>'/>
                        <ul>
                            <li style="background-color:#953b39;padding:3.5px 0px;margin-left:-10px; width:120px;"><fmt:formatDate value='${now}' pattern="d-M-Y" ></fmt:formatDate></li>
                                <li><a calass="active" href="http://eproc.nlcindia.com/OnlineVendorregGuide.html"><b>Search |</b></a></li>
                                <li><a calass="active" href="http://eproc.nlcindia.com/OnlineVendorregGuide.html"><b>New Vendor Registration |</b></a></li>
                                <li><a href="http://eproc.nlcindia.com/reg/vendorregnew.htm"><b>PTE Vendor |</b></a></li>
                                <li><a href="http://eproc.nlcindia.com/reg/vendorregnew.htm"><b>Exsisting Vendor</b></a></li>
                                <ul style="float:right;list-style-type:none;">
                                    <li><a href="http://eproc.nlcindia.com/help/contactno.html"><b>Contact Us |</b></a></li>
                                    <li><a href="javascript:/userRegistration.htm;"><b>Login</b></a></li>
                                </ul>
                            </ul>
                        </td> 
                    </tr>
                </table>
            </h1>
            <div id="redline1" style="background-color:white;height:0.20em;margin-left: 50px; margin-right:50px;">
            </div>                     
            <div id="redline" style="background-color:green;height:0.20em;margin-left: 50px; margin-right:50px;">
            </div>            
            <div id="welcomecontent">
                <p align="center"><font size="2" color='red'><b>Welcome to NLC e-Procurement</b></font></p>
                <table border="0" cellpadding="0" cellspacing="0" align="top" width="100%">
                    <tr>
                        <td width="35%"><p style="background-color:white;height:0.20em;margin-left:250px; margin-right:50px;color:black;font-weight: bold">Live Tender</p></td>
                        <td width="45%"></td>
                        <td width="20"></td>
                    </tr>
                </table>
            </div>
            <div id="page">
                <div id="menuleftcontent">
                    <table width="95%" boredr="1" align="center" style="background-color:white">
                        <tr>
                            <td colspan="2" align="center" style="background-color:#953b39;color:white;"><b>Search</b></td>
                        </tr>
                        <tr>
                            <td width="40%" style="background-color:#EE872A;color:white;">Enquiry No:<font color='red'><b><i>*</i></b></font><b>:</b></td>
                            <td width="60%" style="background-color:#EE872A;color:white;"><input type="text" name="iduser" size="14" /></td>
                        </tr> 
                        <tr><td width="40%" style="background-color:#EE872A;color:white;">Closing Date:<font color='red'><b><i>*</i></b></font></td>
                            <td width="60%" style="background-color:#EE872A;color:white;"><input type="password" name="psw" size="14"/></td> 
                        </tr>
                        <font color='red'><b><i></i></b></font>
                        <tr> 
                            <td colspan="2" ALIGN="CENTER">
                                <input type="submit" value="Search" />  
                            </td>
                        </tr>
                    </table>
                    <br>
                    <table width="95%" boredr="1" align="center">
                        <tr><td colspan="2" ALIGN="CENTER" style="background-color:#953b39;color:white;"><b>Training Kit</b></td></tr>
                        <tr>
                            <td colspan="2" style="background-color:#EE872A;color:white;">
                                <a href="javascript:trainingkit('/help/PreRequisites.jsp?close=true')" onmouseover="return true"><b>Pre Requisites</b></a><br>
                                <a href="javascript:trainingkit('/help/registration.jsp?close=true')" onmouseover="return true"><b>Enrollment</b></a><br>
                                <a href="javascript:trainingkit('/help/VendorRegistration.html')" onmouseover="return true"><b>New Vendor Registration</b></a><b>
                                    <a href="javascript:trainingkit('/help/bidding.jsp?close=true')" onmouseover="return true"><b>Bidding</a></b><br>
                                <a href="javascript:trainingkit('/help/raHelp.html?close=true')" onmouseover="return true"><b>Reverse Auction</b></a><br>
                                <a href="javascript:trainingkit('/help/DigitalCertificate.jsp?close=true')" onmouseover="return true"><b>Digital Signature</b></a><br>
                                <a href="javascript:trainingkit('/help/certificateRenewal.html')" onmouseover="return true"><b>Digital Certificate Renewal</b></a><br>
                                <a href="javascript:trainingkit('/help/logging.jsp?close=true')" onmouseover="return true"><b>Login</b></a><br>        
                            </td>
                        </tr>
                    </table> 
                    <br>
                </div>
                <div id="menurightcontent">
                <sf:form commandName="login">
                    <table boredr="1" align="center" style="background-color:white">
                        <tr><td colspan="2" align="center" style="background-color:#953b39;color:white;"><b>LOGIN</b></td></tr>
                        <tr>
                            <td width="40%" style="background-color:#EE872A;color:white;">User Name<font color='red'><b><i>*</i></b></font><b>:</b></td>
                            <td width="60%" style="background-color:#EE872A;color:white;"><sf:input path="userId" size="15" /></td>
                        </tr> 
                        <tr><td width="40%" style="background-color:#EE872A;color:white;"> Password<font color='red'><b><i>*</i></b></font></td>
                            <td width="60%" style="background-color:#EE872A;color:white;"><sf:password path="desiredPassWord" size="15"/></td> </tr>
                        <font color='red' ><b><i>${error}</i></b></font>
                        <tr> 
                            <td  ALIGN="CENTER">
                                <input type="submit" value="Log in" />  
                            </td>
                            <td ALIGN="CENTER">
                                <input type="submit" value="Secure Log in" />  
                            </td>
                        </tr>
                    </table> <br><br>
                </sf:form>
                <br><br><br>
                <table width="90%" boredr="1" align="center" style="background-color:#953b39; border-color:red;">
                    <tr>
                        <td colspan="2" ALIGN="CENTER" style="background-color:#953b39;color:white;"><b>News</b></td>
                    </tr>
                    <tr>
                    <td colspan="2" style="background-color:#FFFFFF;border-color:red;color:white;">
                    <marquee behavior="scroll" direction="up" scrollamount="1" onmouseover="this.stop();"onmouseout="this.start();" width="100%" height="90" style="height: 131px; width: 70%;">
                        <b style="color:red;">ATTENTION TO BIDDERS</b><br>
                        <span style="color: green">NLC has introduced SMS based intimation. In order to receive SMS update your mobile no. in your profile.</span> <br>
                        <span style="color: red;">The mode of payment towards tender document cost and bid
                            guarantee has been changed to only RTGS / NEFT for all e-procurement 
                            tenders (Mandatory Condition).
                            Kindly read the terms &amp; conditions of enquiry before submitting 
                            your offer.
                        </span>
                    </marquee>
                    </td>
                    </tr>
                </table>    
            </div>
            <div id="tender"><br>  
                <table id="tablecss" width="100%">
                    <tr>
                        <td>
                            <table id="list1"></table>
                            <div id="pager1"></div>
                        </td>  
                    </tr>
                </table>
            </div>
        </div>
        <div id="footer" align="center">
            <table border="0" cellpadding="0" cellspacing="0" height="70" style="background-color:#FFFFFF;" align="top">
                <tr>
                    <td width="10%">&nbsp;&nbsp;&nbsp;&nbsp;</td>
                    <td width="80%" align="center" ><b>©Copyright Neyveli Lignite Corporation Ltd.</b></td>
                    <td width="10%" align="center">&nbsp;&nbsp;</td>
                </tr>
            </table>
            <br>
        </div>
    </body>
</html>
