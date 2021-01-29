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
		this.yerleşikDikdörtgen.kurallar(new GöreliKural(DikdörtgenVerisi.KÜÇÜK),
				new TersGöreliKural(DikdörtgenVerisi.BÜYÜK, Pencere.ÇARPI_GENİŞLİĞİ),
				new GöreliKural(DikdörtgenVerisi.KÜÇÜK),
				new SerbestKural(DikdörtgenVerisi.UZUNLUK, Pencere.ÇUBUK_KALINLIĞI));
	}
	
	@Override
	public void güncelle() {
		if (this.üzerinde && this.ekran.solTık.aşağı()) {
			this.odakla();
			((SerbestKural)this.levha.yerleşikDikdörtgen.yatayKural()).ekle(this.ekran.girdi.sürükleme.x);
			((SerbestKural)this.levha.yerleşikDikdörtgen.dikeyKural()).ekle(this.ekran.girdi.sürükleme.y);
			this.yerleştir();
		}
	}
}
