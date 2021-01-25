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
		this.kurallar = new YerleşimKuralı[4];
	}
	
	/** Yeni bir dikdörtgenden tanımlar. */
	public YerleşikDikdörtgen(final Dikdörtgen ana) {
		this(ana, new Dikdörtgen());
	}
	
	/** Dikdörtgeni yatay boyutta tanımlar. */
	private void yataydaYerleştir() {
		this.kurallar[0].yerleştir();
		this.kurallar[1].yerleştir();
		DikdörtgenVerisi.yatayıHesapla(this.kurallar[0].dikdörtgenVerisi, this.kurallar[1].dikdörtgenVerisi,
				this.hedef);
	}
	
	/** Dikdörtgeni dikey boyutta tanımlar. */
	private void dikeydeYerleştir() {
		this.kurallar[2].yerleştir();
		this.kurallar[3].yerleştir();
		DikdörtgenVerisi.yatayıHesapla(this.kurallar[2].dikdörtgenVerisi, this.kurallar[3].dikdörtgenVerisi,
				this.hedef);
	}
	
	/** Dikdörtgeni tanımlar. */
	public void yerleştir() {
		if (this.bağımlıYatay) {
			this.dikeydeYerleştir();
			this.yataydaYerleştir();
		} else {
			this.yataydaYerleştir();
			this.dikeydeYerleştir();
		}
	}
	
	/** Kuralları temizler. */
	public YerleşikDikdörtgen temizle() {
		this.kurallar[0] = null;
		this.kurallar[2] = null;
		this.bağımlıYatay = false;
		return this;
	}
	
	/** Kurallara yeni bir kuralı ekler. */
	public YerleşikDikdörtgen kuralEkle(final YerleşimKuralı kural, final boolean yatay) {
		kural.ana = this.ana;
		kural.hedef = this.hedef;
		kural.veri = YerleşimVerisi.al(kural.dikdörtgenVerisi, yatay);
		
		int kaçıklık = 2;
		
		if (yatay) {
			kaçıklık = 0;
			this.bağımlıYatay = this.bağımlıYatay || kural.bağımlı;
		}
		
		if (this.kurallar[kaçıklık] == null) {
			if (kural.ikincil) {
				this.kurallar[kaçıklık + 1] = kural;
			} else {
				this.kurallar[kaçıklık] = kural;
				if (this.kurallar[kaçıklık + 1] != null) {
					this.kurallar[kaçıklık + 1].birincilVeri = kural.veri;
				}
			}
		} else {
			this.kurallar[kaçıklık + 1] = kural;
			kural.birincilVeri = this.kurallar[kaçıklık].veri;
		}
		
		return this;
	}
	
	/** Yatayda bir kural ekler. */
	public YerleşikDikdörtgen yatayKural(final YerleşimKuralı kural) {
		return this.kuralEkle(kural, true);
	}
	
	/** Dikeyde bir kural ekler. */
	public YerleşikDikdörtgen dikeyKural(final YerleşimKuralı kural) {
		return this.kuralEkle(kural, false);
	}
	
	/** Dört kuralı da birden ekler. */
	public YerleşikDikdörtgen kurallar(final YerleşimKuralı y1, final YerleşimKuralı y2, final YerleşimKuralı d1,
			final YerleşimKuralı d2) {
		return this.yatayKural(y1).yatayKural(y2).dikeyKural(d1).dikeyKural(d2);
	}
}
