/**
 * 
 */
var showDeny = function(){
	hideAll();
	var rows = document.getElementsByClassName("Denied");
	for(var i =0, il = rows.length;i<il;i++){
		rows[i].className = "trow Denied";
	}
}

var showPending = function(){
	hideAll();
	var rows = document.getElementsByClassName("Pending");
	for(var i =0, il = rows.length;i<il;i++){
		rows[i].className = "trow Pending";
	}
}

var showApproved = function(){
	hideAll();
	var rows = document.getElementsByClassName("Approved");
	for(var i =0;i<rows.length;i++){
		rows[i].className = "trow Approved";
	}
}

var showResolved = function(){
	hideAll();
	var rows = document.getElementsByClassName("Denied");
	for(var i =0;i<rows.length;i++){
		rows[i].className = "trow Denied";
	}
	var rows = document.getElementsByClassName("Approved");
	for(var i =0;i<rows.length;i++){
		rows[i].className = "trow Approved";
	}
}

var showAll = function(){
	var rows = document.getElementsByClassName("Denied");
	for(var i =0;i<rows.length;i++){
		rows[i].className = "trow Denied";
	}
	var rows = document.getElementsByClassName("Pending");
	for(var i =0;i<rows.length;i++){
		rows[i].className = "trow Pending";
	}
	var rows = document.getElementsByClassName("Approved");
	for(var i =0;i<rows.length;i++){
		rows[i].className = "trow Approved";
	}
}

var hideAll = function(){
	var rows = document.getElementsByClassName("trow");
	for(var i =0;i<rows.length;i++){
		rows[i].className += " hidden";
	}
}