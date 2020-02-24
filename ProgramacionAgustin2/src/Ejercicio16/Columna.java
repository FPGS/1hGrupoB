package Ejercicio16;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Columna {
	public static final int HUECO = 50;
	public static final int ANCHURA = 30;
	public static final int VELX = -3;
	// Random rand = new Random();
	Rectangle arriba, abajo;
	Color color;
	public int posy;

	public Columna(int posx) {
		this.arriba = new Rectangle(posx, 0, ANCHURA, (int) (Math.random() * 150) + HUECO);
		this.abajo = new Rectangle(posx, arriba.height + HUECO, ANCHURA, (int) 300 - (arriba.height + HUECO));
		this.color = Color.white;
	}

	public void dibujar(Graphics g) {
		g.setColor(color);
		g.fillRect(arriba.x, arriba.y, arriba.width, arriba.height);
		g.fillRect(abajo.x, abajo.y, abajo.width, abajo.height);
	}

	public void actualizar(Pajaro pajaro) {
		this.arriba.x += VELX;
		this.abajo.x += VELX;
		if ((pajaro.intersects(arriba)) || (pajaro.intersects(abajo))) {
			Flappy.fin = true;


		}

	}
}
