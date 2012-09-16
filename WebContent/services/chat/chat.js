var emptyChk = function() {
	if (message.value == "") {
		alert("Empty field!");
		return false;
	}
};

$(function() {
	$('#message').focus();
});