/**
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 * 0.7 / 26 Oca 2021 / 21:05:26
 * 
 * BaşAşağıMotor'dan alındı.
 * 0.16 / 13 Eyl 2020 / 21:58:50
 */
package başaşağıderebeyi.kütüphane.arayüz;

import static başaşağıderebeyi.kütüphane.matematik.dikdörtgen.DikdörtgenVerisi.*;

import başaşağıderebeyi.kütüphane.matematik.yerleşim.*;

/** Pencerenin üstündeki şerit. */
public class PencereÇubuğu extends Öğe {
	/** Pencerede tanımlar. */
	public PencereÇubuğu(final Pencere pencere) {
		super(pencere, pencere, pencere.içerenEkran);
		yerleşimi
			.kurallarıDeğiştir(
				new GöreliKural(KÜÇÜK_KÖŞESİ),
				new TersGöreliKural(BÜYÜK_KÖŞESİ, Pencere.ÇARPI_GENİŞLİĞİ),
				new TersGöreliKural(BÜYÜK_KÖŞESİ),
				new SerbestKural(UZUNLUKLARI, Pencere.ÇUBUK_KALINLIĞI));
	}
	
	@Override
	public void güncelle() {
		if (sürüklenmesiniBul()) {
			odakla();
			içerenPencere.yatayKonumununKuralı.değeri +=
				içerenEkran.girdi.imlecininSürüklenmesi.birinciBileşeni;
			içerenPencere.dikeyKonumununKuralı.değeri +=
				içerenEkran.girdi.imlecininSürüklenmesi.ikinciBileşeni;
			içerenPencere.yerleştir();
		}
	}
}
