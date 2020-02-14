package com.tma.usecases;

import com.tma.models.Book;
import com.tma.models.User;
import com.tma.repositories.*;

public class UserEditBook implements Usecase {

    QueryRepository<User> userQueryRepository;
    CommandRepository<Book> bookCommandRepository;
    QueryRepository<Book> bookQueryRepository;

    public UserEditBook(Book newBook){
        Book book = bookQueryRepository.findOne(newBook.getId());

        bookCommandRepository = new BookCommandRepository(book);

        userQueryRepository = new UserQueryRepository();
        bookQueryRepository = new BookQueryRepository();
    }

    public void userEditBook() {
        bookCommandRepository.save();
    }
    @Override
    public void execute() {
        userEditBook();
    }
}
