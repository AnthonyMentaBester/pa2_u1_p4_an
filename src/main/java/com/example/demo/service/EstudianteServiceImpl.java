package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.EstudianteRepository;
import com.example.demo.repository.modelo.Estudiante;

//poner siempre aqui en la clases Impl
@Service
public class EstudianteServiceImpl implements EstudianteService {
	
	//pregun tar porque hay menos acoplamiento ?
	@Autowired
	private EstudianteRepository estudianteRepository;
	

	@Override
	public void guardar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.estudianteRepository.insertar(estudiante);
		
	}

	@Override
	public void actualizar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.estudianteRepository.actualizar(estudiante);
		
	}

	@Override
	public Estudiante buscarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		
		return this.estudianteRepository.seleccionar(cedula);
	}

	@Override
	public void borrar(String cedula) {
		// TODO Auto-generated method stub
		this.estudianteRepository.eliminar(cedula);
		
	}

	@Override
	public List<Estudiante> reporteTodos() {
		// TODO Auto-generated method stub
		return this.estudianteRepository.seleccionarTodos();
	}
}
