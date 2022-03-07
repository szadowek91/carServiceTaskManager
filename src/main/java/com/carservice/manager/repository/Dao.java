package com.carservice.manager.repository;


import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface Dao<T> {

    T find(Long id);

    Collection<T> findAll();

    void save(T t);

    T update(T t);

    void delete(T t);

}
