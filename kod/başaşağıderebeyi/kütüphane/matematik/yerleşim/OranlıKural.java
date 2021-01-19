/**
 * başaşağıderebeyi.kütüphane.matematik.yerleşim.OranlıKural.java
 * sürüm / 18 Oca 2021 / 08:23:59
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 * 
 * BaşAşağıMotor'dan alındı.
 * 0.16 / 13 Eyl 2020 / 18:55:02
 */
package başaşağıderebeyi.kütüphane.matematik.yerleşim;

import başaşağıderebeyi.kütüphane.matematik.*;

/** Dikdörtgenin uzunluğunu komşu kenara oranla tanımlayan kural. */
public class OranlıKural extends YerleşimKuralı {
	/** Bu uzunluğun diğerine bölümü. */
	public float oran;
	
	/** Oranı sıfır olarak tanımlar. */
	public OranlıKural() {
		super(DikdörtgenVerisi.UZUNLUK, false, true);
	}

	/** Belirli bir oranla tanımlar. */
	public OranlıKural(float oran) {
		this();
		yaz(oran);
	}
	
	/** Oranı değiştirir. */
	public OranlıKural yaz(float o) {
		oran = o;
		return this;
	}
	
	@Override
	protected void yerleştir() {
		veri.yaz(hedef, veri.komşu().uzunluk().al(hedef) * oran);
	}
}
