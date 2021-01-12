
package com.solodovnikov.model.dao;

import java.sql.SQLException;
import java.util.List;

public interface AbstractDao<T> {

    List<T> findAll() throws SQLException;

    T find(Integer id) throws SQLException;

    void delete(Integer id) throws SQLException;

    void update(Integer id, T object) throws SQLException;

    void create(T object) throws SQLException;

}