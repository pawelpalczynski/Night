package entity;

import org.jbox2d.dynamics.BodyType;

import component.CJBox2D;
import component.renderable.CPrimitiveRender;

public class Wall extends Entity {
	
	public Wall(float x, float y, float width, float height) {
		this.id = "Wall";
		this.width = width;
		this.height = height;
		this.addComponent(new CPrimitiveRender(true, CPrimitiveRender.RECTANGLE));
		this.addComponent(new CJBox2D(x, y, BodyType.STATIC, CJBox2D.RECTANGLE));
		this.layer = 1;
	}
}