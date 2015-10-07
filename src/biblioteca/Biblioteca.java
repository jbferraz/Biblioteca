/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

import model.Cliente;
import repositorio.RepositorioClientes;
import repositorio.RepositorioLivros;
import util.Console;
import model.Livro;
import repositorio.RepositorioRetiraLivro;

/**
 *
 * @author Jair Ferraz
 */
public class Biblioteca {

    static RepositorioLivros repositorioLivros = new RepositorioLivros();
    static RepositorioClientes repositorioClientes = new RepositorioClientes();
    static RepositorioRetiraLivro repositorioRetiraLivro = new RepositorioRetiraLivro();
    

    public static void menuP() {
        int op = 0;

        while (op != 6) {

            System.out.println(".: Biblioteca - Menu :.");
            System.out.println("1 - Cadastro de Livros");
            System.out.println("2 - Cadastro de Clientes");
            System.out.println("6 - Sair");

            op = Console.scanInt("Escolha uma opção: ");
            switch (op) {
                case 1:
                    menuL();
                    break;
                case 2:
                    menuC();
                    break;
                default:
                    throw new AssertionError();
            }
        }
    }

    public static void menuL() {
        int op = 0;
        
        while (op != 3) {
            
            System.out.println("1 - Adicionar Livro");
            System.out.println("2 - Visualizar todos Livros");
            System.out.println("3 - Voltar");
            op = Console.scanInt("Escolha uma opção: ");
            
            switch (op) {
                case 1:
                    String ISBN = Console.scanString("ISBN: ");
                    String nome = Console.scanString("Nome: ");
                    String autores = Console.scanString("Atores: ");
                    String editora = Console.scanString("Editora: ");
                    int ano = Console.scanInt("Ano Lançamento: ");

                    Livro livros = new Livro(ISBN, nome, autores, editora, ano);
                    repositorioLivros.adicionar(livros);
                    break;
                case 2:
                    System.out.println("\nLista de pacientes");
                    if (!repositorioLivros.temLivros()) {
                        System.out.println("Nenhum livro foi cadastrado!");
                    }
                    else {
                        System.out.print(String.format("%-10s", "ISBN"));
                        System.out.print(String.format("%-10s", "Nome"));
                        System.out.print(String.format("%-20s", "Autores"));
                        System.out.print(String.format("%-20s", "Editoras"));
                        System.out.println(String.format("%-5s", "Ano"));
                        for (Livro l : repositorioLivros.getListaLivros()) {
                            System.out.print(String.format("%-10s", l.getISBN()));
                            System.out.print(String.format("%-10s", l.getNome()));
                            System.out.print(String.format("%-20s", l.getAutores()));
                            System.out.print(String.format("%-20s", l.getEditora()));
                            System.out.println(String.format("%-5s", l.getAno()));
                        }
                    }
                    break;
                case 3:
                    menuP();
                default:
                    throw new AssertionError();
            }
        }

    }

    public static void menuC() {
        int op = 0;
        
        while (op != 3) {
            
            System.out.println("1 - Adicionar Cliente");
            System.out.println("2 - Visualizar todos Clientes");
            System.out.println("3 - Voltar");
            op = Console.scanInt("Escolha uma opção: ");
            
            switch (op) {
                case 1:
                    int matricula = Console.scanInt("Matricula: ");
                    String nome = Console.scanString("Nome: ");
                    String telefone = Console.scanString("Telefone: ");

                    Cliente clientes = new Cliente(matricula, nome, telefone);
                    repositorioClientes.adicionar(clientes);
                    break;
                case 2:
                    System.out.println("\nLista de clientes");
                    if (!repositorioLivros.temLivros()) {
                        System.out.println("Nenhum cliente foi cadastrado!");
                    }
                    else {
                        System.out.print(String.format("%-10s", "Matricula"));
                        System.out.print(String.format("%-10s", "Nome"));
                        System.out.println(String.format("%-5s", "Telefone"));
                        for (Cliente c : repositorioClientes.getListaClientes()) {
                            System.out.print(String.format("%-10s", c.getMatricula()));
                            System.out.print(String.format("%-10s", c.getNome()));
                            System.out.println(String.format("%-5s", c.getTelefone()));
                        }
                    }
                    break;
                case 3:
                    menuP();
                default:
                    throw new AssertionError();
            }
        }

    }

    public static void main(String[] args) {
        // TODO code application logic here
       menuP();
    }

}
