/**
 * başaşağıderebeyi.kütüphane.matematik.yerleşim.OranlıKural.java
 * sürüm / 18 Oca 2021 / 08:23:59
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 *
 * BaşAşağıMotor'dan alındı.
 * 0.16 / 13 Eyl 2020 / 18:55:02
 */
package başaşağıderebeyi.kütüphane.matematik.yerleşim;

import static başaşağıderebeyi.kütüphane.matematik.DikdörtgenVerisi.*;

/** Dikdörtgenin uzunluğunu komşu kenara oranla tanımlayan kural. */
public class OranlıKural extends YerleşimKuralı {
	/** Bu uzunluğun diğerine bölümü. */
	public float oranı;
	
	/** Oranı sıfır olarak tanımlar. */
	public OranlıKural() {
		super(UZUNLUKLARI, true);
	}
	
	/** Belirli bir oranla tanımlar. */
	public OranlıKural(final float oran) {
		this();
		oranı = oran;
	}
	
	@Override
	protected void yerleştir() {
		verisi
			.değeriDeğiştir(
				uygulanacağıDikdörtgen,
				verisi
					.diğerBoyuttakiniEdin(UZUNLUKLARI)
					.değeriEdin(uygulanacağıDikdörtgen) *
					oranı);
	}
}
