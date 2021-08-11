package themes;

import java.awt.Color;

/***************************************************************************************
* 	@Authors: Esam Ahmed & Martin Eidler
* 	Date: 05-08-2021
***************************************************************************************/

public class Desert extends Theme {

	public Desert() {
		super();
	}
	
	public Color setObstacle() {
		Color newObstacleColor = new Color(42, 64, 22);
		super.setObstacleColor(newObstacleColor);
		return super.getObstacleColor();
	}
	
	public Color[] setGround() {
		Color newGroundColor = new Color(230, 159, 79);
		Color newGoundTopColor = new Color(17, 32, 8);
		super.setGround(newGroundColor);
		super.setGroundTop(newGoundTopColor);
		Color[] colors = new Color[2];
		colors[0] = super.getGround();
		colors[1] = super.getGroundTop();
		return colors;
	}

}
