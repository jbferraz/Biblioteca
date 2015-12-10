/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import repositorio.RepositorioClientes;
import repositorio.RepositorioLivros;
import repositorio.RepositorioRetiraLivro;
import model.Cliente;
import model.Livro;
import model.RetiraLivro;
import util.Console;
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

        while (op != 4) {
            System.out.println(".: Menu - Cadastro de Livro:.");
            System.out.println("1 - Adicionar Livro");
            System.out.println("2 - Visualizar todos Livros");
            System.out.println("3 - Excluir???");
            System.out.println("4 - Voltar");
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
                    System.out.println("\nExcluir Livro");
                    break;
                case 4:
                    menuP();
                default:
                //throw new AssertionError();
            }
        }

    }

    public static void menuC() {
        int op = 0;

        while (op != 5) {
            System.out.println(".: Menu - Cadastro Cliente:.");
            System.out.println("1 - Adicionar Cliente");
            System.out.println("2 - Visualizar todos Clientes");
            System.out.println("3 - Excluir Clientes");
            System.out.println("4 - Alterar Clientes");
            System.out.println("5 - Voltar");
            op = Console.scanInt("Escolha uma opção: ");
            int matricula;
            String nome;
            String telefone;

            switch (op) {
                case 1:
                    matricula = Console.scanInt("Matricula: ");
                    nome = Console.scanString("Nome: ");
                    telefone = Console.scanString("Telefone: ");

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
                    System.out.println("\nExcluir Clientes");
                    if (!repositorioClientes.temClientes()) {
                        System.out.println("Nenhum cliente foi cadastrado!");
                        break;
                    }
                    matricula = Console.scanInt("Matricula: ");
                    if (repositorioClientes.existeCliente(matricula) == false) {
                        System.out.println("Cliente não cadastrado!");
                        break;
                    } else {
                        clientes = new Cliente(matricula, "", "");
                        repositorioClientes.excluir(repositorioClientes.buscarClientePorMatricula(matricula));
                        System.out.println("Cliente " + matricula + " excluído com sucesso!");
                    }
                    break;
                case 4:
                    System.out.println("\nAltera Clientes");
                    if (!repositorioClientes.temClientes()) {
                        System.out.println("Nenhum cliente foi cadastrado!");
                        break;
                    }
                    matricula = Console.scanInt("Matricula: ");
                    if (repositorioClientes.existeCliente(matricula) == false) {
                        System.out.println("Cliente não cadastrado!");
                        break;
                    } else {
                        nome = repositorioClientes.buscarClientePorMatricula(matricula).getNome();
                        telefone = repositorioClientes.buscarClientePorMatricula(matricula).getTelefone();
                        System.out.println("Nome: " + nome);
                        System.out.println("Telefone: " + telefone);
                        nome = Console.scanString("Novo nome: ");
                        telefone = Console.scanString("Novo telefone: ");
                        repositorioClientes.buscarClientePorMatricula(matricula).setNome(nome);
                        repositorioClientes.buscarClientePorMatricula(matricula).setTelefone(telefone);
                        System.out.println("Cliente alterado com sucesso!");
                    }
                    break;
                case 5:
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
                    int matricula = Console.scanInt("Informa a matricula: ");
                    Cliente cli = repositorioClientes.buscarClientePorMatricula(matricula);

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
                    int quant = Console.scanInt("Informe quantos livros vai retirar: ");
                    ArrayList<Livro> listaLivros = new ArrayList<>();
                    for (int i = 0; i < quant; i++) {
                        System.out.println("Informe o ISBN do Livro nº " + i + 1);
                        String isbn = Console.scanString("Digite ISBN: ");
                        if (!repositorioLivros.existeLivro(isbn)) {
                            System.out.println("Livro não cadastrado");
                            break;
                        } else {
                            Livro l = repositorioLivros.buscarLivroPorISBN(isbn);
                            listaLivros.add(l);
                            System.out.println(l);
                        }
                    }
                    String dtRet = Console.scanString("Data Retirada (dd/mm/aaaa): ");
                    try {
                        Date dtRetirada;
                        Date dtDev;
                        dtRetirada = DateUtil.stringToDate(dtRet);

                        Calendar c = Calendar.getInstance();
                        c.setTime(dtRetirada);
                        c.add(Calendar.DATE, +7);
                        dtDev = c.getTime();

                        RetiraLivro retLivro = new RetiraLivro(cli, listaLivros, dtRetirada, dtDev);
                        repositorioRetiraLivro.adicionar(retLivro);
                    } catch (ParseException ex) {
                        Logger.getLogger(Biblioteca.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case 2:
                    System.out.println("\nLista de Retiradas");
                    if (!repositorioRetiraLivro.temRetiraLivro()) {
                        System.out.println("Nenhum retirada foi encontrada!");
                    } else {
                        System.out.print(String.format("%-10s", "Matricula"));
                        System.out.print(String.format("%-10s", "Livro"));
                        System.out.print(String.format("%-5s", "Data Retirada"));
                        System.out.println(String.format("%-5s", "Data à Devolver"));
                        for (RetiraLivro rt : repositorioRetiraLivro.getListaRetiraLivro()) {
                            System.out.print(String.format("%-10s", rt.getCliente().getNome()));

                            for (Livro ll : rt.getListaLivros()) {
                                System.out.print(String.format("\n%-10s", ll.getNome()));
                            }
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
