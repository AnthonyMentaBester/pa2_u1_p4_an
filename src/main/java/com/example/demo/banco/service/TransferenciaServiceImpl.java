package com.example.demo.banco.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.banco.repository.CuentaRepository;
import com.example.demo.banco.repository.TransferenciaRepository;
import com.example.demo.banco.repository.modelo.Cuenta;
import com.example.demo.banco.repository.modelo.Impuesto;
import com.example.demo.banco.repository.modelo.Transferencia;

@Service
public class TransferenciaServiceImpl implements TransferenciaService{

	@Autowired
	private TransferenciaRepository transferenciaRepository;
	
	@Autowired
	private CuentaRepository cuentaRepository;
	
	@Autowired
	private Impuesto impuesto;
	
	@Autowired
	@Qualifier("nacional")
	private MontoDebitarService debitarService;
	
	@Override
	public void guardar(Transferencia transferencia) {
		// TODO Auto-generated method stub
		System.out.println("la transferencia se va a calcular con el IVA");
		System.out.println(impuesto.getIva());
		this.transferenciaRepository.insertar(transferencia);
		
	}

	@Override
	public void actualizar(Transferencia transferencia) {
	
		this.transferenciaRepository.actualizar(transferencia);
		
	}

	@Override
	public void borrar(String numero) {
		
		this.transferenciaRepository.eliminar(numero);
		
	}

	@Override
	public Transferencia buscarPorNumero(String numero) {

		return this.transferenciaRepository.seleccionarPorNumero(numero);
	}

	@Override
	public void realizar(String numeroCtaOrigen, String numeroCtaDestino, BigDecimal monto) {
		//1.- Consultar la cuenta de origen por el numero
		// solo cuando hacemos calculos accedemos al service si solo es consultar accedemos al repository
		//BYPASS
		Cuenta ctaOrigen = this.cuentaRepository.seleccionarPorNumero(numeroCtaOrigen);
		//2.- Consultar el saldo de la cuenta 
		BigDecimal saldoOrigen = ctaOrigen.getSaldo();
		BigDecimal montoDebitar = this.debitarService.calcular(monto);
		//3.-validad si el saldo es insufuciente
		if(monto.compareTo(saldoOrigen)<=0) {	
			//5.-si es suficiente vaya al paso 6
			//6.- realizamos la resta del saldo origen - monto
			//con big decima no usar operadores +-*/
			
			BigDecimal nuevoSaldoOrigen = saldoOrigen.subtract(montoDebitar);
			
			//7.- actualizamos el nuevo saldo de la cta origen
			ctaOrigen.setSaldo(nuevoSaldoOrigen);
			this.cuentaRepository.actualizar(ctaOrigen);			
			//8consultamos la cuenta de destino por el nunero
			Cuenta ctaDestino = this.cuentaRepository.seleccionarPorNumero(numeroCtaDestino);
			
			//9.- consultamos el saldo de la cuenta destino
			BigDecimal saldoDestino = ctaDestino.getSaldo();
			//10.- realizamos la suma del destino + el monto
			BigDecimal nuevoSaldoDestino = saldoDestino.add(monto);
			// 11actualizamos el nuevo saldo de la cta destino
			ctaDestino.setSaldo(nuevoSaldoDestino);
		    this.cuentaRepository.actualizar(ctaDestino);
			// 12creamos la transferencia
		    Transferencia transfer = new Transferencia();
		    transfer.setCuentaDestino(ctaOrigen);
		    transfer.setCuentaDestino(ctaDestino);
		    transfer.setMonto(monto);
		    Double numero = Math.random();
		    transfer.setNumero(numero.toString());
		    transfer.setFecha(LocalDateTime.now());
		    this.transferenciaRepository.insertar(transfer);
			
			
		}else {
			//4- si no es superficie imprimir mensaje de saldo insufuciente
			System.out.println("su saldo es insuficiente, su saldo es: " + saldoOrigen);
		}
		
	}

	@Override
	public List<Transferencia> reporteTodos() {
		// TODO Auto-generated method stub
		return this.transferenciaRepository.imprimirTodos();
	}


	
	

}
