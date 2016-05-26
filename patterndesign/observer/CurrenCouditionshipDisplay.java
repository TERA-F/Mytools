package observer;

public class CurrenCouditionshipDisplay implements Observer, DisplayElement{
	private float temprature;
	private float humidity;
	private Subject weatherData;
	
	public CurrenCouditionshipDisplay(Subject weatherData){
		this.weatherData = weatherData;
		weatherData.registerObserver(this);
	}
	
	@Override
	public void update(float temperature, float humidity, float pressure) {
		this.temprature = temperature;
		this.humidity = humidity;
		display();
	}
	
	@Override
	public void display() {
		System.out.println("Current conditions:"+temprature + "F degrees and "+ humidity +"% humidity");
	}
}
