<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



	<h1>Recipes</h1>
	<div class=container>		
	<c:forEach var="product" items="${products}">
		
			<div class=column>
			<img src="<c:url value="img/recipe${products.imageName}.jpg"/> " />
			<h3><a href="productDetail?productId=${products.productId}" >${product.name}</a></h3>

			<p>${products.price} price</p>
			</div>
		
		
	</c:forEach>
	
	
    </div>
<c:import url="/WEB-INF/jsp/common/footer.jsp" />

