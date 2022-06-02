package com.ornella.lupee_accounting.entities;

public class User {

    private int id;
    private String login;
    private String password;
    private int user_category;
    private float acct_balance;

    public User() {
    }

    public User(int id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
    }

    public User(int id, float acct_balance) {
        this.id = id;
        this.acct_balance = acct_balance;
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUser_category() {
        return user_category;
    }

    public void setUser_category(int user_category) {
        this.user_category = user_category;
    }

    public float getAcct_balance() {
        return acct_balance;
    }

    public void setAcct_balance(float acct_balance) {
        this.acct_balance = acct_balance;
    }
}
