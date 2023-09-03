package org.example.view;

import org.example.controller.UserController;

import java.util.Scanner;

public class UserView {
    private Scanner scan;
    private UserController userController;

    public UserView() {
        scan = new Scanner(System.in);
        userController = new UserController();
    }

    public void menuUser() {
        System.out.println("\t\t\tVocê deseja: \n\t[1] Fazer Login" + "\n\t[2] Cadastrar-se" + "\n\t[0] Sair");
        int userChoice = scan.nextInt();
        switch (userChoice) {
            case 1:
                collectInfosForLogin();
                break;
            case 2:
                collectInfosForRegister();
                break;
            case 0:
                System.exit(0);
            default:
                System.err.println("Opção Inválida!!! ");
                menuUser();
        }
    }

    public void collectInfosForLogin() {
        System.out.print("EMAIL: ");
        String email = scan.next();

        System.out.print("SENHA: ");
        String password = scan.next();

        userController.userLogIn(email, password);
    }

    public void collectInfosForRegister() {
        System.out.print("NOME: ");
        String nome = scan.next();
        System.out.print("CPF: ");
        String cpf = scan.next();
        System.out.print("EMAIL: ");
        String email = scan.next();
        System.out.print("SENHA: ");
        String senha = scan.next();
        userController.registerNewUser(nome, cpf, email, senha);
    }

    public static void main(String[] args) {
        UserView userView = new UserView();

        userView.menuUser();
    }


}
