// JavaScript Document
function mostrarDiv(divId){
	document.getElementById(divId).style.visibility = 'visible';
	document.getElementById(divId).style.display = '';
}

function ocultarDiv(divId){
	document.getElementById(divId).style.visibility = 'hidden';
	document.getElementById(divId).style.display = 'none';
}

function limpiar(id){
	document.getElementById(id).value = '';
}

function changePage(action){
	var r = parseInt(document.getElementById('rows').value);
	var i = parseInt(document.getElementById('init').value);
	var s = parseInt(document.getElementById('size').value);
	var tope = i+s;
	for(h=i;h<=tope;h++){
		if(h>1 && h<=r) ocultarDiv('div_'+h);
	}
	
	if(action=='foward'){
		if(i+s<r)i += s;
	}else{
		if(i>s)i -= s; else i=2;
	}
	for(h=i;h<i+s;h++){
		if(h>1 && h<=r) mostrarDiv('div_'+h);
	}
	
	document.getElementById('init').value = i;
	document.getElementById('size').value = s;
}

function habilitarDependiente(element){
	var val = element.value;
	var objRadio = document.getElementsByName('radio_'+val);
	var lon = objRadio.length;
	if(element.checked==true){
		for(i=0;i<lon;i++){
			document.getElementsByName('radio_'+val)[i].disabled=false;
		}
	}else{
		for(i=0;i<lon;i++){
			document.getElementsByName('radio_'+val)[i].checked=false;
			document.getElementsByName('radio_'+val)[i].disabled=true;
		}
	}
	//alert ('radio_'+val);
}

function validarMail(mail){
	if(mail.indexOf('@') == -1){
		return false;
	}else if(mail.indexOf('@') != mail.lastIndexOf('@')){
		return false;
	}else if(mail.indexOf('.') == -1){
		return false;
	}else{
		return true;	
	}	
}

function validarUrlOpcion(url){
	if(url.indexOf('php') == -1){
		return false;
	}else if(url.indexOf('.') == -1){
		return false;
	}else{
		return true;	
	}	
}

function validarDane(dane){
	if (/^([0-9])*$/.test(dane)){
		return true;
	}else{
		return false;	
	}
}

function validarEntero(entero){
	if (/^([0-9])*$/.test(entero)){
		return true;
	}else{
		return false;	
	}
}

function validarCoordenadas(coor){
	//if(/(^[0-9]{2}\s[0-9]{2}\s[0-9]{2}\E?W?N?S?)$/.test(coor)){
		return true;
	/*}else{
		return false;
	}	*/
}

function validarTelefono(tel){
	if (/^([0-9])*$/.test(tel)){
		if(parseInt(tel)>=2000000 && parseInt(tel)<=9999999){
			return true;
		}else{
			return false;
		}
	}else{
		return false;	
	}
}

function validarCelular(cel){
	if (/^([0-9])*$/.test(cel)){
		if(parseInt(cel)>=3000000000 && parseInt(cel)<=3299999999){
			return true;
		}else{
			return false;
		}
	}else{
		return false;	
	}
}

function validarReal(num){
	if(/^(?:\+|-)?\d+\.?\d*$/.test(num)){
		return true;
	}else{
		return false;
	}
}

function validarRealEntre(num,l1,l2){
	if(/^(?:\+|-)?\d+\.?\d*$/.test(num)){
		if(parseFloat(num)>=parseFloat(l1)&&parseFloat(num)<=parseFloat(l2)){
			return true;
		}else{
			return false;
		}
	}else{
		return false;
	}
}

function calcularPorcentaje(num1,num2){
	var por = num2*100/num1;
	por = Math.round(por * Math.pow(10, 2)) / Math.pow(10, 2);
	return por;
}

function asignarPorcentaje(id_element,num1,num2){
	document.getElementById(id_element).value = calcularPorcentaje(document.getElementById(num1).value,document.getElementById(num2).value);	
}

function convertirFecha(fecha1){
	var mes = fecha1.substring(5,7);
	var dia = fecha1.substring(8,10);
	var ano = fecha1.substring(0,4);
	var fecha=mes+"/"+dia+"/"+ano;
	return new Date(fecha);
}



function limpiarCampo(campo){
	document.getElementById(campo).value="";
}

function cancelarAccion(form,accion){
	document.getElementById(form).action=accion;
	document.getElementById(form).submit();
}
