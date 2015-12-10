/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Jair Ferraz
 */
public class RetiraLivro {

    private Cliente cliente;
    private  ArrayList<Livro> listaLivros; 
    private  Date dataRetirada;
    private  Date dataDevolucao;

    public RetiraLivro(Cliente cliente, ArrayList<Livro> listaLivros, Date dataRetirada, Date dataDevolucao) {
        this.cliente = cliente;
        this.listaLivros = listaLivros;
        this.dataRetirada = dataRetirada;
        this.dataDevolucao = dataDevolucao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public ArrayList<Livro> getListaLivros() {
        return listaLivros;
    }

    public Date getDataRetirada() {
        return dataRetirada;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }
    
}
