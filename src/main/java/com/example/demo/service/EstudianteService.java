package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.Estudiante;

public interface EstudianteService {
	
	public void guardar(Estudiante estudiante);

	public void actualizar(Estudiante estudiante);

	// se busca apartir de un identificador o primary key
	public Estudiante buscarPorCedula(String cedula);

	// tambien se elimina por un identificador
	public void borrar(String cedula);
	//imprimir toda la lista 
	public List<Estudiante> reporteTodos();

}
