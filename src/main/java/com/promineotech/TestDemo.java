package com.promineotech;

import java.util.Random;

public class TestDemo {
	public int addPositive(int a, int b) {
        if (a > 0 && b > 0) {
            return a + b;
        } else {
            throw new IllegalArgumentException("Both parameters must be positive!");
        }
	}
	
	// A method that multiplies two integers and returns the result
    public int multiply(int a, int b) {
        return a * b;
    }
    
 // Method to get a random integer between 1 and 10
    int getRandomInt() {
        Random random = new Random();
        return random.nextInt(10) + 1; // Returns a random integer between 1 and 10
    }

    // Method to return the square of a random integer
    public int randomNumberSquared() {
        int randomValue = getRandomInt();  // Get a random integer
        return randomValue * randomValue;  // Return the square of the random integer
    }
}
