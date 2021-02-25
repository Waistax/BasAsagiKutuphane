/**
 * başaşağıderebeyi.kütüphane.matematik.Yöney2.java
 * 0.2 / 16 Oca 2021 / 13:07:13
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 *
 * BaşAşağıMotor'dan alındı.
 * 0.13 / 8 Eyl 2020 / 09:16:17
 */
package başaşağıderebeyi.kütüphane.matematik;

/** İki boyutlu bir yöney. Bileşenler ondalık sayılar olarak saklanır. */
public class Yöney2 {
	/** Uzunluğu ve bileşenleri sıfır olan yöney. */
	public static final Yöney2 SIFIR = new Yöney2();
	/** X eksenini temsil eden yöney. */
	public static final Yöney2 BİRİNCİ_EKSEN = new Yöney2(1.0F, 0.0F);
	/** Y eksenini temsil eden yöney. */
	public static final Yöney2 İKİNCİ_EKSEN = new Yöney2(0.0F, 1.0F);
	/** Her eksende bir uzunluğunda olan yöney. */
	public static final Yöney2 BİR = new Yöney2()
		.topla(BİRİNCİ_EKSEN)
		.topla(İKİNCİ_EKSEN);
	
	/** Yöneyin birinci bileşeni. */
	public float birinciBileşeni;
	/** Yöneyin ikinci bileşeni. */
	public float ikinciBileşeni;
	
	/** Sıfır yöneyi tanımlar. */
	public Yöney2() {
	}
	
	/** Verilen bileşenlerle tanımlar. */
	public Yöney2(final float birinciBileşen, final float ikinciBileşen) {
		bileşenleriDeğiştir(birinciBileşen, ikinciBileşen);
	}
	
	/** Verilen yöneyle aynı tanımlar. */
	public Yöney2(final Yöney2 öbürYöney) {
		değiştir(öbürYöney);
	}
	
	/** Verilen yöneyle bu yöneyin denk sayılıp sayılmadığını döndürür. */
	public boolean denkSayılmalarınıBul(final Yöney2 öbürYöney) {
		return MatematikAracı
			.denkSayılmalarınıBul(
				uzunluğununKaresiniBul(),
				öbürYöney.uzunluğununKaresiniBul());
	}
	
	@Override
	public boolean equals(final Object öbürü) {
		if (öbürü instanceof Yöney2 öbürYöney)
			return eşitOlmalarınıBul(öbürYöney);
		return false;
	}
	
	/** Verilen yöneyin bu yöneye eşit olup olmadığını döndürür. */
	public boolean eşitOlmalarınıBul(final Yöney2 öbürYöney) {
		return eşitOlmalarınıBul(
			öbürYöney.birinciBileşeni,
			öbürYöney.ikinciBileşeni);
	}
	
	/** Verilen bileşenlerin yöneyinkilere eşit olup olmadığını döndürür. */
	public boolean eşitOlmalarınıBul(
		final float birinciBileşen,
		final float ikinciBileşen) {
		return birinciBileşeni == birinciBileşen &&
			ikinciBileşeni == ikinciBileşen;
	}
	
	/** Yöneyin doğrultusunu (birim yöneyini) bulup, yöneyi ona değiştirir.
	 * Yöneyi döndürür. */
	public Yöney2 doğrultusunuBul() {
		return doğrultusunuBul(this);
	}
	
	/** Verilen yöneyin doğrultusunu (birim yöneyini) bulup, bu yöneyi ona
	 * değiştirir. Bu yöneyi döndürür. */
	public Yöney2 doğrultusunuBul(final Yöney2 öbürYöney) {
		return böl(öbürYöney, öbürYöney.uzunluğunuBul());
	}
	
	/** Bu yöneye verilen yöneyi ekler. Bu yöneyi döndürür. */
	public Yöney2 topla(final Yöney2 öbürYöney) {
		return topla(this, öbürYöney);
	}
	
