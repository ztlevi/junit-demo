package com.example.junit5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Properties;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class MockitoThrowsTest {

  // demonstrates the configuration of a throws with Mockito
  // not a read test, just "testing" Mockito behavior
  @Test
  public void testMockitoThrows() {
    Properties properties = Mockito.mock(Properties.class);

    when(properties.get(Mockito.anyString())).thenThrow(new IllegalArgumentException("Stuff"));

    Throwable exception = assertThrows(IllegalArgumentException.class, () -> properties.get("A"));

    assertEquals("Stuff", exception.getMessage());
  }

  @Test
  public void testForIOException() throws IOException {
    // create an configure mock
    OutputStream mockStream = mock(OutputStream.class);
    doThrow(new IOException()).when(mockStream).close();

    // use mock
    OutputStreamWriter streamWriter = new OutputStreamWriter(mockStream);

    assertThrows(IOException.class, () -> streamWriter.close());
  }
}
