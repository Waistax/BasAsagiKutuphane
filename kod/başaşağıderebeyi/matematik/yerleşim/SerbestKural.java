/**
 * başaşağıderebeyi.matematik.yerleşim.SerbestKural.java
 * 0.4 / 17 Oca 2021 / 17:04:43
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 * 
 * BaşAşağıMotor'dan alındı.
 * 0.16 / 13 Eyl 2020 / 17:48:47
 */
package başaşağıderebeyi.matematik.yerleşim;

import başaşağıderebeyi.matematik.*;

/** Dikdörtgenin verisini serbestçe tanımlayan kural. */
public class SerbestKural extends YerleşimKuralı {
	/** Veriyi belirleyecek değer. */
	public float değer;
	
	/** Değeri sıfır olarak tanımlar. */
	public SerbestKural(DikdörtgenVerisi dikdörtgenVerisi) {
		super(dikdörtgenVerisi, false, false);
	}
	
	/** Belirli bir değerle tanımlar. */
	public SerbestKural(DikdörtgenVerisi dikdörtgenVerisi, float değer) {
		this(dikdörtgenVerisi);
		yaz(değer);
	}
	
	/** Değeri değiştirir. */
	public SerbestKural yaz(float o) {
		değer = o;
		return this;
	}
	
	/** Değerin üzerine ekler. */
	public SerbestKural ekle(float o) {
		return yaz(değer + o);
	}

	@Override
	protected void yerleştir() {
		veri.yaz(hedef, değer);
	}
}
