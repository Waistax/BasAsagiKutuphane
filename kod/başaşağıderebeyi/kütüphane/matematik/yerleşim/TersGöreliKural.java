/**
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 * 0.4 / 18 Oca 2021 / 08:16:39
 *
 * BaşAşağıMotor'dan alındı.
 * 0.16 / 13 Eyl 2020 / 18:52:31
 */
package başaşağıderebeyi.kütüphane.matematik.yerleşim;

import static başaşağıderebeyi.kütüphane.matematik.dikdörtgen.DikdörtgenVerisi.*;

import başaşağıderebeyi.kütüphane.matematik.dikdörtgen.*;

/** Dikdörtgenin verisini üstün büyük verisine göre tanımlayan kural. */
public class TersGöreliKural extends YerleşimKuralı {
	/** Üst dikdörtgenin büyük verisine olan ters uzaklık. */
	public float uzaklığı;
	
	/** Uzaklığı sıfır olarak tanımlar. */
	public TersGöreliKural(final DikdörtgenVerisi uygulanacağıVeri) {
		super(uygulanacağıVeri, false);
	}
	
	/** Belirli bir uzaklıkla tanımlar. */
	public TersGöreliKural(
		final DikdörtgenVerisi uygulanacağıVeri,
		final float uzaklık) {
		this(uygulanacağıVeri);
		uzaklığı = uzaklık;
	}
	
	@Override
	protected void yerleştir() {
		verisi
			.değeriDeğiştir(
				uygulanacağıDikdörtgen,
				verisi
					.aynıBoyuttakiniEdin(BÜYÜK_KÖŞESİ)
					.değeriEdin(içerenDikdörtgen) -
					uzaklığı);
	}
}
