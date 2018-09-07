
public class SequencThreadProgramme {
	private volatile Integer count=1;
	private volatile Integer threadtorun=1;
	private Object monitor=new Object();
	
	public static void main(String[] args) {
		SequencThreadProgramme sequencThreadProgramme=new SequencThreadProgramme();
		Thread thread1=new Thread(sequencThreadProgramme.new SamplePrinter(1));
		Thread thread2=new Thread(sequencThreadProgramme.new SamplePrinter(2));
		Thread thread3=new Thread(sequencThreadProgramme.new SamplePrinter(3));
		thread1.start();
		thread2.start();
		thread3.start();
	}
	
	public class SamplePrinter implements Runnable{
		
		private Integer threadID;
		
		public SamplePrinter(Integer threadID){
			this.threadID=threadID;
		}

		@Override
		public void run() {
          while(count<=20){
        	  synchronized (monitor) {
				if(threadID!=threadtorun){
					try {
						monitor.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}else{
					System.out.println("Excetion Thread is threadID"+threadID+":"+ count);
					count++;
					if(threadtorun==1){
						threadtorun=2;
					}else if(threadtorun==2){
						threadtorun=3;
					}else{
						threadtorun=1;
					}
				}
				monitor.notifyAll();
			}
        	  
          }
		}
		
	}
    			
			
}
	
	
	