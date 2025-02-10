import java.io.*;

public class CalculadoraImpl implements ICalculadora{

	@Override
	public Double calcular(Operacion op){
		
		switch (op.getOperando() ){

			case SUMA:
				return op.getX1() + op.getX2();

			case RESTA:
				return op.getX1() - op.getX2();

			case DIV:
				return op.getX1() / op.getX2();

			case MULT:
				return op.getX1() * op.getX2();

			default:
				return 0.0;

	
		}

	}

}

