package com.example.demo.banco.repository;

import java.util.List;

import com.example.demo.banco.repository.modelo.Cuenta;
import com.example.demo.banco.repository.modelo.Transferencia;

public interface CuentaRepository {
	public void insertar(Cuenta cuenta);
	public void actualizar(Cuenta cuenta);
	public void eliminar(String numero);
	public Cuenta seleccionarPorNumero(String numero);
	
	

}
