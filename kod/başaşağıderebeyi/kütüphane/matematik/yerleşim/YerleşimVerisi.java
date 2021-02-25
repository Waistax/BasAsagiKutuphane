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
			return ö.k.birinciBileşeni;
		case BÜYÜK_YATAY:
			return ö.b.birinciBileşeni;
		case KÜÇÜK_DİKEY:
			return ö.k.ikinciBileşeni;
		case BÜYÜK_DİKEY:
			return ö.b.ikinciBileşeni;
		case ORTA_YATAY:
			return ö.o.birinciBileşeni;
		case ORTA_DİKEY:
			return ö.o.ikinciBileşeni;
		case UZUNLUK_YATAY:
			return ö.u.birinciBileşeni;
		case UZUNLUK_DİKEY:
			return ö.u.ikinciBileşeni;
		default:
			return 0.0F;
		}
	}
	
	/** Aynı boyuttaki BÜYÜK veriyi verir. */
	public YerleşimVerisi büyük() {
		return YerleşimVerisi.values()[DikdörtgenVerisi.BÜYÜK.ordinal() * 2 +
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
		return YerleşimVerisi.values()[DikdörtgenVerisi.KÜÇÜK.ordinal() * 2 +
			ordinal() % 2];
	}
	
	/** Aynı boyuttaki ORTA veriyi verir. */
	public YerleşimVerisi orta() {
		return YerleşimVerisi.values()[DikdörtgenVerisi.ORTA.ordinal() * 2 +
			ordinal() % 2];
	}
	
	/** Aynı boyuttaki UZUNLUK veriyi verir. */
	public YerleşimVerisi uzunluk() {
		return YerleşimVerisi.values()[DikdörtgenVerisi.UZUNLUK.ordinal() * 2 +
			ordinal() % 2];
	}
	
	/** Yerleştirdiği veriyi değiştirir. */
	public YerleşimVerisi yaz(final Dikdörtgen ö, final float o) {
		switch (this) {
		case KÜÇÜK_YATAY:
			ö.k.birinciBileşeni = o;
			return this;
		case KÜÇÜK_DİKEY:
			ö.k.ikinciBileşeni = o;
			return this;
		case BÜYÜK_YATAY:
			ö.b.birinciBileşeni = o;
			return this;
		case BÜYÜK_DİKEY:
			ö.b.ikinciBileşeni = o;
			return this;
		case ORTA_YATAY:
			ö.o.birinciBileşeni = o;
			return this;
		case ORTA_DİKEY:
			ö.o.ikinciBileşeni = o;
			return this;
		case UZUNLUK_YATAY:
			ö.u.birinciBileşeni = o;
			return this;
		case UZUNLUK_DİKEY:
			ö.u.ikinciBileşeni = o;
			return this;
		default:
			return this;
		}
	}
}
