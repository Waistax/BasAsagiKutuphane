/**
 * başaşağıderebeyi.kütüphane.matematik.Yöney4.java
 * 0.2 / 16 Oca 2021 / 14:13:24
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 *
 * BaşAşağıMotor'dan alındı.
 * 0.22 / 4 Kas 2020 / 21:30:15
 */
package başaşağıderebeyi.kütüphane.matematik;

/** Dört boyutlu bir yöney. Bileşenler ondalıklı sayılar olarak saklanır. */
public class Yöney4 {
	/** Uzunluğu ve bileşenleri sıfır olan yöney. */
	public static final Yöney4 SIFIR = new Yöney4();
	/** X eksenini temsil eden yöney. */
	public static final Yöney4 BİRİNCİ_EKSEN =
		new Yöney4(1.0F, 0.0F, 0.0F, 0.0F);
	/** Y eksenini temsil eden yöney. */
	public static final Yöney4 İKİNCİ_EKSEN =
		new Yöney4(0.0F, 1.0F, 0.0F, 0.0F);
	/** Z eksenini temsil eden yöney. */
	public static final Yöney4 ÜÇÜNCÜ_EKSEN =
		new Yöney4(0.0F, 0.0F, 1.0F, 0.0F);
	/** W eksenini temsil eden yöney. */
	public static final Yöney4 DÖRDÜNCÜ_EKSEN =
		new Yöney4(0.0F, 0.0F, 0.0F, 1.0F);
	/** Her eksende bir uzunluğunda olan yöney. */
	public static final Yöney4 BİR = new Yöney4()
		.topla(BİRİNCİ_EKSEN)
		.topla(İKİNCİ_EKSEN)
		.topla(ÜÇÜNCÜ_EKSEN)
		.topla(DÖRDÜNCÜ_EKSEN);
	
	/** Yöneyin birinci bileşeni. */
	public float birinciBileşeni;
	/** Yöneyin ikinci bileşeni. */
	public float ikinciBileşeni;
	/** Yöneyin üçüncü bileşeni. */
	public float üçüncüBileşeni;
	/** Yöneyin dördüncü bileşeni. */
	public float dördüncüBileşeni;
	
	/** Sıfır yöneyi tanımlar. */
	public Yöney4() {
	}
	
	/** Verilen bileşenlerle tanımlar. */
	public Yöney4(
		final float birinciBileşen,
		final float ikinciBileşen,
		final float üçüncüBileşen,
		final float dördüncüBileşen) {
		bileşenleriniDeğiştir(
			birinciBileşen,
			ikinciBileşen,
			üçüncüBileşen,
			dördüncüBileşen);
	}
	
	/** Verilen yöneyle aynı tanımlar. */
	public Yöney4(final Yöney4 öbürü) {
		değiştir(öbürü);
	}
	
	/** Verilen yöneyle bu yöneyin denk sayılıp sayılmayacağını döndürür. */
	public boolean denkSayılmalarınıBul(final Yöney4 öbürü) {
		return MatematikAracı
			.denkSayılmalarınıBul(
				uzunluğununKaresiniBul(),
				öbürü.uzunluğununKaresiniBul());
	}
	
	@Override
	public boolean equals(final Object öbürü) {
		if (öbürü instanceof Yöney4 öbürYöney)
			return eşitOlmalarınıBul(öbürYöney);
		return false;
	}
	
	/** Verilen yöneyin bu yöneye eşit olup olmadığını döndürür. */
	public boolean eşitOlmalarınıBul(final Yöney4 öbürü) {
		return eşitOlmalarınıBul(
			öbürü.birinciBileşeni,
			öbürü.ikinciBileşeni,
			öbürü.üçüncüBileşeni,
			öbürü.dördüncüBileşeni);
	}
	
	/** Verilen bileşenlerin yöneyinkilere eşit olup olmadığını döndürür. */
	public boolean eşitOlmalarınıBul(
		final float birinciBileşen,
		final float ikinciBileşen,
		final float üçüncüBileşen,
		final float dördüncüBileşen) {
		return birinciBileşeni == birinciBileşen &&
			ikinciBileşeni == ikinciBileşen &&
			üçüncüBileşeni == üçüncüBileşen &&
			dördüncüBileşeni == dördüncüBileşen;
	}
	
