/**
 * başaşağıderebeyi.kütüphane.matematik.yerleşim.OrtalıKural.java
 * sürüm / 18 Oca 2021 / 08:29:01
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 *
 * BaşAşağıMotor'dan alındı.
 * 0.16 / 13 Eyl 2020 / 19:43:35
 */
package başaşağıderebeyi.kütüphane.matematik.yerleşim;

import static başaşağıderebeyi.kütüphane.matematik.DikdörtgenVerisi.*;

/** Dikdörtgenin orta noktasını üstününkine tanımlayan kural. */
public class OrtalıKural extends YerleşimKuralı {
	/** Dikdörtgenin ORTA verisiyle tanımlar. */
	public OrtalıKural() {
		super(ORTA_NOKTASI, false);
	}
	
	@Override
	protected void yerleştir() {
		verisi
			.değeriDeğiştir(
				uygulanacağıDikdörtgen,
				verisi.değeriEdin(içerenDikdörtgen));
	}
}
