package command;

public class GarageDoorDownCommand implements Command {
	GarageDoor garagedoor;
	
	public GarageDoorDownCommand(GarageDoor garageDoor) {
		// TODO Auto-generated constructor stub
		this.garagedoor = garageDoor;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		garagedoor.close();
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		garagedoor.open();
	}

}
