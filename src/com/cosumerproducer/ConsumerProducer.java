package com.cosumerproducer;

import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ConsumerProducer {

  public static void main(String[] args) {
	  BlockingQueue<UUID>sharedQueue=new ArrayBlockingQueue<UUID>(10);
	  Executor executorService=Executors.newFixedThreadPool(10);
	  for (int i = 0; i <10; i++) {
		  executorService.execute(new Consumer(sharedQueue));
	   }
	  Executor executorProducerService=Executors.newFixedThreadPool(10);
	  for (int i = 0; i <10; i++) {
		  executorProducerService.execute(new Producer(sharedQueue));
	   }
  
  }
}
