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
	protected boolean açık;
	/** Fare imlecinin öğenin üzerinde bulunup bulunmadığı. */
	protected boolean üzerinde;
	/** Öğenin kapladığı alan. */
	public final Dikdörtgen alan;
	/** Öğenin içinde bulunduğu ekran. */
	public final Ekran ekran;
	/** Öğenin içinde bulunduğu öğe. */
	public final Levha levha;
	/** Öğenin içinde bulunduğu pencere. */
	public final Pencere pencere;
	/** Alanı anlık olarak tanımlayan nesne. */
	public final YerleşikDikdörtgen yerleşikDikdörtgen;
	
	/** Levhadan tanımlar. */
	public Öğe(final Levha levha) {
		this(levha, levha.pencere, levha.ekran);
	}
	
	/** Verilen öğelerin içinde tanımlar. */
	public Öğe(	final Levha levha,
				final Pencere pencere,
				final Ekran ekran) {
		alan = new Dikdörtgen();
		this.levha = levha;
		if (levha == null)
			yerleşikDikdörtgen = new YerleşikDikdörtgen(null, alan);
		else {
			yerleşikDikdörtgen = new YerleşikDikdörtgen(levha.alan,
														alan);
			levha.içerik.add(this);
		}
		this.pencere = pencere;
		this.ekran = ekran;
	}
	
	/** Fare imlecinin öğenin üzerinde bulunup bulunmadığını
	 * hesaplar. */
	protected void hesaplaÜzerindeMi() {
		if (üzerinde = alan.içinde(ekran.girdi.imleç) &&
						ekran.girdi.imleçUygunMu(this))
			ekran.girdi.imleçHedefi = this;
	}
	
	/** Öğenin açık olup olmadığını döndürür. Bu öğe açık olsa da üstü
	 * kapalıysa kapalı sayılır. */
	public boolean açıkMı() {
		return açık && levha.açıkMı();
	}
	
	/** Öğeyi günceller. */
	public abstract void güncelle();
	
	/** Bu öğeyi odaklamak için istek belirtir. */
	public void odakla() {
		levha.odakla();
	}
	
	/** Fare imlecinin öğenin üzerinde olup olmadığını döndürür. */
	public boolean üzerindeMi() {
		return üzerinde;
	}
	
	/** Öğenin açık olup olmadığını değiştirir. */
	public void yazAçıkMı(final boolean açık) {
		this.açık = açık;
	}
	
	/** Öğeyi levha dikdörtgenine yerleştirir. */
	public void yerleştir() {
		yerleşikDikdörtgen.yerleştir();
	}
}
