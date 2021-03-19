/**
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 * 0.6 / 19 Oca 2021 / 09:31:30
 */
package başaşağıderebeyi.kütüphane.kumhavuzu.olay;

/** Dağıtıcıyı denemek için oluşturulmuş dinleyici. */
public class DenemeDinleyicisi {
	private float çarpımı;
	
	DenemeDinleyicisi(final float çarpımınBaşlangıçDeğeri) {
		çarpımı = çarpımınBaşlangıçDeğeri;
	}
	
	/** Yüzeysel seviyede deneme olaylarını dinler. */
	public void denemeOlayınıDinle(final DenemeOlayı olay) {
		çarpımı *= Float.parseFloat(olay.iletisi);
	}
	
	/** Yüzeysel seviyede deneme olaylarını dinler. Ayrıca kaldırılmış olayları
	 * da dinler. */
	public void susturulmuşDenemeOlayınıDinle(final DenemeOlayı olay) {
		if (olay.susturulması)
			çarpımı = 99.0F;
	}
	
	/** Temel seviyede deneme olaylarını dinler. Olayları ilk alacak
	 * dinleyicidir. */
	public void temeldenDenemeOlayınıDinle(final DenemeOlayı olay) {
		try {
			Float.parseFloat(olay.iletisi);
		} catch (final NumberFormatException hata) {
			olay.susturulması = true;
		}
	}
	
	float çarpımınıEdin() {
		return çarpımı;
	}
}
