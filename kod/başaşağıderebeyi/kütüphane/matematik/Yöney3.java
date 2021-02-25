/**
 * başaşağıderebeyi.kütüphane.matematik.Yöney3.java
 * 0.3 / 16 Oca 2021 / 20:20:09
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.kütüphane.matematik;

/** Üç boyutlu bir yöney. Bileşenler ondalıklı sayılar olarak saklanır. */
public class Yöney3 {
	/** Uzunluğu ve bileşenleri sıfır olan yöney. */
	public static final Yöney3 SIFIR = new Yöney3();
	/** X eksenini temsil eden yöney. */
	public static final Yöney3 BİRİNCİ_EKSEN = new Yöney3(1.0F, 0.0F, 0.0F);
	/** Y eksenini temsil eden yöney. */
	public static final Yöney3 İKİNCİ_EKSEN = new Yöney3(0.0F, 1.0F, 0.0F);
	/** Z eksenini temsil eden yöney. */
	public static final Yöney3 ÜÇÜNCÜ_EKSEN = new Yöney3(0.0F, 0.0F, 1.0F);
	/** Her eksende bir uzunluğunda olan yöney. */
	public static final Yöney3 BİR = new Yöney3()
		.topla(BİRİNCİ_EKSEN)
		.topla(İKİNCİ_EKSEN)
		.topla(ÜÇÜNCÜ_EKSEN);
	
	/** Yöneyin birinci bileşeni. */
	public float birinciBileşeni;
	/** Yöneyin ikinci bileşeni. */
	public float ikinciBileşeni;
	/** Yöneyin üçüncü bileşeni. */
	public float üçüncüBileşeni;
	
	/** Sıfır yöneyi tanımlar. */
	public Yöney3() {
	}
	
	/** Verilen bileşenlerle tanımlar. */
	public Yöney3(
		final float birinciBileşen,
		final float ikinciBileşen,
		final float üçüncüBileşen) {
		bileşenleriDeğiştir(birinciBileşen, ikinciBileşen, üçüncüBileşen);
	}
	
	/** Verilen yöneyle aynı tanımlar. */
	public Yöney3(final Yöney3 öbürYöney) {
		değiştir(öbürYöney);
	}
	
	/** Verilen yöneyle bu yöneyin denk sayılıp sayılmayacağını döndürür. */
	public boolean denkSayılmalarınıBul(final Yöney3 öbürYöney) {
		return MatematikAracı
			.denkSayılmalarınıBul(
				uzunluğununKaresiniBul(),
				öbürYöney.uzunluğununKaresiniBul());
	}
	
	@Override
	public boolean equals(final Object öbürü) {
		if (öbürü instanceof Yöney3 öbürYöney)
			return eşitOlmalarınıBul(öbürYöney);
		return false;
	}
	
	/** Verilen yöneyin bu yöneye eşit olup olmadığını döndürür. */
	public boolean eşitOlmalarınıBul(final Yöney3 öbürYöney) {
		return eşitOlmalarınıBul(
			öbürYöney.birinciBileşeni,
			öbürYöney.ikinciBileşeni,
			öbürYöney.üçüncüBileşeni);
	}
	
	/** Verilen bileşenlerin yöneyinkilere eşit olup olmadığını döndürür. */
	public boolean eşitOlmalarınıBul(
		final float birinciBileşen,
		final float ikinciBileşen,
		final float üçüncüBileşen) {
		return birinciBileşeni == birinciBileşen &&
			ikinciBileşeni == ikinciBileşen &&
			üçüncüBileşeni == üçüncüBileşen;
	}
	
	/** Yöneyin doğrultusunu (birim yöneyini) bulup, yöneyi ona değiştirir.
	 * Yöneyi döndürür. */
	public Yöney3 doğrultusunuBul() {
		return doğrultusunuBul(this);
	}
	
	/** Verilen yöneyin doğrultusunu (birim yöneyini) bulup, bu yöneyi ona
	 * değiştirir. Bu yöneyi döndürür. */
	public Yöney3 doğrultusunuBul(final Yöney3 öbürYöney) {
		return böl(öbürYöney, öbürYöney.uzunluğunuBul());
	}
	
