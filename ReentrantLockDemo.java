package com.javapractice.java8.multithreadingandconcurrency;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {
   private final ReentrantLock lock = new ReentrantLock(true);
   private int shared = 0;
   private void safeInc() {
	   if(lock.tryLock()) {
		   try {
			   shared++;
		   }
		   finally {
			   lock.unlock();
		   }
	   }
	   else {
		   System.out.println(Thread.currentThread().getName()+ "Could not acquired lock");
	   }
   }
   public static void main(String args[]) throws InterruptedException {
	   ReentrantLockDemo demo = new ReentrantLockDemo();
	   Thread t1 = 
			         new Thread(()->{
			        	for(int i=0;i<1000;i++) {
			        		demo.safeInc();
			        	}
			         },"L1");
	   Thread t2 = 
		         new Thread(()->{
		        	for(int i=0;i<1000;i++) {
		        		demo.safeInc();
		        	}
		         },"L2");
	   t1.start();
	   t2.start();
	   t1.join();
	   t2.join();
   }
}
