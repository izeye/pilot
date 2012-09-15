var emptyChk = function() {
	if (message.value == "") {
		alert("Empty field!");
		return false;
	}
	document.chat.submit();
};

$(function() {
	$('#message').focus();
});