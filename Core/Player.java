package Core;

import Interface.Direction;
import Interface.EngineMask;
import Interface.Entity;
import Interface.IMovable;
import Items.Bomb;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

public class Player extends Entity {
	Image leftImg, rightImg;
	
	public Player(EngineMask engine) {	
		defaultImg=new Image("res/ghost_stop.png");
		leftImg=new Image("res/ghost_left.png");
		rightImg=new Image("res/ghost_right.png");
		
		dx=0;
		dy=0;
		
		EntityVieW= new ImageView(defaultImg);
		Alive=true;
		GameEngine=engine;
		GameEngine.addPlayer(this);		
		
	}

	@Override
	public void doAction() {
		if(!this.GameEngine.getBombStatus()) {
			System.out.println("Plot bomb..!");
			new Bomb(GameEngine,this.getX(),this.getY());
		}
		else
		System.out.println("Bomb is NOT ready!");	
	}

	@Override
	public Node getNode() {
		// TODO Auto-generated method stub
		return EntityVieW;
	}

	@Override
	public Object getInstance() {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public void getHit() {
		// TODO Auto-generated method stub
		return;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		return;
	}

}


