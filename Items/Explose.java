package Items;

import Interface.EngineMask;
import Interface.IExplose;
import Interface.Viewable;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Explose implements IExplose {
	EngineMask GameEngine;
	ImageView ExploseView;
	String sourceDefault="res/explose_real.png";
	int ExploseTimer;
	
	Explose(EngineMask engine,double x, double y, int timer){
		GameEngine=engine;
		ExploseView=new ImageView(new Image(sourceDefault));
		GameEngine.add(this);	
		
		ExploseView.setX(x);
		System.out.println("Explose x:"+ x);
		ExploseView.setY(y);
		System.out.println("Explose y:"+ y);
		
		ExploseTimer=timer;
		
		activate();
	}

	@Override
	public Node getNode() {
		return ExploseView;
	}

	@Override
	public Object getInstance() {
		return this;
	}

	@Override
	public void update() {
		if(ExploseTimer>0) {
			ExploseTimer--;
			GameEngine.ExploseColision(this);
		}
		else
			GameEngine.delete(this);
	}
	
	@Override
	public double getX() {
		return ExploseView.getX();
	}
	@Override
	public double getY() {
		return ExploseView.getY();
	}

	@Override
	public void getHit() {
		return;	
	}

	@Override
	public void activate() {
		GameEngine.ExploseColision(this);
		if(GameEngine.SimplyWallCheckColision(this)) {
			GameEngine.delete(this);
		}	
	}

}
