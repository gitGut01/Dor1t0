package Dor1t0myGame;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;

import com.jogamp.newt.event.KeyEvent;
import com.jogamp.newt.event.KeyListener;
import com.jogamp.opengl.GL3;

import graphics.Application2D;
import graphics.scene.Camera;
import graphics.scene.Scene;
import graphics.scene.SceneObject;



/**
 * 
 * Dor1t0s are arguably the most valuable substance in the universe. 
 * They are used in sandwiches, mountain dew and cold medicine. 
 * Dor1t0s are known for their essential minerals and have found their way into supplemental products. 
 * Scientist have discovered that Dor1t0s are made of the strongest material in existence, due to their unique Molecular Level Geometry (MLG). 
 *
 */

public class Dor1t0 extends Application2D implements KeyListener{

    private Scene scene;
    private boolean grow;
    

    ArrayList<Island> arr_island;// = new ArrayList<Island>();
    Stick stick;
    Player player;
    
    SceneObject nullObject;
    Camera camera;
   
    boolean initPause;
    boolean gameFaild;
    boolean restartGame;
    
    
    
	public Dor1t0() {
		
        super("Dor1t0", 500, 800);
        disableWarning();

    }
	
	public static void disableWarning() {
	    System.err.close();
	    System.setErr(System.out);
	}
	
	@Override
	public void init(GL3 gl) {
		 
	        setBackground(new Color(179, 218, 255));
	        // Create a scene
	        scene = new Scene();
	        
	        // Create a camera
	        nullObject = new SceneObject(scene.getRoot());        
	        camera = new Camera(nullObject);
	        scene.setCamera(camera);
	        camera.setScale(20); // scale the camera -> see more of the world  
	        
	        //Information:
	        
	        /*
	        String header = "#######################################\n" + 
	        
	        		"###   ____          ___   _   ___   ###\n" + 
	        		"###  |    \\ ___ ___|_  | | |_|   |  ###\n" + 
	        		"###  |  |  | . |  _|_| |_|  _| | |  ###\n" + 
	        		"###  |____/|___|_| |_____|_| |___|  ###\n" + 
	        		"###                                 ###\n" +
	        		"#######################################\n";
	        
	        String txt = "\n\nPRESS -----> SPACE <------  to start the game/input for the game/restart the game when gameOver";
	        //System.out.println(header + txt);
	        */
	        super.init(gl);
	        getWindow().addKeyListener(this);
	 
	        initObjects();

	    }
	  
	  
	  public void initObjects() {
	        arr_island = new ArrayList<Island>(Arrays.asList(new Island(scene.getRoot(), 0, Color.BLACK), new Island(scene.getRoot(), 1, Color.BLACK), new Island(scene.getRoot(), 2, Color.BLACK)));
	        player = new Player(scene.getRoot(), arr_island);
	        stick = new Stick(arr_island.get(0), arr_island, player, camera, nullObject);
	       
	        
	        
	        nullObject.setPosition(8, 0);
	        nullObject.setParent(player);
	        
	        arr_island.get(1).setPosition(20, -20);
	        arr_island.get(2).setPosition(40, -20);
	        grow = true;
	        
	        initPause = true;
	        gameFaild = false;
	        restartGame = false;
	  }
	
   
    /**
     * A simple example of how to use PolygonalSceneObject, CircularSceneObject and LineObject
     * 
     * and also how to put together a simple scene using the game engine.
     * 
     * @param args
     */
    public static void main(String[] args) {
        Dor1t0 test = new Dor1t0();
        
        test.start();
    }
    
    
    
    @Override
    public void display(GL3 gl) {
        super.display(gl);
        scene.draw(gl);
        
        if(!initPause) {
        	if(grow == true) {
        		stick.setGrowTrue();
        	
        	}else {
        		stick.setGrowFalse();
        	}
        
        }
       
        
        if(stick.isGameFaild()) {
        	gameFaild = true;
        	
        }
        
        
        
        if(restartGame) {
        	System.out.println("\n\nrestart");
        	restartGame = false;
        	
        	//Destroy old scenObjects
            scene.getRoot().destroy();
            
            
	        // Create a camera
            
	        nullObject = new SceneObject(scene.getRoot());
	        camera.setParent(nullObject, false);
	        
	        
	        initObjects();
	        
        }


        
        
    }
    
    

    @Override
    public void reshape(GL3 gl, int width, int height) {
        scene.getCamera().reshape(width, height);
    }


	
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
        	if(!gameFaild) {
        		grow = false;
        		initPause = false;
 
        	}else {
        		
        		restartGame = true;
        		gameFaild = false;
        	}
        }
    
        	
    }
    
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			grow = true; 
		}
	}
	

   

}
