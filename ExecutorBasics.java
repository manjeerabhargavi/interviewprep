package com.javapractice.java8.multithreadingandconcurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * What Submit tasks to a fixed thread pool; graceful shut down
 * Why :Executors manage reusable threads efficiently (prefer over raw thread)
 * 
 */

public class ExecutorBasics {
  public static void main(String args[]) {
	  ExecutorService pool = Executors.newFixedThreadPool(4,r->new Thread(r,"pool-"+System.nanoTime()));
	  for(int i=1; i<=8;i++) {
		  final int id = i;
		  pool.submit(()->{
			  System.out.println(Thread.currentThread().getName() + "processing job#" + id);
		  });
		  try {
			  Thread.sleep(150);
		  }
		  catch(InterruptedException e) {
			  Thread.currentThread().interrupt();
		  }
	  }
	  pool.shutdown(); // Important: Stop accepting new tasks; let current finish
	  System.out.println("Submitted all tasks (Executor Basics)");
  }
}
