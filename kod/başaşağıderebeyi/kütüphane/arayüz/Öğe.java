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
	/** Öğenin içinde bulunduğu öğe. */
	public final Levha levha;
	/** Öğenin içinde bulunduğu pencere. */
	public final Pencere pencere;
	/** Öğenin içinde bulunduğu ekran. */
	public final Ekran ekran;
	/** Öğenin kapladığı alan. */
	public final Dikdörtgen alan;
	/** Alanı anlık olarak tanımlayan nesne. */
	public final YerleşikDikdörtgen yerleşikDikdörtgen;
	/** Öğenin kullanılabilir olup olmadığı. */
	protected boolean açık;
	/** Fare imlecinin öğenin üzerinde bulunup bulunmadığı. */
	protected boolean üzerinde;
	
	/** Verilen öğelerin içinde tanımlar. */
	public Öğe(final Levha levha, final Pencere pencere, final Ekran ekran) {
		this.alan = new Dikdörtgen();
		this.levha = levha;
		if (levha == null) {
			this.yerleşikDikdörtgen = new YerleşikDikdörtgen(null, this.alan);
		} else {
			this.yerleşikDikdörtgen = new YerleşikDikdörtgen(levha.alan, this.alan);
			levha.içerik.add(this);
		}
		this.pencere = pencere;
		this.ekran = ekran;
	}
	
	/** Levhadan tanımlar. */
	public Öğe(final Levha levha) {
		this(levha, levha.pencere, levha.ekran);
	}
	
	/** Öğeyi levha dikdörtgenine yerleştirir. */
	public void yerleştir() {
		this.yerleşikDikdörtgen.yerleştir();
	}
	
	/** Bu öğeyi odaklamak için istek belirtir. */
	public void odakla() {
		this.levha.odakla();
	}
	
	/** Öğenin açık olup olmadığını döndürür. Bu öğe açık olsa da üstü kapalıysa
	 * kapalı sayılır. */
	public boolean açıkMı() {
		return this.açık && this.levha.açıkMı();
	}
	
	/** Öğenin açık olup olmadığını değiştirir. */
	public void yazAçıkMı(final boolean açık) {
		this.açık = açık;
	}
	
	/** Fare imlecinin öğenin üzerinde olup olmadığını döndürür. */
	public boolean üzerindeMi() {
		return this.üzerinde;
	}
	
	/** Fare imlecinin bu öğenin ya da alt öğelerinden birinin üzerinde olup
	 * olmadığını döndürür. */
	public boolean üzerindekindenMi() {
		return this.üzerindeMi();
	}
	
	/** Fare imlecinin öğenin üzerinde bulunup bulunmadığını hesaplar. */
	protected void hesaplaÜzerindeMi() {
		if (this.üzerinde = this.alan.içinde(this.ekran.girdi.imleç) && this.ekran.girdi.imleçUygunMu(this)) {
			this.ekran.girdi.imleçHedefi = this;
		}
	}
	
	/** Öğeyi günceller. */
	public abstract void güncelle();
}
