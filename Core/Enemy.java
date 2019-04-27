package Core;

import Interface.EngineMask;
import Interface.Entity;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Enemy extends Entity{

	
	public Enemy(EngineMask engine) {	
		defaultImg=new Image("res/ghost.png");
		
		dx=0;
		dy=0;
		
		EntityVieW= new ImageView(defaultImg);
		Alive=true;
		GameEngine=engine;
		GameEngine.add(this);		
		
	}
	@Override
	public Object getInstance() {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public void getHit() {
		System.out.println("Enemy hit!");		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doAction() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public Node getNode() {
		return this.EntityVieW;
	}

}
