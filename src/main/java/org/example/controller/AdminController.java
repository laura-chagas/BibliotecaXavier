package org.example.controller;

import org.example.model.AdminModel;
import org.example.model.AuthorModel;
import org.example.model.BookModel;
import org.example.model.UserModel;
import org.example.repository.AdminRepository;

public class AdminController {

    AdminRepository adminRepository = new AdminRepository();
    AdminModel adminModel = new AdminModel();
    BookModel bookModel = new BookModel();
    AuthorModel authorModel = new AuthorModel();
    UserModel userModel = new UserModel();

    public boolean logIn(int tokenAdmin) {
        adminModel.setTokenAdmin(tokenAdmin);
        return adminRepository.logIn(adminModel.getTokenAdmin());
    }

    public boolean registerBook(String title, String description, String genrer) {
        bookModel.setBookTitle(title);
        bookModel.setDescriptionBook(description);
        bookModel.setGenreBook(genrer);
        return adminRepository.registerBook(bookModel.getBookTitle(), bookModel.getDescriptionBook(), bookModel.getGenreBook());
    }

    public boolean registerAuthor(String name, String cpf, String email) {
        authorModel.setAuthoName(name);
        authorModel.setAuthorCpf(cpf);
        authorModel.setAuthorEmail(email);
        return adminRepository.registerAuthor(authorModel.getAuthoName(), authorModel.getAuthorCpf(), authorModel.getAuthorEmail());
    }

    public boolean deleteBook(int idBook) {
        bookModel.setIdBook(idBook);
        return adminRepository.deleteBook(bookModel.getIdBook());
    }

    public boolean deleteAuthor(int idAuthor) {
        authorModel.setAuthorId(idAuthor);
        return adminRepository.deleteAuthor(authorModel.getAuthorId());
    }

    public boolean deleteUser(int idUser) {
        userModel.setUserId(idUser);
        return adminRepository.deleteUser(userModel.getUserId());
    }

    public boolean associateAuthorId(int idAuthor, int idBook) {
        bookModel.setAuthorId(idAuthor);
        bookModel.setIdBook(idBook);
        return adminRepository.associateAuthorId(bookModel.getAuthorId(), bookModel.getIdBook());
    }

    public boolean associateBookId(int idBook, int idAuthor) {
        authorModel.setBookId(idBook);
        authorModel.setAuthorId(idAuthor);
        return adminRepository.associateBookId(authorModel.getBookId(), authorModel.getAuthorId());
    }


}
