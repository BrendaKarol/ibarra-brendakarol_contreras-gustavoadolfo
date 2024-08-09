package com.clinica;

import com.clinica.dao.DAO;
import com.clinica.dao.impl.OdontologoDAOArrayList;
import com.clinica.entidades.Odontologo;
import org.apache.log4j.BasicConfigurator;

/**
 * Implementación del patrón DAO utilizando una ArrayList para almacenar temporalmente los datos de los odontólogos.

 * @author Brenda Karol Ibarra Carbajal
 * @version 1.0
 * @since 2024-08-09
 */

public class Main {

    public static void main(String[] args) throws Exception {
        BasicConfigurator.configure();

        DAO<Odontologo> odontologoDAO = new OdontologoDAOArrayList();

        Odontologo odontologo1 = new Odontologo(101, "Pedro", "Gonzalez");
        Odontologo odontologo2 = new Odontologo(102, "Ana", "Rodriguez");

        odontologoDAO.guardar(odontologo1);
        odontologoDAO.guardar(odontologo2);

        odontologoDAO.listarTodos().forEach(System.out::println);

        odontologoDAO.eliminar(101);

        odontologoDAO.listarTodos().forEach(System.out::println);
    }
}
