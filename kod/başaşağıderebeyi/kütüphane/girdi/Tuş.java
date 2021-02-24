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
	
	private volatile boolean aşağıOlması;
	private boolean basılıOlması;
	private boolean basılması;
	private boolean salınması;
	
	/** Tuşun girdisini kullanan (dinleyen ve işleyen) nesne. Tuş girdisini kullanmadan önce uygun olup olmadığına
	 * bakılmalı ve kullandıktan sonra bu nesne değiştirilmelidir. */
	public Object hedefi;
	
	public Tuş(final int kodu) {
		this.kodu = kodu;
	}
	
	/** Tuşun anlık durumunu günceller. */
	public void güncelle() {
		final boolean sonrakiDurumdaBasılıOlması = aşağıOlması;
		
		basılması = !basılıOlması && sonrakiDurumdaBasılıOlması;
		salınması = basılıOlması && !sonrakiDurumdaBasılıOlması;
		basılıOlması = sonrakiDurumdaBasılıOlması;
		
		hedefi = null;
	}
	
	/** Tuşun eşzamansız olarak aşağıda olup olmadığını değiştirir. */
	public void aşağıOlmasınıDeğiştir(final boolean aşağıOlması) {
		this.aşağıOlması = aşağıOlması;
	}
	
	/** Tuş şu anda basılıysa doğru döndürür. */
	public boolean basılıOlmasınıEdin() {
		return basılıOlması;
	}
	
	/** Tuş şu anda basılmaya başlandıysa doğru döndürür. */
	public boolean basılmasınıEdin() {
		return basılması;
	}
	
	/** Tuş şu anda bırakıldıysa doğru döndürür. */
	public boolean salınmasınıEdin() {
		return salınması;
	}
	
	/** Tuşun verilen nesne tarafından dinlenilmeye uygun olup olmadığını döndürür. Ayrıca uygunsa tuşu kullanılmış
	 * olarak verilen nesneyle işaretler. */
	public boolean kullanmayıDene(final Object nesne) {
		if (hedefi == null) {
			hedefi = nesne;
			return true;
		}
		
		return hedefi == nesne;
	}
}
