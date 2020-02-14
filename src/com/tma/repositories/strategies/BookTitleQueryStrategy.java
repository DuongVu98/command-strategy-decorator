package com.tma.repositories.strategies;

import com.tma.database.Database;
import com.tma.models.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BookTitleQueryStrategy implements QueryStrategy<Book> {

    private Database database = Database.getInstance();

    @Override
    public List<Book> query(String str) {

        List<Book> results = new ArrayList<>();

        for (String key : database.books.keySet()){
            Book book = database.books.get(key);
            boolean isFound = book.getTitle().contains(str);
            if(isFound){
                results.add(book);
            }
        }
        return results;
    }
}
