package logica;

public class Laberinto {
	int dimension;
	int[][] laberinto;
	char estado;
	int[][] recorrido;
	int paso;
	int[] pos;
	
	public void setDimension(int n){
		this.dimension = n;
	}
	
	public void setLaberinto(){
		this.laberinto = new int[this.dimension][this.dimension];
		this.recorrido = new int[this.dimension*this.dimension][2];
		this.paso=0;
		pos = new int[2];
	}
	
	public void inicializarRecorrido(){
		for(int i=0;i<this.recorrido.length;i++){
			for(int j=0;j<this.recorrido[i].length;j++){
				this.recorrido[i][j]=-1;
				
			}
		}
	}
	public void llenarRecorrido(int i, int j){
		this.recorrido[paso][0]=i;
		this.recorrido[paso][1]=j;
	}
	
	public void configurarLaberinto(String cad[]){
		for(int f=0;f<this.dimension;f++){
			for(int c=0;c<this.dimension;c++){
				try{
					this.laberinto[f][c]=Integer.parseInt(String.valueOf(cad[f].charAt(c)));
				}catch(ArrayIndexOutOfBoundsException a){
					this.laberinto[f][c]=0;
				}catch(StringIndexOutOfBoundsException a){
					this.laberinto[f][c]=0;
				}
			}
		}
		this.estado='i';
		inicializarRecorrido();
	}
	
	public void mostrarLaberinto(){
		for(int f=0;f<this.dimension;f++){
			for(int c=0;c<this.dimension;c++){
				System.out.print(this.laberinto[f][c]+"\t");
			}
			System.out.println("");
		}
	}
	
	public void regresar(int i,int j){
		if(paso>0){
			if(verificarNorte(pos[0], pos[1], -1)){
				System.out.println("norte libre("+pos[0]+","+pos[1]+")");
				moverNorte(pos[0], pos[1]);
			}else if(verificarEste(pos[0], pos[1], -1)){
				System.out.println("este libre");
				moverEste(pos[0], pos[1]);
			}else if(verificarSur(pos[0], pos[1], -1)){
				System.out.println("sur libre");
				moverSur(pos[0], pos[1]);
			}else if(verificarOeste(pos[0], pos[1], -1)){
				System.out.println("oeste libre");
				moverOeste(pos[0], pos[1]);
			}
		}
		//return this.recorrido[paso];
	}
	
	public String encontrarSalida(){
		String cad = new String("");
		
		pos[0]=0;
		pos[1]=0;
		
		llenarRecorrido(pos[0], pos[1]);
		while(!(posicionFinal(pos[0], pos[1]))){
			//System.out.println("("+pos[0]+", "+pos[1]+")");
			if(verificarNorte(pos[0], pos[1], 0)){
				moverNorte(pos[0], pos[1]);
			}else if(verificarEste(pos[0], pos[1], 0)){
				moverEste(pos[0], pos[1]);
			}else if(verificarSur(pos[0], pos[1], 0)){
				moverSur(pos[0], pos[1]);
			}else if(verificarOeste(pos[0], pos[1], 0)){
				moverOeste(pos[0], pos[1]);
			}else{ 
				regresar(pos[0], pos[1]);
			}
		}
		if(this.estado!='u'){
			this.estado='s';
		}
		return cad;
	}
	
	public char getEstado(){
		return this.estado;
	}
	
	public boolean posicionFinal(int i,int j){
		boolean val=false;
		if(i==this.dimension-1 && j==this.dimension-1){
			val=true;
		}
		return val;
	}
	public void moverSur(int i,int j){
		this.laberinto[i][j]--;
		this.pos[0]++;
		this.recorrido[paso][0]=this.pos[0];
		this.recorrido[paso][1]=this.pos[1];
		paso++;	
	}
	public void moverNorte(int i,int j){
		this.laberinto[i][j]--;
		this.pos[0]--;
		this.recorrido[paso][0]=this.pos[0];
		this.recorrido[paso][1]=this.pos[1];
		paso++;
	}
	public void moverEste(int i,int j){
		this.laberinto[i][j]--;
		this.pos[1]++;
		this.recorrido[paso][0]=this.pos[0];
		this.recorrido[paso][1]=this.pos[1];
		paso++;
	}
	public void moverOeste(int i,int j){
		this.laberinto[i][j]--;
		this.pos[1]--;
		this.recorrido[paso][0]=this.pos[0];
		this.recorrido[paso][1]=this.pos[1];
		paso++;
	}
	public boolean verificarSur(int i,int j, int v){
		boolean val=false;
		try{
			if(this.laberinto[i+1][j]==v){
				val=true;
			}
		}catch(ArrayIndexOutOfBoundsException e){
			
		}
		return val;
	}
	public boolean verificarNorte(int i,int j, int v){
		boolean val=false;
		try{
			if(this.laberinto[i-1][j]==v){
				val=true;
			}
		}catch(ArrayIndexOutOfBoundsException e){
			
		}
		return val;
	}
	public boolean verificarEste(int i,int j, int v){
		boolean val=false;
		try{
			if(this.laberinto[i][j+1]==v){
				val=true;
			}
		}catch(ArrayIndexOutOfBoundsException e){
			
		}
		return val;
	}
	public boolean verificarOeste(int i,int j, int v){
		boolean val=false;
		try{
			if(this.laberinto[i][j-1]==v){
				val=true;
			}
		}catch(ArrayIndexOutOfBoundsException e){
			
		}
		return val;
	}

}
