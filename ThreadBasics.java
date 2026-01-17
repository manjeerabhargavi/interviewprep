package com.javapractice.java8.multithreadingandconcurrency;

//What: Create threads, name them, start, and join.
//Why: Understand the lowest-level building block before using higher-level executors.

public class ThreadBasics {
  static class Worker implements Runnable{
	  private final String task;
	  Worker(String task){
		  this.task = task;
	  }
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+"::Started->"+task);
		try {
			Thread.sleep(200);
		}
		catch(InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	  System.out.println(Thread.currentThread().getName()+"::finished ->"+task);	
	}
  }
  public static void main(String args[]) {
	  Thread t1 = new Thread(new Worker("Load Profile"),"worker-1");
	  Thread t2 = new Thread(new Worker("Fetch Transactions"),"worker-2");
	  t1.start();
	  t2.start();
	  try {
		t1.join();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  try {
		t2.join();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} //Wait for both to finish
	  System.out.println("All done (Thread Basics)");
  }
}
