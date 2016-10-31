<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<div style="background-color: white">


<img src="img/${ param.plannet }.jpg"/>

<p>If you are ${ param.age } years old on plannet Earth then you are ${ spaceAge } ${ param.plannet } years old</p>













</div>


<c:import url="/WEB-INF/jsp/common/footer.jsp" />