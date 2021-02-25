/**
 * başaşağıderebeyi.kütüphane.matematik.DikdörtgenVerisi.java
 * 0.4 / 17 Oca 2021 / 12:07:23
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 *
 * BaşAşağıMotor'dan alındı.
 * 0.24 / 7 Kas 2020 / 11:15:24
 */
package başaşağıderebeyi.kütüphane.matematik;

/** Dikdörtgeni tanımlarken kullanılan farklı verilerinin sıralaması. Bu veriler
 * bir nokta ya da bir uzunluk olabilir. Her boyut başına dikdörtgenin iki
 * farklı veriye ihtiyacı var. Kalan veriler bunları kullanarak
 * hesaplanabilir. */
public enum DikdörtgenVerisi {
		/** Köşelerden konumu büyük olan. */
		BÜYÜK,
		/** Köşelerden konumu küçük olan. */
		KÜÇÜK,
		/** Orta nokta. */
		ORTA,
		/** Kenar uzunluğu. */
		UZUNLUK;
		
	/** Bilinen verileri kullanarak, dikdörtgenin dikeydeki diğer verilerini
	 * hesaplar. */
	public static void dikeyiHesapla(
		final DikdörtgenVerisi v1,
		final DikdörtgenVerisi v2,
		final Dikdörtgen ö) {
		switch (v1) {
		case KÜÇÜK:
			switch (v2) {
			case KÜÇÜK:
				return;
			case BÜYÜK:
				ö.o.ikinciBileşeni = (ö.k.ikinciBileşeni + ö.b.ikinciBileşeni) /
					2.0F;
				ö.u.ikinciBileşeni = ö.b.ikinciBileşeni - ö.k.ikinciBileşeni;
				return;
			case ORTA:
				ö.b.ikinciBileşeni = 2.0F * ö.o.ikinciBileşeni -
					ö.k.ikinciBileşeni;
				ö.u.ikinciBileşeni = (ö.o.ikinciBileşeni - ö.k.ikinciBileşeni) *
					2.0F;
				return;
			case UZUNLUK:
				ö.b.ikinciBileşeni = ö.k.ikinciBileşeni + ö.u.ikinciBileşeni;
				ö.o.ikinciBileşeni = ö.k.ikinciBileşeni +
					ö.u.ikinciBileşeni / 2.0F;
				return;
			}
		case BÜYÜK:
			switch (v2) {
			case KÜÇÜK:
				DikdörtgenVerisi.dikeyiHesapla(v2, v1, ö);
			case BÜYÜK:
				return;
			case ORTA:
				ö.k.ikinciBileşeni = 2.0F * ö.o.ikinciBileşeni -
					ö.b.ikinciBileşeni;
				ö.u.ikinciBileşeni = (ö.b.ikinciBileşeni - ö.o.ikinciBileşeni) *
					2.0F;
				return;
			case UZUNLUK:
				ö.k.ikinciBileşeni = ö.b.ikinciBileşeni - ö.u.ikinciBileşeni;
				ö.o.ikinciBileşeni = ö.b.ikinciBileşeni -
					ö.u.ikinciBileşeni / 2.0F;
				return;
			}
		case ORTA:
			switch (v2) {
			case KÜÇÜK:
			case BÜYÜK:
				DikdörtgenVerisi.dikeyiHesapla(v2, v1, ö);
			case ORTA:
				return;
			case UZUNLUK:
				ö.k.ikinciBileşeni = ö.o.ikinciBileşeni -
					ö.u.ikinciBileşeni / 2.0F;
				ö.b.ikinciBileşeni = ö.o.ikinciBileşeni +
					ö.u.ikinciBileşeni / 2.0F;
				return;
			}
		case UZUNLUK:
			switch (v2) {
			case KÜÇÜK:
			case BÜYÜK:
			case ORTA:
				DikdörtgenVerisi.dikeyiHesapla(v2, v1, ö);
			case UZUNLUK:
				return;
			}
		}
	}
	
	/** Bilinen verileri kullanarak, dikdörtgenin yataydaki diğer verilerini
	 * hesaplar. */
	public static void yatayıHesapla(
		final DikdörtgenVerisi v1,
		final DikdörtgenVerisi v2,
		final Dikdörtgen ö) {
		switch (v1) {
		case KÜÇÜK:
			switch (v2) {
			case KÜÇÜK:
				return;
			case BÜYÜK:
				ö.o.birinciBileşeni = (ö.k.birinciBileşeni +
					ö.b.birinciBileşeni) / 2.0F;
				ö.u.birinciBileşeni = ö.b.birinciBileşeni - ö.k.birinciBileşeni;
				return;
			case ORTA:
				ö.b.birinciBileşeni = 2.0F * ö.o.birinciBileşeni -
					ö.k.birinciBileşeni;
				ö.u.birinciBileşeni = (ö.o.birinciBileşeni -
					ö.k.birinciBileşeni) * 2.0F;
				return;
			case UZUNLUK:
				ö.b.birinciBileşeni = ö.k.birinciBileşeni + ö.u.birinciBileşeni;
				ö.o.birinciBileşeni = ö.k.birinciBileşeni +
					ö.u.birinciBileşeni / 2.0F;
				return;
			}
		case BÜYÜK:
			switch (v2) {
			case KÜÇÜK:
				DikdörtgenVerisi.yatayıHesapla(v2, v1, ö);
			case BÜYÜK:
				return;
			case ORTA:
				ö.k.birinciBileşeni = 2.0F * ö.o.birinciBileşeni -
					ö.b.birinciBileşeni;
				ö.u.birinciBileşeni = (ö.b.birinciBileşeni -
					ö.o.birinciBileşeni) * 2.0F;
				return;
			case UZUNLUK:
				ö.k.birinciBileşeni = ö.b.birinciBileşeni - ö.u.birinciBileşeni;
				ö.o.birinciBileşeni = ö.b.birinciBileşeni -
					ö.u.birinciBileşeni / 2.0F;
				return;
			}
		case ORTA:
			switch (v2) {
			case KÜÇÜK:
			case BÜYÜK:
				DikdörtgenVerisi.yatayıHesapla(v2, v1, ö);
			case ORTA:
				return;
			case UZUNLUK:
				ö.k.birinciBileşeni = ö.o.birinciBileşeni -
					ö.u.birinciBileşeni / 2.0F;
				ö.b.birinciBileşeni = ö.o.birinciBileşeni +
					ö.u.birinciBileşeni / 2.0F;
				return;
			}
		case UZUNLUK:
			switch (v2) {
			case KÜÇÜK:
			case BÜYÜK:
			case ORTA:
				DikdörtgenVerisi.yatayıHesapla(v2, v1, ö);
			case UZUNLUK:
				return;
			}
		}
	}
}
