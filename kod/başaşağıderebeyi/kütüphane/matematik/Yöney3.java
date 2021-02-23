/**
 * başaşağıderebeyi.kütüphane.matematik.Yöney3.java
 * 0.3 / 16 Oca 2021 / 20:20:09
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.kütüphane.matematik;

/** Üç boyutlu bir yöney. Bileşenler ondalıklı sayılar olarak saklanır. */
public class Yöney3 {
	/** Her eksende bir uzunluğunda olan yöney. */
	public static final Yöney3 BİR = new Yöney3().topla(Yöney3.X_EKSENİ).topla(Yöney3.Y_EKSENİ).topla(Yöney3.Z_EKSENİ);
	/** Uzunluğu ve bileşenleri sıfır olan yöney. */
	public static final Yöney3 SIFIR = new Yöney3();
	/** X eksenini temsil eden yöney. */
	public static final Yöney3 X_EKSENİ = new Yöney3(1.0F, 0.0F, 0.0F);
	/** Y eksenini temsil eden yöney. */
	public static final Yöney3 Y_EKSENİ = new Yöney3(0.0F, 1.0F, 0.0F);
	/** Z eksenini temsil eden yöney. */
	public static final Yöney3 Z_EKSENİ = new Yöney3(0.0F, 0.0F, 1.0F);
	
	/** Yöneyin birinci bileşeni. */
	public float x;
	/** Yöneyin ikinci bileşeni. */
	public float y;
	/** Yöneyin üçüncü bileşeni. */
	public float z;
	
	/** Sıfır yöneyi tanımlar. */
	public Yöney3() {
	}
	
	/** Bileşenlerle tanımlar. */
	public Yöney3(final float x, final float y, final float z) {
		bileşenleriDeğiştir(x, y, z);
	}
	
	/** Verilenle aynı tanımlar. */
	public Yöney3(final Yöney3 ö) {
		değiştir(ö);
	}
	
	/** Verilen yöneyle bu yöneyin aradeğerini buna yazar. Bu yöneyi döndürür. Mesafelerin toplamının bir olduğunu
	 * öarsayar. */
	public Yöney3 aradeğer(final Yöney3 ö, final float uzaklık, final float yakınlık) {
		return this.aradeğer(this, ö, uzaklık, yakınlık);
	}
	
	/** Verilen yöneylerin aradeğerini buna yazar. Bu yöneyi döndürür. Mesafelerin toplamının bir olduğunu öarsayar. */
	public Yöney3 aradeğer(final Yöney3 sol, final Yöney3 sağ, final float solaUzaklık, final float sağaUzaklık) {
		return bileşenleriDeğiştir(	Hesaplayıcı.aradeğer(sol.x, sağ.x, solaUzaklık, sağaUzaklık),
									Hesaplayıcı.aradeğer(sol.y, sağ.y, solaUzaklık, sağaUzaklık),
									Hesaplayıcı.aradeğer(sol.z, sağ.z, solaUzaklık, sağaUzaklık));
	}
	
	/** Yöneyin bileşenlerini değiştirir. Yöneyi döndürür. */
	public Yöney3 bileşenleriDeğiştir(final float x, final float y, final float z) {
		return xBileşeniniDeğiştir(x).yBileşeniniDeğiştir(y).zBileşeniniDeğiştir(z);
	}
	
	/** Yöneyi sayıya böler. Yöneyi döndürür. */
	public Yöney3 böl(final float o) {
		return this.böl(this, o);
	}
	
	/** Verilen yöneyi sayıya bölüp buna yazar. Bu yöneyi döndürür. */
	public Yöney3 böl(final Yöney3 sol, final float sağ) {
		return bileşenleriDeğiştir(sol.x / sağ, sol.y / sağ, sol.z / sağ);
	}
	
	/** Verilen yöneyin bileşenlerinden büyük olanlarını yazar. Bu yöneyi döndürür. */
	public Yöney3 büyüktür(final Yöney3 ö) {
		return this.büyüktür(this, ö);
	}
	
