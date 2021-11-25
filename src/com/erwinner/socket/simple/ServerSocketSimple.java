package com.erwinner.socket.simple;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketSimple {
	public static void main(String[] args) {
		try (ServerSocket socket = new ServerSocket(8090)){
			
			System.out.println("Escuchando peticones...");
			Socket cliente = socket.accept();
			System.out.printf("cliente conectado %s  conectado \n",cliente.getInetAddress().getHostName());
			DataInputStream displayStream= new DataInputStream(cliente.getInputStream());
			String mensaje = null;
			do{
				mensaje=displayStream.readUTF();
				System.out.printf("el cliente %s dice: %s \n",cliente.getInetAddress().getHostName(),mensaje);
			}while(!mensaje.equals("Salir"));
			
			System.out.println("Conexión cerrada");
			cliente.close();
			displayStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}
