/**
 * başaşağıderebeyi.kütüphane.kumhavuzu.awt.AWTMotor.java
 * 0.7 / 27 Oca 2021 / 11:57:57
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.kütüphane.kumhavuzu.awt;

import başaşağıderebeyi.kütüphane.girdi.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

import javax.swing.*;

/** Java AWT kütüphanesini çalıştıran basit bir motor. */
public class AWTMotor {
	/** Motorun çalışıp çalışmadığı. */
	private boolean çalışıyor;
	/** Ekrandaki pencere. */
	private final JFrame çerçeve;
	/** AWT girdilerini dinleyen nesne. */
	private final AWTDinleyici dinleyici;
	/** Motorun çalıştırdığı güncelleyici. */
	private final AWTGüncelleyici güncelleyici;
	/** Çizimin yapıldığı tampon. */
	private final BufferStrategy tampon;
	/** Üzerine çizim yapılan AWT nesnesi. */
	private final Canvas tuval;
	/** Çizim yapmaya yarayan araç. */
	public final Graphics2D çizer;
	/** Motorun girdisi. */
	public final ÇiğGirdi girdi;
	
	/** Motoru başlatarak tanımlar. */
	public AWTMotor(final AWTGüncelleyici güncelleyici) {
		çerçeve = new JFrame("BaşAşağıKütüphane Deneme");
		tuval = new Canvas();
		girdi = new ÇiğGirdi();
		dinleyici = new AWTDinleyici(girdi);
		final Dimension boyut = new Dimension(1280, 720);
		tuval.setMaximumSize(boyut);
		tuval.setMinimumSize(boyut);
		tuval.setPreferredSize(boyut);
		çerçeve.add(tuval);
		çerçeve.pack();
		çerçeve.setResizable(false);
		çerçeve.setLocationRelativeTo(null);
		çerçeve.setVisible(true);
		çerçeve.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(final WindowEvent e) {
				AWTMotor.this.kapat();
			}
		});
		girdi.fareTuşuEkle(MouseEvent.BUTTON1);
		girdi.fareTuşuEkle(MouseEvent.BUTTON2);
		girdi.fareTuşuEkle(MouseEvent.BUTTON3);
		tuval.addKeyListener(dinleyici);
		tuval.addMouseListener(dinleyici);
		tuval.addMouseWheelListener(dinleyici);
		tuval.addMouseMotionListener(dinleyici);
		çerçeve.requestFocus();
		tuval.requestFocus();
		tuval.setBackground(Color.BLACK);
		tuval.createBufferStrategy(2);
		tampon = tuval.getBufferStrategy();
		çizer = (Graphics2D)tampon.getDrawGraphics();
		çizer.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		çizer.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		this.güncelleyici = güncelleyici;
	}
	
	/** Motoru başlatır. */
	public void başlat() {
		float öncekiZaman = System.nanoTime();
		float saniyeSayacı = 0.0F;
		int tıklar = 0;
		çalışıyor = true;
		while (çalışıyor) {
			float geçenZaman = System.nanoTime() - öncekiZaman;
			öncekiZaman += geçenZaman;
			geçenZaman /= 1000000000.0F;
			if ((saniyeSayacı += geçenZaman) >= 1.0F) {
				System.out.println("Tık Oranı: " + tıklar);
				tıklar = 0;
				saniyeSayacı--;
			}
			try {
				Thread.sleep(1);
			} catch (final InterruptedException e1) {
				e1.printStackTrace();
			}
			tıklar++;
			güncelleyici.güncelle();
			tampon.show();
			çizer.clearRect(0, 0, 1280, 720);
		}
		System.exit(0);
	}
	
	/** Motoru kapatır. */
	public void kapat() {
		çalışıyor = false;
	}
}
