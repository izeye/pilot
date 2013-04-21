var cocos2dApp = cc.Application.extend({
	config: document.querySelector('#cocos2d-html5')['c'],
	ctor: function (scene) {
		this._super();
		this.startScene = scene;
		cc.COCOS2D_DEBUG = this.config['COCOS2D_DEBUG'];
		cc.setup(this.config['tag']);
		cc.Loader.shareLoader().onloading = function () {
			cc.LoaderScene.shareLoaderScene().draw();
		};
		cc.Loader.shareLoader().onload = function () {
			cc.AppController.shareAppController().didFinishLaunchingWithOptions();
		};
		cc.Loader.shareLoader().preload([]);
	}
})