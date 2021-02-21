/**
 * başaşağıderebeyi.kütüphane.matematik.yerleşim.TersGöreliKural.java
 * 0.4 / 18 Oca 2021 / 08:16:39
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 *
 * BaşAşağıMotor'dan alındı.
 * 0.16 / 13 Eyl 2020 / 18:52:31
 */
package başaşağıderebeyi.kütüphane.matematik.yerleşim;

import başaşağıderebeyi.kütüphane.matematik.*;

/** Dikdörtgenin verisini üstün büyük verisine göre tanımlayan
 * kural. */
public class TersGöreliKural extends YerleşimKuralı {
	/** Üst dikdörtgenin büyük verisine olan ters uzaklık. */
	public float uzaklık;
	
	/** Uzaklığı sıfır olarak tanımlar. */
	public TersGöreliKural(final DikdörtgenVerisi dikdörtgenVerisi) {
		super(dikdörtgenVerisi, false, false);
	}
	
	/** Belirli bir uzaklıkla tanımlar. */
	public TersGöreliKural(	final DikdörtgenVerisi dikdörtgenVerisi,
							final float uzaklık) {
		this(dikdörtgenVerisi);
		yaz(uzaklık);
	}
	
	@Override
	protected void yerleştir() {
		veri.yaz(hedef, veri.büyük().al(ana) - uzaklık);
	}
	
	/** Uzaklığın üzerine ekler. */
	public TersGöreliKural ekle(final float o) {
		return yaz(uzaklık + o);
	}
	
	/** Uzaklığı değiştirir. */
	public TersGöreliKural yaz(final float o) {
		uzaklık = o;
		return this;
	}
}
