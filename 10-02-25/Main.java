public class Main{

		public static void main(String args[]){

			Operacion op = new Operacion(10.0, 10.0, Operando.SUMA);
			ICalculadora calc = new CalculadoraImpl();
			Double resultado = calc.calcular(op);

		}

}
