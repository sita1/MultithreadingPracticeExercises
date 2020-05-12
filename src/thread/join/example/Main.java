package thread.join.example;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		List<Long> inputNumbers = Arrays.asList(0L,345L,650L,34L,540L);
		
		List<FactorialThread> threads =  new ArrayList<>();
		
		for(long inputNumber : inputNumbers)
		{
			threads.add(new FactorialThread(inputNumber));
		}
		
		for(Thread thread : threads)
		{
			thread.start();
		}
		
		for(Thread thread : threads)
		{
			thread.join(2000);
		}
		for(int i=0;i<inputNumbers.size();i++)
		{
			FactorialThread factorialThread = threads.get(i);
			if(factorialThread.isFinished())
			{
				System.out.println("working fine");
			}
			else
				System.out.println("Not fine");
			
		}
	}

	public static class FactorialThread extends Thread  
	{
		
		private Long inputNumbers;
		
		private BigInteger result = BigInteger.ZERO;
		
		private boolean isFinished = false;
		
		public FactorialThread(long inputNumber)
		{
			this.inputNumbers=inputNumber;
		}
		
		@Override
		public void run()
		{
			this.result=factorialMethod(inputNumbers);
			this.isFinished=true;
		}

		public BigInteger factorialMethod(Long n) {
		BigInteger tempResult = BigInteger.ONE;
		System.out.println("no"+n);
		for(long i=2;i<=n;i++)
		{
			tempResult=tempResult.multiply(new BigInteger(Long.toString(i)));
		}
		return tempResult;
		}

		public boolean isFinished() {
			return isFinished;
		}

		public BigInteger getResult() {
			return result;
		}


	}
}
