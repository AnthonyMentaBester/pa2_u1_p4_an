package com.example.demo.banco.repository;

import java.util.List;

import com.example.demo.banco.repository.modelo.Cuenta;
import com.example.demo.banco.repository.modelo.Transferencia;

public interface TransferenciaRepository {

	//tener cuidado con el objeto al copiar y pegar
	public void insertar(Transferencia transferencia);
	public void actualizar(Transferencia transferencia);
	public void eliminar(String numero);
	public Transferencia seleccionarPorNumero(String numero);
	public List<Transferencia> imprimirTodos();
	

}
