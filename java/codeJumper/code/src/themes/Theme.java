package themes;

import java.awt.Color;

/***************************************************************************************
* 	@Authors: Esam Ahmed & Martin Eidler
* 	Date: 05-08-2021
***************************************************************************************/

public abstract class Theme {
	
	private Color obstacleColor;
	private Color groundTop;
	private Color ground;
	
	// constructor
	public Theme() {
		super();
	}

	public abstract Color setObstacle();
	public abstract Color[] setGround();
	
	// getter & setter
	public Color getObstacleColor() {
		return obstacleColor;
	}

	public void setObstacleColor(Color obstacleColor) {
		this.obstacleColor = obstacleColor;
	}

	public Color getGroundTop() {
		return groundTop;
	}

	public void setGroundTop(Color groundTop) {
		this.groundTop = groundTop;
	}

	public Color getGround() {
		return ground;
	}

	public void setGround(Color ground) {
		this.ground = ground;
	}
	
	

}
