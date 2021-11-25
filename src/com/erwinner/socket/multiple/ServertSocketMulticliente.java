package com.erwinner.socket.multiple;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServertSocketMulticliente {
	public static void main(String[] args) throws IOException {
		try(ServerSocket serverSocket = new ServerSocket(8090)) {
			while(true) {
				System.out.println("Escuchando cliente..");
				Socket cliente = serverSocket.accept();
				System.out.println("Cliente conectado: "+cliente.getInetAddress().getHostName());
				new WorkerSocket(cliente).start();
			}
		}
	}
}
