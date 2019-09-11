package Dor1t0myGame;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;

import graphics.geometry.Point2D;
import graphics.geometry.Polygon2D;
import graphics.scene.PolygonalSceneObject;
import graphics.scene.SceneObject;



public class Numbers extends SceneObject{
	private int nr;
	ArrayList<ArrayList<int[]>> arrNr; 
	
	public Numbers(SceneObject parent, int nr) {
		super(parent);
		this.nr = nr;
		arrNr = new ArrayList<ArrayList<int[]>>(Arrays.asList(
				make0(), make1(), make2(), make3(),
				make4(), make5(), make6(), make7(),
				make8(), make9(), make0()
				));
		
		
		printNr();
		
	}
	
	
	//support up to 999
	//After that nothing is printed out
	public void printNr() {

    	SceneObject nullObject = new SceneObject(this);
    	nullObject.setPosition(0, 0);
    	
    	if(nr < 10) {
    		
    		for(int i = 0; i < 5; i++) {
    			//print each line of pixels
    			printXPixel(arrNr.get(nr).get(i), nullObject, i);
    		}
	    	
    	}else if(nr < 100){
        	nullObject.setPosition(-2, 0);
        	
    		for(int i = 0; i < 5; i++) {
    			//print each line of pixels
    			printXPixel(arrNr.get((nr-nr%10)/10).get(i), nullObject, i);
    		}
    		
    		nullObject = new SceneObject(this);
        	nullObject.setPosition(2f, 0);
        	
    		for(int i = 0; i < 5; i++) {
    			//print each line of pixels
    			printXPixel(arrNr.get(nr%10).get(i), nullObject, i);
    		}
    		
    	}else if (nr < 1000) {
        	nullObject.setPosition(-4, 0);
        	
    		for(int i = 0; i < 5; i++) {
    			//print each line of pixels
    			printXPixel(arrNr.get((nr-nr%100)/100).get(i), nullObject, i);
    		}
    		
    		nullObject = new SceneObject(this);
        	nullObject.setPosition(0, 0);
        	
        	int k = ((nr - (nr%10)) - (nr - (nr%100)));
        	k = (k-k%10)/10;
        	
    		for(int i = 0; i < 5; i++) {
    			//print each line of pixels
    			printXPixel(arrNr.get(k).get(i), nullObject, i);
    		}
    		
    		
    		nullObject = new SceneObject(this);
        	nullObject.setPosition(4, 0);
        	
    		for(int i = 0; i < 5; i++) {
    			//print each line of pixels
    			printXPixel(arrNr.get(nr%10).get(i), nullObject, i);
    		}
    	}

	}
	
	
	
    public ArrayList<int[]> make1() {
    	
    	int[] i1 = {0, 1, 0};
    	int[] i2 = {0, 1, 0};
    	int[] i3 = {0, 1, 0};
    	int[] i4 = {0, 1, 0};
    	int[] i5 = {0, 1, 0};
    	
    	return new ArrayList<int[]>(Arrays.asList(i1, i2, i3, i4, i5));

    	
    }
    
    public  ArrayList<int[]> make2() {
    	
    	int[] i1 = {1, 1, 1};
    	int[] i2 = {0, 0, 1};
    	int[] i3 = {1, 1, 1};
    	int[] i4 = {1, 0, 0};
    	int[] i5 = {1, 1, 1};

    	
    	return new ArrayList<int[]>(Arrays.asList(i1, i2, i3, i4, i5));
    	
    }
    
    public  ArrayList<int[]> make3() {
    	
    	int[] i1 = {1, 1, 1};
    	int[] i2 = {0, 0, 1};
    	int[] i3 = {1, 1, 1};
    	int[] i4 = {0, 0, 1};
    	int[] i5 = {1, 1, 1};
    	
    	return new ArrayList<int[]>(Arrays.asList(i1, i2, i3, i4, i5));
    }

