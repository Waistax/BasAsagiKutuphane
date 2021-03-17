/**
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 * 0.4 / 17 Oca 2021 / 16:19:40
 *
 * BaşAşağıMotor'dan alındı.
 * 0.24 / 7 Kas 2020 / 15:28:16
 */
package başaşağıderebeyi.kütüphane.matematik.yerleşim;

import static başaşağıderebeyi.kütüphane.matematik.dikdörtgen.DikdörtgenVerisi.*;

import başaşağıderebeyi.kütüphane.matematik.dikdörtgen.*;

import java.util.*;

/** Bir dikdörtgeni diğer bir dikdörtgenin içine verilen kurallar ile
 * yerleştirmeye yarayan araç. */
public class Yerleşim {
	private final Dikdörtgen içerenDikdörtgen;
	private final Dikdörtgen uygulanacağıDikdörtgen;
	private final List<Runnable> yerleşimKomutları;
	
	/** Verilen dikdörtgenler için tanımlar. */
	public Yerleşim(
		final Dikdörtgen içerenDikdörtgen,
		final Dikdörtgen uygulanacağıDikdörtgen) {
		this.içerenDikdörtgen = içerenDikdörtgen;
		this.uygulanacağıDikdörtgen = uygulanacağıDikdörtgen;
		yerleşimKomutları = new ArrayList<>(6);
	}
	
	/** Yerleşim kurallarını uygular. */
	public void yerleştir() {
		yerleşimKomutları.forEach(Runnable::run);
	}
	
	/** Yerleşim kurallarını verilenler ile değiştirir. İlk iki kural yatay,
	 * diğer iki kural ise dikey veriler için olmalıdır. */
	public void kurallarıDeğiştir(final YerleşimKuralı... kurallar) {
		for (int i = 0; i < 4; i++) {
			final YerleşimKuralı kural = kurallar[i];
			kural.içerenDikdörtgen = içerenDikdörtgen;
			kural.uygulanacağıDikdörtgen = uygulanacağıDikdörtgen;
			kural.verisi = YerleşimVerisi
				.yerleşimVerisiEdin(kural.uygulanacağıVeri, i < 2);
		}
		
		yerleşimKomutları.clear();
		final int kaçıklığı =
			kurallar[0].bağımlıOlması || kurallar[1].bağımlıOlması ? 2 : 0;
		yerleşimKomutlarınıEkle(kaçıklığı, kurallar);
		yerleşimKomutlarınıEkle((kaçıklığı + 2) % 4, kurallar);
	}
	
	private void yerleşimKomutlarınıEkle(
		final int kaçıklığı,
		final YerleşimKuralı[] kurallar) {
		final YerleşimKuralı birincilKural = kurallar[kaçıklığı];
		final YerleşimKuralı ikincilKural = kurallar[kaçıklığı + 1];
		
		final int birleşimi = verilerinBirleşiminiBul(
			birincilKural.uygulanacağıVeri,
			ikincilKural.uygulanacağıVeri);
		
		yerleşimKomutları.add(() -> birincilKural.yerleştir());
		yerleşimKomutları.add(() -> ikincilKural.yerleştir());
		
		if (kaçıklığı > 1)
			yerleşimKomutları
				.add(
					() -> dikeyBileşenleriniBul(
						birleşimi,
						uygulanacağıDikdörtgen));
		else
			yerleşimKomutları
				.add(
					() -> yatayBileşenleriniBul(
						birleşimi,
						uygulanacağıDikdörtgen));
	}
}
