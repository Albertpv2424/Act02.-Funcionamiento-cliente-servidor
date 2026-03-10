package Act2;

import java.io.*;
import java.net.*;

public class ServidorMultiCliente {
	public static void main(String[] args) {
		try {
			// Crea el servidor en el puerto 5000
			ServerSocket servidor = new ServerSocket(5000);
			System.out.println("Servidor multicliente esperando conexiones...");
			
			// Bucle infinito: el servidor nunca para, siempre acepta nuevos clientes
			while (true) {
				//Espera a que un cliente se conecte
				Socket socket = servidor.accept();
				System.out.println("Nuevo cliente conectado: " + socket.getInetAddress());
				
				// Crea un hilo nuevo para atender a este cliente de forma independiente asi se pueden aceptar mas clientes a la vez
				Thread hilo = new Thread(new ManejadorCliente(socket));
				hilo.start();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}