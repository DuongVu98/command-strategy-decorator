package com.tma.repositories;

import com.tma.database.Database;
import com.tma.models.User;
import com.tma.repositories.strategies.QueryStrategy;

import java.util.List;

public class UserQueryRepository implements QueryRepository<User> {

    private Database database = Database.getInstance();

    @Override
    public void setQueryStrategy(QueryStrategy<User> queryStrategy) {

    }

    @Override
    public User findOne(String id) {
        return database.users.get(id);
    }

    @Override
    public List<User> query(String str) {
        return null;
    }
}
