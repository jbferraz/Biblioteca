/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 * Essa classe serve prar trabalhar com obrjeto Livro 
 * Trabalha com informção ISBN, nome, autores, editora e ano
 * @author Jair Ferraz
 */
public class Livro {
    private String ISBN, nome, autores, editora;
    private int ano;
     /**
     * Inicia o objeto Livro com seus dados 
     * @param ISBN
     * string que referencia  ISBN
     * @param nome
     * string que referencia o nome
     * @param autores 
     * string que referencia o autores
     * @param editora 
     * string que referencia o editora
     * @param ano 
     * string que referencia o ano
     */
    public Livro(String ISBN, String nome, String autores, String editora, int ano) {
        this.ISBN = ISBN;
        this.nome = nome;
        this.autores = autores;
        this.editora = editora;
        this.ano = ano;
    }
    /**
     * altera o ISBN de um Livro
     * @param ISBN 
     * String ISBN do Livro
     */
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }
    /**
     * altera o nome de um Livro
     * @param nome 
     * String nome do Livro
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    /**
     * altera o autores de um Livro
     * @param autores 
     * String autores do Livro
     */
    public void setAutores(String autores) {
        this.autores = autores;
    }
    /**
     * altera o editora de um Livro
     * @param editora 
     * String editora do Livro
     */
    public void setEditora(String editora) {
        this.editora = editora;
    }
    /**
     * altera o ano de um Livro
     * @param ano 
     * Inteiro ano do Livro
     */
    public void setAno(int ano) {
        this.ano = ano;
    }
    /**
     * retorna o ISBN de um Livro
     * @return 
     * 
     */
    public String getISBN() {
        return ISBN;
    }
    /**
     * retorna o nome de um Livro
     * @return 
     * 
     */
    public String getNome() {
        return nome;
    }
    /**
     * retorna o autores de um Livro
     * @return 
     * 
     */
    public String getAutores() {
        return autores;
    }
    /**
     * retorna o editora de um Livro
     * @return 
     * 
     */
    public String getEditora() {
        return editora;
    }
    /**
     * retorna o ano de um Livro
     * @return 
     * 
     */
    public int getAno() {
        return ano;
    }

    @Override
    public String toString() {
        return "Livro{" + "\nISBN=" + ISBN + ", \nnome=" + nome + ", \nautores=" + autores + ", \neditora=" + editora + ", \nano=" + ano + '}';
    }

}
