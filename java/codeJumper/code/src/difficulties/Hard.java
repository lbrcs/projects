package difficulties;

/***************************************************************************************
* 	@Authors: Esam Ahmed & Martin Eidler
* 	Date: 05-08-2021
***************************************************************************************/

public class Hard extends Difficulty {
	
	public Hard() {
		super();
	}
	
	public int setGameTempoValue() {
		int newGameTempo = 15;
		super.setGameTempo(newGameTempo);
		return super.getGameTempo();
	}
	
	public int setPlayerJumpHeightValue() {
		int newPlayerJumpHeight = 13;
		super.setPlayerJumpHeight(newPlayerJumpHeight);
		return super.getPlayerJumpHeight();
	}
	
	public int setObstacleGapWidthValue() {
		int newObstacleGapWidth = 360;
		super.setObstacleGapWidth(newObstacleGapWidth);
		return super.getObstacleGapWidth();
	}
	
	public int setObstacleGapPlacementValue() {
		int newObstacleGapPlacement = 400;
		super.setObstacleGapPlacement(newObstacleGapPlacement);
		return super.getObstacleGapPlacement();
	}
	
	public double setMultiplierValue() {
		double multiplier = 1.5;
		super.setPointsMultiplier(multiplier);
		return super.getPointsMultiplier();
	}
}
