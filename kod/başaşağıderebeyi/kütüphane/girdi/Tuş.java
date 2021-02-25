/**
 * başaşağıderebeyi.kütüphane.girdi.Tuş.java
 * 0.5 / 18 Oca 2021 / 10:38:21
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 *
 * BaşAşağıMotor'dan alındı.
 * 0.20 / 1 Kas 2020 / 16:42:13
 */
package başaşağıderebeyi.kütüphane.girdi;

/** Bilgisayarda aşağı basılabilen herhangi bir tuş. */
public class Tuş {
	/** Tuşu temsil eden sayı kodu. */
	public final int kodu;
	
	private volatile boolean eşzamansızBasılıOlması;
	private boolean basılıOlması;
	private boolean basılması;
	private boolean salınması;
	
	/** Tuşun girdisini kullanan (dinleyen ve işleyen) nesne. Tuş girdisini
	 * kullanmadan önce uygun olup olmadığına bakılmalı ve kullanıldıktan sonra
	 * bu nesne değiştirilmelidir. */
	public Object hedefi;
	
	public Tuş(final int kodu) {
		this.kodu = kodu;
	}
	
	/** Tuşun anlık durumunu günceller. */
	public void güncelle() {
		final boolean sonrakiDurumdaBasılıOlması = eşzamansızBasılıOlması;
		
		basılması = !basılıOlması && sonrakiDurumdaBasılıOlması;
		salınması = basılıOlması && !sonrakiDurumdaBasılıOlması;
		basılıOlması = sonrakiDurumdaBasılıOlması;
		
		hedefi = null;
	}
	
	/** Tuşun eşzamansız olarak basılı olup olmadığını bildirir. */
	public void basılıOlmasınıBildir(final boolean basılıOlması) {
		eşzamansızBasılıOlması = basılıOlması;
	}
	
	/** Tuşun şu anda basılı olup olmadığını döndür. */
	public boolean basılıOlmasınıEdin() {
		return basılıOlması;
	}
	
	/** Tuşun şu anda basılmaya başlanıp başlanmadığını döndürür. */
	public boolean basılmasınıEdin() {
		return basılması;
	}
	
	/** Tuşun şu anda bırakılıp bırakılmadığını döndürür. */
	public boolean salınmasınıEdin() {
		return salınması;
	}
	
	/** Tuşun verilen nesne tarafından kullanılmaya uygun olup olmadığını
	 * döndürür. Uygunsa tuşun hedefini verilen nesneyle değiştirirek tuşu
	 * kullanılmış olarak işaretler. */
	public boolean kullanmayıDene(final Object nesne) {
		if (hedefi == null) {
			hedefi = nesne;
			return true;
		}
		
		return hedefi == nesne;
	}
}
