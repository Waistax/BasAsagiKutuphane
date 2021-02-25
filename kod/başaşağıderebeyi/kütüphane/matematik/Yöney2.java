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
	public static final Yöney2 BİR = new Yöney2().topla(BİRİNCİ_EKSEN).topla(İKİNCİ_EKSEN);
	
	/** Yöneyin birinci bileşeni. */
	public float birinciBileşeni;
	/** Yöneyin ikinci bileşeni. */
	public float ikinciBileşeni;
	
	/** Sıfır yöneyi tanımlar. */
	public Yöney2() {
	}
	
	/** Bileşenlerle tanımlar. */
	public Yöney2(final float birinciBileşeni, final float ikinciBileşeni) {
		bileşenleriDeğiştir(birinciBileşeni, ikinciBileşeni);
	}
	
	/** Verilenle aynı tanımlar. */
	public Yöney2(final Yöney2 öbürü) {
		değiştir(öbürü);
	}
	
	/** Bu yöney ile verilenin denk sayılıp sayılmadığını döndürür. */
	public boolean denkSayılmalarınıBul(final Yöney2 öbürü) {
		return MatematikAracı.denkSayılmalarınıBul(uzunluğunKaresi(), öbürü.uzunluğunKaresi());
	}
	
	@Override
	public boolean equals(final Object obj) {
		if (obj instanceof Yöney2 ö)
			return eşitMi(ö);
		return false;
	}
	
	/** Verilen bileşenlerin yöneyinkilere eşitliğini hesaplar. */
	public boolean eşitMi(final float x, final float y) {
		return birinciBileşeni == x && ikinciBileşeni == y;
	}
	
	/** Verilen yöneyin bu yöneye eşit olup olmadığını hesaplar. */
	public boolean eşitMi(final Yöney2 ö) {
		return this.eşitMi(ö.birinciBileşeni, ö.ikinciBileşeni);
	}
	
	/** Yöneyin doğrultusunu (birim yöneyini) hesaplar. Bu yöneyi döndürür. */
	public Yöney2 doğrultu() {
		return doğrultu(this);
	}
	
	/** Verilen yöneyin doğrultusunu (birim yöneyini) buna yazar. Bu yöneyi döndürür. */
	public Yöney2 doğrultu(final Yöney2 ö) {
		return this.böl(ö, ö.uzunluk());
	}
	
	/** Verilen yöneyi bu yöneye ekler. Bu yöneyi döndürür. */
	public Yöney2 topla(final Yöney2 ö) {
		return this.topla(this, ö);
	}
	
	/** Verilen yöneyleri toplayıp buna yazar. Bu yöneyi döndürür. */
	public Yöney2 topla(final Yöney2 sol, final Yöney2 sağ) {
		return bileşenleriDeğiştir(	sol.birinciBileşeni +	sağ.birinciBileşeni,
									sol.ikinciBileşeni + sağ.ikinciBileşeni);
	}
	
	/** Verilen yöneyi bu yöneyden çıkarır. Bu yöneyi döndürür. */
	public Yöney2 çıkar(final Yöney2 ö) {
		return this.çıkar(this, ö);
	}
	
	/** Verilen yöneyleri çıkarıp buna yazar. Bu yöneyi döndürür. */
	public Yöney2 çıkar(final Yöney2 sol, final Yöney2 sağ) {
		return bileşenleriDeğiştir(	sol.birinciBileşeni -	sağ.birinciBileşeni,
									sol.ikinciBileşeni - sağ.ikinciBileşeni);
	}
	
	/** Yöneyi sayıyla çarpar. Yöneyi döndürür. */
	public Yöney2 çarp(final float o) {
		return this.çarp(this, o);
	}
	
	/** Verilen yöneyi sayıyla çarpıp buna yazar. Bu yöneyi döndürür. */
	public Yöney2 çarp(final Yöney2 sol, final float sağ) {
		return bileşenleriDeğiştir(sol.birinciBileşeni * sağ, sol.ikinciBileşeni * sağ);
	}
	
	/** Yöneyi sayıya böler. Yöneyi döndürür. */
	public Yöney2 böl(final float o) {
		return this.böl(this, o);
	}
	
	/** Verilen yöneyi sayıya bölüp buna yazar. Bu yöneyi döndürür. */
	public Yöney2 böl(final Yöney2 sol, final float sağ) {
		return bileşenleriDeğiştir(sol.birinciBileşeni / sağ, sol.ikinciBileşeni / sağ);
	}
	
	/** Bu yöneyin bileşenlerini ayrı ayrı sıkıştırır. Bu yöneyi döndürür. */
	public Yöney2 sıkıştır(final Yöney2 alt, final Yöney2 üst) {
		return this.sıkıştır(this, alt, üst);
	}
	
	/** Verilen yöneyin bileşenlerini ayrı ayrı sıkıştırıp buna yazar. Bu yöneyi döndürür. */
	public Yöney2 sıkıştır(final Yöney2 ö, final Yöney2 alt, final Yöney2 üst) {
		return bileşenleriDeğiştir(	MatematikAracı.sıkıştır(ö.birinciBileşeni,
															alt.birinciBileşeni,
															üst.birinciBileşeni),
									MatematikAracı.sıkıştır(ö.ikinciBileşeni,
															alt.ikinciBileşeni,
															üst.ikinciBileşeni));
	}
	
	/** Verilen yöneyin bileşenlerinden küçük olanlarını yazar. Bu yöneyi döndürür. */
	public Yöney2 küçüktür(final Yöney2 ö) {
		return this.küçüktür(this, ö);
	}
	
	/** Verilen yöneylerin bileşenlerinden küçük olanlarını buna yazar. Bu yöneyi döndürür. */
	public Yöney2 küçüktür(final Yöney2 sol, final Yöney2 sağ) {
		return bileşenleriDeğiştir(	MatematikAracı.küçüğüBul(sol.birinciBileşeni, sağ.birinciBileşeni),
									MatematikAracı.küçüğüBul(sol.ikinciBileşeni, sağ.ikinciBileşeni));
	}
	
	/** Verilen yöneyin bileşenlerinden büyük olanlarını yazar. Bu yöneyi döndürür. */
	public Yöney2 büyüktür(final Yöney2 ö) {
		return this.büyüktür(this, ö);
	}
	
	/** Verilen yöneylerin bileşenlerinden büyük olanlarını buna yazar. Bu yöneyi döndürür. */
	public Yöney2 büyüktür(final Yöney2 sol, final Yöney2 sağ) {
		return bileşenleriDeğiştir(	MatematikAracı.büyüğüBul(sol.birinciBileşeni, sağ.birinciBileşeni),
									MatematikAracı.büyüğüBul(sol.ikinciBileşeni, sağ.ikinciBileşeni));
	}
	
	/** Yöneyin bileşenlerini ayrı ayrı yuvarlar. Yöneyi döndürür. */
	public Yöney2 yuvarla() {
		return this.yuvarla(this);
	}
	
	/** Verilen yöneyin bileşenlerini ayrı ayrı yuvarlayıp buna yazar. Bu yöneyi döndürür. */
	public Yöney2 yuvarla(final Yöney2 ö) {
		return bileşenleriDeğiştir(	MatematikAracı.yuvarla(ö.birinciBileşeni),
									MatematikAracı.yuvarla(ö.ikinciBileşeni));
	}
	
	/** Yöneyin bileşenlerini ayrı ayrı yukarı yuvarlar. Yöneyi döndürür. */
	public Yöney2 tavan() {
		return this.tavan(this);
	}
	
	/** Verilen yöneyin bileşenlerini ayrı ayrı yukarı yuvarlayıp buna yazar. Bu yöneyi döndürür. */
	public Yöney2 tavan(final Yöney2 ö) {
		return bileşenleriDeğiştir(	MatematikAracı.yukarıYuvarla(ö.birinciBileşeni),
									MatematikAracı.yukarıYuvarla(ö.birinciBileşeni));
	}
	
	/** Yöneyin bileşenlerini ayrı ayrı aşağı yuvarlar. Yöneyi döndürür. */
	public Yöney2 taban() {
		return this.taban(this);
	}
	
	/** Verilen yöneyin bileşenlerini ayrı ayrı aşağı yuvarlayıp buna yazar. Bu yöneyi döndürür. */
	public Yöney2 taban(final Yöney2 ö) {
		return bileşenleriDeğiştir(	MatematikAracı.aşağıYuvarla(ö.birinciBileşeni),
									MatematikAracı.aşağıYuvarla(ö.birinciBileşeni));
	}
	
	/** Verilen yöneyle bu yöneyin aradeğerini buna yazar. Bu yöneyi döndürür. Mesafelerin toplamının bir
	 * olduğunu varsayar. */
	public Yöney2 aradeğer(final Yöney2 ö, final float uzaklık, final float yakınlık) {
		return this.aradeğer(this, ö, uzaklık, yakınlık);
	}
	
	/** Verilen yöneylerin aradeğerini buna yazar. Bu yöneyi döndürür. Mesafelerin toplamının bir
	 * olduğunu varsayar. */
	public Yöney2 aradeğer(	final Yöney2 sol,
							final Yöney2 sağ,
							final float solaUzaklık,
							final float sağaUzaklık) {
		return bileşenleriDeğiştir(	MatematikAracı.aradeğerleriniBul(	sol.birinciBileşeni,
																		sağ.birinciBileşeni,
																		solaUzaklık,
																		sağaUzaklık),
									MatematikAracı.aradeğerleriniBul(	sol.ikinciBileşeni,
																		sağ.ikinciBileşeni,
																		solaUzaklık,
																		sağaUzaklık));
	}
	
	/** Yöneyin uzunluğu hesaplar. */
	public float uzunluk() {
		return MatematikAracı.kökünüBul(uzunluğunKaresi());
	}
	
	/** Yöneyin uzunluğunun karesini hesaplar. */
	public float uzunluğunKaresi() {
		return nokta(this);
	}
	
	/** Verilen yöneyle bu yöneyin nokta çarpımını hesaplar. */
	public float nokta(final Yöney2 ö) {
		return birinciBileşeni * ö.birinciBileşeni + ikinciBileşeni * ö.ikinciBileşeni;
	}
	
	/** Yöneyi dizeye çevirir. */
	public String dizeOlarakEdin() {
		return dizeOluşturucusunaEkle(new StringBuilder()).toString();
	}
	
	/** Yöneyi verilen dize oluşturucusuna ekler. Oluşturucuyu döndürür. */
	public StringBuilder dizeOluşturucusunaEkle(final StringBuilder dizeOluşturucusu) {
		return dizeOluşturucusu	.append('(')
								.append(birinciBileşeni)
								.append(", ")
								.append(ikinciBileşeni)
								.append(')');
	}
	
	@Override
	public String toString() {
		return dizeOlarakEdin();
	}
	
	/** Verilen yöneyi buna yazar. Bu yöneyi döndürür. */
	public Yöney2 değiştir(final Yöney2 ö) {
		return bileşenleriDeğiştir(ö.birinciBileşeni, ö.ikinciBileşeni);
	}
	
	/** Yöneyin bileşenlerini değiştirir. Yöneyi döndürür. */
	public Yöney2 bileşenleriDeğiştir(final float x, final float y) {
		return xBileşeniniDeğiştir(x).yBileşeniniDeğiştir(y);
	}
	
	/** Yöneyin birinci bileşenini değiştirir. Yöneyi döndürür. */
	public Yöney2 xBileşeniniDeğiştir(final float x) {
		birinciBileşeni = x;
		return this;
	}
	
	/** Yöneyin ikinci bileşenini değiştirir. Yöneyi döndürür. */
	public Yöney2 yBileşeniniDeğiştir(final float y) {
		ikinciBileşeni = y;
		return this;
	}
}
