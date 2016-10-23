package ipc;

public class Writer implements Runnable{
		private ReaderandWriter rw;
		public Writer(ReaderandWriter rw){
			this.rw = rw;
		}

		@Override
		public void run() {
			while(true){
				try {
					rw.hasWriter.acquire();
					System.out.println("think up data");
					Thread.sleep(1);
					rw.db.acquire();
					System.out.println("write data base");
					rw.db.release();
					rw.hasWriter.release();
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
}
