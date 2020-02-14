package com.tma.repositories;

import com.tma.database.Database;
import com.tma.models.Book;

import java.util.List;

public class BookCommandRepository implements CommandRepository<Book> {
    private Book book;
    private Database database = Database.getInstance();

    public BookCommandRepository(Book book) {
        this.book = book;
    }

    @Override
    public Book getOne() {
        return book;
    }

    @Override
    public void setOne(Book book) {
        this.book = book;
    }

    @Override
    public void save() {
        database.books.put(book.getId(), book);
    }

    @Override
    public void edit() {
        database.books.remove(book.getId());
        database.books.put(book.getId(), book);
    }

    @Override
    public void delete() {
        database.books.remove(book.getId());
    }
}
