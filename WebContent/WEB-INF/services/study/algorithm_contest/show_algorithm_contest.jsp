<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
<table border="1">
	<tr><th>Rank</th><th>Username</th><th>Solved Problem Count</th></tr>
	<tr><td>1</td><td>izeye</td><td>1</td></tr>
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
