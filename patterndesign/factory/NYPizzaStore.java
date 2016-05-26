package factory;

public class NYPizzaStore extends PizzaStore {

	@Override
	Pizza createPizza(String item) {
		if(item.equals("cheese")){
			return new NYStyleCheesePizza();
		}else if(item.equals("veggie")){
			return new NYStyleVeggiePizza();
		}else if(item.equals("clam")){
			return new NYStyleClamPizza();
		}else if(item.equals("pepperoni")){
			return new NYStylePepperoniPizza();
		}else{
			System.out.println("Error: invalid type of pizza");
			return null;
		}
	}
}
