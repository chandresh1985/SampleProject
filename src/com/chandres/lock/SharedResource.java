package com.chandres.lock;

import java.util.LinkedList;

import java.util.UUID;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.Queue;

public class SharedResource {
	Queue<UUID>resource=new LinkedList<UUID>();
	int max_size=25;
	Lock reEntrantLock=new ReentrantLock();
	 Condition bufferisFull =reEntrantLock.newCondition();
	 Condition fufferisEmplty=reEntrantLock.newCondition();
	
	
	
	public void put(){
		try{
		reEntrantLock.lock();
		if(resource.size()==max_size){
			bufferisFull.await();
		}
		resource.add(UUID.randomUUID());
		fufferisEmplty.signalAll();
		}catch(Exception ex){
			
		}finally {
			reEntrantLock.unlock();
		}
		
	}
	
	public void get(){
		try{
			reEntrantLock.lock();
			if(resource.isEmpty()){
				fufferisEmplty.await();
			}
			System.out.println(resource.remove());
			bufferisFull.signalAll();
			}catch(Exception ex){
				
			}finally {
				reEntrantLock.unlock();
			}
			
	}
	

}
