package abstractfactory;

public class NYPizzaIngredientFactory implements PizzaIngredientFactory {

	@Override
	public Dough createDough() {
		return new ThinCrustDough();
	}

	@Override
	public Sauce createSauce() {
		return new MarinaraSauce();
	}

	@Override
	public Cheese createCheese() {
		return ReggianoCheese();
	}

	@Override
	public Veggies[] createVeggies() {
		Veggies veggiesp[] ={new Garlic(),new Onion(),new Mushroom(),new RedPepper()};
	}

	@Override
	public Pepperoni createPepperoni() {
		return new Sliced Pepperoni();
	}

	@Override
	public Clams createClam() {
		return new FreshClams();
	}
	
}
