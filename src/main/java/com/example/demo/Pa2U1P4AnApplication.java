package com.example.demo;

import java.time.LocalDateTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Pa2U1P4AnApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Pa2U1P4AnApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("mi primer proyecto");
		/*Spring framework: Es un Framework que permite la construccion / desarollo 
		 * de aplicaciones empresariales basadas en Srping
		 */
		
		Profesor profe = new Profesor();
		profe.setApellido("Narvaez");
		profe.setCedula("1719954370");
		profe.setFechaNacimiento(LocalDateTime.now());
		profe.setNombre("Anthony");
		System.out.println(profe);
		
	}

}
