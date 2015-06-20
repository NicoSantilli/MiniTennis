package tennismodel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Juego extends JPanel {	
	Bola bola = new Bola(this);
	Raqueta raqueta = new Raqueta(this);
	
	private void mover() {
		bola.moverBola();
		raqueta.moverRaqueta();
	}
	
	public Juego() {
		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				raqueta.keyReleased(e);
			}

			@Override
			public void keyPressed(KeyEvent e) {
				raqueta.keyPressed(e);
			}
		});
		setFocusable(true);

	}
	
	public static boolean RESIZABLE = false;
	public static boolean VISIBLE = true;
	public static boolean TRUE = true;
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.BLACK);
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		bola.paint(g2d);
		raqueta.paint(g2d);
		
//		Prueba
//		g2d.fillOval(0, 0, 30, 30);
//		g2d.drawOval(0, 50, 30, 30);
//		g2d.fillRect(50, 0, 30, 30);
//		g2d.drawRect(50, 50, 30, 30);
//		
//		g2d.draw(new Ellipse2D.Double(0, 100, 30, 30));
	}
	
	public static void main(String[] args) throws InterruptedException {
		JFrame frame = new JFrame("Mini Tennis");
		Juego juego = new Juego();
		frame.add(juego);
		frame.setSize(300,300);
		frame.setVisible(VISIBLE);
		frame.setResizable(RESIZABLE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		while (TRUE) {
			juego.mover();
			juego.repaint();
			Thread.sleep(5);
		}
	}
}