	/** Yöneyin doğrultusunu (birim yöneyini) bulup, yöneyi ona değiştirir.
	 * Yöneyi döndürür. */
	public Yöney4 doğrultusunuBul() {
		return doğrultusunuBul(this);
	}
	
	/** Verilen yöneyin doğrultusunu (birim yöneyini) bulup, bu yöneyi ona
	 * değiştirir. Bu yöneyi döndürür. */
	public Yöney4 doğrultusunuBul(final Yöney4 öbürü) {
		return böl(öbürü, öbürü.uzunluğunuBul());
	}
	
	/** Bu yöneye verilen yöneyi ekler. Bu yöneyi döndürür. */
	public Yöney4 topla(final Yöney4 öbürü) {
		return this.topla(this, öbürü);
	}
	
	/** Bu yöneyi verilen yöneylerin toplamına değiştirir. Bu yöneyi
	 * döndürür. */
	public Yöney4 topla(final Yöney4 soldaki, final Yöney4 sağdaki) {
		return bileşenleriniDeğiştir(
			soldaki.birinciBileşeni + sağdaki.birinciBileşeni,
			soldaki.ikinciBileşeni + sağdaki.ikinciBileşeni,
			soldaki.üçüncüBileşeni + sağdaki.üçüncüBileşeni,
			soldaki.dördüncüBileşeni + sağdaki.dördüncüBileşeni);
	}
	
	/** Bu yöneyden verilen yöneyi çıkarır. Bu yöneyi döndürür. */
	public Yöney4 çıkar(final Yöney4 öbürü) {
		return çıkar(this, öbürü);
	}
	
	/** Bu yöneyi verilen yöneylerin farkına değiştirir. Bu yöneyi döndürür. */
	public Yöney4 çıkar(final Yöney4 soldaki, final Yöney4 sağdaki) {
		return bileşenleriniDeğiştir(
			soldaki.birinciBileşeni - sağdaki.birinciBileşeni,
			soldaki.ikinciBileşeni - sağdaki.ikinciBileşeni,
			soldaki.üçüncüBileşeni - sağdaki.üçüncüBileşeni,
			soldaki.dördüncüBileşeni - sağdaki.dördüncüBileşeni);
	}
	
	/** Yöneyi verilen sayıyla çarpar. Yöneyi döndürür. */
	public Yöney4 çarp(final float sayı) {
		return çarp(this, sayı);
	}
	
	/** Bu yöneyi verilen yöneyin verilen sayıyla çarpımına değiştirir. Bu
	 * yöneyi döndürür. */
	public Yöney4 çarp(final Yöney4 öbürü, final float sayı) {
		return bileşenleriniDeğiştir(
			öbürü.birinciBileşeni * sayı,
			öbürü.ikinciBileşeni * sayı,
			öbürü.üçüncüBileşeni * sayı,
			öbürü.dördüncüBileşeni * sayı);
	}
	
	/** Yöneyi verilen sayıya böler. Yöneyi döndürür. */
	public Yöney4 böl(final float sayı) {
		return böl(this, sayı);
	}
	
	/** Bu yöneyi verilen yöneyin verilen sayıya bölümüne değiştirir. Bu yöneyi
	 * döndürür. */
	public Yöney4 böl(final Yöney4 öbürü, final float sayı) {
		return bileşenleriniDeğiştir(
			öbürü.birinciBileşeni / sayı,
			öbürü.ikinciBileşeni / sayı,
			öbürü.üçüncüBileşeni / sayı,
			öbürü.dördüncüBileşeni / sayı);
	}
	
	/** Bu yöneyin bileşenlerini ayrı ayrı sıkıştırır. Bu yöneyi döndürür. */
	public Yöney4 sıkıştır(final Yöney4 taban, final Yöney4 tavan) {
		return sıkıştır(this, taban, tavan);
	}
	
