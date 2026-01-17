package com.javapractice.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RemoveDuplicates {
  public static void main(String args[]) {
	  List<String>listStrings = Arrays.asList("ABC","DEF","ABC","DEF","123");
	  List<String>uniqueStrings = listStrings.stream().distinct().collect(Collectors.toList());
	  System.out.println("Uniqute Integer"+uniqueStrings);
  }
}
