package Interface;

import javafx.scene.Node;
import javafx.scene.image.ImageView;

public interface IMovable extends Viewable{
		public void moveUp();
		public void moveDown();
		public void moveLeft();
		public void moveRight();
		
		public void setPozition(double x, double y);
		
		public void doAction();
		
		public double getX();
		public double getY();
		
		public double getImageW();
		public double getImageH();

}
