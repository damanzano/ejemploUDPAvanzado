package nodo1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Comunication extends Thread {
	private DatagramSocket buzon;
	private int recibidoX;
	private int recibidoY;

	public Comunication() {
		try {
			buzon = new DatagramSocket(6000);
		} catch (SocketException e) {
			e.printStackTrace();
			// System.out.println("error" + e);
		}

		this.recibidoX = 0;
		this.recibidoY = 0;
		start();
	}

	public int getRecibidoX() {
		return recibidoX;
	}

	public int getRecibidoY() {
		return recibidoY;
	}

	public void enviar(int posX, int posY) {
		byte[] mensaje= ("pos:"+posX+":"+posY).getBytes();
		
		// Comienza el envio
		InetAddress ip;
		try {
			ip = InetAddress.getByName("localhost");
			DatagramPacket paquete = new DatagramPacket(mensaje, mensaje.length, ip,
					5000);
			buzon.send(paquete);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void recibir() {
		byte[] buf = new byte[50];
		DatagramPacket paquete = new DatagramPacket(buf, buf.length);
		try {
			buzon.receive(paquete);
			String recibido = new String(paquete.getData(), 0,
					paquete.getLength());
			
			if (recibido.contains("pos")) {
				String[] partes = recibido.split(":");
				
				recibidoX = Integer.parseInt(partes[1]);
				recibidoY = Integer.parseInt(partes[2]);
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void run() {
		while (true) {
			recibir();
			try {
				sleep(3);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
