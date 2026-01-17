package com.javapractice.java8.multithreadingandconcurrency;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ConcurrencyWarmup {
  public static void main(String args[]) throws InterruptedException, ExecutionException, TimeoutException {
	  ExecutorService pool = Executors.newFixedThreadPool(4);
	  Future<Integer>f1 = pool.submit(()->expensive(120)); //Callable returns a value
	  Future<Integer>f2 = pool.submit(()->expensive(100));
	  System.out.println(f1.get(500, TimeUnit.MILLISECONDS)+f2.get());//wiht time out
	  pool.shutdown();
  }
  static int expensive(int ms) {
	  try {
		Thread.sleep(ms);
	  } catch (InterruptedException e) {
		Thread.currentThread();
		Thread.interrupted();
	  }
	  return ms/10;
   }
}
