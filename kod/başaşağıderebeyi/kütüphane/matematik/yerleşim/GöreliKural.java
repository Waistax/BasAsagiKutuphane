/**
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 * 0.4 / 18 Oca 2021 / 08:10:04
 *
 * BaşAşağıMotor'dan alındı.
 * 0.16 / 13 Eyl 2020 / 18:48:35
 */
package başaşağıderebeyi.kütüphane.matematik.yerleşim;

import static başaşağıderebeyi.kütüphane.matematik.dikdörtgen.DikdörtgenVerisi.*;

import başaşağıderebeyi.kütüphane.matematik.dikdörtgen.*;

/** Dikdörtgenin verisini üstün küçük verisine göre tanımlayan kural. */
public class GöreliKural extends YerleşimKuralı {
	/** Üst dikdörtgenin küçük verisine olan uzaklık. */
	public float uzaklığı;
	
	/** Uzaklığı sıfır olarak tanımlar. */
	public GöreliKural(final DikdörtgenVerisi uygulanacağıVeri) {
		super(uygulanacağıVeri, false);
	}
	
	/** Belirli bir uzaklıkla tanımlar. */
	public GöreliKural(
		final DikdörtgenVerisi dikdörtgenVerisi,
		final float uzaklık) {
		this(dikdörtgenVerisi);
		uzaklığı = uzaklık;
	}
	
	@Override
	protected void yerleştir() {
		verisi
			.değeriDeğiştir(
				uygulanacağıDikdörtgen,
				verisi
					.aynıBoyuttakiniEdin(KÜÇÜK_KÖŞESİ)
					.değeriEdin(içerenDikdörtgen) +
					uzaklığı);
	}
}
