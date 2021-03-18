/**
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 * 0.6 / 19 Oca 2021 / 08:09:17
 */
package başaşağıderebeyi.kütüphane.kumhavuzu;

import başaşağıderebeyi.kütüphane.kumhavuzu.olay.*;
import başaşağıderebeyi.kütüphane.kumhavuzu.varlık.*;
import başaşağıderebeyi.kütüphane.kumhavuzu.yerleşim.*;
import başaşağıderebeyi.kütüphane.kumhavuzu.yürütücü.*;

/** Farklı yöntemlerin çalışıp çalışmadığını dener. */
class KodDeneme {
	/** Denemenin başlangıcı. */
	public static void main(final String[] args) {
		final Deney deney = new Deney();
		OlayBölümüDenemesi.olayBölümünüDene(deney);
		VarlıkBölümüDenemesi.varlıkBölümünüDene(deney);
		YerleşimBölümüDenemesi.yerleşimBölümünüDene(deney);
		YürütücüBölümüDenemesi.yürütücüBölümünüDene();
	}
}
