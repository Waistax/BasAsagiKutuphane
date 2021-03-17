/**
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 * 0.7 / 19 Oca 2021 / 12:49:54
 * 
 * BaşAşağıMotor'dan alındı.
 * 0.16 / 14 Eyl 2020 / 13:29:10
 */
package başaşağıderebeyi.kütüphane.arayüz;

import static başaşağıderebeyi.kütüphane.matematik.dikdörtgen.DikdörtgenVerisi.*;

import başaşağıderebeyi.kütüphane.girdi.*;
import başaşağıderebeyi.kütüphane.matematik.yerleşim.*;

import java.util.*;

/** Arayüzün içinde bulunduğu ekran. */
public class Ekran extends Levha {
	/** Arayüzün girdisi. */
	final ÇiğGirdi girdi;
	/** Sol fare tuşu. */
	public final Tuş solTık;
	
	/** Bir girdi ve boyut ile tanımlar. */
	public Ekran(
		final ÇiğGirdi girdi,
		final int solTık,
		final float ortaX,
		final float ortaY,
		final float genişlik,
		final float yükseklik) {
		super(null, null, null);
		this.girdi = girdi;
		this.solTık = girdi.faresininTuşunuEdin(solTık);
		
		yerleşimi
			.kurallarıDeğiştir(
				new SerbestKural(ORTA_NOKTASI, ortaX),
				new SerbestKural(UZUNLUKLARI, genişlik),
				new SerbestKural(ORTA_NOKTASI, ortaY),
				new SerbestKural(UZUNLUKLARI, yükseklik));
	}
	
	@Override
	protected void imleçtenİlgiGörmesiniBul() {
		for (final ListIterator<Öğe> tersineYineleme =
			içeriği.listIterator(içeriği.size()); tersineYineleme
				.hasPrevious();)
			tersineYineleme.previous().imleçtenİlgiGörmesiniBul();
		
		imleçtenİlgiGörmesi = alanı.içindeOlmasınıBul(girdi.imlecininKonumu);
	}
	
	@Override
	public boolean açıkOlmasınıEdin() {
		// Ekranın üstü yok.
		return açıkOlması;
	}
	
	@Override
	public void güncelle() {
		yerleştir();
		imleçtenİlgiGörmesiniBul();
		super.güncelle();
	}
	
	@Override
	public void odakla() {
		// Bir şeyi odaklama, ekranın üstü yok.
	}
	
	/** Verilen pencerenin en üstte olup olmadığını döndürür. */
	public boolean üstteMi(final Öğe öğe) {
		if (içeriği.size() == 0)
			return false;
		
		return içeriği.get(içeriği.size() - 1).equals(öğe);
	}
}
