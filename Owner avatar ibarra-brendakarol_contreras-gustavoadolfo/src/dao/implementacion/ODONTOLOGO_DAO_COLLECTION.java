package dao.implementacion;

import dao.IDAO;
import modelo.ODONTOLOGO;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class ODONTOLOGO_DAO_COLLECTION implements IDAO<ODONTOLOGO> {
    private static final Logger logger = Logger.getLogger(ODONTOLOGO_DAO_COLLECTION.class);
    private List<ODONTOLOGO> odontologos = new ArrayList<>();

    @Override
    public ODONTOLOGO guardar(ODONTOLOGO odontologo) {
        odontologos.add(odontologo);
        logger.info("Odontologo guardado en la colección");
        return odontologo;
    }

    @Override
    public List<ODONTOLOGO> listarTodos() {
        logger.info("Odontologos listados desde la colección");
        return odontologos;
    }
}