package com.example.junit5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class ParameterExampleTest {

  public static int[][] data() {
    return new int[][] {{1, 2, 2}, {5, 3, 15}, {121, 4, 484}};
  }

  @ParameterizedTest
  @MethodSource(value = "data")
  void testWithStringParameter(int[] data) {
    MyClass tester = new MyClass();
    int m1 = data[0];
    int m2 = data[1];
    int expected = data[2];
    assertEquals(expected, tester.multiply(m1, m2));
  }

  // class to be tested
  class MyClass {
    public int multiply(int i, int j) {
      return i * j;
    }
  }

  @ParameterizedTest
  @ValueSource(ints = {1, 12, 42})
  void testWithExplicitArgumentConversion(
      @ConvertWith(ToOctalStringArgumentConverter.class) String argument) {
    System.err.println(argument);
    Assertions.assertNotNull(argument);
  }

  static class ToOctalStringArgumentConverter extends SimpleArgumentConverter {
    @Override
    protected Object convert(Object source, Class<?> targetType) {
      assertEquals(Integer.class, source.getClass(), "Can only convert from Integers.");
      assertEquals(String.class, targetType, "Can only convert to String");
      return Integer.toOctalString((Integer) source);
    }
  }
}
