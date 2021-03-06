/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora.model;

import java.sql.Date;

/**
 *
 * @author Maria
 */
public class Reserva {
    private int codReserva;
	private Date dataRetirada;
	private Date dataDevolucao;
	private Cliente cliente;
	private Carro carro;
        private String situacao;
	
	public int getCodReserva() {
		return codReserva;
	}
	public void setCodReserva(int codReserva) {
		this.codReserva = codReserva;
	}
	
	public Date getDataRetirada() {
		return dataRetirada;
	}
	public void setDataRetirada(Date dataRetirada) {
		this.dataRetirada = dataRetirada;
	}
	public Date getDataDevolucao() {
		return dataDevolucao;
	}
	public void setDataDevolucao(Date dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Carro getCarro() {
		return carro;
	}
	public void setCarro(Carro carro) {
		this.carro = carro;
	}
        
        public String getSituacao(){
            return situacao;
        }
        
        public void setSituacao(String situacao){
            this.situacao = situacao;
        }
       
        @Override
        public String toString(){
            return this.cliente.getNome();
    }
}
