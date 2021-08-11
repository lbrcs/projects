package themes;

import java.awt.Color;

/***************************************************************************************
* 	@Authors: Esam Ahmed & Martin Eidler
* 	Date: 05-08-2021
***************************************************************************************/

public class Jungle extends Theme {
	
	public Jungle() {
		super();
	}
	
	public Color setObstacle() {
		Color newObstacleColor = new Color(107, 65, 5);
		super.setObstacleColor(newObstacleColor);
		return super.getObstacleColor();
	}
	
	public Color[] setGround() {
		Color newGroundColor = new Color(17, 40, 24);
		Color newGoundTopColor = new Color(50, 92, 12);
		super.setGround(newGroundColor);
		super.setGroundTop(newGoundTopColor);
		Color[] colors = new Color[2];
		colors[0] = super.getGround();
		colors[1] = super.getGroundTop();
		return colors;
	}
	
	/*@Override
	public Color getObstacleColor() = new Color(107, 65, 5);
	public Color getGroundTop() = new Color(50, 92, 12);
	public Color getGround() = new Color(17, 40, 24);*/

	

	
}
