<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<div style="background-color: white">

<h1>Solar System Geek Forum</h1>
		<p><a href="spaceForumInput" >Post a Message</a></p>
		<div class="posts">
		<c:forEach var='index' items='${posts}' begin="0" end="${posts.size()-1}"> 
  			
  			  <div  class="post">
  			 <h2>${index.subject} </h2>
  			
  			 <h3> by: ${index.username} Time ${index.datePosted }</h3>
  			 <p> Message: ${index.message } </p>
  			  </div>
  			
		</c:forEach>
		 </div>


<c:import url="/WEB-INF/jsp/common/footer.jsp" />