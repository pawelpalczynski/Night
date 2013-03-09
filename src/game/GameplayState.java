package game;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import component.ImageRenderComponent;

import entity.Entity;
import entity.Player;

public class GameplayState extends BasicGameState{
	
	private final int stateID;
	private Player player;
	private Entity zombie;
	
	GameplayState(int stateID) {
		this.stateID = stateID;
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sb)
			throws SlickException {
		player = new Player("player");
		
		zombie = new Entity("zombie");
		zombie.addComponent(new ImageRenderComponent("image", new Image("data/images/zombie.png")));
		zombie.setPosition(new Vector2f(500f, 600f));
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sb, Graphics gr)
			throws SlickException {
		player.render(gc, sb, gr);
		zombie.render(gc, sb, gr);
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sb, int delta)
			throws SlickException {
		Input input = gc.getInput();
		
		if (input.isKeyPressed(Input.KEY_ESCAPE)){
			gc.exit();
		}
		
		player.update(gc, sb, delta);
	}

	@Override
	public int getID() {
		return this.stateID;
	}

}
