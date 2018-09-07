package ThreadSequencing;

public class MainClass {

//	public static void main(String[] args) {
//		ThreadStage state=ThreadStage.threadZero;
//		Thread oddThread=new Thread(new ThreadOdd(state));
//		Thread zeroThread=new Thread(new ZeroThread(state));
//		Thread evenThread=new Thread(new ThreadEven(state));
//		oddThread.start();
//		zeroThread.start();
//		evenThread.start();
//	}
//	
//	
	
    public static void main(String[] args) {
    	 MainClass mtt = new MainClass();
    	 mtt.printSequenceWithThreads();
	}
    private volatile int sequence=0;
	private void printSequenceWithThreads() {
		Runnable oddThread=new Runnable() {
			
			@Override
			public void run() {
				while(true){
					for (int i = 1; i < Integer.MAX_VALUE; i++) {
						if(sequence==1){
						if(i%2==0){
							System.out.println(i + ":" + Thread.currentThread().getName());
							sequence=0;
							try {
								Thread.sleep(100);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						}try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		};
		
      Runnable evenThread=new Runnable() {
			@Override
			public void run() {
				while(true){
					for (int i = 1; i < Integer.MAX_VALUE; i++) {
						if(sequence==0){
						if(i%2!=0){
							System.out.println(i + ":" + Thread.currentThread().getName());
							sequence=1;
							try {
								Thread.sleep(100);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						}try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
				}
			}
		};
		
		Thread eventhrea=new Thread(evenThread);
		Thread oddThrea=new Thread(oddThread);
		eventhrea.start();
		oddThrea.start();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	  protected int threadSequence = 0;
//	  public static void main(String[] args) {
//		  MainClass mtt = new MainClass();
//	        mtt.printSequenceWithThreads();
//	    }
//
//	    public void printSequenceWithThreads() {
//
//	        Runnable r1 = new Runnable() {
//	            @Override
//	            public void run() {
//	                try {
//	                    int i=1;
//	                    for(i=1; i<=10; ) {
//	                        if(threadSequence == 0) {
//	                            System.out.print(" " + 0);
//	                            if(i%2 == 0) {
//	                                threadSequence = 2;
//	                            } else {
//	                                threadSequence = 1;
//	                            }
//	                            i++;
//	                        }
//	                        Thread.sleep(100);
//	                    }
//	                } catch(InterruptedException ex) {
//	                    ex.printStackTrace();
//	                }
//	            }
//	        };
//
//
//	        Runnable r2 = new Runnable(){
//	            @Override
//	            public void run() {
//	                try {
//	                    int i = 1;
//	                    for (i = 1; i <= 10;) {
//	                        if(threadSequence == 1) {
//	                            System.out.print(" " + i);
//	                            threadSequence = 0;
//	                            i = i + 2;
//	                        }
//	                        Thread.sleep(100);
//	                    }
//	                } catch (InterruptedException ex) {
//	                    ex.printStackTrace();
//	                }
//	            }
//	        };
//
//	        Runnable r3 = new Runnable() {
//	            @Override
//	            public void run() {
//	                try {
//	                    int i = 2;
//	                    for (i = 2; i <= 10; ) {
//	                        if(threadSequence == 2) {
//	                            System.out.print(" " + i);
//	                            threadSequence = 0;
//	                            i = i + 2;
//	                        }
//	                        Thread.sleep(100);
//	                    }
//	                } catch (InterruptedException ex) {
//	                    ex.printStackTrace();
//	                }
//	            }
//	        };
//
//	        Thread t1 = new Thread(r1);
//	        Thread t2 = new Thread(r2);
//	        Thread t3 = new Thread(r3);
//
//	        t1.start();
//	        t2.start();
//	        t3.start();
//	    }


}
