package com.tma.usecases;

import com.tma.models.User;
import com.tma.repositories.CommandRepository;
import com.tma.repositories.QueryRepository;
import com.tma.repositories.UserCommandRepository;
import com.tma.repositories.UserQueryRepository;

public class RegisterUser implements Usecase {

    private CommandRepository<User> userCommandRepository;

    public RegisterUser(User user){
        userCommandRepository = new UserCommandRepository(user);
    }

    public void createUser(){
        userCommandRepository.save();
    }

    @Override
    public void execute() {
        createUser();
    }
}
