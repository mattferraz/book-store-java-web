/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tads.mhsf.models.repositories;

import com.tads.mhsf.models.business.Book;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mtshs
 */

public class BookRepository {
    
    private static final List<Book> books = new ArrayList<>();
    
    
    public static void addBook(Book book) {
        books.add(book);
    }
    
    public static void removeBook(int id) {
        for (int index = 0; index < books.size(); index++) {
            if (books.get(index).getId() == id) {
                books.remove(index);
                break;
            }
        }
    }
    
    public static void editBook(Book updatedBook) {
        for (Book book : books) {
            if (book.getId() == updatedBook.getId()) {
                book = updatedBook;
                break;
            }
        }
    }
    
    public static Book getBook(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }
    
    public static List<Book> getAllBooks() {
        return books;
    }
    
}
