package Ejercicio17;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

public class Jugando extends Applet implements Runnable {
	Thread animacion;
	Image imagen;
	Graphics noseve;
	int contador = 0;
	int indice = 0;
	public static boolean fin = false;
	String quijote[] = { "En", "un", "lugar", "de", "la", "Mancha", "de", "cuyo", "nombre", "no", "quiero", "acordarme",
			"no", "ha", "mucho", "tiempo", "vivía", "un", "hidalgo", "de", "los", "de", "lanza", "en", "astillero",
			"adara", "antigua", "rocín", "flaco", "y", "galgo", "corredor" };
	List<Palabra> palabras;

	public void init() {
		imagen = createImage(300, 300); // es un metodo de la clase applet que instancia un objeto de la clase imagen
		noseve = imagen.getGraphics();
		palabras = new ArrayList(quijote.length);
		palabras.add(new Palabra(quijote[indice]));
		contador = 0;
		indice++;



	}

	public void start() {// aqui trabajaremos con los thread, este metodo es de la clase applet
		animacion = new Thread(this);// thread es un proceso
		animacion.start();// este metodo start es de la clase thread
	}

	public void run() {
		do {
			contador += 100;
			if (contador % 1000 == 0) {// Para que se instancie cada 2 segundos
				palabras.add(new Palabra(quijote[indice]));
				contador = 0;
				indice++;
				if (indice == quijote.length) {// para que vuelva a empezar
					indice = 0;
				}

			}
			for (int i = 0; i < palabras.size(); i++) {
				palabras.get(i).actualizar();
			}
			repaint();// este metodo borra el objeto graphics y vuelve a llamar al metodo paint
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}
		} while (true);

	}

	public void paint(Graphics g) {
		noseve.setColor(Color.black);
		noseve.fillRect(0, 0, 300, 300);
		for (int i = 0; i < palabras.size(); i++) {
			palabras.get(i).dibujar(noseve);

		}
		if (fin) { // FIN DEL JUEGO
			noseve.setColor(Color.red);
			noseve.drawString("GAME OVER", 100, 100);
			animacion.stop();
		}
		g.drawImage(imagen, 0, 0, this);

	}

	public boolean mouseDown(Event e, int x, int y) {

			if (palabras.get(0).contains(x, y)) {
				palabras.remove(0);
			// para que solo elimine una pelota cada click

		}
		return true;
	}

}
