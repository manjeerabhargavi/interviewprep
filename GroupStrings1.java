package com.javapractice.javainterview;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupStrings1 {
     public static void main(String args[]) {
    	 List<String> words = Arrays.asList("a", "bb", "ccc", "dd", "e");
    	 Map<Integer,List<String>>map = words.stream().collect(Collectors.groupingBy(String::length));
    	 System.out.println("Grouped Map is:"+map);
    			                              
     }
}