	/** Bu yöneye verilen yöneyi ekler. Bu yöneyi döndürür. */
	public Yöney3 topla(final Yöney3 öbürYöney) {
		return topla(this, öbürYöney);
	}
	
	/** Bu yöneyi verilen yöneylerin toplamına değiştirir. Bu yöneyi
	 * döndürür. */
	public Yöney3 topla(final Yöney3 soldakiYöney, final Yöney3 sağdakiYöney) {
		return bileşenleriDeğiştir(
			soldakiYöney.birinciBileşeni + sağdakiYöney.birinciBileşeni,
			soldakiYöney.ikinciBileşeni + sağdakiYöney.ikinciBileşeni,
			soldakiYöney.üçüncüBileşeni + sağdakiYöney.üçüncüBileşeni);
	}
	
	/** Bu yöneyden verilen yöneyi çıkarır. Bu yöneyi döndürür. */
	public Yöney3 çıkar(final Yöney3 öbürYöney) {
		return çıkar(this, öbürYöney);
	}
	
	/** Bu yöneyi verilen yöneylerin farkına değiştirir. Bu yöneyi döndürür. */
	public Yöney3 çıkar(final Yöney3 soldakiYöney, final Yöney3 sağdakiYöney) {
		return bileşenleriDeğiştir(
			soldakiYöney.birinciBileşeni - sağdakiYöney.birinciBileşeni,
			soldakiYöney.ikinciBileşeni - sağdakiYöney.ikinciBileşeni,
			soldakiYöney.üçüncüBileşeni - sağdakiYöney.üçüncüBileşeni);
	}
	
	/** Yöneyi verilen sayıyla çarpar. Yöneyi döndürür. */
	public Yöney3 çarp(final float sayı) {
		return çarp(this, sayı);
	}
	
	/** Bu yöneyi verilen yöneyin verilen sayıyla çarpımına değiştirir. Bu
	 * yöneyi döndürür. */
	public Yöney3 çarp(final Yöney3 öbürYöney, final float sayı) {
		return bileşenleriDeğiştir(
			öbürYöney.birinciBileşeni * sayı,
			öbürYöney.ikinciBileşeni * sayı,
			öbürYöney.üçüncüBileşeni * sayı);
	}
	
	/** Yöneyi verilen sayıya böler. Yöneyi döndürür. */
	public Yöney3 böl(final float sayı) {
		return böl(this, sayı);
	}
	
	/** Bu yöneyi verilen yöneyin verilen sayıya bölümüne değiştirir. Bu yöneyi
	 * döndürür. */
	public Yöney3 böl(final Yöney3 soldakiYöney, final float sayı) {
		return bileşenleriDeğiştir(
			soldakiYöney.birinciBileşeni / sayı,
			soldakiYöney.ikinciBileşeni / sayı,
			soldakiYöney.üçüncüBileşeni / sayı);
	}
	
	/** Bu yöneyin bileşenlerini ayrı ayrı sıkıştırır. Bu yöneyi döndürür. */
	public Yöney3 sıkıştır(final Yöney3 tabanYöney, final Yöney3 tavanYöney) {
		return sıkıştır(this, tabanYöney, tavanYöney);
	}
	
