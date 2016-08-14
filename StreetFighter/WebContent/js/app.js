/**
 *  Street Fighter js
 */


var isHover = false;
//Load Javascript
$(document).ready(function(){
	$(".ryu").mouseenter(function(){
		$(".ryu-still").hide();
		$(".ryu-ready").show();
		isHover = true;
	}).mouseleave(function(){
		$(".ryu-ready").hide();
		$(".ryu-still").show();
		isHover = false;
	}).mousedown(function(){
		playHadouken();
		$(".ryu-ready").hide();
		$(".ryu-throwing").show();
		$(".hadouken").show().animate({'left':"5rem"},280,
				function(){
					$(this).hide();
					$(this).css("left","10rem");
		});
	}).mouseup(function(){
		$(".ryu-throwing").hide();
		$(".ryu-ready").show();
	})
})
	
	//Play hadouken-sound on mousedown
	//show throwing, hide ready
	//Animate hadouken gif 
	
	//mouseup - hide throwing, show ready 
	
//---
//document ready keydown 'x'
$(document).keydown(function(evtkey){
	if(evtkey.keyCode == 88){
		playPose();
		$(".ryu-cool").show();
		$(".ryu-still").hide();
		$(".ryu-ready").hide();
		$(".ryu-throwing").hide();
	}
}).keyup(function(evtkey){
	if(evtkey.keyCode == 88){
		$("#playEye")[0].pause();
		$(".ryu-cool").hide();
		if(isHover == true){
			$(".ryu-ready").show();
		}else{
			$(".ryu-still").show();
		}
	}
})

//playPose, show cool, hide still, hide ready
var playSound = false;
function playPose(){
//	playSound= !playSpund;
//	if(playSound){
//		$("#playEye")[0].volume = 0.2;
//		$("#playEye")[0].play();
//	}
//	else{
//		$("#playEye")[0].stop();
//	}
	$("#playEye")[0].volume = 0.2;
	$("#playEye")[0].play();
}
//keyup 'x' pose-sound pause/load, hide cool
//if hover show ready else show still
//---


//Play hadouken fn - volume, load, play
function playHadouken(){
	$("#playHadouken")[0].volume = 0.2;
	$("#playHadouken")[0].load();
	$("#playHadouken")[0].play();
}
//Play prose fn 