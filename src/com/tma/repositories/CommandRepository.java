package com.tma.repositories;

public interface CommandRepository<T> {
    T getOne();
    void setOne(T t);

    void save();
    void edit();
    void delete();
}