	/** Bu yöneyi verilen yöneyin sıkıştırılmışına değiştirir. Bu yöneyi
	 * döndürür. */
	public Yöney4 sıkıştır(
		final Yöney4 öbürü,
		final Yöney4 taban,
		final Yöney4 tavan) {
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
					tavan.ikinciBileşeni),
			MatematikAracı
				.sıkıştır(
					öbürü.üçüncüBileşeni,
					taban.üçüncüBileşeni,
					tavan.üçüncüBileşeni),
			MatematikAracı
				.sıkıştır(
					öbürü.dördüncüBileşeni,
					taban.dördüncüBileşeni,
					tavan.dördüncüBileşeni));
	}
	
	/** Bu yöneyin bileşenleri ile verilen yöneyin karşılık gelen bileşenlerini
	 * karşılaştırır. Bu yöneyin bileşenlerini içlerinden küçük olana
	 * değiştirir. Bu yöneyi döndürür. */
	public Yöney4 küçüğüBul(final Yöney4 öbürü) {
		return küçüğüBul(this, öbürü);
	}
	
	/** Verilen yöneylerin karşılık gelen bileşenlerini karşılaştırır. Bu
	 * yöneyin bileşenlerini içlerinden küçük olana değiştirir. Bu yöneyi
	 * döndürür. */
	public Yöney4 küçüğüBul(final Yöney4 soldaki, final Yöney4 sağdaki) {
		return bileşenleriniDeğiştir(
			MatematikAracı
				.küçüğüBul(soldaki.birinciBileşeni, sağdaki.birinciBileşeni),
			MatematikAracı
				.küçüğüBul(soldaki.ikinciBileşeni, sağdaki.ikinciBileşeni),
			MatematikAracı
				.küçüğüBul(soldaki.üçüncüBileşeni, sağdaki.üçüncüBileşeni),
			MatematikAracı
				.küçüğüBul(soldaki.dördüncüBileşeni, sağdaki.dördüncüBileşeni));
	}
	
	/** Bu yöneyin bileşenleri ile verilen yöneyin karşılık gelen bileşenlerini
	 * karşılaştırır. Bu yöneyin bileşenlerini içlerinden büyük olana
	 * değiştirir. Bu yöneyi döndürür. */
	public Yöney4 büyüğüBul(final Yöney4 öbürü) {
		return büyüğüBul(this, öbürü);
	}
	
	/** Verilen yöneylerin karşılık gelen bileşenlerini karşılaştırır. Bu
	 * yöneyin bileşenlerini içlerinden büyük olana değiştirir. Bu yöneyi
	 * döndürür. */
	public Yöney4 büyüğüBul(final Yöney4 soldaki, final Yöney4 sağdaki) {
		return bileşenleriniDeğiştir(
			MatematikAracı
				.büyüğüBul(soldaki.birinciBileşeni, sağdaki.birinciBileşeni),
			MatematikAracı
				.büyüğüBul(soldaki.ikinciBileşeni, sağdaki.ikinciBileşeni),
			MatematikAracı
				.büyüğüBul(soldaki.üçüncüBileşeni, sağdaki.üçüncüBileşeni),
			MatematikAracı
				.büyüğüBul(soldaki.dördüncüBileşeni, sağdaki.dördüncüBileşeni));
	}
	
	/** Yöneyin bileşenlerini ayrı ayrı yuvarlar. Yöneyi döndürür. */
	public Yöney4 yuvarla() {
		return yuvarla(this);
	}
	
	/** Bu yöneyi verilen yöneyin yuvarlanmışına değiştirir. Bu yöneyi
	 * döndürür. */
	public Yöney4 yuvarla(final Yöney4 öbürü) {
		return bileşenleriniDeğiştir(
			MatematikAracı.yuvarla(öbürü.birinciBileşeni),
			MatematikAracı.yuvarla(öbürü.ikinciBileşeni),
			MatematikAracı.yuvarla(öbürü.üçüncüBileşeni),
			MatematikAracı.yuvarla(öbürü.dördüncüBileşeni));
	}
	
	/** Yöneyin bileşenlerini ayrı ayrı aşağı yuvarlar. Yöneyi döndürür. */
	public Yöney4 aşağıYuvarla() {
		return aşağıYuvarla(this);
	}
	
	/** Verilen yöneyin bileşenlerini ayrı ayrı aşağı yuvarlayıp buna yazar. Bu
	 * yöneyi döndürür. */
	public Yöney4 aşağıYuvarla(final Yöney4 öbürü) {
		return bileşenleriniDeğiştir(
			MatematikAracı.aşağıYuvarla(öbürü.birinciBileşeni),
			MatematikAracı.aşağıYuvarla(öbürü.ikinciBileşeni),
			MatematikAracı.aşağıYuvarla(öbürü.üçüncüBileşeni),
			MatematikAracı.aşağıYuvarla(öbürü.dördüncüBileşeni));
	}
	
	/** Yöneyin bileşenlerini ayrı ayrı yukarı yuvarlar. Yöneyi döndürür. */
	public Yöney4 yukarıYuvarla() {
		return yukarıYuvarla(this);
	}
	
	/** Bu yöneyi verilen yöneyin yukarı yuvarlanmışına değiştirir. Bu yöneyi
	 * döndürür. */
	public Yöney4 yukarıYuvarla(final Yöney4 öbürü) {
		return bileşenleriniDeğiştir(
			MatematikAracı.yukarıYuvarla(öbürü.birinciBileşeni),
			MatematikAracı.yukarıYuvarla(öbürü.ikinciBileşeni),
			MatematikAracı.yukarıYuvarla(öbürü.üçüncüBileşeni),
			MatematikAracı.yukarıYuvarla(öbürü.dördüncüBileşeni));
	}
	
	/** Bu yöneyi baştaki ve sondaki yöneylerin verilen uzaklığa göre
	 * aradeğerlerine değiştirir. Verilen yöneylerin bu yöneyden farklı olduğunu
	 * varsayar. Bu yöneyi döndürür. */
	public Yöney4 aradeğerleriniBul(
		final Yöney4 baştaki,
		final Yöney4 sondaki,
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
	public float noktaÇarp(final Yöney4 öbürü) {
		return birinciBileşeni * öbürü.birinciBileşeni +
			ikinciBileşeni * öbürü.ikinciBileşeni +
			üçüncüBileşeni * öbürü.üçüncüBileşeni +
			dördüncüBileşeni * öbürü.dördüncüBileşeni;
	}
	
	@Override
	public String toString() {
		return dizeyeÇevir();
	}
	
	/** Yöneyi dize olarak döndürür. */
	public String dizeyeÇevir() {
		return dizeOluşturucusunaYaz(new StringBuilder()).toString();
	}
	
	/** Yöneyi verilen dize oluşturucusuna ekler. Oluşturucuyu döndürür. */
	public StringBuilder dizeOluşturucusunaYaz(
		final StringBuilder dizeOluşturucusu) {
		return dizeOluşturucusu
			.append('(')
			.append(birinciBileşeni)
			.append(", ")
			.append(ikinciBileşeni)
			.append(", ")
			.append(üçüncüBileşeni)
			.append(", ")
			.append(dördüncüBileşeni)
			.append(')');
	}
	
	/** Bu yöneyi verilen yöneye değiştirir. Bu yöneyi döndürür. */
	public Yöney4 değiştir(final Yöney4 öbürü) {
		return bileşenleriniDeğiştir(
			öbürü.birinciBileşeni,
			öbürü.ikinciBileşeni,
			öbürü.üçüncüBileşeni,
			öbürü.dördüncüBileşeni);
	}
	
	/** Yöneyin bileşenlerini değiştirir. Yöneyi döndürür. */
	public Yöney4 bileşenleriniDeğiştir(
		final float birinciBileşen,
		final float ikinciBileşen,
		final float üçüncüBileşen,
		final float dördüncüBileşen) {
		return birinciBileşeniniDeğiştir(birinciBileşen)
			.ikinciBileşeniniDeğiştir(ikinciBileşen)
			.üçüncüBileşeniniDeğiştir(üçüncüBileşen)
			.dördüncüBileşeniniDeğiştir(dördüncüBileşen);
	}
	
	/** Yöneyin birinci bileşenini değiştirir. Yöneyi döndürür. */
	public Yöney4 birinciBileşeniniDeğiştir(final float birinciBileşen) {
		birinciBileşeni = birinciBileşen;
		return this;
	}
	
	/** Yöneyin ikinci bileşenini değiştirir. Yöneyi döndürür. */
	public Yöney4 ikinciBileşeniniDeğiştir(final float ikinciBileşen) {
		ikinciBileşeni = ikinciBileşen;
		return this;
	}
	
	/** Yöneyin üçüncü bileşenini değiştirir. Yöneyi döndürür. */
	public Yöney4 üçüncüBileşeniniDeğiştir(final float üçüncüBileşen) {
		üçüncüBileşeni = üçüncüBileşen;
		return this;
	}
	
	/** Yöneyin dördüncü bileşenini değiştirir. Yöneyi döndürür. */
	public Yöney4 dördüncüBileşeniniDeğiştir(final float dördüncüBileşen) {
		dördüncüBileşeni = dördüncüBileşen;
		return this;
	}
}
