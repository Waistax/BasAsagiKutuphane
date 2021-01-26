/**
 * başaşağıderebeyi.kütüphane.arayüz.Pencere.java
 * 0.7 / 19 Oca 2021 / 12:50:22
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.kütüphane.arayüz;

import başaşağıderebeyi.kütüphane.matematik.*;
import başaşağıderebeyi.kütüphane.matematik.yerleşim.*;

/** Ekranda bağımsız bir öğe. */
public class Pencere extends Levha {
	/** Pencerenin üstündeki çubuğun kalınlığı. */
	public static final float ÇUBUK_KALINLIĞI = 30.0F;
	/** Pencereyi kapatma tuşunun genişliği. */
	public static final float ÇARPI_GENİŞLİĞİ = 50.0F;
	/** Pencerenin başlığı. */
	public final String başlık;
	
	/** Ekranın en üstünde tanımlar. */
	public Pencere(final Ekran ekran, final String başlık, final float genişlik, final float yükseklik) {
		super(ekran);
		this.başlık = başlık;
		this.yerleşikDikdörtgen.kurallar(new SerbestKural(DikdörtgenVerisi.ORTA, ekran.alan.o.x),
				new SerbestKural(DikdörtgenVerisi.UZUNLUK, genişlik),
				new SerbestKural(DikdörtgenVerisi.ORTA, ekran.alan.o.y),
				new SerbestKural(DikdörtgenVerisi.UZUNLUK, genişlik));
		
	}
}
