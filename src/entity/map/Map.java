package entity.map;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import component.renderable.CImageRender;
import component.renderable.CMapRender;

import entity.Entity;

public class Map extends Entity {
	
	public Map(String path) throws SlickException{
		 //this.addComponent(new CMapRender(path));
		this.addComponent(new CImageRender(new Image("data/images/map.png")));
		this.layer = 0;
	}
}
