$(".earnBt").click(function(){
	$.get("/freebitcoin",function(data){
		var obj = JSON.parse(data);
		$(".modal .error").text(obj.error);
	})
})