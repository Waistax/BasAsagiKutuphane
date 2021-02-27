/**
 * başaşağıderebeyi.kütüphane.matematik.yerleşim.YerleşikDikdörtgen.java
 * 0.4 / 17 Oca 2021 / 16:19:40
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 *
 * BaşAşağıMotor'dan alındı.
 * 0.24 / 7 Kas 2020 / 15:28:16
 */
package başaşağıderebeyi.kütüphane.matematik.yerleşim;

import başaşağıderebeyi.kütüphane.matematik.*;

/** Bir dikdörtgeni diğer bir dikdörtgenin içine verilen kurallar ile
 * yerleştirmeye yarayan araç. */
public class Yerleşim {
	private final Dikdörtgen içerenDikdörtgen;
	private final Dikdörtgen uygulanacağıDikdörtgen;
	private final YerleşimKuralı[] kuralları;
	
	/** Verilen dikdörtgenler için tanımlar. */
	public Yerleşim(
		final Dikdörtgen içerenDikdörtgen,
		final Dikdörtgen uygulanacağıDikdörtgen) {
		this.içerenDikdörtgen = içerenDikdörtgen;
		this.uygulanacağıDikdörtgen = uygulanacağıDikdörtgen;
		kuralları = new YerleşimKuralı[4];
	}
	
	/** Yerleşimi uygular. */
	public void yerleştir() {
		for (final YerleşimKuralı kuralı : kuralları)
			kuralı.yerleştir();
	}
	
	/** Yerleşim kurallarını verilenler ile değiştirir. İlk iki kural yatay,
	 * diğer iki kural ise dikey veriler için olmalıdır. */
	public void kurallarıDeğiştir(final YerleşimKuralı... kurallar) {
		int işaretçi =
			kurallar[0].bağımlıOlması || kurallar[1].bağımlıOlması ? 2 : 0;
		for (int i = 0; i < 4; i++) {
			final YerleşimKuralı kural = kurallar[i];
			kural.içerenDikdörtgen = içerenDikdörtgen;
			kural.uygulanacağıDikdörtgen = uygulanacağıDikdörtgen;
			kural.verisi = YerleşimVerisi.al(kural.uygulanacağıVeri, i < 2);
			kuralları[işaretçi++ % 4] = kural;
		}
	}
}
