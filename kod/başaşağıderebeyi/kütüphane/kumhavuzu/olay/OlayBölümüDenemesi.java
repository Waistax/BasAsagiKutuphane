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
	public static void olayBölümünüDene(final Deney deney) {
		deney.başlat("Olay");
		
		final AnlıOlayDağıtıcısı anlıDağıtıcı = new AnlıOlayDağıtıcısı();
		final DenemeDinleyicisi dinleyici = new DenemeDinleyicisi(1.0F);
		anlıDağıtıcı.dinleyicileriniEkle(dinleyici);
		
		anlıDağıtıcı.dağıt(new DenemeOlayı("3.14159"));
		anlıDağıtıcı.güncelle();
		deney.dene(dinleyici.çarpımınıEdin(), 3.14159F, 0.0001F);
		
		anlıDağıtıcı.dağıt(new DenemeOlayı("Bu Cem kötüdür!"));
		anlıDağıtıcı.güncelle();
		deney.dene(dinleyici.çarpımınıEdin(), 99.0F, 0.0001F);
		
		anlıDağıtıcı.dinleyicileriniÇıkar(dinleyici);
		anlıDağıtıcı.dağıt(new DenemeOlayı("2.79"));
		anlıDağıtıcı.güncelle();
		deney.dene(dinleyici.çarpımınıEdin(), 99.0F, 0.0001F);
		
		final OlayDağıtıcısı dağıtıcı = new OlayDağıtıcısı();
		dağıtıcı.dinleyicileriniEkle(dinleyici);
		dağıtıcı.dağıt(new DenemeOlayı("0.1"));
		deney.dene(dinleyici.çarpımınıEdin(), 9.9F, 0.01F);
		
		dağıtıcı.dağıt(new DenemeOlayı("Cem çok iyi birisidir!"));
		deney.dene(dinleyici.çarpımınıEdin(), 99.0F, 0.0001F);
		
		dağıtıcı.dinleyicileriniÇıkar(dinleyici);
		dağıtıcı.dağıt(new DenemeOlayı("2.79"));
		deney.dene(dinleyici.çarpımınıEdin(), 99.0F, 0.0001F);
		
		deney.bitir();
	}
}
