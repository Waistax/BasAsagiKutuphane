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
	/** Her eksende bir uzunluğunda olan yöney. */
	public static final Yöney4 BİR = new Yöney4()	.topla(Yöney4.X_EKSENİ)
													.topla(Yöney4.Y_EKSENİ)
													.topla(Yöney4.Z_EKSENİ)
													.topla(Yöney4.W_EKSENİ);
	/** Uzunluğu ve bileşenleri sıfır olan yöney. */
	public static final Yöney4 SIFIR = new Yöney4();
	/** W eksenini temsil eden yöney. */
	public static final Yöney4 W_EKSENİ = new Yöney4(0.0F, 0.0F, 0.0F, 1.0F);
	/** X eksenini temsil eden yöney. */
	public static final Yöney4 X_EKSENİ = new Yöney4(1.0F, 0.0F, 0.0F, 0.0F);
	/** Y eksenini temsil eden yöney. */
	public static final Yöney4 Y_EKSENİ = new Yöney4(0.0F, 1.0F, 0.0F, 0.0F);
	/** Z eksenini temsil eden yöney. */
	public static final Yöney4 Z_EKSENİ = new Yöney4(0.0F, 0.0F, 1.0F, 0.0F);
	
	/** Yöneyin dördüncü bileşeni. */
	public float w;
	/** Yöneyin birinci bileşeni. */
	public float x;
	/** Yöneyin ikinci bileşeni. */
	public float y;
	/** Yöneyin üçüncü bileşeni. */
	public float z;
	
	/** Sıfır yöneyi tanımlar. */
	public Yöney4() {
	}
	
	/** Bileşenlerle tanımlar. */
	public Yöney4(final float x, final float y, final float z, final float w) {
		bileşenleriDeğiştir(x, y, z, w);
	}
	
	/** Verilenle aynı tanımlar. */
	public Yöney4(final Yöney4 ö) {
		değiştir(ö);
	}
	
	/** Verilen yöneyle bu yöneyin aradeğerini buna yazar. Bu yöneyi döndürür. Mesafelerin toplamının bir
	 * olduğunu varsayar. */
	public Yöney4 aradeğer(final Yöney4 ö, final float uzaklık, final float yakınlık) {
		return this.aradeğer(this, ö, uzaklık, yakınlık);
	}
	
	/** Verilen yöneylerin aradeğerini buna yazar. Bu yöneyi döndürür. Mesafelerin toplamının bir
	 * olduğunu varsayar. */
	public Yöney4 aradeğer(	final Yöney4 sol,
							final Yöney4 sağ,
							final float solaUzaklık,
							final float sağaUzaklık) {
		return bileşenleriDeğiştir(	Hesaplayıcı.aradeğer(sol.x, sağ.x, solaUzaklık, sağaUzaklık),
									Hesaplayıcı.aradeğer(sol.y, sağ.y, solaUzaklık, sağaUzaklık),
									Hesaplayıcı.aradeğer(sol.z, sağ.z, solaUzaklık, sağaUzaklık),
									Hesaplayıcı.aradeğer(sol.w, sağ.w, solaUzaklık, sağaUzaklık));
	}
	
	/** Yöneyin bileşenlerini değiştirir. Yöneyi döndürür. */
	public Yöney4 bileşenleriDeğiştir(final float x, final float y, final float z, final float w) {
		return xBileşeniniDeğiştir(x)	.yBileşeniniDeğiştir(y)
										.zBileşeniniDeğiştir(z)
										.wBileşeniniDeğiştir(w);
	}
	
	/** Yöneyi sayıya böler. Yöneyi döndürür. */
	public Yöney4 böl(final float o) {
		return this.böl(this, o);
	}
	
	/** Verilen yöneyi sayıya bölüp buna yazar. Bu yöneyi döndürür. */
	public Yöney4 böl(final Yöney4 sol, final float sağ) {
		return bileşenleriDeğiştir(sol.x / sağ, sol.y / sağ, sol.z / sağ, sol.w / sağ);
	}
	
	/** Verilen yöneyin bileşenlerinden büyük olanlarını yazar. Bu yöneyi döndürür. */
	public Yöney4 büyüktür(final Yöney4 ö) {
		return this.büyüktür(this, ö);
	}
	
	/** Verilen yöneylerin bileşenlerinden büyük olanlarını buna yazar. Bu yöneyi döndürür. */
	public Yöney4 büyüktür(final Yöney4 sol, final Yöney4 sağ) {
		return bileşenleriDeğiştir(	Hesaplayıcı.büyüktür(sol.x, sağ.x),
									Hesaplayıcı.büyüktür(sol.y, sağ.y),
									Hesaplayıcı.büyüktür(sol.z, sağ.z),
									Hesaplayıcı.büyüktür(sol.w, sağ.w));
	}
	
	/** Yöneyi sayıyla çarpar. Yöneyi döndürür. */
	public Yöney4 çarp(final float o) {
		return this.çarp(this, o);
	}
	
	/** Verilen yöneyi sayıyla çarpıp buna yazar. Bu yöneyi döndürür. */
	public Yöney4 çarp(final Yöney4 sol, final float sağ) {
		return bileşenleriDeğiştir(sol.x * sağ, sol.y * sağ, sol.z * sağ, sol.w * sağ);
	}
	
	/** Verilen yöneyi bu yöneyden çıkarır. Bu yöneyi döndürür. */
	public Yöney4 çıkar(final Yöney4 ö) {
		return this.çıkar(this, ö);
	}
	
	/** Verilen yöneylerin çıkarıp buna yazar. Bu yöneyi döndürür. */
	public Yöney4 çıkar(final Yöney4 sol, final Yöney4 sağ) {
		return bileşenleriDeğiştir(sol.x - sağ.x, sol.y - sağ.y, sol.z - sağ.z, sol.w - sağ.w);
	}
	
	/** Verilen yöneyi buna yazar. Bu yöneyi döndürür. */
	public Yöney4 değiştir(final Yöney4 ö) {
		return bileşenleriDeğiştir(ö.x, ö.y, ö.z, ö.w);
	}
	
	/** Yöneyi dizeye çevirir. */
	public String dizeOlarakEdin() {
		return dizeOluşturucusunaYaz(new StringBuilder()).toString();
	}
	
	/** Yöneyi verilen dize oluşturucusuna ekler. Oluşturucuyu döndürür. */
	public StringBuilder dizeOluşturucusunaYaz(final StringBuilder dizeOluşturucusu) {
		return dizeOluşturucusu	.append('(')
								.append(x)
								.append(", ")
								.append(y)
								.append(", ")
								.append(z)
								.append(", ")
								.append(w)
								.append(')');
	}
	
	/** Yöneyin doğrultusunu (birim yöneyini) hesaplar. Bu yöneyi döndürür. */
	public Yöney4 doğrultu() {
		return this.böl(uzunluk());
	}
	
	/** Verilen yöneyin doğrultusunu (birim yöneyini) buna yazar. Bu yöneyi döndürür. */
	public Yöney4 doğrultu(final Yöney4 ö) {
		return this.böl(ö, ö.uzunluk());
	}
	
	@Override
	public boolean equals(final Object obj) {
		return this.eşitMi((Yöney4)obj);
	}
	
	/** Verilen bileşenlerin yöneyinkilere eşitliğini hesaplar. */
	public boolean eşitMi(final float x, final float y, final float z, final float w) {
		return this.x == x && this.y == y && this.z == z && this.w == w;
	}
	
	/** Verilen yöneyin bu yöneye eşit olup olmadığını hesaplar. */
	public boolean eşitMi(final Yöney4 ö) {
		return this.eşitMi(ö.x, ö.y, ö.z, ö.w);
	}
	
	/** Verilen yöneyin bileşenlerinden küçük olanlarını yazar. Bu yöneyi döndürür. */
	public Yöney4 küçüktür(final Yöney4 ö) {
		return this.küçüktür(this, ö);
	}
	
	/** Verilen yöneylerin bileşenlerinden küçük olanlarını buna yazar. Bu yöneyi döndürür. */
	public Yöney4 küçüktür(final Yöney4 sol, final Yöney4 sağ) {
		return bileşenleriDeğiştir(	Hesaplayıcı.küçüktür(sol.x, sağ.x),
									Hesaplayıcı.küçüktür(sol.y, sağ.y),
									Hesaplayıcı.küçüktür(sol.z, sağ.z),
									Hesaplayıcı.küçüktür(sol.w, sağ.w));
	}
	
	/** Verilen yöneyle bu yöneyin nokta çarpımını hesaplar. */
	public float nokta(final Yöney4 ö) {
		return x * ö.x + y * ö.y + z * ö.z + w * ö.w;
	}
	
	/** Bu yöneyin bileşenlerini ayrı ayrı sıkıştırır. Bu yöneyi döndürür. */
	public Yöney4 sıkıştır(final Yöney4 alt, final Yöney4 üst) {
		return this.sıkıştır(this, alt, üst);
	}
	
	/** Verilen yöneyin bileşenlerini ayrı ayrı sıkıştırıp buna yazar. Bu yöneyi döndürür. */
	public Yöney4 sıkıştır(final Yöney4 ö, final Yöney4 alt, final Yöney4 üst) {
		return bileşenleriDeğiştir(	Hesaplayıcı.sıkıştır(ö.x, alt.x, üst.x),
									Hesaplayıcı.sıkıştır(ö.y, alt.y, üst.y),
									Hesaplayıcı.sıkıştır(ö.z, alt.z, üst.z),
									Hesaplayıcı.sıkıştır(ö.w, alt.w, üst.w));
	}
	
	/** Yöneyin bileşenlerini ayrı ayrı aşağı yuvarlar. Yöneyi döndürür. */
	public Yöney4 taban() {
		return this.taban(this);
	}
	
	/** Verilen yöneyin bileşenlerini ayrı ayrı aşağı yuvarlayıp buna yazar. Bu yöneyi döndürür. */
	public Yöney4 taban(final Yöney4 ö) {
		return bileşenleriDeğiştir(	Hesaplayıcı.taban(ö.x),
									Hesaplayıcı.taban(ö.y),
									Hesaplayıcı.taban(ö.z),
									Hesaplayıcı.taban(ö.w));
	}
	
	/** Yöneyin bileşenlerini ayrı ayrı yukarı yuvarlar. Yöneyi döndürür. */
	public Yöney4 tavan() {
		return this.tavan(this);
	}
	
	/** Verilen yöneyin bileşenlerini ayrı ayrı yukarı yuvarlayıp buna yazar. Bu yöneyi döndürür. */
	public Yöney4 tavan(final Yöney4 ö) {
		return bileşenleriDeğiştir(	Hesaplayıcı.tavan(ö.x),
									Hesaplayıcı.tavan(ö.y),
									Hesaplayıcı.tavan(ö.z),
									Hesaplayıcı.tavan(ö.w));
	}
	
	/** Verilen yöneyi bu yöneye ekler. Bu yöneyi döndürür. */
	public Yöney4 topla(final Yöney4 ö) {
		return this.topla(this, ö);
	}
	
	/** Verilen yöneyleri toplayıp buna yazar. Bu yöneyi döndürür. */
	public Yöney4 topla(final Yöney4 sol, final Yöney4 sağ) {
		return bileşenleriDeğiştir(sol.x + sağ.x, sol.y + sağ.y, sol.z + sağ.z, sol.w + sağ.w);
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
	
	/** Yöneyin dördüncü bileşenini değiştirir. Yöneyi döndürür. */
	public Yöney4 wBileşeniniDeğiştir(final float w) {
		this.w = w;
		return this;
	}
	
	/** Yöneyin birinci bileşenini değiştirir. Yöneyi döndürür. */
	public Yöney4 xBileşeniniDeğiştir(final float x) {
		this.x = x;
		return this;
	}
	
	/** Yöneyin ikinci bileşenini değiştirir. Yöneyi döndürür. */
	public Yöney4 yBileşeniniDeğiştir(final float y) {
		this.y = y;
		return this;
	}
	
	/** Yöneyin bileşenlerini ayrı ayrı yuvarlar. Yöneyi döndürür. */
	public Yöney4 yuvarla() {
		return this.yuvarla(this);
	}
	
	/** Verilen yöneyin bileşenlerini ayrı ayrı yuvarlayıp buna yazar. Bu yöneyi döndürür. */
	public Yöney4 yuvarla(final Yöney4 ö) {
		return bileşenleriDeğiştir(	Hesaplayıcı.yuvarla(ö.x),
									Hesaplayıcı.yuvarla(ö.y),
									Hesaplayıcı.yuvarla(ö.z),
									Hesaplayıcı.yuvarla(ö.w));
	}
	
	/** Yöneyin üçüncü bileşenini değiştirir. Yöneyi döndürür. */
	public Yöney4 zBileşeniniDeğiştir(final float z) {
		this.z = z;
		return this;
	}
}
