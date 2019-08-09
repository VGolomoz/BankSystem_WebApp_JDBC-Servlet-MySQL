package project.DAO.interfaces;

import java.util.List;

public interface DAO<T> extends AutoCloseable {

    void create(T entity);

    T getById(int id);

    List<T> findAll();

    boolean update(T t);

    boolean delete(int id);

    @Override
    void close();
}
