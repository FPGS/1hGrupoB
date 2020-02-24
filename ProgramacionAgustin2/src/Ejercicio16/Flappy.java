package Ejercicio16;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

public class Flappy extends Applet implements Runnable {

	Pajaro bird;
	Thread animacion;
	Image imagen;
	Graphics noseve;
	Columna columna;
	List<Columna> columnas;
	public static Boolean fin = false;

	public static final int LONGITUD = 10;
	public static final int POSINICIAL = 250;
	public static final int DISTANCIA = 250;

	public void init() {
		columnas = new ArrayList(LONGITUD);

		imagen = createImage(300, 300); // es un metodo de la clase applet que instancia un objeto de la clase imagen
		noseve = imagen.getGraphics();
		bird = new Pajaro();
		for (int i = 0; i < LONGITUD; i++) {
			columnas.add(new Columna(POSINICIAL + (DISTANCIA * i)));
		}


	}

	public void start() {
		animacion = new Thread(this);
		animacion.start();
	}


	public void run() {
		do {

			bird.actualizar();
			for (int i = 0; i < LONGITUD; i++) {
				columnas.get(i).actualizar(bird);
			}
			if (columnas.get(0).arriba.x <= 0) {
				columnas.remove(0);
				columnas.add(new Columna(400));
			}


			repaint();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}
		} while (true);
	}
	public void paint(Graphics g) {
		noseve.setColor(Color.black);
		noseve.fillRect(0, 0, 300, 300);
		if (fin) {
			noseve.setColor(Color.white);
			noseve.drawString("GAME OVER", 100, 100);
			animacion.stop();
		}
		bird.dibujar(noseve);
		for (int i = 0; i < columnas.size(); i++) {
			columnas.get(i).dibujar(noseve);
		}

		g.drawImage(imagen, 0, 0, this);
	}

	public boolean mouseDown(Event e, int x, int y) {

		bird.y -= 15;
		return true;
		

	}
}


