(function () {
	document = window.document;
	canvas = document.getElementById('canvas');
	context = canvas.getContext('2d');
	
	var maps = [
	    [],
		[
			[1, 1, 1, 1, 1, 1, 1, 1, 1, 1],
			[1, 1, 1, 1, 1, 1, 1, 1, 1, 1],
			[1, 1, 1, 1, 1, 1, 1, 1, 1, 1]
		]
	];
	
	var map;
	
	var bat = {};
	bat.width = 80;
	bat.height = 20;
	bat.x = 0;
	bat.y = canvas.height - bat.height;
	bat.color = 'yellow';
	bat.step = 30;
	bat.init = function () {
		this.x = canvas.width / 2 - this.width / 2;
	};
	bat.moveLeft = function () {
		if (bat.x - bat.step >= 0) {
			bat.x -= bat.step;
		} else {
			bat.x = 0;
		}
	};
	bat.moveRight = function () {
		if (bat.x + bat.width + bat.step <= canvas.width) {
			bat.x += bat.step;
		} else {
			bat.x = canvas.width - bat.width;
		}
	};
	
	var ball = {};
	ball.radius = 10;
	ball.x = 0;
	ball.y = 0;
	ball.dx = -1;
	ball.dy = -2;
	ball.color = '#000';
	ball.init = function () {
		this.x = bat.x + bat.width / 2;
		// Add extra radius gap to y of ball to prevent from re-bouncing.
		this.y = canvas.height - bat.height - this.radius * 2;
	};
	
	var tile = {};
	tile.width = 79;
	tile.height = 40;
	tile.color = '#F00';
	
	level = 1;
	score = 0;
	
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
						bat.moveLeft();
						break;
						
					case 39: // arrow right
						bat.moveRight();
						break;
				}
			};
			canvas.onmousemove = function (e) {
//				console.log(e);
				bat.x = e.pageX - canvas.offsetLeft - bat.width / 2;
			};
		},
		start: function () {
			var self = this;
			
			console.log('start');
			
			// FIXME: doesn't appear.
			self.printCenter('Arkanoid');
			
			self.clearScreen();

			bat.init();
			ball.init();
			
			self.printCenter('Level ' + level);
			
			map = jQuery.extend(true, [], maps[level]);
			
			window.setTimeout(function () {
				timer_id = window.setInterval(function () {
					self.refreshFrames.call(self);
				}, 1);
			}, 2000);
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
//			context.clearRect(0, 0, canvas.width, canvas.height);
			
			context.fillStyle = '#CCC';
			context.fillRect(0, 0, canvas.width, canvas.height);
		},
		refreshFrames: function () {
			var self = this;
			
			self.clearScreen();
			
			self.drawBall();
			self.drawBat();
			
			if (ball.x + ball.dx > canvas.width || ball.x + ball.dx < 0) {
				ball.dx = -ball.dx;
			}
			if (ball.y + ball.dy < 0) {
				ball.dy = -ball.dy;
			}
			if (ball.y + ball.dy > canvas.height) {
				self.die();
			}
			// Check collision with bat.
			if (self.collide(bat.x, bat.y, bat.width, bat.height)) {
				// Hit the left-side of bat.
				if (ball.x < bat.x + bat.width / 2) {
					if (ball.dx > 0) {
						ball.dx = -ball.dx;
					}
				// Hit the right-side of bat.
				} else {
					if (ball.dx < 0) {
						ball.dx = -ball.dx;
					}
				}
				ball.dy = -ball.dy;
			}
			
			var x = 0;
			var y = 0;
			for (var row = 0, rows = map.length; row < rows; row++) {
				x = 0;
				for (var col = 0, cols = map[row].length; col < cols; col++) {
					if (map[row][col] == 1 && self.collide(x + 1, y + 1, tile.width, tile.height)) {
						ball.dx = -ball.dx;
						ball.dy = -ball.dy;
						map[row][col] = 0;
						
						score += 10;
					}
					x += tile.width + 1;
				}
				y += tile.height + 1;
			}
			
			ball.x += ball.dx;
			ball.y += ball.dy;
			
			var x = 0;
			var y = 0;
			for (var row = 0, rows = map.length; row < rows; row++) {
				x = 0;
				for (var col = 0, cols = map[row].length; col < cols; col++) {
//					console.log(row + ", " + col);
//					console.log(x + ", " + y);
					
					if (map[row][col] == 1) {
						self.drawTile(x + 1, y + 1);
					}
					x += tile.width + 1;
				}
				y += tile.height + 1;
			}
			
			self.drawStatus();
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
			
			window.clearInterval(timer_id);
			
			self.printCenter('Game Over');
		},
		collide: function (squareX, squareY, width, height) {
			var distance = 0;
			if (ball.x < squareX) {
				distance += Math.pow(ball.x - squareX, 2);
			} else if (ball.x > squareX + width) {
				distance += Math.pow(ball.x - squareX - width, 2);
			}	
			if (ball.y < squareY) {
				distance += Math.pow(ball.y - squareY, 2);
			} else if (ball.y > squareY + height) {
				distance += Math.pow(ball.y - squareY - height, 2);
			}	
			return distance <= Math.pow(ball.radius, 2);
		}
	};
	
	ARKANOID.init();
}());