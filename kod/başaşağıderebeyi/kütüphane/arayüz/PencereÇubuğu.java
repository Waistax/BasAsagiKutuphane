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
		super(pencere, pencere, pencere.ekran);
		yerleşikDikdörtgen.kurallar(new GöreliKural(DikdörtgenVerisi.KÜÇÜK),
									new TersGöreliKural(DikdörtgenVerisi.BÜYÜK,
														Pencere.ÇARPI_GENİŞLİĞİ),
									new GöreliKural(DikdörtgenVerisi.KÜÇÜK),
									new SerbestKural(	DikdörtgenVerisi.UZUNLUK,
														Pencere.ÇUBUK_KALINLIĞI));
	}
	
	@Override
	public void güncelle() {
		if (üzerinde && ekran.solTık.aşağı()) {
			odakla();
			((SerbestKural)levha.yerleşikDikdörtgen.yatayKural()).ekle(ekran.girdi.sürükleme.x);
			((SerbestKural)levha.yerleşikDikdörtgen.dikeyKural()).ekle(ekran.girdi.sürükleme.y);
			yerleştir();
		}
	}
}
