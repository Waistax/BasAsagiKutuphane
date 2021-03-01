/**
 * başaşağıderebeyi.kütüphane.kumhavuzu.Deney.java
 * 0.10 / 27 Şub 2021 / 19:21:57
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.kütüphane.kumhavuzu;

import başaşağıderebeyi.kütüphane.matematik.*;

/** Deneylerin başlangıç ve bitişlerini kaydeder. Denemelerin sonuçlarını teker
 * teker yazdırır. */
public class Deney {
	private String adı;
	private int denemelerininSayısı;
	private int geçilenDenemelerininSayısı;
	
	/** Verilen ad ile deneyi başlatır. */
	public void başlat(final String adı) {
		final String başlangıçBildirisi =
			(this.adı = adı) + " deneyi başlıyor...";
		çizgiYazdır(başlangıçBildirisi.length());
		System.out.println(başlangıçBildirisi);
		
		denemelerininSayısı = 0;
		geçilenDenemelerininSayısı = 0;
	}
	
	/** Verilen denemenin sonucunu yazdırır. Denemeler bir ondalık sayı değer
	 * oluşturmalıdırlar. Böylece bu değer ve beklenen değer verilen özür payı
	 * ile karşılaştırılır. Çok yüksek özür payları sorunlu denemelerin
	 * geçmesine sebep olurken, çok düşük özür payları geçmesi gereken
	 * denemeleri geçirmez. */
	public void dene(
		final float değer,
		final float beklenenDeğer,
		final float özürPayı) {
		final boolean deneme =
			MatematikAracı.denkSayılmalarınıBul(değer, beklenenDeğer, özürPayı);
		System.out.print((++denemelerininSayısı) + ". deneme ");
		
		if (deneme) {
			System.out.print("geçildi!");
			geçilenDenemelerininSayısı++;
		} else
			System.out.print("geçilemedi!");
		
		System.out
			.println(
				" " + değer + " / " + beklenenDeğer + " (" + özürPayı + ")");
		System.out.flush();
		
		if (!deneme) {
			System.err.println(Thread.currentThread().getStackTrace()[2]);
			System.err.flush();
		}
	}
	
	/** En son başlatılan deneyi bitirir. */
	public void bitir() {
		final String bitişBildirisi = adı +
			" deneyi tamamlandı. Denemelerin geçme oranı: " +
			geçilenDenemelerininSayısı +
			"/" +
			denemelerininSayısı;
		System.out.println(bitişBildirisi);
		çizgiYazdır(bitişBildirisi.length());
	}
	
	private void çizgiYazdır(final int uzunluğu) {
		final StringBuilder dizeOluşturucusu = new StringBuilder(uzunluğu);
		
		for (int i = 0; i < uzunluğu; i++)
			dizeOluşturucusu.append('~');
		
		System.out.println(dizeOluşturucusu.toString());
	}
}
