package com.tma.repositories;

import com.tma.database.Database;
import com.tma.models.User;

public class UserCommandRepository implements CommandRepository<User> {

    private User user;
    private Database database = Database.getInstance();
    public UserCommandRepository(User user) {
        this.user = user;
    }

    @Override
    public User getOne() {
        return user;
    }

    @Override
    public void setOne(User user) {
        this.user = user;
    }

    @Override
    public void save() {
        database.users.put(user.getId(), user);
    }

    @Override
    public void edit() {
        database.users.remove(user.getId());
        database.users.put(user.getId(), user);
    }

    @Override
    public void delete() {
        database.users.remove(user.getId());
    }
}
