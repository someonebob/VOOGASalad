package player.launchers;

import java.util.ResourceBundle;

import data.Game;
import javafx.stage.Stage;
import polyglot.Polyglot;

public class BasicPlayer extends AbstractPlayer {

	public BasicPlayer(Stage primaryStage, Game game, Polyglot polyglot, ResourceBundle IOResources, boolean firstTimeLoading) {
		super(primaryStage, game, polyglot, IOResources, firstTimeLoading);
		
		this.getRunningGameLoop().startTimeline();
	}

}