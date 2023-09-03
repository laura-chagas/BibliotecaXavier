package org.example.model;

public class AuthorModel {
    private int authorId;
    private String authoName;
    private String authorCpf;
    private String authorEmail;
    private int bookId;

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getAuthoName() {
        return authoName;
    }

    public void setAuthoName(String authoName) {
        this.authoName = authoName;
    }

    public String getAuthorCpf() {
        return authorCpf;
    }

    public void setAuthorCpf(String authorCpf) {
        this.authorCpf = authorCpf;
    }

    public String getAuthorEmail() {
        return authorEmail;
    }

    public void setAuthorEmail(String authorEmail) {
        this.authorEmail = authorEmail;
    }
}
