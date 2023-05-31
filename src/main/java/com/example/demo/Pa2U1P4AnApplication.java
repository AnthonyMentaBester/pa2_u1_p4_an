                 package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.banco.repository.modelo.Cuenta;
import com.example.demo.banco.repository.modelo.Transferencia;
import com.example.demo.banco.service.CuentaService;
import com.example.demo.banco.service.TransferenciaService;
import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.service.EstudianteService;

@SpringBootApplication
public class Pa2U1P4AnApplication implements CommandLineRunner {

	@Autowired
	private CuentaService cuentaService;
	
	//debo agregar otra anotacion para que sepa cual usar popner titulo y nombre
	//esto se lo hace en la anotacion la qualifier
	@Autowired
	private TransferenciaService transferenciaService;
	

	public static void main(String[] args) {
		SpringApplication.run(Pa2U1P4AnApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//cta1
		Cuenta cta1 = new Cuenta();
		cta1.setCedulaPropietario("1719954370");
		cta1.setFechaApertura(LocalDate.now());
		cta1.setNumero("1263");
		cta1.setSaldo(new BigDecimal(200));
		cta1.setTipo("A");
		this.cuentaService.ingresar(cta1);
		
		//cta2
		Cuenta cta2 = new Cuenta();
		cta2.setCedulaPropietario("1719954371");
		cta2.setFechaApertura(LocalDate.now());
		cta2.setNumero("4263");
		cta2.setSaldo(new BigDecimal(100));
		cta2.setTipo("C");
		this.cuentaService.ingresar(cta2);
		
		

		
		this.transferenciaService.realizar("1263", "4263", new BigDecimal(10));
		
		
		System.out.println("Saldo Origen:" + this.cuentaService.buscarPorNumero("1263").getSaldo());
		System.out.println("Saldo Destino:" + this.cuentaService.buscarPorNumero("4263").getSaldo());
		
		
		
		/*//reporte todos
		List<Transferencia> reporte = this.transferenciaService.reporteTodos();
		System.out.println("Reporte de todas las transaccioness");
		for (Transferencia trans : reporte) {
			System.out.println(trans);
		}*/
		
		
		
		

	}

}
