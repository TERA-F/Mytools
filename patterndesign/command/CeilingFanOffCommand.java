package command;

public class CeilingFanOffCommand implements Command {
/*
	CeilingFan ceilingfan;
	
	public CeilingFanOffCommand(CeilingFan ceilifan) {
		// TODO Auto-generated constructor stub
		this.ceilingfan = ceilifan;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		ceilingfan.off();
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		ceilingfan.on();
	}
*/
	
	CeilingFan ceilingfan;
	int prevSpeed;
	
	CeilingFanOffCommand(CeilingFan ceilingFan){
		this.ceilingfan = ceilingFan;
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		prevSpeed = ceilingfan.getSpeed();
		ceilingfan.off();
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		if(prevSpeed == CeilingFan.HIGH){
			ceilingfan.high();
		}else if(prevSpeed == CeilingFan.MEDIUM){
			ceilingfan.medium();
		}else if(prevSpeed == CeilingFan.LOW){
			ceilingfan.low();
		}else if(prevSpeed == CeilingFan.OFF){
			ceilingfan.off();
		}
	}
}
