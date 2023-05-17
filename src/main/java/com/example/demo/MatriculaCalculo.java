package com.example.demo;

public class MatriculaCalculo {
	
	public void realizarMatricula(String tipo) {
		if (tipo.equals("1")) {
			Materia mat = new Materia(); 
			mat.setNombre("P.WEB");
			//insertar en la base
			System.out.println("Se inserto materia");
		}
		else {
			MateriaExtraordinaria matX = new MateriaExtraordinaria();
			matX.setNombre("P.web");
			matX.setCantidadCreditos(10);
			System.out.println("Se inserto materia extraordinaria");
			//insertar en la base
		}
	}

}
