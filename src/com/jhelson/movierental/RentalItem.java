package com.jhelson.movierental;

public class RentalItem {
    private String itemName;
    private String itemID;
    private boolean available = true;

    public RentalItem(String itemID, String itemName) {
        this.itemID = itemID;
        this.itemName = itemName;
        this.available = true;
    }

    public String getItemName() { return itemName; }
    public void setItemName(String itemName) { this.itemName = itemName; }
    public String getItemID() { return itemID; }
    public void setItemID(String itemID) { this.itemID = itemID; }
    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }

    public String showDetails() {
        return "ID: " + itemID + " | Título: " + itemName + " | Disponible: " + (available ? "Sí" : "No");
    }
}