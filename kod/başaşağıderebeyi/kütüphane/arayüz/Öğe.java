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
	protected boolean açıkOlması;
	protected boolean imlecinAltındaOlması;
	
	/** Öğenin kapladığı alan. */
	public final Dikdörtgen alanı;
	/** Alanı anlık olarak tanımlayan nesne. */
	public final Yerleşim yerleşikDikdörtgeni;
	
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
		alanı = new Dikdörtgen();
		this.içerenLevha = içerenLevha;
		if (içerenLevha == null)
			yerleşikDikdörtgeni = new Yerleşim(null, alanı);
		else {
			yerleşikDikdörtgeni = new Yerleşim(içerenLevha.alanı, alanı);
			içerenLevha.içerik.add(this);
		}
		this.içerenPencere = içerenPencere;
		this.içerenEkran = içerenEkran;
	}
	
	/** Öğenin açık olup olmadığını döndürür. Bu öğe açık olsa da üstü kapalıysa
	 * kapalı sayılır. */
	public boolean açıkMı() {
		return açıkOlması && içerenLevha.açıkMı();
	}
	
	/** Öğenin açık olup olmadığını değiştirir. */
	public void açıkOlmasınıDeğiştir(final boolean açık) {
		açıkOlması = açık;
	}
	
	/** Fare imlecinin öğenin üzerinde olup olmadığını döndürür. */
	public boolean üzerindeMi() {
		return imlecinAltındaOlması;
	}
	
	/** Fare imlecinin öğenin üzerinde bulunup bulunmadığını hesaplar. */
	protected void üzerindeBulunmasınıHesapla() {
		if (imlecinAltındaOlması =
			alanı.içindeOlmasınıBul(içerenEkran.girdi.imlecininKonumu) &&
				içerenEkran.girdi.imleçUygunMu(this))
			içerenEkran.girdi.imlecininHedefi = this;
	}
	
	/** Bu öğeyi odaklamak için istek belirtir. */
	public void odakla() {
		içerenLevha.odakla();
	}
	
	/** Öğeyi levha dikdörtgenine yerleştirir. */
	public void yerleştir() {
		yerleşikDikdörtgeni.yerleştir();
	}
	
	/** Öğeyi günceller. */
	public abstract void güncelle();
}
