package command;

public class Light {
	String name;
	public Light(String string) {
		// TODO Auto-generated constructor stub
		name = string;
	}

	public void on(){
		System.out.println(name+" is on;");
	}
	
	public void off(){
		System.out.println(name+"Light is off;");
	}
}
