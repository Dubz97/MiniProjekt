package com.miniprojekt.model;

public class Joined {
    private int accountid;
    private int id;
    private String wish;

    @Override
    public String toString() {
        return "Joined{" +
                "accountid=" + accountid +
                ", id=" + id +
                ", wish='" + wish + '\'' +
                '}';
    }

    public Joined(int accountid, int id, String wish) {
        this.accountid = accountid;
        this.id = id;
        this.wish = wish;
    }

    public int getAccountid() {
        return accountid;
    }

    public void setAccountid(int accountid) {
        this.accountid = accountid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWish() {
        return wish;
    }

    public void setWish(String wish) {
        this.wish = wish;
    }
}
