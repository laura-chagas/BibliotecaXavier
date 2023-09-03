package org.example.controller;

import org.example.model.UserModel;
import org.example.repository.UserRepository;

public class UserController {
    UserRepository userRepository = new UserRepository();
    UserModel userModel = new UserModel();

    public boolean registerNewUser(String nome, String cpf, String email, String senha) {
        userModel.setUserName(nome);
        userModel.setUserCpf(cpf);
        userModel.setUserEmail(email);
        userModel.setUserPassword(senha);
        return userRepository.registerANewUser(userModel.getUserName(), userModel.getUserCpf(), userModel.getUserEmail(), userModel.getUserPassword());
    }

    public Boolean userLogIn(String email, String password) {
        userModel.setUserEmail(email);
        userModel.setUserPassword(password);
        return userRepository.logIn(userModel.getUserEmail(), userModel.getUserPassword());
    }
}


