package com.tma;

import com.tma.database.Database;
import com.tma.models.Book;
import com.tma.models.User;
import com.tma.usecases.*;

public class Main {

    public static void setUpData(){
        User user = new User("1", "Tony");

        Book book1 = new Book("1", "Chi Pheo", "Nam Cao", "novel");
        Book book2 = new Book("2", "So do", "Vu Trong Phung", "novel");


        RegisterUser registerUser = new RegisterUser(user);
        registerUser.execute();

        UserAddBook userAddBook = new UserAddBook(user.getId(), book1);
        userAddBook.execute();

        userAddBook = new UserAddBook(user.getId(), book2);
        userAddBook.execute();
    }

    public static void main(String[] args) {
	// write your code here
        setUpData();

        String input1 = "So";
        String input2 = "Ph";

        System.out.println("Search books with title only --> input: " + input1);
        SearchUsecase<Book> bookSearchUsecase = new BookSearchUsecase(input1);
        System.out.println(bookSearchUsecase.search());

        System.out.println("\nSearch books with title and author --> input: " + input2);
        bookSearchUsecase = new BookSearchAuthorUsecase(new BookSearchUsecase(input2), input2);
        System.out.println(bookSearchUsecase.search());
    }
}
