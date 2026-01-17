package com.javapractice.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.javapractice.leetcode.pojo.Employee;

public class SortEmployees {
  public static void main(String args[]) {
	  List<Employee> employees = Arrays.asList(
	            new Employee("John", 50000),
	            new Employee("Jane", 60000),
	            new Employee("Bob", 50000)
	        );
      List<Employee>sortedBySalaryDesc = employees.stream()
    		  .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
    		  .distinct()
    		  .collect(Collectors.toList());
      System.out.println(sortedBySalaryDesc);
  }
}
