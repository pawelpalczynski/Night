package entity;

import java.util.ArrayList;
import java.util.List;

import message.Message;

public class EntityContainer {
	
	private static List<Entity> entities = new ArrayList<Entity>();
	private static List<Entity> entitiesToAdd = new ArrayList<Entity>();
	private static List<Entity> entitiesToDestroy = new ArrayList<Entity>();
	private static List<Entity> entitiesRender = new ArrayList<Entity>();
	private static Player player;
	
	public static void addEntity(Entity e){
		entitiesToAdd.add(e);
	}
	
	public static void moveEntitiesToAdd(){
		for (Entity e : entitiesToAdd){
			entities.add(e);
		}
		if (!entitiesToAdd.isEmpty()) entitiesRender = sortRender();
		entitiesToAdd.clear();
	}
	
	public static void destroyEntity(Entity e){
		entitiesToDestroy.add(e);
	}
	
	public static void removeEntities(){
		for (Entity e : entitiesToDestroy){
			entities.remove(e);
		}
		if (!entitiesToDestroy.isEmpty()) entitiesRender = sortRender();
		entitiesToDestroy.clear();
	}
	
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

	public static void setPlayer(Player player) {
		EntityContainer.player = player;
	}

	public static List<Entity> getEntitiesRender() {
		return entitiesRender;
	}

	public static void setEntitiesRender(List<Entity> entitiesRender) {
		EntityContainer.entitiesRender = entitiesRender;
	}
	
}
