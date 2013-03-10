package entity;

import java.util.ArrayList;

import message.Message;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;
 
import component.Component;
import component.CRenderable;
 
public class Entity {
     
    String id;
     
    Vector2f position;
    Vector2f velocity;
    int width;
	int height;
	float scale;
    float rotation;
 
    CRenderable renderComponent = null;
     
    ArrayList<Component> components = null;
     
    public Entity(String id) {
        this.id = id;
         
        components = new ArrayList<Component>();
        width = 10;
        height = 10;
        position = new Vector2f(0, 0);
        velocity = new Vector2f(0, 0);
        scale = 1;
        rotation = 0;
    }
 
    public void addComponent(Component component) {
        if(CRenderable.class.isInstance(component)){
            renderComponent = (CRenderable)component;
        }
        component.setOwnerEntity(this);
        components.add(component);
    }
 
    public Component getComponent(String id) {    
        for(Component comp : components) {
        	if ( comp.getId().equalsIgnoreCase(id) )
        		return comp;
        }
        return null;
    }
    
    public void sendMessage(Message message){
    	for (Component comp : components){
    		comp.readMessage(message);
    	}
    }
 
    public Vector2f getPosition() {
    	return position;
    }
     
    public float getScale() {
    	return scale;
    }
     
    public float getRotation() {
    	return rotation;
    }
     
    public String getId() {
        return id;
    }
 
    public void setPosition(Vector2f position) {
    	this.position = position;
    }
 
    public void setRotation(float rotate) {
        rotation = rotate;
    }
 
    public void setScale(float scale) {
    	this.scale = scale;
    }
    
    public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}
	
	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
     
    public void update(GameContainer gc, StateBasedGame sb, int delta) {
        for(Component component : components) {
            component.update(gc, sb, delta);
        }        	
    }
 
    public void render(GameContainer gc, StateBasedGame sb, Graphics gr) {
        if(renderComponent != null)
            renderComponent.render(gc, sb, gr);
    	}
    
    public void destroy(){
    	EntityContainer.destroyEntity(this);
    }

	public Vector2f getVelocity() {
		return velocity;
	}

	public void setVelocity(Vector2f velocity) {
		this.velocity = velocity;
	}

}