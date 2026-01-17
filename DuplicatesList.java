package com.javapractice.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DuplicatesList {
  public static void main(String args[]) {
	  List<Integer> nums = Arrays.asList(1,2,3,2,4,1,5,6,1);
	  Set<Integer>seen = new HashSet<>();
	  Set<Integer>dup = nums.stream()
			                .filter(c->!seen.add(c))
			                .collect(Collectors.toSet());
	  System.out.println(dup);
			                
  }
}
