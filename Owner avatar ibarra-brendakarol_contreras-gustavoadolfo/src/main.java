// src/main/Main.java


import dao.implementacion.ODONTOLOGO_DAO_H2;
import modelo.ODONTOLOGO;
import servicio.ODONTOLOGO_SERVICE;

public class main {
    public static void main(String[] args) {
        ODONTOLOGO_SERVICE serviceDB = new ODONTOLOGO_SERVICE(new ODONTOLOGO_DAO_H2());
        ODONTOLOGO_SERVICE serviceCollection = new ODONTOLOGO_SERVICE(new ODONTOLOGO_DAO_COLLECTION());

        ODONTOLOGO odontologo1 = new ODONTOLOGO("12345", "Juan", "Perez");
        ODONTOLOGO odontologo2 = new ODONTOLOGO("67890", "Ana", "Gomez");

        serviceDB.guardarOdontologo(odontologo1);
        serviceDB.guardarOdontologo(odontologo2);

        serviceCollection.guardarOdontologo(odontologo1);
        serviceCollection.guardarOdontologo(odontologo2);

        System.out.println("Odontologos desde la base de datos:");
        serviceDB.listarTodosLosOdontologos().forEach(o -> System.out.println(o.getNombre() + " " + o.getApellido()));

        System.out.println("Odontologos desde la colección:");
        serviceCollection.listarTodosLosOdontologos().forEach(o -> System.out.println(o.getNombre() + " " + o.getApellido()));
    }
}
