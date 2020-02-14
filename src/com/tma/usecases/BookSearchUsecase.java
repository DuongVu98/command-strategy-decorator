package com.tma.usecases;

import com.tma.models.Book;
import com.tma.repositories.BookQueryRepository;
import com.tma.repositories.QueryRepository;
import com.tma.repositories.strategies.BookTitleQueryStrategy;

import java.util.List;

public class BookSearchUsecase implements SearchUsecase<Book> {

    private QueryRepository<Book> bookQueryRepository;
    private String inputString;

    public BookSearchUsecase(String inputString) {
        this.inputString = inputString;
        bookQueryRepository = new BookQueryRepository();
    }

    private List<Book> searchTitle(){
        bookQueryRepository.setQueryStrategy(new BookTitleQueryStrategy());
        return bookQueryRepository.query(inputString);
    }

    @Override
    public List<Book> search() {
        return searchTitle();
    }
}
