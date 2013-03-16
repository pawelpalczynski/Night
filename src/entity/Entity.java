package entity;

import java.util.ArrayList;

import message.CMessage;
import message.MComponentAdded;
import message.Message;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;
 
import component.CJBox2D;
import component.Component;
import component.renderable.CRenderable;
 
public class Entity implements Cloneable {
     
    protected String id;
     
    Vector2f position;
    Vector2f center;
    float width;
	float height;
	float scale;
    float rotation;
    protected int layer;
 
    ArrayList<CRenderable> renderComponent = new ArrayList<CRenderable>();
     
    ArrayList<Component> components = null;
    public Entity() {         
        this("Entity");
    }
     
    public Entity(String id) {
        this.id = id;
         
        components = new ArrayList<Component>();
        width = 10f;
        height = 10f;
        position = new Vector2f(0, 0);
        center = new Vector2f(width/2f, height/2f);
        scale = 1f;
        rotation = 0f;
    }
 
    public void addComponent(Component component) {
        component.setOwnerEntity(this);
        components.add(component);
        component.setDependencies();
        if (CJBox2D.class.isInstance(component)) ((CJBox2D) component).setPosition();
        if(CRenderable.class.isInstance(component)){
            ((CRenderable) component).setDimensions();
            renderComponent.add((CRenderable) component);
        }
        sendMessage(new MComponentAdded(component));
    }
 
    public Component getComponent(String id) {    
        for(Component comp : components) {
        	if ( comp.getId().equalsIgnoreCase(id) )
        		return comp;
        }
        return null;
    }
    
    public ArrayList<Component> getComponentList(){
    	return components;
    }
    
    public void sendMessage(Message message){
    	for (Component comp : components){
    		comp.readMessage(message);
    	}
    }
    
    public void sendMessage(CMessage message){
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
   

	public void setWidth(int width) {
		this.width = width;
	}

	public void setHeight(int height) {
		this.height = height;
	}
     
    public void update(GameContainer gc, StateBasedGame sb, int delta) throws SlickException {
        for(Component component : components) {
            component.update(gc, sb, delta);
        }
        center.set(position.x + width/2f, position.y + height/2f);
    }
 
    public void render(GameContainer gc, StateBasedGame sb, Graphics gr) {
        for (CRenderable c : renderComponent) c.render(gc, sb, gr);
    }
    
    public void destroy(){
    	EntityContainer.destroyEntity(this);
    }

	public Vector2f getCenter() {
		return center;
	}

	public void setCenter(Vector2f center) {
		this.center = center;
	}

	public int getLayer() {
		return layer;
	}

	public void setLayer(int layer) {
		this.layer = layer;
	}

	public float getWidth() {
		return width;
	}

	public float getHeight() {
		return height;
	}

}