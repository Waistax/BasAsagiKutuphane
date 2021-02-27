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
	public Pencere(
		final Ekran ekran,
		final String başlık,
		final float genişlik,
		final float yükseklik) {
		super(ekran, null, ekran);
		this.başlık = başlık;
		yerleşikDikdörtgeni
			.kurallarEkle(
				new SerbestKural(
					DikdörtgenVerisi.ORTA_NOKTASI,
					ekran.alanı.ortaNoktası.birinciBileşeni),
				new SerbestKural(DikdörtgenVerisi.UZUNLUKLARI, genişlik),
				new SerbestKural(
					DikdörtgenVerisi.ORTA_NOKTASI,
					ekran.alanı.ortaNoktası.ikinciBileşeni),
				new SerbestKural(DikdörtgenVerisi.UZUNLUKLARI, yükseklik));
		new PencereÇubuğu(this);
		new Düğme(this, "X", new PencereyiKapat(this)).yerleşikDikdörtgeni
			.kurallarEkle(
				new TersGöreliKural(DikdörtgenVerisi.BÜYÜK_KÖŞESİ),
				new SerbestKural(
					DikdörtgenVerisi.UZUNLUKLARI,
					Pencere.ÇARPI_GENİŞLİĞİ),
				new GöreliKural(DikdörtgenVerisi.KÜÇÜK_KÖŞESİ),
				new SerbestKural(
					DikdörtgenVerisi.UZUNLUKLARI,
					Pencere.ÇUBUK_KALINLIĞI));
	}
	
	@Override
	public void odakla() {
		içerenEkran.içerik.remove(this);
		içerenEkran.içerik.add(this);
	}
}
