package decorator;

public class Whip extends CondimentDecorator{
	Beverage beverage;
	public Whip(Beverage beverage){
		this.beverage=beverage;
	}
	
	@Override
	public double cost(){
		return .10+beverage.cost();
	}

	@Override
	public String getDscription() {
		return beverage.getDscription()+",Whip";
	}
		
}
