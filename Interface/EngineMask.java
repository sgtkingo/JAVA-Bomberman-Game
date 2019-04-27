package Interface;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;

public interface EngineMask {
	public Viewable CheckWallColision(Viewable Object);
	public boolean SimplyWallCheckColision(Viewable Object);
	
	public boolean SimplyWallCheckColision(Node Tester);
	public boolean isFree(Node Tester);
	
	public void ExploseColision(IExplose Object);
	public void bombStatus();
	public boolean getBombStatus();
	
	
	public void add(Viewable O);
	public void addPlayer(IMovable Player);
	public void delete(Viewable O);
	
	public void setRoot(Group root);
	public Group getRoot();
	
	public void nextScene();
	public Scene getScene();
	
	public void TikTak();
	
	public void startEnigine();
	public void restartGame();
}
