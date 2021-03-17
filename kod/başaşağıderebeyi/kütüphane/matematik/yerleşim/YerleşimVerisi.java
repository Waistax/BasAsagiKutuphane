/**
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 * 0.4 / 17 Oca 2021 / 13:55:22
 */
package başaşağıderebeyi.kütüphane.matematik.yerleşim;

import başaşağıderebeyi.kütüphane.matematik.dikdörtgen.*;

/** Bir kuralın yerleştirdiği farklı verilerin sıralaması. */
public enum YerleşimVerisi {
		/** Köşelerden konumu küçük olanın birinci bileşeni. */
		KÜÇÜK_KÖŞESİNİN_YATAYI,
		/** Köşelerden konumu büyük olanın birinci bileşeni. */
		BÜYÜK_KÖŞESİNİN_YATAYI,
		/** Orta noktanın birinci bileşeni. */
		ORTA_NOKTASININ_YATAYI,
		/** Genişliği. */
		GENİŞLİĞİ,
		/** Köşelerden konumu küçük olanın ikinci bileşeni. */
		KÜÇÜK_KÖŞESİNİN_DİKEYİ,
		/** Köşelerden konumu büyük olanın ikinci bileşeni. */
		BÜYÜK_KÖŞESİNİN_DİKEYİ,
		/** Orta noktanın birinci ikinci. */
		ORTA_NOKTASININ_DİKEYİ,
		/** Yüksekliği. */
		YÜKSEKLİĞİ;
		
	/** Verilen dikdörtgen verisi ve boyut birleşimini döndürür. */
	public static YerleşimVerisi yerleşimVerisiEdin(
		final DikdörtgenVerisi dikdörtgenVerisi,
		final boolean yatayOlması) {
		return yerleşimVerisiEdin(dikdörtgenVerisi.ordinal(), yatayOlması);
	}
	
	/** Verilen dikdörtgen verisi ve boyut birleşimini döndürür. */
	public static YerleşimVerisi yerleşimVerisiEdin(
		final int dikdörtgenVerisiSırası,
		final boolean yatayOlması) {
		return values()[dikdörtgenVerisiSırası + (yatayOlması ? 0 : 4)];
	}
	
	/** Diğer boyuttaki aynı veriyi döndürür. */
	public YerleşimVerisi diğerBoyuttakiniEdin() {
		return yerleşimVerisiEdin(ordinal() % 4, ordinal() < 4);
	}
	
	/** Diğer boyuttaki farklı bir veriyi döndürür. */
	public YerleşimVerisi diğerBoyuttakiniEdin(
		final DikdörtgenVerisi dikdörtgenVerisi) {
		return yerleşimVerisiEdin(dikdörtgenVerisi, ordinal() > 4);
	}
	
	/** Aynı boyuttaki farklı bir veriyi döndürür. */
	public YerleşimVerisi aynıBoyuttakiniEdin(
		final DikdörtgenVerisi dikdörtgenVerisi) {
		return yerleşimVerisiEdin(dikdörtgenVerisi, ordinal() < 4);
	}
	
	/** Yerleştirdiği verinin değerini döndürür. */
	public float değeriEdin(final Dikdörtgen dikdörtgen) {
		final DikdörtgenVerisi verisi =
			DikdörtgenVerisi.values()[ordinal() % 4];
		return ordinal() < 4 ?
			verisi.yatayBileşeniniEdin(dikdörtgen) :
			verisi.dikeyBileşeniniEdin(dikdörtgen);
	}
	
	/** Yerleştirdiği verinin değerini değiştirir. */
	public YerleşimVerisi değeriDeğiştir(
		final Dikdörtgen dikdörtgen,
		final float değer) {
		final DikdörtgenVerisi verisi =
			DikdörtgenVerisi.values()[ordinal() % 4];
		if (ordinal() < 4)
			verisi.yatayBileşeniniDeğiştir(dikdörtgen, değer);
		else
			verisi.dikeyBileşeniniDeğiştir(dikdörtgen, değer);
		return this;
	}
}
