package com.example.demo;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.service.EstudianteService;

@SpringBootApplication
public class Pa2U1P4AnApplication implements CommandLineRunner {

	@Autowired
	private EstudianteService estudianteService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U1P4AnApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Estudiante miEstudiante = new Estudiante();
		miEstudiante.setApellido("Narvaez");
		miEstudiante.setCedula("1719954370");
		miEstudiante.setNombre("Anthony");
		miEstudiante.setFechaNacimiento(LocalDateTime.of(1999, 8, 11, 10, 50));

		Estudiante miEstudiante1 = new Estudiante();
		miEstudiante1.setApellido("Coloma");
		miEstudiante1.setCedula("1751457167");
		miEstudiante1.setNombre("Dilan");
		miEstudiante1.setFechaNacimiento(LocalDateTime.of(1998, 8, 3, 10, 50));

		// 1.- GUARDAR
		this.estudianteService.guardar(miEstudiante);
		this.estudianteService.guardar(miEstudiante1);

		// IMPRIMIR REPORTE
		List<Estudiante> reporte = this.estudianteService.reporteTodos();
		System.out.println("Reporte de todos los estudiantes");
		for (Estudiante estu : reporte) {
			System.out.println(estu);
		}

		// 2.- ACTUALIZAR
		miEstudiante1.setApellido("Pozo");
		this.estudianteService.actualizar(miEstudiante1);;

		// IMPRIMIR REPORTE PARA VER SI SE ACTUALIZO
		List<Estudiante> reporte1 = this.estudianteService.reporteTodos();
		System.out.println("Reporte de todos los estudiantes mas el actualizado");
		for (Estudiante estu: reporte1) {
			System.out.println(estu);
		}
		// 3.- ELIMINAR REPORTE
		this.estudianteService.borrar("1719954370");

		// IMPRIMIR REPORTE PARA VER SI SE BORRO
		List<Estudiante> reporte2 = this.estudianteService.reporteTodos();
		System.out.println("Reporte de todos los estudiantes mas el borrado");
		for (Estudiante estu: reporte2) {
			System.out.println(estu);
		}
		
		//BUSCAR EL ESTUDIANTE POR CEDULA
		Estudiante estu1 = this.estudianteService.buscarPorCedula("1719954370");
		System.out.println("El estudiante con cedula: " + estu1);
		Estudiante estu2 = this.estudianteService.buscarPorCedula("1719954371");
		System.out.println("El estudiante con cedula inexistente: " + estu2);
		

		
		
		

	}

}
