if (typeof de == 'undefined') {
	var de = {}
}
if (typeof de.filzobjekt == 'undefined') {
	de.filzobjekt = {};
}

(function($) {
	de.filzobjekt.render = function() {
		console.log($('#submit'));
		var submit_btn = $('#submit').click(
		function() {
			console.log("Click Submit");
			var user_fld = $('#username');
			var pw_fld = $('#password');
			var username = user_fld.val();
			var pw = pw_fld.val();
			if (username == '' || username == null) {
				console.log("username == empty");
				return;
			}
			if (pw == '' || pw == null) {
				console.log("pw == empty");
				return;
			}
			$.ajax({
				url : "rest/login",
				type : "PUT",
				data : {
					'username' : username,
					'password' : pw
				},
				dataType : "html",
				success : function(data, textStatus, jqXHR) {
					console.log("success", data);
					de.filzobjekt.token = jqXHR.getResponseHeader('authorization');
					//window.location.replace("/");
				},
				error : function() {
					console.log("error");
				}
			});
		});

	}
})(jQuery);
