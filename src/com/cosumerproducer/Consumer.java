package com.cosumerproducer;

import java.util.UUID;
import java.util.concurrent.BlockingQueue;

class Consumer implements Runnable{
	private BlockingQueue<UUID>	sharedQueue;
    public Consumer(BlockingQueue<UUID>	sharedQueue){
  	  this.sharedQueue=sharedQueue;
    }
/*		@Override
		public void run() {
			while(true){
			synchronized (sharedQueue) {
				while(sharedQueue.isEmpty()){
					try {
						sharedQueue.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread().getName());
				System.out.println(sharedQueue.remove());
				sharedQueue.notifyAll();
			}
				
			}
		}*/
	@Override
	public void run() {
		while(true){
				System.out.println(Thread.currentThread().getName());
				try {
					System.out.println(sharedQueue.take());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
	}
    
		}
		