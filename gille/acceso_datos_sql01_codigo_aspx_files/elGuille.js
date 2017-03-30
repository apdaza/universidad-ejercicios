// FlashObject
// Para que se vean los Flash sin necesidad de activarlos.
// Puesto para usar con los banners de Microsoft (McCann) (23/Ago/06 15.11)
//
/**
 * FlashObject v1.3d: Flash detection and embed - http://blog.deconcept.com/flashobject/
 *
 * FlashObject is (c) 2006 Geoff Stearns and is released under the MIT License:
 * http://www.opensource.org/licenses/mit-license.php
 *
 */
if(typeof com=="undefined"){var com=new Object();}
if(typeof com.deconcept=="undefined"){com.deconcept=new Object();}
if(typeof com.deconcept.util=="undefined"){com.deconcept.util=new Object();}
if(typeof com.deconcept.FlashObjectUtil=="undefined"){com.deconcept.FlashObjectUtil=new Object();}
com.deconcept.FlashObject=function(_1,id,w,h,_5,c,_7,_8,_9,_a,_b){
if(!document.createElement||!document.getElementById){return;}
this.DETECT_KEY=_b?_b:"detectflash";
this.skipDetect=com.deconcept.util.getRequestParameter(this.DETECT_KEY);
this.params=new Object();
this.variables=new Object();
this.attributes=new Array();
this.useExpressInstall=_7;
if(_1){this.setAttribute("swf",_1);}
if(id){this.setAttribute("id",id);}
if(w){this.setAttribute("width",w);}
if(h){this.setAttribute("height",h);}
if(_5){this.setAttribute("version",new com.deconcept.PlayerVersion(_5.toString().split(".")));}
this.installedVer=com.deconcept.FlashObjectUtil.getPlayerVersion(this.getAttribute("version"),_7);
if(c){this.addParam("bgcolor",c);}
var q=_8?_8:"high";
this.addParam("quality",q);
var _d=(_9)?_9:window.location;
this.setAttribute("xiRedirectUrl",_d);
this.setAttribute("redirectUrl","");
if(_a){this.setAttribute("redirectUrl",_a);}
};
com.deconcept.FlashObject.prototype={setAttribute:function(_e,_f){
this.attributes[_e]=_f;
},getAttribute:function(_10){
return this.attributes[_10];
},addParam:function(_11,_12){
this.params[_11]=_12;
},getParams:function(){
return this.params;
},addVariable:function(_13,_14){
this.variables[_13]=_14;
},getVariable:function(_15){
return this.variables[_15];
},getVariables:function(){
return this.variables;
},createParamTag:function(n,v){
var p=document.createElement("param");
p.setAttribute("name",n);
p.setAttribute("value",v);
return p;
},getVariablePairs:function(){
var _19=new Array();
var key;
var _1b=this.getVariables();
for(key in _1b){_19.push(key+"="+_1b[key]);}
return _19;
},getFlashHTML:function(){
var _1c="";
if(navigator.plugins&&navigator.mimeTypes&&navigator.mimeTypes.length){
if(this.getAttribute("doExpressInstall")){
this.addVariable("MMplayerType","PlugIn");
}
_1c="<embed type=\"application/x-shockwave-flash\" src=\""+this.getAttribute("swf")+"\" width=\""+this.getAttribute("width")+"\" height=\""+this.getAttribute("height")+"\"";
_1c+=" id=\""+this.getAttribute("id")+"\" name=\""+this.getAttribute("id")+"\" ";
var _1d=this.getParams();
for(var key in _1d){_1c+=[key]+"=\""+_1d[key]+"\" ";}
var _1f=this.getVariablePairs().join("&");
if(_1f.length>0){_1c+="flashvars=\""+_1f+"\"";}
_1c+="/>";
}else{
if(this.getAttribute("doExpressInstall")){this.addVariable("MMplayerType","ActiveX");}
_1c="<object id=\""+this.getAttribute("id")+"\" classid=\"clsid:D27CDB6E-AE6D-11cf-96B8-444553540000\" width=\""+this.getAttribute("width")+"\" height=\""+this.getAttribute("height")+"\">";
_1c+="<param name=\"movie\" value=\""+this.getAttribute("swf")+"\" />";
var _20=this.getParams();
for(var key in _20){_1c+="<param name=\""+key+"\" value=\""+_20[key]+"\" />";}
var _22=this.getVariablePairs().join("&");
if(_22.length>0){_1c+="<param name=\"flashvars\" value=\""+_22+"\" />";
}_1c+="</object>";}
return _1c;
},write:function(_23){
if(this.useExpressInstall){
var _24=new com.deconcept.PlayerVersion([6,0,65]);
if(this.installedVer.versionIsValid(_24)&&!this.installedVer.versionIsValid(this.getAttribute("version"))){
this.setAttribute("doExpressInstall",true);
this.addVariable("MMredirectURL",escape(this.getAttribute("xiRedirectUrl")));
document.title=document.title.slice(0,47)+" - Flash Player Installation";
this.addVariable("MMdoctitle",document.title);}
}else{this.setAttribute("doExpressInstall",false);}
if(this.skipDetect||this.getAttribute("doExpressInstall")||this.installedVer.versionIsValid(this.getAttribute("version"))){
var n=(typeof _23=="string")?document.getElementById(_23):_23;
n.innerHTML=this.getFlashHTML();
}else{if(this.getAttribute("redirectUrl")!=""){document.location.replace(this.getAttribute("redirectUrl"));}}}};
com.deconcept.FlashObjectUtil.getPlayerVersion=function(_26,_27){
var _28=new com.deconcept.PlayerVersion(0,0,0);
if(navigator.plugins&&navigator.mimeTypes.length){
var x=navigator.plugins["Shockwave Flash"];
if(x&&x.description){_28=new com.deconcept.PlayerVersion(x.description.replace(/([a-z]|[A-Z]|\s)+/,"").replace(/(\s+r|\s+b[0-9]+)/,".").split("."));}
}else{
try{var axo=new ActiveXObject("ShockwaveFlash.ShockwaveFlash");
for(var i=3;axo!=null;i++){
axo=new ActiveXObject("ShockwaveFlash.ShockwaveFlash."+i);
_28=new com.deconcept.PlayerVersion([i,0,0]);}}
catch(e){}
if(_26&&_28.major>_26.major){return _28;}
if(!_26||((_26.minor!=0||_26.rev!=0)&&_28.major==_26.major)||_28.major!=6||_27){
try{
_28=new com.deconcept.PlayerVersion(axo.GetVariable("$version").split(" ")[1].split(","));
}catch(e){}}}
return _28;
};
com.deconcept.PlayerVersion=function(_2c){
this.major=parseInt(_2c[0])||0;
this.minor=parseInt(_2c[1])||0;
this.rev=parseInt(_2c[2])||0;
};
com.deconcept.PlayerVersion.prototype.versionIsValid=function(fv){
if(this.major<fv.major){return false;}
if(this.major>fv.major){return true;}
if(this.minor<fv.minor){return false;}
if(this.minor>fv.minor){return true;}
if(this.rev<fv.rev){return false;}
return true;
};
com.deconcept.util={getRequestParameter:function(_2e){
var q=document.location.search||document.location.hash;
if(q){var _30=q.indexOf(_2e+"=");
var _31=(q.indexOf("&",_30)>-1)?q.indexOf("&",_30):q.length;
if(q.length>1&&_30>-1){
return q.substring(q.indexOf("=",_30)+1,_31);}}return "";
},removeChildren:function(n){
while(n.hasChildNodes()){
n.removeChild(n.firstChild);}}};
if(Array.prototype.push==null){
Array.prototype.push=function(_33){
this[this.length]=_33;
return this.length;};}
var getQueryParamValue=com.deconcept.util.getRequestParameter;
var FlashObject=com.deconcept.FlashObject;

