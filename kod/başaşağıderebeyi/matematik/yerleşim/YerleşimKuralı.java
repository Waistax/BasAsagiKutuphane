/**
 * başaşağıderebeyi.matematik.yerleşim.YerleşimKuralı.java
 * 0.4 / 17 Oca 2021 / 13:18:29
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 * 
 * BaşAşağıMotor'dan alındı.
 * 0.16 / 13 Eyl 2020 / 17:46:57
 */
package başaşağıderebeyi.matematik.yerleşim;

import başaşağıderebeyi.matematik.*;

/** Bir dikdörtgeni üstündekine göre tanımlayan kural. */
public abstract class YerleşimKuralı {
	/** Yerleştirdiği veri. */
	final DikdörtgenVerisi dikdörtgenVerisi;
	/** Eşinden sonra gelip gelmediği. */
	final boolean ikincil;
	/** Diğer boyutun sonucuna bağlı olup olmadığı. */
	final boolean bağımlı;
	/** Belirleyici, üst dikdörtgen. */
	protected Dikdörtgen ana;
	/** Yerleştirilecek dikdörtgen. */
	protected Dikdörtgen hedef;
	/** Yerleştirdiği veri ve boyut birleştirmesi. */
	protected YerleşimVerisi veri;
	/** Eşinin yerleştirdiği veri ve boyut birleştirmesi.
	 * Eğer eşinin sıralaması önemli değilse boş bırakılır. */
	protected YerleşimVerisi birincilVeri;
	
	/** Kuralı tanımlar. */
	protected YerleşimKuralı(DikdörtgenVerisi dikdörtgenVerisi, boolean ikincil, boolean bağımlı) {
		this.dikdörtgenVerisi = dikdörtgenVerisi;
		this.ikincil = ikincil;
		this.bağımlı = bağımlı;
	}
	
	/** Dikdörtgenin verisini hesaplar. */
	protected abstract void yerleştir();
}
