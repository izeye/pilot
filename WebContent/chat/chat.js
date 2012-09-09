var emptyChk = function() {
	if (message.value == "") {
		alert("Empty field!");
		return false;
	} else {
		$('#message').click();
	}
};

$(function() {
	$('#message').focus();
});