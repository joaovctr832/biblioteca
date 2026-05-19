import java.util.ArrayList;
import java.util.Scanner;

class Livro {
    private String titulo;
    private String autor;
    private boolean emprestado;

    public Livro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
        this.emprestado = false;
    }

    public String getTitulo() {
        return titulo;
    }

    public boolean isEmprestado() {
        return emprestado;
    }

    public void emprestar() {
        emprestado = true;
    }

    public void devolver() {
        emprestado = false;
    }

    public void mostrarInfo() {
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Status: " + (emprestado ? "Emprestado" : "Disponível"));
        System.out.println("----------------------");
    }
}

class Biblioteca {
    private ArrayList<Livro> livros = new ArrayList<>();

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
        System.out.println("Livro adicionado com sucesso!");
    }

    public void listarLivros() {
        if (livros.isEmpty()) {
            System.out.println("Nenhum livro cadastrado.");
            return;
        }

        for (Livro livro : livros) {
            livro.mostrarInfo();
        }
    }

    public Livro buscarLivro(String titulo) {
        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                return livro;
            }
        }
        return null;
    }

    public void emprestarLivro(String titulo) {
        Livro livro = buscarLivro(titulo);

        if (livro == null) {
            System.out.println("Livro não encontrado.");
        } else if (livro.isEmprestado()) {
            System.out.println("Esse livro já está emprestado.");
        } else {
            livro.emprestar();
            System.out.println("Livro emprestado com sucesso!");
        }
    }

    public void devolverLivro(String titulo) {
        Livro livro = buscarLivro(titulo);

        if (livro == null) {
            System.out.println("Livro não encontrado.");
        } else if (!livro.isEmprestado()) {
            System.out.println("Esse livro já está disponível.");
        } else {
            livro.devolver();
            System.out.println("Livro devolvido com sucesso!");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();

        int opcao;

        do {
            System.out.println("\n===== BIBLIOTECA =====");
            System.out.println("1 - Adicionar livro");
            System.out.println("2 - Listar livros");
            System.out.println("3 - Emprestar livro");
            System.out.println("4 - Devolver livro");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = entrada.nextInt();
            entrada.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o título do livro: ");
                    String titulo = entrada.nextLine();

                    System.out.print("Digite o autor do livro: ");
                    String autor = entrada.nextLine();

                    Livro livro = new Livro(titulo, autor);
                    biblioteca.adicionarLivro(livro);
                    break;

                case 2:
                    biblioteca.listarLivros();
                    break;

                case 3:
                    System.out.print("Digite o título do livro para emprestar: ");
                    String tituloEmprestar = entrada.nextLine();
                    biblioteca.emprestarLivro(tituloEmprestar);
                    break;

                case 4:
                    System.out.print("Digite o título do livro para devolver: ");
                    String tituloDevolver = entrada.nextLine();
                    biblioteca.devolverLivro(tituloDevolver);
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        entrada.close();
    }
}