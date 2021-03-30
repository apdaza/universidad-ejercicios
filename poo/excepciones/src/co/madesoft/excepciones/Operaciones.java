package co.madesoft.excepciones;

public class Operaciones {
	private int valorUno;
    private int valorDos;
    
    public void setValorUno(int v){
        valorUno = v;
    }
    
    public void setValorDos(int v){
        valorDos = v;
    }
    
    public int dividir(){
        int d=0;
        try{
            d=valorUno/valorDos;
        }catch(ArithmeticException e){
            System.out.println("excepción aritmetica capturada: "+e.toString());
        }
        return d;
    }
}
