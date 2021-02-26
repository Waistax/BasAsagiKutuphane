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
	public static final Yöney2 BİR =
		new Yöney2().topla(BİRİNCİ_EKSEN).topla(İKİNCİ_EKSEN);
	
	/** Yöneyin birinci bileşeni. */
	public float birinciBileşeni;
	/** Yöneyin ikinci bileşeni. */
	public float ikinciBileşeni;
	
	/** Sıfır yöneyi tanımlar. */
	public Yöney2() {
	}
	
	/** Verilen bileşenlerle tanımlar. */
	public Yöney2(final float birinciBileşen, final float ikinciBileşen) {
		bileşenleriniDeğiştir(birinciBileşen, ikinciBileşen);
	}
	
	/** Verilen yöneyle aynı tanımlar. */
	public Yöney2(final Yöney2 öbürü) {
		değiştir(öbürü);
	}
	
	/** Verilen yöneyle bu yöneyin denk sayılıp sayılmadığını döndürür. */
	public boolean denkSayılmalarınıBul(final Yöney2 öbürü) {
		return MatematikAracı
			.denkSayılmalarınıBul(
				uzunluğununKaresiniBul(),
				öbürü.uzunluğununKaresiniBul());
	}
	
	@Override
	public boolean equals(final Object öbürü) {
		if (öbürü instanceof Yöney2 öbürYöney)
			return eşitOlmalarınıBul(öbürYöney);
		return false;
	}
	
	/** Verilen yöneyin bu yöneye eşit olup olmadığını döndürür. */
	public boolean eşitOlmalarınıBul(final Yöney2 öbürü) {
		return eşitOlmalarınıBul(öbürü.birinciBileşeni, öbürü.ikinciBileşeni);
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
	public Yöney2 doğrultusunuBul(final Yöney2 öbürü) {
		return böl(öbürü, öbürü.uzunluğunuBul());
	}
	
	/** Bu yöneye verilen yöneyi ekler. Bu yöneyi döndürür. */
	public Yöney2 topla(final Yöney2 öbürü) {
		return topla(this, öbürü);
	}
	
	/** Bu yöneyi verilen yöneylerin toplamına değiştirir. Bu yöneyi
	 * döndürür. */
	public Yöney2 topla(final Yöney2 soldaki, final Yöney2 sağdaki) {
		return bileşenleriniDeğiştir(
			soldaki.birinciBileşeni + sağdaki.birinciBileşeni,
			soldaki.ikinciBileşeni + sağdaki.ikinciBileşeni);
	}
	
	/** Bu yöneyden verilen yöneyi çıkarır. Bu yöneyi döndürür. */
	public Yöney2 çıkar(final Yöney2 öbürü) {
		return çıkar(this, öbürü);
	}
	
	/** Bu yöneyi verilen yöneylerin farkına değiştirir. Bu yöneyi döndürür. */
	public Yöney2 çıkar(final Yöney2 soldaki, final Yöney2 sağdaki) {
		return bileşenleriniDeğiştir(
			soldaki.birinciBileşeni - sağdaki.birinciBileşeni,
			soldaki.ikinciBileşeni - sağdaki.ikinciBileşeni);
	}
	
	/** Yöneyi verilen sayıyla çarpar. Yöneyi döndürür. */
	public Yöney2 çarp(final float sayı) {
		return çarp(this, sayı);
	}
	
	/** Bu yöneyi verilen yöneyin verilen sayıyla çarpımına değiştirir. Bu
	 * yöneyi döndürür. */
	public Yöney2 çarp(final Yöney2 öbürü, final float sayı) {
		return bileşenleriniDeğiştir(
			öbürü.birinciBileşeni * sayı,
			öbürü.ikinciBileşeni * sayı);
	}
	
	/** Yöneyi verilen sayıya böler. Yöneyi döndürür. */
	public Yöney2 böl(final float sayı) {
		return böl(this, sayı);
	}
	
	/** Bu yöneyi verilen yöneyin verilen sayıya bölümüne değiştirir. Bu yöneyi
	 * döndürür. */
	public Yöney2 böl(final Yöney2 öbürü, final float sayı) {
		return bileşenleriniDeğiştir(
			öbürü.birinciBileşeni / sayı,
			öbürü.ikinciBileşeni / sayı);
	}
	
	/** Bu yöneyin bileşenlerini ayrı ayrı sıkıştırır. Bu yöneyi döndürür. */
	public Yöney2 sıkıştır(final Yöney2 taban, final Yöney2 tavan) {
		return sıkıştır(this, taban, tavan);
	}
	
	/** Bu yöneyi verilen yöneyin sıkıştırılmışına değiştirir. Bu yöneyi
	 * döndürür. */
	public Yöney2 sıkıştır(
		final Yöney2 öbürü,
		final Yöney2 taban,
		final Yöney2 tavan) {
		return bileşenleriniDeğiştir(
			MatematikAracı
				.sıkıştır(
					öbürü.birinciBileşeni,
					taban.birinciBileşeni,
					tavan.birinciBileşeni),
			MatematikAracı
				.sıkıştır(
					öbürü.ikinciBileşeni,
					taban.ikinciBileşeni,
					tavan.ikinciBileşeni));
	}
	
	/** Bu yöneyin bileşenleri ile verilen yöneyin karşılık gelen bileşenlerini
	 * karşılaştırır. Bu yöneyin bileşenlerini içlerinden küçük olana
	 * değiştirir. Bu yöneyi döndürür. */
	public Yöney2 küçüğüBul(final Yöney2 öbürü) {
		return küçüğüBul(this, öbürü);
	}
	
	/** Verilen yöneylerin karşılık gelen bileşenlerini karşılaştırır. Bu
	 * yöneyin bileşenlerini içlerinden küçük olana değiştirir. Bu yöneyi
	 * döndürür. */
	public Yöney2 küçüğüBul(final Yöney2 soldaki, final Yöney2 sağdaki) {
		return bileşenleriniDeğiştir(
			MatematikAracı
				.küçüğüBul(soldaki.birinciBileşeni, sağdaki.birinciBileşeni),
			MatematikAracı
				.küçüğüBul(soldaki.ikinciBileşeni, sağdaki.ikinciBileşeni));
	}
	
	/** Bu yöneyin bileşenleri ile verilen yöneyin karşılık gelen bileşenlerini
	 * karşılaştırır. Bu yöneyin bileşenlerini içlerinden büyük olana
	 * değiştirir. Bu yöneyi döndürür. */
	public Yöney2 büyüğüBul(final Yöney2 öbürü) {
		return büyüğüBul(this, öbürü);
	}
	
	/** Verilen yöneylerin karşılık gelen bileşenlerini karşılaştırır. Bu
	 * yöneyin bileşenlerini içlerinden büyük olana değiştirir. Bu yöneyi
	 * döndürür. */
	public Yöney2 büyüğüBul(final Yöney2 soldaki, final Yöney2 sağdaki) {
		return bileşenleriniDeğiştir(
			MatematikAracı
				.büyüğüBul(soldaki.birinciBileşeni, sağdaki.birinciBileşeni),
			MatematikAracı
				.büyüğüBul(soldaki.ikinciBileşeni, sağdaki.ikinciBileşeni));
	}
	
	/** Yöneyin bileşenlerini ayrı ayrı yuvarlar. Yöneyi döndürür. */
	public Yöney2 yuvarla() {
		return yuvarla(this);
	}
	
	/** Bu yöneyi verilen yöneyin yuvarlanmışına değiştirir. Bu yöneyi
	 * döndürür. */
	public Yöney2 yuvarla(final Yöney2 öbürü) {
		return bileşenleriniDeğiştir(
			MatematikAracı.yuvarla(öbürü.birinciBileşeni),
			MatematikAracı.yuvarla(öbürü.ikinciBileşeni));
	}
	
	/** Yöneyin bileşenlerini ayrı ayrı aşağı yuvarlar. Yöneyi döndürür. */
	public Yöney2 aşağıYuvarla() {
		return aşağıYuvarla(this);
	}
	
	/** Bu yöneyi verilen yöneyin aşağı yuvarlanmışına değiştirir. Bu yöneyi
	 * döndürür. */
	public Yöney2 aşağıYuvarla(final Yöney2 öbürü) {
		return bileşenleriniDeğiştir(
			MatematikAracı.aşağıYuvarla(öbürü.birinciBileşeni),
			MatematikAracı.aşağıYuvarla(öbürü.birinciBileşeni));
	}
	
	/** Yöneyin bileşenlerini ayrı ayrı yukarı yuvarlar. Yöneyi döndürür. */
	public Yöney2 yukarıYuvarla() {
		return yukarıYuvarla(this);
	}
	
	/** Bu yöneyi verilen yöneyin yukarı yuvarlanmışına değiştirir. Bu yöneyi
	 * döndürür. */
	public Yöney2 yukarıYuvarla(final Yöney2 öbürü) {
		return bileşenleriniDeğiştir(
			MatematikAracı.yukarıYuvarla(öbürü.birinciBileşeni),
			MatematikAracı.yukarıYuvarla(öbürü.birinciBileşeni));
	}
	
	/** Bu yöneyi baştaki ve sondaki yöneylerin verilen uzaklığa göre
	 * aradeğerlerine değiştirir. Verilen yöneylerin bu yöneyden farklı olduğunu
	 * varsayar. Bu yöneyi döndürür. */
	public Yöney2 aradeğerleriniBul(
		final Yöney2 baştaki,
		final Yöney2 sondaki,
		final float uzaklık) {
		/* aradeğer = baştakiYöney + (sondakiYöney - baştakiYöney) * uzaklık */
		return topla(baştaki, çarp(çıkar(sondaki, baştaki), uzaklık));
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
	public float noktaÇarp(final Yöney2 öbürü) {
		return birinciBileşeni * öbürü.birinciBileşeni +
			ikinciBileşeni * öbürü.ikinciBileşeni;
	}
	
	/** Verilen yöneyle bu yöneyin çapraz çarpımını döndürür. */
	public float çaprazÇarp(final Yöney2 öbürü) {
		/* i x j = k -> (ai + bj) x (xi + yj) -> k = ay - xb */
		return birinciBileşeni * öbürü.ikinciBileşeni -
			ikinciBileşeni * öbürü.birinciBileşeni;
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
	public StringBuilder dizeOluşturucusunaEkle(
		final StringBuilder dizeOluşturucusu) {
		return dizeOluşturucusu
			.append('(')
			.append(birinciBileşeni)
			.append(", ")
			.append(ikinciBileşeni)
			.append(')');
	}
	
	/** Bu yöneyi verilen yöneye değiştirir. Bu yöneyi döndürür. */
	public Yöney2 değiştir(final Yöney2 öbürü) {
		return bileşenleriniDeğiştir(
			öbürü.birinciBileşeni,
			öbürü.ikinciBileşeni);
	}
	
	/** Yöneyin bileşenlerini değiştirir. Yöneyi döndürür. */
	public Yöney2 bileşenleriniDeğiştir(
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
