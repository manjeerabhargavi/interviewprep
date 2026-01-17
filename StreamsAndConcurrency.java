package com.javapractice.java8.multithreadingandconcurrency;

import java.util.Arrays;
import java.util.List;

public class StreamsAndConcurrency {
	public static void main(String args[]) {
		List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6);
		int sumSquaresEven = nums.stream().filter(n -> n % 2 == 0).map(n -> n * n).reduce(0, Integer::sum);
		System.out.println("Reduced Value:" + sumSquaresEven);
	}
}
