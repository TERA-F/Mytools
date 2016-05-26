package decorator;

public abstract class Beverage {
	String description = "Unknown Beverage";
	
	public String getDscription(){
		return description;
	}
	
	public abstract double cost();
}
