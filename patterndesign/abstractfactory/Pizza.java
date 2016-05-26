package abstractfactory;

public abstract class Pizza {
	String name;
	Dough dough;
	Sauce sauce;
	Veggies vaggies[];
	Cheese cheese;
	Pepperoni perpperoni;
	Clams clam;
	
	abstract void prepare();

	void bake()	{
		System.out.println("Bake for 25 minutes at 350");
	}
	
	void cut()	{
		System.out.println("Cutting the Pizza into diagonal slices");
	}
	
	void box()	{
		System.out.println("Place pizza in offical PizzaStore box");
	}
	
	void setName(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}

	public String toString(){
		//打印比萨的代码
	}
}
