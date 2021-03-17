/**
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 * 0.4 / 17 Oca 2021 / 12:07:23
 *
 * BaşAşağıMotor'dan alındı.
 * 0.24 / 7 Kas 2020 / 11:15:24
 */
package başaşağıderebeyi.kütüphane.matematik.dikdörtgen;

/** Dikdörtgeni tanımlarken kullanılan farklı verilerinin sıralaması. Bu veriler
 * bir nokta ya da bir uzunluk olabilir. Her boyut başına dikdörtgenin iki
 * farklı veriye ihtiyacı var. Kalan veriler bunları kullanarak bulunur. */
public enum DikdörtgenVerisi {
		/** Köşelerden konumu küçük olan. */
		KÜÇÜK_KÖŞESİ,
		/** Köşelerden konumu büyük olan. */
		BÜYÜK_KÖŞESİ,
		/** Orta nokta. */
		ORTA_NOKTASI,
		/** Kenar uzunluğu. */
		UZUNLUKLARI;
		
	/** Bilinen verileri kullanarak, dikdörtgenin diğer verilerini hesaplar. */
	public static void bileşenleriniBul(
		final DikdörtgenVerisi birincisi,
		final DikdörtgenVerisi ikincisi,
		final Dikdörtgen dikdörtgen) {
		final int birleşimleri = verilerinBirleşiminiBul(birincisi, ikincisi);
		yatayBileşenleriniBul(birleşimleri, dikdörtgen);
		dikeyBileşenleriniBul(birleşimleri, dikdörtgen);
	}
	
	/** Bilinen verileri kullanarak, dikdörtgenin yataydaki diğer verilerini
	 * hesaplar. */
	public static void yatayBileşenleriniBul(
		final DikdörtgenVerisi birincisi,
		final DikdörtgenVerisi ikincisi,
		final Dikdörtgen dikdörtgen) {
		yatayBileşenleriniBul(
			verilerinBirleşiminiBul(birincisi, ikincisi),
			dikdörtgen);
	}
	
	/** Bilinen verileri kullanarak, dikdörtgenin dikeydeki diğer verilerini
	 * hesaplar. */
	public static void yatayBileşenleriniBul(
		final int verilerinBirleşimleri,
		final Dikdörtgen dikdörtgen) {
		
		switch (verilerinBirleşimleri) {
		case 1, 4: // KÜÇÜK_KÖŞESİ ve BÜYÜK_KÖŞESİ.
			dikdörtgen.ortaNoktası.birinciBileşeni =
				(dikdörtgen.küçükKöşesi.birinciBileşeni +
					dikdörtgen.büyükKöşesi.birinciBileşeni) / 2.0F;
			dikdörtgen.uzunlukları.birinciBileşeni =
				dikdörtgen.büyükKöşesi.birinciBileşeni -
					dikdörtgen.küçükKöşesi.birinciBileşeni;
			return;
		case 2, 8: // KÜÇÜK_KÖŞESİ ve ORTA_NOKTASI.
			dikdörtgen.büyükKöşesi.birinciBileşeni =
				2.0F * dikdörtgen.ortaNoktası.birinciBileşeni -
					dikdörtgen.küçükKöşesi.birinciBileşeni;
			dikdörtgen.uzunlukları.birinciBileşeni =
				(dikdörtgen.ortaNoktası.birinciBileşeni -
					dikdörtgen.küçükKöşesi.birinciBileşeni) * 2.0F;
			return;
		case 3, 12: // KÜÇÜK_KÖŞESİ ve UZUNLUKLARI.
			dikdörtgen.büyükKöşesi.birinciBileşeni =
				dikdörtgen.küçükKöşesi.birinciBileşeni +
					dikdörtgen.uzunlukları.birinciBileşeni;
			dikdörtgen.ortaNoktası.birinciBileşeni =
				dikdörtgen.küçükKöşesi.birinciBileşeni +
					dikdörtgen.uzunlukları.birinciBileşeni / 2.0F;
			return;
		case 6, 9: // BÜYÜK_KÖŞESİ ve ORTA_NOKTASI.
			dikdörtgen.küçükKöşesi.birinciBileşeni =
				2.0F * dikdörtgen.ortaNoktası.birinciBileşeni -
					dikdörtgen.büyükKöşesi.birinciBileşeni;
			dikdörtgen.uzunlukları.birinciBileşeni =
				(dikdörtgen.büyükKöşesi.birinciBileşeni -
					dikdörtgen.ortaNoktası.birinciBileşeni) * 2.0F;
			return;
		case 7, 13: // BÜYÜK_KÖŞESİ ve UZUNLUKLARI.
			dikdörtgen.küçükKöşesi.birinciBileşeni =
				dikdörtgen.büyükKöşesi.birinciBileşeni -
					dikdörtgen.uzunlukları.birinciBileşeni;
			dikdörtgen.ortaNoktası.birinciBileşeni =
				dikdörtgen.büyükKöşesi.birinciBileşeni -
					dikdörtgen.uzunlukları.birinciBileşeni / 2.0F;
			return;
		case 11, 14: // ORTA_NOKTASI ve UZUNLUKLARI.
			dikdörtgen.küçükKöşesi.birinciBileşeni =
				dikdörtgen.ortaNoktası.birinciBileşeni -
					dikdörtgen.uzunlukları.birinciBileşeni / 2.0F;
			dikdörtgen.büyükKöşesi.birinciBileşeni =
				dikdörtgen.ortaNoktası.birinciBileşeni +
					dikdörtgen.uzunlukları.birinciBileşeni / 2.0F;
			return;
		default: // 0, 5, 10, 15: Aynı iki veri, geçersiz.
			return;
		}
	}
	
