package com.example.junit5;

public class Database {

  private int id;

  public boolean isAvailable() {
    // TODO implement the access to the database
    return false;
  }

  public int getUniqueId() {
    return id;
  }

  public void setUniqueId(int eq) {
    this.id = eq;
  }
}
