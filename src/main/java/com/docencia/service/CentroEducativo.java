package com.docencia.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.docencia.model.Alumno;
import com.docencia.model.Persona;
import com.docencia.model.Profesor;
import com.docencia.util.Validaciones;

public class CentroEducativo {
    private List<Persona> personas;
    private Set<String> documentosRegistrados;
    private Set<String> emailsRegistrados;

    /**
     * Constructor por defecto
     */
    public CentroEducativo() {
        personas = new ArrayList<>();
        documentosRegistrados = new HashSet<>();
        emailsRegistrados = new HashSet<>();
    }

    /**
     * Lista todas las personas
     * @return lista de personas
     */
    public List<Persona> listarPersonas(){
        return List.copyOf(personas);
    }

    /**
     * Busca a una persona por id
     * @param id el identificador unico
     * @return la persona
     */
    public Persona buscarPorId(int id) {
        Persona personaABuscar = new Alumno(id);
        int posicion = personas.indexOf(personaABuscar);
        if(posicion < 0){
            return null;
        }
        return personas.get(posicion);

    }

    /**
     * Lista alumnos en el centro
     * @return lista de alumnos
     */
    public List<Alumno> listarAlumnos() {
        List<Alumno> alumnos = new ArrayList<>();
        for (Persona persona : personas) {
           if(persona instanceof Alumno){
                alumnos.add((Alumno) persona);
           } 
        }
        return alumnos;
    }

    /**
     * Registra un profesor en el centro
     * @return true / false
     */
    public List<Profesor> listarProfesores() {
        List<Profesor> profesores = new ArrayList<>();
        for (Persona persona : personas) {
           if(persona instanceof Profesor){
                profesores.add((Profesor) persona);
           } 
        }
        return profesores;
    }

    /**
     * Registra una nueva persona en el centro
     * @param persona la persona a registrar
     * @return true / false
     */
    public boolean registrarPersona(Persona persona){
        if(persona == null || persona.getId() <= 0){
            return false;
        }
        if(personas.contains(persona)) {
            return false;
        }
        if(emailsRegistrados.contains(persona.getEmail())){
            return false;
        }
        if(documentosRegistrados.contains(persona.getDocumento())){
            return false;
        }
        if(!Validaciones.documentoValido(persona.getDocumento())){
            throw new IllegalArgumentException("El documento tiene un formato incorrecto");
        }
        if(!Validaciones.emailValido(persona.getEmail())){
            throw new IllegalArgumentException("El email tiene un formato incorrecto");
        }
        documentosRegistrados.add(persona.getDocumento());
        emailsRegistrados.add(persona.getEmail());
        return personas.add(persona);
    }

    /**
     * Busca a una persona por su documento de identidad
     * @param documento el documento de identidad
     * @return persona
     */
    public Persona buscarPorDocumento(String documento) {
        if(documento == null || documento.isBlank()) {
            return null;
        }
        if(!documentosRegistrados.contains(documento)) {
            return null;
        }

        for (Persona persona : personas) {
            if(persona.getDocumento().equals(documento)){
                return persona;
            }
        }
        return null;
    }

    /**
     * Busca a una persona por un prefijo que coincida con su nombre
     * @param index indice de la lista donde empieza a buscar pref. (0)
     * @param prefijo prefijo
     * @return lista de personas coincidentes
     */
    public List<Persona> buscarPorPrefijo(int index, String prefijo) {
        
        if(index >= personas.size()) {
            return new ArrayList<>();
        }
        List<Persona> encontrados = new ArrayList<>();
        
        Pattern patron = Pattern.compile("^"+prefijo);
        Matcher matcher = patron.matcher(personas.get(index).getNombre());

        if(matcher.find()){
            encontrados.add(personas.get(index));
        }
        encontrados.addAll(buscarPorPrefijo(index+1, prefijo));
        return encontrados;
    }

    /**
     * Lista mayores de la edad dada
     * @param edad edad dada
     * @return lista de personas
     */
    public List<Persona> listarMayores(int edad){

        if(edad < 0){
            throw new IllegalArgumentException();
        }
        List<Persona> mayores = new ArrayList<>();
        for (Persona persona : personas) {
            if((LocalDate.now().getYear() - persona.getFechaNacimiento().getYear()) > edad ){
                mayores.add(persona);
            }
        }
        return mayores;
    }
}
