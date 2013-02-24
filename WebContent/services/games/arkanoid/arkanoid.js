(function () {
	document = window.document;
	canvas = document.getElementById('canvas');
	context = canvas.getContext('2d');

	ARKANOID = {
		bat: {
			width: 80,
			height: 20,
			x: canvas.width / 2 - this.width / 2,
			y: canvas.height - this.height
		},
		ball: {
			radius: 10,
			x: this.bat.x + this.bat.width / 2 - this.radius,
			y: this.canvas.height - this.bat.height - this.radius,
			dx: 0,
			dy: 0
		},
		init: function () {
			console.log('init');
			this.bind();
			
			this.context.fillStyle = '#CCC';
			this.context.fillRect(0, 0, this.canvas.width, this.canvas.height);
		},
		bind: function () {
			this.document.onkeydown = function (e) {
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
			console.log('start');
			this.init();
		}
	};
}());