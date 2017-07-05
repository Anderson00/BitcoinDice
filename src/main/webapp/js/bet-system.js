var baseChance = 49.5;
var rollNumberMax = 99.99;
var rollNumberMin = 0.01;
var basePayout = 2;
var chance = baseChance;
var payout = basePayout; //payout depende da chance
var payoutAlter = false, chanceAlter = false; // boolean;
var rangeUnder = false;

var payoutBox = $(".payout .box-text");
var payoutValue = $(".payout .box-text .value");
var payoutInput = [$(".payout .box-input"),$(".payout .box-input input")];
var chanceBox = $(".chance .box-text");
var chanceInput = [$(".chance .box-input"),$(".chance .box-input input")];
var chanceValue = $(".chance .box-text .value");
var rollRange = $(".chance-win .roll-range");
var rollValue = $(".chance-win .roll-range .value");

var balance = $("#balance");
var amount = $(".bet-area .amount");
var profit = $(".bet-area .profit");

amount.val("0.00000001");
profit.val(amount.val());

payoutBox.click(function(){
	payoutBox.css("display","none");
	payoutInput[0].css("display","block");
	payoutInput[1].focus();
});

chanceBox.click(function(){
	chanceBox.css("display","none");
	chanceInput[0].css("display","block");
	chanceInput[1].focus();
});

payoutInput[1].focusout(function(){
	payoutBox.css("display","block");
	payoutInput[0].css("display","none");
});

chanceInput[1].focusout(function(){
	chanceBox.css("display","block");
	chanceInput[0].css("display","none");
});

payoutInput[1].change(function(){	
	var value;
	var val = 0;
	val = parseFloat(this.value);
	var total = (basePayout*baseChance)/val;
	chance = total;
	chanceInput[1].val(total);
	chanceValue.text(total.toFixed(2)+"%");	
	if(this.value == parseInt(this.value))
		value = this.value+".000x";
	else{		
		console.log(parseFloat(this.value).toFixed(3));		
		value = parseFloat(this.value).toFixed(3)+"x";
	}
	
	payout = this.value;
	console.log(payout);
	profit.val( (parseFloat(amount.val())*payout-parseFloat(amount.val())).toFixed(8) );
	var roll = (rangeUnder)? (rollNumberMax-chance) : chance;
	rollValue.text(roll.toFixed(2));
	payoutValue.text(value);
});

payoutInput[1].keyup(function(){
	payoutInput[1].change();
}).keydown(function(){
	payoutInput[1].change();
});

chanceInput[1].change(function(){	
	var value;
		console.log("wed")
		chanceAlter = true;
		chance = parseFloat(this.value);	
		var total = (baseChance * basePayout)/chance;
		payoutInput[1].val(total);
		if(total == parseInt(total))
			value = total+".000x";
		else{		
			console.log(parseFloat(total).toFixed(3));		
			value = parseFloat(total).toFixed(3)+"x";
		}
		payoutValue.text(value);
	
	payout = total;	
	profit.val(calcProfit(payout).toFixed(8));
	var roll = (rangeUnder)? (rollNumberMax-chance) : chance;
	rollValue.text(roll.toFixed(2));
	chanceValue.text(this.value+"%");
});

chanceInput[1].keyup(function(){
	chanceInput[1].change();
}).keydown(function(){
	chanceInput[1].change();
});


rollRange.click(function(){
	var str = (rangeUnder)? "Roll Under":"Roll Over";
	$(".chance-win .roll-range label").text(str);
	rangeUnder = !rangeUnder;
	
	var roll = (rangeUnder)? (rollNumberMax-chance) : chance;
	rollValue.text(roll.toFixed(2));
});


$(".bet-area .half").click(function(){	
	amount.val((parseFloat(amount.val())/2).toFixed(8));
	profit.val(calcProfit(payout).toFixed(8));
});

$(".bet-area .double").click(function(){	
	amount.val((parseFloat(amount.val())*2).toFixed(8));
	profit.val(calcProfit(payout).toFixed(8));
});

$(".bet-area .max").click(function(){	
	amount.val($("#balance").text());
	profit.val(calcProfit(payout).toFixed(8));
});

function calcProfit(payout){
	return parseFloat(amount.val())*payout-parseFloat(amount.val());
}

function toSatoshi(val){
	return (val*1e8);
}
function toBTC(val){
	return (val*1e-8);
}

var cont = 0;

$(".roll-dice").click(function(){
	
	var a = toSatoshi(parseFloat(amount.val()));
	if(isNaN(a) || isNaN(payout))
		return;
	console.log(a);
	$.post("/bet",{'amount':a.toFixed(0),'payout':payout,'high':rangeUnder},function(data){
		var obj = JSON.parse(data);
		var b = toSatoshi(parseFloat(balance.text()));
		balance.text( toBTC(b+obj.profit).toFixed(8) );
		
		if($("#table-body tr").length >= 10){
			$("#table-body")[0].removeChild($("#table-body tr")[9]);
		}
		$("#table-body").prepend("<tr><td>"+obj.betID+"</td>" +
				"<td>"+obj.date+"</td>" +
				"<td>"+toBTC(obj.amount).toFixed(8)+"</td>" +
				"<td>"+obj.payout+"</td>" +
				"<td>"+obj.chance+"</td>" +
				"<td>"+obj.roll+"</td>" +
				"<td>"+toBTC(obj.profit).toFixed(8)+"</td></tr>");
		console.log(obj);
	});
});
