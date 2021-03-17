/**
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 * 0.12 / 15 Mar 2021 / 11:07:37
 */
package başaşağıderebeyi.kütüphane.kumhavuzu.yerleşim;

import static başaşağıderebeyi.kütüphane.matematik.dikdörtgen.DikdörtgenVerisi.*;

import başaşağıderebeyi.kütüphane.kumhavuzu.*;
import başaşağıderebeyi.kütüphane.matematik.dikdörtgen.*;
import başaşağıderebeyi.kütüphane.matematik.yerleşim.*;

/** Yerleşim bölümünü dener. */
public class YerleşimBölümüDenemesi {
	/** Bütün yerleşim bölümünün çalışmasını dener. */
	public static void yerleşimBölümünüDene(final Deney deney) {
		deney.başlat("Yerleşim");
		
		final Dikdörtgen içerenDikdörtgen = new Dikdörtgen();
		final Yerleşim içerenYerleşim = new Yerleşim(null, içerenDikdörtgen);
		
		içerenYerleşim
			.kurallarıDeğiştir(
				new SerbestKural(ORTA_NOKTASI, 30.0F),
				new SerbestKural(KÜÇÜK_KÖŞESİ, 0.0F),
				new SerbestKural(ORTA_NOKTASI, 30.0F),
				new SerbestKural(KÜÇÜK_KÖŞESİ, 0.0F));
		içerenYerleşim.yerleştir();
		
		deney
			.dene(içerenDikdörtgen.ortaNoktası.birinciBileşeni, 30.0F, 0.0001F);
		deney
			.dene(içerenDikdörtgen.uzunlukları.birinciBileşeni, 60.0F, 0.0001F);
		
		final Dikdörtgen dikdörtgen = new Dikdörtgen();
		final Yerleşim yerleşim = new Yerleşim(içerenDikdörtgen, dikdörtgen);
		
		yerleşim
			.kurallarıDeğiştir(
				new GöreliKural(KÜÇÜK_KÖŞESİ, 10.0F),
				new OrtalıKural(),
				new TersGöreliKural(BÜYÜK_KÖŞESİ, 10.0F),
				new OranlıKural(0.5F));
		yerleşim.yerleştir();
		
		deney.dene(dikdörtgen.büyükKöşesi.birinciBileşeni, 50.0F, 0.0001F);
		deney.dene(dikdörtgen.küçükKöşesi.ikinciBileşeni, 30.0F, 0.0001F);
		deney.dene(dikdörtgen.uzunlukları.ikinciBileşeni, 20.0F, 0.0001F);
		
		yerleşim
			.kurallarıDeğiştir(
				new GöreliKural(KÜÇÜK_KÖŞESİ, 10.0F),
				new OrtalıKural(),
				new TersGöreliKural(BÜYÜK_KÖŞESİ, 10.0F),
				new OranlıKural(0.75F));
		yerleşim.yerleştir();
		
		deney.dene(dikdörtgen.büyükKöşesi.birinciBileşeni, 50.0F, 0.0001F);
		deney.dene(dikdörtgen.küçükKöşesi.ikinciBileşeni, 20.0F, 0.0001F);
		deney.dene(dikdörtgen.uzunlukları.ikinciBileşeni, 30.0F, 0.0001F);
		
		deney.bitir();
	}
}
