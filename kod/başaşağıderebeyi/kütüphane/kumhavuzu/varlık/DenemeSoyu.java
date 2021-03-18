/**
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 * 0.11 / 2 Mar 2021 / 19:02:09
 */
package başaşağıderebeyi.kütüphane.kumhavuzu.varlık;

import başaşağıderebeyi.kütüphane.varlık.*;

class DenemeSoyu extends Soy {
	private float sıralıÇarpımı;
	private volatile float paralelÇarpımı;
	
	DenemeSoyu(final Topluluk topluluk, final float çarpımınBaşlangıçDeğeri) {
		super(topluluk, DenemeBileşeni.class);
		sıralıÇarpımı = çarpımınBaşlangıçDeğeri;
		paralelÇarpımı = çarpımınBaşlangıçDeğeri;
	}
	
	@Override
	public void güncelle() {
		varlıkları
			.stream()
			.map(varlığı -> varlığı.bileşeniniEdin(DenemeBileşeni.class))
			.forEach(
				varlığınınBileşeni -> sıralıÇarpımı *=
					varlığınınBileşeni.çarpanı);
		varlıkları
			.parallelStream()
			.map(varlığı -> varlığı.bileşeniniEdin(DenemeBileşeni.class))
			.forEach(bileşeni -> paralelÇarpımı *= bileşeni.çarpanı);
	}
	
	@Override
	public void çiz() {
	}
	
	float sıralıÇarpımınıEdin() {
		return sıralıÇarpımı;
	}
	
	float paralelÇarpımınıEdin() {
		return paralelÇarpımı;
	}
}
