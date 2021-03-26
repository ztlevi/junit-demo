package com.example.junit5;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ServiceTest {

  @Mock Database databaseMock;

  @Test
  public void testQuery() {
    Database databaseMock2 = mock(Database.class);

    assertNotNull(databaseMock);
    // Configure the Mock to return true when its isAvailable method is called
    when(databaseMock.isAvailable()).thenReturn(true);
    Service t = new Service(databaseMock);
    boolean check = t.query("* from t");
    assertTrue(check);
  }
}
