package com.tma.repositories;

import com.tma.database.Database;
import com.tma.models.Book;
import com.tma.repositories.strategies.BookTitleQueryStrategy;
import com.tma.repositories.strategies.QueryStrategy;

import java.util.List;

public class BookQueryRepository implements QueryRepository<Book> {

    private Database database = Database.getInstance();
    private QueryStrategy<Book> bookQueryStrategy;

    @Override
    public void setQueryStrategy(QueryStrategy<Book> queryStrategy) {
        bookQueryStrategy = queryStrategy;
    }

    @Override
    public Book findOne(String id) {
        return database.books.get(id);
    }

    @Override
    public List<Book> query(String str) {
        return bookQueryStrategy.query(str);
    }
}
