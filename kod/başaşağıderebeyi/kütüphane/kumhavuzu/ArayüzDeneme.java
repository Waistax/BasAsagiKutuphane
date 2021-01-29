/**
 * başaşağıderebeyi.kütüphane.kumhavuzu.ArayüzDeneme.java
 * 0.7 / 29 Oca 2021 / 11:52:08
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.kütüphane.kumhavuzu;

import başaşağıderebeyi.kütüphane.arayüz.*;
import başaşağıderebeyi.kütüphane.kumhavuzu.awt.*;
import başaşağıderebeyi.kütüphane.matematik.*;

import java.awt.*;
import java.awt.event.*;

/** Arayüzün çalışmasını dener. */
public class ArayüzDeneme implements AWTGüncelleyici {
	/** AWT motoru. */
	private final AWTMotor motor;
	/** Arayüzün temel nesnesi. */
	private final Ekran ekran;
	
	/** Tanımlar. */
	public ArayüzDeneme() {
		this.motor = new AWTMotor(this);
		this.ekran = new Ekran(this.motor.girdi, 640.0F, 360.0F, 1280.0F, 720.0F, MouseEvent.BUTTON1);
		new Pencere(this.ekran, "Deneme", 100, 100);
		this.motor.başlat();
	}
	
	@Override
	public void güncelle() {
		this.ekran.güncelle();
		this.öğeÇiz(this.ekran);
	}
	
	/** Verilen dikdörtgeni ekrana kutu olarak çizer. */
	private void kutuÇiz(final Dikdörtgen d, final Color renk, final boolean kalın) {
		this.motor.çizer.setColor(renk);
		this.motor.çizer.setStroke(new BasicStroke(kalın ? 2.0F : 0.5F));
		this.motor.çizer.fillRect((int)d.k.x, (int)d.k.y, (int)(d.b.x - d.k.x), (int)(d.b.y - d.k.y));
		this.motor.çizer.setColor(Color.black);
		this.motor.çizer.drawRect((int)d.k.x, (int)d.k.y, (int)(d.b.x - d.k.x), (int)(d.b.y - d.k.y));
	}
	
	/** Verilen öğeyi çizer. */
	private void öğeÇiz(final Öğe öğe) {
		final FontMetrics ölçü = this.motor.çizer.getFontMetrics();
		final float yazıSonu = ölçü.getLeading() + ölçü.getAscent();
//		final float yükseklik = yazıSonu + ölçü.getDescent();
		if (öğe instanceof Levha) {
			if (öğe instanceof Pencere) {
				this.kutuÇiz(öğe.alan, Color.LIGHT_GRAY, this.ekran.üstteMi(öğe));
			}
			((Levha)öğe).herÖğeİçin(this::öğeÇiz);
		} else if (öğe instanceof Düğme) {
			this.kutuÇiz(öğe.alan, öğe.üzerindeMi() ? Color.RED : ((Düğme)öğe).basılıMı() ? Color.GRAY : Color.WHITE,
					false);
			this.motor.çizer.setColor(öğe.üzerindeMi() ? Color.white : Color.black);
			final String yazı = ((Düğme)öğe).yazı;
			this.motor.çizer.drawString(yazı, (öğe.alan.b.x + öğe.alan.k.x - ölçü.stringWidth(yazı)) / 2.0F,
					(öğe.alan.b.y + öğe.alan.k.y + yazıSonu) / 2.0F);
		} else if (öğe instanceof PencereÇubuğu) {
			this.kutuÇiz(öğe.alan, Color.WHITE, false);
			this.motor.çizer.setColor(Color.black);
			this.motor.çizer.drawString(öğe.pencere.başlık, öğe.alan.k.x + ölçü.charWidth(' '),
					(öğe.alan.b.y + öğe.alan.k.y + yazıSonu) / 2.0F);
		}
	}
}
