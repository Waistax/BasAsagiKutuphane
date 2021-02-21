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

/** Bir dikdörtgeni üstündekine göre tanımlayan kural. */
public abstract class YerleşimKuralı {
	/** Belirleyici, üst dikdörtgen. */
	protected Dikdörtgen ana;
	/** Eşinin yerleştirdiği veri ve boyut birleştirmesi. Eğer eşinin
	 * sıralaması önemli değilse boş bırakılır. */
	protected YerleşimVerisi birincilVeri;
	/** Yerleştirilecek dikdörtgen. */
	protected Dikdörtgen hedef;
	/** Yerleştirdiği veri ve boyut birleştirmesi. */
	protected YerleşimVerisi veri;
	/** Diğer boyutun sonucuna bağlı olup olmadığı. */
	final boolean bağımlı;
	/** Yerleştirdiği veri. */
	final DikdörtgenVerisi dikdörtgenVerisi;
	/** Eşinden sonra gelip gelmediği. */
	final boolean ikincil;
	
	/** Kuralı tanımlar. */
	protected YerleşimKuralı(	final DikdörtgenVerisi dikdörtgenVerisi,
								final boolean ikincil,
								final boolean bağımlı) {
		this.dikdörtgenVerisi = dikdörtgenVerisi;
		this.ikincil = ikincil;
		this.bağımlı = bağımlı;
	}
	
	/** Dikdörtgenin verisini hesaplar. */
	protected abstract void yerleştir();
}
