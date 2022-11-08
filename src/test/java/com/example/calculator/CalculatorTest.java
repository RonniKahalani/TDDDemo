package com.example.calculator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.TestInstance.*;
import static org.mockito.Mockito.when;

@TestInstance(Lifecycle.PER_CLASS)
public class CalculatorTest {

    @Mock
    private NumberSource numberSource;

    private Calculator cut;

    @BeforeAll
    public void beforeAll() {

        MockitoAnnotations.openMocks(this);
    }

    @BeforeEach
    public void beforeEach() {

        cut = new Calculator(numberSource);
    }

    @ParameterizedTest
    @ValueSource(longs = {1L, 10L, 100L, Long.MAX_VALUE})
    public void calculator_Multiply_PositiveAndPositive_ReturnPositive(long value) {
        // Arrange.
        when(numberSource.next()).thenReturn( value, value);
        // Act.
        long result = cut.multiply();
        // Assert.
        assertTrue( result > 0);
    }

    @ParameterizedTest
    @ValueSource(longs = {1L, 10L, 100L, Long.MAX_VALUE})
    public void calculator_Multiply_NegativeAndPositive_ReturnsNegative(long value) {
        // Arrange.
        when(numberSource.next()).thenReturn( -value, value);
        // Act.
        long result = cut.multiply();
        // Assert.
        assertTrue(result < 0);
    }

    @ParameterizedTest
    @ValueSource(longs = {1L, 10L, 100L, Long.MAX_VALUE})
    public void calculator_Multiply_PositiveAndNegative_ReturnsNegative(long value) {
        // Arrange.
        when(numberSource.next()).thenReturn( value, -value);
        // Act.
        long result = cut.multiply();
        // Assert.
        assertTrue(result < 0);
    }

    @ParameterizedTest
    @ValueSource(longs = {1L, 10L, 100L, Long.MAX_VALUE})
    public void calculator_Multiply_NegativeAndNegative_ReturnsPositive(long value) {
        // Arrange.
        when(numberSource.next()).thenReturn( -value, -value);
        // Act.
        long result = cut.multiply();
        // Assert.
        assertTrue(result > 0);
    }
}
