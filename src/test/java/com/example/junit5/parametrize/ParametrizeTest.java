package com.example.junit5.parametrize;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.platform.commons.util.StringUtils;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParametrizeTest {

    static Stream<Arguments> arguments = Stream.of(
        Arguments.of(null, true), // null strings should be considered blank
        Arguments.of("", true),
        Arguments.of("  ", true),
        Arguments.of("not blank", false)
    );

    @ParameterizedTest
    @VariableSource("arguments")
    void isBlank_ShouldReturnTrueForNullOrBlankStringsVariableSource(
        String input, boolean expected) {
        assertEquals(expected, StringUtils.isBlank(input));
    }
}
