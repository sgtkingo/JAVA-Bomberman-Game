package Interface;

import Interface.Direction;
import Interface.IMovable;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

public abstract class Entity extends Direction implements IMovable {
	
	protected ImageView EntityVieW;
	protected Image defaultImg;

	protected EngineMask GameEngine;
	protected final static int step=5;
	protected int direction;
	protected boolean Alive;
	
	protected Rectangle colisionTester;
	
	protected int dx,dy;
	
	@Override
	public void moveUp() {
		direction=UP;
		if(!isWallColized(0,-(step+1))){
			EntityVieW.setTranslateY(EntityVieW.getTranslateY()-step);
		}
		else
		{
			System.out.println("Colize UP!");
			stepBack();
		}
	}
	
	@Override
	public void moveDown(){
		direction=DOWN;
		if(!isWallColized(0,(step+1))){
			EntityVieW.setTranslateY(EntityVieW.getTranslateY()+step);
		}
		else
		{
			System.out.println("Colize DOWN!");
			stepBack();
		}
	}
	@Override
	public void moveLeft() {
		direction=LEFT;
		if(!isWallColized((-(step+1)),0)){
			EntityVieW.setTranslateX(EntityVieW.getTranslateX()-step);
		}
		else
		{
			System.out.println("Colize LEFT!");
			stepBack();
		}
	}
	@Override
	public void moveRight() {
		direction=RIGHT;
		if(!isWallColized((step+1),0)){
			EntityVieW.setTranslateX(EntityVieW.getTranslateX()+step);
		}
		else
		{
			System.out.println("Colize RIGHT!");
			stepBack();
		}
	}
	

	@Override
	public abstract void doAction();
	
	protected void stepBack() {
		switch(this.direction) {
		case UP:
		{
			EntityVieW.setTranslateY(EntityVieW.getTranslateY()+1);
			break;
		}
		case DOWN:
		{
			EntityVieW.setTranslateY(EntityVieW.getTranslateY()-1);
			break;
		}
		case LEFT:
		{
			EntityVieW.setTranslateX(EntityVieW.getTranslateX()+1);
			break;
		}
		case RIGHT:
		{
			EntityVieW.setTranslateX(EntityVieW.getTranslateX()-1);
			break;
		}
		
		}	
	}

	@Override
	public boolean isAlive() {
		return Alive;
	}


	public void isExploseColized() {
			return;
	}
	
	public void isColized() {
			return;
	}
	
	public boolean isWallColized(int dirx, int diry) {
		dx=dirx;
		dy=diry;
		colisionTester=getOffsetBounds();
		return GameEngine.SimplyWallCheckColision(colisionTester);
	}


	@Override
	public void setPozition(double x, double y) {
		EntityVieW.setTranslateX(x);
		EntityVieW.setTranslateY(y);
		
	}
	

	
	@Override
	public double getX() {
		return (getNode().getTranslateX()+getNode().getLayoutX());
	}
	@Override
	public double getY() {
		return (getNode().getTranslateY()+getNode().getLayoutY());
	}
	
	
	@Override
	public double getImageW() {
		return EntityVieW.getImage().getWidth();
	}
	@Override
	public double getImageH() {
		return EntityVieW.getImage().getHeight();
	}
	
	protected Rectangle getOffsetBounds() {
		System.out.println("Tested X:"+(getX()+dx)+" Y:"+(getY()+dy)+" offset:"+dx+"|"+dy);
		System.out.println("Actual X:"+(getX())+" Y:"+(getY()));
		return new Rectangle(getX()+dx,getY()+dy,getImageW(),getImageH());
	}

}
