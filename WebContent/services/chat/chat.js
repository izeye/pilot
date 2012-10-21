var emptyChk = function() {
	if (message.value == "") {
		alert("Empty field!");
		return false;
	}
};

$(function() {
	$('#message').focus();
	getMessages();
	setInterval(function(){
		getMessages();
	},10000);
});

var getMessages = function(){
	$.getJSON('/services/chat/messages.do',{just:new Date().getTime()},	function(data){
		$('#output').empty();

		var header = '<tr><td width="200">TIME</td><td width="100">NICKNAME</td><td width="700">MESSAGE</td></tr>';
		$(header).appendTo('#output');
		$.each(data,function(index,item){
			var output = '<tr><td>'+item.formattedCreatedTime+'</td><td>'+item.nickname+'</td><td>'+item.message+'</td></tr>';
			$(output).appendTo('#output');
		});
		
		$("table#output tr:even").css("background-color", "#F4F4F8");
		$("table#output tr:odd").css("background-color", "#FFFFFF");
	});
}; 

$(function(){
	$('#chat').submit(function(event){
		$.post('/services/chat/send-message.do',$(this).serialize());
		$('#message').val('');
		event.preventDefault();
					
		getMessages();
	});
});