import java.util.Scanner;

class FirstThread extends Thread{
	public void produce() throws InterruptedException{
		synchronized (this) {
			System.out.println("Producer thread is working");
			wait();
			System.out.println("Producer thread contunie");
		}
	}
	
	public void consume() throws InterruptedException{
		Thread.sleep(2000);
		Scanner scanner = new Scanner(System.in);
		
		synchronized (this) {
			System.out.println("Consumer thread is working");
			System.out.println("Press Enter to continue");
			scanner.nextLine();
			System.out.println("Consumer thread contunie");
			notify();
			Thread.sleep(5000);
			System.out.println("Consumer worked for 5 seconds");
		}
		
	}
}