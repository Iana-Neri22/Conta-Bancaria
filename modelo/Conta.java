package br.com.caelum.contas.modelo;

import br.com.caelum.javafx.api.util.Evento;

public abstract class Conta {
	
	protected double saldo;
	private String titular;
	private int numero;
	private String agencia;
	private Object conta;
	
	@Override
	public String toString() {
		return "[titular=" + titular + ", numero=" + numero + ", agencia=" + agencia + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		
		Conta outraConta = (Conta) obj;
		
		return this.numero == outraConta.numero && this.agencia.equals(outraConta.agencia);
	}
	
	abstract public String getTipo();
	
	public void deposita(double valor) {
		
		if (valor < 0) {
			throw new IllegalArgumentException("Você tentou depositar um valor negativo");
		} else {
			this.saldo += valor;
		}
		
		
	}
	
	public void saca(double valor) {
		
		if (valor < 0) {
			throw new IllegalArgumentException("Você tentou sacar um valor negativo");
		} else {
			this.saldo -= valor;
		}
		
	}

	public void transfere(double valor, Conta conta) {
		this.saca(valor);
		conta.deposita(valor);
	}

	public double getSaldo() {
		return saldo;
	}

	public String getTitular() {
		return titular;
	}

	public int getNumero() {
		return numero;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}
	
	public void setTitular(String titular) {
		this.titular = titular;
	}

	
	
}