//
//==========================================
// elGuille.js
// (c)Guillermo 'guille' Som, 1998-2006
// Última revisión:           (30/Mar/2006)
//==========================================
function validarGuille(valor){
	if(valor=="")
		return false;
    fBuscarGuille.B3.value=valor;
    fBuscarGuille.Op.value="150";
    return true;
}
function validarGuille2(valor){
	if(valor=="")
		return false;
    fBuscarGuille2.B3.value=valor;
    fBuscarGuille2.Op.value="150";
    return true;
}
// Solo si se debe poner la cabecera (valor por defecto) (26/Jun/07)
// ///////////////////////////
// isDefined (o para saber si está definida la variable)
// http://jehiah.cz/archive/javascript-isdefined-function
// El que funciona es lo que dice Marton
// ///////////////////////////
sinCabecera = window.sinCabecera ? window.sinCabecera : false;
	
if( sinCabecera == false )
{
document.write("<table border='1' width='100%'>" +
"  <tr>" +
"    <td valign='middle' align='middle' width='200' rowspan=2>" +
"       <a href='"+gsPath+"default.aspx'>" +
"       <img src='"+gsPath+"imagenes/el_guille.gif' alt='ir al indice principal' border='0'></a>" +
"    </td>" +
"    <td align='middle'>" +
"       <font face='Comic Sans MS' color='#000080' size='4'><strong><a href='"+gsPath+"el_guille.aspx' style='color:navy'><acronym title='Quien es el Guille?'>el Guille</acronym></a>, la Web del Visual Basic, C#, .NET y m&aacute;s...</strong></font>" +
"    </td>" +
"  </tr>" +
"   <tr>" +
"       <td align='middle' height=20 background='"+gsPath+"imagenes/barra_grisclaro.png'><b><font face='Verdana' size='1'>&nbsp;"+
"       <a href='"+gsPath+"lonuevo/2007/octubre/Default.aspx'><acronym title='Lo Nuevo de este mes'>Lo+</acronym></a> -" +
"       <a href='"+gsPath+"NET/WinFX/default.aspx'><acronym title='Indice de WinFX, WPF, WWF, WCF y .NET 3.0'>WinFX</acronym></a> -" + 
"       <a href='"+gsPath+"NET/default.aspx'><acronym title='El indice de punto NET'>.NET</acronym></a> -" +
"       <a href='"+gsPath+"NET/ADONET/indiceADONET.asp'><acronym title='Bases de datos de punto NET'>ADO.NET</acronym></a> -" +
"       <a href='"+gsPath+"NET/ASPNET/indiceASPNET.aspx'><acronym title='Paginas y servicios Web en punto NET'>ASP.NET</acronym></a> -" +
"       <a href='"+gsPath+"NET/comodotnet.aspx'><acronym title='Como... en punto NET'>C&oacute;mo...</acronym></a> -" +
"       <a href='"+gsPath+"colabora/colabora.htm'><acronym title='Las colaboraciones'>Colabora</acronym></a> -" +
"       <a href='"+gsPath+"vb/default.aspx'><acronym title='El indice de Visual Basic 6'>VB6</acronym></a> -" +
"       <a href='"+gsPath+"vb/VB_API.HTM'><acronym title='API de Windows (VB6)'>API</acronym></a> -" +
"       <a href='"+gsPath+"HTMLscripts/HTML_Tip.aspx'><acronym title='Lenguajes Scripts y HTML'>HTML</acronym></a> -" +
"       <a href='"+gsPath+"sistema/Vista/Default.aspx'><acronym title='Articulos y trucos para Windows Vista'>Vista</acronym></a> -" +
"       <a href='"+gsPath+"otrositios/Default.aspx'><acronym title='Otros sitios'>Links</acronym></a>&nbsp;-" +
"       <a href='"+gsPath+"foros_guille.aspx'><acronym title='Los foros del Guille'>Foros</acronym></a>" +
"       &nbsp;</font></b></td>" +
"   </tr>" +
"</table>");
}
// Mostrar alternando lo que había con lo del hosting (07/Mar/06)
var hoyBanArriba = new Date();
var mBanSegundos = hoyBanArriba.getSeconds(); // .getMinutes();
var bannerMSjul = false;

