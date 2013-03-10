package entity;

import java.util.ArrayList;
import java.util.List;

import message.Message;

public class EntityContainer {
	
	private static List<Entity> entities = new ArrayList<Entity>();
	private static List<Entity> entitiesToAdd = new ArrayList<Entity>();
	private static List<Entity> entitiesToDestroy = new ArrayList<Entity>();

	public static void addEntity(Entity e){
		entitiesToAdd.add(e);
	}
	
	public static void moveEntitiesToAdd(){
		for (Entity e : entitiesToAdd){
			entities.add(e);
		}
		entitiesToAdd.clear();
	}
	
	public static void destroyEntity(Entity e){
		entitiesToDestroy.add(e);
	}
	
	public static void removeEntities(){
		for (Entity e : entitiesToDestroy){
			entities.remove(e);
		}
	}
	
	public static List<Entity> getEntities(){
		return entities;
	}
	
	public static void sendMessage(Message message){
		for (Entity e : getEntities()){
			e.sendMessage(message);
		}
	}
	
}
