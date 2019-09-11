package Dor1t0myGame;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;

import graphics.geometry.Point2D;
import graphics.geometry.Polygon2D;
import graphics.scene.PolygonalSceneObject;
import graphics.scene.SceneObject;

public class Island extends PolygonalSceneObject{
	
	private int i;
	private int islandNr;
	
	public Island(SceneObject parent, int islandNr, Color c) {
		super(parent,
		new Polygon2D(new ArrayList<Point2D>(Arrays.asList( 
				
				new Point2D(0, 0), 
				new Point2D(0, 15), 
				new Point2D(-7, 15), 
				new Point2D(-7, 0)
				))),
				c, 
				null);
		
		this.translate(0, -20);
		changeIslandSize();
		this.islandNr = islandNr;
		
	}
	
	public void changeIslandSize() {
		
		i = (int)(Math.random()*4);
		this.setPolygon(new Polygon2D(new ArrayList<Point2D>(Arrays.asList( 
				
				new Point2D(0, 0), 
				new Point2D(0, 15), 
				new Point2D(-7 + i , 15), 
				new Point2D(-7 + i, 0)
				))));
	}
	
	
	
	public int getIslandWidth() {
		return -7 + i;
	}
	
	public int getIslandNr() {
		return islandNr;
	}

	
	

	
}
