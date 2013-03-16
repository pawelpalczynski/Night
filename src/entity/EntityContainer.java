package entity;

import java.util.ArrayList;
import java.util.List;

import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.World;

import component.CJBox2D;

import message.Message;

public class EntityContainer {
	
//	30 pixels = 1 metre
	
	private static List<Entity> entities = new ArrayList<Entity>();
	private static List<Entity> entitiesToAdd = new ArrayList<Entity>();
	private static List<Entity> entitiesToDestroy = new ArrayList<Entity>();
	private static List<Entity> entitiesRender = new ArrayList<Entity>();
	private static List<Entity> entitiesCollide = new ArrayList<Entity>();
	private static List<Body> bodiesCollide = new ArrayList<Body>();
	private static Player player;
	private static World world = new World(new Vec2(0f, 0f), false);
	
	public static float ViewX = 0;
	public static float ViewY = 0;
	public static float BoundX = 1600;
	public static float BoundY = 1200;
	
	public static float SlickToJBox2D = 1f/30f;
	public static float JBox2DToSlick = 30f;
	
	public static void addEntity(Entity e){
		entitiesToAdd.add(e);
		if (e.getComponent("Colidable") != null) entitiesCollide.add(e);
		if (e.getComponent("JBox2D") != null) {
			bodiesCollide.add(((CJBox2D) e.getComponent("JBox2D")).getBody());
			((CJBox2D) e.getComponent("JBox2D")).setDimensions();
			((CJBox2D) e.getComponent("JBox2D")).setPosition();
		}
	}
	
	public static void moveEntitiesToAdd(){
		for (Entity e : entitiesToAdd){
			entities.add(e);
		}
		// sort the render list every time new entity is added
		if (!entitiesToAdd.isEmpty()) entitiesRender = sortRender();
		entitiesToAdd.clear();
	}
	
	public static void destroyEntity(Entity e){
		entitiesToDestroy.add(e);
		if (e.getComponent("Colidable") != null) entitiesCollide.remove(e);
		if (e.getComponent("JBox2D") != null) bodiesCollide.remove(((CJBox2D) e.getComponent("JBox2D")).getBody());
	}
	
	public static void removeEntities(){
		for (Entity e : entitiesToDestroy){
			entities.remove(e);
		}
		if (!entitiesToDestroy.isEmpty()) entitiesRender = sortRender();
		entitiesToDestroy.clear();
	}
	
	// sort the render list according to layers
	public static List<Entity> sortRender(){
		List<Entity> list_old = new ArrayList<Entity>();
		for (Entity e : getEntities()) list_old.add(e) ;
		List<Entity> to_remove = new ArrayList<Entity>();
		List<Entity> list_new = new ArrayList<Entity>();
		int i = 0;
		
		while (!list_old.isEmpty()){
			for (Entity e : list_old){
				if (e.getLayer() == i) {
					list_new.add(e);
					to_remove.add(e);
				}
			}
			for (Entity e : to_remove){
				list_old.remove(e);
			}
			to_remove.clear();
			i++;
		}
		return list_new;
	}
	
	public static List<Entity> getEntities(){
		return entities;
	}
	
	public static void sendMessage(Message message){
		for (Entity e : getEntities()){
			e.sendMessage(message);
		}
	}

	public static Player getPlayer() {
		return player;
	}

	public static List<Entity> getEntitiesRender() {
		return entitiesRender;
	}

	public static float getBoundX() {
		return BoundX;
	}

	public static void setBoundX(float boundX) {
		BoundX = boundX;
	}

	public static float getBoundY() {
		return BoundY;
	}

	public static void setBoundY(float boundY) {
		BoundY = boundY;
	}

	public static List<Entity> getEntitiesCollide() {
		return entitiesCollide;
	}

	public static World getWorld() {
		return world;
	}

	public static List<Body> getBodiesCollide() {
		return bodiesCollide;
	}

	public static void setPlayer(Player player) {
		EntityContainer.player = player;
	}
	
}
