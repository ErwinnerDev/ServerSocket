package com.erwinner.socket.simple;


import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClienteSocket {
	public static void main(String[] args) throws UnknownHostException, IOException {
		DataOutputStream datOutStream= null;
		try(Socket socket = new Socket("localhost",8090)){
			datOutStream=new DataOutputStream(socket.getOutputStream());
			datOutStream.writeUTF("Soy un cliente");
			datOutStream.writeUTF("Salir");
		}catch(Exception e){
			e.printStackTrace();
			e.getMessage();
		}
	}

}
