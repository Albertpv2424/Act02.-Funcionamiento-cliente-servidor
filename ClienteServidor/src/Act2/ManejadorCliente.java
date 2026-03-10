package Act2;

import java.io.*;
import java.net.*;

public class ManejadorCliente implements Runnable {
	private Socket socket;
	
	public ManejadorCliente(Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		try {
			BufferedReader entrada = new BufferedReader(
					new InputStreamReader(socket.getInputStream())
					);
			PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
			
			String mensaje;
			while ((mensaje = entrada.readLine()) != null) {
				System.out.println("[" + socket.getInetAddress() + "] dice: " + mensaje);
				salida.println("Servidor responde a: " + mensaje);
			}
			
			System.out.println("Cliente desconectado: " + socket.getInetAddress());
			socket.close();
			
		} catch (IOException e) {
			System.out.println("Error con cliente: " + e.getMessage());
		}
	}
}