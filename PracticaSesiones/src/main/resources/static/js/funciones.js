function muestraMensaje() {
	var url_string = window.location.href;
	var url = new URL(url_string);
	var referer = url.searchParams.get("referer");
	var resultadoAccionOK = url.searchParams.get("resultadoAccionOK");
	var resultadoAccionNOK = url.searchParams.get("resultadoAccionNOK");
	if (referer && referer !== "") {
		alert("Referer: " + referer);
	}	
	if (resultadoAccionOK && resultadoAccionOK !== "") {
		alert(resultadoAccionOK);
	}
	if (resultadoAccionNOK != null && resultadoAccionNOK !== "") {
		alert(resultadoAccionNOK);
	}	
}