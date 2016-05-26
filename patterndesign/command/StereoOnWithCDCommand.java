package command;

public class StereoOnWithCDCommand implements Command {
	Stereo stereo;
	
	public StereoOnWithCDCommand(Stereo stereo){
		this.stereo = stereo;
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		stereo.on();
		stereo.setCD();
		stereo.setVolume(11);
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		stereo.off();
	}

}
