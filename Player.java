package Dor1t0myGame;
import java.util.ArrayList;
import graphics.scene.MyCoolSceneObject;
import graphics.scene.Scene;
import graphics.scene.SceneObject;

public class Player extends MyCoolSceneObject{
	
	SceneObject parent;
	Scene scene;
	ArrayList<Island> arr_island;
	boolean lost;
	
	
	public Player(SceneObject parent, ArrayList<Island> arr_island) {
		super(parent);
		
		this.scale(5);
		this.arr_island = arr_island;
	
		this.translate(arr_island.get(0).getGlobalPosition().getX() - 1, -5);
		
		this.getMLG().translate(0, -0.64f);
		lost = false;
	}
	
	public void setLost() {
		lost = true;
	}
	
	@Override
    public void updateSelf(float dt) {
        // Do nothing by default
		
		if(lost) {
			this.getMLG().translate(0.01f, 0);
		}
    }
	
	

	

	
	


}
