package component.renderable;

import message.CMessage;
import message.Message;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;
 
public class CImageRender extends CRenderable {
 
    Image image;
     
    public CImageRender(Image image) {
    	this.id = "ImageRender";
        this.image = image;
    }
    
    @Override
	public void setDimensions(){
    	owner.setWidth(image.getWidth());
        owner.setHeight(image.getHeight());
    }
     
    @Override
    public void render(GameContainer gc, StateBasedGame sb, Graphics gr) {
        Vector2f pos = owner.getPosition();
        float scale = owner.getScale();
        image.rotate((float) (owner.getRotation() - image.getRotation()));
        
        image.draw(pos.x, pos.y, scale);
    }
 
    @Override
    public void update(GameContainer gc, StateBasedGame sb, int delta) {
        
    }

	@Override
	public void readMessage(Message message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void readMessage(CMessage message) {
		
	}

	@Override
	public void setDependencies() {
	
	}
 
}