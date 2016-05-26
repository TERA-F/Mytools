package decorator;

public class Mocha extends CondimentDecorator{
	Beverage beverage;
	public Mocha(Beverage beverage){
		this.beverage=beverage;
	}
	
	@Override
	public double cost(){
		return .20+beverage.cost();
	}

	@Override
	public String getDscription() {
		return beverage.getDscription()+",Mocha";
	}
		
}
