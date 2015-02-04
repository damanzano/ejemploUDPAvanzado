package nodo2;

import processing.core.PApplet;

public class Circle {
	
	private int posX, posY;
	private PApplet pantalla;
	
	public Circle(PApplet pantalla) {
		posX = 0;
		posY = 0;
		this.pantalla = pantalla;
	}
	
	public void draw() {
		pantalla.fill(255,0,0);
		pantalla.ellipse(posX, posY, 25,25);
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

}
