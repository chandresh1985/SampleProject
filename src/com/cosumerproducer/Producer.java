package com.cosumerproducer;

import java.util.UUID;
import java.util.concurrent.BlockingQueue;

	
	public class Producer implements Runnable{
		 private BlockingQueue<UUID>sharedQueue;
	      public Producer(BlockingQueue<UUID>	sharedQueue){
	    	  this.sharedQueue=sharedQueue;
	      }

/*		@Override
		public void run() {
			while(true){
			synchronized (sharedQueue) {
				while(sharedQueue.size()==10){
					try {
						sharedQueue.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}  
				   System.out.println(Thread.currentThread().getName());
					sharedQueue.add(UUID.randomUUID());
					sharedQueue.notifyAll();
			}
			
			}
		}*/
	      
	    @Override
	  	public void run() {
	    	while(true){
					
					   System.out.println(Thread.currentThread().getName());
					   try {
						sharedQueue.put(UUID.randomUUID());
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
	  		
	  	}
			
		}
