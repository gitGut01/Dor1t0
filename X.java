package Dor1t0myGame;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;

import graphics.geometry.Point2D;
import graphics.geometry.Polygon2D;
import graphics.scene.PolygonalSceneObject;
import graphics.scene.SceneObject;

public class X extends PolygonalSceneObject{
	
	public X(SceneObject parent) {
		super(parent,
		new Polygon2D(new ArrayList<Point2D>(Arrays.asList( 
				
				new Point2D(0, 0), 
				new Point2D(0, 15), 
				new Point2D(-2, 15), 
				new Point2D(-2, 0)
				))),
				Color.RED,
				null);
		

		
	}
}
