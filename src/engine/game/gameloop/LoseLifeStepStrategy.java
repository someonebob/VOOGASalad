package engine.game.gameloop;

import engine.game.LevelManager;

public class LoseLifeStepStrategy extends TransitionStepStrategy {
	private static final String RESOURCE_NAME = "GameOver";
	
	public LoseLifeStepStrategy() {
		super(RESOURCE_NAME);
	}
	
	/**
	 * Subclass specific text based on variables, not on resource file.
	 */
	/*
	@Override
	protected String getSubclassSpecificText() {
		return "";  //TODO
	}
	*/
	
	@Override
	protected StepStrategy getNextStepStrategy(LevelManager levelManager) {
		return new LevelStepStrategy(); 
	}

	@Override
	protected int nextLevelNumber(LevelManager levelManager) {
		return levelManager.getLevelNumber() + 1;
	}

	
	
}
