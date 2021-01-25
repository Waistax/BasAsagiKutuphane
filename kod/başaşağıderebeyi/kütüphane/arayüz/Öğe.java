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
	public boolean açık;
	/** Fare imlecinin öğenin üzerinde bulunup bulunmadığı. Bu koşul birden fazla
	 * öğe için aynı anda doğru olabilir. Bu koşul hangi öğenin görünür ya da üstte
	 * olduğuna bakmaz. */
	public boolean üzerinde;
	/** Fare imlecinin bu öğe tarafından kullanılabilir olup olmadığı. Bu koşul
	 * yalnızca tek bir öğe için doğru olur. */
	public boolean imleçte;
	/** Bu öğenin görünümünü belirleyen nesne. Bu nesneye öğe tarafından hiçbir
	 * şekilde erişilmez. */
	public Object görünüm;
	
	/** Levhanın içinde tanımlar. */
	public Öğe(final Levha levha) {
		this.alan = new Dikdörtgen();
		if (levha == null) {
			this.levha = null;
			this.pencere = null;
			this.ekran = null;
			this.yerleşikDikdörtgen = new YerleşikDikdörtgen(null, this.alan);
		} else {
			this.levha = levha;
			this.pencere = levha.pencere;
			this.ekran = levha.ekran;
			this.yerleşikDikdörtgen = new YerleşikDikdörtgen(levha.alan, this.alan);
			levha.içerik.add(this);
		}
	}
	
	/**  */
	public void yerleştir() {
		this.yerleşikDikdörtgen.yerleştir();
	}
	
	public void üzerindeyiHesapla() {
		this.üzerinde = this.levha.üzerinde && this.alan.içinde(this.ekran.girdi.imleç);
	}
	
	public void imleciHesapla() {
		if (this.imleçte = this.üzerinde && this.ekran.girdi.imleçUygun(this))

	}
	
	public void güncelle() {
	}
}
