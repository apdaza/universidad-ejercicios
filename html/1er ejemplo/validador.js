function validar(){
	if(document.getElementById('nombre').value==""){
		alert('el nombre no puede ser vacio');
		return;
	}
	if(document.getElementById('apellido').value==""){
		alert('el apellido no puede ser vacio');
		return;
	}
	if(document.getElementById('ciudad').value=="0"){
		alert('la ciudad no puede ser vacio');
		return;
	}
	alert('ok');
	document.getElementById('frmPersonal').submit();
}
