

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class copiarArchivoTexto {

	public static Scanner teclado = new Scanner(System.in);
	public static void main(String[] args) {
		

		copiarArchivo();
		
	}

	public static void copiarArchivo() {
		
		File enlace, enlaceCopia;
		
		String archivoOriginal= "original.txt", contenido, ficheroCopia, lineaLeida;
		int lineas, contador;
		
		
		enlace = new File(archivoOriginal);
		 
		
		try (FileWriter escritura = new FileWriter(enlace);
				BufferedWriter flujo = new BufferedWriter(escritura);) {
			
			System.out.println("num linea a escribir: ");
			lineas = Integer.parseInt(teclado.nextLine());
			
			for (contador =1; contador <= lineas; contador++) {
				
				System.out.println("linea " + contador + "/" + lineas);
				
				System.out.println("que deseas escribir en fichero original: ");
				contenido = teclado.nextLine();
				
				flujo.write(contenido);
				flujo.newLine();
				
			}
			
			
		} catch (IOException e) {

			System.out.println("error" + e.getMessage());
			
		}
		
		System.out.println("nombre del fichero donde vamos a copiar las lineas escritas anteriormente: ");
		ficheroCopia = teclado.nextLine();
		
		enlaceCopia = new File(ficheroCopia + ".txt");
		
		try(FileReader lector = new FileReader(enlace);
				BufferedReader flujoLector = new BufferedReader(lector);
				FileWriter escritura = new FileWriter(enlaceCopia);
				BufferedWriter flujo = new BufferedWriter(escritura);) {
			
			lineaLeida = flujoLector.readLine();
			
			while (lineaLeida != null) {
			
				flujo.write(lineaLeida);
				flujo.newLine();
				
				lineaLeida = flujoLector.readLine();

			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
