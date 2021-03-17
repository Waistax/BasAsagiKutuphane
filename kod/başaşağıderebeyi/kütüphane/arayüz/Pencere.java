/**
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 * 0.7 / 19 Oca 2021 / 12:50:22
 * 
 * BaşAşağıMotor'dan alındı.
 * 0.16 / 13 Eyl 2020 / 21:51:31
 */
package başaşağıderebeyi.kütüphane.arayüz;

import static başaşağıderebeyi.kütüphane.matematik.dikdörtgen.DikdörtgenVerisi.*;

import başaşağıderebeyi.kütüphane.matematik.yerleşim.*;

/** Ekranda bağımsız bir öğe. */
public class Pencere extends Levha {
	/** Pencereyi kapatma tuşunun genişliği. */
	public static final float ÇARPI_GENİŞLİĞİ = 50.0F;
	/** Pencerenin üstündeki çubuğun kalınlığı. */
	public static final float ÇUBUK_KALINLIĞI = 30.0F;
	
	/** Pencerenin orta noktasının yatay konumunu belirleyen kural. */
	public final SerbestKural yatayKonumununKuralı;
	/** Pencerenin orta noktasının dikey konumunu belirleyen kural. */
	public final SerbestKural dikeyKonumununKuralı;
	
	/** Pencerenin başlığı. */
	public String başlığı;
	
	/** Ekranın en üstünde tanımlar. */
	public Pencere(
		final Ekran ekran,
		final float genişlik,
		final float yükseklik) {
		super(ekran, null, ekran);
		
		yerleşimi
			.kurallarıDeğiştir(
				yatayKonumununKuralı = new SerbestKural(
					ORTA_NOKTASI,
					ekran.alanı.ortaNoktası.birinciBileşeni),
				new SerbestKural(UZUNLUKLARI, genişlik),
				dikeyKonumununKuralı = new SerbestKural(
					ORTA_NOKTASI,
					ekran.alanı.ortaNoktası.ikinciBileşeni),
				new SerbestKural(UZUNLUKLARI, yükseklik));
		new PencereÇubuğu(this);
		
		final Düğme kapatmaDüğmesi = new Düğme(this);
		kapatmaDüğmesi.yerleşimi
			.kurallarıDeğiştir(
				new TersGöreliKural(BÜYÜK_KÖŞESİ),
				new SerbestKural(UZUNLUKLARI, Pencere.ÇARPI_GENİŞLİĞİ),
				new TersGöreliKural(BÜYÜK_KÖŞESİ),
				new SerbestKural(UZUNLUKLARI, Pencere.ÇUBUK_KALINLIĞI));
		kapatmaDüğmesi.çalıştıracağı = () -> içerenLevha.içeriği.remove(this);
		kapatmaDüğmesi.yazısı = "X";
	}
	
	@Override
	public void odakla() {
		içerenEkran.içeriği.remove(this);
		içerenEkran.içeriği.add(this);
	}
}
