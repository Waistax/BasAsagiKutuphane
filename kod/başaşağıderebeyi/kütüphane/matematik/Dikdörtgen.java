/**
 * başaşağıderebeyi.kütüphane.matematik.Dikdörtgen.java
 * 0.4 / 17 Oca 2021 / 12:08:18
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 *
 * BaşAşağıMotor'dan alındı.
 * 0.13 / 8 Eyl 2020 / 09:37:00
 */
package başaşağıderebeyi.kütüphane.matematik;

/** İki boyutlu bir dikdörtgen. Bileşenler ondalıklı sayılar olarak saklanır. */
public class Dikdörtgen {
	/** Konumunun değerleri küçük olan köşesi. */
	public final Yöney2 küçükKöşesi;
	/** Konumunun değerleri büyük olan köşesi. */
	public final Yöney2 büyükKöşesi;
	/** Orta noktası. */
	public final Yöney2 ortaNoktası;
	/** Kenarlarının uzunluklarını içeren yöney. */
	public final Yöney2 uzunlukları;
	
	/** Sıfır dikdörtgeni tanımlar. */
	public Dikdörtgen() {
		küçükKöşesi = new Yöney2();
		büyükKöşesi = new Yöney2();
		ortaNoktası = new Yöney2();
		uzunlukları = new Yöney2();
	}
	
	@Override
	public boolean equals(final Object öbürü) {
		if (öbürü instanceof Dikdörtgen öbürDikdörtgen)
			return eşitOlmalarınıBul(öbürDikdörtgen);
		return false;
	}
	
	/** Verilen dikdörtgenin bu dikdörtgene eşit olup olmadığını döndürür. */
	public boolean eşitOlmalarınıBul(final Dikdörtgen öbürü) {
		return küçükKöşesi.eşitOlmalarınıBul(öbürü.küçükKöşesi) &&
			büyükKöşesi.eşitOlmalarınıBul(öbürü.büyükKöşesi) &&
			ortaNoktası.eşitOlmalarınıBul(öbürü.ortaNoktası) &&
			uzunlukları.eşitOlmalarınıBul(öbürü.uzunlukları);
	}
	
	/** Verilen yöneyin dikdörtgenin içinde olup olmadığını döndürür. */
	public boolean içindeOlmasınıBul(final Yöney2 yöney) {
		return küçükKöşesi.birinciBileşeni <= yöney.birinciBileşeni &&
			küçükKöşesi.ikinciBileşeni <= yöney.ikinciBileşeni &&
			büyükKöşesi.birinciBileşeni >= yöney.birinciBileşeni &&
			büyükKöşesi.ikinciBileşeni >= yöney.ikinciBileşeni;
	}
	
	/** Dikdörtgenin verilerini ayrı ayrı yuvarlar. Dikdörtgeni döndürür. */
	public Dikdörtgen yuvarla() {
		return yuvarla(this);
	}
	
	/** Bu dikdörtgeni verilen dikdörtgenin yuvarlanmışına değiştirir. Bu
	 * dikdörtgeni döndürür. */
	public Dikdörtgen yuvarla(final Dikdörtgen öbürü) {
		küçükKöşesi.yuvarla(öbürü.küçükKöşesi);
		büyükKöşesi.yuvarla(öbürü.büyükKöşesi);
		ortaNoktası.yuvarla(öbürü.ortaNoktası);
		uzunlukları.yuvarla(öbürü.uzunlukları);
		return this;
	}
	
	/** Dikdörtgenin verilerini ayrı ayrı aşağı yuvarlar. Dikdörtgeni
	 * döndürür. */
	public Dikdörtgen aşağıYuvarla() {
		return aşağıYuvarla(this);
	}
	
	/** Bu dikdörtgeni verilen dikdörtgenin aşağı yuvarlanmışına değiştirir. Bu
	 * dikdörtgeni döndürür. */
	public Dikdörtgen aşağıYuvarla(final Dikdörtgen öbürü) {
		küçükKöşesi.aşağıYuvarla(öbürü.küçükKöşesi);
		büyükKöşesi.aşağıYuvarla(öbürü.büyükKöşesi);
		ortaNoktası.aşağıYuvarla(öbürü.ortaNoktası);
		uzunlukları.aşağıYuvarla(öbürü.uzunlukları);
		return this;
	}
	
	/** Dikdörtgenin verilerini ayrı ayrı yukarı yuvarlar. Dikdörtgeni
	 * döndürür. */
	public Dikdörtgen yukarıYuvarla() {
		return yukarıYuvarla(this);
	}
	
	/** Bu dikdörtgeni verilen dikdörtgenin yukarı yuvarlanmışına değiştirir. Bu
	 * dikdörtgeni döndürür. */
	public Dikdörtgen yukarıYuvarla(final Dikdörtgen öbürü) {
		küçükKöşesi.yukarıYuvarla(öbürü.küçükKöşesi);
		büyükKöşesi.yukarıYuvarla(öbürü.büyükKöşesi);
		ortaNoktası.yukarıYuvarla(öbürü.ortaNoktası);
		uzunlukları.yukarıYuvarla(öbürü.uzunlukları);
		return this;
	}
	
