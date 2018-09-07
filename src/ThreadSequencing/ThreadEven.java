package ThreadSequencing;

public class ThreadEven implements Runnable {

	private int evenvalu = 2;
	private ThreadStage currentstate;

	public ThreadEven(ThreadStage currentstate) {
		this.currentstate = currentstate;
	}

	@Override
	public void run() {
		while (true) {
			while (!currentstate.equals(ThreadStage.threadEven)) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(evenvalu);
				evenvalu = evenvalu + 2;
				currentstate = ThreadStage.threadZero;
			}
		}
	}
}
