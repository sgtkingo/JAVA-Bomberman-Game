package Core;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.Node;
//Rename to engine, set root and control
public class Colision extends Thread{
	final int delay=100;
	protected List<Node> NodeBuffer;
	
	public Colision() {
		NodeBuffer= new ArrayList<Node>();
		System.out.println("Colision system runnig...");
	}
	
	public void add(Node N) {	
		NodeBuffer.add(N);
		System.out.println("Object "+N.toString()+" added!");
	}
	
	public Node Check(Node B) {
		for(Node N: NodeBuffer) {
				if(N.getBoundsInParent().intersects(B.getBoundsInParent())) {
					if(N.equals(B))continue;
					System.out.println("Object "+N.toString()+" colision with " +B.toString()+"!");
					return B;
				}
				//System.out.println("Object "+N.toString()+" check!");
		}
		return null;
	}
	
	
	/*public void run() {
		while(true) {
			try {
			Thread.sleep(delay);
			}
			catch (InterruptedException e) {}
			Check();
		}
	}*/
}
