/**
 * başaşağıderebeyi.kütüphane.kumhavuzu.olay.OlayBölümüDenemesi.java
 * 0.10 / 27 Şub 2021 / 19:10:45
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.kütüphane.kumhavuzu.olay;

import başaşağıderebeyi.kütüphane.olay.*;

/** Olay bölümünü dener. */
public class OlayBölümüDenemesi {
	/** Olayların ve dağıtıcının çalışmasını dener. */
	public static boolean olayDenemesi() {
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("Olay denemesi başlıyor... (0/3)");
		
		final OlayYöneticisi dağıtıcı = new OlayYöneticisi();
		final DenemeDinleyicisi dinleyici = new DenemeDinleyicisi(1.0F);
		dağıtıcı.dinleyiciEkle(dinleyici);
		
		dağıtıcı.olayEkle(new DenemeOlayı("3.14159"));		
		dağıtıcı.güncelle();
		
		if (dinleyici.çarpımıDene(3.14159F))
			return false;

		System.out.println("1. deneme geçildi... (1/3)");

		dağıtıcı.olayEkle(new DenemeOlayı("Bu Cem kötüdür!"));
		dağıtıcı.güncelle();
		
		if (dinleyici.çarpımıDene(99.0F))
			return false;

		System.out.println("2. deneme geçildi... (2/3)");
		
		dağıtıcı.dinleyiciÇıkar(dinleyici);
		dağıtıcı.olayEkle(new DenemeOlayı("2.79"));
		dağıtıcı.güncelle();
		
		if (dinleyici.çarpımıDene(99.0F))
			return false;

		System.out.println("3. deneme geçildi... (3/3)");
		System.out.println("Olay denemesi tamamlandı... (3/3)");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		return true;
	}
}
