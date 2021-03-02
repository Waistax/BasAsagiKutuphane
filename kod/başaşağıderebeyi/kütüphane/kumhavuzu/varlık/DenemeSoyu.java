/**
 * başaşağıderebeyi.kütüphane.kumhavuzu.varlık.DenemeSoyu.java
 * 0.11 / 2 Mar 2021 / 19:02:09
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.kütüphane.kumhavuzu.varlık;

import başaşağıderebeyi.kütüphane.varlık.*;

class DenemeSoyu extends Soy {
	private float çarpımı;
	private volatile float eşzamanlıÇarpımı;
	
	DenemeSoyu(final Topluluk topluluk, final float çarpımınBaşlangıçDeğeri) {
		super(topluluk, DenemeBileşeni.class);
		çarpımı = çarpımınBaşlangıçDeğeri;
		eşzamanlıÇarpımı = çarpımınBaşlangıçDeğeri;
	}
	
	@Override
	public void güncelle() {
		varlıkları
			.stream()
			.map(varlığı -> varlığı.bileşeniniEdin(DenemeBileşeni.class))
			.forEach(
				varlığınınBileşeni -> çarpımı *= varlığınınBileşeni.çarpanı);
		varlıkları
			.stream()
			.parallel()
			.map(varlığı -> varlığı.bileşeniniEdin(DenemeBileşeni.class))
			.forEach(bileşeni -> eşzamanlıÇarpımı *= bileşeni.çarpanı);
	}
	
	@Override
	public void çiz() {
	}
	
	float çarpımınıEdin() {
		return çarpımı;
	}
	
	float eşzamanlıÇarpımınıEdin() {
		return eşzamanlıÇarpımı;
	}
}