// Para probar el anuncio del sponsor
//mBanSegundos = 1
//mBanSegundos = 56

if( mBanSegundos < 5 ) // 0-4 (5)
{
// Anuncio Libro
document.write(""+
"<div class='colorClaro' align='center' style='padding-top:1.0em; padding-bottom:1.0em'><h2><a href='" + gsPath + "NET/MIVB2005/comprar.asp'>Regalate mi libro de Visual Basic 2005</a></h2>"+
"</div>");
}
else if( mBanSegundos < 15 ) // 5-14 (10)
{
// Velneo
document.write(""+
"<div class='colorClaro'><center><a target='_blank' href='http://es.velneo.com/'>"+
"<img style='border:0px;width:562;height:76' alt='Velneo' src='" + gsPath +"sponsors/velneo562x76.jpg'></a></center></div>"+
"");
}
else if( mBanSegundos < 21 ) // 15-20 (7)
{
// Oferta hosting a 4.95
document.write(""+
"<div class='colorClaro' style='padding-top:1.0em; padding-bottom:1.0em'><center><h2><span style='color:#FF0000'>OFERTA</span> <a href='"+gsPath+"hostings/elguille_ofertas_hosting.asp'>alojamiento</a> .NET 2.0, SQL Server 4.95 Eur "+
"		al mes<br>"+
"		<font color='#008000'>Ahora con el doble de casi todo !!!</font></h2></center>"+
"</div>");
}
else if( mBanSegundos < 25 ) // 21-24 (4)
{
// Oferta hosting a 2.95
document.write(""+
"<div class='colorClaro' align='center' style='padding-top:1.0em; padding-bottom:1.0em'><h2>La <font color='#FF0000'>OFERTA</font> de <a href='"+gsPath+"hostings/elguille_ofertas_hosting.asp'>alojamiento</a> m&aacute;s econ&oacute;mica: 2.95 Eur<br>"+
"		<font color='#008000'>Ahora con el doble de casi todo !!!</font></h2>"+
"</div>");
}
else if( mBanSegundos < 30 ) // 25-29 (5)
{
// Oferta .eu a 9.95
document.write(""+
"<div class='colorClaro' align='center' style='padding-top:1.0em; padding-bottom:1.0em'><h3>"+
"elGuille.Hosting y <a href='http://www.domitienda.com' target='_blank'>Domitienda.com</a> te traen una oferta irresistible:<br>"+
"Registro de dominios de extensi&oacute;n .eu para todos, precio irrestible,<br>"+
"contrata tu dominio de extensi&oacute;n .eu a precio de .COM: 9.95 euros<br>"+
"</h3>(Oferta v&aacute;lida hasta el 31 de Octubre de 2007)"+
"</div>");
}
else if( mBanSegundos < 35 ) // 30-34 (5)
{
// dotNetMania
document.write(""+
"<div class='colorClaro' align='center' style='padding-top:1.0em; padding-bottom:1.0em'>"+
"	<h2><span style='color:firebrick'>dotNetMania + el sitio del Guille:</span><br>"+
"	<span style='color:#2B90FF'>La mejor informacion de punto NET!</span><br>"+
"	<a href='"+gsPath+"NET/revistas/dotNetmania/suscripcion_dnm.aspx'>Suscribete ya!</a> y "+
"	consigue un 10% de descuento</h2>"+
"</div>");
}
else if( mBanSegundos < 45 ) // 35-44 (10) 01/Oct/07
{
// Oferta hosting Multidominio
document.write(""+
"<div class='colorClaro' align='center' style='padding-top:1.0em; padding-bottom:1.0em'><h2>elGuille.hosting: "+
"   Oferta de <a href='"+gsPath+"hostings/elguille_ofertas_hosting.asp'>alojamiento multi dominio</a></h2>"+
"	<h3>Por solo 40.95 Euros al mes...</h3>"+
"</div>");
}
else if( mBanSegundos < 48 ) // 45-47 (3)
{
// Foros
document.write("" +
"<div class='colorClaro' align='center' style='padding-top:1.0em; padding-bottom:1.0em'>"+
"<h3>Resuelve tus dudas: <a href='http://foros.elguille.info/' target='_blank'>Entra en los foros del Guille</a></h3>"+
"</div>");
}
else if( mBanSegundos < 52 ) // 48-51 (4)
{
// Oferta hosting a 9.95
document.write(""+
"<div class='colorClaro' align='center' style='padding-top:1.0em; padding-bottom:1.0em'><h2>La oferta de <a href='"+gsPath+"hostings/elguille_ofertas_hosting.asp'>alojamiento</a> "+
"		recomendada por el Guille:<br>"+
"		<font color='#008000'>.NET 2.0, SQL Server y mucho mas por 9.95 Euros al mes</font></h2>"+
"</div>");
}
else if( mBanSegundos < 57 ) // 52-56 (5)
{
// Oferta hosting Multidominio
document.write(""+
"<div class='colorClaro' align='center' style='padding-top:1.0em; padding-bottom:1.0em'><h2>elGuille.hosting: "+
"   Oferta de <a href='"+gsPath+"hostings/elguille_ofertas_hosting.asp'>alojamiento multi dominio</a></h2>"+
"	<h3>Por solo 40.95 Euros al mes...</h3>"+
"</div>");
}
else // 57-59 (3)
{
// Oferta hosting genérica
document.write(""+
"<div class='colorClaro' align='center' style='padding-top:1.0em; padding-bottom:1.0em'><h2>Ofertas de <a href='"+gsPath+"hostings/elguille_ofertas_hosting.asp'>alojamiento</a> "+
"		elGuille.hosting:<br>"+
"		<font color='#FF0000'>posiblemente los mejores precios<br>"+
"		</font><font color='#008000'>Ahora con el doble de casi todo !!!</font></h2>"+
"</div>");
}