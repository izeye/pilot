<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<script type="text/javascript" src="/resources/syntaxhighlighter/scripts/shCore.js"></script>
	<script type="text/javascript" src="/resources/syntaxhighlighter/scripts/shBrushJScript.js"></script>
	<script type="text/javascript" src="/resources/syntaxhighlighter/scripts/shBrushJava.js"></script>
	<link type="text/css" rel="stylesheet" href="/resources/syntaxhighlighter/styles/shCoreEmacs.css"/>
	<script type="text/javascript">SyntaxHighlighter.all();</script>
	<style>
		.syntaxhighlighter { padding-bottom: 1px; }
		.syntaxhighlighter .line.alt2 {
  			background-color: #232323 !important;
		}
	</style>
</head>
<body style="background: white; font-family: Helvetica">
	<pre class="brush: java">
${ source }
	</pre>
</body>
