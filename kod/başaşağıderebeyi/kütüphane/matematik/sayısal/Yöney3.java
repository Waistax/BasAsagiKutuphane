/**
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 * 0.3 / 16 Oca 2021 / 20:20:09
 */
package başaşağıderebeyi.kütüphane.matematik.sayısal;

import başaşağıderebeyi.kütüphane.matematik.*;

import java.io.*;

import org.hsluv.*;

/** Üç boyutlu bir yöney. Bileşenler ondalıklı sayılar olarak saklanır. */
public class Yöney3 implements Serializable {
	@Serial
	private static final long serialVersionUID = 7228645153036198411L;
	
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
		bileşenleriniDeğiştir(birinciBileşen, ikinciBileşen, üçüncüBileşen);
	}
	
	/** Verilen yöneyle aynı tanımlar. */
	public Yöney3(final Yöney3 öbürü) {
		değiştir(öbürü);
	}
	
	/** Verilen yöneyle bu yöneyin denk sayılıp sayılmayacağını döndürür. */
	public boolean denkSayılmalarınıBul(final Yöney3 öbürü) {
		return MatematikAracı
			.denkSayılmalarınıBul(
				uzunluğununKaresiniBul(),
				öbürü.uzunluğununKaresiniBul());
	}
	
	@Override
	public boolean equals(final Object öbürü) {
		if (öbürü instanceof Yöney3 öbürYöney)
			return eşitOlmalarınıBul(öbürYöney);
		return false;
	}
	
	/** Verilen yöneyin bu yöneye eşit olup olmadığını döndürür. */
	public boolean eşitOlmalarınıBul(final Yöney3 öbürü) {
		return eşitOlmalarınıBul(
			öbürü.birinciBileşeni,
			öbürü.ikinciBileşeni,
			öbürü.üçüncüBileşeni);
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
	public Yöney3 doğrultusunuBul(final Yöney3 öbürü) {
		return böl(öbürü, öbürü.uzunluğunuBul());
	}
	
	/** Bu yöneye verilen yöneyi ekler. Bu yöneyi döndürür. */
	public Yöney3 topla(final Yöney3 öbürü) {
		return topla(this, öbürü);
	}
	
	/** Bu yöneyi verilen yöneylerin toplamına değiştirir. Bu yöneyi
	 * döndürür. */
	public Yöney3 topla(final Yöney3 soldaki, final Yöney3 sağdaki) {
		return bileşenleriniDeğiştir(
			soldaki.birinciBileşeni + sağdaki.birinciBileşeni,
			soldaki.ikinciBileşeni + sağdaki.ikinciBileşeni,
			soldaki.üçüncüBileşeni + sağdaki.üçüncüBileşeni);
	}
	
	/** Bu yöneyden verilen yöneyi çıkarır. Bu yöneyi döndürür. */
	public Yöney3 çıkar(final Yöney3 öbürü) {
		return çıkar(this, öbürü);
	}
	
	/** Bu yöneyi verilen yöneylerin farkına değiştirir. Bu yöneyi döndürür. */
	public Yöney3 çıkar(final Yöney3 soldaki, final Yöney3 sağdaki) {
		return bileşenleriniDeğiştir(
			soldaki.birinciBileşeni - sağdaki.birinciBileşeni,
			soldaki.ikinciBileşeni - sağdaki.ikinciBileşeni,
			soldaki.üçüncüBileşeni - sağdaki.üçüncüBileşeni);
	}
	
	/** Yöneyi verilen sayıyla çarpar. Yöneyi döndürür. */
	public Yöney3 çarp(final float sayı) {
		return çarp(this, sayı);
	}
	
	/** Bu yöneyi verilen yöneyin verilen sayıyla çarpımına değiştirir. Bu
	 * yöneyi döndürür. */
	public Yöney3 çarp(final Yöney3 öbürü, final float sayı) {
		return bileşenleriniDeğiştir(
			öbürü.birinciBileşeni * sayı,
			öbürü.ikinciBileşeni * sayı,
			öbürü.üçüncüBileşeni * sayı);
	}
	
	/** Yöneyi verilen sayıya böler. Yöneyi döndürür. */
	public Yöney3 böl(final float sayı) {
		return böl(this, sayı);
	}
	
	/** Bu yöneyi verilen yöneyin verilen sayıya bölümüne değiştirir. Bu yöneyi
	 * döndürür. */
	public Yöney3 böl(final Yöney3 öbürü, final float sayı) {
		return bileşenleriniDeğiştir(
			öbürü.birinciBileşeni / sayı,
			öbürü.ikinciBileşeni / sayı,
			öbürü.üçüncüBileşeni / sayı);
	}
	
	/** Bu yöneyin bileşenlerini ayrı ayrı sıkıştırır. Bu yöneyi döndürür. */
	public Yöney3 sıkıştır(final Yöney3 taban, final Yöney3 tavan) {
		return sıkıştır(this, taban, tavan);
	}
	
	/** Bu yöneyi verilen yöneyin sıkıştırılmışına değiştirir. Bu yöneyi
	 * döndürür. */
	public Yöney3 sıkıştır(
		final Yöney3 öbürü,
		final Yöney3 taban,
		final Yöney3 tavan) {
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
					tavan.üçüncüBileşeni));
	}
	
	/** Bu yöneyin bileşenleri ile verilen yöneyin karşılık gelen bileşenlerini
	 * karşılaştırır. Bu yöneyin bileşenlerini içlerinden küçük olana
	 * değiştirir. Bu yöneyi döndürür. */
	public Yöney3 küçüğüBul(final Yöney3 öbürü) {
		return küçüğüBul(this, öbürü);
	}
	
	/** Verilen yöneylerin karşılık gelen bileşenlerini karşılaştırır. Bu
	 * yöneyin bileşenlerini içlerinden küçük olana değiştirir. Bu yöneyi
	 * döndürür. */
	public Yöney3 küçüğüBul(final Yöney3 soldaki, final Yöney3 sağdaki) {
		return bileşenleriniDeğiştir(
			MatematikAracı
				.küçüğüBul(soldaki.birinciBileşeni, sağdaki.birinciBileşeni),
			MatematikAracı
				.küçüğüBul(soldaki.ikinciBileşeni, sağdaki.ikinciBileşeni),
			MatematikAracı
				.küçüğüBul(soldaki.üçüncüBileşeni, sağdaki.üçüncüBileşeni));
	}
	
	/** Bu yöneyin bileşenleri ile verilen yöneyin karşılık gelen bileşenlerini
	 * karşılaştırır. Bu yöneyin bileşenlerini içlerinden büyük olana
	 * değiştirir. Bu yöneyi döndürür. */
	public Yöney3 büyüğüBul(final Yöney3 öbürü) {
		return büyüğüBul(this, öbürü);
	}
	
	/** Verilen yöneylerin karşılık gelen bileşenlerini karşılaştırır. Bu
	 * yöneyin bileşenlerini içlerinden büyük olana değiştirir. Bu yöneyi
	 * döndürür. */
	public Yöney3 büyüğüBul(final Yöney3 soldaki, final Yöney3 sağdaki) {
		return bileşenleriniDeğiştir(
			MatematikAracı
				.büyüğüBul(soldaki.birinciBileşeni, sağdaki.birinciBileşeni),
			MatematikAracı
				.büyüğüBul(soldaki.ikinciBileşeni, sağdaki.ikinciBileşeni),
			MatematikAracı
				.büyüğüBul(soldaki.üçüncüBileşeni, sağdaki.üçüncüBileşeni));
	}
	
	/** Yöneyin bileşenlerini ayrı ayrı yuvarlar. Yöneyi döndürür. */
	public Yöney3 yuvarla() {
		return yuvarla(this);
	}
	
	/** Bu yöneyi verilen yöneyin yuvarlanmışına değiştirir. Bu yöneyi
	 * döndürür. */
	public Yöney3 yuvarla(final Yöney3 öbürü) {
		return bileşenleriniDeğiştir(
			MatematikAracı.yuvarla(öbürü.birinciBileşeni),
			MatematikAracı.yuvarla(öbürü.ikinciBileşeni),
			MatematikAracı.yuvarla(öbürü.üçüncüBileşeni));
	}
	
	/** Yöneyin bileşenlerini ayrı ayrı aşağı yuvarlar. Yöneyi döndürür. */
	public Yöney3 aşağıYuvarla() {
		return aşağıYuvarla(this);
	}
	
	/** Bu yöneyi verilen yöneyin aşağı yuvarlanmışına değiştirir. Bu yöneyi
	 * döndürür. */
	public Yöney3 aşağıYuvarla(final Yöney3 öbürü) {
		return bileşenleriniDeğiştir(
			MatematikAracı.aşağıYuvarla(öbürü.birinciBileşeni),
			MatematikAracı.aşağıYuvarla(öbürü.ikinciBileşeni),
			MatematikAracı.aşağıYuvarla(öbürü.üçüncüBileşeni));
	}
	
	/** Yöneyin bileşenlerini ayrı ayrı yukarı yuvarlar. Yöneyi döndürür. */
	public Yöney3 yukarıYuvarla() {
		return yukarıYuvarla(this);
	}
	
	/** Bu yöneyi verilen yöneyin yukarı yuvarlanmışına değiştirir. Bu yöneyi
	 * döndürür. */
	public Yöney3 yukarıYuvarla(final Yöney3 öbürü) {
		return bileşenleriniDeğiştir(
			MatematikAracı.yukarıYuvarla(öbürü.birinciBileşeni),
			MatematikAracı.yukarıYuvarla(öbürü.ikinciBileşeni),
			MatematikAracı.yukarıYuvarla(öbürü.üçüncüBileşeni));
	}
	
	/** Bu yöneyi baştaki ve sondaki yöneylerin verilen uzaklığa göre
	 * aradeğerlerine değiştirir. Verilen yöneylerin bu yöneyden farklı olduğunu
	 * varsayar. Bu yöneyi döndürür. */
	public Yöney3 aradeğerleriniBul(
		final Yöney3 baştaki,
		final Yöney3 sondaki,
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
	public float noktaÇarp(final Yöney3 öbürü) {
		return birinciBileşeni * öbürü.birinciBileşeni +
			ikinciBileşeni * öbürü.ikinciBileşeni +
			üçüncüBileşeni * öbürü.üçüncüBileşeni;
	}
	
	/** Bu yöneyi verilen yöneyle bu yöneyin çapraz çarpımına değiştirir. Bu
	 * yöneyi döndürür. */
	public Yöney3 çaprazÇarp(final Yöney3 öbürü) {
		return çaprazÇarp(this, öbürü);
	}
	
	/** Bu yöneyi verilen yöneylerin çapraz çarpımına değiştirir. Bu yöneyi
	 * döndürür. */
	public Yöney3 çaprazÇarp(final Yöney3 soldaki, final Yöney3 sağdaki) {
		/* j x k = i -> (ai + bj + ck) x (xi + yj + zk) -> i = bz - yc */
		/* k x i = j -> (ai + bj + ck) x (xi + yj + zk) -> j = cx - za */
		/* i x j = k -> (ai + bj + ck) x (xi + yj + zk) -> k = ay - xb */
		return bileşenleriniDeğiştir(
			soldaki.ikinciBileşeni * sağdaki.üçüncüBileşeni -
				sağdaki.ikinciBileşeni * soldaki.üçüncüBileşeni,
			soldaki.üçüncüBileşeni * sağdaki.birinciBileşeni -
				sağdaki.üçüncüBileşeni * soldaki.birinciBileşeni,
			soldaki.birinciBileşeni * sağdaki.ikinciBileşeni -
				sağdaki.birinciBileşeni * soldaki.ikinciBileşeni);
	}
	
	/** RGB renk uzayındaki yöneyi HSLuv renk uzayındaki dengine değiştirir.
	 * Yöneyi döndürür. */
	public Yöney3 rgbdenHsluva() {
		return rgbdenHsluva(this);
	}
	
	/** Bu yöneyi RGB renk uzayında verilen yöneyin HSLuv renk uzayındaki
	 * dengine değiştirir. Bu yöneyi döndürür. */
	public Yöney3 rgbdenHsluva(final Yöney3 öbürü) {
		final double[] dizisi = HUSLColorConverter
			.rgbToHsluv(
				new double[] {
					öbürü.birinciBileşeni,
					öbürü.ikinciBileşeni,
					öbürü.üçüncüBileşeni });
		return bileşenleriniDeğiştir(
			(float)dizisi[0],
			(float)dizisi[1],
			(float)dizisi[2]);
	}
	
	/** HSLuv renk uzayındaki yöneyi RGB renk uzayındaki dengine değiştirir.
	 * Yöneyi döndürür. */
	public Yöney3 hsluvdanRgbye() {
		return hsluvdanRgbye(this);
	}
	
	/** Bu yöneyi HSLuv renk uzayında verilen yöneyin RGB renk uzayındaki
	 * dengine değiştirir. Bu yöneyi döndürür. */
	public Yöney3 hsluvdanRgbye(final Yöney3 öbürü) {
		final double[] dizisi = HUSLColorConverter
			.hsluvToRgb(
				new double[] {
					öbürü.birinciBileşeni,
					öbürü.ikinciBileşeni,
					öbürü.üçüncüBileşeni });
		return bileşenleriniDeğiştir(
			(float)dizisi[0],
			(float)dizisi[1],
			(float)dizisi[2]);
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
	
	/** Bu yöneyi verilen yöneye değiştirir. Bu yöneyi döndürür. */
	public Yöney3 değiştir(final Yöney3 öbürü) {
		return bileşenleriniDeğiştir(
			öbürü.birinciBileşeni,
			öbürü.ikinciBileşeni,
			öbürü.üçüncüBileşeni);
	}
	
	/** Yöneyin bileşenlerini değiştirir. Yöneyi döndürür. */
	public Yöney3 bileşenleriniDeğiştir(
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
