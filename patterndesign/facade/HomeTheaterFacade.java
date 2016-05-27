package facade;

public class HomeTheaterFacade {
	Amplifier amp;
	Tuner tuner;
	DvdPlayer dvd;
	CdPlayer cd;
	Projector projector;
	TheaterLights light;
	Screen screen;
	PopcornPopper popper;
	
	public HomeTheaterFacade(Amplifier amp,
			Tuner tuner,
			DvdPlayer dvd,
			CdPlayer cd,
			Projector projector,
			TheaterLights light,
			Screen screen,
			PopcornPopper popper){
		this.amp = amp;
		this.tuner = tuner;
		this.dvd = dvd;
		this.cd = cd;
		this.projector = projector;
		this.light = light;
		this.screen = screen;
		this.popper = popper;
	}
	
	public void watchMoive(){
		System.out.println("Get ready to watch a movie...");
		popper.on();
		popper.pop();
		light.on();
		screen.down();
		projector.on();
		projector.wideScreenMode();
		amp.on();
		amp.setDvd();
		amp.setSurroundSound();
		amp.setVolume();
		dvd.on();
		dvd.play();
	}
}
