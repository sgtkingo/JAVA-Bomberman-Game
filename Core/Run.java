package Core;

import Interface.EngineMask;
import Interface.IMovable;
import Interface.ISolid;
import Items.Wall;
import javafx.application.Application;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class Run extends Application {

	@Override
	public void start(Stage stage) throws Exception {

		/*stage.setScene(createScene());
		stage.setTitle("Bomber-Man");*/
		
		EngineMask GameEngine= new Engine();
		IMovable Player= new Player(GameEngine);
		GameEngine.startEnigine();
		stage.setTitle("Bomber-Man");
		stage.setScene(GameEngine.getScene());

		ISolid Wall= new Wall(false,GameEngine);

		Wall.setPozition(200, 200);
		GameEngine.add(Wall);

		GameEngine.getScene().setOnKeyPressed((KeyEvent event) -> {
			if(event.getCode()==KeyCode.W) {
				Player.moveUp();
				
			}
			if(event.getCode()==KeyCode.S) {
				Player.moveDown();
			}

			if(event.getCode()==KeyCode.A) {
				Player.moveLeft();
			}

			if(event.getCode()==KeyCode.D) {
				Player.moveRight();
			}
			
			if(event.getCode()==KeyCode.SPACE) {
				Player.doAction();
			}
			});
		
		stage.show();
	}
	
	public static void main(String[] args) {		
		System.out.println("Runing FX app...");
		launch("MyApp");
	}
	


}
