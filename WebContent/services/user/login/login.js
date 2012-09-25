var login = function() {
	if (user_id.value == "" || password.value == "") {
		alert("Empty field!");
		return false;
	}
	
	if(!validateEmail(user_id.value)){
		alert("Invalid Email");
		return false;
	}
	
	current_url.value=window.location.href;
};
