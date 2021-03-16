/**
 * başaşağıderebeyi.kütüphane.arayüz.Öğe.java
 * 0.7 / 19 Oca 2021 / 11:41:20
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 *
 * BaşAşağıMotor'dan alındı.
 * 0.16 / 13 Eyl 2020 / 17:43:42
 */
package başaşağıderebeyi.kütüphane.arayüz;

import başaşağıderebeyi.kütüphane.matematik.*;
import başaşağıderebeyi.kütüphane.matematik.yerleşim.*;

/** Arayüzündeki her bir öğe. */
public abstract class Öğe {
	/** Öğenin kullanılabilir olup olmadığı. */
	protected boolean açıkOlması;
	/** Fare imlecinin öğeyle ilgilenip ilgilenmediği. */
	protected boolean imleçtenİlgiGörmesi;
	
	/** Öğenin kapladığı alan. */
	public final Dikdörtgen alanı;
	/** Alanı anlık olarak tanımlayan nesne. */
	public final Yerleşim yerleşimi;
	
	/** Öğenin içinde bulunduğu öğe. */
	public final Levha içerenLevha;
	/** Öğenin içinde bulunduğu pencere. */
	public final Pencere içerenPencere;
	/** Öğenin içinde bulunduğu ekran. */
	public final Ekran içerenEkran;
	
	/** Levha ile aynı tanımlar. */
	public Öğe(final Levha içerenLevha) {
		this(içerenLevha, içerenLevha.içerenPencere, içerenLevha.içerenEkran);
	}
	
	/** Verilen öğelerin içinde tanımlar. */
	public Öğe(
		final Levha içerenLevha,
		final Pencere içerenPencere,
		final Ekran içerenEkran) {
		açıkOlması = true;
		alanı = new Dikdörtgen();
		this.içerenLevha = içerenLevha;
		if (içerenLevha == null)
			yerleşimi = new Yerleşim(null, alanı);
		else {
			yerleşimi = new Yerleşim(içerenLevha.alanı, alanı);
			içerenLevha.içeriği.add(this);
		}
		this.içerenPencere = içerenPencere;
		this.içerenEkran = içerenEkran;
	}
	
	/** Öğenin açık olup olmadığını döndürür. Bu öğe açık olsa da üstü kapalıysa
	 * kapalı sayılır. */
	public boolean açıkOlmasınıEdin() {
		return açıkOlması && içerenLevha.açıkOlmasınıEdin();
	}
	
	/** Öğenin açık olup olmadığını değiştirir. */
	public void açıkOlmasınıDeğiştir(final boolean açık) {
		açıkOlması = açık;
	}
	
	/** Fare imlecinin öğenin üzerinde olup olmadığını döndürür. */
	public boolean imleçtenİlgiGörümesiniEdin() {
		return imleçtenİlgiGörmesi;
	}
	
	/** Fare imlecinin öğenin üzerinde olup olmadığını bulur. */
	protected void imleçtenİlgiGörmesiniBul() {
		imleçtenİlgiGörmesi =
			alanı.içindeOlmasınıBul(içerenEkran.girdi.imlecininKonumu) &&
				içerenEkran.solTık.kullanmayıDene(this);
	}
	
	/** Fare imlecinin öğeyi sürükleyip sürüklemediğini bulur. */
	protected boolean sürüklenmesiniBul() {
		return içerenEkran.solTık.ilgilendiğiNesne == this &&
			içerenEkran.solTık.basılıOlmasınıEdin();
	}
	
	/** Bu öğeyi ve üst öğelerini öne getirir. */
	public void odakla() {
		içerenLevha.odakla();
	}
	
	/** Öğeyi levha dikdörtgenine yerleştirir. Öğenin alanını ve konumunu
	 * yeniden bulur. */
	public void yerleştir() {
		yerleşimi.yerleştir();
	}
	
	/** Öğeyi günceller. */
	public abstract void güncelle();
}
