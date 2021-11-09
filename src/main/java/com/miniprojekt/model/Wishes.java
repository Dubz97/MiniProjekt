package com.miniprojekt.model;

public class Wishes {


  private int idWish;
  private int idWishlist;
  private String description;
  private int quantity;



  public Wishes(int id, int idWishlist, String description, int quantity) {
    this.idWish = id;
    this.idWishlist = idWishlist;
    this.description = description;
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

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
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
        ", wish='" + description + '\'' +
        ", quantity=" + quantity +
        '}';
  }
}