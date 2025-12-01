package com.jhelson.movierental;

import java.util.ArrayList;
import java.util.List;

public class SistemaRenta {
    private List<RentalItem> items = new ArrayList<>();
    private List<Cliente> clientes = new ArrayList<>();

    public boolean addItem(RentalItem item) {
        if (buscarItemPorID(item.getItemID()) != null) return false;
        items.add(item);
        return true;
    }

    public boolean registrarCliente(Cliente c) {
        if (buscarClientePorID(c.getCustomerID()) != null) return false;
        clientes.add(c);
        return true;
    }

    public boolean rentarPeliculaACliente(String itemID, String customerID) {
        RentalItem item = buscarItemPorID(itemID);
        Cliente cli = buscarClientePorID(customerID);
        if (item == null || !(item instanceof Movie) || cli == null) return false;
        if (!item.isAvailable()) return false;
        item.setAvailable(false);
        cli.getRentedMovies().add(itemID);
        return true;
    }

    public boolean devolverPelicula(String itemID, String customerID) {
        RentalItem item = buscarItemPorID(itemID);
        Cliente cli = buscarClientePorID(customerID);
        if (item == null || cli == null) return false;
        boolean estaba = cli.getRentedMovies().remove(itemID);
        if (estaba) {
            item.setAvailable(true);
            return true;
        }
        return false;
    }

    public void mostrarTodosLosItems() {
        if (items.isEmpty()) {
            System.out.println("No hay ítems.");
            return;
        }
        for (RentalItem it : items) {
            System.out.println(it.showDetails());
        }
    }

    public void mostrarTodosLosClientes() {
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes.");
            return;
        }
        for (Cliente c : clientes) {
            System.out.println(c.showCustomerDetails());
        }
    }


    private RentalItem buscarItemPorID(String id) {
        for (RentalItem it : items) {
            if (it.getItemID().equals(id)) return it;
        }
        return null;
    }

    private Cliente buscarClientePorID(String id) {
        for (Cliente c : clientes) {
            if (c.getCustomerID().equals(id)) return c;
        }
        return null;
    }
}