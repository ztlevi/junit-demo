package com.example.junit5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.*;

public class CalculatorTest {

  private Calculator calculator;

  @BeforeEach
  public void setUp() throws Exception {
    calculator = new Calculator();
  }

  @Test
  @DisplayName("Simple multiplication should work")
  public void testMultiply() {
    assertEquals(20, calculator.multiply(4, 5), "Regular multiplication should work");
  }

  @Test
  @DisplayName("Test on specific OS")
  public void testOnCondition() {
    Assumptions.assumeTrue(System.getProperty("os.name").contains("Mac OS X"));
    assertEquals(0, calculator.multiply(0, 5), "Multiple with zero should be zero");
  }

  @RepeatedTest(5)
  @DisplayName("Ensure correct handling of zero")
  public void testMultiplyWithZero() {
    assertEquals(0, calculator.multiply(0, 5), "Multiple with zero should be zero");
    assertEquals(0, calculator.multiply(5, 0), "Multiple with zero should be zero");
  }

  @Test
  void exceptionTesting() {
    Throwable exception = assertThrows(IllegalArgumentException.class, () -> calculator.multiply(10000, 2));
    //    assertEquals("Age must be an Integer.", exception.getMessage());
  }
}
