package command;

public class CeilingFanHighCommand implements Command {
	CeilingFan ceilingfan;
	int prevSpeed;
	
	CeilingFanHighCommand(CeilingFan ceilingFan){
		this.ceilingfan = ceilingFan;
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		prevSpeed = ceilingfan.getSpeed();
		ceilingfan.high();
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
