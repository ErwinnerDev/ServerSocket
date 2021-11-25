package com.erwinner.socket.multiple;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClienteSocket {
	/*
	 * Se puede jecutar N clientes y cada uno puede enviar mensajes y se resiviran por el Servert
	 * */
	public static String readMessage() throws IOException {
		System.out.print("\n ->");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		return reader.readLine();
	}

	public static void main(String[] args) throws UnknownHostException, IOException {
		 
		try(Socket socket  = new Socket("localhost",8090)) {
			DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
			String mensaje;
			do {
				mensaje=readMessage();
				dataOutputStream.writeUTF(mensaje);
			}while(!"Salir".equals(mensaje));
		}
	}

}
