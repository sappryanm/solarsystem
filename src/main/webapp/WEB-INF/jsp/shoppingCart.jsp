<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<div style="background-color: white">

<table>
<c:forEach items="${ cart}" var="item">
	
		<tr>
			<td>
				<img src="img/${item.product.imageName }" class="detailImage"/>
			</td>
			<td>
				<p style="color:black">${item.product.name }</p>
			</td>
			<td>
				<p style="color:black">${item.product.price }</p>
			</td>
			<td>
				<p style="color:black">${item.quantity }</p>
			</td>
			<td>
				<p style="color:black">${item.total} </p>
			</td>
		</tr>

</c:forEach>
</table>	










</div>


<c:import url="/WEB-INF/jsp/common/footer.jsp" />