package game;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class GameplayState extends BasicGameState{
	
	private final int stateID;
	private Image player;
	
	GameplayState(int stateID) {
		this.stateID = stateID;
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sb)
			throws SlickException {
		player = new Image("data/images/player.png");
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sb, Graphics g)
			throws SlickException {
		player.draw(100f, 100f);
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sb, int delta)
			throws SlickException {
		Input input = gc.getInput();
		
		if (input.isKeyPressed(Input.KEY_ESCAPE)){
			gc.exit();
		}
		if (input.isKeyPressed(Input.KEY_W)){
			
		}
		
	}

	@Override
	public int getID() {
		return this.stateID;
	}

}
