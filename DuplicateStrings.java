package com.javapractice.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DuplicateStrings {
   public static void main(String args[]) {
	   List<String>listStrings = Arrays.asList("ABC","DEF","ABC","DEF","123");
	   Set<String>seen = new HashSet<>();
	   Set<String>dup = listStrings.stream().filter(c->!seen.add(c))
			                                .collect(Collectors.toSet());
	   System.out.println("Dup"+dup);
   }
}
