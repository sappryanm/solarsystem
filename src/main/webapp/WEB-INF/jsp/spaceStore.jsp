<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<div style="background-color: white">

<h1>Solar System Geek Shop</h1>

	<c:forEach items="products" var="product">
		<div>
		<img src="img${product.imageName}.jpg"/>
		</div><br>
	
	
	</c:forEach>





</div>


<c:import url="/WEB-INF/jsp/common/footer.jsp" />