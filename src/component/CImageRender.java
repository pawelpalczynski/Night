package component;

import message.Message;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;
 
public class CImageRender extends CRenderable {
 
    Image image;
     
    public CImageRender(String id, Image image)
    {
        super(id);
        this.image = image;
    }
     
    @Override
    public void render(GameContainer gc, StateBasedGame sb, Graphics gr) {
        Vector2f pos = owner.getPosition();
        float scale = owner.getScale();
         
        image.draw(pos.x, pos.y, scale);
    }
 
    @Override
    public void update(GameContainer gc, StateBasedGame sb, int delta) {
        image.rotate(owner.getRotation() - image.getRotation());
    }

	@Override
	public void readMessage(Message message) {
		// TODO Auto-generated method stub
		
	}
 
}