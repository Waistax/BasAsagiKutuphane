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
	public final Topluluk topluluk;
	public final Set<Varlık> varlıklar;
	public final Class<? extends Bileşen>[] gerekliSınıflar;
	
	@SuppressWarnings("unchecked")
	public Soy(Topluluk topluluk, Class<?>... gerekliSınıflar) {
		this.topluluk = topluluk;
		varlıklar = new HashSet<>();
		this.gerekliSınıflar = (Class<? extends Bileşen>[])gerekliSınıflar;
		topluluk.soylar.add(this);
		for (Varlık varlık : topluluk.varlıklar)
			ekle(varlık);
	}
	
	public boolean karşılıyorMu(Varlık varlık) {
		for (Class<? extends Bileşen> sınıf : gerekliSınıflar)
			if (varlık.bileşen(sınıf) == null)
				return false;
		return true;
	}
	
	public void ekle(Varlık varlık) {
		if (karşılıyorMu(varlık) && varlıklar.add(varlık))
			eklendi(varlık);
	}
	
	public void çıkar(Varlık varlık) {
		if (varlıklar.remove(varlık))
			çıkarıldı(varlık);
	}

	public void eklendi(Varlık varlık) {
	}
	
	public void çıkarıldı(Varlık varlık) {
	}
	
	public void güncelle() {
	}
	
	public void çiz() {
	}
}
