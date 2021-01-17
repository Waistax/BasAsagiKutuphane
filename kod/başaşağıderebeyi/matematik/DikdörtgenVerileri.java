/**
 * başaşağıderebeyi.matematik.DikdörtgenVerileri.java
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
 * Kalan veriler bunları kullanarak hesaplanabilir.
 * Veriler şöyledir:
 * KÜÇÜK, köşelerden konumu küçük olan,
 * BÜYÜK, köşelerden konumu büyük olan,
 * ORTA, orta nokta,
 * UZUNLUK, uzunluk. */
public enum DikdörtgenVerileri {
	/** KÜÇÜK, BÜYÜK, ORTA ve UZUNLUK verilerinin birleştirmeleri: */
	KÜÇÜK_BÜYÜK,
	KÜÇÜK_ORTA,
	KÜÇÜK_UZUNLUK,
	BÜYÜK_ORTA,
	BÜYÜK_UZUNLUK,
	ORTA_UZUNLUK;
	
	/** Bu verileri kullanarak, dikdörtgenin yataydaki diğer verilerini hesaplar. */
	public void yatayıHesapla(Dikdörtgen ö) {
		switch(this) {
		case KÜÇÜK_BÜYÜK:
			ö.o.x = (ö.k.x + ö.b.x) / 2.0F;
			ö.u.x = ö.b.x - ö.k.x;
			break;
		case KÜÇÜK_ORTA:
			ö.b.x = 2.0F * ö.o.x - ö.k.x;
			ö.u.x = (ö.o.x - ö.k.x) * 2.0F;
			break;
		case KÜÇÜK_UZUNLUK:
			ö.b.x = ö.k.x + ö.u.x;
			ö.o.x = ö.k.x + ö.u.x / 2.0F;
			break;
		case BÜYÜK_ORTA:
			ö.k.x = 2.0F * ö.o.x - ö.b.x;
			ö.u.x = (ö.b.x - ö.o.x) * 2.0F;
			break;
		case BÜYÜK_UZUNLUK:
			ö.k.x = ö.b.x - ö.u.x;
			ö.o.x = ö.b.x - ö.u.x / 2.0F;
			break;
		case ORTA_UZUNLUK:
			ö.k.x = ö.o.x - ö.u.x / 2.0F;
			ö.b.x = ö.o.x + ö.u.x / 2.0F;
			break;
		}
	}
	
	/** Bu verileri kullanarak, dikdörtgenin dikeydeki diğer verilerini hesaplar. */
	public void dikeyiHesapla(Dikdörtgen ö) {
		switch(this) {
		case KÜÇÜK_BÜYÜK:
			ö.o.y = (ö.k.y + ö.b.y) / 2.0F;
			ö.u.y = ö.b.y - ö.k.y;
			break;
		case KÜÇÜK_ORTA:
			ö.b.y = 2.0F * ö.o.y - ö.k.y;
			ö.u.y = (ö.o.y - ö.k.y) * 2.0F;
			break;
		case KÜÇÜK_UZUNLUK:
			ö.b.y = ö.k.y + ö.u.y;
			ö.o.y = ö.k.y + ö.u.y / 2.0F;
			break;
		case BÜYÜK_ORTA:
			ö.k.y = 2.0F * ö.o.y - ö.b.y;
			ö.u.y = (ö.b.y - ö.o.y) * 2.0F;
			break;
		case BÜYÜK_UZUNLUK:
			ö.k.y = ö.b.y - ö.u.y;
			ö.o.y = ö.b.y - ö.u.y / 2.0F;
			break;
		case ORTA_UZUNLUK:
			ö.k.y = ö.o.y - ö.u.y / 2.0F;
			ö.b.y = ö.o.y + ö.u.y / 2.0F;
			break;
		}
	}
}
