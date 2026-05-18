public void emprestarLivro(int codigo) {

    if (codigo >= 0 && codigo < livros.size()) {

        Livro livro = livros.get(codigo);

        if (!livro.isEmprestado()) {

            livro.setEmprestado(true);

            System.out.println("Livro emprestado com sucesso!");

        } else {

            System.out.println("Livro já está emprestado.");
        }

    } else {

        System.out.println("Código inválido.");
    }
}