	/** Bu yöneyi verilen yöneyin sıkıştırılmışına değiştirir. Bu yöneyi
	 * döndürür. */
	public Yöney3 sıkıştır(
		final Yöney3 öbürYöney,
		final Yöney3 tabanYöney,
		final Yöney3 tavanYöney) {
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
					tavanYöney.ikinciBileşeni),
			MatematikAracı
				.sıkıştır(
					öbürYöney.üçüncüBileşeni,
					tabanYöney.üçüncüBileşeni,
					tavanYöney.üçüncüBileşeni));
	}
	
	/** Bu yöneyin bileşenleri ile verilen yöneyin karşılık gelen bileşenlerini
	 * karşılaştırır. Bu yöneyin bileşenlerini içlerinden küçük olana
	 * değiştirir. Bu yöneyi döndürür. */
	public Yöney3 küçüğüBul(final Yöney3 öbürYöney) {
		return küçüğüBul(this, öbürYöney);
	}
	
	/** Verilen yöneylerin karşılık gelen bileşenlerini karşılaştırır. Bu
	 * yöneyin bileşenlerini içlerinden küçük olana değiştirir. Bu yöneyi
	 * döndürür. */
	public Yöney3 küçüğüBul(
		final Yöney3 soldakiYöney,
		final Yöney3 sağdakiYöney) {
		return bileşenleriDeğiştir(
			MatematikAracı
				.küçüğüBul(
					soldakiYöney.birinciBileşeni,
					sağdakiYöney.birinciBileşeni),
			MatematikAracı
				.küçüğüBul(
					soldakiYöney.ikinciBileşeni,
					sağdakiYöney.ikinciBileşeni),
			MatematikAracı
				.küçüğüBul(
					soldakiYöney.üçüncüBileşeni,
					sağdakiYöney.üçüncüBileşeni));
	}
	
	/** Bu yöneyin bileşenleri ile verilen yöneyin karşılık gelen bileşenlerini
	 * karşılaştırır. Bu yöneyin bileşenlerini içlerinden büyük olana
	 * değiştirir. Bu yöneyi döndürür. */
	public Yöney3 büyüğüBul(final Yöney3 öbürYöney) {
		return büyüğüBul(this, öbürYöney);
	}
	
	/** Verilen yöneylerin karşılık gelen bileşenlerini karşılaştırır. Bu
	 * yöneyin bileşenlerini içlerinden büyük olana değiştirir. Bu yöneyi
	 * döndürür. */
	public Yöney3 büyüğüBul(
		final Yöney3 soldakiYöney,
		final Yöney3 sağdakiYöney) {
		return bileşenleriDeğiştir(
			MatematikAracı
				.büyüğüBul(
					soldakiYöney.birinciBileşeni,
					sağdakiYöney.birinciBileşeni),
			MatematikAracı
				.büyüğüBul(
					soldakiYöney.ikinciBileşeni,
					sağdakiYöney.ikinciBileşeni),
			MatematikAracı
				.büyüğüBul(
					soldakiYöney.üçüncüBileşeni,
					sağdakiYöney.üçüncüBileşeni));
	}
	
	/** Yöneyin bileşenlerini ayrı ayrı yuvarlar. Yöneyi döndürür. */
	public Yöney3 yuvarla() {
		return yuvarla(this);
	}
	
	/** Bu yöneyi verilen yöneyin yuvarlanmışına değiştirir. Bu yöneyi
	 * döndürür. */
	public Yöney3 yuvarla(final Yöney3 öbürYöney) {
		return bileşenleriDeğiştir(
			MatematikAracı.yuvarla(öbürYöney.birinciBileşeni),
			MatematikAracı.yuvarla(öbürYöney.ikinciBileşeni),
			MatematikAracı.yuvarla(öbürYöney.üçüncüBileşeni));
	}
	
	/** Yöneyin bileşenlerini ayrı ayrı aşağı yuvarlar. Yöneyi döndürür. */
	public Yöney3 aşağıYuvarla() {
		return aşağıYuvarla(this);
	}
	
	/** Bu yöneyi verilen yöneyin aşağı yuvarlanmışına değiştirir. Bu yöneyi
	 * döndürür. */
	public Yöney3 aşağıYuvarla(final Yöney3 öbürYöney) {
		return bileşenleriDeğiştir(
			MatematikAracı.aşağıYuvarla(öbürYöney.birinciBileşeni),
			MatematikAracı.aşağıYuvarla(öbürYöney.ikinciBileşeni),
			MatematikAracı.aşağıYuvarla(öbürYöney.üçüncüBileşeni));
	}
	
	/** Yöneyin bileşenlerini ayrı ayrı yukarı yuvarlar. Yöneyi döndürür. */
	public Yöney3 yukarıYuvarla() {
		return yukarıYuvarla(this);
	}
	
	/** Bu yöneyi verilen yöneyin yukarı yuvarlanmışına değiştirir. Bu yöneyi
	 * döndürür. */
	public Yöney3 yukarıYuvarla(final Yöney3 öbürYöney) {
		return bileşenleriDeğiştir(
			MatematikAracı.yukarıYuvarla(öbürYöney.birinciBileşeni),
			MatematikAracı.yukarıYuvarla(öbürYöney.ikinciBileşeni),
			MatematikAracı.yukarıYuvarla(öbürYöney.üçüncüBileşeni));
	}
	
	/** Bu yöneyi verilen yöneyle bu yöneyin verilen mesafelere göre aradeğerine
	 * değiştirir. Bu yöneyi döndürür. Mesafelerin toplamının bir olduğunu
	 * varsayar. */
	public Yöney3 aradeğerleriniBul(
		final Yöney3 öbürYöney,
		final float uzaklık,
		final float yakınlık) {
		return aradeğerleriniBul(this, öbürYöney, uzaklık, yakınlık);
	}
	
	/** Bu yöneyi verilen yöneylerin verilen mesafelere göre aradeğerine
	 * değiştirir. Bu yöneyi döndürür. Mesafelerin toplamının bir olduğunu
	 * varsayar. */
	public Yöney3 aradeğerleriniBul(
		final Yöney3 soldakiYöney,
		final Yöney3 sağdakiYöney,
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
					sağdakineOlanUzaklık),
			MatematikAracı
				.aradeğerleriniBul(
					soldakiYöney.üçüncüBileşeni,
					sağdakiYöney.üçüncüBileşeni,
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
	public float noktaÇarp(final Yöney3 öbürYöney) {
		return birinciBileşeni * öbürYöney.birinciBileşeni +
			ikinciBileşeni * öbürYöney.ikinciBileşeni +
			üçüncüBileşeni * öbürYöney.üçüncüBileşeni;
	}
	
	/** Bu yöneyi verilen yöneylerin çapraz çarpımına değiştirir. Bu yöneyi
	 * döndürür. */
	public Yöney3 çaprazÇarp(
		final Yöney3 soldakiYöney,
		final Yöney3 sağdakiYöney) {
		/* ixj=k, jxk=i, kxi=j -> (ai+bj+ck)x(xi+yj+zk) -> i=bz-yc, j=cx-za,
		 * k=ay-xb */
		
		return bileşenleriDeğiştir(
			soldakiYöney.ikinciBileşeni * sağdakiYöney.üçüncüBileşeni -
				sağdakiYöney.ikinciBileşeni * soldakiYöney.üçüncüBileşeni,
			soldakiYöney.üçüncüBileşeni * sağdakiYöney.birinciBileşeni -
				sağdakiYöney.üçüncüBileşeni * soldakiYöney.birinciBileşeni,
			soldakiYöney.birinciBileşeni * sağdakiYöney.ikinciBileşeni -
				sağdakiYöney.birinciBileşeni * soldakiYöney.ikinciBileşeni);
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
			.append(')');
	}
	
	/** Verilen yöneyi buna yazar. Bu yöneyi döndürür. */
	public Yöney3 değiştir(final Yöney3 öbürYöney) {
		return bileşenleriDeğiştir(
			öbürYöney.birinciBileşeni,
			öbürYöney.ikinciBileşeni,
			öbürYöney.üçüncüBileşeni);
	}
	
	/** Yöneyin bileşenlerini değiştirir. Yöneyi döndürür. */
	public Yöney3 bileşenleriDeğiştir(
		final float birinciBileşen,
		final float ikinciBileşen,
		final float üçüncüBileşen) {
		return birinciBileşeniniDeğiştir(birinciBileşen)
			.ikinciBileşeniniDeğiştir(ikinciBileşen)
			.üçüncüBileşeniniDeğiştir(üçüncüBileşen);
	}
	
	/** Yöneyin birinci bileşenini değiştirir. Yöneyi döndürür. */
	public Yöney3 birinciBileşeniniDeğiştir(final float birinciBileşen) {
		birinciBileşeni = birinciBileşen;
		return this;
	}
	
	/** Yöneyin ikinci bileşenini değiştirir. Yöneyi döndürür. */
	public Yöney3 ikinciBileşeniniDeğiştir(final float ikinciBileşen) {
		ikinciBileşeni = ikinciBileşen;
		return this;
	}
	
	/** Yöneyin üçüncü bileşenini değiştirir. Yöneyi döndürür. */
	public Yöney3 üçüncüBileşeniniDeğiştir(final float üçüncüBileşen) {
		üçüncüBileşeni = üçüncüBileşen;
		return this;
	}
}
