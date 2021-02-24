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
	/** Arayüzün temel nesnesi. */
	private final Ekran ekran;
	/** AWT motoru. */
	private final AWTMotor motor;
	
	/** Tanımlar. */
	public ArayüzDeneme() {
		motor = new AWTMotor(this);
		ekran = new Ekran(motor.girdi, MouseEvent.BUTTON1, 640.0F, 360.0F, 1280.0F, 720.0F);
		new Pencere(ekran, "Deneme", 300, 200);
		motor.başlat();
	}
	
	/** Verilen dikdörtgeni ekrana kutu olarak çizer. */
	private void kutuÇiz(final Dikdörtgen d, final Color renk, final boolean kalın) {
		motor.çizer.setColor(renk);
		motor.çizer.setStroke(new BasicStroke(kalın ? 2.0F : 0.5F));
		motor.çizer.fillRect((int)d.k.x, (int)d.k.y, (int)(d.b.x - d.k.x), (int)(d.b.y - d.k.y));
		motor.çizer.setColor(Color.black);
		motor.çizer.drawRect((int)d.k.x, (int)d.k.y, (int)(d.b.x - d.k.x), (int)(d.b.y - d.k.y));
	}
	
	/** Verilen öğeyi çizer. */
	private void öğeÇiz(final Öğe öğe) {
		final FontMetrics ölçü = motor.çizer.getFontMetrics();
		final float yazıSonu = ölçü.getLeading() + ölçü.getAscent();
//		final float yükseklik = yazıSonu + ölçü.getDescent();
		if (öğe instanceof Levha) {
			if (öğe instanceof Pencere)
				kutuÇiz(öğe.alanı, Color.LIGHT_GRAY, ekran.üstteMi(öğe));
			((Levha)öğe).herÖğeİçin(this::öğeÇiz);
		} else if (öğe instanceof Düğme) {
			kutuÇiz(öğe.alanı,
					öğe.üzerindeMi() ? Color.RED :
							((Düğme)öğe).basılıOlmasınıEdin() ? Color.GRAY : Color.WHITE,
					false);
			motor.çizer.setColor(öğe.üzerindeMi() ? Color.white : Color.black);
			final String yazı = ((Düğme)öğe).yazı;
			motor.çizer.drawString(	yazı,
									(öğe.alanı.b.x + öğe.alanı.k.x - ölçü.stringWidth(yazı)) / 2.0F,
									(öğe.alanı.b.y + öğe.alanı.k.y + yazıSonu) / 2.0F);
		} else if (öğe instanceof PencereÇubuğu) {
			kutuÇiz(öğe.alanı, Color.WHITE, false);
			motor.çizer.setColor(Color.black);
			motor.çizer.drawString(	öğe.üstündekiPencere.başlık,
									öğe.alanı.k.x + ölçü.charWidth(' '),
									(öğe.alanı.b.y + öğe.alanı.k.y + yazıSonu) / 2.0F);
		}
	}
	
	@Override
	public void güncelle() {
		ekran.güncelle();
		öğeÇiz(ekran);
	}
}
