package com.miniprojekt.model;

public class Wishes {


  private int idWish;
  private int idWishlist;
  private String wish;
  private int quantity;



  public Wishes(int id, int userId, String wish, int quantity) {
    this.idWish = id;
    this.idWishlist = userId;
    this.wish = wish;
    this.quantity = quantity;
  }
  public Wishes() {}

  public int getIdWishlist() {
    return idWishlist;
  }

  public void setIdWishlist(int idWishlist) {
    this.idWishlist = idWishlist;
  }

  public int getIdWish() {
    return idWish;
  }

  public void setIdWish(int idWish) {
    this.idWish = idWish;
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
        "id=" + idWish +
        ", userId=" + idWishlist +
        ", wish='" + wish + '\'' +
        ", quantity=" + quantity +
        '}';
  }
}