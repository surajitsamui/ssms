<%-- 
    Document   : workflowEntry
    Created on : 28 Nov, 2012, 11:37:43 AM
    Author     : sintu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="/css/olimms.css" type="text/css">
        <link rel="stylesheet" href="/css/ccms.css" type="text/css">
        <script type="text/javascript" language="javascript" src="/scripts/jquery.min.js"></script>
        <title>JSP Page</title>
        <script type="text/javascript">
            var rowIndex;
            function getDocLocId(){
                document.forms[0].action="/admin/workflowentry.htm";
                window.open("/admin/searchDocLoc.htm", "docloc","toolbar=no,width=750,height=450,resizable=yes,top="+(screen.height-400)/2+",left="+(screen.width-700)/2+",scrollbars=yes");
            }
            function getRoleLocId(index){
                rowIndex=index;
                window.open("/admin/searchRoleLoc.htm", "roleloc","toolbar=no,width=750,height=450,resizable=yes,top="+(screen.height-400)/2+",left="+(screen.width-700)/2+",scrollbars=yes");                
            }
            
            function deleteworkflow(index){            
                if(window.confirm("Are you wnat to delete this file?")){
                    var data={"seqId":$('[name="wflst['+index+'].seqId"]').val()}
                    $.ajax({                    
                        url:"workflowdelete.htm",                       
                        contentType: 'application/json', 
                        cache: false,
                        data:data,                    
                        success: function(response){   
                            if(response=="_ok_"){                            
                                document.forms[0].action="/admin/workflowentry.htm";
                                document.forms[0].submit();
                            }
                        },error: function(response, ajaxOptions, thrownError) {                                                    
                            alert(thrownError)
                        }
                    });  
                }else{
                    $('#deleteRow').attr("checked",false);
                }
            }    
            function addrow(){                
                var rc = $('#work >tbody >tr').length ;
                var html="<tr>";
                html += "<td><input id=\"wflst"+rc+".seqId\" name=\"wflst["+rc+"].seqId\" type=\"hidden\" value=\"0\">\n\
                                     <input id=\"wflst"+rc+".currentLevel\" name=\"wflst["+rc+"].currentLevel\" type=\"text\" value=\"0\">\n\
                                     <input id=\"wflst"+rc+".docLocId\" name=\"wflst["+rc+"].docLocId\" type=\"hidden\" value=\"${wfe.docLocId}\"></td>";
                html += " <td><input id=\"wflst"+rc+".rolelocDesc\" name=\"wflst["+rc+"].rolelocDesc\" readonly=\"readonly\" type=\"text\" value=\"\">\n\
                                      <input id=\"wflst"+rc+".roleLocId\" name=\"wflst["+rc+"].roleLocId\" type=\"hidden\" value=\"0\">\n\
                                      <input type=\"button\" value=\"..\"  onclick=\"getRoleLocId("+rc+")\" ></td>";
                html += "<td><input id=\"wflst"+rc+".targetLevel\" name=\"wflst["+rc+"].targetLevel\" type=\"text\" value=\"0\"></td>";
                html += "<td><input id=\"wflst"+rc+".branchDocLocId\" name=\"wflst["+rc+"].branchDocLocId\" type=\"text\" value=\"0\" size=\"14\">\n\
                                     <input type=\"button\" value=\"..\" onclick=\"getBranch()\"></td>";
                html += "<td><input id=\"wflst"+rc+".serialNo\" name=\"wflst["+rc+"].serialNo\" type=\"text\" value=\""+(rc+1)+"\"></td>";
                html += "<td><input id=\"deleteRow\" name=\"deleteRow\" type=\"checkbox\" onclick=\"deleteworkflow("+rc+")\"></td>";
                //<input type="checkbox" id="deleteRow" >
                html +="</tr>";        
                if(rc == 0){
                    $("table#work >tbody").html(html);
                }else{
                    $("table#work >tbody tr").last().after(html);
                }
            }
            function save(){
                document.forms[0].action="/admin/workflowsave.htm";
                document.forms[0].submit();
            }
            
            function getBranch(index){
                if($('#docLocId').val()==0){
                    alert("Please select a document first");
                    return;
                }
                rowIndex=index;
                window.open("/admin/branchList.htm?docLocId="+$('#docLocId').val(), "branch","toolbar=no,width=750,height=450,resizable=yes,top="+(screen.height-400)/2+",left="+(screen.width-700)/2+",scrollbars=yes");
            }
        </script>
    </head>
    <body>
        <sf:form  commandName="wfe" ><br>
            <table class="searchResult1" width="90%" border="1" cellpadding="0" cellspacing="0">
                <tr>
                    <th width="15%">Document: </th>
                    <td  width="35%">
                        <span><input type="button" value=".." onclick="getDocLocId()"></span>
                        <sf:input path="docName" readonly="true" size="40"/>
                            <sf:hidden path="docLocId"  />
                            <sf:hidden path="docId" />
                    </td>
                    <th  width="15%">Location: </th>
                    <td width="35%"><sf:hidden path="locId"  readonly="true"/><sf:input path="locDesc" readonly="true"/></span></td>
                </tr>
            </table><br>
            <table class="searchResult1" width="90%" border="1" cellpadding="0" cellspacing="0" id="work">
                <thead>
                    <tr>
                        <th style="width:  5%">Level</th>
                        <th >Role - Location</th>
                        <th style="width: 5%">Target Level</th>
                        <th style="width: 15%">Branch</th>
                        <th style="width: 5%">Serial No.</th>
                        <th style="width: 5%">Delete</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${wfe.wflst}" varStatus="row">
                        <tr>
                            <td><sf:hidden path="wflst[${row.index}].seqId"/><sf:input path="wflst[${row.index}].currentLevel" size="3"/><sf:hidden path="wflst[${row.index}].docLocId"/></td>
                            <td><sf:input path="wflst[${row.index}].rolelocDesc" readonly="true" size="55"/>
                                <sf:hidden path="wflst[${row.index}].roleLocId"/><input type="button" value=".." onclick="getRoleLocId(${row.index})"></td>
                            <td><sf:input path="wflst[${row.index}].targetLevel" size="3"/></td>
                            <td><sf:input path="wflst[${row.index}].branchDocLocId" size="10" />
                                <input type="button" value=".." onclick="getBranch(${row.index})">
                            </td>
                            <td><sf:input path="wflst[${row.index}].serialNo" size="3"/></td>                         
                            <td><input type="checkbox" id="deleteRow" onclick="deleteworkflow('${row.index}')"></td>                        
                        </tr>
                    </c:forEach>

                </tbody>
            </table>
            <input type="button" onclick="addrow()" value="Add Row">
            <input type="button" value="Save" onclick="save()">
        </sf:form>
    </body>
</html>
