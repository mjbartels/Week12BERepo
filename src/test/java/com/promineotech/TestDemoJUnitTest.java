package com.promineotech;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TestDemoJUnitTest {
	
	private TestDemo testDemo;

    // Step a: Initialize the testDemo object before each test
    @BeforeEach
    void setUp() {
        testDemo = new TestDemo();
    }

    // Step b: Change @Test to @ParameterizedTest
    @ParameterizedTest
    @MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForAddPositive")
    void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
        
        // Step e: Write the test
        if (!expectException) {
            assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
        } else {
            // Step f: Test for the thrown exception using assertThatThrownBy
            assertThatThrownBy(() -> testDemo.addPositive(a, b))
                .isInstanceOf(IllegalArgumentException.class);
        }
    }

 // Regular Test: Directly testing with specific pairs of positive numbers
    @Test
    void assertThatPairsOfPositiveNumbersAreAddedCorrectly() {
        assertThat(testDemo.addPositive(4, 5)).isEqualTo(9);
        assertThat(testDemo.addPositive(40, 50)).isEqualTo(90);
        assertThat(testDemo.addPositive(100, 200)).isEqualTo(300);
        // You can add more assertions as needed
    }
    // Step j: Parameter source method for the test cases
    static Stream<Arguments> argumentsForAddPositive() {
        return Stream.of(
            arguments(2, 4, 6, false),  // Test with both positive numbers
            arguments(1, 5, 6, false),  // Another test with both positive numbers
            arguments(-1, 5, 0, true),  // Test with a negative number
            arguments(0, 3, 0, true),   // Test with zero
            arguments(10, 0, 0, true)   // Another test with zero
        );
    }

    // a. Test method with package visibility
    @Test
    void assertThatNumberSquaredIsCorrect() {
        // b. Use Mockito.spy to mock the TestDemo class
        TestDemo mockDemo = spy(testDemo);

        // c. Mock the getRandomInt() method to return 5
        doReturn(5).when(mockDemo).getRandomInt();

        // d. Call the randomNumberSquared method
        int fiveSquared = mockDemo.randomNumberSquared();

        // e. Assert that the result is 25 (since 5^2 = 25)
        assertThat(fiveSquared).isEqualTo(25);
    }
}
