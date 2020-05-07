package therad.termination.deamon;

public class MainExeec {
	
	public static void main(String ab[])
	{
		Thread thread = new Thread(new BlockingTest());
		thread.start();
		thread.interrupt();
		
	}
	private static class BlockingTest implements Runnable{
		@Override
		public void run() {
			try {
				Thread.sleep(400000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
}
