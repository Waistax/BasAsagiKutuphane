/**
 * başaşağıderebeyi.matematik.yerleşim.TersGöreliKural.java
 * 0.4 / 18 Oca 2021 / 08:16:39
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 * 
 * BaşAşağıMotor'dan alındı.
 * 0.16 / 13 Eyl 2020 / 18:52:31
 */
package başaşağıderebeyi.matematik.yerleşim;

import başaşağıderebeyi.matematik.*;

/** Dikdörtgenin verisini üstün büyük verisine göre tanımlayan kural. */
public class TersGöreliKural extends YerleşimKuralı {
	/** Üst dikdörtgenin büyük verisine olan ters uzaklık. */
	public float uzaklık;
	
	/** Uzaklığı sıfır olarak tanımlar. */
	public TersGöreliKural(DikdörtgenVerisi dikdörtgenVerisi) {
		super(dikdörtgenVerisi, false, false);
	}

	/** Belirli bir uzaklıkla tanımlar. */
	public TersGöreliKural(DikdörtgenVerisi dikdörtgenVerisi, float uzaklık) {
		this(dikdörtgenVerisi);
		yaz(uzaklık);
	}
	
	/** Uzaklığı değiştirir. */
	public TersGöreliKural yaz(float o) {
		uzaklık = o;
		return this;
	}
	
	/** Uzaklığın üzerine ekler. */
	public TersGöreliKural ekle(float o) {
		return yaz(uzaklık + o);
	}

	@Override
	protected void yerleştir() {
		veri.yaz(hedef, veri.büyük().al(ana) - uzaklık);
	}
}