    public ArrayList<int[]> make4() {
    	
    	int[] i1 = {1, 0, 1};
    	int[] i2 = {1, 0, 1};
    	int[] i3 = {1, 1, 1};
    	int[] i4 = {0, 0, 1};
    	int[] i5 = {0, 0, 1};
    	
    	return new ArrayList<int[]>(Arrays.asList(i1, i2, i3, i4, i5));
    	
    }
  
    public  ArrayList<int[]> make5() {
    	

    	int[] i1 = {1, 1, 1};
    	int[] i2 = {1, 0, 0};
    	int[] i3 = {1, 1, 1};
    	int[] i4 = {0, 0, 1};
    	int[] i5 = {1, 1, 1};
    	
    	
    	return new ArrayList<int[]>(Arrays.asList(i1, i2, i3, i4, i5));
    	
    }
    
    public  ArrayList<int[]> make6() {
    	

    	int[] i1 = {1, 1, 1};
    	int[] i2 = {1, 0, 0};
    	int[] i3 = {1, 1, 1};
    	int[] i4 = {1, 0, 1};
    	int[] i5 = {1, 1, 1};
    	
    	return new ArrayList<int[]>(Arrays.asList(i1, i2, i3, i4, i5));
    	
    }
    
    public  ArrayList<int[]> make7() {
    	

    	int[] i1 = {1, 1, 1};
    	int[] i2 = {0, 0, 1};
    	int[] i3 = {0, 0, 1};
    	int[] i4 = {0, 0, 1};
    	int[] i5 = {0, 0, 1};
    	
    	
    	return new ArrayList<int[]>(Arrays.asList(i1, i2, i3, i4, i5));
    	
    }
    
    public  ArrayList<int[]> make8() {
    	

    	int[] i1 = {1, 1, 1};
    	int[] i2 = {1, 0, 1};
    	int[] i3 = {1, 1, 1};
    	int[] i4 = {1, 0, 1};
    	int[] i5 = {1, 1, 1};
    	
    	
    	return new ArrayList<int[]>(Arrays.asList(i1, i2, i3, i4, i5));
    	
    }
    
    public  ArrayList<int[]> make9() {
    	

    	int[] i1 = {1, 1, 1};
    	int[] i2 = {1, 0, 1};
    	int[] i3 = {1, 1, 1};
    	int[] i4 = {0, 0, 1};
    	int[] i5 = {0, 0, 1};
    	
    	return new ArrayList<int[]>(Arrays.asList(i1, i2, i3, i4, i5));
    	
    }

    public  ArrayList<int[]> make0() {
    	

    	int[] i1 = {1, 1, 1};
    	int[] i2 = {1, 0, 1};
    	int[] i3 = {1, 0, 1};
    	int[] i4 = {1, 0, 1};
    	int[] i5 = {1, 1, 1};
    	
    	
    	return new ArrayList<int[]>(Arrays.asList(i1, i2, i3, i4, i5));
    	
    }
    
    //Print one row of pixels in the sunglasses
    
    public void printXPixel(int[] arr, SceneObject parent, int y) {
    	
    	for (int i = 0; i < arr.length; i++) {
    		if(arr[i] == 1) {
    			BlackPixel(parent, new Color(47,79,79), i, y);
    		}else if(arr[i] == 2){
    			BlackPixel(parent, Color.WHITE, i, y);
   		 	}else {
   		 		BlackPixel(parent, null, i, y);
   		 }
    	}
    }
    
    
    //One pixel 
    public SceneObject BlackPixel(SceneObject parent, Color color, int x, int y) {

    	PolygonalSceneObject p = new PolygonalSceneObject(parent,
		new Polygon2D(new ArrayList<Point2D>(Arrays.asList( 
				
				new Point2D(0, 0), 
				new Point2D(0, 1), 
				new Point2D(1, 1), 
				new Point2D(1, 0)
				))),
				color, 
				null);
    	
    	p.translate(x, -y);
    	return p;
    	
    	
    }

}
