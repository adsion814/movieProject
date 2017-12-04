$(document).ready(function(){
	$("#carousel-617528").carousel("cycle");
	$("#slideone").mouseover(function(){
	
		$("#moviehead1").css("font-size",40);
		$("#carousel-617528").carousel(0);
	});
	$("#slideone").mouseout(function(){
		$("#moviehead1").css("font-size",30);
		
	});
	$("#slidetwo").mouseover(function(){
		$("#moviehead2").css("font-size",40);
		$("#carousel-617528").carousel(1);
	});
	$("#slidetwo").mouseout(function(){
		$("#moviehead2").css("font-size",30);
		
	});
	$("#slidethree").mouseover(function(){
		$("#moviehead3").css("font-size",40);
		$("#carousel-617528").carousel(2);
	});
	$("#slidethree").mouseout(function(){
		$("#moviehead3").css("font-size",30);
		
	});
	

});

