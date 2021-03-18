/**
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 * 0.11 / 2 Mar 2021 / 18:57:35
 */
package başaşağıderebeyi.kütüphane.kumhavuzu.varlık;

import başaşağıderebeyi.kütüphane.kumhavuzu.*;
import başaşağıderebeyi.kütüphane.varlık.*;

/** Varlık bölümünü dener. */
public class VarlıkBölümüDenemesi {
	/** Bütün varlık bölümünün çalışmasını dener. */
	public static void varlıkBölümünüDene(final Deney deney) {
		deney.başlat("Varlık");
		
		final Topluluk topluluk = new Topluluk();
		final DenemeSoyu soy = new DenemeSoyu(topluluk, 1.0F);
		topluluk.güncelle();
		deney.dene(soy.sıralıÇarpımınıEdin(), 1.0F, 0.001F);
		deney.dene(soy.paralelÇarpımınıEdin(), 1.0F, 0.001F);
		
		Varlık varlık = new Varlık(topluluk);
		topluluk.güncelle();
		deney.dene(soy.sıralıÇarpımınıEdin(), 1.0F, 0.001F);
		deney.dene(soy.paralelÇarpımınıEdin(), 1.0F, 0.001F);
		
		new DenemeBileşeni(varlık, 3.0F);
		topluluk.güncelle();
		deney.dene(soy.sıralıÇarpımınıEdin(), 3.0F, 0.001F);
		deney.dene(soy.paralelÇarpımınıEdin(), 3.0F, 0.001F);
		
		topluluk.varlığınıÇıkar(varlık);
		topluluk.güncelle();
		deney.dene(soy.sıralıÇarpımınıEdin(), 3.0F, 0.001F);
		deney.dene(soy.paralelÇarpımınıEdin(), 3.0F, 0.001F);
		
		varlık = new Varlık(topluluk);
		new DenemeBileşeni(varlık, 10.0F);
		topluluk.güncelle();
		deney.dene(soy.sıralıÇarpımınıEdin(), 30.0F, 0.001F);
		deney.dene(soy.paralelÇarpımınıEdin(), 30.0F, 0.001F);
		
		topluluk.soyunuÇıkar(soy);
		topluluk.güncelle();
		deney.dene(soy.sıralıÇarpımınıEdin(), 30.0F, 0.001F);
		deney.dene(soy.paralelÇarpımınıEdin(), 30.0F, 0.001F);
		
		deney.bitir();
	}
}
