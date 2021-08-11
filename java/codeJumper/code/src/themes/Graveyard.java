package themes;

import java.awt.Color;

/***************************************************************************************
* 	@Authors: Esam Ahmed & Martin Eidler
* 	Date: 05-08-2021
***************************************************************************************/

public class Graveyard extends Theme {

	public Graveyard() {
		super();
	}
	
	public Color setObstacle() {
		Color newObstacleColor = new Color(1, 31, 41);
		super.setObstacleColor(newObstacleColor);
		return super.getObstacleColor();
	}
	
	public Color[] setGround() {
		Color newGroundColor = new Color(0,123,130);
		Color newGoundTopColor = new Color(7, 166, 169);
		super.setGround(newGroundColor);
		super.setGroundTop(newGoundTopColor);
		Color[] colors = new Color[2];
		colors[0] = super.getGround();
		colors[1] = super.getGroundTop();
		return colors;
	}

}
