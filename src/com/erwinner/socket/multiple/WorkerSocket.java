package com.erwinner.socket.multiple;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class WorkerSocket extends Thread{
	private Socket cliente;

	public WorkerSocket(Socket cliente) {
		this.cliente = cliente;
	}

	@Override
	public void run() {
		try(DataInputStream DataInputStream= new DataInputStream(cliente.getInputStream())) {
			String mensaje = null;
			do {
				mensaje= DataInputStream.readUTF();
				System.out.printf("%s  Dice: %s \n",cliente.getInetAddress().getHostName(),mensaje);
			}while(!"Salir".equals(mensaje));
		} catch (IOException e) {
			e.getMessage();
		}  
	}
	
	

}
