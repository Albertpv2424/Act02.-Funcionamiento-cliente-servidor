package Act2;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Cliente {
	public static void main(String[] args) {
		try {
			Socket socket = new Socket("127.0.0.1", 5000);
			System.out.println("Conectado al servidor.");
			
			PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
			BufferedReader entrada = new BufferedReader(
					new InputStreamReader(socket.getInputStream())
					);
			Scanner teclado = new Scanner(System.in);
			
			String mensaje;
			while (true) {
				System.out.print("Tú: ");
				mensaje = teclado.nextLine();
				salida.println(mensaje);
				System.out.println("Servidor: " + entrada.readLine());
				
				if (mensaje.equalsIgnoreCase("salir")) break;
			}
			
			socket.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}