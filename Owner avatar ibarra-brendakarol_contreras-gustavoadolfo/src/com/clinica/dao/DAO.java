package com.clinica.dao;

import java.util.List;

/**
 * Implementación del patrón DAO utilizando una ArrayList para almacenar temporalmente los datos de los odontólogos.

 * @author Brenda Karol Ibarra Carbajal
 * @version 1.0
 * @since 2024-08-09
 */
public interface DAO<T> {
    void guardar(T t) throws Exception;
    T buscarPorId(Integer id) throws Exception;
    void actualizar(T t) throws Exception;
    void eliminar(Integer id) throws Exception;
    List<T> listarTodos() throws Exception;
}
