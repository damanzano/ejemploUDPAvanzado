package nodo2;
import processing.core.PApplet;


public class ViewNodo2 extends PApplet{

	ControlNodo2 control;
	
	//@Override
	public void setup() {
		control = new ControlNodo2(this);
	}
	
	//@Override
	public void draw() {
		background(255);
		control.draw();
	}	
	
	//@Override
	public void mouseMoved() {
		control.mouseMoved(mouseX, mouseY);
	}
	
}
