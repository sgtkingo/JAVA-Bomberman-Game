package Items;

import Interface.EngineMask;
import Interface.ISolid;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Wall implements ISolid{
	EngineMask GameEngine;
	boolean isSolid;
	ImageView WallVieW;
	String SourceNormal="res/wall_block_cracked2.png";
	String SourceSolid="res/wall_block.png";
	
	
	public Wall(boolean solid, EngineMask engine) {
		GameEngine=engine;
		if(isSolid=solid) {
			WallVieW= new ImageView(new Image(SourceSolid));
		}
		else
		{
			WallVieW= new ImageView(new Image(SourceNormal));
		}
		
	}
	@Override
	public void getHit() {
		if(isSolid()) {
			System.out.println("This wall "+WallVieW.toString()+" was hit!");
		}
		else
		{
			System.out.println("This wall "+WallVieW.toString()+" was destroy!");
			GameEngine.delete(this);
		}
		
	}

	@Override
	public Node getNode() {
		return WallVieW;
	}
	@Override
	public void setPozition(double x, double y) {
		WallVieW.setX(x);
		WallVieW.setY(y);		
	}
	@Override
	public boolean isSolid() {
		return isSolid;
	}
	@Override
	public Object getInstance() {
		// TODO Auto-generated method stub
		return this;
	}
	
	@Override
	public double getX() {
		return WallVieW.getX();
	}
	@Override
	public double getY() {
		return WallVieW.getY();
	}
	@Override
	public void update() {
		return;
		
	}
	@Override
	public boolean isBomb() {
		return false;
	}

}
