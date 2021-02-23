/**
 * başaşağıderebeyi.kütüphane.arayüz.Ekran.java
 * 0.7 / 19 Oca 2021 / 12:49:54
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 * 
 * BaşAşağıMotor'dan alındı.
 * 0.16 / 14 Eyl 2020 / 13:29:10
 */
package başaşağıderebeyi.kütüphane.arayüz;

import başaşağıderebeyi.kütüphane.girdi.*;
import başaşağıderebeyi.kütüphane.matematik.*;
import başaşağıderebeyi.kütüphane.matematik.yerleşim.*;

import java.util.*;

/** Arayüzün içinde bulunduğu ekran. */
public class Ekran extends Levha {
	/** Önceki güncellemede fare sol tuşunun hedefi. */
	private Object öncekiİmleçHedefi;
	/** Arayüzün girdisi. */
	final ÇiğGirdi girdi;
	/** Sol fare tuşu. */
	public final Tuş solTık;
	
	/** Bir girdi ve boyut ile tanımlar. */
	public Ekran(	final ÇiğGirdi girdi,
					final int solTık,
					final float ortaX,
					final float ortaY,
					final float genişlik,
					final float yükseklik) {
		super(null, null, null);
		this.girdi = girdi;
		this.solTık = girdi.alFareTuşu(solTık);
		
		// Verilen boyutları kullanarak ekranı yerleştir.
		yerleşikDikdörtgen.kurallar(new SerbestKural(DikdörtgenVerisi.ORTA, ortaX),
									new SerbestKural(DikdörtgenVerisi.UZUNLUK, genişlik),
									new SerbestKural(DikdörtgenVerisi.ORTA, ortaY),
									new SerbestKural(DikdörtgenVerisi.UZUNLUK, yükseklik))
							.yerleştir();
	}
	
	@Override
	protected void üzerindeBulunmasınıHesapla() {
		// Pencerelerde en sondan başa doğru dön.
		final ListIterator<Öğe> yineleme = içerik.listIterator(içerik.size());
		while (yineleme.hasPrevious())
			yineleme.previous().üzerindeBulunmasınıHesapla();
		
		üzerinde = alan.içinde(girdi.imleç);
	}
	
	@Override
	public boolean açıkMı() {
		// Ekranın üstü yok.
		return açık;
	}
	
	@Override
	public void güncelle() {
		yerleştir();
		
		if (girdi.imleçHedefi == null && solTık.aşağı())
			girdi.imleçHedefi = öncekiİmleçHedefi;
		
		üzerindeBulunmasınıHesapla();
		
		öncekiİmleçHedefi = girdi.imleçHedefi;
		
		if (!(öncekiİmleçHedefi instanceof Öğe))
			öncekiİmleçHedefi = null;
		
		super.güncelle();
	}
	
	@Override
	public void odakla() {
		// Bir şeyi odaklama, ekranın üstü yok.
	}
	
	/** Verilen pencerenin en üstte olup olmadığını döndürür. */
	public boolean üstteMi(final Öğe öğe) {
		if (içerik.size() == 0)
			return false;
		
		return içerik.get(içerik.size() - 1).equals(öğe);
	}
}
