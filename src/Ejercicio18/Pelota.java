package Ejercicio18;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Pelota extends Rectangle {
	int velX;
	int velY;
	Color colores[] = { Color.white, Color.yellow, Color.blue, Color.green, Color.red, Color.gray, Color.magenta };
	Color color;
	public Pelota() {
		super((int) (Math.random() * 295) + 5, (int) (Math.random() * 295) + 5, (int) (Math.random() * 6) + 5,
				(int) (Math.random() * 6) + 5);
		this.velX = (int) (Math.random() * 4) + 2;
		this.velY = (int) (Math.random() * 4) + 2;
		this.color = colores[(int) (Math.random() * colores.length)];
	}

	public void dibujar(Graphics g) {
		g.setColor(color);
		g.fillOval(this.x, this.y, this.width, this.height);
	}

	public void actualizar() {
		this.x += velX;
		this.y += velY;
		if (this.x <= 0 || this.x >= 300) {
			this.velX = -this.velX;
		}
		if (this.y >= 300) {
			this.velY = -this.velY;
		}
		if (this.y <= 0) {
			this.velY = -this.velY;
			Jugando.crear = true;
		}
	}
}
