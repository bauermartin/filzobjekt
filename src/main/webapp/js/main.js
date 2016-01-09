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
(function($) {
	init();

	de.filzobjekt.render = function() {
		de.filzobjekt.mainmodel.render();
	};
	de.filzobjekt.text = function(ev, type) {

		console.log(ev);
		de.filzobjekt.mainmodel.text(type);
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
	self.text_dialog = null;
	self.content = null;
	self.text = function(type) {

	};
	self.render = function() {
		$('.text_dialog').click(function() {
			// var self = $(this);
			// console.log(self.attr('id'));
			// renderDialog(self);
			$('#modalContent');
			$('#dialog').modal('toggle');
		});
	};
	function renderDialog(elem) {
		if (self.text_dialog === null) {
			self.content = $('<textarea>', {
				width : '100%',
				height : '100%'
			}).val(elem.html());
			var dialog = $('<div>', {
				width : 1000,
				height : 300
			}).append(self.content);
			$('body').append(dialog);
			self.text_dialog = $(dialog).dialog({
				title : "Text Editor",
				resizable : true,
				modal : true,
				draggable : false,
				width : 1000,
				height : 300
			});
		} else {
			self.content.val(elem.html());
			self.text_dialog.dialog().open();
		}
	}
}

function cleanText(text) {
	var text_lines = text.split("\n");
	var format_text = "";
	var first = true;
	$.each(text_lines, function() {
		var clean_text = this.trim();
		if (clean_text !== null && clean_text !== "") {
			if (!first) {
				format_text += "\n";
			}
			first = false;
			format_text += clean_text;
		}
	});
	return format_text;
}

/**
 * 
 * @constructor
 */
function NavModel() {
	var self = this;

}