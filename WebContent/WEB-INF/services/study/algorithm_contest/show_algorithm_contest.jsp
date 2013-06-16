<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form method="post" action="/services/study/algorithm_contest/addHistory.do">
Contest:
<select name="contestSequence" id="contestSequence">
	<option value="1">Programming Challenge</option>
</select><br/>
Problem ID: <input type="text" name="problemId" id="problemId" /><br/>
Your submission history: <input type="text" name="submissionHistory" id="submissionHistory" /> <br/>
ex. 476006 	13/02/17 01:27 	Solved 	1.388 secs. 	JAVA<br> 
<input type="submit" />
</form>

<hr>
<h1>Rank</h1>
		<table class="table table-striped table-bordered table-hover table-condensed">
			<thead>
				<tr>
					<th>Rank</th><th>Nickname</th><th>Point</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="leaderboardEntry" items="${requestScope.leaderboardEntries}">
					<tr>
						<td>${leaderboardEntry.rank}</td>
						<td>
							<img src="/resources/common/images/flags/${leaderboardEntry.countryCode}.png" width="20%" height="20%"/>
							${leaderboardEntry.nickname}
						</td>
						<td>${leaderboardEntry.point}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
<h1>Problems</h1>
<table border="1">
	<tr>
		<th align="center" width="80">problem_id</th>
		<th align="center" width="320">title</th>
		<th align="center" width="300">url</th>
		<th align="center" width="40">created_time</th>
	</tr>
	<c:forEach items="${problemList}" var="problem">
		<tr>
			<td align="center">${problem.problemId}</td>
			<td align="left">${problem.title}</td>
			<td align="left">${problem.url}</td>
			<td align="left">${problem.createdTime}</td>
		</tr>
	</c:forEach>
</table>
