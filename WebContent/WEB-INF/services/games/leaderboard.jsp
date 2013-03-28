<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<title>Leaderboard</title>
	</head>
	<body>
		<h3>Leaderboard</h3>
		<table border="1">
			<thead>
				<tr>
					<th>Rank</th><th>Nickname</th><th>Point</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="entry" items="${requestScope.entries}">
					<tr>
						<td>${entry.rank}</td>
						<td>
							<img src="/resources/common/images/flags/${entry.countryCode}.png" width="20%" height="20%"/>
							<a href="/services/game/score/history.do?game_sequence=${requestScope.gameSequence}&user_sequence=${entry.userSequence}&nickname=${entry.nickname}" target="game_history">
								${entry.nickname}
							</a>
						</td>
						<td>${entry.point}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<iframe id="game_history" width="400" height="300"></iframe>
	</body>
</html>