package ipc;

public class Runner implements Runnable{


		private PhilosopherDining ph;
		private int i;
		public Runner(PhilosopherDining ph,int i){
			this.ph = ph;
			this.i = i;
		}
		
		@Override
		public void run() {
			while(true){
				ph.takeforks(i);
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ph.put_forks(i);
			}
		}
		
}
