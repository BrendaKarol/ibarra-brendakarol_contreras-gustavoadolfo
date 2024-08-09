package com.clinica;

import com.clinica.dao.DAO;
import com.clinica.dao.impl.OdontologoDAOArrayList;
import com.clinica.entidades.Odontologo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * Implementación del patrón DAO utilizando una ArrayList para almacenar temporalmente los datos de los odontólogos.

 * @author Brenda Karol Ibarra Carbajal
 * @version 1.0
 * @since 2024-08-09
 */


public class OdontologoDAOTest {

    private DAO<Odontologo> odontologoDAO;

    @BeforeEach
    public void setUp() {
        odontologoDAO = new OdontologoDAOArrayList();
    }

    @Test
    public void testListarTodos() throws Exception {
        odontologoDAO.guardar(new Odontologo(101, "Pedro", "Gonzalez"));
        odontologoDAO.guardar(new Odontologo(102, "Ana", "Rodriguez"));

        List<Odontologo> odontologos = odontologoDAO.listarTodos();

        Assertions.assertEquals(2, odontologos.size());
    }
}
