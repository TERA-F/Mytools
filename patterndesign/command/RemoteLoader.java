package command;

import javax.crypto.Mac;

public class RemoteLoader {
	/*
	public static void main(String[] args){
		RemoteControl remoteControl = new RemoteControl();
		
		Light livingRoomLight = new Light("Living Room");
		Light kitchenLight = new Light("Kitchen");
		CeilingFan ceilifan = new CeilingFan("Living Room");
		GarageDoor garageDoor = new GarageDoor("garagedoor");
		Stereo stereo = new Stereo("Living room");
		
		LightOnCommand livingRoomLightOn = new LightOnCommand(livingRoomLight);
		LightOffCommand livingRoomLightOff = new LightOffCommand(livingRoomLight);
		LightOnCommand KitchenLightOn = new LightOnCommand(kitchenLight);
		LightOffCommand KitchenLightOff = new LightOffCommand(kitchenLight);
		
		CeilingFanOnCommand cleilingFanon = new CeilingFanOnCommand(ceilifan);
		CeilingFanOffCommand ceilingFanoff = new CeilingFanOffCommand(ceilifan);
		
		GarageDoorUpCommand garageDoorUp = new GarageDoorUpCommand(garageDoor);
		GarageDoorDownCommand garageDoorDown = new GarageDoorDownCommand(garageDoor);
		
		StereoOnWithCDCommand stereoOnWithCD = new StereoOnWithCDCommand(stereo);
		StereoOffWithCDCommand stereoOffWithCD = new StereoOffWithCDCommand(stereo);
		
		remoteControl.setCommand(0, livingRoomLightOn, livingRoomLightOff);
		remoteControl.setCommand(1, KitchenLightOn, KitchenLightOff);
		remoteControl.setCommand(2, cleilingFanon, ceilingFanoff);
		remoteControl.setCommand(3, garageDoorUp, garageDoorDown);
		remoteControl.setCommand(4, stereoOnWithCD, stereoOffWithCD);
		
		System.out.println(remoteControl);
		
		remoteControl.onButtonWasPushed(0);
		remoteControl.offButtonWasPushed(0);
		remoteControl.onButtonWasPushed(1);
		remoteControl.offButtonWasPushed(1);
		remoteControl.onButtonWasPushed(2);
		remoteControl.offButtonWasPushed(2);
		remoteControl.onButtonWasPushed(3);
		remoteControl.offButtonWasPushed(3);
		remoteControl.onButtonWasPushed(4);
		remoteControl.offButtonWasPushed(4);
	}

	
	
	public static void main(String[] args){
		RemoteControlWithUndo remoteControl = new RemoteControlWithUndo();
		Light livingRoomLight = new Light("Living Room");
		
		LightOnCommand livingRoomLightOn = new LightOnCommand(livingRoomLight);
		LightOffCommand liviingOffCommandOff = new LightOffCommand(livingRoomLight);
		
		remoteControl.setCommand(0, livingRoomLightOn, liviingOffCommandOff);
		
		remoteControl.onButtonWasPushed(0);
		remoteControl.offButtonWasPushed(0);
		System.out.println(remoteControl);
		remoteControl.undoButtonWasPushed();
		remoteControl.offButtonWasPushed(0);
		remoteControl.onButtonWasPushed(0);
		System.out.println(remoteControl);
		remoteControl.undoButtonWasPushed();

	}
	


	public static void main(String[] args){
		RemoteControlWithUndo remoteControl = new RemoteControlWithUndo();
		CeilingFan ceilingFan = new CeilingFan("Living Room");
		CeilingFanMediumCommand ceilingFanMedium = new CeilingFanMediumCommand(ceilingFan);
		CeilingFanHighCommand ceilingFanHigh = new CeilingFanHighCommand(ceilingFan);
		CeilingFanOffCommand ceilingFanoff = new CeilingFanOffCommand(ceilingFan);
		
		remoteControl.setCommand(0, ceilingFanMedium, ceilingFanoff);
		remoteControl.setCommand(1, ceilingFanHigh, ceilingFanoff);
		
		remoteControl.onButtonWasPushed(0);
		remoteControl.offButtonWasPushed(1);
		System.out.println(remoteControl);
		remoteControl.undoButtonWasPushed();
		
		remoteControl.onButtonWasPushed(1);
		System.out.println(remoteControl);
		remoteControl.undoButtonWasPushed();
	}
*/
	public static void main(String[] args){
		RemoteControlWithUndo remoteControl = new RemoteControlWithUndo();
		
		Light livingRoomLight = new Light("Living Room");
		Light kitchenLight = new Light("Kitchen");
		CeilingFan ceilifan = new CeilingFan("Living Room");
		GarageDoor garageDoor = new GarageDoor("garagedoor");
		Stereo stereo = new Stereo("Living room");
	
		LightOnCommand livingRoomLightOn = new LightOnCommand(livingRoomLight);
		LightOffCommand livingRoomLightOff = new LightOffCommand(livingRoomLight);
		LightOnCommand KitchenLightOn = new LightOnCommand(kitchenLight);
		LightOffCommand KitchenLightOff = new LightOffCommand(kitchenLight);
		
		CeilingFanOnCommand cleilingFanon = new CeilingFanOnCommand(ceilifan);
		CeilingFanOffCommand ceilingFanoff = new CeilingFanOffCommand(ceilifan);
		
		GarageDoorUpCommand garageDoorUp = new GarageDoorUpCommand(garageDoor);
		GarageDoorDownCommand garageDoorDown = new GarageDoorDownCommand(garageDoor);
		
		StereoOnWithCDCommand stereoOnWithCD = new StereoOnWithCDCommand(stereo);
		StereoOffWithCDCommand stereoOffWithCD = new StereoOffWithCDCommand(stereo);
	
		Command[] partyOn = {livingRoomLightOn,KitchenLightOn,cleilingFanon,garageDoorUp};
		Command[] partyOff = {livingRoomLightOff,KitchenLightOff,ceilingFanoff,garageDoorDown};
		
		MacroCommand partyOnMacro = new MacroCommand(partyOn);
		MacroCommand partyOffMacro = new MacroCommand(partyOff);
		remoteControl.setCommand(0, partyOnMacro, partyOffMacro);
		
		System.out.println(remoteControl);
		System.out.println("--- Pushing Macro On ---");
		remoteControl.onButtonWasPushed(0);
		System.out.println("--- Pushing Macro Off ---");
		remoteControl.offButtonWasPushed(0);
	}
}