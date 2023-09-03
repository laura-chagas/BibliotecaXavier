package org.example.controller;

import org.example.model.BookModel;
import org.example.model.LoanModel;
import org.example.model.UserModel;
import org.example.repository.LoanRepository;

public class LoanController {
    LoanRepository loanRepo = new LoanRepository();
    LoanModel loanModel = new LoanModel();
    BookModel bookModel = new BookModel();
    UserModel userModel = new UserModel();

    public boolean registerNewLoan(int id_book, int id_user) {
        bookModel.setIdBook(id_book);
        userModel.setUserId(id_user);
        loanModel.setBookId(bookModel.getIdBook());
        loanModel.setUserId(userModel.getUserId());
        return loanRepo.registerNewLoan(loanModel.getBookId(), loanModel.getUserId());
    }

    public boolean associateUserId(int idUser, int id_loan) {
        userModel.setUserId(idUser);
        loanModel.setLoanId(id_loan);
        return loanRepo.associateUserId(userModel.getUserId(), loanModel.getLoanId());
    }

    public boolean updateStatusBook(int id_book) {
        bookModel.setIdBook(id_book);
        return loanRepo.updateStatusBook(bookModel.getIdBook());
    }
}