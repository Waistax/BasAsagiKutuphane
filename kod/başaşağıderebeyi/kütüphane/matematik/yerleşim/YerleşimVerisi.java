/**
 * başaşağıderebeyi.kütüphane.matematik.yerleşim.YerleşimVerisi.java
 * 0.4 / 17 Oca 2021 / 13:55:22
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.kütüphane.matematik.yerleşim;

import başaşağıderebeyi.kütüphane.matematik.*;

/** Bir kuralın yerleştirdiği farklı verilerin sıralaması. */
public enum YerleşimVerisi {
		BÜYÜK_DİKEY,
		BÜYÜK_YATAY,
		KÜÇÜK_DİKEY,
		/** Verilerin yatay ve dikey ile birleştirmeleri: */
		KÜÇÜK_YATAY,
		ORTA_DİKEY,
		ORTA_YATAY,
		UZUNLUK_DİKEY,
		UZUNLUK_YATAY;
		
	/** Dikdörtgen verisinden belli bir boyuttakini verir. */
	public static YerleşimVerisi al(
		final DikdörtgenVerisi veri,
		final boolean yatay) {
		return YerleşimVerisi.values()[veri.ordinal() * 2 + (yatay ? 0 : 1)];
	}
	
	/** Yerleştirdiği veriyi verir. */
	public float al(final Dikdörtgen ö) {
		switch (this) {
		case KÜÇÜK_YATAY:
			return ö.küçükKöşesi.birinciBileşeni;
		case BÜYÜK_YATAY:
			return ö.büyükKöşesi.birinciBileşeni;
		case KÜÇÜK_DİKEY:
			return ö.küçükKöşesi.ikinciBileşeni;
		case BÜYÜK_DİKEY:
			return ö.büyükKöşesi.ikinciBileşeni;
		case ORTA_YATAY:
			return ö.ortaNoktası.birinciBileşeni;
		case ORTA_DİKEY:
			return ö.ortaNoktası.ikinciBileşeni;
		case UZUNLUK_YATAY:
			return ö.uzunlukları.birinciBileşeni;
		case UZUNLUK_DİKEY:
			return ö.uzunlukları.ikinciBileşeni;
		default:
			return 0.0F;
		}
	}
	
	/** Aynı boyuttaki BÜYÜK veriyi verir. */
	public YerleşimVerisi büyük() {
		return YerleşimVerisi
			.values()[DikdörtgenVerisi.BÜYÜK_KÖŞESİ.ordinal() * 2 +
				ordinal() % 2];
	}
	
	/** Aynı boyuttaki karşı veriyi verir. */
	public YerleşimVerisi karşı() {
		return YerleşimVerisi.values()[ordinal() - ordinal() % 2 * 2 + 1];
	}
	
	/** Diğer boyuttaki aynı veridir. */
	public YerleşimVerisi komşu() {
		return YerleşimVerisi
			.values()[ordinal() - ordinal() % 2 + (ordinal() + 1) % 2];
	}
	
	/** Aynı boyuttaki KÜÇÜK veriyi verir. */
	public YerleşimVerisi küçük() {
		return YerleşimVerisi
			.values()[DikdörtgenVerisi.KÜÇÜK_KÖŞESİ.ordinal() * 2 +
				ordinal() % 2];
	}
	
	/** Aynı boyuttaki ORTA veriyi verir. */
	public YerleşimVerisi orta() {
		return YerleşimVerisi
			.values()[DikdörtgenVerisi.ORTA_NOKTASI.ordinal() * 2 +
				ordinal() % 2];
	}
	
	/** Aynı boyuttaki UZUNLUK veriyi verir. */
	public YerleşimVerisi uzunluk() {
		return YerleşimVerisi
			.values()[DikdörtgenVerisi.UZUNLUKLARI.ordinal() * 2 +
				ordinal() % 2];
	}
	
	/** Yerleştirdiği veriyi değiştirir. */
	public YerleşimVerisi yaz(final Dikdörtgen ö, final float o) {
		switch (this) {
		case KÜÇÜK_YATAY:
			ö.küçükKöşesi.birinciBileşeni = o;
			return this;
		case KÜÇÜK_DİKEY:
			ö.küçükKöşesi.ikinciBileşeni = o;
			return this;
		case BÜYÜK_YATAY:
			ö.büyükKöşesi.birinciBileşeni = o;
			return this;
		case BÜYÜK_DİKEY:
			ö.büyükKöşesi.ikinciBileşeni = o;
			return this;
		case ORTA_YATAY:
			ö.ortaNoktası.birinciBileşeni = o;
			return this;
		case ORTA_DİKEY:
			ö.ortaNoktası.ikinciBileşeni = o;
			return this;
		case UZUNLUK_YATAY:
			ö.uzunlukları.birinciBileşeni = o;
			return this;
		case UZUNLUK_DİKEY:
			ö.uzunlukları.ikinciBileşeni = o;
			return this;
		default:
			return this;
		}
	}
}
