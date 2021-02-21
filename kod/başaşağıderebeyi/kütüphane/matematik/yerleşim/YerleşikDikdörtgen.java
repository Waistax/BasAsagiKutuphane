/**
 * başaşağıderebeyi.kütüphane.matematik.yerleşim.YerleşikDikdörtgen.java
 * 0.4 / 17 Oca 2021 / 16:19:40
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 *
 * BaşAşağıMotor'dan alındı.
 * 0.24 / 7 Kas 2020 / 15:28:16
 */
package başaşağıderebeyi.kütüphane.matematik.yerleşim;

import başaşağıderebeyi.kütüphane.matematik.*;

/** Anlık olarak tanımlanan bir dikdörtgen. */
public class YerleşikDikdörtgen {
	/** Belirleyici, üst dikdörtgen. */
	private final Dikdörtgen ana;
	/** Yerleştirilecek dikdörtgen. */
	private final Dikdörtgen hedef;
	/** Yerleşimi belirleyen kurallar. */
	private final YerleşimKuralı[] kurallar;
	/** Yataydaki verilerin dikeydekilere bağlı olup olmadığı. */
	private boolean bağımlıYatay;
	
	/** Var olan bir dikdörtgenden tanımlar. */
	public YerleşikDikdörtgen(final Dikdörtgen ana, final Dikdörtgen hedef) {
		this.ana = ana;
		this.hedef = hedef;
		kurallar = new YerleşimKuralı[4];
	}
	
	/** Yeni bir dikdörtgenden tanımlar. */
	public YerleşikDikdörtgen(final Dikdörtgen ana) {
		this(ana, new Dikdörtgen());
	}
	
	/** Dikdörtgeni yatay boyutta tanımlar. */
	private void yataydaYerleştir() {
		kurallar[0].yerleştir();
		kurallar[1].yerleştir();
		DikdörtgenVerisi.yatayıHesapla(kurallar[0].dikdörtgenVerisi, kurallar[1].dikdörtgenVerisi, hedef);
	}
	
	/** Dikdörtgeni dikey boyutta tanımlar. */
	private void dikeydeYerleştir() {
		kurallar[2].yerleştir();
		kurallar[3].yerleştir();
		DikdörtgenVerisi.dikeyiHesapla(kurallar[2].dikdörtgenVerisi, kurallar[3].dikdörtgenVerisi, hedef);
	}
	
	/** Dikdörtgeni tanımlar. */
	public void yerleştir() {
		if (bağımlıYatay) {
			dikeydeYerleştir();
			yataydaYerleştir();
		} else {
			yataydaYerleştir();
			dikeydeYerleştir();
		}
	}
	
	/** Kuralları temizler. */
	public YerleşikDikdörtgen temizle() {
		kurallar[0] = null;
		kurallar[2] = null;
		bağımlıYatay = false;
		return this;
	}
	
	/** Kurallara yeni bir kuralı ekler. */
	public YerleşikDikdörtgen kuralEkle(final YerleşimKuralı kural, final boolean yatay) {
		kural.ana = ana;
		kural.hedef = hedef;
		kural.veri = YerleşimVerisi.al(kural.dikdörtgenVerisi, yatay);
		
		int kaçıklık = 2;
		
		if (yatay) {
			kaçıklık = 0;
			bağımlıYatay = bağımlıYatay || kural.bağımlı;
		}
		
		if (kurallar[kaçıklık] == null) {
			if (kural.ikincil)
				kurallar[kaçıklık + 1] = kural;
			else {
				kurallar[kaçıklık] = kural;
				if (kurallar[kaçıklık + 1] != null)
					kurallar[kaçıklık + 1].birincilVeri = kural.veri;
			}
		} else {
			kurallar[kaçıklık + 1] = kural;
			kural.birincilVeri = kurallar[kaçıklık].veri;
		}
		
		return this;
	}
	
	/** Yatayda bir kural ekler. */
	public YerleşikDikdörtgen yatayKural(final YerleşimKuralı kural) {
		return kuralEkle(kural, true);
	}
	
	/** Dikeyde bir kural ekler. */
	public YerleşikDikdörtgen dikeyKural(final YerleşimKuralı kural) {
		return kuralEkle(kural, false);
	}
	
	/** Dört kuralı da birden ekler. */
	public YerleşikDikdörtgen kurallar(final YerleşimKuralı y1, final YerleşimKuralı y2, final YerleşimKuralı d1,
			final YerleşimKuralı d2) {
		return this.yatayKural(y1).yatayKural(y2).dikeyKural(d1).dikeyKural(d2);
	}
	
	/** Yataydaki ilk kuralı döndürür. */
	public YerleşimKuralı yatayKural() {
		return kurallar[0];
	}
	
	/** Yataydaki ikinci kuralı döndürür. */
	public YerleşimKuralı ikincilYatayKural() {
		return kurallar[1];
	}
	
	/** Dikeydeki ilk kuralı döndürür. */
	public YerleşimKuralı dikeyKural() {
		return kurallar[2];
	}
	
	/** Dikeydeki ikinci kuralı döndürür. */
	public YerleşimKuralı ikincilDikeyKural() {
		return kurallar[3];
	}
}
