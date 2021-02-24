/**
 * başaşağıderebeyi.kütüphane.matematik.Yöney2.java
 * 0.2 / 16 Oca 2021 / 13:07:13
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 *
 * BaşAşağıMotor'dan alındı.
 * 0.13 / 8 Eyl 2020 / 09:16:17
 */
package başaşağıderebeyi.kütüphane.matematik;

/** İki boyutlu bir yöney. Bileşenler ondalıklı sayılar olarak saklanır. */
public class Yöney2 {
	/** Her eksende bir uzunluğunda olan yöney. */
	public static final Yöney2 BİR = new Yöney2().topla(Yöney2.X_EKSENİ).topla(Yöney2.Y_EKSENİ);
	/** Uzunluğu ve bileşenleri sıfır olan yöney. */
	public static final Yöney2 SIFIR = new Yöney2();
	/** X eksenini temsil eden yöney. */
	public static final Yöney2 X_EKSENİ = new Yöney2(1.0F, 0.0F);
	/** Y eksenini temsil eden yöney. */
	public static final Yöney2 Y_EKSENİ = new Yöney2(0.0F, 1.0F);
	
	/** Yöneyin birinci bileşeni. */
	public float x;
	/** Yöneyin ikinci bileşeni. */
	public float y;
	
	/** Sıfır yöneyi tanımlar. */
	public Yöney2() {
	}
	
	/** Bileşenlerle tanımlar. */
	public Yöney2(final float x, final float y) {
		bileşenleriDeğiştir(x, y);
	}
	
	/** Verilenle aynı tanımlar. */
	public Yöney2(final Yöney2 ö) {
		değiştir(ö);
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
		return bileşenleriDeğiştir(	Hesaplayıcı.aradeğer(sol.x, sağ.x, solaUzaklık, sağaUzaklık),
									Hesaplayıcı.aradeğer(sol.y, sağ.y, solaUzaklık, sağaUzaklık));
	}
	
	/** Yöneyin bileşenlerini değiştirir. Yöneyi döndürür. */
	public Yöney2 bileşenleriDeğiştir(final float x, final float y) {
		return xBileşeniniDeğiştir(x).yBileşeniniDeğiştir(y);
	}
	
	/** Yöneyi sayıya böler. Yöneyi döndürür. */
	public Yöney2 böl(final float o) {
		return this.böl(this, o);
	}
	
	/** Verilen yöneyi sayıya bölüp buna yazar. Bu yöneyi döndürür. */
	public Yöney2 böl(final Yöney2 sol, final float sağ) {
		return bileşenleriDeğiştir(sol.x / sağ, sol.y / sağ);
	}
	
	/** Verilen yöneyin bileşenlerinden büyük olanlarını yazar. Bu yöneyi döndürür. */
	public Yöney2 büyüktür(final Yöney2 ö) {
		return this.büyüktür(this, ö);
	}
	
	/** Verilen yöneylerin bileşenlerinden büyük olanlarını buna yazar. Bu yöneyi döndürür. */
	public Yöney2 büyüktür(final Yöney2 sol, final Yöney2 sağ) {
		return bileşenleriDeğiştir(	Hesaplayıcı.büyüktür(sol.x, sağ.x),
									Hesaplayıcı.büyüktür(sol.y, sağ.y));
	}
	
	/** Yöneyi sayıyla çarpar. Yöneyi döndürür. */
	public Yöney2 çarp(final float o) {
		return this.çarp(this, o);
	}
	
	/** Verilen yöneyi sayıyla çarpıp buna yazar. Bu yöneyi döndürür. */
	public Yöney2 çarp(final Yöney2 sol, final float sağ) {
		return bileşenleriDeğiştir(sol.x * sağ, sol.y * sağ);
	}
	
	/** Verilen yöneyi bu yöneyden çıkarır. Bu yöneyi döndürür. */
	public Yöney2 çıkar(final Yöney2 ö) {
		return this.çıkar(this, ö);
	}
	
	/** Verilen yöneyleri çıkarıp buna yazar. Bu yöneyi döndürür. */
	public Yöney2 çıkar(final Yöney2 sol, final Yöney2 sağ) {
		return bileşenleriDeğiştir(sol.x - sağ.x, sol.y - sağ.y);
	}
	
	/** Verilen yöneyi buna yazar. Bu yöneyi döndürür. */
	public Yöney2 değiştir(final Yöney2 ö) {
		return bileşenleriDeğiştir(ö.x, ö.y);
	}
	
	/** Yöneyi dizeye çevirir. */
	public String dizeOlarakEdin() {
		return dizeOluşturucusunaEkle(new StringBuilder()).toString();
	}
	
	/** Yöneyi verilen dize oluşturucusuna ekler. Oluşturucuyu döndürür. */
	public StringBuilder dizeOluşturucusunaEkle(final StringBuilder dizeOluşturucusu) {
		return dizeOluşturucusu.append('(').append(x).append(", ").append(y).append(')');
	}
	
	/** Yöneyin doğrultusunu (birim yöneyini) hesaplar. Bu yöneyi döndürür. */
	public Yöney2 doğrultu() {
		return this.böl(uzunluk());
	}
	
