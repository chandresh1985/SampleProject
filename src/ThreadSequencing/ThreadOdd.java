package ThreadSequencing;

public class ThreadOdd implements Runnable {

	private int oddValue = 1;
	private ThreadStage currentstate;

	public ThreadOdd(ThreadStage currentstate) {
		this.currentstate = currentstate;
	}

	@Override
	public void run() {
		while (true) {
			while (!currentstate.equals(ThreadStage.threadOdd)) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(oddValue);
				oddValue = oddValue + 2;
				currentstate = ThreadStage.threadZero;
			}

		}
	}

}
