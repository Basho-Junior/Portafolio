package com.example.practica2client;

import com.example.practica2client.objetos.Cliente;
import com.example.practica2client.objetos.Info;
import lombok.SneakyThrows;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.jms.JMSException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class Practica2clientApplication {

	private static List<Cliente> misClientes;
	private static long counter = 0;
	public static void main(String[] args) throws JMSException, IOException {
		misClientes = new ArrayList<>();
		SpringApplication.run(Practica2clientApplication.class, args);

		Runnable sendData = new Runnable() {
			public void run() {
				enviarMensajes();
			}
		};
		// Crear task para enviar datos desde los clientes cada 3s
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
		executor.scheduleAtFixedRate(sendData, 0, 3, TimeUnit.SECONDS);
	}

	/**

	 */
	private static void enviarMensajes() {
		int temperatura, humedad;
		int totalClientes = misClientes.size();
		if (misClientes.size()==0) {
			System.out.println("No hay clientes registrados");
		} else {
			System.out.println("Enviando datos desde clientes a servidor: ");
		}
		for (Cliente cliente:
				misClientes) {
			temperatura = ThreadLocalRandom.current().nextInt(0, 50);  // de 0 a 50 celsius
			humedad = ThreadLocalRandom.current().nextInt(0, 101); // de 0 a 100 %
			System.out.println("Cliente " + cliente.getIdCliente() + ": temperatura="
					+ temperatura + "; humedad=" + humedad + ".");
			Info informacion = new Info((int)cliente.getIdCliente(), temperatura, humedad, totalClientes);
			try {
				cliente.enviarObjeto(informacion);
			} catch (JMSException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// Obtener lista de clientes.
	public static List<Cliente> getMisClientes() {
		return misClientes;
	}
	public static long getCounter() {
		return counter;
	}
	public static void setCounter(long counter) {
		Practica2clientApplication.counter = counter;
	}
}
