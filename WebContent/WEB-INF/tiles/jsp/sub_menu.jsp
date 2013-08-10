<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="well sidebar-nav">
	<ul class="nav nav-list">
		<c:forEach var="subMenuSection" items="${subMenuSections}">
			<li class="nav-header">${subMenuSection.getHeader()}</li>
			<c:forEach var="menuItem" items="${subMenuSection.getMenuItems()}">
				<li><a href="${menuItem.getUrl()}">${menuItem.getName()}</a></li>
			</c:forEach>
			<li class="divider"></li>
		</c:forEach>
	</ul>
</div>