	/** Bu yöneyi verilen yöneylerin toplamına değiştirir. Bu yöneyi
	 * döndürür. */
	public Yöney2 topla(final Yöney2 soldakiYöney, final Yöney2 sağdakiYöney) {
		return bileşenleriDeğiştir(
			soldakiYöney.birinciBileşeni + sağdakiYöney.birinciBileşeni,
			soldakiYöney.ikinciBileşeni + sağdakiYöney.ikinciBileşeni);
	}
	
	/** Bu yöneyden verilen yöneyi çıkarır. Bu yöneyi döndürür. */
	public Yöney2 çıkar(final Yöney2 öbürYöney) {
		return çıkar(this, öbürYöney);
	}
	
	/** Bu yöneyi verilen yöneylerin farkına değiştirir. Bu yöneyi döndürür. */
	public Yöney2 çıkar(final Yöney2 soldakiYöney, final Yöney2 sağdakiYöney) {
		return bileşenleriDeğiştir(
			soldakiYöney.birinciBileşeni - sağdakiYöney.birinciBileşeni,
			soldakiYöney.ikinciBileşeni - sağdakiYöney.ikinciBileşeni);
	}
	
	/** Yöneyi verilen sayıyla çarpar. Yöneyi döndürür. */
	public Yöney2 çarp(final float sayı) {
		return çarp(this, sayı);
	}
	
	/** Bu yöneyi verilen yöneyin verilen sayıyla çarpımına değiştirir. Bu
	 * yöneyi döndürür. */
	public Yöney2 çarp(final Yöney2 öbürYöney, final float sayı) {
		return bileşenleriDeğiştir(
			öbürYöney.birinciBileşeni * sayı,
			öbürYöney.ikinciBileşeni * sayı);
	}
	
	/** Yöneyi verilen sayıya böler. Yöneyi döndürür. */
	public Yöney2 böl(final float sayı) {
		return böl(this, sayı);
	}
	
	/** Bu yöneyi verilen yöneyin verilen sayıya bölümüne değiştirir. Bu yöneyi
	 * döndürür. */
	public Yöney2 böl(final Yöney2 öbürYöney, final float sayı) {
		return bileşenleriDeğiştir(
			öbürYöney.birinciBileşeni / sayı,
			öbürYöney.ikinciBileşeni / sayı);
	}
	
	/** Bu yöneyin bileşenlerini ayrı ayrı sıkıştırır. Bu yöneyi döndürür. */
	public Yöney2 sıkıştır(final Yöney2 tabanYöney, final Yöney2 tavanYöney) {
		return sıkıştır(this, tabanYöney, tavanYöney);
	}
	
	/** Bu yöneyi verilen yöneyin sıkıştırılmışına değiştirir. Bu yöneyi
	 * döndürür. */
	public Yöney2 sıkıştır(
		final Yöney2 öbürYöney,
		final Yöney2 tabanYöney,
		final Yöney2 tavanYöney) {
		return bileşenleriDeğiştir(
			MatematikAracı
				.sıkıştır(
					öbürYöney.birinciBileşeni,
					tabanYöney.birinciBileşeni,
					tavanYöney.birinciBileşeni),
			MatematikAracı
				.sıkıştır(
					öbürYöney.ikinciBileşeni,
					tabanYöney.ikinciBileşeni,
					tavanYöney.ikinciBileşeni));
	}
	
	/** Bu yöneyin bileşenleri ile verilen yöneyin karşılık gelen bileşenlerini
	 * karşılaştırır. Bu yöneyin bileşenlerini içlerinden küçük olana
	 * değiştirir. Bu yöneyi döndürür. */
	public Yöney2 küçüğüBul(final Yöney2 öbürYöney) {
		return küçüğüBul(this, öbürYöney);
	}
	
