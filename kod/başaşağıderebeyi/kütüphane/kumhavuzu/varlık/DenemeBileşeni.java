/**
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 * 0.11 / 2 Mar 2021 / 18:59:41
 */
package başaşağıderebeyi.kütüphane.kumhavuzu.varlık;

import başaşağıderebeyi.kütüphane.varlık.*;

class DenemeBileşeni extends Bileşen {
	float çarpanı;
	
	DenemeBileşeni(final Varlık içerenVarlık, final float çarpan) {
		super(içerenVarlık);
		çarpanı = çarpan;
	}
}