	/** Eldeki verileri kullanarak, dikdörtgenin dikeydeki diğer verilerini
	 * bulur. Verilen iki veri ayrı olmalıdır. */
	public static void dikeyBileşenleriniBul(
		final DikdörtgenVerisi birincisi,
		final DikdörtgenVerisi ikincisi,
		final Dikdörtgen dikdörtgen) {
		dikeyBileşenleriniBul(
			verilerinBirleşiminiBul(birincisi, ikincisi),
			dikdörtgen);
	}
	
	/** Eldeki verileri kullanarak, dikdörtgenin dikeydeki diğer verilerini
	 * bulur. */
	public static void dikeyBileşenleriniBul(
		final int verilerinBirleşimleri,
		final Dikdörtgen dikdörtgen) {
		
		switch (verilerinBirleşimleri) {
		case 1, 4: // KÜÇÜK_KÖŞESİ ve BÜYÜK_KÖŞESİ.
			dikdörtgen.ortaNoktası.ikinciBileşeni =
				(dikdörtgen.küçükKöşesi.ikinciBileşeni +
					dikdörtgen.büyükKöşesi.ikinciBileşeni) / 2.0F;
			dikdörtgen.uzunlukları.ikinciBileşeni =
				dikdörtgen.büyükKöşesi.ikinciBileşeni -
					dikdörtgen.küçükKöşesi.ikinciBileşeni;
			return;
		case 2, 8: // KÜÇÜK_KÖŞESİ ve ORTA_NOKTASI.
			dikdörtgen.büyükKöşesi.ikinciBileşeni =
				2.0F * dikdörtgen.ortaNoktası.ikinciBileşeni -
					dikdörtgen.küçükKöşesi.ikinciBileşeni;
			dikdörtgen.uzunlukları.ikinciBileşeni =
				(dikdörtgen.ortaNoktası.ikinciBileşeni -
					dikdörtgen.küçükKöşesi.ikinciBileşeni) * 2.0F;
			return;
		case 3, 12: // KÜÇÜK_KÖŞESİ ve UZUNLUKLARI.
			dikdörtgen.büyükKöşesi.ikinciBileşeni =
				dikdörtgen.küçükKöşesi.ikinciBileşeni +
					dikdörtgen.uzunlukları.ikinciBileşeni;
			dikdörtgen.ortaNoktası.ikinciBileşeni =
				dikdörtgen.küçükKöşesi.ikinciBileşeni +
					dikdörtgen.uzunlukları.ikinciBileşeni / 2.0F;
			return;
		case 6, 9: // BÜYÜK_KÖŞESİ ve ORTA_NOKTASI.
			dikdörtgen.küçükKöşesi.ikinciBileşeni =
				2.0F * dikdörtgen.ortaNoktası.ikinciBileşeni -
					dikdörtgen.büyükKöşesi.ikinciBileşeni;
			dikdörtgen.uzunlukları.ikinciBileşeni =
				(dikdörtgen.büyükKöşesi.ikinciBileşeni -
					dikdörtgen.ortaNoktası.ikinciBileşeni) * 2.0F;
			return;
		case 7, 13: // BÜYÜK_KÖŞESİ ve UZUNLUKLARI.
			dikdörtgen.küçükKöşesi.ikinciBileşeni =
				dikdörtgen.büyükKöşesi.ikinciBileşeni -
					dikdörtgen.uzunlukları.ikinciBileşeni;
			dikdörtgen.ortaNoktası.ikinciBileşeni =
				dikdörtgen.büyükKöşesi.ikinciBileşeni -
					dikdörtgen.uzunlukları.ikinciBileşeni / 2.0F;
			return;
		case 11, 14: // ORTA_NOKTASI ve UZUNLUKLARI.
			dikdörtgen.küçükKöşesi.ikinciBileşeni =
				dikdörtgen.ortaNoktası.ikinciBileşeni -
					dikdörtgen.uzunlukları.ikinciBileşeni / 2.0F;
			dikdörtgen.büyükKöşesi.ikinciBileşeni =
				dikdörtgen.ortaNoktası.ikinciBileşeni +
					dikdörtgen.uzunlukları.ikinciBileşeni / 2.0F;
			return;
		default: // 0, 5, 10, 15: Aynı iki veri, geçersiz.
			return;
		}
	}
	
