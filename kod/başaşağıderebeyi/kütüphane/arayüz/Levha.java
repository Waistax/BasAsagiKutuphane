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

/** İçinde öğe barındırabilen öğe. */
public class Levha extends Öğe {
	/** İçindeki öğeler. */
	public final List<Öğe> içeriği;
	/** Fare imlecinin içerdiği öğelerden birinin ya da kendisinin üzerinde olup
	 * olmadığıdır. */
	protected boolean içeriğininİmleçtenİlgiGörmesi;
	
	/** Levhanın içinde tanımlar. */
	public Levha(final Levha levha) {
		super(levha);
		içeriği = new ArrayList<>();
	}
	
	/** Verilen öğelerin içinde tanımlar. */
	public Levha(final Levha levha, final Pencere pencere, final Ekran ekran) {
		super(levha, pencere, ekran);
		içeriği = new ArrayList<>();
	}
	
	@Override
	protected void imleçtenİlgiGörmesiniBul() {
		içeriğininİmleçtenİlgiGörmesi = false;
		
		for (final ListIterator<Öğe> yineleme =
			içeriği.listIterator(içeriği.size()); yineleme.hasPrevious();) {
			final Öğe içeriği = yineleme.previous();
			içeriği.imleçtenİlgiGörmesiniBul();
			içeriğininİmleçtenİlgiGörmesi =
				içeriğininİmleçtenİlgiGörmesi || içeriği.imleçtenİlgiGörmesi;
		}
		
		super.imleçtenİlgiGörmesiniBul();
		içeriğininİmleçtenİlgiGörmesi =
			içeriğininİmleçtenİlgiGörmesi || imleçtenİlgiGörmesi;
	}
	
	/** Fare imlecinin içerdiği öğelerden birinin ya da kendisinin üzerinde olup
	 * olmadığıdır. */
	public boolean içeriğininİmleçtenİlgiGörmesiniEdin() {
		return içeriğininİmleçtenİlgiGörmesi;
	}
	
	@Override
	public void yerleştir() {
		super.yerleştir();
		for (final Öğe öğe : içeriği)
			öğe.yerleştir();
	}
	
	@Override
	public void güncelle() {
		for (final ListIterator<Öğe> yineleme =
			içeriği.listIterator(içeriği.size()); yineleme.hasPrevious();)
			yineleme.previous().güncelle();
	}
}
