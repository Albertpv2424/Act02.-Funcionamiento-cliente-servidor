package Act2;

import java.io.*;
import java.net.*;

public class ServidorMultiCliente {
	public static void main(String[] args) {
		try {
			ServerSocket servidor = new ServerSocket(5000);
			System.out.println("Servidor multicliente esperando conexiones...");
			
			while (true) {
				Socket socket = servidor.accept();
				System.out.println("Nuevo cliente conectado: " + socket.getInetAddress());
				
				Thread hilo = new Thread(new ManejadorCliente(socket));
				hilo.start();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}