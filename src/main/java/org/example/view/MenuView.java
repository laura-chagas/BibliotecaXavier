package org.example.view;

import java.util.Scanner;

public class MenuView {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            AdminView adminView = new AdminView();
            UserView userView = new UserView();
            int choice = 0;
            do {
                System.out.println("Bem-vindo a biblioteca");
                System.out.println("Você é: 1-Administrador | 2-Visitante | 0-Sair");
                choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        adminView.logInAdmin();
                        break;
                    case 2:
                        userView.menuUser();
                        break;
                    case 0:
                        System.exit(0);
                    default:
                        System.out.println("Opção inválida");
                }
            } while (choice != 0);
        }
    }

