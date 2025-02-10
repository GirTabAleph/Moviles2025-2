public class Operacion{
		
	private Double x1;
	private Double x2;
	private Operando operando;

	public Double getX1(){

		return x1;

	}

	public Double getX2(){

		return x2;

	}

	public Operando getOperando(){

		return operando;

	}

	public void setX1(Double x1){

		this.x1 = x1;
	}

	public void setX2(Double x2){
		
		this.x2 = x2;

	}

	public void setOperando(Operando operando){

		this.operando = operando;

	}
	
	//Constructor vacío.
	public Operacion(){
	}


	//Constructor parametrizado.
	public Operacion(Double x1, Double x2, Operando operando){

		setX1(x1);
		setX2(x2);
		setOperando(operando);

	}


}
