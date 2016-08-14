/**
 * 
 */
var div,req,id,pokemon,resp;
var oReq = new XMLHttpRequest();
window.onload = function(){
	req = new XMLHttpRequest();
	div = document.getElementById('mainArea');
	document.getElementById('submit').addEventListener('click', submit, false);
	document.getElementById('clear').addEventListener('click', clear, false);
}
function reqListener () {
	console.log(this.responseText);
}
function submit(event){
	

		
		oReq.addEventListener("load", reqListener);
		oReq.open("GET", "http://www.example.org/example.txt");
		oReq.send();
//	id = parseInt(document.getElementById('txtbox').value);
//	if(!id){
//		req.open("GET", "http://pokeapi.co/api/v2/pokemon/"+id, false);
//		req.onreadystatechange = function() {
//			if (req.readyState != 4) return;
//			if (req.status != 200) {
//			return;
//			}
//			resp = req.responseText;
//		}
//		req.send();
//	}
//	if(resp){
//		div.innerHTML += resp.sprites.front_default;
//	}
}
function clear(event){
	div.innerHTML = '';
}