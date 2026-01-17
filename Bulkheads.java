package com.javapractice.java8.cardpayment.core;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Bulkheads {
  public static final ExecutorService VISA_EXEC = new ThreadPoolExecutor
		  (8,6,60,TimeUnit.SECONDS,new LinkedBlockingQueue<>(200),
				  r -> new Thread(r,"visa-exec-" + System.nanoTime()));
  public static final ExecutorService AMEX_EXEC = new ThreadPoolExecutor
		                  (6,12,60,TimeUnit.SECONDS,new LinkedBlockingQueue<>(200),
		                		r-> new Thread(r,"amex-exec-"+System.nanoTime()));
  public static final ScheduledExecutorService SCHED = 
		  Executors.newScheduledThreadPool(4,r->new Thread(r,"sched-"+System.nanoTime()));
		                		
}
