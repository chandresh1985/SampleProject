package ThreadSequencing;

public class ZeroThread implements Runnable {

	private ThreadStage currentstate;
	private boolean isEventhread = false;

	public ZeroThread(ThreadStage currentstate) {
		this.currentstate = currentstate;
	}

	@Override
	public void run() {
		while (true) {
			while (!currentstate.equals(ThreadStage.threadZero)) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
			System.out.println(0);
			if (isEventhread) {
				currentstate = ThreadStage.threadEven;
			} else {
				currentstate = ThreadStage.threadOdd;
			}
			isEventhread=!isEventhread;
		}
	}

}
