<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="/WEB-INF/jsp/common/header.jsp" />
<div style="background-color:white">

	<h1 class="centered">Geek Store</h1>
	<table>
	<c:forEach var="product" items="${products}">
		
		<tr>
			<td>
			<img src="img/${product.imageName}" style="height: 200px"/> 
			</td>
			<td>
				<p style=color:black><b>${product.name}</b></p>
				<br>
				<a href="productDetail?productId=${product.id}">${product.price} price</a>
			</td>
		</tr>
		
	</c:forEach>
	</table>	
	
</div>
<c:import url="/WEB-INF/jsp/common/footer.jsp" />

