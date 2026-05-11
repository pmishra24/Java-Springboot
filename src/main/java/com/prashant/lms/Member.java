package com.prashant.lms;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;

    @ManyToMany
    @JoinTable(name = "member_book", joinColumns = @JoinColumn(name = "member_id"), inverseJoinColumns = @JoinColumn(name = "book_id"))
    private List<Book> borrowedBooks;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(List<Book> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

    public void updateBorrowedBooks(Book borrowedBook) {
        this.borrowedBooks.add(borrowedBook);
    }

}
