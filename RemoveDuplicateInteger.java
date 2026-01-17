package com.javapractice.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class RemoveDuplicateInteger {
  public static void main(String args[]) {
	 List<Integer> numList = Arrays.asList(12,23,34,56,12,12,34,56);
	 List<Integer>unqiueList = numList.stream()
			                          .filter(Objects::nonNull)
			                          .distinct()
			                          .collect(Collectors.toList());
	 System.out.println("Non Duplicate::"+unqiueList);
	 
	 
  }
}
