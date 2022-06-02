package com.ornella.lupee_accounting.entities;

public class Invoice {
    String id;
    int itemsQtity;
    int totalPrice;

    public Invoice() {
    }

    public Invoice(String id, int itemsQtity, int totalPrice) {
        this.id = id;
        this.itemsQtity = itemsQtity;
        this.totalPrice = totalPrice;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getItemsQtity() {
        return itemsQtity;
    }

    public void setItemsQtity(int itemsQtity) {
        this.itemsQtity = itemsQtity;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
}
