package com.docencia.util;

import java.util.regex.Pattern;

public class Validaciones {

    /**
     * Comprueba con regex que el email sea valido
     * @return true / false
     */
    public static boolean emailValido(String email){
        if(email == null || email.isBlank()){
            throw new IllegalArgumentException();
        }
        String patron = "[a-zA-Z0-9\\._%-]+@[a-z\\.]+\\.[a-z]{2,}";
        return Pattern.matches(patron, email);
    }

    /**
     * Comprueba con regex que el documento sea valido
     * @return true / false
     */
    public static boolean documentoValido(String documento){
        if(documento == null || documento.isBlank()){
            throw new IllegalArgumentException();
        }
        documento.trim().toUpperCase();
        String patron = "([A-Z])?([0-9]{8}[A-Z])";
        return Pattern.matches(patron, documento);
    }
}
