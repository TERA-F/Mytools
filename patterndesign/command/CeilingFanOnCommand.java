package command;

public class CeilingFanOnCommand implements Command{
	CeilingFan ceilingfan;

	public CeilingFanOnCommand(CeilingFan ceilifan) {
		// TODO Auto-generated constructor stub
		this.ceilingfan = ceilifan;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		ceilingfan.on();
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		ceilingfan.off();
	}
	
	

}
