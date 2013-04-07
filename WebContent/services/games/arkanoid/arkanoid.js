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
	
	var SIN30 = Math.sin(Math.PI / 6);
	var SIN45 = Math.sin(Math.PI / 4);
	
	var ball = {};
	ball.radius = 10;
	ball.x = 0;
	ball.y = 0;
	ball.initialSpeed = 2;
	ball.speed = ball.initialSpeed;
	ball.initialDx = ball.speed * Math.cos(SIN45);
	ball.initialDy = -ball.speed * Math.sin(SIN45);
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
	
	//item: itemTile
	var itemTile = {};
	itemTile.color = '#FFD9EC';
	
	//총알을 담을 배열
	var bullets = null;
	
	//아이템볼을 담는 배열
	var itemBalls = null;
	
	//아이템 이벤트 시간누적 변수
	var itemEventTime = 0;
	
	
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
			canvas.onmousemove = function (e) {
//				console.log(e);
				bat.x = e.pageX - canvas.offsetLeft - bat.width / 2;
			};
			canvas.addEventListener("mousedown", function() {
				//총알이벤트 발생하면 눌러진다.
				
				if(itemEventTime > 0){
					self.setBullets();
				}
			} );
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
			bullets = new Array();
			itemBalls = new Array();
			
			self.clearScreen();
			
			bat.init();
			ball.init();
			
			self.printCenter('Level ' + level);
			
			map = jQuery.extend(true, [], maps[level]);
			
			//item : map에 item을 랜덤적용
			self.setItems(map);
			
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
			
