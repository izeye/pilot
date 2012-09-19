var checkValidation = function() {
	if (sign_up_user_id.value == "" || sign_up_password.value == ""
			|| confirm_password.value == "" || nickname.value == "") {
		alert("Empty field!");
		return false;
	}
	if (sign_up_password.value != confirm_password.value) {
		alert("Password and confirmed password don't match!");
		return false;
	}

	if (!validateEmail(sign_up_user_id.value)) {
		alert("Invalid Email");
		return false;
	}
	document.sign_up.submit();
};

$(function() {
	$('#sign_up_user_id').focus();
});