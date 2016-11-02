<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<c:import url="/WEB-INF/jsp/common/header.jsp" />

<div class="productDetail" style="background-color: white">
<h1>Solar System Gift Shop</h1>

<c:set var="id" value="${param.product.id }"/>
<img src="img/${product.imageName}"class="detailImage"/>
<h2>${product.name }</h2>
<p style="color: blue;">${product.price }</p>
<p> ${product.description} <br>

<form name="result" action="shoppingCart" method="POST">

	<label for="quantity">Quantity</label>
	<input type="text" name="quantity" id="quantity"/>
	<input type="hidden" name="productId" value="${product.id}"/>
	<input type="submit" value="Add To Cart"/>
		

</form>











</div>


<c:import url="/WEB-INF/jsp/common/footer.jsp" />












