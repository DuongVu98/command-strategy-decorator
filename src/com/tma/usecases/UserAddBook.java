package com.tma.usecases;

import com.tma.models.Book;
import com.tma.models.User;
import com.tma.repositories.*;

public class UserAddBook implements Usecase {

    private CommandRepository<User> userCommandRepository;
    private QueryRepository<User> userQueryRepository;
    private CommandRepository<Book> bookCommandRepository;
    private QueryRepository<Book> bookQueryRepository;

    public UserAddBook(String userId, Book book){
        userQueryRepository = new UserQueryRepository();
        bookQueryRepository = new BookQueryRepository();

        User user = userQueryRepository.findOne(userId);

        userCommandRepository = new UserCommandRepository(user);
        bookCommandRepository = new BookCommandRepository(book);
    }

    void userAddNewBook(){
        User user = userCommandRepository.getOne();
        Book book = bookCommandRepository.getOne();

//        System.out.println(user.getBooks());

        user.getBooks().add(book);
        userCommandRepository.setOne(user);
        userCommandRepository.save();

        bookCommandRepository.save();
    }


    @Override
    public void execute() {
        userAddNewBook();
    }
}
