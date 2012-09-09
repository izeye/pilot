var emptyChk = function() {
	if (message.value == "") {
		alert("Empty field!");
	} else {
		$('#message').click();
	}
};

$(function() {
	$('#message').focus();
});