(function () {
	Array.prototype.removeAt = function (index) {
		this.splice(index, 1);
	};
	
	var ITEM_TYPE_GUN = 1;
	
	var document = window.document;
	var image = document.getElementById('image');
	var canvas = document.getElementById('canvas');
	var context = canvas.getContext('2d');
	var pauseAndResume = document.getElementById('pause_and_resume');
	var paused = false;
	
	function preventBehavior(e) {
		e.preventDefault();
	}
	
	canvas.addEventListener('mousedown', preventBehavior, false);
	
	canvas.addEventListener('touchmove', preventBehavior, false);
	canvas.addEventListener('touchstart', preventBehavior, false);
	
// canvas.width = window.innerWidth;
// canvas.height = window.innerHeight;
	
// function fullscreen() {
// if (canvas.webkitRequestFullScreen) {
// canvas.webkitRequestFullScreen();
// } else {
// canvas.mozRequestFullScreen();
// }
// }
// fullscreen();
// canvas.addEventListener('click', fullscreen);
	
	var maps = [
	    [],
//		[
//			[0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
//			[0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
//			[0, 1, 2, 3, 4, 5, 6, 0, 0, 0],
//			[0, 7, 8, 9, 10, 11, 12, 13, 0, 0],
//			[0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
//		],
		[
			[0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
			[0, 3, 3, 3, 3, 3, 3, 3, 3, 0],
			[0, 2, 2, 2, 2, 2, 2, 2, 2, 0],
			[0, 1, 1, 1, 1, 1, 1, 1, 1, 0],
			[0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
		],
		[
			[5, 5, 5, 5, 5, 5, 5, 5, 5, 5],
			[4, 4, 4, 4, 4, 4, 4, 4, 4, 4],
			[3, 3, 3, 3, 3, 3, 3, 3, 3, 3],
			[2, 2, 2, 2, 2, 2, 2, 2, 2, 2],
			[1, 1, 1, 1, 1, 1, 1, 1, 1, 1]
		],
		[
			[0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
			[0, 3, 3, 3, 3, 3, 3, 3, 3, 0],
			[0, 2, 2, 2, 2, 2, 2, 2, 2, 0],
			[0, 7, 7, 7, 7, 7, 7, 7, 7, 0],
			[0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
		],
		[
			[5, 5, 5, 5, 5, 5, 5, 5, 5, 5],
			[4, 4, 4, 4, 4, 4, 4, 4, 4, 4],
			[3, 3, 3, 3, 3, 3, 3, 3, 3, 3],
			[2, 2, 2, 2, 2, 2, 2, 2, 2, 2],
			[7, 7, 7, 7, 7, 7, 7, 7, 7, 7]
		],
		[
			[0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
			[0, 3, 3, 3, 13, 13, 3, 3, 3, 0],
			[0, 2, 2, 2, 13, 13, 2, 2, 2, 0],
			[0, 7, 7, 7, 13, 13, 7, 7, 7, 0],
			[0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
		],
		[
			[5, 5, 5, 5, 13, 13, 5, 5, 5, 5],
			[4, 4, 4, 4, 13, 13, 4, 4, 4, 4],
			[3, 3, 3, 3, 13, 13, 3, 3, 3, 3],
			[2, 2, 2, 2, 13, 13, 2, 2, 2, 2],
			[7, 7, 7, 7, 13, 13, 7, 7, 7, 7]
		]
//		[
//			[1, 1, 1, 1, 1, 1, 1, 1, 1, 1],
//			[1, 1, 1, 1, 1, 1, 1, 1, 1, 1],
//			[1, 1, 1, 1, 1, 1, 1, 1, 1, 1],
//			[1, 1, 1, 1, 1, 1, 1, 1, 1, 1],
//			[1, 1, 1, 1, 1, 1, 1, 1, 1, 1]
//		],
// [
// [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
// [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
// [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
// [1, 0, 0, 0, 0, 0, 0, 0, 0, 0],
// [1, 0, 0, 0, 0, 0, 0, 0, 0, 0],
// ],
// [
// [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
// [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
// [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
// [1, 0, 0, 0, 0, 0, 0, 0, 0, 0],
// [1, 0, 0, 0, 0, 0, 0, 0, 0, 0],
// ]
	];

	var map;
	
	var bat = {};
	bat.imageX = 665;
	bat.imageY = 646;
	bat.imageWidth = 115;
	bat.imageHeight = 25;
	bat.width = bat.imageWidth / 5 * 2.5;
	bat.height = bat.imageHeight / 5 * 2.5;
	bat.x = 0;
// bat.y = canvas.height - bat.height;
	bat.y = canvas.height - bat.height - 100;
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
	bat.move = function (e) {
		bat.x = e.pageX - canvas.offsetLeft - bat.width / 2;
	};
	
	var SIN30 = Math.sin(Math.PI / 6);
	var SIN45 = Math.sin(Math.PI / 4);
	
	var ball = {};
	ball.imageX = 200;
	ball.imageY = 540;
	ball.imageRadius = 20;
	ball.imageDiameter = ball.imageRadius * 2;
	ball.radius = ball.imageRadius / 5 * 2.5;
	ball.diameter = ball.radius * 2;
	ball.x = 0;
	ball.y = 0;
	ball.initialSpeed = 3.5;
	ball.speed = ball.initialSpeed;
	ball.initialDx = ball.speed * Math.cos(SIN45);
	ball.initialDy = -ball.speed * Math.sin(SIN45);
	ball.dx = ball.initialDx;
	ball.dy = ball.initialDy;
	ball.init = function () {
		this.x = bat.x + bat.width / 2;
		// Add extra radius gap to y of ball to prevent from re-bouncing.
		this.y = canvas.height - bat.height - this.radius * 2 - 100;
	};

	var TILE_TYPE_BLANK = {
		needHits: 0
	};
	var TILE_TYPE_NORMAL = {
		needHits: 1
	};
	var TILE_TYPE_HARD = {
		needHits: 3
	};
	var TILE_TYPE_UNBREAKABLE = {
		needHits: -1
	};
	
	var TILE_COLOR_PURPLE = 1;
	var TILE_COLOR_ORANGE = 2;
	var TILE_COLOR_BLUE = 3;
	var TILE_COLOR_RED = 4;
	var TILE_COLOR_YELLOW = 5;
	var TILE_COLOR_GREEN = 6;
	
	var tileTypes = [TILE_TYPE_NORMAL, TILE_TYPE_HARD, TILE_TYPE_UNBREAKABLE];
	var tileColors = [
		TILE_COLOR_PURPLE,
		TILE_COLOR_ORANGE,
		TILE_COLOR_BLUE,
		TILE_COLOR_RED,
		TILE_COLOR_YELLOW,
		TILE_COLOR_GREEN];
	
	var TILE_IMAGE_WIDTH = 80;
	var TILE_IMAGE_HEIGHT = 35;
	
	var TILE = {
		imageWidth: TILE_IMAGE_WIDTH,
		imageHeight: TILE_IMAGE_HEIGHT,
		width: TILE_IMAGE_WIDTH / 5 * 2.5,
		height: TILE_IMAGE_HEIGHT / 5 * 2.5,
	};
	
	var TILE_BLANK = jQuery.extend(false, {
		type: TILE_TYPE_BLANK
	}, TILE);
	
	var TILE_NORMAL_PURPLE = jQuery.extend(false, {
		type: TILE_TYPE_NORMAL,
		color: TILE_COLOR_PURPLE,
		imageX: 0,
		imageY: 220
	}, TILE);
	var TILE_NORMAL_ORANGE = jQuery.extend(false, {
		type: TILE_TYPE_NORMAL,
		color: TILE_COLOR_ORANGE,
		imageX: 130,
		imageY: 220
	}, TILE);
	var TILE_NORMAL_BLUE = jQuery.extend(false, {
		type: TILE_TYPE_NORMAL,
		color: TILE_COLOR_BLUE,
		imageX: 275,
		imageY: 220
	}, TILE);
	var TILE_NORMAL_RED = jQuery.extend(false, {
		type: TILE_TYPE_NORMAL,
		color: TILE_COLOR_RED,
		imageX: 425,
		imageY: 220
	}, TILE);
	var TILE_NORMAL_YELLOW = jQuery.extend(false, {
		type: TILE_TYPE_NORMAL,
		color: TILE_COLOR_YELLOW,
		imageX: 565,
		imageY: 220
	}, TILE);
	var TILE_NORMAL_GREEN = jQuery.extend(false, {
		type: TILE_TYPE_NORMAL,
		color: TILE_COLOR_GREEN,
		imageX: 705,
		imageY: 220
	}, TILE);
	
	var TILE_HARD_PURPLE = jQuery.extend(false, {
		type: TILE_TYPE_HARD,
		color: TILE_COLOR_PURPLE,
		imageX: 0,
		imageY: 147
	}, TILE);
	var TILE_HARD_ORANGE = jQuery.extend(false, {
		type: TILE_TYPE_HARD,
		color: TILE_COLOR_ORANGE,
		imageX: 130,
		imageY: 147
	}, TILE);
	var TILE_HARD_BLUE = jQuery.extend(false, {
		type: TILE_TYPE_HARD,
		color: TILE_COLOR_BLUE,
		imageX: 275,
		imageY: 147
	}, TILE);
	var TILE_HARD_RED = jQuery.extend(false, {
		type: TILE_TYPE_HARD,
		color: TILE_COLOR_RED,
		imageX: 425,
		imageY: 147
	}, TILE);
	var TILE_HARD_YELLOW = jQuery.extend(false, {
		type: TILE_TYPE_HARD,
		color: TILE_COLOR_YELLOW,
		imageX: 565,
		imageY: 147
	}, TILE);
	var TILE_HARD_GREEN = jQuery.extend(false, {
		type: TILE_TYPE_HARD,
		color: TILE_COLOR_GREEN,
		imageX: 705,
		imageY: 147
	}, TILE);
	
	var TILE_UNBREAKABLE = jQuery.extend(false, {
		type: TILE_TYPE_UNBREAKABLE,
		imageX: 707,
		imageY: 387
	}, TILE);
	
	var tileDefinitions = [
	    TILE_BLANK, // 0
	    TILE_NORMAL_PURPLE, // 1
	    TILE_NORMAL_ORANGE, // 2
	    TILE_NORMAL_BLUE, // 3
	    TILE_NORMAL_RED, // 4
	    TILE_NORMAL_YELLOW, // 5
	    TILE_NORMAL_GREEN, // 6
	    TILE_HARD_PURPLE, // 7
	    TILE_HARD_ORANGE, // 8
	    TILE_HARD_BLUE, // 9
	    TILE_HARD_RED, // 10
	    TILE_HARD_YELLOW, // 11
	    TILE_HARD_GREEN, // 12
	    TILE_UNBREAKABLE // 13
	];
	
	// 총알을 담을 배열
	var bullets = null;
	
	// 아이템볼을 담는 배열
	var items = null;
	
	// 아이템 이벤트 시간누적 변수
	var itemEventTime = 0;
	
	var level = 1;
	var score = 0;
	
	var timer_id = 0;
	
	var item_meta = {
		radius : 15,
		speed : 2, 
		color : '#1DDB16'
	};
	
	var bullet_meta = {
		radius : 5,
		speed : 5, 
		color : '#FFBB00'
	};
	
	var is_playing = false;
	
	function fireBullet() { 
		if (itemEventTime > 0) {
			bullets.push({
				x : bat.x + bat.width / 2,
				y : canvas.height - bat.height - 5 * 2 - 100
			});
		}
	}
	
	var jewel_meta = {
		radius: 8,
		speed: 2,
		color: 'yellow',
		border_color: 'orange'
	};
	
	var bullets = [];
	var items = [];
	var jewels = [];
	
	var block_score = 10;
	var jewel_score = 20;
	
	ARKANOID = {
		init: function () {
			var self = this;
			
			console.log('init');
			
			self.bind();
		},
		bind: function () {
			var self = this;
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
			canvas.onmousemove = bat.move;
			canvas.ontouchmove = bat.move;
			canvas.onmousedown = fireBullet;
			canvas.ontouchstart = fireBullet;
		},
		start: function () {
			var self = this;
			
			console.log('start');
			
			is_playing = true;
			
			// FIXME: doesn't appear.
			self.printCenter('Arkanoid');
			
			self.startLevel();
		},
		reset: function () {
			window.clearInterval(timer_id);
			
			score = 0;
			
			level = 1;

			ball.speed = ball.initialSpeed;
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
			
			itemEventTime = 0;
			
			self.clearScreen();
			
			bat.init();
			ball.init();
			
			self.printCenter('Level ' + level);
			
			map = [];
			for (var i = 0; i < maps[level].length; i++) {
				var row = [];
				map.push(row);
				for (var j = 0; j < maps[level][i].length; j++) {
					var tileDefinition = tileDefinitions[maps[level][i][j]];
					var tile = jQuery.extend(
							false,
							{needCurrentHits: tileDefinition.type.needHits},
							tileDefinition);
					row.push(tile);
				}
			}
			
			// item : map에 item을 랜덤적용
//			self.setItems(map);
			
			window.setTimeout(function () {
				timer_id = window.setInterval(function () {
					self.refreshFrames.call(self);
				}, 10);
//				}, 100);
//				}, 1000);
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
// context.clearRect(0, 0, canvas.width, canvas.height);
			
// context.fillStyle = '#CCC';
// context.fillRect(0, 0, canvas.width, canvas.height);
			
			var grd = context.createLinearGradient(0, 0, 0, canvas.height);
			grd.addColorStop(0, '#004CB3');
			grd.addColorStop(1, '#8ED6FF');
			context.fillStyle = grd;
			context.fillRect(0, 0, canvas.width, canvas.height);
		},
		refreshFrames: function () {
			
			// 총쏘기 이벤트 시간 제어
			if(itemEventTime > 0){
				itemEventTime--;
			}
			
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
			if (self.isCollidedBetweenBallAndBat()) {
// self.collideBetweenBallAndBat();
				self.collideBetweenBallAndBatV2();
			}
			
			// 아이템볼과 배트의 충돌 검사
			for (var i = 0; i < items.length; i++) {
				if (self.isCollidedBetweenBatAndItem(items[i])) {
					items.removeAt(i);
					itemEventTime += 180;
				}
			}
			
			for (var i = 0; i < jewels.length; i++) {
				if (self.isCollidedBetweenBatAndItem(jewels[i])) {
					jewels.removeAt(i);
					score += jewel_score * level;
				}
			}

			var x = 0;
			var y = 0;
			var tile;
			for (var row = 0, rows = map.length; row < rows; row++) {
				x = 0;
				for (var col = 0, cols = map[row].length; col < cols; col++) {
					tile = map[row][col];
					if (tile.type != TILE_TYPE_BLANK) {
						var collided = false;
						if (self.isCollidedBetweenBallAndSquare(x + 1, y + 1, tile.width, tile.height)) {
							collided = true;
							ball.dx = -ball.dx;
							ball.dy = -ball.dy;
						}
						
						for (var i = 0; i < bullets.length; i++){
							if (self.isCollidedBetweenBulletAndTile(bullets[i], x + 1, y + 1, tile.width, tile.height)) {
								collided = true;
								bullets.removeAt(i);
								break;
							}
						}
						
						if (collided) {
							tile.needCurrentHits--;
							if (tile.needCurrentHits == 0) {
								map[row][col] = TILE_BLANK;
							}
							
							// Check item block.
							for (var i = 0; i < items.length; i++) {
								if (items[i].row == row && items[i].column == col) {
									items[i].x = x + tile.width / 2;
									items[i].y = y + tile.height;
									items[i].visible = true;
								}
							}
							
							document.getElementById("explosion").play();
							
							if (tile.type != TILE_TYPE_UNBREAKABLE) {
								score += block_score * level;
								
								if (tile.needCurrentHits == 0) {
									jewels.push({
										x: x + tile.width / 2,
										y: y + tile.height,
									});
								}
							}
						}
					}
					x += tile.width + 1;
				}
				y += tile.height + 1;
			}

			ball.x += ball.dx;
			ball.y += ball.dy;
			
			// item: 아이템을 내려오게 한다.
			for (var i = 0; i < items.length; i++) {
				if (items[i].visible) {
					self.drawItem(items[i]);
					items[i].y += item_meta.speed;
					if (items[i].y > canvas.height) {
						items.removeAt(i);
					}
				}
			}
			
			for (var i = 0; i < jewels.length; i++) {
				self.drawJewel(jewels[i]);
				jewels[i].y += jewel_meta.speed;
				if (jewels[i].y > canvas.height) {
					jewels.removeAt(i);
				}
			}
			
			// 총알을 그린다.
			for (var i = 0; i < bullets.length; i++){
				console.dir(bullets);
				self.drawBullet(bullets[i]);
				bullets[i].y -= bullet_meta.speed;
				if (bullets[i].y < 0) {
					bullets.removeAt(i);
				}
			}
			
			var x = 0;
			var y = 0;
			var tile;
			for (var row = 0, rows = map.length; row < rows; row++) {
				x = 0;
				for (var col = 0, cols = map[row].length; col < cols; col++) {
					tile = map[row][col];
					self.drawTile(tile, x + 1, y + 1);
					
					x += tile.width + 1;
				}
				y += tile.height + 1;
			}
			
			self.drawStatus();
			
			var levelCleared = true;
			for (var row = 0, rows = map.length; row < rows; row++) {
				for (var col = 0, cols = map[row].length; col < cols; col++) {
					var tile = map[row][col];
					if (tile.type != TILE_TYPE_BLANK && tile.type != TILE_TYPE_UNBREAKABLE) {
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
		collideBetweenBallAndBat: function () {
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
		},
		collideBetweenBallAndBatV2: function () {
			var angle = (bat.x - ball.x) / bat.width * Math.PI;
			ball.dx = -ball.speed * Math.cos(angle);
			ball.dy = ball.speed * Math.min(Math.sin(angle), -SIN30);
			
			document.getElementById("jump").play();
		},
		drawBall: function () {
// context.strokeStyle = ball.color;
// context.fillStyle = ball.color;
// context.beginPath();
// context.arc(ball.x, ball.y, ball.radius, 0, Math.PI * 2, true);
// context.closePath();
// context.stroke();
// context.fill();
			context.drawImage(image, ball.imageX, ball.imageY, ball.imageDiameter, ball.imageDiameter,
					ball.x, ball.y, ball.diameter, ball.diameter);
		},
		drawBat: function () {
			context.drawImage(image, bat.imageX, bat.imageY, bat.imageWidth, bat.imageHeight,
					bat.x, bat.y, bat.width, bat.height);
		},
		drawTile: function (tile, x, y) {
			var imageY = tile.imageY;
			if (tile.type == TILE_TYPE_HARD) {
				imageY -= (TILE_TYPE_HARD.needHits - tile.needCurrentHits) * 75;
				imageY = Math.max(imageY, 0);
			}
			context.drawImage(image, tile.imageX, imageY, tile.imageWidth, tile.imageHeight,
					x, y, tile.width, tile.height);
		},
		drawItem: function (item) {  // item: 아이템볼을 그려준다.
			context.fillStyle = item_meta.color;
			context.beginPath();
			context.arc(item.x, item.y, item_meta.radius, 0, Math.PI * 2, true);
			context.closePath();
			context.fill();
		},
		drawJewel: function (jewel) {
			context.fillStyle = jewel_meta.color;
			context.beginPath();
			context.arc(jewel.x, jewel.y, jewel_meta.radius, 0, Math.PI * 2, true);
			context.closePath();
			context.fill();
			
			context.strokeStyle = jewel_meta.border_color;
			context.beginPath();
			context.arc(jewel.x, jewel.y, jewel_meta.radius, 0, Math.PI * 2, true);
			context.closePath();
			context.stroke();
			
			context.textAlign = 'center';
			context.font = 'bold 15px sans-serif';
			context.fillStyle = '#000';
			context.fillText('$', jewel.x, jewel.y + 5, jewel_meta.radius * 2);
		},
		drawBullet: function (bullet) {
			context.fillStyle = bullet.color;
			context.beginPath();
			context.arc(bullet.x, bullet.y, bullet_meta.radius, 0, Math.PI * 2, true);
			context.closePath();
			context.fill();
		},
		drawStatus: function () {
			var self = this;
			
			self.print('Score: ' + score, 400, 300, 100);
		},
		pauseAndResume: function () {
			console.log(paused);
			var self = this;
			
			if (!is_playing) {
				return;
			}
			
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
			
			is_playing = false;
		},
		clearLevel: function () {
			var self = this;
			
			window.clearInterval(timer_id);
			
			self.printCenter('Level Clear');
			
			window.setTimeout(function () {
				level++;
// ball.dx = ball.initialDx * (1 + 0.5 * (level - 1));
// ball.dy = ball.initialDy * (1 + 0.5 * (level - 1));
// console.log(ball.dx);
// console.log(ball.dy);
// ball.speed *= 1.5; // Too fast.
// ball.speed *= 1.3;
//				ball.speed *= 1.2;
				ball.speed *= 1.1;
				ball.dx = ball.initialDx;
				ball.dy = ball.initialDy;
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
			
			is_playing = false;
		},
		isCollided: function (circleX, circleY, radius, squareX, squareY, width, height) {
			var distance = 0;
			if (circleX < squareX) {
				distance += Math.pow(circleX - squareX, 2);
			} else if (circleX > squareX + width) {
				distance += Math.pow(circleX - squareX - width, 2);
			}	
			if (circleY < squareY) {
				distance += Math.pow(circleY - squareY, 2);
			} else if (circleY > squareY + height) {
				distance += Math.pow(circleY - squareY - height, 2);
			}	
			return distance <= Math.pow(radius, 2);
		},
		isCollidedBetweenBallAndSquare: function (squareX, squareY, width, height) {
			var self = this;
			
			return self.isCollided(ball.x, ball.y, ball.radius, squareX, squareY, width, height);
		},
		isCollidedBetweenBallAndBat: function () {
			var self = this;
			
			return self.isCollided(ball.x, ball.y, ball.radius, bat.x, bat.y, bat.width, bat.height);
		},
		isCollidedBetweenBatAndItem: function (item) {
			var self = this;
			
			return self.isCollided(item.x, item.y, item_meta.radius, bat.x, bat.y, bat.width, bat.height);
		},
		isCollidedBetweenBulletAndTile: function (bullet, tileX, tileY, width, height) {
			var self = this;
			
			return self.isCollided(bullet.x, bullet.y, bullet_meta.radius, tileX, tileY, width, height);
		},
		setItems: function (map){
			var count = 0;
			while (count < level){
				var i = Math.floor(Math.random() * map.length);
				var j = Math.floor(Math.random() * map[0].length);
				if (map[i][j] == 1) {
					console.log("item is set at " + i + ", " + j);
					items.push({
						type: ITEM_TYPE_GUN,
						row: i,
						column: j,
						x: 0,
						y: 0,
						visible: false
					});
					count++;
				}
			}
		}
	};
	
	ARKANOID.init();
}());