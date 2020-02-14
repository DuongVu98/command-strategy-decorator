package com.tma.usecases;

import com.tma.models.Book;
import com.tma.repositories.QueryRepository;
import com.tma.repositories.strategies.BookAuthorQueryStrategy;
import com.tma.usecases.decorators.BookSearchUsecaseDecorator;

import java.util.List;

public class BookSearchAuthorUsecase extends BookSearchUsecaseDecorator {

    public BookSearchAuthorUsecase(SearchUsecase<Book> bookSearchUsecase, String inputString) {
        super(bookSearchUsecase, inputString);
    }

    private List<Book> searchAuthor(){
        bookQueryRepository.setQueryStrategy(new BookAuthorQueryStrategy());
        return bookQueryRepository.query(inputString);
    }

    @Override
    public List<Book> search(){

        List<Book> list1 = bookSearchUsecase.search();
        List<Book> list2 = searchAuthor();

        list1.addAll(list2);
        return list1;
    }
}
