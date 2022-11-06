package com.mainuddin.spring.restApi.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFilter;

import javax.persistence.*;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int authorId;
    private String firstName;
    private String lastName;
    private String language;

    @OneToOne(mappedBy = "author")
    @JsonBackReference
    private Book book;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Author() {
    }

    public Author(int authorId, String firstName, String lastName, String language) {
        this.authorId = authorId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.language = language;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "Author{" +
                "authorId=" + authorId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", language='" + language + '\'' +
                '}';
    }
}
