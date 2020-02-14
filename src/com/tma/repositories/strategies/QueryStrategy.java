package com.tma.repositories.strategies;

import java.util.List;

public interface QueryStrategy<T> {
    List<T> query(String str);
}
