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
		this.içerik = new ArrayList<>();
	}
	
	/** Verilen öğelerin içinde tanımlar. */
	public Levha(final Levha levha, final Pencere pencere, final Ekran ekran) {
		super(levha, pencere, ekran);
		this.içerik = new ArrayList<>();
	}
	
	@Override
	public void yerleştir() {
		super.yerleştir();
		for (final Öğe öğe : this.içerik) {
			öğe.yerleştir();
		}
	}
	
	@Override
	public boolean üzerindekindenMi() {
		for (final Öğe öğe : this.içerik) {
			if (öğe.üzerindekindenMi()) {
				return true;
			}
		}
		return super.üzerindekindenMi();
	}
	
	@Override
	protected void hesaplaÜzerindeMi() {
		final ListIterator<Öğe> yineleme = this.içerik.listIterator(this.içerik.size());
		while (yineleme.hasPrevious()) {
			yineleme.previous().hesaplaÜzerindeMi();
		}
		super.hesaplaÜzerindeMi();
	}
	
	@Override
	public void güncelle() {
		final ListIterator<Öğe> yineleme = this.içerik.listIterator(this.içerik.size());
		while (yineleme.hasPrevious()) {
			yineleme.previous().güncelle();
		}
	}
	
	/** Her öğe için verilen görevi yapar. */
	public void herÖğeİçin(final Consumer<Öğe> görev) {
		this.içerik.forEach(görev);
	}
}
