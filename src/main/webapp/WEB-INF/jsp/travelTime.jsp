<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<div style="background-color: white">

<c:url var="formResult" value="/travelTimeResult" />
<form action="${ formResult }" method="get">
	
	<table><tr>
	<td style="color: black">Choose A Planet</td>
  		<td>
  		<select name="plannet">
    		<option value="mercury">Mercury</option>
    		<option value="venus">Venus</option>
    		<option value="earth">Earth</option>
    		<option value="mars">Mars</option>
    		<option value="jupiter">Jupiter</option>
    		<option value="saturn">Saturn</option>
    		<option value="uranus">Uranus</option>
    		<option value="neptune">Neptune</option>   
  		</select>
  		</td>
	<tr>
	<td>
	
	<tr>
		<td>Select travel method</td>
		<td>
			<select name="travelMethod">
    		<option value="walking">Walking</option>
    		<option value="car">Car</option>
    		<option value="bulletTrain">Bullet Train</option>
    		<option value="boeing">Boeing 747</option>
    		<option value="concorde">Concorde</option>   
  		</select>
  		</td>
	</tr>
	
	
		<label for="age" style="color: black">Enter Your Age</label>
	</td>
	<td>
		<input type="double" name="age" id="age"/>
	</td>
	<tr><td></td>
		<td>
			<input type="submit" value="Calculate">
		</td>
		</tr>
	</table>
</form>


</div>


<c:import url="/WEB-INF/jsp/common/footer.jsp" />