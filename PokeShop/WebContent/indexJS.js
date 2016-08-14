var total = 0;
var cPokemon = [];
var cCost = [];
//ajax call to pull 151 pokemon
$.ajax({url: "http://pokeapi.co/api/v2/pokemon/?limit=151",
		success: function(data){
			var tableString = "<table class='table table-hover'>"+
				"<thread><tr><th>Name</th><th>Price</th><th>Add to Cart</th>"+
				"</tr></thread><tbody>";
			//add price using math.random
			for(var x=0;x<data.results.length;x++){
				console.log(data.results[x].name)
				var num = ((Math.random()*100)+0.01).toFixed(2);
				tableString += "<tr id='"+data.results[x].name+
					"'><td>"+data.results[x].name+"</td> <td>$"+num+
					"</td><td><button class ='btn btn-success'"+
					"id=\"btn"+data.results[x].name+"\" onclick='addToCart(&apos;'"+
					data.results[x].name.valueOf().toString()+"&apos;,"+
					num+")'>Add To Cart</button></td></tr>"
			}
			tableString += "</tbody></table>";
			$('#pokemon').html(tableString);
		}
		
})
        //builds table string from api call
    
	//for loop through pokemon
        //add a price for each pokemon using math.random
        //sets up id to be pokemon name 
        //sets up button to have onclick passing name and price
    
   
        //appends the table to the html page
    

//adds a pokemon to the cart
var addToCart = function(name,price){
	$("#cart").empty();
	cPokemon.push(name);
	cCost.push(price);
	for(var l=0;l<cPokemon.length;l++){
		$("#cart").append("<tr><td>"+cPokemon[l]+"</td><td>"+
				cCost[l]+"</td><td><button class='btn btn-link'"+
				" style='color:red;' onClick='removeFromCart(&apos;"+
				cPokemon[l]+"&apos;)'> &#10060</button></td></tr>");
		total+=cCost[l];
	}
	$('#total').text("Total: $"+total);
	$("#"+name).css("background-color","yellow");
	$("btn"+name).prop("disabled",true);
}
    //clear cart for new entries
    
    //pushes pokemon and price into arrays

    //creates item for the cart with remove button
    
    //increase total
    
    //change total amount on page along with css for pokemon on list


//remove pokemon from cart
//reactivate button
//change color back to white
removeFromCart=function(name){
	$("#"+name).css("background-color","white");
	$("#btn"+name).prop("disabled",false);
	for(var r=0;r<c.pokemon.length;r++){
		if(cPokemon[r]==name){
			total-=cCost[r];
			cPokemon.splice(r,1);
			$("#total").text("Total: $"+total);
		}
		$("#cart").empty();
		for(var a=0;a<cPokemon.length;a++){
			$("#cart").append("<tr><td>"+cPokemon[a]+
					"</td><td>"+cCost[a]+"</td><td>"+
					"<button class='btn btn-link'style='color:red;'"+
					"onClikck=removeFromCart(&apos;"+cPokemon[a]+
					"&apos;)'>&#10060</button></td></tr>")
		}
	}
}
    //reset list

    //remove item from array and rebuild list

    //clear div for new data
    
    //create new list
 

//reset page for new purchase
//checkout fn
checkout = function(){
	for(var c=0;c<cPokemon.length;c++){
		total=0;
		$("#cart").empty();
		$("#total").text("Total: $");
		$("#btn"+cPokemon[c]).prop("disabled",false);
	}
}