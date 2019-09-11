package Dor1t0myGame;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;


import graphics.geometry.Point2D;
import graphics.geometry.Polygon2D;
import graphics.scene.Camera;
import graphics.scene.PolygonalSceneObject;
import graphics.scene.SceneObject;

public class Stick extends PolygonalSceneObject{
	
	private float growRate;
	private float rotateRate;
	private boolean growBo;
	
	private boolean pause;
	
	Player player;
	ArrayList<Island> arr_island;
	int point;
	Camera camera;
	boolean gameFaild;
	Numbers nr;
	
	SceneObject nullObject;
	
	
	public Stick(SceneObject parent, ArrayList<Island> arr_island, Player player, Camera camera, SceneObject nullObject) {
		super(parent,
		new Polygon2D(new ArrayList<Point2D>(Arrays.asList( 
				new Point2D(0, 0), 
				new Point2D(0, 0), 
				new Point2D(-0.3f, 0), 
				new Point2D(-0.3f, 0)
				))),
				Color.BLACK, 
				null);
		
		this.translate(0, 15);
		growBo = false;
		pause = false;
		this.arr_island = arr_island; 
		this.player = player;
		this.camera = camera;
		gameFaild = false;
		this.nullObject = nullObject;
		nr = new Numbers(player, 0);
		nr.translate(1.5f, 4);
		nr.scale(0.2f);
		
		point = 0; 

	}
	
	public void setGrowTrue() {
		growBo = true;
	}
	
	public void setGrowFalse() {
		growBo = false;
	}
	
	
	public float getLength() {
		return growRate;
		
	}

	public boolean isGameFaild() {
		return gameFaild;
	}
	
	 @Override
	    public void updateSelf(float dt) {

		 	if(growBo && !pause) {
				growRate += 0.3f;
				rotateRate = 0;
				this.setPolygon(new Polygon2D(new ArrayList<Point2D>(Arrays.asList( 
						new Point2D(0, 0), 
						new Point2D(0, growRate), 
						new Point2D(-0.3f, growRate), 
						new Point2D(-0.3f, 0)
						))));
	
		        }else {
		        	if(growRate > 0.2f) {
		        		pause = true;
		        		
		        		
		        		if(this.getRotation() >= -90) {
		        			rotateRate -= 0.1f;
		        			this.rotate(rotateRate);
		        		
		        			//System.out.println(((Island) this.getParent()).getIslandNr());
		        			
		        		}else {
		        			
		        			Island thisIsland = arr_island.get((((Island) this.getParent()).getIslandNr()));
		        			float thisIslandPos = thisIsland.getGlobalPosition().getX();
		        			
		        			Island nextIsland = arr_island.get((((Island) this.getParent()).getIslandNr() + 1)%3);
		        			int nextIslandWidth = nextIsland.getIslandWidth();
		        			float nextIslandPos = nextIsland.getGlobalPosition().getX();
		        			
		        			
		       
		        			
		        			if((nextIslandPos + nextIslandWidth) - thisIslandPos > this.getLength() || nextIslandPos - thisIslandPos < this.getLength()) {
		        				if(this.getRotation() >= -175) {
				        			rotateRate -= 0.1f;
				        			this.rotate(rotateRate);
		        				}else {
		        			        X x1 = new X(thisIsland);
		        			        X x2 = new X(thisIsland);
		        			        
		        			        x1.setRotation(45);
		        			        x2.setRotation(-45);
		        			        
		        			        x1.setPosition(5, 20);
		        			        x2.setPosition(-5, 19);
		        			        
		        			        if(camera.getGlobalPosition().getX() >= player.getGlobalPosition().getX()) {
		        			        	nullObject.translate(-0.2f, 0.1f);
		        			        	//camera.translate(-0.4f, 0.1f);
		        			        	nr.translate(-0.2f, 0.04f);
		        			        }else {
		        			        	player.setLost();
		        			        	gameFaild = true;
		        			       }
		        				}
		        				
		        			
		        				
		        				
		        			}else {
		        				
		        				
		        				if(player.getGlobalPosition().getX() <= nextIslandPos - 1) {
		        					player.translate(0.3f, 0);
		        					
		        			
		        					
		        				
		        					
		        				}else {
		        					//because of some delay in the update function
		        					//The polygon is already reset here
		        					growRate = 0;
		        					this.setPolygon(new Polygon2D(new ArrayList<Point2D>(Arrays.asList( 
		        							new Point2D(0, 0), 
		        							new Point2D(0, growRate), 
		        							new Point2D(-0.3f, growRate), 
		        							new Point2D(-0.3f, 0)
		        							))));
		        					this.setParent(nextIsland, false);
		        					this.setRotation(0);
		        					
		       
		        					thisIsland.changeIslandSize();
		        					
		        					int t = 35 - (int)(Math.random()*6);
		        					
		        					
		        					//thisIsland.translate(t, 0);
		        					thisIsland.setPosition(nextIsland.getGlobalPosition().getX() + t, -20);
		        			
		        					
		        					
		        					point++; 
		        					nr.destroy();
		        					nr = new Numbers(player, point);
		        					nr.translate(1.5f, 4);
		        					nr.scale(0.2f);
		        					
		        					//System.out.println("Points: " + point);
		        					growBo = true;
		        					pause = false;
		        				}
		        				
		        			}

		        		}

		        	}
		   
		        }
		 
	 }
}
	 
	
	


