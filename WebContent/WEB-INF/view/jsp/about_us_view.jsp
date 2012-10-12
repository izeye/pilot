<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h3>About CTB Research Group</h3>
<p>CTB stands for "cushion the blow". CTB Research Group is one of CTB groups.</p>
<h3>About Members</h3>
<ul>
	<c:forEach var="item" items="${staff}">
		<li>${item.nickname}</li>
	</c:forEach>
</ul>
