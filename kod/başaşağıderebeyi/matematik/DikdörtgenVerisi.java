/**
 * başaşağıderebeyi.matematik.DikdörtgenVerisi.java
 * 0.4 / 17 Oca 2021 / 12:07:23
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 * 
 * BaşAşağıMotor'dan alındı.
 * 0.24 / 7 Kas 2020 / 11:15:24
 */
package başaşağıderebeyi.matematik;

/** Dikdörtgeni tanımlarken kullanılan farklı verilerinin sıralamasıdır.
 * Bu veriler bir nokta ya da bir uzunluk olabilir.
 * Her boyut başına dikdörtgenin iki farklı veriye ihtiyacı vardır.
 * Kalan veriler bunları kullanarak hesaplanabilir. */
public enum DikdörtgenVerisi {
	/** Köşelerden konumu küçük olandır. */
	KÜÇÜK,
	/** Köşelerden konumu büyük olandır. */
	BÜYÜK,
	/** Orta noktadır. */
	ORTA,
	/** Kenar uzunluğudur. */
	UZUNLUK;
	
	/** Bilinen verileri kullanarak, dikdörtgenin yataydaki diğer verilerini hesaplar. */
	public static void yatayıHesapla(DikdörtgenVerisi v1, DikdörtgenVerisi v2, Dikdörtgen ö) {
		switch (v1) {
		case KÜÇÜK:
			switch (v2) {
			case KÜÇÜK:
				return;
			case BÜYÜK:
				ö.o.x = (ö.k.x + ö.b.x) / 2.0F;
				ö.u.x = ö.b.x - ö.k.x;
				return;
			case ORTA:
				ö.b.x = 2.0F * ö.o.x - ö.k.x;
				ö.u.x = (ö.o.x - ö.k.x) * 2.0F;
				return;
			case UZUNLUK:
				ö.b.x = ö.k.x + ö.u.x;
				ö.o.x = ö.k.x + ö.u.x / 2.0F;
				return;
			}
		case BÜYÜK:
			switch (v2) {
			case KÜÇÜK:
				yatayıHesapla(v2, v1, ö);
			case BÜYÜK:
				return;
			case ORTA:
				ö.k.x = 2.0F * ö.o.x - ö.b.x;
				ö.u.x = (ö.b.x - ö.o.x) * 2.0F;
				return;
			case UZUNLUK:
				ö.k.x = ö.b.x - ö.u.x;
				ö.o.x = ö.b.x - ö.u.x / 2.0F;
				return;
			}
		case ORTA:
			switch (v2) {
			case KÜÇÜK:
			case BÜYÜK:
				yatayıHesapla(v2, v1, ö);
			case ORTA:
				return;
			case UZUNLUK:
				ö.k.x = ö.o.x - ö.u.x / 2.0F;
				ö.b.x = ö.o.x + ö.u.x / 2.0F;
				return;
			}
		case UZUNLUK:
			switch (v2) {
			case KÜÇÜK:
			case BÜYÜK:
			case ORTA:
				yatayıHesapla(v2, v1, ö);
			case UZUNLUK:
				return;
			}
		}
	}
	
	/** Bilinen verileri kullanarak, dikdörtgenin dikeydeki diğer verilerini hesaplar. */
	public static void dikeyiHesapla(DikdörtgenVerisi v1, DikdörtgenVerisi v2, Dikdörtgen ö) {
		switch (v1) {
		case KÜÇÜK:
			switch (v2) {
			case KÜÇÜK:
				return;
			case BÜYÜK:
				ö.o.y = (ö.k.y + ö.b.y) / 2.0F;
				ö.u.y = ö.b.y - ö.k.y;
				return;
			case ORTA:
				ö.b.y = 2.0F * ö.o.y - ö.k.y;
				ö.u.y = (ö.o.y - ö.k.y) * 2.0F;
				return;
			case UZUNLUK:
				ö.b.y = ö.k.y + ö.u.y;
				ö.o.y = ö.k.y + ö.u.y / 2.0F;
				return;
			}
		case BÜYÜK:
			switch (v2) {
			case KÜÇÜK:
				dikeyiHesapla(v2, v1, ö);
			case BÜYÜK:
				return;
			case ORTA:
				ö.k.y = 2.0F * ö.o.y - ö.b.y;
				ö.u.y = (ö.b.y - ö.o.y) * 2.0F;
				return;
			case UZUNLUK:
				ö.k.y = ö.b.y - ö.u.y;
				ö.o.y = ö.b.y - ö.u.y / 2.0F;
				return;
			}
		case ORTA:
			switch (v2) {
			case KÜÇÜK:
			case BÜYÜK:
				dikeyiHesapla(v2, v1, ö);
			case ORTA:
				return;
			case UZUNLUK:
				ö.k.y = ö.o.y - ö.u.y / 2.0F;
				ö.b.y = ö.o.y + ö.u.y / 2.0F;
				return;
			}
		case UZUNLUK:
			switch (v2) {
			case KÜÇÜK:
			case BÜYÜK:
			case ORTA:
				dikeyiHesapla(v2, v1, ö);
			case UZUNLUK:
				return;
			}
		}
	}
}
