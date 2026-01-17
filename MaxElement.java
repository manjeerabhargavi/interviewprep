package com.javapractice.javainterview;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class MaxElement {
  public static void main(String args[]) {
	  OptionalInt max = IntStream.range(0, 10).max();
	  System.out.println("Max"+max);
	  List<Integer>intList = Arrays.asList(123,333,121,677);
	  int max1 = intList.stream().distinct().max(Integer::compare).get();
	  System.out.print(max1);;
	  int min = intList.stream().min(Integer::compare).get();
	  System.out.println("Minimum "+min);
	  double sumOfElementsAsDouble = intList.stream().mapToInt(i->i).average().getAsDouble();
	  System.out.println("Sum Of Elements As double:"+sumOfElementsAsDouble);
	  int sumOfElements = intList.stream().mapToInt(i->i).sum();
	  System.out.println("Sum Of Elements:"+sumOfElements);
	  
	  
  }
}
