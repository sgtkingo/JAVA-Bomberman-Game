package Core;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Interface.EngineMask;
import Interface.IExplose;
import Interface.IMovable;
import Interface.ISolid;
import Interface.Viewable;
import Rooms.BasicRoom;
import Rooms.Rooms;
import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
//Rename to engine, set root and control
public class Engine implements EngineMask{
	
	Iterator I;
	TimerEngine timer;
	IMovable Player;
	ISolid bomb;
	boolean bobmStatus;
	private int Time=0;
	
	protected List<ISolid> WallBuffer;
	protected List<IMovable> EnemyBuffer;
	protected List<IExplose> ExpoloseBuffer;
	protected List<Viewable> ObjectsBuffer;
	
	protected List<Rooms> RoomsBuffer;
	protected Group primalRoot;
	protected Scene actual;
	protected Rooms actualroom;
	
	public Engine() {
		WallBuffer= new ArrayList<ISolid>();
		EnemyBuffer= new ArrayList<IMovable>();
		ExpoloseBuffer= new ArrayList<IExplose>();
		
		ObjectsBuffer= new ArrayList<Viewable>();
		RoomsBuffer= new ArrayList<Rooms>();
		
		createRoot();
		
		timer=new TimerEngine(this);
		Time=1000;
		
		System.out.println("Engine system runnig...");
		//initStage();
	}
	
	public void add(Viewable Object) {
		if(Object instanceof ISolid)
		{
			if(((ISolid)Object).isBomb())bomb=(ISolid)Object;
			WallBuffer.add((ISolid) Object);
		}
		if(Object instanceof IMovable)
			EnemyBuffer.add((IMovable) Object);
		if(Object instanceof IExplose)
			ExpoloseBuffer.add((IExplose) Object);
		
		ObjectsBuffer.add(Object);
		primalRoot.getChildren().add(Object.getNode());
		System.out.println("Object "+Object.toString()+" added!");
	}
	
	@Override
	public void delete(Viewable N) {
		if(N instanceof ISolid)
			WallBuffer.remove(N);
		if(N instanceof IMovable)
			EnemyBuffer.remove(N);
		if(N instanceof IExplose)
			ExpoloseBuffer.remove(N);
		
		ObjectsBuffer.remove(N);
		primalRoot.getChildren().remove(N.getNode());
		System.out.println("Object "+N.toString()+" deleted!");
	}
	
	public Viewable CheckWallColision(Viewable Object) {
		for(Viewable N: WallBuffer) {
				if(N.getNode().getBoundsInParent().intersects(Object.getNode().getBoundsInParent())) {
					if(N.equals(Object))continue;
					System.out.println("Object "+N.toString()+" colision with " +Object.toString()+"!");
					return Object;
				}
		}
		return null;
	}
	
	@Override
	public boolean SimplyWallCheckColision(Viewable Object) {
		for(Viewable N: WallBuffer) {
			if(N.getNode().getBoundsInParent().intersects(Object.getNode().getBoundsInParent())) {
				if(N.equals(Object))continue;
				/*if(Object instanceof IExplose ) {
					if(N.equals(bomb))
						return false;
				}*/
				System.out.println("Object "+N.toString()+" colision with " +Object.toString()+"!");
				return true;
			}
	}
	return false;
	}
	
	@Override
	public boolean SimplyWallCheckColision(Node Object) {
		for(Viewable N: WallBuffer) {
			if(N.getNode().getBoundsInParent().intersects(Object.getBoundsInParent())) {
				System.out.println("Object "+N.toString()+" colision with " +Object.toString()+"!");
				return true;
			}
	}
	return false;
	}
	
	public void ExploseColision(IExplose Object) {
		for(Viewable Tested: ObjectsBuffer) {
			if(Tested.getNode().getBoundsInParent().intersects(Object.getNode().getBoundsInParent())) {
				if(Tested.equals(Object))continue;
				Tested.getHit();
				//System.out.println("Object "+Object.toString()+" hit " +Tested.toString()+"!");
			}
		}
	}
	
	@Override
	public boolean isFree(Node Tester) {
		for(ISolid wall: WallBuffer) {
			if(wall.getNode().getBoundsInParent().intersects(Tester.getBoundsInParent())) {
				return false;
			}
		}
		return true;
	}
	
	
	public void setRoot(Group root) {
		if(root!=null) {
			primalRoot=root;
			System.out.println("New root set!");
		}
	}
	
	private void createRoot() {
		primalRoot= new Group();
		System.out.println("->New root created!");
	}
	
	public Group getRoot() {
		return primalRoot;
	}
	
	private void loadScene(Scene load) {
		actual=load;
	}
	
	public void nextScene() {
		System.out.println("->Loading next scene..");
		I=RoomsBuffer.iterator();
		if(I.hasNext()) {
			actualroom=(Rooms)I.next();
			actualroom.setPlayer(Player);
			loadScene(actualroom.getScene());
		}
		
	}
	
	public Scene getScene() {
		if(actual!=null)
		{
			return actual;		
		}
		else
		{
			System.out.println("No scene..");
			return null;
		}
	}
	
	protected Rooms getRoom() {
		return actualroom;
	}
	
	protected void loadRooms() {
		System.out.println("->Preparion all rooms..");
		RoomsBuffer.add(new BasicRoom(this));
	}
	
	
	public void startEnigine() {
		System.out.println("***Init stage***");
		loadRooms();
		nextScene();
		
	}
	
	public void updateAll() {
		if(getBombStatus()) {
			bomb.update();
		}
		//else if(ExpoloseBuffer.size()>0)
		for(Viewable object:ObjectsBuffer) {
			if(object!=null)
			object.update();
		}
	}

	@Override
	public void addPlayer(IMovable p) {
		Player=p;
		primalRoot.getChildren().add(Player.getNode());
		bobmStatus=false;
	}

	@Override
	public void bombStatus() {
		bobmStatus=!bobmStatus;
		if(bobmStatus) {
			timer.clockWatch(1000);
		}
	}

	@Override
	public boolean getBombStatus() {
		return bobmStatus;
	}

	@Override
	public void restartGame() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void TikTak() {
		updateAll();
		System.out.println("TikTak..."+System.currentTimeMillis());	
	}

	
	




	
}

