package com.javapractice.java8.multithreadingandconcurrency;


//SynchronizedDemo.java
//What: Show race condition without synchronization, then fix it.
//Why: Shared state requires mutual exclusion to avoid incorrect results.

public class RaceConditionVsSynchronized {
 static class Counter{
	 private int value = 0;
	 //Uncomment to fix race : synchronozied method ensures exclusive access
	 //public synchronized void inc()
	 public void inc() {
		 value++;
	 }
 }
}
