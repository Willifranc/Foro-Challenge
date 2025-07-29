package com.foro;

import org.flywaydb.core.Flyway;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ForoHubApplication {

	public static void main(String[] args) {
// ✅ Reparar historial de Flyway (solo una vez)
//		Flyway.configure()
//				.dataSource("jdbc:mysql://localhost/forohub", "root", "Programador_2025")
//				.load()
//				.repair(); // Repara errores anteriores de migraciones fallidas


		SpringApplication.run(ForoHubApplication.class, args);
	}

}
