(function () {
	var document = window.document;
	var canvas = document.getElementById('canvas');
	var context = canvas.getContext('2d');
	
	var maps = [
	    [],
		[
			[1, 1, 1, 1, 1, 1, 1, 1, 1, 1],
			[1, 1, 1, 1, 1, 1, 1, 1, 1, 1],
			[1, 1, 1, 1, 1, 1, 1, 1, 1, 1],
			[1, 1, 1, 1, 1, 1, 1, 1, 1, 1],
			[1, 1, 1, 1, 1, 1, 1, 1, 1, 1]
		]
	];
	
	var map;
	
	var tile = {};
	tile.width = 50;
	tile.height = 50;
	tile.color = '#F00';
	
	var level = 1;
	var score = 0;
	
	SACHUNSUNG = {
		init: function () {
			var self = this;
			
			console.log('init');
		},
		start: function () {
			var self = this;
			
			console.log('start');
		},
		print: function(text, x, y, width) {
			context.textAlign = 'center';
			context.font = 'bold 20px sans-serif';
			context.fillStyle = '#000';
			context.fillText(text, x, y, width);
		},
		printCenter: function (text) {
			var self = this;
			
			self.print(text, canvas.width / 2, canvas.height / 2, canvas.width);
		},
		clearScreen: function () {
			context.fillStyle = '#CCC';
			context.fillRect(0, 0, canvas.width, canvas.height);
		},
		drawTile: function (x, y) {
			context.fillStyle = tile.color;
			context.beginPath();
			context.rect(x, y, tile.width, tile.height);
			context.closePath();
			context.fill();
		},
		drawStatus: function () {
			var self = this;
			
			self.print('Score: ' + score, 700, 500, 100);
		},
		die: function () {
			var self = this;
			
			self.printCenter('Game Over');
			
			// Send score.
		},
		clearGame: function () {
			var self = this;
			
			self.printCenter('Game Clear');
			
			// Send socre.
		}
	};
	
	SACHUNSUNG.init();
}());