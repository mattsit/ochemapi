var host = "http://localhost:4567";

var molecule_server = host + "/molecule";
var params = {formula: "water", panel: 0};
var molecule_params = {formula: "water"};
var panel;

$(document).ready(function(){

	$(".button").click(function() {
	    console.log("click");
		$.get({
		    async: true,
		    url: host,
		    data: params,
		    success: function(data) {
		        console.log("success");
		        params["panel"] = data;
		    }
		});
	});
});
