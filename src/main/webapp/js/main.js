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
})(jQuery);

/**
 * 
 */
function init() {
	de.filzobjekt.mainmodel = new MainModel();
}
/**
 * 
 * @constructor
 */
function MainModel() {
	var self = this;
	self.render = function() {
		var editor = CKEDITOR.instances["editor"];

		var close_ev = false;
		$('#dialog_close1').click(function() {
			close_ev = true;
		});
		$('#dialog_close2').click(function() {
			close_ev = true;
		});
		var orig_field = null;
		$('.text_dialog').click(function() {
			close_ev = false;
			orig_field = $(this);
			var editor_field = $('#editor');
			if (editor) {
				editor.destroy(true);
			}
			editor_field.text(orig_field.html());
			editor = CKEDITOR.replace(editor_field.get(0));
			$('#dialog').modal('toggle');
		});

		$('#dialog').on('hidden.bs.modal', function(e) {
			if (!close_ev) {
				orig_field.html(editor.getData());
			}
		});
	};
}
