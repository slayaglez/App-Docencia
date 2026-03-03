package com.docencia.model;

import java.time.LocalDate;
import java.util.Objects;
import java.util.regex.Pattern;

import com.docencia.util.Validaciones;

public abstract class Persona{

    private final int id;
    private String nombre;
    private String documento;
    private String email;
    private LocalDate fechaNacimiento;
    private final LocalDate fechaRegistro;

    public Persona(int id){
        if(id <= 0) {
            throw new IllegalArgumentException();
        }
        this.id = id;
        this.fechaRegistro = LocalDate.now();
    }

    /**
     * Constructor con id
     * @param id identificador unico
     */
    public Persona(int id, LocalDate fechaRegistro){
        if(id <= 0) {
            throw new IllegalArgumentException();
        }
        this.id = id;
        this.fechaRegistro = fechaRegistro;
    }

    /**
     * Constructor por defecto
     * @param id identificador unico
     * @param nombre nombre de la persona
     * @param documento documento de identidad
     * @param email direccion de correo
     * @param fechaNacimiento fecha de nacimiento LocalDate
     * @param fechaRegistro fecha de registro LocalDate
     */
    public Persona(int id, String nombre, String documento, String email, LocalDate fechaNacimiento, LocalDate fechaRegistro) {
        if(id <= 0) {
            throw new IllegalArgumentException();
        }
        if(nombre == null || nombre.length() < 2){
            throw new IllegalArgumentException();
        }
        if(fechaNacimiento == null || fechaNacimiento.isAfter(LocalDate.now())){
            throw new IllegalArgumentException();
        }
        if(fechaRegistro == null || fechaRegistro.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException();
        }
        this.id = id;
        this.nombre = nombre.trim();
        this.documento = documento;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaRegistro = fechaRegistro;
    }

    // GETTERS
    public final int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public final LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    // SETTERS
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDocumento(String documento) {

        Validaciones.documentoValido(documento);
        this.documento = documento;
    }

    public void setEmail(String email) {
        Validaciones.emailValido(email);
        this.email = email;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Persona other = (Persona) obj;
        return id == other.id;
    }

    /**
     * Devuelve la edad de una persona
     * @return edad actual
     */
    public int edad(){
        int edad = LocalDate.now().getYear() - getFechaNacimiento().getYear();
        return edad;
    }

    @Override
    public String toString() {
        return "\n==============================\n"+ getTipo() +"id = " + id + "\nnombre = " + nombre + "\ndocumento = " + documento + "\nemail = " + email
                + "\nfechaNacimiento = " + fechaNacimiento + "\nfechaRegistro = " + fechaRegistro + "\n==============================\n";
    }    

    public String getTipo(){
        return "";
    }
}
