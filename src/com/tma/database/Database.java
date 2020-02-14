package com.tma.database;

import com.tma.models.Book;
import com.tma.models.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Database {
    public Map<String, User> users = new HashMap<String, User>();
    public Map<String, Book> books = new HashMap<String, Book>();

    public Map selectAllUsers() {
        return users;
    }

    public Map selectAllBooks(){
        return books;
    }

    private static class SingletonHelper {
        private static Database database;

        public static Database getInstance(){
            if(database == null){
                database = new Database();
            }
            return database;
        }
    }

    public static Database getInstance(){
        return SingletonHelper.getInstance();
    }
}
