package org.example.dao;

import java.util.List;

public interface DAO<T> {

    public List<T> findAll();

}
