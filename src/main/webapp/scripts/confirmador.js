
function confirmar(idcontato){
	 let resposta = confirm("Confirma a exclusao deste contato?")
	 if(resposta === true){
		 window.location.href = "delete?idcontato=" + idcontato
	 }
 }