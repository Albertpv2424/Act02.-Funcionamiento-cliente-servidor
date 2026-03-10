package Act2;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Cliente {
	public static void main(String[] args) {
		try {
			// Se conecta al servidor mediante IP y puerto
			Socket socket = new Socket("127.0.0.1", 5000);
			System.out.println("Conectado al servidor.");
			
			// Prepara la salida para enviar mensajes al servidor
			PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
			
			// Prepara la entrada para recibir respuestas del servidor
			BufferedReader entrada = new BufferedReader(
					new InputStreamReader(socket.getInputStream())
					);
			Scanner teclado = new Scanner(System.in);
			
			String mensaje;
			//Cliente puede enviar mensajes continuamente
			while (true) {
				System.out.print("Tú: ");
				mensaje = teclado.nextLine();
				salida.println(mensaje); //Envi mensaje al servidor
				// Espera y muestra la respuesta del servidor
				System.out.println("Servidor: " + entrada.readLine());
				//Si el usuario escribe salir se desconecta
				if (mensaje.equalsIgnoreCase("salir")) break;
			}
			
			socket.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}