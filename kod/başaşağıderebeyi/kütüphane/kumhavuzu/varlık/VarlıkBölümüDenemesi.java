/**
 * başaşağıderebeyi.kütüphane.kumhavuzu.varlık.VarlıkBölümüDenemesi.java
 * 0.11 / 2 Mar 2021 / 18:57:35
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.kütüphane.kumhavuzu.varlık;

import başaşağıderebeyi.kütüphane.kumhavuzu.*;
import başaşağıderebeyi.kütüphane.varlık.*;

/** Varlık bölümünü dener. */
public class VarlıkBölümüDenemesi {
	/** Bütün varlık bölümünün çalışmasını dener. */
	public static void varlıkBölümüniDene(final Deney deney) {
		deney.başlat("Varlık");
		
		final Topluluk topluluk = new Topluluk();
		final DenemeSoyu soy = new DenemeSoyu(topluluk, 1.0F);
		topluluk.güncelle();
		deney.dene(soy.çarpımınıEdin(), 1.0F, 0.001F);
		deney.dene(soy.eşzamanlıÇarpımınıEdin(), 1.0F, 0.001F);
		
		Varlık varlık = new Varlık(topluluk);
		topluluk.güncelle();
		deney.dene(soy.çarpımınıEdin(), 1.0F, 0.001F);
		deney.dene(soy.eşzamanlıÇarpımınıEdin(), 1.0F, 0.001F);
		
		new DenemeBileşeni(varlık, 3.0F);
		topluluk.güncelle();
		deney.dene(soy.çarpımınıEdin(), 3.0F, 0.001F);
		deney.dene(soy.eşzamanlıÇarpımınıEdin(), 3.0F, 0.001F);
		
		topluluk.varlığınıÇıkar(varlık);
		topluluk.güncelle();
		deney.dene(soy.çarpımınıEdin(), 3.0F, 0.001F);
		deney.dene(soy.eşzamanlıÇarpımınıEdin(), 3.0F, 0.001F);
		
		varlık = new Varlık(topluluk);
		new DenemeBileşeni(varlık, 10.0F);
		topluluk.güncelle();
		deney.dene(soy.çarpımınıEdin(), 30.0F, 0.001F);
		deney.dene(soy.eşzamanlıÇarpımınıEdin(), 30.0F, 0.001F);
		
		topluluk.soyunuÇıkar(soy);
		topluluk.güncelle();
		deney.dene(soy.çarpımınıEdin(), 30.0F, 0.001F);
		deney.dene(soy.eşzamanlıÇarpımınıEdin(), 30.0F, 0.001F);
		
		deney.bitir();
	}
}
