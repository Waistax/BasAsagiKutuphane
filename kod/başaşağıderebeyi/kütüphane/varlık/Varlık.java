/**
 * başaşağıderebeyi.kütüphane.varlık.Varlık.java
 * 0.8 / 17 Şub 2021 / 10:50:27
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 * 
 * BaşAşağıMotor'dan alındı.
 * 0.22 / 4 Kas 2020 / 18:09:39
 */
package başaşağıderebeyi.kütüphane.varlık;

import java.util.*;

public class Varlık {
	public final Map<Class<? extends Bileşen>, Bileşen> bileşenler;
	public final Topluluk topluluk;
	
	public Varlık(final Topluluk topluluk) {
		this.topluluk = topluluk;
		bileşenler = new HashMap<>();
		topluluk.varlıklar.add(this);
	}
	
	@SuppressWarnings("unchecked")
	public <T extends Bileşen> T bileşen(final Class<T> sınıf) {
		return (T)bileşenler.get(sınıf);
	}
}
