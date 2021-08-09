package com.example.junit5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

class PropertyManager {
  Properties properties;

  public PropertyManager(Properties properties) {
    this.properties = properties;
  }

  public void printProperties() {
    // System.out.println(this.properties.setProperty("a", "a"));
    System.out.println(this.properties.toString());
  }
}

@ExtendWith(MockitoExtension.class)
class MockitoSpyTest {
  @Mock private Properties mockedProperties;

  // When you use dependency injection for this object
  @Spy
  @InjectMocks
  private Properties injectedSpiedProperties;

  // demonstrates of the spy function
  @Test
  public void testDifferenceBetweenMockAndSpy() {
    // Mocked object does not perform the actual function
    List<String> mocked = mock(LinkedList.class);
    mocked.add("dummy");
    verify(mocked).add("dummy");
    Assertions.assertEquals(mocked.size(), 0);

    // Spied object will perform the actual function
    List<String> spied = spy(LinkedList.class);
    spied.add("dummy");
    verify(spied).add("dummy");
    Assertions.assertEquals(spied.size(), 1);
  }

  @Test
  public void testMockitoSpy() {
    // Method 1: spy a created object
    // Properties properties = new Properties();
    // Properties spyProperties = spy(properties);

    // Method 2: spy a class
    // Method 3: use @Spy annotation
    Properties spyProperties = spy(Properties.class);

    doReturn("42").when(spyProperties).get("shoeSize");

    String value = (String) spyProperties.get("shoeSize");

    assertEquals("42", value);
  }

  @Test
  public void testMockitoSpyWithNestedMockedObject() {
    PropertyManager pm = new PropertyManager(mockedProperties);
    pm.printProperties();
  }

  @Test
  public void testLinkedListSpyCorrect() {
    // Lets spy a LinkedList
    List<String> spied = spy(LinkedList.class);

    // this would not work as delegate it called so spied.get(0)
    // throws IndexOutOfBoundsException (list is still empty)
    // when(spied.get(0)).thenReturn("foo");

    // you have to use doReturn() for stubbing
    doReturn("foo").when(spied).get(0);

    assertEquals("foo", spied.get(0));
  }
}
