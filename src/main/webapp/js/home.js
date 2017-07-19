$.get("/betinfo/100",function(dat){
	
	morris =  Morris.Area({
        element: 'morris-area-chart',
        data: dat,
        xkey: 'date',
        ykeys: ['balance'],
        labels: ['balance'],
        pointSize: 2,
        hideHover: 'auto',
        resize: true
    });
})

function dateFormat(obj){
	var data = new Date(obj);
	return data.toLocaleDateString()+" "+data.toLocaleTimeString().slice(0,5);
}

function pays(){
	$.get("/payments",function(dat){
		console.log(dat);
		$(".table-body")[0].innerHTML = "";
		var lng = (dat.length-1 > 6)? 6 : dat.length; 
		for(var i = lng; i >= 0; i--){
			var data = new Date(dat[i].date);
			$(".table-body").prepend("<tr>" +
						"<td>"+dat[i].payID+"</td>" +
						"<td>"+data.toLocaleDateString()+"</td>" +
						"<td>"+data.toLocaleTimeString().slice(0,5)+"</td>" +
						"<td>"+(dat[i].amount*1e-8).toFixed(8)+"</td>" +
					"</tr>");
		}
	});
}
pays();

