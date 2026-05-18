 public class Livro{
 private String titulo;
 private String autor;
 private boolean emprestado;
    public Livro(String titulo,String autor){
        this.titulo = titulo;
        this.autor = autor;
        this.emprestado = false
    }
    public void exibirInfo(){
        System.out.println("Titulo: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Status: " + (emprestado ? "Emprestado" : "Disponivel"));
        System.out.println(--------------);
    }
}