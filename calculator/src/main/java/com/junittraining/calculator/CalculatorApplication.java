package com.junittraining.calculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CalculatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(CalculatorApplication.class, args);
	}

	public int integerDivision(int dividend, int divisor) {
		return dividend / divisor;

	}

	public int integerSubtraction(int minuend, int subtrahend) {
		return minuend - subtrahend;
	}
}
