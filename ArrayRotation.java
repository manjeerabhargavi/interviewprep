package com.javapractice.leetcode;
/**
 * Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem 
first write algorithm and then write java coding use java 8 streams and other features. explain each step
 */
/**
 * Idea (simple & optimal):
To rotate an array to the right by k, we:
1. Normalize k → k = k % n (because rotating by n or multiples does nothing; also handle negative k).
2. Reverse the entire array.
3. Reverse the first k elements.
4. Reverse the remaining n-k elements
 */
public class ArrayRotation {
  public static void main(String args[]) {
	  /**
	   * If n <= 1, return (no rotation needed).
		Normalize k to [0, n-1]: k = ((k % n) + n) % n.
		(Works for negative k too: e.g., right rotate by -2 equals left by 2.)
		If k == 0, return.
		Reverse nums[0..n-1].
		Reverse nums[0..k-1].
		Reverse nums[k..n-1].
	   */
  }
  public static void rotate(int[] nums,int k) {
	  int n = nums.length;
	  if(n<=1) return ;
	  //Reverse entire array
	  k = ((k%n)+n)%n;
	  
  }
}
