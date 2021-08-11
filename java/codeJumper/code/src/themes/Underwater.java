package themes;

import java.awt.Color;

/***************************************************************************************
* 	@Authors: Esam Ahmed & Martin Eidler
* 	Date: 05-08-2021
***************************************************************************************/

public class Underwater extends Theme {

	public Underwater() {
		super();
	}
	
	public Color setObstacle() {
		Color newObstacleColor = new Color(129, 173, 244);
		super.setObstacleColor(newObstacleColor);
		return super.getObstacleColor();
	}
	
	public Color[] setGround() {
		Color newGroundColor = new Color(17, 216, 255);
		Color newGoundTopColor = new Color(25, 39, 160);
		super.setGround(newGroundColor);
		super.setGroundTop(newGoundTopColor);
		Color[] colors = new Color[2];
		colors[0] = super.getGround();
		colors[1] = super.getGroundTop();
		return colors;
	}

}
