/**
 * başaşağıderebeyi.kütüphane.varlık.Topluluk.java
 * 0.8 / 17 Şub 2021 / 10:54:36
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 * 
 * BaşAşağıMotor'dan alındı.
 * 0.22 / 4 Kas 2020 / 18:47:22
 */
package başaşağıderebeyi.kütüphane.varlık;

import java.util.*;

public class Topluluk {
	public final Set<Soy> soylar;
	public final Set<Varlık> varlıklar;
	
	public Topluluk() {
		varlıklar = new HashSet<>();
		soylar = new HashSet<>();
	}
	
	public void çıkar(final Varlık varlık) {
		if (varlıklar.remove(varlık))
			for (final Soy soy : soylar)
				soy.çıkar(varlık);
	}
	
	public void çiz() {
		for (final Soy soy : soylar)
			soy.çiz();
	}
	
	public void güncelle() {
		for (final Soy soy : soylar)
			soy.güncelle();
	}
}
