<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div style="font-family:verdana;padding:20px;border-radius:10px;border:10px solid #EE872A;"> 
    <h1 align="center"><img src="http://www.nlcindia.com/images/nlc_logo3.jpg" width="75" height="70">
        <font color="grey">Welcome <u>${homePageS.name}</u> to NLC Administrator Home Page</font>
    </h1>
</div>
<hr>

<br>
<table align="center" >
    <tbody >
        <tr><td bgcolor="#FF9E0E" colspan="40" height="20" >
                <tr>
                    <td>   <c:forEach items="${menu}" var="map">
                <input type="button" value="${map.key}" onclick="location ='${map.value}';"/>
                        </c:forEach></td></tr>
            </td></tr>
    </tbody>
</table>