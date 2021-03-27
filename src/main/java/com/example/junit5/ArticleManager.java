package com.example.junit5;

public class ArticleManager {
  private User user;
  private ArticleDatabase database;

  public ArticleManager(User user, ArticleDatabase database) {
    super();
    this.user = user;
    this.database = database;
  }

  public void initialize() {
    database.addListener(new ArticleListener());
  }
}
