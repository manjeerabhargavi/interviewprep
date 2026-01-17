package com.javapractice.javainterview;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ListOfStringsStartsWithLetter {
   public static void main(String args[]) {
	   List<String> words = Arrays.asList("Apple", "Banana", "Apricot", "Orange");
	   List<String>filtered = words.stream()
			                      .filter(s->s.startsWith("A"))
			                      .map(String::toUpperCase)
			                      .collect(Collectors.toList());
	   System.out.println("Filtered:"+filtered);
   }
}
