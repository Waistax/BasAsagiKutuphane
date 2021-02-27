/**
 * başaşağıderebeyi.kütüphane.arayüz.PencereÇubuğu.java
 * 0.7 / 26 Oca 2021 / 21:05:26
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 * 
 * BaşAşağıMotor'dan alındı.
 * 0.16 / 13 Eyl 2020 / 21:58:50
 */
package başaşağıderebeyi.kütüphane.arayüz;

import başaşağıderebeyi.kütüphane.matematik.*;
import başaşağıderebeyi.kütüphane.matematik.yerleşim.*;

/** Pencerenin üstündeki şerit. */
public class PencereÇubuğu extends Öğe {
	/** Pencerede tanımlar. */
	public PencereÇubuğu(final Pencere pencere) {
		super(pencere, pencere, pencere.içerenEkran);
		yerleşikDikdörtgeni
			.kurallarıDeğiştir(
				new GöreliKural(DikdörtgenVerisi.KÜÇÜK_KÖŞESİ),
				new TersGöreliKural(
					DikdörtgenVerisi.BÜYÜK_KÖŞESİ,
					Pencere.ÇARPI_GENİŞLİĞİ),
				new GöreliKural(DikdörtgenVerisi.KÜÇÜK_KÖŞESİ),
				new SerbestKural(
					DikdörtgenVerisi.UZUNLUKLARI,
					Pencere.ÇUBUK_KALINLIĞI));
	}
	
	@Override
	public void güncelle() {
		if (imlecinAltındaOlması && içerenEkran.solTık.basılıOlmasınıEdin()) {
			odakla();
			((SerbestKural)içerenLevha.yerleşikDikdörtgeni.yatayKural())
				.ekle(içerenEkran.girdi.imlecininSürüklenmesi.birinciBileşeni);
			((SerbestKural)içerenLevha.yerleşikDikdörtgeni.dikeyKural())
				.ekle(içerenEkran.girdi.imlecininSürüklenmesi.ikinciBileşeni);
			yerleştir();
		}
	}
}
