
package model;

/**
 * Essa classe serve prar trabalhar com obrjeto Cliente 
 * Trabalha com informção matricula, nome e telefone
 * @author Jair Ferraz
 */
public class Cliente {
    private int matricula;
    private String nome, telefone;

     /**
     * Inicia o objeto cliente com seus dados 
     * @param matricula
     * inteiro que referencia a matricula
     * @param nome
     * string que referencia o nome
     * @param telefone 
     * objeto telefone voltado pra especificar o telefone de um cliente
     */
    public Cliente(int matricula, String nome, String telefone) {
        this.matricula = matricula;
        this.nome = nome;
        this.telefone = telefone;
    }
    /**
     * altera o matricula de um cliente
     * @param matricula 
     * inteiro matricula do cliente
     */
    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }
    /**
     * altera o nome de um cliente
     * @param nome 
     * string nome do cliente
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    /**
     * altera o telefone de um cliente
     * @param telefone 
     * string telefone do cliente
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    /**
     * retorna o matricula de um cliente
     * @return 
     * 
     */
    public int getMatricula() {
        return matricula;
    }
    /**
     * retorna o nome de um cliente
     * @return 
     * 
     */
    public String getNome() {
        return nome;
    }
    /**
     * retorna o telefone de um cliente
     * @return 
     * 
     */
    public String getTelefone() {
        return telefone;
    }

    @Override
    public String toString() {
        return "Cliente{" + "\nmatricula=" + matricula + ", \nnome=" + nome + ", \ntelefone=" + telefone + '}';
    }
    
    
}
