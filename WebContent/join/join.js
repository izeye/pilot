var checkValidation = function() {
	if (user_id.value == "" || password.value == "" || confirm_password.value == "" || nickname.value == "") {
		alert("Empty field!");
		return false;
	}
	if (password.value != confirm_password.value) {
		alert("Password and confirmed password don't match!");
		return false;
	}
	document.join.submit();
};

$(function() {
	$('#user_id').focus();
});