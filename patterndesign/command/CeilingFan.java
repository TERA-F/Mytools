package command;

public class CeilingFan {
	String name;
	public static final int HIGH = 3;
	public static final int MEDIUM = 2;
	public static final int LOW = 1;
	public static final int OFF = 0;
	String location;
	int speed;

	public CeilingFan(String string) {
		// TODO Auto-generated constructor stub
		this.location = location;
		speed = OFF;
	}

	public void high(){
		speed = HIGH;
		System.out.println(location + "ceiling fan is on HIGH");
	}
	
	public void medium(){
		speed = MEDIUM;
		System.out.println(location + "ceiling fan is on MEDIUM");
	}
	
	public void low(){
		speed = LOW;
		System.out.println(location + "ceiling fan is on LOW");
	}
	
	public void off(){
		speed = OFF;
		System.out.println(location + "ceiling fan is on OFF");
	}
	
	public int getSpeed(){
		return speed;
	}
	public void on() {
		// TODO Auto-generated method stub
		System.out.println(name+" is on");
	}

	/*
	public void off() {
		// TODO Auto-generated method stub
		System.out.println(name+" is off");
	}
	*/
}
