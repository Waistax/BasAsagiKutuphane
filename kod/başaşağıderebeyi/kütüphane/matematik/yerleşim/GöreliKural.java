/**
 * başaşağıderebeyi.kütüphane.matematik.yerleşim.GöreliKural.java
 * 0.4 / 18 Oca 2021 / 08:10:04
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 *
 * BaşAşağıMotor'dan alındı.
 * 0.16 / 13 Eyl 2020 / 18:48:35
 */
package başaşağıderebeyi.kütüphane.matematik.yerleşim;

import başaşağıderebeyi.kütüphane.matematik.*;

/** Dikdörtgenin verisini üstün küçük verisine göre tanımlayan kural. */
public class GöreliKural extends YerleşimKuralı {
	/** Üst dikdörtgenin küçük verisine olan uzaklık. */
	public float uzaklık;
	
	/** Uzaklığı sıfır olarak tanımlar. */
	public GöreliKural(final DikdörtgenVerisi dikdörtgenVerisi) {
		super(dikdörtgenVerisi, false, false);
	}
	
	/** Belirli bir uzaklıkla tanımlar. */
	public GöreliKural(final DikdörtgenVerisi dikdörtgenVerisi, final float uzaklık) {
		this(dikdörtgenVerisi);
		this.yaz(uzaklık);
	}
	
	/** Uzaklığı değiştirir. */
	public GöreliKural yaz(final float o) {
		this.uzaklık = o;
		return this;
	}
	
	/** Uzaklığın üzerine ekler. */
	public GöreliKural ekle(final float o) {
		return this.yaz(this.uzaklık + o);
	}
	
	@Override
	protected void yerleştir() {
		this.veri.yaz(this.hedef, this.veri.küçük().al(this.ana) + this.uzaklık);
	}
}
