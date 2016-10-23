package ipc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class ReaderandWriter {

	Semaphore db = new Semaphore(1);
	int rc = 0;
	Semaphore hasWriter = new Semaphore(1);
	
	public static void main(String[] args) {
		ExecutorService pool = Executors.newFixedThreadPool(7);
		ReaderandWriter rw = new ReaderandWriter();
		
		Reader r1 = new Reader(rw);
		Reader r2 = new Reader(rw);
		Reader r3 = new Reader(rw);
		Reader r4 = new Reader(rw);
		Reader r5 = new Reader(rw);
		Writer w1 = new Writer(rw);
		Writer w2 = new Writer(rw);
		pool.submit(r1);
		pool.submit(r2);
		pool.submit(r3);
		pool.submit(r4);
		pool.submit(r5);
		pool.submit(w1);
		pool.submit(w2);

		
	}
	 
}
