function on(){
	var url ="ws/led/on";
	 sendRequest(url);
}
function off(){
	var url ="ws/led/off";
	 sendRequest(url);
}

function capture(){
	var sec = $("#sec").val();
	var url ="ws/led?nb="+nb+"&sec="+sec;
	 sendRequest(url);
}

function sendRequest(url){
	$.get( url, function( data ) {
		});
}
