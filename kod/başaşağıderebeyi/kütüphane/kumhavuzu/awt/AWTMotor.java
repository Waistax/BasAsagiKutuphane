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
	/** Ekrandaki pencere. */
	private final JFrame çerçeve;
	/** Üzerine çizim yapılan AWT nesnesi. */
	private final Canvas tuval;
	/** Motorun girdisi. */
	public final ÇiğGirdi girdi;
	/** AWT girdilerini dinleyen nesne. */
	private final AWTDinleyici dinleyici;
	/** Motorun çalışıp çalışmadığı. */
	private boolean çalışıyor;
	/** Çizimin yapıldığı tampon. */
	private final BufferStrategy tampon;
	/** Çizim yapmaya yarayan araç. */
	public final Graphics2D çizer;
	/** Motorun çalıştırdığı güncelleyici. */
	private final AWTGüncelleyici güncelleyici;
	
	/** Motoru başlatarak tanımlar. */
	public AWTMotor(final AWTGüncelleyici güncelleyici) {
		this.çerçeve = new JFrame("BaşAşağıKütüphane Deneme");
		this.tuval = new Canvas();
		this.girdi = new ÇiğGirdi();
		this.dinleyici = new AWTDinleyici(this.girdi);
		final Dimension boyut = new Dimension(1280, 720);
		this.tuval.setMaximumSize(boyut);
		this.tuval.setMinimumSize(boyut);
		this.tuval.setPreferredSize(boyut);
		this.çerçeve.add(this.tuval);
		this.çerçeve.pack();
		this.çerçeve.setResizable(false);
		this.çerçeve.setLocationRelativeTo(null);
		this.çerçeve.setVisible(true);
		this.çerçeve.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(final WindowEvent e) {
				AWTMotor.this.kapat();
			}
		});
		this.girdi.ekleFareTuşu(MouseEvent.BUTTON1);
		this.girdi.ekleFareTuşu(MouseEvent.BUTTON2);
		this.girdi.ekleFareTuşu(MouseEvent.BUTTON3);
		this.tuval.addKeyListener(this.dinleyici);
		this.tuval.addMouseListener(this.dinleyici);
		this.tuval.addMouseWheelListener(this.dinleyici);
		this.tuval.addMouseMotionListener(this.dinleyici);
		this.çerçeve.requestFocus();
		this.tuval.requestFocus();
		this.tuval.setBackground(Color.BLACK);
		this.tuval.createBufferStrategy(2);
		this.tampon = this.tuval.getBufferStrategy();
		this.çizer = (Graphics2D)this.tampon.getDrawGraphics();
		this.çizer.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		this.çizer.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		this.güncelleyici = güncelleyici;
	}
	
	/** Motoru başlatır. */
	public void başlat() {
		float öncekiZaman = System.nanoTime();
		float saniyeSayacı = 0.0F;
		int tıklar = 0;
		this.çalışıyor = true;
		while (this.çalışıyor) {
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
			this.güncelleyici.güncelle();
			this.tampon.show();
			this.çizer.clearRect(0, 0, 1280, 720);
		}
		System.exit(0);
	}
	
	/** Motoru kapatır. */
	public void kapat() {
		this.çalışıyor = false;
	}
}
