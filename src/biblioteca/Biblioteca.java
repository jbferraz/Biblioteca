/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Cliente;
import repositorio.RepositorioClientes;
import repositorio.RepositorioLivros;
import util.Console;
import model.Livro;
import model.RetiraLivro;
import repositorio.RepositorioRetiraLivro;
import util.DateUtil;

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
            System.out.println("3 - Cadastro de Retirada de Livro");
            System.out.println("6 - Sair");

            op = Console.scanInt("Escolha uma opção: ");
            switch (op) {
                case 1:
                    menuL();
                    break;
                case 2:
                    menuC();
                    break;
                case 3:
                    menuRL();
                    break;
                default:
                    //throw new AssertionError();
            }
        }
    }

    public static void menuL() {
        int op = 0;

        while (op != 3) {
            System.out.println(".: Menu - Cadastro de Livro:.");
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
                    System.out.println("\nLista de Livros");
                    if (!repositorioLivros.temLivros()) {
                        System.out.println("Nenhum livro foi cadastrado!");
                    } else {
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
                    //throw new AssertionError();
            }
        }

    }

    public static void menuC() {
        int op = 0;

        while (op != 3) {
            System.out.println(".: Menu - Cadastro Cliente:.");
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
                    if (!repositorioClientes.temClientes()) {
                        System.out.println("Nenhum cliente foi cadastrado!");
                    } else {
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
                    //throw new AssertionError();
            }
        }

    }

    public static void menuRL() {
        int op = 0;

        while (op != 3) {

            System.out.println(".: Menu - Retirada de Livro:.");
            System.out.println("1 - Adicionar Retirada de Livro");
            System.out.println("2 - Visualizar todas Retiradas de Livros");
            System.out.println("3 - Voltar");

            op = Console.scanInt("Escolha uma opção: ");
            switch (op) {
                case 1:
                    System.out.println("Escolher Cliente:");
                    if (!repositorioClientes.temClientes()) {
                        System.out.println("Nenhum cliente foi cadastrado!");
                    } else {
                        System.out.print(String.format("%-10s", "Matricula"));
                        System.out.print(String.format("%-10s", "Nome"));
                        System.out.println(String.format("%-5s", "Telefone"));
                        for (Cliente c : repositorioClientes.getListaClientes()) {
                            System.out.print(String.format("%-10s", c.getMatricula()));
                            System.out.print(String.format("%-10s", c.getNome()));
                            System.out.println(String.format("%-5s", c.getTelefone()));
                        }
                        System.out.println("------------");
                    }
                    int matricula=Console.scanInt("Informa a matricula: ");
                    
                    System.out.println("Escolher Livros:");
                    if (!repositorioLivros.temLivros()) {
                        System.out.println("Nenhum livro foi cadastrado!");
                    } else {
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
                    int quant=Console.scanInt("Informe quantos livros vai retirar: ");
                    ArrayList<Livro> listaLivros = null;
                    for (int i = 0; i < quant; i++) {
                        System.out.println("Informe o ISBN do Livro nº " + i+1);
                        listaLivros.add(repositorioLivros.buscarLivroPorISBN(Console.scanString("Digite: ")));
                    }
                    String dtRet = Console.scanString("Data Retirada (dd/mm/aaaa): ");
                    try {
                        Date dtRetirada;
                        dtRetirada = DateUtil.stringToDate(dtRet);
                        RetiraLivro retLivro = new RetiraLivro(matricula, listaLivros, dtRetirada, dtRetirada);
                        repositorioRetiraLivro.adicionar(retLivro);
                    } catch (ParseException ex) {
                        Logger.getLogger(Biblioteca.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    break;
                case 2:
                    System.out.println("\nLista de clientes");
                    if (!repositorioRetiraLivro.temRetiraLivro()) {
                        System.out.println("Nenhum retirada foi encontrada!");
                    } else {
                        System.out.print(String.format("%-10s", "Matricula"));
                        System.out.print(String.format("%-10s", "Livro"));
                        System.out.print(String.format("%-5s", "Data Retirada"));
                        System.out.println(String.format("%-5s", "Data à Devolver"));
                        for (RetiraLivro rt : repositorioRetiraLivro.getListaRetiraLivro()) {
                            System.out.print(String.format("%-10s", rt.getMatricula()));
                            /*
                            for (Livro ll : rt.getListaLivros()) {
                                System.out.print(String.format("%-10s", ll.getListaLivros());
                            }*/
                            System.out.print(String.format("%-5s", rt.getDataRetirada()));
                            System.out.println(String.format("%-5s", rt.getDataDevolucao()));
                        }
                    }

                    break;
                case 3:
                    menuP();
                    break;
                default:
                    //throw new AssertionError();
            }
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here
        menuP();
    }

}
