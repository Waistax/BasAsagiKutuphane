/**
 * başaşağıderebeyi.kütüphane.varlık.Soy.java
 * 0.8 / 17 Şub 2021 / 10:53:54
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 * 
 * BaşAşağıMotor'dan alındı.
 * 0.22 / 4 Kas 2020 / 19:00:40
 */
package başaşağıderebeyi.kütüphane.varlık;

import java.util.*;

public class Soy {
	public final Class<? extends Bileşen>[] gerekliSınıflar;
	public final Topluluk topluluk;
	public final Set<Varlık> varlıklar;
	
	@SuppressWarnings("unchecked")
	public Soy(final Topluluk topluluk, final Class<?>... gerekliSınıflar) {
		this.topluluk = topluluk;
		varlıklar = new HashSet<>();
		this.gerekliSınıflar = (Class<? extends Bileşen>[])gerekliSınıflar;
		topluluk.soylar.add(this);
		for (final Varlık varlık : topluluk.varlıklar)
			ekle(varlık);
	}
	
	public void çıkar(final Varlık varlık) {
		if (varlıklar.remove(varlık))
			çıkarıldı(varlık);
	}
	
	public void çıkarıldı(final Varlık varlık) {
	}
	
	public void çiz() {
	}
	
	public void ekle(final Varlık varlık) {
		if (karşılıyorMu(varlık) && varlıklar.add(varlık))
			eklendi(varlık);
	}
	
	public void eklendi(final Varlık varlık) {
	}
	
	public void güncelle() {
	}
	
	public boolean karşılıyorMu(final Varlık varlık) {
		for (final Class<? extends Bileşen> sınıf : gerekliSınıflar)
			if (varlık.bileşen(sınıf) == null)
				return false;
		return true;
	}
}
