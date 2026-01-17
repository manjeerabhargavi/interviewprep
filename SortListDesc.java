package com.javapractice.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortListDesc {
   public static void main(String args[]) {
	   List<Integer> nums = Arrays.asList(1,2,3,2,4,1,5,6,1);
	   List<Integer>numsDesc = nums.stream().sorted(Comparator.reverseOrder())
			                        .collect(Collectors.toList());
	   System.out.println("Descending order"+numsDesc);
	   
   }
}
