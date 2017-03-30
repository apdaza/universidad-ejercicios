package logica;

public class Matematicas {
	double operandoUno;
	double operandoDos;
	double resultado;
	
	public Matematicas(){
		this.operandoUno=0;
		this.operandoDos=0;
		this.resultado=0;
	}
	
	public double getOperandoDos() {
		return operandoDos;
	}
	
	public void setOperandoDos(double operandoDos) {
		this.operandoDos = operandoDos;
	}
	
	public double getOperandoUno() {
		return operandoUno;
	}
	
	public void setOperandoUno(double operandoUno) {
		this.operandoUno = operandoUno;
	}
	
	public double getResultado() {
		return resultado;
	}
	
	public void suma(){
		this.resultado = this.operandoUno+this.operandoDos;
	}
	
	public void resta(){
		this.resultado = this.operandoUno-this.operandoDos;
	}
	
	public void producto(){
		this.resultado = this.operandoUno*this.operandoDos;
	}
	
	public void division(){
		this.resultado = this.operandoUno/this.operandoDos;
	}
	
	public void potencia(){
		this.resultado = 1;
		for(int i=0;i<(int)(this.operandoDos);i++){
			this.resultado*=this.operandoUno;
		}
	}
	public void factorial(){
		this.resultado = 1;
		for(int i=1;i<=(int)(this.operandoUno);i++){
			this.resultado*=i;
		}
	}
	

}