	/** Bu dikdörtgeni verilen sondaki dikdörtgen olmak üzere, baştaki ve
	 * sondaki dikdörtgenlerin verilen uzaklığa göre aradeğerlerine değiştirir.
	 * Bu dikdörtgeni döndürür. */
	public Dikdörtgen aradeğerleriniBul(
		final Dikdörtgen öbürü,
		final float uzaklık) {
		return aradeğerleriniBul(this, öbürü, uzaklık);
	}
	
	/** Bu dikdörtgeni baştaki ve sondaki dikdörtgenlerin verilen uzaklığa göre
	 * aradeğerlerine değiştirir. Bu dikdörtgeni döndürür. */
	public Dikdörtgen aradeğerleriniBul(
		final Dikdörtgen baştaki,
		final Dikdörtgen sondaki,
		final float uzaklık) {
		küçükKöşesi
			.aradeğerleriniBul(
				baştaki.küçükKöşesi,
				sondaki.küçükKöşesi,
				uzaklık);
		büyükKöşesi
			.aradeğerleriniBul(
				baştaki.büyükKöşesi,
				sondaki.büyükKöşesi,
				uzaklık);
		ortaNoktası
			.aradeğerleriniBul(
				baştaki.ortaNoktası,
				sondaki.ortaNoktası,
				uzaklık);
		uzunlukları
			.aradeğerleriniBul(
				baştaki.uzunlukları,
				sondaki.uzunlukları,
				uzaklık);
		return this;
	}
	
	@Override
	public String toString() {
		return dizeyeÇevir();
	}
	
	/** Dikdörtgeni dize olarak döndürür. */
	public String dizeyeÇevir() {
		return dizeOluşturucusunaEkle(new StringBuilder()).toString();
	}
	
	/** Dikdörtgeni verilen dize oluşturucusuna ekler. Oluşturucuyu döndürür. */
	public StringBuilder dizeOluşturucusunaEkle(
		final StringBuilder dizeOluşturucusu) {
		return dizeOluşturucusu
			.append('[')
			.append(küçükKöşesi)
			.append(", ")
			.append(büyükKöşesi)
			.append(", ")
			.append(ortaNoktası)
			.append(", ")
			.append(uzunlukları)
			.append(']');
	}
	
	/** Bu dikdörtgeni verilen dikdörtgene değiştirir. Bu dikdörtgeni
	 * döndürür. */
	public Dikdörtgen değiştir(final Dikdörtgen öbürü) {
		return küçükKöşesiniDeğiştir(öbürü.küçükKöşesi)
			.büyükKöşesiniDeğiştir(öbürü.büyükKöşesi)
			.ortaNoktasınıDeğiştir(öbürü.ortaNoktası)
			.uzunluklarınıDeğiştir(öbürü.uzunlukları);
	}
	
	/** Küçük olan köşeyi değiştirir. Dikdörtgeni döndürür. */
	public Dikdörtgen küçükKöşesiniDeğiştir(final Yöney2 küçükKöşe) {
		küçükKöşesi.değiştir(küçükKöşe);
		return this;
	}
	
	/** Küçük olan köşeyi değiştirir. Dikdörtgeni döndürür. */
	public Dikdörtgen küçükKöşesiniDeğiştir(
		final float birinciBileşen,
		final float ikinciBileşen) {
		küçükKöşesi.bileşenleriniDeğiştir(birinciBileşen, ikinciBileşen);
		return this;
	}
	
	/** Büyük olan köşeyi değiştirir. Dikdörtgeni döndürür. */
	public Dikdörtgen büyükKöşesiniDeğiştir(final Yöney2 büyükKöşe) {
		büyükKöşesi.değiştir(büyükKöşe);
		return this;
	}
	
	/** Büyük olan köşeyi değiştirir. Dikdörtgeni döndürür. */
	public Dikdörtgen büyükKöşesiniDeğiştir(
		final float birinciBileşen,
		final float ikinciBileşen) {
		büyükKöşesi.bileşenleriniDeğiştir(birinciBileşen, ikinciBileşen);
		return this;
	}
	
	/** Orta noktayı değiştirir. Dikdörtgeni döndürür. */
	public Dikdörtgen ortaNoktasınıDeğiştir(final Yöney2 ortaNokta) {
		ortaNoktası.değiştir(ortaNokta);
		return this;
	}
	
	/** Orta noktayı değiştirir. Dikdörtgeni döndürür. */
	public Dikdörtgen ortaNoktasınıDeğiştir(
		final float birinciBileşen,
		final float ikinciBileşen) {
		ortaNoktası.bileşenleriniDeğiştir(birinciBileşen, ikinciBileşen);
		return this;
	}
	
	/** Uzunluğu değiştirir. Dikdörtgeni döndürür. */
	public Dikdörtgen uzunluklarınıDeğiştir(final Yöney2 uzunluklar) {
		uzunlukları.değiştir(uzunluklar);
		return this;
	}
	
	/** Uzunluğu değiştirir. Dikdörtgeni döndürür. */
	public Dikdörtgen uzunluklarınıDeğiştir(
		final float birinciBileşen,
		final float ikinciBileşen) {
		uzunlukları.bileşenleriniDeğiştir(birinciBileşen, ikinciBileşen);
		return this;
	}
}
