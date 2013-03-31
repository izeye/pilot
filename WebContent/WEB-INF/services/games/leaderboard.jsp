<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<title>Leaderboard</title>
	</head>
	<body>
		<h3>Leaderboard</h3>
		<table>
		<tr>
		<td>
		<table class="table table-striped table-bordered table-hover table-condensed">
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
							<a href="/services/game/score/history.do?game_sequence=${requestScope.gameSequence}&user_sequence=${entry.userSequence}" target="game_history">
								${entry.nickname}
							</a>
						</td>
						<td>${entry.point}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		</td>
		<td>
		<iframe id="game_history" name="game_history" width="400" height="300"></iframe>
		</td>
		</tr>
		</table>
	</body>
</html>