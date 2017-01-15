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

	$.each($(".carousel"), function() {
		$(this).swiperight(function() {
			$(this).carousel('prev');
		});
		$(this).swipeleft(function() {
			$(this).carousel('next');
		});
	});

}

function Shoes(_shoesConf) {
	var _me = this;
	_me.previewImg = $('#shoesPreview');
	_me.imgStart = 4;
	_me.imageRowName = $('.imgNames .imgRowColumn');
	_me.imageRow = $('.images .imgRowColumn');
	var first = $(_me.imageRow[0]).find('img');
	// toggle first Item
	_me.previewImg.attr('src', first.attr('src'));

	_me.togglePreview = function(arguments, ev) {
		var clickedImg = $(ev.currentTarget);
		var src = clickedImg.attr('src_big');
		_me.previewImg.attr('src', src);
	};
	_me.next = function() {
		if ((_me.imgStart + 1) > _me.imageRow.length) {
			return;
		}
		$.each(_me.imageRow, function(i) {
			var img = $(this);
			img.removeClass('activeImg');
			img.addClass('inactiveImg');
			img = $(_me.imageRowName[i]);
			img.removeClass('activeImg');
			img.addClass('inactiveImg');
		});
		for (var i = 0; i < 4; i++) {
			var img = $(_me.imageRow[_me.imgStart + i]);
			img.addClass('activeImg');
			img.removeClass('inactiveImg');
			img = $(_me.imageRowName[_me.imgStart + i]);
			img.addClass('activeImg');
			img.removeClass('inactiveImg');
		}
		_me.imgStart += 4;
	};
	_me.previous = function() {
		if (_me.imgStart - 4 <= 0) {
			return;
		}
		$.each(_me.imageRow, function(i) {
			var img = $(this);
			img.removeClass('activeImg');
			img.addClass('inactiveImg');
			img = $(_me.imageRowName[i]);
			img.removeClass('activeImg');
			img.addClass('inactiveImg');
		});
		_me.imgStart -= 4;
		for (var i = 4; i > 0; i--) {
			var img = $(_me.imageRow[_me.imgStart - i]);
			img.addClass('activeImg');
			img.removeClass('inactiveImg');
			img = $(_me.imageRowName[_me.imgStart + i]);
			img.addClass('activeImg');
			img.removeClass('inactiveImg');
		}
	};
}

/**
 * 
 * @constructor
 */
function ViewModel(_conf) {
	var self = this;
	self.dialog = null;
	if (_conf.target.shoes) {
		self.shoes = new Shoes({
			target : _conf.target.shoes
		});
	}
}
