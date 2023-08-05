package com.junittraining.calculator;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@DisplayName("Test Math operations in CalculatorApplication class")
class CalculatorApplicationTests {
	CalculatorApplication calculator;

	@BeforeAll
	static void setup(){
		System.out.println("Executing @BeforeAll Before all tests");
	}

	@AfterAll
	static void cleanup(){
		System.out.println("Executing @AfterAll After all tests");
	}

	@BeforeEach
	void setupEach(){
		System.out.println("Executing @BeforeEach Before each test");
		calculator = new CalculatorApplication();
	}

	@AfterEach
	void cleanupEach(){
		System.out.println("Executing @AfterEach After each test");
	}

	// test<System Under Test>_< Condition or State Change>_<Expected Behavior>
	@Disabled("TODO: Implement this test")
	@DisplayName("Test 10/5 = 2")
	@Test
	void testIntegerDivision_WhenFourIsDividedByTwo_ShouldReturnTwo(){
		System.out.println("Executing @Test 10/5 = 2");
		int result = calculator.integerDivision(10, 5);
		assertEquals(2, result,"10 / 5 must be 2");
	}
	@DisplayName("Test 10/0 = ArithmeticException")
	@Test
	void testIntegerDivision_WhenDivisorIsZero_ShouldThrowArithmeticException(){
		// Given
		System.out.println("Executing @Test 10/0 = ArithmeticException");
		int dividend = 10;
		int divisor = 0;
		String expectedExceptionMessage = "/ by zero";
		// When
		ArithmeticException exception = assertThrows(ArithmeticException.class, () -> calculator.integerDivision(dividend, divisor), "Divisor cannot be zero");
		// Then
		assertEquals(expectedExceptionMessage, exception.getMessage(), "Unexpected exception message");

	}
	@DisplayName("Test 10-5 = 5")
	@ParameterizedTest
	@MethodSource("integerSubtractionInputParameters")
	void testIntegerSubtraction_WhenTenIsSubstractedByFive_ShouldReturnFive(int minuend, int subtrahend, int expected){
		// Given
		System.out.println("Executing @Test 10-5 = 5");
//		int minuend = 10;
//		int subtrahend = 5;
//		int expected = 5;
		// When
		int result = calculator.integerSubtraction(minuend, subtrahend);
		// Then
		assertEquals(expected, result,() -> minuend + " - " + subtrahend + " must be " + expected	);
	}
	private static Stream<Arguments> integerSubtractionInputParameters() {
		return Stream.of(
				Arguments.of(10, 5, 5),
				Arguments.of(10, 10, 0),
				Arguments.of(10, 15, -5)
		);
	}
}
