package ipc;

import java.util.Random;

public class ProductorandConsumerWithWait {

	static final int N = 10;
	static final productor p1 = new productor();
	static final productor p2 = new productor();
	static final consumer c = new consumer();
	static final monitor mon = new monitor();
	
	public static void main(String[] args) {
		p1.start();
		p2.start();
		c.start();
	}
	static class productor extends Thread{
		
		@Override
		public void run(){
			int item;
			while(true){
				item = productor_item();
				mon.insert(item);
			}
		}

		private int productor_item() {
			Random random = new Random();
			int item = random.nextInt();
			System.out.println("生产 ："+item);
			return item;
		}
	}
	
	static class consumer extends Thread{
		
		@Override
		public void run(){
			int item;
			while(true){
				item = mon.remove();
				consum_item(item);
			}
		}

		private void consum_item(int item) {
			System.out.println("消费 ："+item);
		}
	}
	
	static class monitor{
		private int[] buffer = new int[N];
		private int count = 0, lo = 0, hi = 0;
		
		public synchronized void insert(int val){
			if(count == N)
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			buffer[hi] = val;
			hi = (hi+1)/N;
			count = count +1;
			if(count == 1) notifyAll();
		}
		
		public synchronized int remove(){
			if(count ==0)
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			int val = buffer[lo];
			lo = (lo+1)/N;
			count--;
			if(count == N-1) notifyAll();
			return val;
		}
	}
}
