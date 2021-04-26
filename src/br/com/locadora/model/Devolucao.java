/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora.model;

public class Devolucao {
    private int codDevolucao;
    private Cliente cliente;
    private Carro carro;

    public int getCodDevolucao() {
        return codDevolucao;
    }

    public void setCodDevolucao(int codDevolucao) {
        this.codDevolucao = codDevolucao;
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
    
    
}
