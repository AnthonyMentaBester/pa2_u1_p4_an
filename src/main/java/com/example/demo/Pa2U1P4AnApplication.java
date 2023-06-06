                 package com.example.demo;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.banco.repository.modelo.Cajero;
import com.example.demo.banco.repository.modelo.Presidente;
import com.example.demo.banco.repository.modelo.Transferencia;
import com.example.demo.banco.service.CargaSistemaService;
import com.example.demo.banco.service.TransferenciaService;

@SpringBootApplication
public class Pa2U1P4AnApplication implements CommandLineRunner {

	@Autowired
	private Cajero cajero;
	
	@Autowired
	private Cajero cajero1;
	
	@Autowired
	private Presidente presidente;
	
	@Autowired
	private Presidente presidente1;
	
	@Autowired
	private CargaSistemaService cargaSistemaService;
	
	//debo agregar otra anotacion para que sepa cual usar popner titulo y nombre
	//esto se lo hace en la anotacion la qualifier
	@Autowired
	private TransferenciaService transferenciaService;
	

	public static void main(String[] args) {
		SpringApplication.run(Pa2U1P4AnApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		this.cajero.setApellido("Narvaez");
		this.cajero.setNombre("Anthony");
		this.cajero.setSalario(new BigDecimal(100));
		System.out.println(this.cajero);
		this.cajero1.setApellido("teran");
		//imprime valores null pero no es nulll si existe la inyeccion 
		System.out.println(this.cajero1);
		
		this.presidente.setApellido("Coloma");
		this.presidente.setNombre("Renato");
		this.presidente.setCedula("1789543123");
		
		this.presidente1.setApellido("Taco");
		
		System.out.println(this.presidente);
		
		System.out.println(this.presidente1);
		
		System.out.println("**********SEGUNDA PARTE***********");
		this.cargaSistemaService.cargar();
		Transferencia trans = new Transferencia();
		trans.setCuentaDestino(null);
		trans.setCuentaOrigen(null);
		trans.setFecha(null);
		trans.setMonto(new BigDecimal(100));
		trans.setNumero("123232");
		//por lo general no cambiaran catalogos parametros 
		this.transferenciaService.guardar(trans);
	
		
		
	}

}
