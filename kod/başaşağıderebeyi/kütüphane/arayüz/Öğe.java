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
	/** Fare imlecinin öğenin üzerinde bulunup bulunmadığı. */
	protected boolean imlecinAltındaOlması;
	
	/** Öğenin kapladığı alan. */
	public final Dikdörtgen alanı;
	/** Alanı anlık olarak tanımlayan nesne. */
	public final YerleşikDikdörtgen yerleşikDikdörtgeni;
	
	/** Öğenin içinde bulunduğu ekran. */
	public final Ekran üstündekiEkranı;
	/** Öğenin içinde bulunduğu pencere. */
	public final Pencere üstündekiPencere;
	/** Öğenin içinde bulunduğu öğe. */
	public final Levha üstündekiLevha;
	
	/** Levhadan tanımlar. */
	public Öğe(final Levha levha) {
		this(levha, levha.üstündekiPencere, levha.üstündekiEkranı);
	}
	
	/** Verilen öğelerin içinde tanımlar. */
	public Öğe(final Levha levha, final Pencere pencere, final Ekran ekran) {
		alanı = new Dikdörtgen();
		üstündekiLevha = levha;
		if (levha == null)
			yerleşikDikdörtgeni = new YerleşikDikdörtgen(null, alanı);
		else {
			yerleşikDikdörtgeni = new YerleşikDikdörtgen(levha.alanı, alanı);
			levha.içerik.add(this);
		}
		üstündekiPencere = pencere;
		üstündekiEkranı = ekran;
	}
	
	/** Öğenin açık olup olmadığını döndürür. Bu öğe açık olsa da üstü kapalıysa kapalı sayılır. */
	public boolean açıkMı() {
		return açıkOlması && üstündekiLevha.açıkMı();
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
		if (imlecinAltındaOlması = alanı.içinde(üstündekiEkranı.girdi.imleç) &&
									üstündekiEkranı.girdi.imleçUygunMu(this))
			üstündekiEkranı.girdi.imleçHedefi = this;
	}
	
	/** Bu öğeyi odaklamak için istek belirtir. */
	public void odakla() {
		üstündekiLevha.odakla();
	}
	
	/** Öğeyi levha dikdörtgenine yerleştirir. */
	public void yerleştir() {
		yerleşikDikdörtgeni.yerleştir();
	}
	
	/** Öğeyi günceller. */
	public abstract void güncelle();
}
