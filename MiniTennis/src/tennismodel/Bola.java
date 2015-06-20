package tennismodel;

import java.awt.Graphics2D;

public class Bola {
	protected int ejeX = 0;
	protected int ejeXa = 1;
	protected int ejeY = 0;
	protected int ejeYa = 1;
	
	private Juego juego;
	
	public Bola(Juego juego) {
		this.juego = juego;
	}
	
	protected void moverBola() {
		if (ejeX + ejeXa < 0)
			ejeXa = 1;
		if (ejeX + ejeXa > juego.getWidth() - 30)
			ejeXa = -1;
		if (ejeY + ejeYa < 0)
			ejeYa = 1;
		if (ejeY + ejeYa > juego.getHeight() - 30)
			ejeYa = -1;
		
		ejeX = ejeX + ejeXa;
		ejeY = ejeY + ejeYa;
	}
	
	public void paint(Graphics2D g) {
		g.fillOval(ejeX, ejeY, 30, 30);
	}
}
