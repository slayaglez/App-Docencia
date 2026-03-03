package com.docencia.app;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.docencia.model.Alumno;
import com.docencia.model.Persona;
import com.docencia.model.Profesor;
import com.docencia.service.CentroEducativo;

public class Main {
    static CentroEducativo centroEducativo;

    private static void imprimirMenu() {
        System.out.println("\n===== CENTRO EDUCATIVO =====");
        System.out.println("1) Registrar alumno");
        System.out.println("2) Registrar profesor");
        System.out.println("3) Listar personas");
        System.out.println("4) Buscar por ID");
        System.out.println("5) Buscar por documento");
        System.out.println("6) Listar mayores de X");
        System.out.println("7) Buscar por prefijo");
        System.out.println("0) Salir");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CentroEducativo centro = new CentroEducativo();
        int op;
        do {
            imprimirMenu();
            System.out.print("Opción: ");

            String linea = sc.nextLine();
            try {
                op = Integer.parseInt(linea.trim());
            } catch (NumberFormatException e) {
                System.out.println("Opción inválida. Introduce un número.");
                op = -1;
            }
            try {
                switch (op) {
                    case 1 -> registrarAlumno(sc, centro);
                    case 2 -> registrarProfesor(sc, centro);
                    case 3 -> listarPersonas(centro);
                    case 4 -> buscarPorId(sc, centro);
                    case 5 -> buscarPorDocumento(sc, centro);
                    case 6 -> listarMayores(sc, centro);
                    case 7 -> buscarPorPrefijo(sc, centro);
                    case 0 -> System.out.println("Saliendo...");
                    default -> System.out.println("Opción no reconocida.");
                }
            } catch (Exception e) {
                System.out.println("ERROR: " + e.getMessage());
            }
        } while (op != 0);
        sc.close();
    }

    private static void registrarAlumno(Scanner sc, CentroEducativo centro) {
        System.out.println("\n--- Registro Alumno ---");
        System.out.print("ID: ");
        int id = Integer.parseInt(sc.nextLine().trim());
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Documento: ");
        String documento = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Fecha nacimiento (YYYY-MM-DD): ");
        LocalDate fechaNacimiento = LocalDate.parse(sc.nextLine().trim());
        LocalDate fechaRegistro = LocalDate.now();
        System.out.print("Curso: ");
        String curso = sc.nextLine();
        Alumno alumno = new Alumno(id, nombre, documento, email,
                fechaNacimiento, fechaRegistro, curso);
        centro.registrarPersona(alumno);
        System.out.println("Alumno registrado.");
    }

    private static void registrarProfesor(Scanner sc, CentroEducativo centro) {
        System.out.println("\n--- Registrar Profesor ---");
        System.out.print("ID: ");
        int id = Integer.parseInt(sc.nextLine().trim());
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Documento: ");
        String documento = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Fecha nacimiento (YYYY-MM-DD): ");
        LocalDate fechaNacimiento = LocalDate.parse(sc.nextLine().trim());
        LocalDate fechaRegistro = LocalDate.now();
        System.out.print("Departamento: ");
        String departamento = sc.nextLine();
        Profesor profesor = new Profesor(id, nombre, documento, email,
                fechaNacimiento, fechaRegistro, departamento);
        centro.registrarPersona(profesor);
        System.out.println("Profesor registrado.");
    }

    private static void listarPersonas(CentroEducativo centro) {
        System.out.println("\n--- Listado de personas ---");
        List<Persona> personas = centro.listarPersonas();

        if (personas.isEmpty()) {
            System.out.println("(vacío)");
            return;
        }
        for (Persona persona : personas) {
            persona.getTipo();
            System.out.println(persona);
        }
    }

    private static void buscarPorId(Scanner sc, CentroEducativo centro) {
        System.out.println("\n--- Buscar por ID ---");
        System.out.print("ID: ");
        int id = Integer.parseInt(sc.nextLine().trim());
        Persona persona = centro.buscarPorId(id);
        System.out.println(persona == null ? "No existente" : persona.toString());
    }

    private static void buscarPorDocumento(Scanner sc, CentroEducativo centro) {
        System.out.println("\n--- Buscar por documento ---");
        System.out.print("Documento: ");
        String documento = sc.nextLine();
        Persona persona = centro.buscarPorDocumento(documento);
        System.out.println(persona == null ? "No existente" : persona.toString());
    }

    private static void listarMayores(Scanner sc, CentroEducativo centro) {
        System.out.println("\n--- Listar mayores de: ---");
        System.out.print("Edad: ");
        String edad = sc.nextLine();
        int edadInt = Integer.parseInt(edad);
        List<Persona> mayores = centro.listarMayores(edadInt);
        System.out.println(mayores.isEmpty() ? "No hay integrantes mayores de esa edad" : mayores.toString());
    }

    private static void buscarPorPrefijo(Scanner sc, CentroEducativo centro) {
        System.out.println("\n--- Buscar por prefijo ---");
        System.out.print("Prefijo (primera mayúscula): ");
        String prefijo = sc.nextLine();
        List<Persona> listado = centro.buscarPorPrefijo(0, prefijo);
        System.out.println(listado.isEmpty() ? "No existente" : listado.toString());
    }
}
