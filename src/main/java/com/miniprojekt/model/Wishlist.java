package com.miniprojekt.model;

public class Wishlist {

private int id;

private String wish;
private int quantity;


  public Wishlist(int id, String wish, int quantity) {
    this.id = id;
    this.wish = wish;
    this.quantity = quantity;
  }
  public Wishlist() {}

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

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  @Override
  public String toString() {
    return "Wishlist{" +
            "id=" + id +
            ", wish='" + wish + '\'' +
            ", quantity=" + quantity +
            '}';
  }
}
