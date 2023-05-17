package com.example.demo;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Pa2U1P4AnApplication implements CommandLineRunner {

	//declare la anotacion paso 2
	@Autowired
	private Profesor profe2;
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U1P4AnApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("mi primer proyecto");
		
		//le vamos a delegar la craecion al contenedor 
		
		
		/*Spring framework: Es un Framework que permite la construccion / desarollo 
		 * de aplicaciones empresariales basadas en Srping
		 */
		
		Profesor profe = new Profesor();
		profe.setApellido("Narvaez");
		profe.setCedula("1719954370");
		profe.setFechaNacimiento(LocalDateTime.now());
		profe.setNombre("Anthony");
		System.out.println(profe);
		System.out.println(profe.getApellido());
		
		//si sale null instanciar variable arriba paso 3
		profe2 = new Profesor();
		
		System.out.println(profe2);
		profe2.setApellido("Teran");
	
		System.out.println(profe2.getApellido());
		
		Profesor profe3;
		profe3 = profe;
		System.out.println(profe3);
		profe.setApellido("anangono");
		System.out.println(profe3);
		System.out.println(profe);
		
		MatriculaCalculo mat = new  MatriculaCalculo();
		mat.realizarMatricula("1");
		
		
		
		
	}

}
