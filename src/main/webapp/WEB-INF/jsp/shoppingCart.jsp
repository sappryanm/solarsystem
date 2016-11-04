<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.techelevator.ssg.model.store.DollarAmount"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<div style="background-color: white">

<table>
<c:set var="grandTotal" value="${DollarAmount(0) }"/>

<c:forEach items="${ cart}" var="item" >
	
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
				 <c:set var="grandTotal" value="${grandTotal.plus(item.total)}" />
			</td>
		</tr>

</c:forEach>
		  <tr><td></td><td></td><td></td><td></td><td style=color:black>Grand Total: ${grandTotal}</td></tr>
		  <tr><td></td><td></td><td></td><td></td><td><a href="endsession"> Checkout</a></td></tr>
		
</table>	
	









</div>


<c:import url="/WEB-INF/jsp/common/footer.jsp" />