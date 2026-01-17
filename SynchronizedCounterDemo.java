package com.javapractice.java8.multithreadingandconcurrency;
/**
 * Show a race condition then fix it by synchronizing the increment method
 */
public class SynchronizedCounterDemo {
  private int value = 0;
  /**
   * Uncommented the synchronized version to fix the race
   *
   */
  /*public synchronized void inc()
  {
	 value++; 
  }*/
  //Intentionally unsynchronized first to show the problem
  public void inc() {
	  value++;
  }
  public int get() {
	  return value;
  }
  public static void main(String args[]) throws Exception {
	  SynchronizedCounterDemo counter = new  SynchronizedCounterDemo();
	  Thread t1 = new Thread(()->{
		  for(int i=0;i<100_000;i++) {
			  counter.inc();
		  }
	 },"T1");
	Thread t2 = new Thread(()->{
		for(int i=0;i<100_000;i++) {
			counter.inc();
		}
	},"T2");

        t1.start(); 
        t2.start();
        t1.join();  
        t2.join();
      System.out.println("Value (race-prone)="+counter.get());
      System.out.println("Enable Synchronous	inc()for exact 200000");
  }
}
