/**
 * başaşağıderebeyi.kütüphane.matematik.yerleşim.YerleşimKuralı.java
 * 0.4 / 17 Oca 2021 / 13:18:29
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 *
 * BaşAşağıMotor'dan alındı.
 * 0.16 / 13 Eyl 2020 / 17:46:57
 */
package başaşağıderebeyi.kütüphane.matematik.yerleşim;

import başaşağıderebeyi.kütüphane.matematik.*;

/** Yerleşimin nasıl yapılacağını belirleyen kural. */
public abstract class YerleşimKuralı {
	/** Dikdörtgenin yerleştirileceği üst dikdörtgen.*/
	protected Dikdörtgen içerenDikdörtgen;
	/** Yerleştirilecek dikdörtgen. */
	protected Dikdörtgen uygulanacağıDikdörtgen;
	/** Yerleştirdiği veri ve boyut birleştirmesi. */
	protected YerleşimVerisi verisi;
	
	/** Yerleştirdiği veri. */
	final DikdörtgenVerisi uygulanacağıVeri;
	/** Diğer boyutun sonucuna bağlı olup olmadığı. */
	final boolean bağımlıOlması;
	
	/** Kuralı tanımlar. */
	protected YerleşimKuralı(
		final DikdörtgenVerisi uygulanacağıVeri,
		final boolean bağımlıOlması) {
		this.uygulanacağıVeri = uygulanacağıVeri;
		this.bağımlıOlması = bağımlıOlması;
	}
	
	/** Dikdörtgenin verisini bulur. */
	protected abstract void yerleştir();
}
