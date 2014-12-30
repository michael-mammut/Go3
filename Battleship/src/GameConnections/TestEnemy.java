package GameConnections;

import java.awt.Point;

import GameUtilities.Command;
import GameUtilities.Ship;
import GameUtilities.ShipPosition;
import GameUtilities.ShipType;
import GameUtilities.Field.Field;

public class TestEnemy 
{
	private Field enemyField = new Field();
	private int commandNo = 0;
			
	public void attacBack()
	{
		
	}
	
	public void sendFieldInitCommand()
	{
		fillFieldWithShips();
		DataBox.pushReceiveCommand(createFieldInitCommand());
	}
	
	private Command createFieldInitCommand()
	{
		Command command = new Command(getNewCommandNo(), enemyField, "INIT_FIELD");
		return command;
	}
	
	private void fillFieldWithShips()
	{
		Ship ship = new Ship(new ShipPosition(new Point(4,5),"vertical"), ShipType.AIRCARRER, 1);
		enemyField.setShipOnField(ship);
		ship = new Ship(new ShipPosition(new Point(2,3),"vertical"), ShipType.DESTROYER, 2);
		enemyField.setShipOnField(ship);
		ship = new Ship(new ShipPosition(new Point(6,7),"vertical"), ShipType.YELLOW_SUBMARINE, 3);
		enemyField.setShipOnField(ship);
	}
	
	private int getNewCommandNo()
	{
		return ++this.commandNo;
	}
}
