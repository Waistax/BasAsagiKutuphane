/**
 * başaşağıderebeyi.kütüphane.arayüz.Levha.java
 * 0.7 / 19 Oca 2021 / 12:50:09
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 * 
 * BaşAşağıMotor'dan alındı.
 * 0.16 / 14 Eyl 2020 / 16:51:55
 */
package başaşağıderebeyi.kütüphane.arayüz;

import java.util.*;
import java.util.function.*;

/** İçinde öğe barındırabilen öğe. */
public class Levha extends Öğe {
	/** İçindeki öğeler. */
	protected final List<Öğe> içerik;
	
	/** Levhanın içinde tanımlar. */
	public Levha(final Levha levha) {
		super(levha);
		içerik = new ArrayList<>();
	}
	
	/** Verilen öğelerin içinde tanımlar. */
	public Levha(final Levha levha, final Pencere pencere, final Ekran ekran) {
		super(levha, pencere, ekran);
		içerik = new ArrayList<>();
	}
	
	@Override
	protected void üzerindeBulunmasınıHesapla() {
		final ListIterator<Öğe> yineleme = içerik.listIterator(içerik.size());
		while (yineleme.hasPrevious())
			yineleme.previous().üzerindeBulunmasınıHesapla();
		super.üzerindeBulunmasınıHesapla();
	}
	
	@Override
	public void güncelle() {
		final ListIterator<Öğe> yineleme = içerik.listIterator(içerik.size());
		while (yineleme.hasPrevious())
			yineleme.previous().güncelle();
	}
	
	/** Her öğe için verilen görevi yapar. */
	public void herÖğeİçin(final Consumer<Öğe> görev) {
		içerik.forEach(görev);
	}
	
	/** Fare imlecinin bu öğenin ya da alt öğelerinden birinin üzerinde olup olmadığını döndürür. */
	public boolean üzerindekindenMi() {
		for (final Öğe öğe : içerik)
			if (öğe instanceof Levha && ((Levha)öğe).üzerindekindenMi())
				return true;
		return üzerinde;
	}
	
	@Override
	public void yerleştir() {
		super.yerleştir();
		for (final Öğe öğe : içerik)
			öğe.yerleştir();
	}
}
