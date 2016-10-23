package ipc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class PhilosopherDining {

	static final private int THINKING = 0;
	static final private int HUNGRY = 1; 
	static final private int EATING = 2;
	
	static final private int NUMBER = 5;
	int[] state = new int[NUMBER];
	private Semaphore[] s = new Semaphore[NUMBER];
	
	public void takeforks(int i){
		take_forks(i);
		try {
			s[i].acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			s[i].release();
		}
	}
	
	private synchronized void take_forks(int i){
		state[i] = HUNGRY;
		test(i);
	}
	
	public synchronized void put_forks(int i ){
		state[i] = THINKING;
		test((i+NUMBER-1)%NUMBER);
		test((i+1)%NUMBER);
	}
	
	private void test(int i){
		if(state[i] == HUNGRY && state[(i+NUMBER-1)%NUMBER] != EATING && state[(i+1)%NUMBER] != EATING){
			state[i] = EATING;
			System.out.println("Philosopher "+i+" is having dinner!");
			s[i].release();
		}
	}
	
	public static void main(String[] args) {
		PhilosopherDining pd = new PhilosopherDining();
		for(int i = 0 ; i< NUMBER ; i++){
			pd.s[i] = new Semaphore(1);
		}
		ExecutorService pool = Executors.newFixedThreadPool(5);
		for(int i = 0 ;i < NUMBER ; i++){
			Runner runner = new Runner(pd,i);
			pool.submit(runner);
		}		
	}
	
	
}
