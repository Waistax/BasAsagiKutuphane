/**
 * başaşağıderebeyi.matematik.yerleşim.OrtalıKural.java
 * sürüm / 18 Oca 2021 / 08:29:01
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 * 
 * BaşAşağıMotor'dan alındı.
 * 0.16 / 13 Eyl 2020 / 19:43:35
 */
package başaşağıderebeyi.matematik.yerleşim;

import başaşağıderebeyi.matematik.*;

/** Dikdörtgenin orta noktasını üstününkine tanımlayan kural. */
public class OrtalıKural extends YerleşimKuralı {
	/** Dikdörtgenin ORTA verisiyle tanımlar. */
	public OrtalıKural() {
		super(DikdörtgenVerisi.ORTA, false, false);
	}

	@Override
	protected void yerleştir() {
		veri.yaz(hedef, veri.al(ana));
	}
}
