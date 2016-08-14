/**
 * JavaScript
 */
var ul,total;
function rfibbinachi(num1,num2){
	addDisplay('', num1);
	addDisplay('', num2);
	total=num1-num2;
	addDisplay('', total);
	for(var i = 0;i<100;i++){
		total=num2-total;
		num2=num2-total;
		addDisplay('', total);
	}
}
function fibbinachi(num1,num2){
	addDisplay('', num1);
	addDisplay('', num2);
	total=num1+num2;
	addDisplay('', total);
	for(var i = 0;i<100;i++){
		total=total+num2;
		num2=total-num2;
		addDisplay('', total);
	}
}
function fizzbuzz(num,start){
	if(isNaN(start))
		start=0;
	for(var i=start; i<=num; i++)
		if(i%15==0)
			addDisplay("FizzBuzz",i);
		else if(i%5==0)
			addDisplay("Buzz",i);
		else if(i%3==0)
			addDisplay("Fizz",i);
		else
			addDisplay("",i);
}
function handler(event){
	ul.innerHTML = '';
	rfibbinachi(parseInt(document.getElementById('txtbox').value),parseInt(document.getElementById('conbox').value));
}
window.onload = function(){
	ul = document.getElementById('ulbody');
	document.getElementById('submit').addEventListener('click', handler, false);
}
function addDisplay(str, num){
	var li = document.createElement("li");
	if(num||num==0)
		li.appendChild(document.createTextNode(num + ".  " + str));
	else
		console.log("ERROR");
	ul.appendChild(li);
}