//			context.fillStyle = '#CCC';
//			context.fillRect(0, 0, canvas.width, canvas.height);
			
			var grd = context.createLinearGradient(0, 0, 0, canvas.height);
			grd.addColorStop(0, '#004CB3');
			grd.addColorStop(1, '#8ED6FF');
			context.fillStyle = grd;
			context.fillRect(0, 0, canvas.width, canvas.height);
		},
		refreshFrames: function () {
			
			//총쏘기 이벤트 시간 제어
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
			if (self.collide(bat.x, bat.y, bat.width, bat.height)) {
//				self.collideBetweenBallAndBat();
				self.collideBetweenBallAndBatV2();
			}
			
			
			//아이템볼과 배트의 충돌 검사
			for(var i=0;i<itemBalls.length;i++){
				if(self.itemBallCollide(itemBalls[i], bat.x, bat.y, bat.width, bat.height)){
					itemBalls[i].visible = false;
					itemEventTime += 2;
				}
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
					}else if (map[row][col] == 2 && self.collide(x + 1, y + 1, tile.width, tile.height)){  //item충돌
						ball.dx = -ball.dx;
						ball.dy = -ball.dy;
						map[row][col] = 0;
						score += 10 * level;
						//item : 이부분에서 아이템 볼을 떨어뜨려 준다.
						//itemBall.x 를 결정해 준다.
						//itemBall객체를 생성해서 itemBals배열에 넣는다.
						var tempItemBall = {
							x : x+1+tile.width/2,
							y : y+1+tile.height, 
							radius : 30,
							visible : true,
							speed : 1, 
							color : '#1DDB16'
			            };
						itemBalls.push(tempItemBall);
						
						document.getElementById("explosion").play();
					}
					x += tile.width + 1;
				}
				y += tile.height + 1;
			}
			
			//총알과 블럭의 충돌을 검사
			var x = 0;
			var y = 0;
			for (var row = 0, rows = map.length; row < rows; row++) {
				x = 0;
				for (var col = 0, cols = map[row].length; col < cols; col++) {
					for(var i=0;i<bullets.length;i++){
						if (map[row][col] == 1 && self.bulletsCollide(bullets[i],x + 1, y + 1, tile.width, tile.height)) {
							map[row][col] = 0;
							bullets[i].visible = false;
						
							score += 10 * level;
						
							document.getElementById("explosion").play();
						}else if (map[row][col] == 2 && self.bulletsCollide(bullets[i],x + 1, y + 1, tile.width, tile.height)){  //item충돌
							map[row][col] = 0;
							bullets[i].visible = false;
							
							score += 10 * level;
							
							//item : 이부분에서 아이템 볼을 떨어뜨려 준다.
							//itemBall.x 를 결정해 준다.
							var tempItemBall = {
								x : x+1+tile.width/2,
								y : y+1+tile.height, 
								radius : 30,
								visible : true,
								speed : 1, 
								color : '#1DDB16'
				            };
							itemBalls.push(tempItemBall);
							
							document.getElementById("explosion").play();
						}
					}
					x += tile.width + 1;
				}
				y += tile.height + 1;
			}

			
			ball.x += ball.dx;
			ball.y += ball.dy;
			
			//item: 아이템을 내려오게 한다.
			for(var i=0;i<itemBalls.length;i++){
				if(itemBalls[i].visible){
					self.drawItemBall(itemBalls[i]);
					itemBalls[i].y+=itemBalls[i].speed;
				}
			}
			
			//총알을 그린다.
			for(var i=0;i<bullets.length;i++){
				if(bullets[i].visible == true){
					self.drawBullets(bullets[i]);
					bullets[i].y -= bullets[i].speed; 										
				}
			}
			
			var x = 0;
			var y = 0;
			for (var row = 0, rows = map.length; row < rows; row++) {
				x = 0;
				for (var col = 0, cols = map[row].length; col < cols; col++) {
//					console.log(row + ", " + col);
//					console.log(x + ", " + y);
					
					if (map[row][col] == 1) {
						self.drawTile(x + 1, y + 1);
					}else if(map[row][col] == 2){  //item
						self.drawItemTile(x +1, y + 1);
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
		drawItemTile: function(x, y){  //item
			context.fillStyle = itemTile.color;
			context.beginPath();
			context.rect(x, y, tile.width, tile.height);
			context.closePath();
			context.fill();
		},
		drawItemBall: function(itemBall){  //item: 아이템볼을 그려준다.
			context.fillStyle = itemBall.color;
			context.beginPath();
			context.arc(itemBall.x, itemBall.y, itemBall.radius, 0, Math.PI * 2, true);
			context.closePath();
			context.fill();
		},
		drawBullets: function(bullet){
			context.fillStyle = bullet.color;
			context.beginPath();
			context.arc(bullet.x, bullet.y, bullet.radius, 0, Math.PI * 2, true);
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
//				ball.dx = ball.initialDx * (1 + 0.5 * (level - 1));
//				ball.dy = ball.initialDy * (1 + 0.5 * (level - 1));
//				console.log(ball.dx);
//				console.log(ball.dy);
//				ball.speed *= 1.5; // Too fast.
				ball.speed *= 1.3;
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
		},
		itemBallCollide: function(itemBall, squareX, squareY, width, height){
			var distance = 0;
			if (itemBall.x < squareX) {
				distance += Math.pow(itemBall.x - squareX, 2);
			} else if (itemBall.x > squareX + width) {
				distance += Math.pow(itemBall.x - squareX - width, 2);
			}	
			if (itemBall.y < squareY) {
				distance += Math.pow(itemBall.y - squareY, 2);
			} else if (ball.y > squareY + height) {
				distance += Math.pow(itemBall.y - squareY - height, 2);
			}	
			return distance <= Math.pow(itemBall.radius, 2);
		},
		bulletsCollide: function(bullet, squareX, squareY, width, height){ //블럭과 총알의 충돌을 검사
			var distance = 0;
			if (bullet.x < squareX) {
				distance += Math.pow(bullet.x - squareX, 2);
			} else if (bullet.x > squareX + width) {
				distance += Math.pow(bullet.x - squareX - width, 2);
			}	
			if (bullet.y < squareY) {
				distance += Math.pow(bullet.y - squareY, 2);
			} else if (bullet.y > squareY + height) {
				distance += Math.pow(bullet.y - squareY - height, 2);
			}	
			return distance <= Math.pow(bullet.radius, 2);
		},
		setItems: function(map){
			var count = 0;
			while(count < 3){
				var i = Math.floor(Math.random() * map.length);
				var j = Math.floor(Math.random() * map[0].length);
				if(map[i][j] == 1){
					map[i][j] = 2;
					count++;
				}
			}
		},
		setBullets: function(){ 
			var tempBullet = {
				x : bat.x + bat.width / 2,
				y : canvas.height - bat.height - 5 * 2, 
				radius : 5,
				visible : true,
				speed : 5, 
				color : '#FFBB00'
			};
			bullets.push(tempBullet);
			console.log("bullet.length : "+bullets.length);
		}
	};
	
	ARKANOID.init();
}());