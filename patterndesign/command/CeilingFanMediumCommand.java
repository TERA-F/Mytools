package command;

public class CeilingFanMediumCommand implements Command {
	CeilingFan ceilingfan;
	int prevSpeed;
	
	CeilingFanMediumCommand(CeilingFan ceilingFan){
		this.ceilingfan = ceilingFan;
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		prevSpeed = ceilingfan.getSpeed();
		ceilingfan.medium();
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
