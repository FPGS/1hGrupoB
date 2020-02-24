package Ejercicio18;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;



public class Jugando extends Applet implements Runnable {
	/*
	 * crear una pelota que rebote en los bordes pero que al rebotar en el borde
	 * superior cree otra más y así sucesivamente (valores aleatorios)
	 */
	Thread animacion;
	Image imagen;
	Graphics noseve;
	public static boolean crear = false;
	boolean fin = false;
	List<Pelota> pelotas;
	public void init() {
		imagen = createImage(300, 300); // es un metodo de la clase applet que instancia un objeto de la clase imagen
		noseve = imagen.getGraphics();
		pelotas = new ArrayList();
		for (int i = 0; i < 10; i++) {
		pelotas.add(new Pelota());
		}
	}

	public void start() {
		animacion = new Thread(this);// thread es un proceso
		animacion.start();// este metodo start es de la clase thread
	}

	public void paint(Graphics g) {
		noseve.setColor(Color.black);
		noseve.fillRect(0, 0, 300, 300);
		for (int i = 0; i < pelotas.size(); i++) {
			pelotas.get(i).dibujar(noseve);

		}
		if (fin) { // FIN DEL JUEGO
			noseve.setColor(Color.red);
			noseve.drawString("HAS GANADO!!!!!!", 100, 100);
			animacion.stop();
		}
		g.drawImage(imagen, 0, 0, this);
	}

	public void run() {
		do {
			for (int i = 0; i < pelotas.size(); i++) {
				pelotas.get(i).actualizar();
			}
			if (crear) {
				pelotas.add(new Pelota());
				crear = false;
			}
			if (pelotas.size() == 0) {
				fin = true;
			}

			repaint();// este metodo borra el objeto graphics y vuelve a llamar al metodo paint
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}
		} while (true);
	}

	public boolean mouseDown(Event e, int x, int y) {
		for (int i = 0; i < pelotas.size(); i++) {
			if (pelotas.get(i).contains(x, y)) {
				pelotas.remove(i);
				// para que solo elimine una pelota cada click
			}
		}
		return true;
	}


}
