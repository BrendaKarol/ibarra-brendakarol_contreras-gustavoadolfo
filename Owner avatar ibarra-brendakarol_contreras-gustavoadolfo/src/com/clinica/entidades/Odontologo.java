package com.clinica.entidades;

/**
 * Implementación del patrón DAO utilizando una ArrayList para almacenar temporalmente los datos de los odontólogos.

 * @author Brenda Karol Ibarra Carbajal
 * @version 1.0
 * @since 2024-08-09
 */
public class Odontologo {
    private Integer numeroMatricula;
    private String nombre;
    private String apellido;

    // Constructor
    public Odontologo(Integer numeroMatricula, String nombre, String apellido) {
        this.numeroMatricula = numeroMatricula;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    // Getters y Setters
    public Integer getNumeroMatricula() {
        return numeroMatricula;
    }

    public void setNumeroMatricula(Integer numeroMatricula) {
        this.numeroMatricula = numeroMatricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    // Método toString
    @Override
    public String toString() {
        return "Odontologo{" +
                "numeroMatricula=" + numeroMatricula +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                '}';
    }
}
