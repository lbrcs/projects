package themes;

import java.awt.Color;

/***************************************************************************************
* 	@Authors: Esam Ahmed & Martin Eidler
* 	Date: 05-08-2021
***************************************************************************************/

public class Ice extends Theme {

	public Ice() {
		super();
	}
	
	public Color setObstacle() {
		Color newObstacleColor = new Color(231, 240, 249);
		super.setObstacleColor(newObstacleColor);
		return super.getObstacleColor();
	}
	
	public Color[] setGround() {
		Color newGroundColor = new Color(135, 199, 211);
		Color newGoundTopColor = new Color(77, 184, 216);
		super.setGround(newGroundColor);
		super.setGroundTop(newGoundTopColor);
		Color[] colors = new Color[2];
		colors[0] = super.getGround();
		colors[1] = super.getGroundTop();
		return colors;
	}

}
