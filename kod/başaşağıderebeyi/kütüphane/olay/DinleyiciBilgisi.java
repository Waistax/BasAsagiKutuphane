/**
 * başaşağıderebeyi.kütüphane.olay.DinleyiciBilgisi.java
 * 0.6 / 19 Oca 2021 / 07:56:58
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 * 
 * BaşAşağıMotor'dan alındı.
 * 0.28 / 11 Kas 2020 / 21:35:37
 */
package başaşağıderebeyi.kütüphane.olay;

import java.lang.reflect.*;

/** Dinleyicinin kayıtlı bilgileri. */
class DinleyiciBilgisi {
	/** Kaydedilen nesne. */
	final Object nesne;
	/** Kaydedilen yöntem. */
	final Method yöntem;
	/** Kaydedilen dinleyicinin kaldırılmış olayları dinleyip dinlemediği. */
	final boolean kaldırılmışlarıDinler;

	/** Kaydı tanımlar. */
	DinleyiciBilgisi(Object nesne, Method yöntem, boolean kaldırılmışlarıDinler) {
		this.nesne = nesne;
		this.yöntem = yöntem;
		this.kaldırılmışlarıDinler = kaldırılmışlarıDinler;
	}
}
