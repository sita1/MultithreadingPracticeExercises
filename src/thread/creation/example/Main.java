package thread.creation.example;

public class Main {


		public static void main(String[] args) {
			System.out.print("hiiiii");
			Thread thread = new Thread(new Runnable() {
				
				@Override
				public void run() {
				System.out.println("hello"+Thread.currentThread().getName());
					
				}
			});
			
			thread.start();
		}
		
}
