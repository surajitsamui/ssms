<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--div style="font-family:verdana;padding:20px;border-radius:10px;border:10px solid #EE872A;"> 
    <h1 align="center"><img src="http://www.nlcindia.com/images/nlc_logo3.jpg" width="75" height="70">
        <font color="grey">Welcome <u>${homePageS.name}</u> to NLC Administrator Home Page</font>
    </h1>
</div>
<hr--%>

<br>
<p align="center">
    <c:forEach items="${menu}" var="map">
        <input type="button" value="${map.key}" onclick="location = '${map.value}';" style="padding: 7px; border:1px solid #EE872A"/>
    </c:forEach>
</p>