	/** Verilen yöneylerin bileşenlerinden büyük olanlarını buna yazar. Bu yöneyi döndürür. */
	public Yöney3 büyüktür(final Yöney3 sol, final Yöney3 sağ) {
		return bileşenleriDeğiştir(	Hesaplayıcı.büyüktür(sol.x, sağ.x),
									Hesaplayıcı.büyüktür(sol.y, sağ.y),
									Hesaplayıcı.büyüktür(sol.z, sağ.z));
	}
	
	/** Yöneyi sayıyla çarpar. Yöneyi döndürür. */
	public Yöney3 çarp(final float o) {
		return this.çarp(this, o);
	}
	
	/** Verilen yöneyi sayıyla çarpıp buna yazar. Bu yöneyi döndürür. */
	public Yöney3 çarp(final Yöney3 sol, final float sağ) {
		return bileşenleriDeğiştir(sol.x * sağ, sol.y * sağ, sol.z * sağ);
	}
	
	/** Verilen yöneyi bu yöneyden çıkarır. Bu yöneyi döndürür. */
	public Yöney3 çıkar(final Yöney3 ö) {
		return this.çıkar(this, ö);
	}
	
	/** Verilen yöneylerin çıkarıp buna yazar. Bu yöneyi döndürür. */
	public Yöney3 çıkar(final Yöney3 sol, final Yöney3 sağ) {
		return bileşenleriDeğiştir(sol.x - sağ.x, sol.y - sağ.y, sol.z - sağ.z);
	}
	
	/** Verilen yöneyi buna yazar. Bu yöneyi döndürür. */
	public Yöney3 değiştir(final Yöney3 ö) {
		return bileşenleriDeğiştir(ö.x, ö.y, ö.z);
	}
	
	/** Yöneyi dizeye çevirir. */
	public String dizeOlarakEdin() {
		return dizeOluşturucusunaYaz(new StringBuilder()).toString();
	}
	
	/** Yöneyi verilen dize oluşturucusuna ekler. Oluşturucuyu döndürür. */
	public StringBuilder dizeOluşturucusunaYaz(final StringBuilder dizeOluşturucusu) {
		return dizeOluşturucusu.append('(').append(x).append(", ").append(y).append(", ").append(z).append(')');
	}
	
	/** Yöneyin doğrultusunu (birim yöneyini) hesaplar. Bu yöneyi döndürür. */
	public Yöney3 doğrultu() {
		return this.böl(uzunluk());
	}
	
	/** Verilen yöneyin doğrultusunu (birim yöneyini) buna yazar. Bu yöneyi döndürür. */
	public Yöney3 doğrultu(final Yöney3 ö) {
		return this.böl(ö, ö.uzunluk());
	}
	
	@Override
	public boolean equals(final Object obj) {
		return this.eşitMi((Yöney3)obj);
	}
	
	/** Verilen bileşenlerin yöneyinkilere eşitliğini hesaplar. */
	public boolean eşitMi(final float x, final float y, final float z) {
		return this.x == x && this.y == y && this.z == z;
	}
	
	/** Verilen yöneyin bu yöneye eşit olup olmadığını hesaplar. */
	public boolean eşitMi(final Yöney3 ö) {
		return this.eşitMi(ö.x, ö.y, ö.z);
	}
	
	/** Verilen yöneyin bileşenlerinden küçük olanlarını yazar. Bu yöneyi döndürür. */
	public Yöney3 küçüktür(final Yöney3 ö) {
		return this.küçüktür(this, ö);
	}
	
	/** Verilen yöneylerin bileşenlerinden küçük olanlarını buna yazar. Bu yöneyi döndürür. */
	public Yöney3 küçüktür(final Yöney3 sol, final Yöney3 sağ) {
		return bileşenleriDeğiştir(	Hesaplayıcı.küçüktür(sol.x, sağ.x),
									Hesaplayıcı.küçüktür(sol.y, sağ.y),
									Hesaplayıcı.küçüktür(sol.z, sağ.z));
	}
	
