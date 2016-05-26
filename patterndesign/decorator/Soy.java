package decorator;

public class Soy extends CondimentDecorator{
	Beverage beverage;
	public Soy(Beverage beverage){
		this.beverage=beverage;
	}
	
	@Override
	public double cost(){
		return .15+beverage.cost();
	}

	@Override
	public String getDscription() {
		return beverage.getDscription()+",Soy";
	}
		
}
