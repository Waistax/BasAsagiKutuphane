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
	private final YerleşimKuralı[] sıralıKuralları;
	
	/** Verilen dikdörtgenler için tanımlar. */
	public Yerleşim(
		final Dikdörtgen içerenDikdörtgen,
		final Dikdörtgen uygulanacağıDikdörtgen) {
		this.içerenDikdörtgen = içerenDikdörtgen;
		this.uygulanacağıDikdörtgen = uygulanacağıDikdörtgen;
		kuralları = new YerleşimKuralı[4];
		sıralıKuralları = new YerleşimKuralı[4];
	}
	
	/** Yerleşimi uygular. */
	public void yerleştir() {
		sıralıKuralları[0].yerleştir();
		sıralıKuralları[1].yerleştir();
		sıralıKuralları[2].yerleştir();
		sıralıKuralları[3].yerleştir();
	}
	
	/** Verilen kuralları ekler. Kuralların yatay ve dikey kuralların kendi
	 * içlerinde sırası önemli değildir. */
	public void kurallarEkle(
		final YerleşimKuralı birinciYatayKural,
		final YerleşimKuralı ikinciYatayKural,
		final YerleşimKuralı birinciDikeyKural,
		final YerleşimKuralı ikinciDikeyKural) {
		kuralları[0] = birinciYatayKural;
		kuralları[1] = ikinciYatayKural;
		kuralları[2] = birinciDikeyKural;
		kuralları[3] = ikinciDikeyKural;
		kurallarınıSırala();
		kurallarınıAyarla();
	}
	
	private void kurallarınıSırala() {
		if (kuralları[0].bağımlı || kuralları[1].bağımlı) {
			kuralÇiftiniSırala(true, 2);
			kuralÇiftiniSırala(false, 0);
		} else {
			kuralÇiftiniSırala(true, 0);
			kuralÇiftiniSırala(false, 2);
		}
	}
	
	private void kuralÇiftiniSırala(
		final boolean yataydakiÇiftiOlmaları,
		final int işaretçi) {
		final int sıraları = yataydakiÇiftiOlmaları ? 0 : 2;
		if (kuralları[0].ikincil) {
			sıralıKuralları[işaretçi] = kuralları[sıraları + 1];
			sıralıKuralları[işaretçi + 1] = kuralları[sıraları];
		} else {
			sıralıKuralları[işaretçi] = kuralları[sıraları];
			sıralıKuralları[işaretçi + 1] = kuralları[sıraları + 1];
		}
	}
	
	private void kurallarınıAyarla() {
		for (final YerleşimKuralı kuralı : kuralları) {
			kuralı.ana = içerenDikdörtgen;
			kuralı.hedef = uygulanacağıDikdörtgen;
		}
		sıralıKuralları[1].birincilVeri = sıralıKuralları[0].veri;
		sıralıKuralları[3].birincilVeri = sıralıKuralları[2].veri;
	}
	
	/** Yataydaki verilerini belirleyen birinci kuralı döndürür. */
	public <T extends YerleşimKuralı> T birinciYatayKuralınıEdin() {
		return kuralınıEdin(0);
	}
	
	/** Yataydaki verilerini belirleyen ikinci kuralı döndürür. */
	public <T extends YerleşimKuralı> T ikinciYatayKuralınıEdin() {
		return kuralınıEdin(1);
	}
	
	/** Dikeydeki verilerini belirleyen birinci kuralı döndürür. */
	public <T extends YerleşimKuralı> T birinciDikeyKuralınıEdin() {
		return kuralınıEdin(2);
	}
	
	/** Dikeydeki verilerini belirleyen ikinci kuralı döndürür. */
	public <T extends YerleşimKuralı> T ikinciDikeyKuralınıEdin() {
		return kuralınıEdin(3);
	}
	
	@SuppressWarnings("unchecked")
	private <T extends YerleşimKuralı> T kuralınıEdin(final int sırası) {
		return (T)kuralları[sırası];
	}
}