	/** Verilen yöneyin doğrultusunu (birim yöneyini) buna yazar. Bu yöneyi döndürür. */
	public Yöney2 doğrultu(final Yöney2 ö) {
		return this.böl(ö, ö.uzunluk());
	}
	
	@Override
	public boolean equals(final Object obj) {
		return this.eşitMi((Yöney2)obj);
	}
	
	/** Verilen bileşenlerin yöneyinkilere eşitliğini hesaplar. */
	public boolean eşitMi(final float x, final float y) {
		return this.x == x && this.y == y;
	}
	
	/** Verilen yöneyin bu yöneye eşit olup olmadığını hesaplar. */
	public boolean eşitMi(final Yöney2 ö) {
		return this.eşitMi(ö.x, ö.y);
	}
	
	/** Verilen yöneyin bileşenlerinden küçük olanlarını yazar. Bu yöneyi döndürür. */
	public Yöney2 küçüktür(final Yöney2 ö) {
		return this.küçüktür(this, ö);
	}
	
	/** Verilen yöneylerin bileşenlerinden küçük olanlarını buna yazar. Bu yöneyi döndürür. */
	public Yöney2 küçüktür(final Yöney2 sol, final Yöney2 sağ) {
		return bileşenleriDeğiştir(	Hesaplayıcı.küçüktür(sol.x, sağ.x),
									Hesaplayıcı.küçüktür(sol.y, sağ.y));
	}
	
	/** Verilen yöneyle bu yöneyin nokta çarpımını hesaplar. */
	public float nokta(final Yöney2 ö) {
		return x * ö.x + y * ö.y;
	}
	
	/** Bu yöneyin bileşenlerini ayrı ayrı sıkıştırır. Bu yöneyi döndürür. */
	public Yöney2 sıkıştır(final Yöney2 alt, final Yöney2 üst) {
		return this.sıkıştır(this, alt, üst);
	}
	
	/** Verilen yöneyin bileşenlerini ayrı ayrı sıkıştırıp buna yazar. Bu yöneyi döndürür. */
	public Yöney2 sıkıştır(final Yöney2 ö, final Yöney2 alt, final Yöney2 üst) {
		return bileşenleriDeğiştir(	Hesaplayıcı.sıkıştır(ö.x, alt.x, üst.x),
									Hesaplayıcı.sıkıştır(ö.y, alt.y, üst.y));
	}
	
	/** Yöneyin bileşenlerini ayrı ayrı aşağı yuvarlar. Yöneyi döndürür. */
	public Yöney2 taban() {
		return this.taban(this);
	}
	
	/** Verilen yöneyin bileşenlerini ayrı ayrı aşağı yuvarlayıp buna yazar. Bu yöneyi döndürür. */
	public Yöney2 taban(final Yöney2 ö) {
		return bileşenleriDeğiştir(Hesaplayıcı.taban(ö.x), Hesaplayıcı.taban(ö.x));
	}
	
	/** Yöneyin bileşenlerini ayrı ayrı yukarı yuvarlar. Yöneyi döndürür. */
	public Yöney2 tavan() {
		return this.tavan(this);
	}
	
	/** Verilen yöneyin bileşenlerini ayrı ayrı yukarı yuvarlayıp buna yazar. Bu yöneyi döndürür. */
	public Yöney2 tavan(final Yöney2 ö) {
		return bileşenleriDeğiştir(Hesaplayıcı.tavan(ö.x), Hesaplayıcı.tavan(ö.x));
	}
	
	/** Verilen yöneyi bu yöneye ekler. Bu yöneyi döndürür. */
	public Yöney2 topla(final Yöney2 ö) {
		return this.topla(this, ö);
	}
	
	/** Verilen yöneyleri toplayıp buna yazar. Bu yöneyi döndürür. */
	public Yöney2 topla(final Yöney2 sol, final Yöney2 sağ) {
		return bileşenleriDeğiştir(sol.x + sağ.x, sol.y + sağ.y);
	}
	
	@Override
	public String toString() {
		return dizeOlarakEdin();
	}
	
	/** Yöneyin uzunluğunun karesini hesaplar. */
	public float uzunluğunKaresi() {
		return nokta(this);
	}
	
	/** Yöneyin uzunluğu hesaplar. */
	public float uzunluk() {
		return Hesaplayıcı.kökü(uzunluğunKaresi());
	}
	
	/** Yöneyin birinci bileşenini değiştirir. Yöneyi döndürür. */
	public Yöney2 xBileşeniniDeğiştir(final float x) {
		this.x = x;
		return this;
	}
	
	/** Yöneyin ikinci bileşenini değiştirir. Yöneyi döndürür. */
	public Yöney2 yBileşeniniDeğiştir(final float y) {
		this.y = y;
		return this;
	}
	
	/** Yöneyin bileşenlerini ayrı ayrı yuvarlar. Yöneyi döndürür. */
	public Yöney2 yuvarla() {
		return this.yuvarla(this);
	}
	
	/** Verilen yöneyin bileşenlerini ayrı ayrı yuvarlayıp buna yazar. Bu yöneyi döndürür. */
	public Yöney2 yuvarla(final Yöney2 ö) {
		return bileşenleriDeğiştir(Hesaplayıcı.yuvarla(ö.x), Hesaplayıcı.yuvarla(ö.y));
	}
}
