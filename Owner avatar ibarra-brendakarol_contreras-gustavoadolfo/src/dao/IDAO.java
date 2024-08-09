package dao;

// src/dao/IDAO.java


import java.util.List;

public interface IDAO<T> {
    T guardar(T t);
    List<T> listarTodos();
}

