import java.io.IOException;
import java.util.Scanner;

public class CodigoCesar {

	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		codigoCesar();
	}

	public static void codigoCesar() {

		// VARIABLES
		String texto;
		int codigo, opcion;

		do {
			System.out.print("Introduce un texto: ");
			texto = teclado.nextLine();
		} while (texto.isEmpty());

		do {
			System.out.print("Introduce el código: ");
			codigo = Integer.parseInt(teclado.nextLine());

		} while (codigo < 1);

		do {

			System.out.print("(1) cifrar o (2) descifrar?: ");
			opcion = Integer.parseInt(teclado.nextLine());
		} while (opcion < 1 || opcion > 2);

		if (opcion == 1) {
			System.out.println("Texto cifrado: " + cifradoCesar(texto, codigo));

		} else {
			System.out.println("Texto descifrado: " + descifradoCesar(texto, codigo));
		}
	}

	public static String cifradoCesar(String texto, int codigo) {
		
		StringBuilder cifrado = new StringBuilder();
		codigo = codigo % 26; //letra abecedario
		
		for (int i = 0; i < texto.length(); i++) { //recorremos
			
			if (texto.charAt(i) >= 'a' && texto.charAt(i) <= 'z') { //comprobamos que este de a a z
				
				if ((texto.charAt(i) + codigo) > 'z') { //si sobrepasa la letra
					cifrado.append((char) (texto.charAt(i) + codigo - 26)); //se quita 26 codigo para que se ajuste
				} else {
					cifrado.append((char) (texto.charAt(i) + codigo)); //se añade sin mas
				}
			} else if (texto.charAt(i) >= 'A' && texto.charAt(i) <= 'Z') { //matusculas
				
				if ((texto.charAt(i) + codigo) > 'Z') {
					cifrado.append((char) (texto.charAt(i) + codigo - 26));
				} else {
					cifrado.append((char) (texto.charAt(i) + codigo));
				}
			}
		}
		return cifrado.toString();
	}

	public static String descifradoCesar(String texto, int codigo) {
		
		StringBuilder cifrado = new StringBuilder();
		codigo = codigo % 26; //letra abecedario
		
		
		for (int i = 0; i < texto.length(); i++) {
			if (texto.charAt(i) >= 'a' && texto.charAt(i) <= 'z') {
				
				if ((texto.charAt(i) - codigo) < 'a') { //si es mas pequeño que la primera letra
					
					cifrado.append((char) (texto.charAt(i) - codigo + 26)); //al descifrar se suma 26 y se resta el codigo
				
				} else {
					
					cifrado.append((char) (texto.charAt(i) - codigo)); //se resta el codigo
				}
			} else if (texto.charAt(i) >= 'A' && texto.charAt(i) <= 'Z') { //mayusculas
				
				if ((texto.charAt(i) - codigo) < 'A') {
					cifrado.append((char) (texto.charAt(i) - codigo + 26)); 
				} else {
					cifrado.append((char) (texto.charAt(i) - codigo));
				}
			}
		}
		return cifrado.toString();
	}
}
