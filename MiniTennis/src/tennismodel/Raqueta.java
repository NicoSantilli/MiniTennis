package tennismodel;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

public class Raqueta {
	int ejeX = 0;
	int ejeXa = 1;
	
	private Juego juego;
	
	public Raqueta(Juego juego) {
		this.juego = juego;
	}
	
	public void moverRaqueta() {
		if (ejeX + ejeXa > 0 && ejeX + ejeXa < juego.getWidth()-60) {
			ejeX = ejeX + ejeXa;
		}
	}
	
	void paint(Graphics2D g) {
		g.fillRect(ejeX, 250, 60, 10);
	}
	
	void keyReleased(KeyEvent e) {
		ejeXa = 0;
	}
	
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
			ejeXa = -1;
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			ejeXa = 1;
	}
}
