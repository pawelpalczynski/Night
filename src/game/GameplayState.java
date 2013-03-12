package game;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

import entity.Entity;
import entity.Player;
import entity.EntityContainer;
import entity.enemy.Zombie;
import entity.map.Map;

public class GameplayState extends BasicGameState{
	
	private final int stateID;
	
	private TiledMap map;
	
	GameplayState(int stateID) {
		this.stateID = stateID;
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sb) throws SlickException {
		Player player = new Player();
		EntityContainer.setPlayer(player);
		EntityContainer.addEntity(player);
		
		EntityContainer.addEntity(new Map("data/map.tmx"));
		EntityContainer.addEntity(new Zombie());
		
		//map = new TiledMap("data/map.tmx");
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sb, Graphics gr) throws SlickException {
		for (Entity e : EntityContainer.getEntitiesRender()){
			e.render(gc, sb, gr);
		}
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sb, int delta) throws SlickException {
		Input input = gc.getInput();
		
		if (input.isKeyPressed(Input.KEY_ESCAPE)){
			gc.exit();
		} else if (input.isKeyPressed(Input.KEY_F1)){
			gc.setFullscreen(gc.isFullscreen() ? false : true);
		}
		
		for (Entity e : EntityContainer.getEntities()){
			e.update(gc, sb, delta);
		}
		
		if (input.isMousePressed(Input.MOUSE_RIGHT_BUTTON)){
			Zombie zombie = new Zombie();
			zombie.setPosition(new Vector2f(input.getMouseX(), input.getMouseY()));
			EntityContainer.addEntity(zombie);
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
