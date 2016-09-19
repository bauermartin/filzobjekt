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
$(function() {
	init();
	console.log("init");
});

/**
 * 
 */
function init() {
	de.filzobjekt.ViewModel = new ViewModel({
		target : {
			shoes : $('.shoes'),
			home : $('.home')
		}
	});
	ko.applyBindings(de.filzobjekt.ViewModel);
}

/**
 * 
 * @constructor
 */
function ViewModel(_conf) {
	var self = this;
	self.dialog = null;
	self.shoes = new Shoes({
		target : _conf.target.shoes
	});

	function Shoes(_shoesConf) {
		var _me = this;
		_me.previewImg = $('#shoesPreview');
		_me.imgStart = 5;
		_me.imageRow = $('.imgRowColumn');
		_me.togglePreview = function(arguments, ev) {
			var clickedImg = $(ev.currentTarget);
			var src = clickedImg.attr('src');
			_me.previewImg.attr('src', src);
		};
		_me.next = function() {
			if ((_me.imgStart + 1) > _me.imageRow.length) {
				return;
			}
			$.each(_me.imageRow, function() {
				var img = $(this);
				img.removeClass('activeImg');
				img.addClass('inactiveImg');
			});
			console.log(_me.imgStart);
			for (var i = 0; i < 5; i++) {
				var img = $(_me.imageRow[_me.imgStart + i]);
				img.addClass('activeImg');
				img.removeClass('inactiveImg');
			}
			_me.imgStart += 5;
		};
		_me.previous = function() {
			if (_me.imgStart - 5 <= 0) {
				return;
			}
			$.each(_me.imageRow, function() {
				var img = $(this);
				img.removeClass('activeImg');
				img.addClass('inactiveImg');
			});
			_me.imgStart -= 5;
			console.log(_me.imgStart);
			for (var i = 5; i > 0; i--) {
				var pos = _me.imgStart - i;
				console.log(pos);
				var img = $(_me.imageRow[_me.imgStart - i]);
				img.addClass('activeImg');
				img.removeClass('inactiveImg');
			}
		};
	}

	self.render = function() {

	}
}
