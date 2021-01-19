/**
 * başaşağıderebeyi.kütüphane.kumhavuzu.DenemeDinleyicisi.java
 * 0.6 / 19 Oca 2021 / 09:31:30
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.kütüphane.kumhavuzu;

import başaşağıderebeyi.kütüphane.olay.*;

/** Dağıtıcıyı denemek için oluşturulmuş dinleyici. */
public class DenemeDinleyicisi {
	/** İlk önce olayı alacak dinleyici yöntem. */
	@Dinleyici(öncelik = Öncelik.TEMEL)
	public void denemeOlayıOlduTemel(DenemeOlayı olay) {
		olay.kaldırılmış = olay.ileti.contains("Cem kötü");
	}

	/** Kaldırılmış olayları da alacak yöntem. */
	@Dinleyici(kaldırılmışlarıDinler = true)
	public void denemeOlayıOlduKaldırılmış(DenemeOlayı olay) {
		if (olay.kaldırılmış)
			System.out.println("Susturulmuş ileti: " + olay.ileti);
	}
	
	/** Yüzeysel seviyede olayları alacak yöntem. */
	@Dinleyici
	public void denemeOlayıOldu(DenemeOlayı olay) {
		System.out.println("İleti: " + olay.ileti);
	}
}
