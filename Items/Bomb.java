package Items;

import Interface.EngineMask;
import Interface.ISolid;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Bomb implements ISolid{
	
	EngineMask GameEngine;
	ImageView BombView;
	String sourceDefault="res/bomb.png";
	int ExploseTimer;
	
	double xpos,ypos;
	
	public Bomb(EngineMask engine, double x, double y){
		GameEngine=engine;
		BombView=new ImageView(new Image(sourceDefault));
		setPozition(x,y);
		
		ExploseTimer=1000;
		GameEngine.add(this);
		GameEngine.bombStatus();
	}
	@Override
	public Node getNode() {
		return BombView;
	}

	@Override
	public Object getInstance() {
		return this;
	}


	private void Explose() {
			GameEngine.bombStatus();
			GameEngine.delete(this);
			new Explose(GameEngine,getX()+32,getY(),ExploseTimer/2);
			new Explose(GameEngine,getX(),getY()-32,ExploseTimer/2);
			new Explose(GameEngine,getX(),getY()+32,ExploseTimer/2);
			new Explose(GameEngine,getX()-32,getY(),ExploseTimer/2);
			new Explose(GameEngine,getX(),getY(),ExploseTimer/2);
			
	}
	@Override
	public void update() {
		Explose();
	}
	@Override
	public double getX() {
		return BombView.getX();
	}
	@Override
	public double getY() {
		return BombView.getY();
	}
	@Override
	public void getHit() {
		return;
		
	}
	@Override
	public boolean isSolid() {
		return true;
	}
	@Override
	public void setPozition(double x, double y) {
		xpos=x;
		ypos=y;
		BombView.setX(x);
		BombView.setY(y);
	}
	@Override
	public boolean isBomb() {
		return true;
	}

}
