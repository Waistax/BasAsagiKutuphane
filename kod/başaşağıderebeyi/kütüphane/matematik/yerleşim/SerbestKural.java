/**
 * başaşağıderebeyi.kütüphane.matematik.yerleşim.SerbestKural.java
 * 0.4 / 17 Oca 2021 / 17:04:43
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 *
 * BaşAşağıMotor'dan alındı.
 * 0.16 / 13 Eyl 2020 / 17:48:47
 */
package başaşağıderebeyi.kütüphane.matematik.yerleşim;

import başaşağıderebeyi.kütüphane.matematik.*;

/** Dikdörtgenin verisini serbestçe tanımlayan kural. */
public class SerbestKural extends YerleşimKuralı {
	/** Veriyi belirleyecek değer. */
	public float değer;
	
	/** Değeri sıfır olarak tanımlar. */
	public SerbestKural(final DikdörtgenVerisi dikdörtgenVerisi) {
		super(dikdörtgenVerisi, false);
	}
	
	/** Belirli bir değerle tanımlar. */
	public SerbestKural(
		final DikdörtgenVerisi dikdörtgenVerisi,
		final float değer) {
		this(dikdörtgenVerisi);
		yaz(değer);
	}
	
	@Override
	protected void yerleştir() {
		verisi.yaz(uygulanacağıDikdörtgen, değer);
	}
	
	/** Değerin üzerine ekler. */
	public SerbestKural ekle(final float o) {
		return yaz(değer + o);
	}
	
	/** Değeri değiştirir. */
	public SerbestKural yaz(final float o) {
		değer = o;
		return this;
	}
}