	/** Verilen yöneylerin karşılık gelen bileşenlerini karşılaştırır. Bu
	 * yöneyin bileşenlerini içlerinden küçük olana değiştirir. Bu yöneyi
	 * döndürür. */
	public Yöney2
		küçüğüBul(final Yöney2 soldakiYöney, final Yöney2 sağdakiYöney) {
		return bileşenleriDeğiştir(
			MatematikAracı
				.küçüğüBul(
					soldakiYöney.birinciBileşeni,
					sağdakiYöney.birinciBileşeni),
			MatematikAracı
				.küçüğüBul(
					soldakiYöney.ikinciBileşeni,
					sağdakiYöney.ikinciBileşeni));
	}
	
	/** Bu yöneyin bileşenleri ile verilen yöneyin karşılık gelen bileşenlerini
	 * karşılaştırır. Bu yöneyin bileşenlerini içlerinden büyük olana
	 * değiştirir. Bu yöneyi döndürür. */
	public Yöney2 büyüğüBul(final Yöney2 öbürYöney) {
		return büyüğüBul(this, öbürYöney);
	}
	
	/** Verilen yöneylerin karşılık gelen bileşenlerini karşılaştırır. Bu
	 * yöneyin bileşenlerini içlerinden büyük olana değiştirir. Bu yöneyi
	 * döndürür. */
	public Yöney2
		büyüğüBul(final Yöney2 soldakiYöney, final Yöney2 sağdakiYöney) {
		return bileşenleriDeğiştir(
			MatematikAracı
				.büyüğüBul(
					soldakiYöney.birinciBileşeni,
					sağdakiYöney.birinciBileşeni),
			MatematikAracı
				.büyüğüBul(
					soldakiYöney.ikinciBileşeni,
					sağdakiYöney.ikinciBileşeni));
	}
	
	/** Yöneyin bileşenlerini ayrı ayrı yuvarlar. Yöneyi döndürür. */
	public Yöney2 yuvarla() {
		return yuvarla(this);
	}
	
	/** Bu yöneyi verilen yöneyin yuvarlanmışına değiştirir. Bu yöneyi
	 * döndürür. */
	public Yöney2 yuvarla(final Yöney2 öbürYöney) {
		return bileşenleriDeğiştir(
			MatematikAracı.yuvarla(öbürYöney.birinciBileşeni),
			MatematikAracı.yuvarla(öbürYöney.ikinciBileşeni));
	}
	
	/** Yöneyin bileşenlerini ayrı ayrı aşağı yuvarlar. Yöneyi döndürür. */
	public Yöney2 aşağıYuvarla() {
		return aşağıYuvarla(this);
	}
	
	/** Bu yöneyi verilen yöneyin aşağı yuvarlanmışına değiştirir. Bu yöneyi
	 * döndürür. */
	public Yöney2 aşağıYuvarla(final Yöney2 öbürYöney) {
		return bileşenleriDeğiştir(
			MatematikAracı.aşağıYuvarla(öbürYöney.birinciBileşeni),
			MatematikAracı.aşağıYuvarla(öbürYöney.birinciBileşeni));
	}
	
	/** Yöneyin bileşenlerini ayrı ayrı yukarı yuvarlar. Yöneyi döndürür. */
	public Yöney2 yukarıYuvarla() {
		return yukarıYuvarla(this);
	}
	
	/** Bu yöneyi verilen yöneyin yukarı yuvarlanmışına değiştirir. Bu yöneyi
	 * döndürür. */
	public Yöney2 yukarıYuvarla(final Yöney2 öbürYöney) {
		return bileşenleriDeğiştir(
			MatematikAracı.yukarıYuvarla(öbürYöney.birinciBileşeni),
			MatematikAracı.yukarıYuvarla(öbürYöney.birinciBileşeni));
	}
	
	/** Bu yöneyi verilen yöneyle bu yöneyin verilen mesafelere göre aradeğerine
	 * değiştirir. Bu yöneyi döndürür. Mesafelerin toplamının bir olduğunu
	 * varsayar. */
	public Yöney2 aradeğerleriniBul(
		final Yöney2 öbürYöney,
		final float uzaklık,
		final float yakınlık) {
		return aradeğerleriniBul(this, öbürYöney, uzaklık, yakınlık);
	}
	
