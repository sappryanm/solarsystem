<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<div style="background-color: white">
	<form action="spaceForumInput" method="POST">
		<label for="spaceForum" style="color: black">Enter Your Username</label><br>
		<input type="text" name="username" id="user"/><br>
		<label for="spaceForum" style="color: black">Subject</label><br>
		<input type="text" name="subject" id="subject"/><br>
		<label for="spaceForum" style="color: black">Message</label><br>
		<input type="text" name="message" id="message"/><br>
		<input type="submit" value="Submit">
	</form>
</div>
<c:import url="/WEB-INF/jsp/common/footer.jsp" />
