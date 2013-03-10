package game;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import entity.Entity;
import entity.Player;
import entity.Zombie;
import entity.EntityContainer;

public class GameplayState extends BasicGameState{
	
	private final int stateID;
	
	GameplayState(int stateID) {
		this.stateID = stateID;
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sb)
			throws SlickException {
		
		EntityContainer.addEntity(new Player("player"));
		EntityContainer.addEntity(new Zombie("zombie"));
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sb, Graphics gr)
			throws SlickException {
		for (Entity e : EntityContainer.getEntities()){
			e.render(gc, sb, gr);
		}
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sb, int delta)
			throws SlickException {
		Input input = gc.getInput();
		
		if (input.isKeyPressed(Input.KEY_ESCAPE)){
			gc.exit();
		}
		
		for (Entity e : EntityContainer.getEntities()){
			e.update(gc, sb, delta);
		}

		// Add and destroy entities
		EntityContainer.moveEntitiesToAdd();
		EntityContainer.removeEntities();
	}

	@Override
	public int getID() {
		return this.stateID;
	}

}
