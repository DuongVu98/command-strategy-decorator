package com.tma.usecases.decorators;

import com.tma.models.Book;
import com.tma.repositories.BookQueryRepository;
import com.tma.repositories.QueryRepository;
import com.tma.usecases.SearchUsecase;

import java.util.List;

public abstract class BookSearchUsecaseDecorator implements SearchUsecase<Book> {

    protected SearchUsecase<Book> bookSearchUsecase;
    protected QueryRepository<Book> bookQueryRepository;
    protected String inputString;

    public BookSearchUsecaseDecorator(SearchUsecase<Book> bookSearchUsecase, String inputString) {
        this.bookSearchUsecase = bookSearchUsecase;
        bookQueryRepository = new BookQueryRepository();
        this.inputString = inputString;
    }

    @Override
    public List<Book> search(){
        return bookSearchUsecase.search();
    }
}
