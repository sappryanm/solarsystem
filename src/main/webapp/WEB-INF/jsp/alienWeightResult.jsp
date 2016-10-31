<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<div style="background-color: white">

<div style="display:inline">
	<img src="img/${ param.plannet }.jpg"/>
	<p>You are ${ param.weight } lbs on plannet Earth, you would weigh ${ spaceWeight } lbs on ${ param.plannet }</p>
</div>


</div>






















<c:import url="/WEB-INF/jsp/common/footer.jsp" />