package servicio;

import dao.IDAO;
import modelo.ODONTOLOGO;
import java.util.List;

public class ODONTOLOGO_SERVICE{

    private IDAO<ODONTOLOGO> odontologoIDAO;

    // Constructor
    public ODONTOLOGO_SERVICE(IDAO<ODONTOLOGO> odontologoIDAO) {
        this.odontologoIDAO = odontologoIDAO;
    }

    // Método para guardar un odontólogo
    public void guardarOdontologo(ODONTOLOGO odontologo) {
        odontologoIDAO.guardar(odontologo);
    }

    // Método para listar todos los odontólogos
    public List<ODONTOLOGO> listarTodosLosOdontologos() {
        return odontologoIDAO.listarTodos();
    }
}
