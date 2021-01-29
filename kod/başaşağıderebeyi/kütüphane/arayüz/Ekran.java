/**
 * başaşağıderebeyi.kütüphane.arayüz.Ekran.java
 * 0.7 / 19 Oca 2021 / 12:49:54
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 * 
 * BaşAşağıMotor'dan alındı.
 * 0.16 / 14 Eyl 2020 / 13:29:10
 */
package başaşağıderebeyi.kütüphane.arayüz;

import başaşağıderebeyi.kütüphane.girdi.*;
import başaşağıderebeyi.kütüphane.matematik.*;
import başaşağıderebeyi.kütüphane.matematik.yerleşim.*;

import java.util.*;

/** Arayüzün içinde bulunduğu ekran. */
public class Ekran extends Levha {
	/** Arayüzün girdisi. */
	final ÇiğGirdi girdi;
	/** Sol fare tuşu. */
	public final Tuş solTık;
	/** Önceki güncellemede fare sol tuşunun hedefi. */
	private Object öncekiİmleçHedefi;
	
	/** Bir girdi ve boyut ile tanımlar. */
	public Ekran(final ÇiğGirdi girdi, final float ortaX, final float ortaY, final float genişlik,
			final float yükseklik, final int solTık) {
		super(null, null, null);
		this.girdi = girdi;
		this.solTık = girdi.alFareTuşu(solTık);
		this.yerleşikDikdörtgen.kurallar(new SerbestKural(DikdörtgenVerisi.ORTA, ortaX),
				new SerbestKural(DikdörtgenVerisi.UZUNLUK, genişlik), new SerbestKural(DikdörtgenVerisi.ORTA, ortaY),
				new SerbestKural(DikdörtgenVerisi.UZUNLUK, yükseklik)).yerleştir();
	}
	
	@Override
	public void odakla() {
		// Ekran kendini odaklamaz.
		// Ekranın üstü yok.
	}
	
	@Override
	public boolean açıkMı() {
		// Ekranın üstü yok.
		return this.açık;
	}
	
	@Override
	protected void hesaplaÜzerindeMi() {
		final ListIterator<Öğe> yineleme = this.içerik.listIterator(this.içerik.size());
		while (yineleme.hasPrevious()) {
			yineleme.previous().hesaplaÜzerindeMi();
		}
		this.üzerinde = this.alan.içinde(this.girdi.imleç);
	}
	
	@Override
	public void güncelle() {
		this.yerleştir();
		if (this.girdi.imleçHedefi == null && this.solTık.aşağı()) {
			this.girdi.imleçHedefi = this.öncekiİmleçHedefi;
		}
		this.hesaplaÜzerindeMi();
		this.öncekiİmleçHedefi = this.girdi.imleçHedefi;
		if (!(this.öncekiİmleçHedefi instanceof Öğe)) {
			this.öncekiİmleçHedefi = null;
		}
		super.güncelle();
	}
	
	public boolean üstteMi(final Öğe öğe) {
		if (this.içerik.size() == 0) {
			return false;
		}
		return this.içerik.get(this.içerik.size() - 1).equals(öğe);
	}
}
