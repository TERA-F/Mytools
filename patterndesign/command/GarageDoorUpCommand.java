package command;

public class GarageDoorUpCommand implements Command {
	GarageDoor garagedoor;
	
	public GarageDoorUpCommand(GarageDoor garageDoor) {
		// TODO Auto-generated constructor stub
		this.garagedoor =garageDoor;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		garagedoor.open();
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		garagedoor.close();
	}

}
