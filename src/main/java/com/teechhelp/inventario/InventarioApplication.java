package com.teechhelp.inventario; // Asegúrate de que este paquete sea correcto

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // Esta anotación habilita la configuración automática de Spring Boot
public class InventarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventarioApplication.class, args); // Inicia la aplicación
	}
}
