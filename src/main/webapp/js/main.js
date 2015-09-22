/**
 * Created by MBauer on 14.09.2015.
 */
if (typeof de == 'undefined') {
	var de = {}
}
if (typeof de.filzobjekt == 'undefined') {
	de.filzobjekt = {};
}
/**
 *
 */
(function ($) {
	init();
	de.filzobjekt.render = function () {
		de.filzobjekt.nav.render();
		console.log(de.filzobjekt.nav.home_button);
	};
})(jQuery);

/**
 *
 */
function init() {
	de.filzobjekt.mainmodel = new MainModel();
	de.filzobjekt.nav = new NavModel();
}

/**
 *
 * @constructor
 */
function MainModel() {
	var self = this;
	self.buttons = [];
}

/**
 *
 * @constructor
 */
function NavModel() {
	var self = this;
	self.render = function () {
		self.home_button = $('button[name=home]').button().click(function () {
			console.log("this is a test");
		});

		self.shoes_button = $('button[name=shoes]').button().click(function () {
			console.log("this is a test");
		});

		self.handbag_button = $('button[name=handbag]').button().click(function () {
			console.log("this is a test");
		});

		self.object_button = $('button[name=object]').button().click(function () {
			console.log("this is a test");
		});

		self.seat_pad_button = $('button[name=seat_pad]').button().click(function () {
			console.log("this is a test");
		});

		self.scarf_button = $('button[name=scarf]').button().click(function () {
			console.log("this is a test");
		});
	self.gabi_button=$('button[name=gabi]').button();
		self.impressum_button=$('button[name=impressum]').button();
		self.kontakt_button=$('button[name=kontakt]').button();
	};
}
