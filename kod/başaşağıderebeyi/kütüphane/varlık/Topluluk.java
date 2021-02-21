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
	public final Set<Varlık> varlıklar;
	public final Set<Soy> soylar;
	
	public Topluluk() {
		varlıklar = new HashSet<>();
		soylar = new HashSet<>();
	}

	public void güncelle() {
		for (Soy soy : soylar)
			soy.güncelle();
	}
	
	public void çiz() {
		for (Soy soy : soylar)
			soy.çiz();
	}
	
	public void çıkar(Varlık varlık) {
		if (varlıklar.remove(varlık))
			for (Soy soy : soylar)
				soy.çıkar(varlık);
	}
}
