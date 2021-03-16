/**
 * başaşağıderebeyi.kütüphane.arayüz.KaydırmaÇubuğu.java
 * 0.12.2 / 16 Mar 2021 / 18:20:01
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 * 
 * BaşAşağıMotor'dan alındı.
 * 0.17 / 15 Eyl 2020 / 18:03:11
 */
package başaşağıderebeyi.kütüphane.arayüz;

import static başaşağıderebeyi.kütüphane.matematik.DikdörtgenVerisi.*;
import static başaşağıderebeyi.kütüphane.matematik.MatematikAracı.*;

import başaşağıderebeyi.kütüphane.matematik.yerleşim.*;

import java.util.function.*;

/** Kayan levhanın görünen alanını kaydırmada kullanılan çubuk. */
public class KaydırmaÇubuğu extends Öğe {
	/** Çubuğun kalınlığı. */
	public static final float KALINLIĞI = 10.0F;
	
	private final Runnable sürükleyici;
	private final Runnable yerleştirici;
	private final Supplier<Float> konumunuEdinici;
	private final Supplier<Float> konumununSınırınıBulucu;
	private final Consumer<Float> konumunuDeğiştirici;
	private final Consumer<Float> kaydırıcı;
	
	private final SerbestKural genişliğininKuralı;
	private final SerbestKural yüksekliğininKuralı;
	
	KaydırmaÇubuğu(
		final KayanLevha kaydırdığı,
		final boolean dikeyÇubukOlması) {
		super(kaydırdığı.içerenLevha.içerenLevha);
		
		genişliğininKuralı = new SerbestKural(UZUNLUKLARI);
		yüksekliğininKuralı = new SerbestKural(UZUNLUKLARI);
		
		if (dikeyÇubukOlması) {
			genişliğininKuralı.değeri = KALINLIĞI;
			final TersGöreliKural dikeyKonumununKuralı =
				new TersGöreliKural(BÜYÜK_KÖŞESİ);
			yerleşimi
				.kurallarıDeğiştir(
					new TersGöreliKural(BÜYÜK_KÖŞESİ),
					genişliğininKuralı,
					dikeyKonumununKuralı,
					yüksekliğininKuralı);
			
			sürükleyici = () -> dikeyKonumununKuralı.uzaklığı -=
				içerenEkran.girdi.imlecininSürüklenmesi.ikinciBileşeni;
			
			yerleştirici = () -> {
				yüksekliğininKuralı.değeri = karesiniBul(
					kaydırdığı.içerenLevha.içerenLevha.alanı.uzunlukları.ikinciBileşeni) /
					kaydırdığı.alanı.uzunlukları.ikinciBileşeni;
				açıkOlması =
					yüksekliğininKuralı.değeri < kaydırdığı.içerenLevha.alanı.uzunlukları.ikinciBileşeni;
			};
			
			konumunuEdinici = () -> dikeyKonumununKuralı.uzaklığı;
			
			konumununSınırınıBulucu =
				() -> kaydırdığı.içerenLevha.içerenLevha.alanı.uzunlukları.ikinciBileşeni -
					alanı.uzunlukları.ikinciBileşeni;
			
			konumunuDeğiştirici =
				konum -> dikeyKonumununKuralı.uzaklığı = konum;
			
			kaydırıcı = konumununSınırı -> kaydırdığı.kayması.ikinciBileşeni =
				dikeyKonumununKuralı.uzaklığı / konumununSınırı;
		} else {
			yüksekliğininKuralı.değeri = KALINLIĞI;
			final GöreliKural yatayKonumununKuralı =
				new GöreliKural(KÜÇÜK_KÖŞESİ);
			yerleşimi
				.kurallarıDeğiştir(
					yatayKonumununKuralı,
					genişliğininKuralı,
					new GöreliKural(KÜÇÜK_KÖŞESİ),
					yüksekliğininKuralı);
			
			sürükleyici = () -> yatayKonumununKuralı.uzaklığı +=
				içerenEkran.girdi.imlecininSürüklenmesi.birinciBileşeni;
			
			yerleştirici = () -> {
				genişliğininKuralı.değeri = karesiniBul(
					kaydırdığı.içerenLevha.alanı.uzunlukları.birinciBileşeni) /
					kaydırdığı.alanı.uzunlukları.birinciBileşeni;
				açıkOlması =
					genişliğininKuralı.değeri < kaydırdığı.içerenLevha.alanı.uzunlukları.birinciBileşeni;
			};
			
			konumunuEdinici = () -> yatayKonumununKuralı.uzaklığı;
			
			konumununSınırınıBulucu =
				() -> kaydırdığı.içerenLevha.alanı.uzunlukları.birinciBileşeni -
					alanı.uzunlukları.birinciBileşeni;
			
			konumunuDeğiştirici =
				konum -> yatayKonumununKuralı.uzaklığı = konum;
			
			kaydırıcı = konumununSınırı -> kaydırdığı.kayması.birinciBileşeni =
				-yatayKonumununKuralı.uzaklığı / konumununSınırı;
		}
	}
	
	@Override
	public void yerleştir() {
		yerleştirici.run();
		super.yerleştir();
	}
	
	@Override
	public void güncelle() {
		if (!açıkOlmasınıEdin())
			return;
		
		if (sürüklenmesiniBul()) {
			sürükleyici.run();
			odakla();
		}
		
		final float konumununSınırı = konumununSınırınıBulucu.get();
		
		if (konumunuEdinici.get() > konumununSınırı)
			konumunuDeğiştirici.accept(konumununSınırı);
		
		if (konumunuEdinici.get() < 0.0F)
			konumunuDeğiştirici.accept(0.0F);
		
		kaydırıcı.accept(konumununSınırı);
		içerenLevha.yerleştir();
	}
}
