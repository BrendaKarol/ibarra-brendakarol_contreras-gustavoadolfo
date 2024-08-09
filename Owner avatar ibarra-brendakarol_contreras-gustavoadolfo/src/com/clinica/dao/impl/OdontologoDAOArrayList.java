package com.clinica.dao.impl;

import com.clinica.dao.DAO;
import com.clinica.entidades.Odontologo;
import dao.IDAO;
import modelo.ODONTOLOGO;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementación del patrón DAO utilizando una ArrayList para almacenar temporalmente los datos de los odontólogos.

 * @author Brenda Karol Ibarra Carbajal
 * @version 1.0
 * @since 2024-08-09
 */

public class OdontologoDAOArrayList implements DAO<Odontologo> {

    private static final Logger logger = Logger.getLogger(OdontologoDAOArrayList.class);
    private List<Odontologo> odontologos = new ArrayList<>();

    @Override
    public void guardar(Odontologo odontologo) {
        odontologos.add(odontologo);
        logger.info("Odontólogo guardado correctamente: " + odontologo);
    }

    @Override
    public Odontologo buscarPorId(Integer id) {
        for (Odontologo odontologo : odontologos) {
            if (odontologo.getNumeroMatricula().equals(id)) {
                logger.info("Odontólogo encontrado: " + odontologo);
                return odontologo;
            }
        }
        logger.warn("No se encontró ningún odontólogo con el ID: " + id);
        return null;
    }

    @Override
    public void actualizar(Odontologo odontologo) {
        for (int i = 0; i < odontologos.size(); i++) {
            if (odontologos.get(i).getNumeroMatricula().equals(odontologo.getNumeroMatricula())) {
                odontologos.set(i, odontologo);
                logger.info("Odontólogo actualizado correctamente: " + odontologo);
                return;
            }
        }
        logger.warn("No se encontró ningún odontólogo con el ID: " + odontologo.getNumeroMatricula());
    }

    @Override
    public void eliminar(Integer id) {
        odontologos.removeIf(odontologo -> odontologo.getNumeroMatricula().equals(id));
        logger.info("Odontólogo eliminado con ID: " + id);
    }

    @Override
    public List<Odontologo> listarTodos() {
        logger.info("Listado de todos los odontólogos realizado correctamente");
        return new ArrayList<>(odontologos);
    }
}
