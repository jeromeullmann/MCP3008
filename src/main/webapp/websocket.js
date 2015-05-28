
var wsUri = "ws://" + document.location.hostname + ":" + document.location.port + document.location.pathname + "websocket/ledstatus";

var websocket = new WebSocket(wsUri);

websocket.onopen = function(evt) { onOpen(evt) };
websocket.onmessage = function(evt) { onMessage(evt) };
websocket.onerror = function(evt) { onError(evt) };

function join() {
    websocket.send(username + " joined");
}

function send_message() {
    websocket.send(username + ": " + textField.value);
}

function onOpen() {
    writeToScreen("Connected to " + wsUri);
}

function onMessage(evt) {
    writeToScreen("onMessage: " + evt.data);
}

function onError(evt) {
    writeToScreen('<span style="color: red;">ERROR:</span> ' + evt.data);
}

function writeToScreen(message) {
	console.log(message);
	$("#log").append("<p>"+message+"</p>");
}



