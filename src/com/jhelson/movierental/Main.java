package com.jhelson.movierental;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SistemaRenta sistema = new SistemaRenta();

        // Datos iniciales para probar rápido
        sistema.addItem(new Movie("P001", "La ciudad y los perros", "Francisco Lombardi", 137, "14+", "Drama"));
        sistema.addItem(new Movie("P002", "Asu Mare", "Ricardo Maldonado", 100, "PG", "Comedia"));
        sistema.registrarCliente(new Cliente("C001", "Jhelson"));
        sistema.registrarCliente(new Cliente("C002", "María"));

        while (true) {
            System.out.println("\n--- Sistema de Renta de Películas ---");
            System.out.println("1) Agregar película");
            System.out.println("2) Registrar cliente");
            System.out.println("3) Rentar película");
            System.out.println("4) Devolver película");
            System.out.println("5) Mostrar todas las películas");
            System.out.println("6) Mostrar todos los clientes");
            System.out.println("0) Salir");
            System.out.print("Opción: ");

            String opStr = sc.nextLine().trim();
            int op;
            try { op = Integer.parseInt(opStr); } catch (Exception e) { System.out.println("Opción inválida."); continue; }

            switch (op) {
                case 1:
                    System.out.print("ID: ");
                    String id = sc.nextLine().trim();
                    System.out.print("Título: ");
                    String titulo = sc.nextLine().trim();
                    System.out.print("Director: ");
                    String director = sc.nextLine().trim();
                    System.out.print("Duración (min): ");
                    int dur;
                    try { dur = Integer.parseInt(sc.nextLine().trim()); } catch (Exception e) { System.out.println("Duración inválida."); break; }
                    System.out.print("Clasificación: ");
                    String clasif = sc.nextLine().trim();
                    System.out.print("Género: ");
                    String genero = sc.nextLine().trim();
                    boolean agregado = sistema.addItem(new Movie(id, titulo, director, dur, clasif, genero));
                    System.out.println(agregado ? "Película agregada." : "Ya existe un ítem con ese ID.");
                    break;

                case 2:
                    System.out.print("ID cliente: ");
                    String cid = sc.nextLine().trim();
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine().trim();
                    boolean reg = sistema.registrarCliente(new Cliente(cid, nombre));
                    System.out.println(reg ? "Cliente registrado." : "Ya existe un cliente con ese ID.");
                    break;

                case 3:
                    System.out.print("ID película a rentar: ");
                    String rid = sc.nextLine().trim();
                    System.out.print("ID cliente: ");
                    String rcid = sc.nextLine().trim();
                    boolean ok = sistema.rentarPeliculaACliente(rid, rcid);
                    System.out.println(ok ? "Renta realizada." : "No se pudo rentar (verifica IDs o disponibilidad).");
                    break;

                case 4:
                    System.out.print("ID película a devolver: ");
                    String did = sc.nextLine().trim();
                    System.out.print("ID cliente: ");
                    String dcid = sc.nextLine().trim();
                    boolean dev = sistema.devolverPelicula(did, dcid);
                    System.out.println(dev ? "Devolución registrada." : "No se pudo devolver (verifica IDs o si el cliente la tenía).");
                    break;

                case 5:
                    sistema.mostrarTodosLosItems();
                    break;

                case 6:
                    sistema.mostrarTodosLosClientes();
                    break;

                case 0:
                    System.out.println("Gracias. ¡Chau!");
                    return;

                default:
                    System.out.println("Opción inválida.");
            }
        }
    }
}