	/** Verilen yöneyle bu yöneyin nokta çarpımını hesaplar. */
	public float nokta(final Yöney3 ö) {
		return x * ö.x + y * ö.y + z * ö.z;
	}
	
	/** Bu yöneyin bileşenlerini ayrı ayrı sıkıştırır. Bu yöneyi döndürür. */
	public Yöney3 sıkıştır(final Yöney3 alt, final Yöney3 üst) {
		return this.sıkıştır(this, alt, üst);
	}
	
	/** Verilen yöneyin bileşenlerini ayrı ayrı sıkıştırıp buna yazar. Bu yöneyi döndürür. */
	public Yöney3 sıkıştır(final Yöney3 ö, final Yöney3 alt, final Yöney3 üst) {
		return bileşenleriDeğiştir(	Hesaplayıcı.sıkıştır(ö.x, alt.x, üst.x),
									Hesaplayıcı.sıkıştır(ö.y, alt.y, üst.y),
									Hesaplayıcı.sıkıştır(ö.z, alt.z, üst.z));
	}
	
	/** Yöneyin bileşenlerini ayrı ayrı aşağı yuvarlar. Yöneyi döndürür. */
	public Yöney3 taban() {
		return this.taban(this);
	}
	
	/** Verilen yöneyin bileşenlerini ayrı ayrı aşağı yuvarlayıp buna yazar. Bu yöneyi döndürür. */
	public Yöney3 taban(final Yöney3 ö) {
		return bileşenleriDeğiştir(Hesaplayıcı.taban(ö.x), Hesaplayıcı.taban(ö.y), Hesaplayıcı.taban(ö.z));
	}
	
	/** Yöneyin bileşenlerini ayrı ayrı yukarı yuvarlar. Yöneyi döndürür. */
	public Yöney3 tavan() {
		return this.tavan(this);
	}
	
	/** Verilen yöneyin bileşenlerini ayrı ayrı yukarı yuvarlayıp buna yazar. Bu yöneyi döndürür. */
	public Yöney3 tavan(final Yöney3 ö) {
		return bileşenleriDeğiştir(Hesaplayıcı.tavan(ö.x), Hesaplayıcı.tavan(ö.y), Hesaplayıcı.tavan(ö.z));
	}
	
	/** Verilen yöneyi bu yöneye ekler. Bu yöneyi döndürür. */
	public Yöney3 topla(final Yöney3 ö) {
		return this.topla(this, ö);
	}
	
	/** Verilen yöneyleri toplayıp buna yazar. Bu yöneyi döndürür. */
	public Yöney3 topla(final Yöney3 sol, final Yöney3 sağ) {
		return bileşenleriDeğiştir(sol.x + sağ.x, sol.y + sağ.y, sol.z + sağ.z);
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
	public Yöney3 xBileşeniniDeğiştir(final float x) {
		this.x = x;
		return this;
	}
	
	/** Yöneyin ikinci bileşenini değiştirir. Yöneyi döndürür. */
	public Yöney3 yBileşeniniDeğiştir(final float y) {
		this.y = y;
		return this;
	}
	
	/** Yöneyin bileşenlerini ayrı ayrı yuvarlar. Yöneyi döndürür. */
	public Yöney3 yuvarla() {
		return this.yuvarla(this);
	}
	
	/** Verilen yöneyin bileşenlerini ayrı ayrı yuvarlayıp buna yazar. Bu yöneyi döndürür. */
	public Yöney3 yuvarla(final Yöney3 ö) {
		return bileşenleriDeğiştir(Hesaplayıcı.yuvarla(ö.x), Hesaplayıcı.yuvarla(ö.y), Hesaplayıcı.yuvarla(ö.z));
	}
	
	/** Yöneyin üçüncü bileşenini değiştirir. Yöneyi döndürür. */
	public Yöney3 zBileşeniniDeğiştir(final float z) {
		this.z = z;
		return this;
	}
}
