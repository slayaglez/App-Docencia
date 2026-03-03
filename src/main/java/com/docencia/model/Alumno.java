package com.docencia.model;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

public class Alumno extends Persona{

    private String curso;
    private Set<String> modulos;

    public Alumno(int id){
        super(id);
    }

    /**
     * Constructor por defecto
     * @param id identificador unico
     * @param nombre nombre de la persona
     * @param documento documento de identidad
     * @param email direccion de correo
     * @param fechaNacimiento fecha de nacimiento LocalDate
     * @param fechaRegistro fecha de registro LocalDate
     * @param curso curso del alumno
     */
    public Alumno(int id, String nombre, String documento, String email, LocalDate fechaNacimiento, LocalDate fechaRegistro, String curso) {
        super(id, nombre, documento, email, fechaNacimiento, fechaRegistro);
        this.curso = curso;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
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
        Alumno other = (Alumno) obj;
        return Objects.equals(this.getId(), other.getId());
    }

    /**
     * Agrego un modulo
     * @param modulo el modulo a agregar
     * @return true / false
     */
    public boolean addModulo(String modulo){
        if(modulo == null || modulo.isBlank() || modulo.trim().length() <= 2){
            return false;
        }
        return modulos.add(modulo);
    }

    /**
     * Elimina un modulo
     * @param modulo modulo a eliminar
     * @return true / false
     */
    public boolean removeModulo(String modulo){
        return modulos.remove(modulo);
    }

    public Set<String> getModulos(){
        return modulos;
    }

    @Override
    public String getTipo(){
        return "Alumno\n";
    }
}
