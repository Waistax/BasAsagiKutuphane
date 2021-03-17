/**
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 * 0.8 / 17 Şub 2021 / 10:50:27
 * 
 * BaşAşağıMotor'dan alındı.
 * 0.22 / 4 Kas 2020 / 18:09:39
 */
package başaşağıderebeyi.kütüphane.varlık;

import java.util.*;

/** Bileşenlerin birleşmesiyle ortaya çıkan bir oluşum. */
public class Varlık {
	/** Varlığın içinde bulunduğu topluluk. */
	public final Topluluk içerenTopluluk;
	/** Varlığı tanımlayan bileşenler. */
	public final Map<Class<? extends Bileşen>, Bileşen> bileşenleri;
	
	/** Verilen topluluğun içinde tanımlar. */
	public Varlık(final Topluluk içerenTopluluk) {
		this.içerenTopluluk = içerenTopluluk;
		bileşenleri = new HashMap<>();
		içerenTopluluk.varlığıEkle(this);
	}
	
	/** Verilen sınıftan olan bileşeni döndürür. Eğer öyle bir bileşen yoksa
	 * null döndürür. */
	@SuppressWarnings("unchecked")
	public <T extends Bileşen> T bileşeniniEdin(final Class<T> sınıfı) {
		return (T)bileşenleri.get(sınıfı);
	}
	
	@SuppressWarnings("unchecked")
	void bileşeniEkle(final Bileşen bileşen) {
		Class<? extends Bileşen> sınıfı = bileşen.getClass();
		
		do {
			bileşenleri.put(sınıfı, bileşen);
			sınıfı = (Class<? extends Bileşen>)sınıfı.getSuperclass();
		} while (sınıfı != Bileşen.class);
		
		içerenTopluluk.varlığınıTekrarSoylarınaEklemeyiDene(this);
	}
}
