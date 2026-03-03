package com.docencia.model;

import java.time.LocalDate;
import java.util.Objects;

public class Profesor extends Persona{
    private String departamento;

    /**
     * Constructor con id
     * @param id identificador unico
     */
    public Profesor(int id) {
        super(id);
    }

    /**
     * Contructor por defecto
     * @param id identificador
     * @param nombre nombre de la persona
     * @param documento documento de identidad
     * @param email email
     * @param fechaNacimiento fecha de nacimiento
     * @param fechaRegistro fecha de registro
     * @param departamento departamento
     */
    public Profesor(int id, String nombre, String documento, String email, LocalDate fechaNacimiento,
            LocalDate fechaRegistro, String departamento) {
        super(id, nombre, documento, email, fechaNacimiento, fechaRegistro);
        this.departamento = departamento;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + Objects.hash(getId());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Profesor other = (Profesor) obj;
        return Objects.equals(this.getId(), other.getId());
    }

    @Override
    public String getTipo(){
        return "Profesor\n";
    }
}
