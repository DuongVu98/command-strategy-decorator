package com.tma.repositories;

import com.tma.repositories.strategies.QueryStrategy;

import java.util.List;

public interface QueryRepository<T>{
    void setQueryStrategy(QueryStrategy<T> queryStrategy);
    T findOne(String id);
    List<T> query(String str);
}
