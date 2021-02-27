/**
 * başaşağıderebeyi.kütüphane.kumhavuzu.olay.DenemeDinleyicisi.java
 * 0.6 / 19 Oca 2021 / 09:31:30
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.kütüphane.kumhavuzu.olay;

import başaşağıderebeyi.kütüphane.olay.*;

/** Dağıtıcıyı denemek için oluşturulmuş dinleyici. */
class DenemeDinleyicisi {
	private float çarpımı;
	
	/** Bir başlangıç değeri ile tanımlar. */
	DenemeDinleyicisi(final float çarpımınBaşlangıçDeğeri) {
		çarpımı = çarpımınBaşlangıçDeğeri;
	}
	
	/** Yüzeysel seviyede deneme olaylarını dinler. */
	@Dinleyici
	private void denemeOlayınıDinle(final DenemeOlayı olay) {
		çarpımı *= Float.parseFloat(olay.iletisi);
	}
	
	/** Yüzeysel seviyede deneme olaylarını dinler. Ayrıca kaldırılmış olayları
	 * da dinler. */
	@Dinleyici(kaldırılmışlarıDinler = true)
	private void kaldırılmışDenemeOlayınıDinle(final DenemeOlayı olay) {
		if (olay.kaldırılmış)
			çarpımı = 99.0F;
	}
	
	/** Temel seviyede deneme olaylarını dinler. Olayları ilk alacak
	 * dinleyicidir. */
	@Dinleyici(öncelik = Öncelik.TEMEL)
	private void temeldenDenemeOlayınıDinle(final DenemeOlayı olay) {
		try {
			Float.parseFloat(olay.iletisi);
		} catch (final NumberFormatException hata) {
			olay.kaldırılmış = true;
		}
	}
	
	/** Çarpımı dener. */
	boolean çarpımıDene(final float beklenenÇarpım) {
		return çarpımı == beklenenÇarpım;
	}
}
