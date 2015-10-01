/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorio;

import java.util.ArrayList;
import model.Livro;

/**
 *
 * @author 771400163
 */
public class RepositorioLivros {
    private ArrayList<Livro> listaLivros;
    
    public RepositorioLivros(){
        listaLivros= new ArrayList<Livro>();        
    }
    public void adicionar(Livro livro){
        listaLivros.add(livro);
    }
    public ArrayList<Livro> getListaLivros() {
        return listaLivros;
    }
    public Livro buscarLivroPorISBN(String isbn)
    {
        for(Livro l: listaLivros)
        {
            if(l.getISBN().equals(isbn))
            {
                return(l);
            }
        }
        return(null);
    }
    public boolean existeLivro(String isbn){
        if(this.buscarLivroPorISBN(isbn)!=null)
            return true;
        else
            return false;
    }
    public Livro buscarClientePorNomeCliente(String NomeLivro)
    {
        for(Livro l: listaLivros)
        {
            if(l.getNome().equals(NomeLivro))
            {
                return(l);
            }
        }
        return(null);
    }
    public boolean temLivros(){
        return !listaLivros.isEmpty();
    }
}
