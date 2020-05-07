package threaad.creation.example1;

public class Main {

	public static void main(String[] args) {
		System.out.print("hiiiii");
		Thread thread = new Thread();
		
		thread.start();

	}
	
	private static class NewThread extends Thread
	{
		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("New Thread "+ this.getName());
		}
	}

}
