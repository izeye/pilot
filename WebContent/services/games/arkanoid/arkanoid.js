(function () {
	var document = window.document;
	var canvas = document.getElementById('canvas');
	var context = canvas.getContext('2d');
	var pauseAndResume = document.getElementById('pause_and_resume');
	var paused = false;
	
	var maps = [
	    [],
		[
			[0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
			[0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
			[0, 1, 1, 1, 1, 1, 1, 1, 0, 0],
			[0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
			[0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
		],
		[
			[0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
			[0, 1, 1, 1, 1, 1, 1, 1, 1, 0],
			[0, 1, 1, 1, 1, 1, 1, 1, 1, 0],
			[0, 1, 1, 1, 1, 1, 1, 1, 1, 0],
			[0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
		],
		[
			[1, 1, 1, 1, 1, 1, 1, 1, 1, 1],
			[1, 1, 1, 1, 1, 1, 1, 1, 1, 1],
			[1, 1, 1, 1, 1, 1, 1, 1, 1, 1],
			[1, 1, 1, 1, 1, 1, 1, 1, 1, 1],
			[1, 1, 1, 1, 1, 1, 1, 1, 1, 1]
		]
//		[
//			[0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
//			[0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
//			[0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
//			[1, 0, 0, 0, 0, 0, 0, 0, 0, 0],
//			[1, 0, 0, 0, 0, 0, 0, 0, 0, 0],
//		],
//		[
//			[0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
//			[0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
//			[0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
//			[1, 0, 0, 0, 0, 0, 0, 0, 0, 0],
//			[1, 0, 0, 0, 0, 0, 0, 0, 0, 0],
//		]
	];
	
	var map;
	
	var bat = {};
	bat.width = 160;
	bat.height = 20;
	bat.x = 0;
	bat.y = canvas.height - bat.height;
	bat.centerColor = 'yellow';
	bat.edgeColor = 'red';
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
	ball.initialDx = -1;
	ball.initialDy = -2;
	ball.dx = ball.initialDx;
	ball.dy = ball.initialDy;
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
	
	var level = 1;
	var score = 0;
	
	var timer_id = 0;
	
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
			
			self.startLevel();
		},
		reset: function () {
			window.clearInterval(timer_id);
			
			score = 0;
			
			level = 1;
			
			ball.dx = ball.initialDx;
			ball.dy = ball.initialDy;
		},
		restart: function () {
			var self = this;
			
			self.reset();
			self.start();
		},
		startLevel: function () {
			var self = this;
			
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
				var quater = bat.width / 4;
				
				var temp = ball.dx;
				
				// Hit the leftmost-side of bat.
				if (ball.x < bat.x + quater) {
					if (ball.dx > 0) {
						ball.dx = -ball.dy;
						ball.dy = Math.abs(temp);
					} else { // ball.dx < 0
						ball.dx = -ball.dy;
						ball.dy = Math.abs(temp);
					}
				// Hit the left-side of bat.
				} else if (ball.x < bat.x + quater * 2) {
					if (ball.dx > 0) {
						ball.dx = -ball.dx;
					}
				// Hit the right-side of bat.
				} else if (ball.x < bat.x + quater * 3) {
					if (ball.dx < 0) {
						ball.dx = -ball.dx;
					}
				// Hit the rightmost-side of bat.
				} else {
					if (ball.dx < 0) {
						ball.dx = ball.dy;
						ball.dy = Math.abs(temp);
					} else { // ball.dx > 0
						ball.dx = ball.dy;
						ball.dy = Math.abs(temp);
					}
				}
				ball.dy = -ball.dy;
				
				document.getElementById("jump").play();
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
						
						score += 10 * level;
						
						document.getElementById("explosion").play();
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
			
			var levelCleared = true;
			for (var row = 0, rows = map.length; row < rows; row++) {
				for (var col = 0, cols = map[row].length; col < cols; col++) {
					if (map[row][col] == 1) {
						levelCleared = false;
						break;
					}
				}
				if (!levelCleared) {
					break;
				}
			}
			
			if (levelCleared) {
				self.clearLevel();
			}
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
			var quarter = bat.width / 4;
			
			context.fillStyle = bat.edgeColor;
			context.beginPath();
			context.rect(bat.x, bat.y, quarter, bat.height);
			context.closePath();
			context.fill();

			context.beginPath();
			context.rect(bat.x + quarter * 3, bat.y, quarter, bat.height);
			context.closePath();
			context.fill();
			
			context.fillStyle = bat.centerColor;
			context.beginPath();
			context.rect(bat.x + quarter, bat.y, quarter * 2, bat.height);
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
		pauseAndResume: function () {
			console.log(paused);
			var self = this;
			
			if (paused) {
				self.resume();
				pauseAndResume.setAttribute("value", "Pause");
			} else {
				self.pause();
				pauseAndResume.setAttribute("value", "Resume");
			}
			paused = !paused;
		},
		pause: function () {
			console.log('paused');
			window.clearInterval(timer_id);
		},
		resume: function () {
			console.log('resumed');
			var self = this;
			
			timer_id = window.setInterval(function () {
				self.refreshFrames.call(self);
			}, 1);
		},
		die: function () {
			var self = this;
			
			window.clearInterval(timer_id);
			
			self.printCenter('Game Over');
			
			jQuery.post('/services/game/score/record.do', 'game_sequence=1&score=' + score);
		},
		clearLevel: function () {
			var self = this;
			
			window.clearInterval(timer_id);
			
			self.printCenter('Level Clear');
			
			window.setTimeout(function () {
				level++;
				ball.dx = ball.initialDx * (1 + 0.5 * (level - 1));
				ball.dy = ball.initialDy * (1 + 0.5 * (level - 1));
				console.log(ball.dx);
				console.log(ball.dy);
				if (maps[level]) {
					self.startLevel();
				} else {
					self.clearGame();
				}
			}, 2000);
		},
		clearGame: function () {
			var self = this;
			
			window.clearInterval(timer_id);
			
			self.clearScreen();
			self.printCenter('Game Clear');
			
			jQuery.post('/services/game/score/record.do', 'game_sequence=1&score=' + score);
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