(function () {
	var document = window.document;
	var canvas = document.getElementById('canvas');
	var context = canvas.getContext('2d');
	
	var level = 1;
	var score = 0;
	
	REMEMBER_PHOTOS = {
		init: function () {
			var self = this;
			
			console.log('init');
		},
		start: function () {
			var self = this;
			
			console.log('start');
			
			var imageObj = new Image();
			imageObj.onload = function () {
				context.drawImage(imageObj, 0, 0);
			};
			imageObj.src = '/resources/common/images/objects/amulet.JPG';
		}
	};
	
	REMEMBER_PHOTOS.init();
}());