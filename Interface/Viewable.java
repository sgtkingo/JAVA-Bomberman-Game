package Interface;

import javafx.scene.Node;

public interface Viewable {
	public Node getNode();
	public Object getInstance();
	public void getHit();
	
	public boolean isDead();
	
	public void update();	
	public double getX();
	public double getY();
}
