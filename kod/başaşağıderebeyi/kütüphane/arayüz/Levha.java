/**
 * başaşağıderebeyi.kütüphane.arayüz.Levha.java
 * 0.7 / 19 Oca 2021 / 12:50:09
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.kütüphane.arayüz;

import java.util.*;

/** İçinde öğe barındırabilen öğe. */
public class Levha extends Öğe {
	/** İçindeki öğeler. */
	public final List<Öğe> içerik;
	
	/** Levhanın içinde tanımlar. */
	public Levha(final Levha levha) {
		super(levha);
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
	public void üzerindeyiHesapla() {
		super.üzerindeyiHesapla();
		for (final Öğe öğe : this.içerik) {
			öğe.üzerindeyiHesapla();
		}
	}
	
	@Override
	public void imleciHesapla() {
		for (int i = this.içerik.size() - 1; i > -1; i--) {
			this.içerik.get(i).imleciHesapla();
		}
		super.imleciHesapla();
	}
	
	@Override
	public void güncelle() {
		for (int i = this.içerik.size() - 1; i > -1; i--) {
			this.içerik.get(i).güncelle();
		}
	}
}
