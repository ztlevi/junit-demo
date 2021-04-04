package com.example.junit5;

public class Utility {
  public static String getDatabaseConnection(String url) {
    return "http:///production/" + url;
  }
}
