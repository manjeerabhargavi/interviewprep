package com.javapractice.java8.multithreadingandconcurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceEx {
	private final int id;

	public ExecutorServiceEx(int id) {
		this.id = id;
	}

	private void runTask() {
		System.out.println(Thread.currentThread().getName() + "Processing job#" + id);
		try {
			Thread.sleep(150);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

	public static void main(String args[]) {
		ExecutorService pool = Executors.newFixedThreadPool(4, r -> new Thread(r, "pool-" + System.nanoTime()));
		for (int i = 1; i <= 8; i++) {
			ExecutorServiceEx job = new ExecutorServiceEx(i);
			pool.submit(job::runTask);
		}
		pool.shutdown();
		System.out.println("Executor Service Demo Submitted all tasks");
	}
}
