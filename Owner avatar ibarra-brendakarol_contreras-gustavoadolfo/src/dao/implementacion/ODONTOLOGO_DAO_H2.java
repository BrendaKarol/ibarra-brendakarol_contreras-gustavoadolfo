package dao.implementacion;

import dao.IDAO;
import modelo.ODONTOLOGO;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ODONTOLOGO_DAO_H2 implements IDAO<ODONTOLOGO> {
    private static final Logger logger = Logger.getLogger(ODONTOLOGO_DAO_H2.class);
    private static final String URL = "jdbc:h2:../jars/";

    static {
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            logger.error("Error al cargar el controlador H2", e);
        }
    }

    @Override
    public ODONTOLOGO guardar(ODONTOLOGO odontologo) {
        try (Connection connection = DriverManager.getConnection(URL, "sa", "")) {
            PreparedStatement ps = connection.prepareStatement(
                    "INSERT INTO ODONTOLOGO (NUMERO_MATRICULA, NOMBRE, APELLIDO) VALUES (?, ?, ?)");
            ps.setString(1, odontologo.getNumeroMatricula());
            ps.setString(2, odontologo.getNombre());
            ps.setString(3, odontologo.getApellido());
            ps.executeUpdate();
            logger.info("Odontologo guardado en la base de datos");
        } catch (Exception e) {
            logger.error("Error al guardar odontologo en la base de datos", e);
        }
        return odontologo;
    }

    @Override
    public List<ODONTOLOGO> listarTodos() {
        List<ODONTOLOGO> odontologos = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL, "sa", "")) {
            ResultSet rs = connection.createStatement().executeQuery("SELECT * FROM ODONTOLOGO");
            while (rs.next()) {
                odontologos.add(new ODONTOLOGO(
                        rs.getString("NUMERO_MATRICULA"),
                        rs.getString("NOMBRE"),
                        rs.getString("APELLIDO")
                ));
            }
            logger.info("Odontologos listados desde la base de datos");
        } catch (Exception e) {
            logger.error("Error al listar odontologos desde la base de datos", e);
        }
        return odontologos;
    }
}
