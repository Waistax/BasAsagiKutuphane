/**
 * başaşağıderebeyi.kütüphane.arayüz.Pencere.java
 * 0.7 / 19 Oca 2021 / 12:50:22
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 * 
 * BaşAşağıMotor'dan alındı.
 * 0.16 / 13 Eyl 2020 / 21:51:31
 */
package başaşağıderebeyi.kütüphane.arayüz;

import başaşağıderebeyi.kütüphane.matematik.*;
import başaşağıderebeyi.kütüphane.matematik.yerleşim.*;

/** Ekranda bağımsız bir öğe. */
public class Pencere extends Levha {
	/** Pencereyi kapatma tuşunun genişliği. */
	public static final float ÇARPI_GENİŞLİĞİ = 50.0F;
	/** Pencerenin üstündeki çubuğun kalınlığı. */
	public static final float ÇUBUK_KALINLIĞI = 30.0F;
	/** Pencerenin başlığı. */
	public final String başlık;
	
	/** Ekranın en üstünde tanımlar. */
	public Pencere(final Ekran ekran, final String başlık, final float genişlik, final float yükseklik) {
		super(ekran, null, ekran);
		this.başlık = başlık;
		yerleşikDikdörtgeni.kurallar(	new SerbestKural(	DikdörtgenVerisi.ORTA,
															ekran.alanı.o.birinciBileşeni),
										new SerbestKural(DikdörtgenVerisi.UZUNLUK, genişlik),
										new SerbestKural(	DikdörtgenVerisi.ORTA,
															ekran.alanı.o.ikinciBileşeni),
										new SerbestKural(DikdörtgenVerisi.UZUNLUK, yükseklik));
		new PencereÇubuğu(this);
		new Düğme(	this,
					"X",
					new PencereyiKapat(this)).yerleşikDikdörtgeni.kurallar(	new TersGöreliKural(DikdörtgenVerisi.BÜYÜK),
																			new SerbestKural(	DikdörtgenVerisi.UZUNLUK,
																								Pencere.ÇARPI_GENİŞLİĞİ),
																			new GöreliKural(DikdörtgenVerisi.KÜÇÜK),
																			new SerbestKural(	DikdörtgenVerisi.UZUNLUK,
																								Pencere.ÇUBUK_KALINLIĞI));
	}
	
	@Override
	public void odakla() {
		içerenEkran.içerik.remove(this);
		içerenEkran.içerik.add(this);
	}
}
