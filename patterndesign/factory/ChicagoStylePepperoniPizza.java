package factory;

public class ChicagoStylePepperoniPizza  extends Pizza{
	public ChicagoStylePepperoniPizza(){
		name = "Chicago Style Deep Dish Cheese Pizza";
		dough = "Extra Thick Crust Dough";
		sauce = "Plum Tomato Sauce";
		
		toppings.add("Shredded Mozzarella Cheese");
	}
	
	void cut(){
		System.out.println("Cutting the Pizza into square slices");
	}

}
