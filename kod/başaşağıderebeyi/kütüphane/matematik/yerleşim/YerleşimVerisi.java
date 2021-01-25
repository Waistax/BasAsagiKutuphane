/**
 * başaşağıderebeyi.kütüphane.matematik.yerleşim.YerleşimVerisi.java
 * 0.4 / 17 Oca 2021 / 13:55:22
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.kütüphane.matematik.yerleşim;

import başaşağıderebeyi.kütüphane.matematik.*;

/** Bir kuralın yerleştirdiği farklı verilerin sıralaması. */
public enum YerleşimVerisi {
	/** Verilerin yatay ve dikey ile birleştirmeleri: */
	KÜÇÜK_YATAY, KÜÇÜK_DİKEY, BÜYÜK_YATAY, BÜYÜK_DİKEY, ORTA_YATAY, ORTA_DİKEY, UZUNLUK_YATAY, UZUNLUK_DİKEY;
	
	/** Dikdörtgen verisinden belli bir boyuttakini verir. */
	public static YerleşimVerisi al(final DikdörtgenVerisi veri, final boolean yatay) {
		return YerleşimVerisi.values()[veri.ordinal() * 2 + (yatay ? 0 : 1)];
	}
	
	/** Aynı boyuttaki karşı veriyi verir. */
	public YerleşimVerisi karşı() {
		return YerleşimVerisi.values()[this.ordinal() - this.ordinal() % 2 * 2 + 1];
	}
	
	/** Diğer boyuttaki aynı veridir. */
	public YerleşimVerisi komşu() {
		return YerleşimVerisi.values()[this.ordinal() - this.ordinal() % 2 + (this.ordinal() + 1) % 2];
	}
	
	/** Aynı boyuttaki KÜÇÜK veriyi verir. */
	public YerleşimVerisi küçük() {
		return YerleşimVerisi.values()[DikdörtgenVerisi.KÜÇÜK.ordinal() * 2 + this.ordinal() % 2];
	}
	
	/** Aynı boyuttaki BÜYÜK veriyi verir. */
	public YerleşimVerisi büyük() {
		return YerleşimVerisi.values()[DikdörtgenVerisi.BÜYÜK.ordinal() * 2 + this.ordinal() % 2];
	}
	
	/** Aynı boyuttaki ORTA veriyi verir. */
	public YerleşimVerisi orta() {
		return YerleşimVerisi.values()[DikdörtgenVerisi.ORTA.ordinal() * 2 + this.ordinal() % 2];
	}
	
	/** Aynı boyuttaki UZUNLUK veriyi verir. */
	public YerleşimVerisi uzunluk() {
		return YerleşimVerisi.values()[DikdörtgenVerisi.UZUNLUK.ordinal() * 2 + this.ordinal() % 2];
	}
	
	/** Yerleştirdiği veriyi verir. */
	public float al(final Dikdörtgen ö) {
		switch (this) {
		case KÜÇÜK_YATAY:
			return ö.k.x;
		case BÜYÜK_YATAY:
			return ö.b.x;
		case KÜÇÜK_DİKEY:
			return ö.k.y;
		case BÜYÜK_DİKEY:
			return ö.b.y;
		case ORTA_YATAY:
			return ö.o.x;
		case ORTA_DİKEY:
			return ö.o.y;
		case UZUNLUK_YATAY:
			return ö.u.x;
		case UZUNLUK_DİKEY:
			return ö.u.y;
		default:
			return 0.0F;
		}
	}
	
	/** Yerleştirdiği veriyi değiştirir. */
	public YerleşimVerisi yaz(final Dikdörtgen ö, final float o) {
		switch (this) {
		case KÜÇÜK_YATAY:
			ö.k.x = o;
			return this;
		case KÜÇÜK_DİKEY:
			ö.k.y = o;
			return this;
		case BÜYÜK_YATAY:
			ö.b.x = o;
			return this;
		case BÜYÜK_DİKEY:
			ö.b.y = o;
			return this;
		case ORTA_YATAY:
			ö.o.x = o;
			return this;
		case ORTA_DİKEY:
			ö.o.y = o;
			return this;
		case UZUNLUK_YATAY:
			ö.u.x = o;
			return this;
		case UZUNLUK_DİKEY:
			ö.u.y = o;
			return this;
		default:
			return this;
		}
	}
}
