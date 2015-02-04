package nodo1;

import processing.core.PApplet;

public class ViewNodo1 extends PApplet {
	private ControlNodo1 control;

	@Override
	public void draw() {
		background(150);
		control.draw();
	}

	@Override
	public void mouseMoved() {
		// TODO Auto-generated method stub
		control.mouseMoved(mouseX, mouseY);
	}

	@Override
	public void setup() {
		control = new ControlNodo1(this);
	}
	
	
	
}
