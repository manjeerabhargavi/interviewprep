package com.javapractice.javainterview;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SortDistinctElements {
   public static void main(String args[]) {
	   //Use distinct before sorted
	   List<Integer> result = Stream.of(3,1,2,2,3)
			                        .distinct()
			                        .sorted()
			                        .collect(Collectors.toList());
	   System.out.println(result);
	   
	   
   }
}
