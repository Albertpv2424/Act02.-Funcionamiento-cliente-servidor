package Act2;

import java.io.*;
import java.net.*;

public class ManejadorCliente implements Runnable {
	private Socket socket;
	
	// Recibe el socket del cliente al que tiene que atender
	public ManejadorCliente(Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		try {
			// Prepara la entrada para leer mensajes del cliente
			BufferedReader entrada = new BufferedReader(
					new InputStreamReader(socket.getInputStream())
					);
			
			// Prepara la salida para enviar respuestas al cliente
			PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
			
			String mensaje;
			// Sigue leyendo mensajes hasta que el cliente se desconecte
			while ((mensaje = entrada.readLine()) != null) {
				System.out.println("[" + socket.getInetAddress() + "] dice: " + mensaje);
				//Envia la respuesta de vuelta al cliente
				salida.println("Servidor responde a: " + mensaje);
			}
			
			System.out.println("Cliente desconectado: " + socket.getInetAddress());
			socket.close();
			
		} catch (IOException e) {
			System.out.println("Error con cliente: " + e.getMessage());
		}
	}
}