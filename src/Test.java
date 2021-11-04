public class Test{
	public static void main (String[] args) throws InterruptedException{
		FirstThread thread = new FirstThread();
		Thread producerThread = new Thread(new Runnable() {
			@Override 
			public void run() {
				try {
					thread.produce();
				}
				catch (InterruptedException e) {
				 e.printStackTrace();
				}
			}
		});
		Thread consumerThread = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					thread.consume();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		producerThread.start();
		consumerThread.start();
		producerThread.join();
		consumerThread.join();
	}
}