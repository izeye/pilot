var tableSeq;

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

var ajax = function(text,seq){
	$.ajax({
		type:"GET",
		url:"/services/translation/accessToken.do",
		dataType:"text",
	    error:function(xhr,status,e){
	    	alert("errors :  " + status);
	    },
		success:function(msg){
			tableSeq = seq;
			translator(msg,"en","ko",text);
		}
	});	
};
 
 var translator = function(accessToken,from,to,text){
	 //var from = "en", to = "ko", text = "studing is hard.";

     var s = document.createElement("script");
     s.src = "http://api.microsofttranslator.com/V2/Ajax.svc/Translate" +
         "?appId=Bearer " + encodeURIComponent(accessToken) +
         "&from=" + encodeURIComponent(from) +
         "&to=" + encodeURIComponent(to) +
         "&text=" + encodeURIComponent(text) +
         "&oncomplete=mycallback";
     document.body.appendChild(s);
 };

 function mycallback(response)
 {
     $('#translate'+tableSeq).text(response);
 }

var getMessages = function(){
	$.getJSON('/services/chat/messages.do',{just:new Date().getTime()},	function(data){
		$('#output').empty();

		var header = '<tr><td width="100">IMAGE</td><td width="200">TIME</td><td width="100">NICKNAME</td><td width="700">MESSAGE</td></tr>';
		$(header).appendTo('#output');
		$.each(data,function(index,item){
			var output = '';
			var image = '';
			
			if(item.facebookUsername != ''){
				image = '<img src="https://graph.facebook.com/'+item.facebookUsername+'/picture"/>';
			}else{
				image = '<img src="/services/image/image.do?userSeq='+item.userSequence+'"'+'/>';
			}
			
			if(item.language == 'ko'){				
				output = '<tr><td>'+image+'</td><td>'
				+item.formattedCreatedTime+'</td><td>'+item.nickname+'</td><td>'
				+item.message+'</td></tr>';
			}else{
				output = '<tr><td>'+image+'</td><td>'
				+item.formattedCreatedTime+'</td><td>'+item.nickname+'</td><td>'
				+item.message +
				'<div id="translate'+item.sequence+'">' +
				'<a href="#" onclick="ajax(\''+item.message+'\','+item.sequence+')">번역하기</a>'
				+'</div></td></tr>';
			}
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