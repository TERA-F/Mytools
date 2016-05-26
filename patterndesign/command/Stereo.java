package command;

public class Stereo {
	String name;
	
	public Stereo(String string) {
		// TODO Auto-generated constructor stub
		name = string;
	}

	public void on() {
		// TODO Auto-generated method stub

	}

	public void setCD() {
		// TODO Auto-generated method stub
		System.out.println(name+" set CD");
	}

	public void setVolume(int i) {
		// TODO Auto-generated method stub
		System.out.println(name+" set Volume");
	}

	public void off() {
		// TODO Auto-generated method stub
		System.out.println(name+" is off");
	}	
}
