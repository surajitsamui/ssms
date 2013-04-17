<%-- 
    Document   : home
    Created on : 1 Sep, 2012, 4:42:08 PM
    Author     : srini
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="/scripts/jquery.min.js" ></script>
        <script>
            function showDesc(){
                var url = "/vendor/"+$('#venCode').val();
                $.ajax({
                    type: 'put',
                    url: url,
                    async: true,
                    contentType: 'application/json',
                    //data: '{"item": 500}',
                    success: function(response) {
                        $('#venDesc').text(response);
                    },
                    error: function(xhr) {
                        alert('Error!  Status = ' + xhr.status + " Message = " + xhr.statusText);
                    }
                });
            }
        </script>
    </head>
    <body>
        <h1>Hello World! You have done it. Srini</h1>
        <h2>DateBase Time is ${dataBaseTime}</h2>
        <h3>${matDesc}</h3>


        <div>
            <input type="text" value="" id="venCode"> </br>
            <span id="venDesc"></span></br>
            <input type="button" value="show description" onclick="showDesc()">
        </div>
    </body>
</html>
