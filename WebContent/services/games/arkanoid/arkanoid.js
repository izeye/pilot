(function () {
	document = window.document;
	canvas = document.getElementById('canvas');
	context = canvas.getContext('2d');
	
	var bat = {};
	bat.width = 80;
	bat.height = 20;
	bat.x = 0;
	bat.y = canvas.height - bat.height;
	bat.color = 'yellow';
	bat.init = function () {
		bat.x = canvas.width / 2 - bat.width / 2;
	};
	
	var ball = {};
	ball.radius = 10;
	ball.x = 0;
	ball.y = 0;
	ball.dx = -2;
	ball.dy = -4;
	ball.color = '#000';
	ball.init = function () {
		ball.x = bat.x + bat.width / 2 - ball.radius;
		ball.y = canvas.height - bat.height - ball.radius;
	};
	
	level = 1;
	
	timer_id = 0;
	
	ARKANOID = {
		init: function () {
			var self = this;
			
			console.log('init');
			
			self.bind();
		},
		bind: function () {
			document.onkeydown = function (e) {
				var key = e.charCode ? e.charCode : e.keyCode ? e.keyCode : 0;
				switch (key) {
					case 37: // arrow left
						console.log('arrow left');
						break;
						
					case 39: // arrow right
						console.log('arrow right');
						break;
				}
			};
		},
		start: function () {
			var self = this;
			
			console.log('start');
			
			// FIXME: doesn't appear.
			self.print('Arkanoid');
			
			self.clearScreen();

			bat.init();
			ball.init();
			
			self.print('Level ' + level);
			
			window.setTimeout(function () {
				timer_id = window.setInterval(function () {
					console.log(self);
					self.refreshFrames.call(self);
				}, 10);
			}, 2000);
		},
		print: function(text) {
			context.textAlign = 'center';
			context.font = 'bold 20px sans-serif';
			context.fillStyle = '#000';
			context.fillText(text, canvas.width / 2, canvas.height / 2, canvas.width);
		},
		clearScreen: function () {
//			context.clearRect(0, 0, canvas.width, canvas.height);
			
			context.fillStyle = '#CCC';
			context.fillRect(0, 0, canvas.width, canvas.height);
		},
		refreshFrames: function () {
			var self = this;
			
			self.clearScreen();
			
			self.drawBall();
			self.drawBat();
		},
		drawBall: function () {
//			context.strokeStyle = ball.color;
			context.fillStyle = ball.color;
			context.beginPath();
			context.arc(ball.x, ball.y, ball.radius, 0, Math.PI * 2, true);
			context.closePath();
//			context.stroke();
			context.fill();
		},
		drawBat: function () {
			context.fillStyle = bat.color;
			context.beginPath();
			context.rect(bat.x, bat.y, bat.width, bat.height);
			context.closePath();
			context.fill();
		}
	};
	
	ARKANOID.init();
}());