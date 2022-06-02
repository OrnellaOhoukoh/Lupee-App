package com.ornella.lupee_accounting.entities;

public class Operation {
    private int id;
    private String name;
    private float amount;
    private int id_user;

    public Operation() {
    }

    public Operation(int id, float amount, int id_user) {
        this.id = id;
        this.amount = amount;
        this.id_user = id_user;
    }

    public Operation(int id, float amount) {
        this.id = id;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }
}
