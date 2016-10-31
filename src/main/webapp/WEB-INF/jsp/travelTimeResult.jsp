<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<div style="background-color: white">

<img src="img/${ param.plannet }.jpg"/>
	<p>Traveling by ${ param.travelMethod } you will reach ${ param.plannet } in ${ travelTime } years.  You will be ${ travelAge }
	 years old</p>








</div>


<c:import url="/WEB-INF/jsp/common/footer.jsp" />