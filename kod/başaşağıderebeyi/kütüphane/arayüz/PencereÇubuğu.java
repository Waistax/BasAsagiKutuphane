/**
 * başaşağıderebeyi.kütüphane.arayüz.PencereÇubuğu.java
 * 0.7 / 26 Oca 2021 / 21:05:26
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.kütüphane.arayüz;

import başaşağıderebeyi.kütüphane.matematik.*;
import başaşağıderebeyi.kütüphane.matematik.yerleşim.*;

/** Pencerenin üstündeki şerit. */
public class PencereÇubuğu extends Öğe {
	/** Pencerede tanımlar. */
	public PencereÇubuğu(final Pencere pencere) {
		super(pencere);
		this.yerleşikDikdörtgen.kurallar(new GöreliKural(DikdörtgenVerisi.KÜÇÜK),
				new TersGöreliKural(DikdörtgenVerisi.BÜYÜK, Pencere.ÇARPI_GENİŞLİĞİ),
				new GöreliKural(DikdörtgenVerisi.KÜÇÜK),
				new SerbestKural(DikdörtgenVerisi.UZUNLUK, Pencere.ÇUBUK_KALINLIĞI));
	}
	
	@Override
	public void güncelle() {
		if (this.ekran.girdi.imleçUygunMu(this) && this.ekran.solTık.aşağı()) {
			this.odakla();
			
			this.yerleştir();
		}
	}
}
