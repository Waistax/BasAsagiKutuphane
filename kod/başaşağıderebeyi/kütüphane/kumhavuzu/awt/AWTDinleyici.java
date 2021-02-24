/**
 * başaşağıderebeyi.kütüphane.kumhavuzu.awt.AWTDinleyici.java
 * 0.7 / 27 Oca 2021 / 11:59:03
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.kütüphane.kumhavuzu.awt;

import başaşağıderebeyi.kütüphane.girdi.*;

import java.awt.event.*;

/** Java AWT kütüphanesinden gelen girdileri dinler. */
public class AWTDinleyici implements
		KeyListener,
		MouseListener,
		MouseWheelListener,
		MouseMotionListener {
	/** Dinlenen girdilerin hedefi. */
	private final ÇiğGirdi girdi;
	
	/** Girdi ile tanımlar. */
	public AWTDinleyici(final ÇiğGirdi girdi) {
		this.girdi = girdi;
	}
	
	@Override
	public void keyPressed(final KeyEvent e) {
		girdi.klavyeTuşununAşağıOlduğunuDeğiştir(e.getKeyCode(), true);
	}
	
	@Override
	public void keyReleased(final KeyEvent e) {
		girdi.klavyeTuşununAşağıOlduğunuDeğiştir(e.getKeyCode(), false);
	}
	
	@Override
	public void keyTyped(final KeyEvent e) {
	}
	
	@Override
	public void mouseClicked(final MouseEvent e) {
	}
	
	@Override
	public void mouseDragged(final MouseEvent e) {
		girdi.imlecininKonumunuBildir(e.getX(), e.getY());
	}
	
	@Override
	public void mouseEntered(final MouseEvent e) {
	}
	
	@Override
	public void mouseExited(final MouseEvent e) {
	}
	
	@Override
	public void mouseMoved(final MouseEvent e) {
		girdi.imlecininKonumunuBildir(e.getX(), e.getY());
	}
	
	@Override
	public void mousePressed(final MouseEvent e) {
		girdi.fareTuşununAşağıOlduğunuDeğiştir(e.getButton(), true);
	}
	
	@Override
	public void mouseReleased(final MouseEvent e) {
		girdi.fareTuşununAşağıOlduğunuDeğiştir(e.getButton(), false);
	}
	
	@Override
	public void mouseWheelMoved(final MouseWheelEvent e) {
		girdi.tekerleğininDevriniBildir(e.getWheelRotation());
	}
}
