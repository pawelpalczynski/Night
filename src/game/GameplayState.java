package game;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import component.CColidable;

import entity.Entity;
import entity.Player;
import entity.EntityContainer;
import entity.Rock;
import entity.Wall;
import entity.enemy.Zombie;
import entity.map.Map;

public class GameplayState extends BasicGameState{
	
	private final int stateID;
	
	GameplayState(int stateID) {
		this.stateID = stateID;
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sb) throws SlickException {
		Player player = new Player();
		EntityContainer.setPlayer(player);
		EntityContainer.addEntity(player);
		
		EntityContainer.addEntity(new Map("data/map.tmx"));
		EntityContainer.addEntity(new Rock());
		
		// Walls
		EntityContainer.addEntity(new Wall(EntityContainer.getBoundX()/2f, 0, EntityContainer.getBoundX(), 0));
		EntityContainer.addEntity(new Wall(0, EntityContainer.getBoundY()/2f, 0, EntityContainer.getBoundY()));
		EntityContainer.addEntity(new Wall(EntityContainer.getBoundX(), EntityContainer.getBoundY()/2f, 0, EntityContainer.getBoundY()));
		EntityContainer.addEntity(new Wall(EntityContainer.getBoundX()/2f, EntityContainer.getBoundY(), EntityContainer.getBoundX(), 0));
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sb, Graphics gr) throws SlickException {
		float minX = EntityContainer.ViewX;
		float minY = EntityContainer.ViewY;
		float maxX = minX + gc.getWidth();
		float maxY = minY + gc.getHeight();
		
		gr.translate(-EntityContainer.ViewX, -EntityContainer.ViewY);
		for (Entity e : EntityContainer.getEntitiesRender()){
			if (e.getPosition().x + e.getWidth() > minX && e.getPosition().y + e.getHeight() > minY && e.getPosition().x < maxX && e.getPosition().y < maxY ){
				e.render(gc, sb, gr);
			}
		}
		gr.translate(-EntityContainer.ViewX, -EntityContainer.ViewY);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sb, int delta) throws SlickException {
		Input input = gc.getInput();
		
		// Temporary input
		if (input.isKeyPressed(Input.KEY_ESCAPE)){
			gc.exit();
		} else if (input.isKeyPressed(Input.KEY_F1)){
			gc.setFullscreen(gc.isFullscreen() ? false : true);
		}
		
		for (Entity e : EntityContainer.getEntities()){
			e.update(gc, sb, delta);
		}
		
		// Physics step
		handleColisions();
		EntityContainer.getWorld().step(delta/1000f, 8, 3);
		
		// Add zombies on r-click
		if (input.isMousePressed(Input.MOUSE_RIGHT_BUTTON)){
			EntityContainer.addEntity(new Zombie(input.getMouseX() + EntityContainer.ViewX, input.getMouseY() + EntityContainer.ViewY));
		}

		// Add and destroy entities
		EntityContainer.moveEntitiesToAdd();
		EntityContainer.removeEntities();
		
		// Move the view window
		EntityContainer.ViewX = EntityContainer.getPlayer().getCenter().x - gc.getWidth()/2;
		EntityContainer.ViewY = EntityContainer.getPlayer().getCenter().y - gc.getHeight()/2;
		
		if (EntityContainer.ViewX < 0) EntityContainer.ViewX = 0;
		if (EntityContainer.ViewY < 0) EntityContainer.ViewY = 0;
		if (EntityContainer.ViewX > EntityContainer.BoundX - gc.getWidth()) EntityContainer.ViewX = EntityContainer.BoundX - gc.getWidth();
		if (EntityContainer.ViewY > EntityContainer.BoundY - gc.getHeight()) EntityContainer.ViewY = EntityContainer.BoundY - gc.getHeight();
	}

	@Override
	public int getID() {
		return this.stateID;
	}
	
	private void handleColisions(){
		for (Entity e1 : EntityContainer.getEntitiesCollide()){
			float size1 = (e1.getWidth() < e1.getHeight()) ? e1.getWidth() : e1.getHeight();
			for (Entity e2 : EntityContainer.getEntitiesCollide()){
				float size2 = (e2.getWidth() < e2.getHeight()) ? e2.getWidth() : e2.getHeight();
				if (e1.getCenter().distanceSquared(e2.getCenter()) < size1*size1 + size2*size2){
					if (e1.getClass() != e2.getClass() && e1 != e2) {
						((CColidable) e1.getComponent("Colidable")).colide();
					}
				}
			}
		}
	}

}
