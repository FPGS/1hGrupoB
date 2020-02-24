package Ejercicio16;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Pajaro extends Rectangle {
	Color color;

	public int velY;

	public Pajaro() {
		super(50, 20, 15, 15);
		velY = +5;
		this.color = Color.white;
	}

	public void dibujar(Graphics g) {
		g.setColor(color);
		g.fillOval(x, y, width, height);
	}

	public void actualizar() {

		y += velY;

		if (y >= (300 - width)) {
			y = 300 - width;
		}

	}
}
