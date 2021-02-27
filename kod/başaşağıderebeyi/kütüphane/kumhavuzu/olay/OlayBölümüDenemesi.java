/**
 * başaşağıderebeyi.kütüphane.kumhavuzu.olay.OlayBölümüDenemesi.java
 * 0.10 / 27 Şub 2021 / 19:10:45
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.kütüphane.kumhavuzu.olay;

import başaşağıderebeyi.kütüphane.kumhavuzu.*;
import başaşağıderebeyi.kütüphane.olay.*;

/** Olay bölümünü dener. */
public class OlayBölümüDenemesi {
	/** Olayların ve dağıtıcının çalışmasını dener. */
	public static void olayDenemesi(final Deney deney) {
		deney.başlat("Olay");
		
		final OlayYöneticisi dağıtıcı = new OlayYöneticisi();
		final DenemeDinleyicisi dinleyici = new DenemeDinleyicisi(1.0F);
		dağıtıcı.dinleyiciEkle(dinleyici);
		
		dağıtıcı.olayEkle(new DenemeOlayı("3.14159"));
		dağıtıcı.güncelle();
		deney.dene(dinleyici.çarpımıDene(3.14159F));
		
		dağıtıcı.olayEkle(new DenemeOlayı("Bu Cem kötüdür!"));
		dağıtıcı.güncelle();
		deney.dene(dinleyici.çarpımıDene(99.0F));
		
		dağıtıcı.dinleyiciÇıkar(dinleyici);
		dağıtıcı.olayEkle(new DenemeOlayı("2.79"));
		dağıtıcı.güncelle();
		deney.dene(dinleyici.çarpımıDene(99.0F));
		
		deney.bitir();
	}
}