	/** Eldeki verilerin birleştirmelerinden çıkan özgün bir sayı döndürür. */
	public static int verilerinBirleşiminiBul(
		final DikdörtgenVerisi birincisi,
		final DikdörtgenVerisi ikincisi) {
		/* 0 -> KÜÇÜK_KÖŞESİ ve KÜÇÜK_KÖŞESİ */
		/* 1 -> KÜÇÜK_KÖŞESİ ve BÜYÜK_KÖŞESİ */
		/* 2 -> KÜÇÜK_KÖŞESİ ve ORTA_NOKTASI */
		/* 3 -> KÜÇÜK_KÖŞESİ ve UZUNLUKLARI */
		/* 4 -> BÜYÜK_KÖŞESİ ve KÜÇÜK_KÖŞESİ */
		/* 5 -> BÜYÜK_KÖŞESİ ve BÜYÜK_KÖŞESİ */
		/* 6 -> BÜYÜK_KÖŞESİ ve ORTA_NOKTASI */
		/* 7 -> BÜYÜK_KÖŞESİ ve UZUNLUKLARI */
		/* 8 -> ORTA_NOKTASI ve KÜÇÜK_KÖŞESİ */
		/* 9 -> ORTA_NOKTASI ve BÜYÜK_KÖŞESİ */
		/* 10 -> ORTA_NOKTASI ve ORTA_NOKTASI */
		/* 11 -> ORTA_NOKTASI ve UZUNLUKLARI */
		/* 12 -> UZUNLUKLARI ve KÜÇÜK_KÖŞESİ */
		/* 13 -> UZUNLUKLARI ve BÜYÜK_KÖŞESİ */
		/* 14 -> UZUNLUKLARI ve ORTA_NOKTASI */
		/* 15 -> UZUNLUKLARI ve UZUNLUKLARI */
		return birincisi.ordinal() * 4 + ikincisi.ordinal();
	}
	
	/** Verilen dikdörtgenin yataydaki verisini döndürür. */
	public float yatayBileşeniniEdin(final Dikdörtgen dikdörtgen) {
		return switch (this) {
		case KÜÇÜK_KÖŞESİ -> dikdörtgen.küçükKöşesi.birinciBileşeni;
		case BÜYÜK_KÖŞESİ -> dikdörtgen.büyükKöşesi.birinciBileşeni;
		case ORTA_NOKTASI -> dikdörtgen.ortaNoktası.birinciBileşeni;
		case UZUNLUKLARI -> dikdörtgen.uzunlukları.birinciBileşeni;
		};
	}
	
	/** Verilen dikdörtgenin dikeydeki verisini döndürür. */
	public float dikeyBileşeniniEdin(final Dikdörtgen dikdörtgen) {
		return switch (this) {
		case KÜÇÜK_KÖŞESİ -> dikdörtgen.küçükKöşesi.ikinciBileşeni;
		case BÜYÜK_KÖŞESİ -> dikdörtgen.büyükKöşesi.ikinciBileşeni;
		case ORTA_NOKTASI -> dikdörtgen.ortaNoktası.ikinciBileşeni;
		case UZUNLUKLARI -> dikdörtgen.uzunlukları.ikinciBileşeni;
		};
	}
	
	/** Verilen dikdörtgenin yataydaki verisini değiştirir. */
	public void yatayBileşeniniDeğiştir(
		final Dikdörtgen dikdörtgen,
		final float değer) {
		switch (this) {
		case KÜÇÜK_KÖŞESİ -> dikdörtgen.küçükKöşesi
			.birinciBileşeniniDeğiştir(değer);
		case BÜYÜK_KÖŞESİ -> dikdörtgen.büyükKöşesi
			.birinciBileşeniniDeğiştir(değer);
		case ORTA_NOKTASI -> dikdörtgen.ortaNoktası
			.birinciBileşeniniDeğiştir(değer);
		case UZUNLUKLARI -> dikdörtgen.uzunlukları
			.birinciBileşeniniDeğiştir(değer);
		}
	}
	
	/** Verilen dikdörtgenin dikeydeki verisini değiştirir. */
	public void dikeyBileşeniniDeğiştir(
		final Dikdörtgen dikdörtgen,
		final float değer) {
		switch (this) {
		case KÜÇÜK_KÖŞESİ -> dikdörtgen.küçükKöşesi
			.ikinciBileşeniniDeğiştir(değer);
		case BÜYÜK_KÖŞESİ -> dikdörtgen.büyükKöşesi
			.ikinciBileşeniniDeğiştir(değer);
		case ORTA_NOKTASI -> dikdörtgen.ortaNoktası
			.ikinciBileşeniniDeğiştir(değer);
		case UZUNLUKLARI -> dikdörtgen.uzunlukları
			.ikinciBileşeniniDeğiştir(değer);
		}
	}
}
