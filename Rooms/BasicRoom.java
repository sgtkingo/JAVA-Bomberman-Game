package Rooms;

import java.util.ArrayList;

import Core.Enemy;
import Core.Engine;
import Interface.IMovable;
import Interface.Viewable;
import javafx.scene.Scene;
import javafx.scene.paint.Color;

public class BasicRoom extends RoomManager{
	public BasicRoom(Engine GameEngine){
		this.GameEngine=GameEngine;
		Enemy=new ArrayList<IMovable>();
		Walls=new ArrayList<Viewable>();
		SolidWalls=new ArrayList<Viewable>();
		createRoom();
	}

	@Override
	public void createRoom() {
		System.out.println("Creating room "+this.toString()+"...");
		workplace= new Scene(GameEngine.getRoot(),DEFAULT_ROOM_WEIGHT,DEFAULT_ROOM_HEIGHT,Color.SANDYBROWN);	
		this.setUpRoom();
		this.makeOutline();
		this.addEnemys(96, 96);
		this.addEnemys(128, 96);
		this.addEnemys(64, 96);
		this.addEnemys(256, 128);
		this.render();
	}
		
	@Override
	public RoomManager getRoom() {
		return this;
	}
	@Override
	public void setPlayer(IMovable player) {
		player.getNode().setLayoutX(DEFAULT_PLAYER_START);
		player.getNode().setLayoutY(DEFAULT_PLAYER_START);	
	}
	

}
