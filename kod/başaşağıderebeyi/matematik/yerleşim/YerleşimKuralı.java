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

/** Bir dikdörtgeni üstündekine göre tanımlayan kuraldır. */
public abstract class YerleşimKuralı {
	/** Yerleştirdiği veridir. */
	final DikdörtgenVerisi dikdörtgenVerisi;
	/** Eşinden sonra gelip gelmediğidir. */
	final boolean ikincil;
	/** Diğer boyutun sonucuna bağlı olup olmadığıdır. */
	final boolean bağımlı;
	/** Belirleyici, üst dikdörtgendir. */
	protected Dikdörtgen ana;
	/** Yerleştirilecek dikdörtgendir. */
	protected Dikdörtgen hedef;
	/** Yerleştirdiği veri ve boyut birleştirmesidir. */
	protected YerleşimVerisi veri;
	/** Eşinin yerleştirdiği veri ve boyut birleştirmesidir.
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
