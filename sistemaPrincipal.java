package Anfiteatro.SistemaReserva;

/*Notas:
 * La matriz se declara como tipo char por lo tanto:
 * Al usarlo en una condicional como if o while, se debe comparar usando "==".
 * Si la matriz se declara tipo String, entonces se utiliza el metodo ".equals(X)"
 * Esto pasa porque String es un objeto y se usa un metodo.*/
import java.util.Scanner;

public class sistemaPrincipal {
	public static void main(String[] args) {
		// Declaracion de variables principales:
		// Mapa inicial donde todos los asientos estan libres
		char[][] mapa = new char[10][10];
		int userOption = 1;

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				mapa[i][j] = 'L';
			}
		}

		while (userOption == 1) {
			System.out.println("BIENVENIDO AL SISTEMA DE RESERVAS DEL ANFITEATRO");
			System.out.println("Seleccione una de las siguientes opciones:");
			System.out.println("*Reservar asiento (1).");
			System.out.println("*Cerrar el sistema (cualquier otro número entre 0 y 9)");
			userOption = userInput();
			if (userOption == 1) {
				reservarAsiento(mapa);
			}
		}
		System.out.println("Finalizando programa...");
		System.out.println("Gracias por tu preferencia, hasta pronto!");
	}

	// funcion que recibe el mapa y lo imprime
	static void imprimirMapa(char mapa[][]) {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				System.out.print("(" + i + "," + j + ")" + mapa[i][j] + " ");
			}
			System.out.println();
		}
	}

	// funcion para reservar asientos
	static char[][] reservarAsiento(char mapa[][]) {
		int userOption = 1;
		while (userOption == 1) {
			System.out.println("Asientos libres con 'L' y ocupados con 'X':");
			imprimirMapa(mapa);
			System.out.println("Por favor, ingrese la fila:");
			int fila = userInput();
			System.out.println("por favor, ingrese la columna:");
			int columna = userInput();
			if (mapa[fila][columna] == 'L') {
				mapa[fila][columna] = 'X';
				System.out.println("Reservando asiento...");
				System.out.println("Asiento reservado!");
			} else {
				System.out.println("Asiento no disponible");

			}
			imprimirMapa(mapa);
			System.out.println("Ingrese una de las siguientes opciones:");
			System.out.println("*Reservar asiento (1).");
			System.out.println("*Regresar al menu principal(cualquier otro número entre 0 y 9)");
			;
			userOption = userInput();
			if (userOption == 9) {
				break;
			}
		}
		System.out.println("Gracias por tu preferencia, vuelve pronto!");
		return mapa;
	}

	// funcion que devuelve el valor ingresado por el usuario
	static int userInput() {
		Scanner inputScanner=new Scanner(System.in);
		int userOption=-1;
		while(userOption<0||userOption>9) {
			System.out.println("Numeros aceptables entre 0 y 9");
			while(!inputScanner.hasNextInt()) {
				System.out.println("Error, solo aceptamos numeros");
				inputScanner.next();
			}
			userOption = inputScanner.nextInt();
		}
		return userOption;
	}
}