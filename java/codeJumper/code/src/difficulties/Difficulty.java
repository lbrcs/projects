package difficulties;

/***************************************************************************************
* 	@Authors: Esam Ahmed & Martin Eidler
* 	Date: 05-08-2021
***************************************************************************************/

public abstract class Difficulty {

	private int gameTempo;
	private int playerJumpHeight;
	private int obstacleGapWidth;
	private int obstacleGapPlacement;
	private double pointsMultiplier;
	
	public Difficulty() {
		super();
	}
	
	public abstract int setGameTempoValue();
	public abstract int setPlayerJumpHeightValue();
	public abstract int setObstacleGapWidthValue();
	public abstract int setObstacleGapPlacementValue();
	public abstract double setMultiplierValue();

	
	//getter & setter
	
	public int getGameTempo() {
		return gameTempo;
	}

	public void setGameTempo(int gameTempo) {
		this.gameTempo = gameTempo;
	}

	public int getPlayerJumpHeight() {
		return playerJumpHeight;
	}

	public void setPlayerJumpHeight(int playerJumpHeight) {
		this.playerJumpHeight = playerJumpHeight;
	}

	public int getObstacleGapWidth() {
		return obstacleGapWidth;
	}

	public void setObstacleGapWidth(int obstacleGapWidth) {
		this.obstacleGapWidth = obstacleGapWidth;
	}

	public int getObstacleGapPlacement() {
		return obstacleGapPlacement;
	}

	public void setObstacleGapPlacement(int obstacleGapPlacement) {
		this.obstacleGapPlacement = obstacleGapPlacement;
	}

	public double getPointsMultiplier() {
		return pointsMultiplier;
	}

	public void setPointsMultiplier(double pointsMultiplier) {
		this.pointsMultiplier = pointsMultiplier;
	}
	
}
