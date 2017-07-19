$(".earnBt").click(function(){
	$.get("/freebitcoin",function(data){
		var obj = JSON.parse(data);
		$(".modal .ok").text("");
		$(".modal .error").text(obj.error);	
		if(obj.error == undefined){
			$(".modal .error").text("");
			$(".modal .ok").text("You won 200 satoshi");	
			$('.balance').text( (obj.balance*1e-8).toFixed(8) );
		}
	})
});

$(".modal .withdraw").click(function(){
	$.post("/withdraw",{'amount':$("#myModal2 .form-control")[0].value,'address':$("#myModal2 .form-control")[1].value},function(data){
		var dat = JSON.parse(data);
		if($("#myModal2 .form-control")[0].value == 0 || $("#myModal2 .form-control")[1].value == ""){
			$(".modal .error").text("Empty Fields");
			$(".modal .ok").text("");
		}
		if(dat.error == undefined){
			$(".modal .error").text("");
			$(".modal .ok").text("Ok");
			$(".modal .error").text(dat.error);
			if(pays != undefined)
				pays();
			
			var amount = parseFloat($(".balance")[0].innerHTML);
			var withdraw = parseFloat($(".withD")[0].innerHTML);
			
			var v = parseInt($("#myModal2 .form-control")[0].value)*1e-8;
			$(".balance").text((amount-v).toFixed(8));
			$(".withD").text((withdraw + v).toFixed(8));
		}else{
			$(".modal .error").text(dat.error);
			$(".modal .ok").text("");
		}
	});
	
});