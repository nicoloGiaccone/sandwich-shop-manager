////////////////////////////////////////////////////////////////////
// Nicolò Giaccone 1171208
////////////////////////////////////////////////////////////////////
package it.unipd.tos.model;

public class MenuItem {
    public enum itemType {Panini, Fritti, Bevande}

    private itemType type;
    private String name;
    private double price;

    public MenuItem(itemType t, String n, double p) {
        type = t;
        name = n;
        price = p;
    }

    public itemType getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }
}
