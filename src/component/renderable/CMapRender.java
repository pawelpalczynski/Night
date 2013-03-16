package component.renderable;

import message.CMessage;
import message.Message;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

import entity.EntityContainer;

public class CMapRender extends CRenderable {
	
	TiledMap map;
	
	public CMapRender(String path) throws SlickException{
		this.id = "MapRender";
		//this.map = new TiledMap(path);
	}

	@Override
	public void setDimensions() {
		EntityContainer.setBoundX(map.getWidth());
		EntityContainer.setBoundY(map.getHeight());
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sb, Graphics gr) {
		//map.render(0, 0);
		
	}

	@Override
	public void setDependencies() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void readMessage(Message message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void readMessage(CMessage message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sb, int delta) {
		// TODO Auto-generated method stub
		
	}

}
