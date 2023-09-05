package org.example.view;

import org.example.controller.AdminController;
import org.example.controller.LoanController;

import java.util.Scanner;

public class AdminView {

    AdminController adminController;
    LoanController loanController;
    Scanner scan;

    public AdminView() {
        adminController = new AdminController();
        loanController = new LoanController();
        scan = new Scanner(System.in);
    }

    public void logInAdmin() {
        System.out.println("Por favor, efetue seu login para ter acesso as opções: ");
        System.out.println();
        System.out.println("Informe seu token de acesso: ");
        int tokenAdmin = scan.nextInt();
        menuAdmin(adminController.logIn(tokenAdmin));
    }

    public void menuAdmin(boolean longinIsTrue) {
        int userchoice;
        do {
            System.out.println("Informe a opção desejada:" + "\n\t1- Cadastrar Autor" + "\n\t2- Cadastrar Livro" + "\n\t3- Deletar um cadastro " + "\n\t4- Efetuar um empréstimo" + "\n\t5- Associar Livro a um Autor " + "\n\t6- Associar Autor a um Livro" + "\n\t0- SAIR ");
            userchoice = scan.nextInt();
            switch (userchoice) {
                case 1:
                    registerAuthor();
                    break;
                case 2:
                    bookRegister();
                    break;
                case 3:
                    menuExcluded();
                    break;
                case 4:
                    registerNewLoan();
                    break;
                case 5:
                    associateAuthorId();
                    break;
                case 6:
                    associateBookId();
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Opção inválida");
            }
        } while (userchoice != 0);
    }

    public void registerAuthor() {
        System.out.println("Informe o nome do Autor: ");
        String name = scan.next();
        scan.nextLine();
        System.out.println("Informe o CPF do Autor: ");
        String cpf = scan.next();
        System.out.println("Informe o e-mail do Autor: ");
        String email = scan.next();
        adminController.registerAuthor(name, cpf, email);
    }

    public void bookRegister() {
        System.out.println("Qual o título do livro?:");
        String title = scan.next();
        scan.nextLine();
        System.out.println("Qual a descrição?: ");
        String description = scan.next();
        scan.nextLine();
        System.out.println("Qual o gênero?: ");
        String genrer = scan.next();
        adminController.registerBook(title, description, genrer);
    }

    public void menuExcluded() {
        int choice;
        do {
            System.out.println("Informe qual tipo de cadastro deseja excluir: " + "\n\t1-Excluir um livro" + "\n\t2-Excluir um autor" + "\n\t3-Excluir um usuário" + "\n\t0-Sair");
            choice = scan.nextInt();
            System.out.println("Informe o id: ");
            int idASerDeletado = scan.nextInt();
            switch (choice) {
                case 1:
                    adminController.deleteBook(idASerDeletado);
                    break;
                case 2:
                    adminController.deleteAuthor(idASerDeletado);
                    break;
                case 3:
                    adminController.deleteUser(idASerDeletado);
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Opção inválida");
                    menuExcluded();
            }
        } while (choice != 0);
    }

    public void registerNewLoan() {
        System.out.println("Digite o id do livro que deseja pegar emprestado:");
        int id_livro = scan.nextInt();
        System.out.println("Digite o id(leitor):");
        int id_leitor = scan.nextInt();
        loanController.registerNewLoan(id_livro, id_leitor);
    }

    public void associateAuthorId() {
        System.out.println("Informe o id do Autor: ");
        int idAutor = scan.nextInt();
        System.out.println("Informe o id do Livro: ");
        int idLivro = scan.nextInt();
        adminController.associateAuthorId(idAutor, idLivro);
    }

    public void associateBookId() {
        System.out.println("Informe o id do Livro: ");
        int idLivro = scan.nextInt();
        System.out.println("Informe o id do Autor: ");
        int idAutor = scan.nextInt();
        adminController.associateBookId(idLivro, idAutor);
    }

}

