import java.util.Scanner;

public class Main{

		public static void main(String args[]){
			
			//Preparar Scanner.
			Scanner in = new Scanner(System.in);

			System.out.println("Ingrese el primer valor: ");
			Double x1 = in.nextDouble();

			System.out.println("Ingrese el segundo valor: ");
			Double x2 = in.nextDouble();
			
			//Consumir la siguiente línea.
			in.nextLine();

			Operando operando = null;
			System.out.println("Ingrese la operación: MULT, DIV, SUMA, REST");
			String operandoStr = in.nextLine().toUpperCase();
			
			try{

				operando = Operando.valueOf(operandoStr);
			
			} catch(Exception e){
			
				System.out.println("Algo salió mal.");
			
			}
			
			//Arreglar esto para que pueda acceder al enumerado.
			Operacion op = new Operacion(x1, x2, operando);
			ICalculadora calc = new CalculadoraImpl();
			Double resultado = calc.calcular(op);
			System.out.println("Resultado: " + resultado);

		}

}
