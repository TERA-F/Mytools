package ipc;

public class Reader implements Runnable{
		private ReaderandWriter rw;

		public Reader(ReaderandWriter rw) {
			this.rw = rw;
		}

		@Override
		public void run() {
			while(true){
				try {
				addrc();
				System.out.println(rw.rc + "is reading");
				Thread.sleep(1);
				cutrc();
				System.out.println(rw.rc+"use data");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		private  void cutrc() {
			synchronized (rw) {
				rw.rc--;
				if(rw.rc == 0){
					rw.db.release();
				}			
			}

		}

		private  void addrc() throws InterruptedException {
			synchronized (rw) {
				if(!rw.hasWriter.tryAcquire()){
					rw.db.release();
					rw.hasWriter.acquire();
					rw.db.acquire();

				}
				rw.rc++;
				if(rw.rc ==1){
						rw.db.acquire();
				}
				rw.hasWriter.release();			
			}

		}
}
