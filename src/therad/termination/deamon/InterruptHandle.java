package therad.termination.deamon;

import java.math.BigInteger;

public class InterruptHandle {

	public static void main(String[] args) {
		Thread thread = new Thread(new LongComputationTask(new BigInteger("200000"), new BigInteger("1000000")));
		thread.start();
		thread.interrupt();
	}
	
	private static class LongComputationTask implements Runnable{
		private BigInteger base;
		private BigInteger power;
		
		public LongComputationTask(BigInteger base , BigInteger power) {
			// TODO Auto-generated constructor stub
			this.base=base;
			this.power=power;
		}
		@Override
		public void run() {
		
			System.out.println(base+" "+power+" "+pow(base,power));
		}
		
		public BigInteger pow(BigInteger base,BigInteger power)
		{
			BigInteger result = BigInteger.ONE;
			for(BigInteger i =BigInteger.ZERO; i.compareTo(power)!=0 ; i=i.add(BigInteger.ONE))
			{
				if(Thread.currentThread().isInterrupted())
				{
					System.out.println("prematurly intruppt");
					 
					return BigInteger.ZERO;
				}
				result = result.multiply(base);
			}
			return result;
		}
		
	}

}