	/** Bu yöneyi verilen yöneylerin verilen mesafelere göre aradeğerine
	 * değiştirir. Bu yöneyi döndürür. Mesafelerin toplamının bir olduğunu
	 * varsayar. */
	public Yöney2 aradeğerleriniBul(
		final Yöney2 soldakiYöney,
		final Yöney2 sağdakiYöney,
		final float soldakineOlanUzaklık,
		final float sağdakineOlanUzaklık) {
		return bileşenleriDeğiştir(
			MatematikAracı
				.aradeğerleriniBul(
					soldakiYöney.birinciBileşeni,
					sağdakiYöney.birinciBileşeni,
					soldakineOlanUzaklık,
					sağdakineOlanUzaklık),
			MatematikAracı
				.aradeğerleriniBul(
					soldakiYöney.ikinciBileşeni,
					sağdakiYöney.ikinciBileşeni,
					soldakineOlanUzaklık,
					sağdakineOlanUzaklık));
	}
	
	/** Yöneyin uzunluğunu döndürür. */
	public float uzunluğunuBul() {
		return MatematikAracı.kökünüBul(uzunluğununKaresiniBul());
	}
	
	/** Yöneyin uzunluğunun karesini döndürür. */
	public float uzunluğununKaresiniBul() {
		return noktaÇarp(this);
	}
	
	/** Verilen yöneyle bu yöneyin nokta çarpımını döndürür. */
	public float noktaÇarp(final Yöney2 öbürYöney) {
		return birinciBileşeni * öbürYöney.birinciBileşeni +
			ikinciBileşeni * öbürYöney.ikinciBileşeni;
	}
	
	/** Verilen yöneyle bu yöneyin çapraz çarpımını döndürür. */
	public float çaprazÇarp(final Yöney2 öbürYöney) {
		return birinciBileşeni * öbürYöney.ikinciBileşeni -
			ikinciBileşeni * öbürYöney.birinciBileşeni;
	}
	
	@Override
	public String toString() {
		return dizeyeÇevir();
	}
	
	/** Yöneyi dize olarak döndürür. */
	public String dizeyeÇevir() {
		return dizeOluşturucusunaEkle(new StringBuilder()).toString();
	}
	
	/** Yöneyi verilen dize oluşturucusuna ekler. Oluşturucuyu döndürür. */
	public StringBuilder
		dizeOluşturucusunaEkle(final StringBuilder dizeOluşturucusu) {
		return dizeOluşturucusu
			.append('(')
			.append(birinciBileşeni)
			.append(", ")
			.append(ikinciBileşeni)
			.append(')');
	}
	
	/** Bu yöneyi verilen yöneye değiştirir. Bu yöneyi döndürür. */
	public Yöney2 değiştir(final Yöney2 öbürYöney) {
		return bileşenleriDeğiştir(
			öbürYöney.birinciBileşeni,
			öbürYöney.ikinciBileşeni);
	}
	
	/** Yöneyin bileşenlerini değiştirir. Yöneyi döndürür. */
	public Yöney2 bileşenleriDeğiştir(
		final float birinciBileşen,
		final float ikinciBileşen) {
		return birinciBileşeniniDeğiştir(birinciBileşen)
			.ikinciBileşeniniDeğiştir(ikinciBileşen);
	}
	
	/** Yöneyin birinci bileşenini değiştirir. Yöneyi döndürür. */
	public Yöney2 birinciBileşeniniDeğiştir(final float birinciBileşen) {
		birinciBileşeni = birinciBileşen;
		return this;
	}
	
	/** Yöneyin ikinci bileşenini değiştirir. Yöneyi döndürür. */
	public Yöney2 ikinciBileşeniniDeğiştir(final float ikinciBileşen) {
		ikinciBileşeni = ikinciBileşen;
		return this;
	}
}
