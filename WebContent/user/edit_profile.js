var checkValidation = function() {
	if (current_password.value == "" || nickname.value == "") {
		alert("Empty field!");
		return false;
	}
	if (new_password.value != "" && confirm_new_password.value != "" && new_password.value != confirm_new_password.value) {
		alert("New assword and confirmed new password don't match!");
		return false;
	}
	document.edit_profile.submit();
};

$(function() {
	$('#user_id').focus();
});