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
	/** Yöneyin birinci bileşeni. */
	public float x;
	/** Yöneyin ikinci bileşeni. */
	public float y;
	/** Yöneyin üçüncü bileşeni. */
	public float z;
	/** Yöneyin dördüncü bileşeni. */
	public float w;
	
	/** Sıfır yöneyi tanımlar. */
	public Yöney4() {
	}
	
	/** Bileşenlerle tanımlar. */
	public Yöney4(final float x, final float y, final float z, final float w) {
		this.yaz(x, y, z, w);
	}
	
	/** Verilenle aynı tanımlar. */
	public Yöney4(final Yöney4 ö) {
		this.yaz(ö);
	}
	
	/** Yöneyin birinci bileşenini değiştirir. Yöneyi döndürür. */
	public Yöney4 yazX(final float x) {
		this.x = x;
		return this;
	}
	
	/** Yöneyin ikinci bileşenini değiştirir. Yöneyi döndürür. */
	public Yöney4 yazY(final float y) {
		this.y = y;
		return this;
	}
	
	/** Yöneyin üçüncü bileşenini değiştirir. Yöneyi döndürür. */
	public Yöney4 yazZ(final float z) {
		this.z = z;
		return this;
	}
	
	/** Yöneyin dördüncü bileşenini değiştirir. Yöneyi döndürür. */
	public Yöney4 yazW(final float w) {
		this.w = w;
		return this;
	}
	
	/** Yöneyin bileşenlerini değiştirir. Yöneyi döndürür. */
	public Yöney4 yaz(final float x, final float y, final float z, final float w) {
		return yazX(x).yazY(y).yazZ(z).yazW(w);
	}
	
	/** Verilen yöneyi buna yazar. Bu yöneyi döndürür. */
	public Yöney4 yaz(final Yöney4 ö) {
		return this.yaz(ö.x, ö.y, ö.z, ö.w);
	}
	
	/** Verilen yöneyleri toplayıp buna yazar. Bu yöneyi döndürür. */
	public Yöney4 topla(final Yöney4 sol, final Yöney4 sağ) {
		return this.yaz(sol.x + sağ.x, sol.y + sağ.y, sol.z + sağ.z, sol.w + sağ.w);
	}
	
	/** Verilen yöneyi bu yöneye ekler. Bu yöneyi döndürür. */
	public Yöney4 topla(final Yöney4 ö) {
		return this.topla(this, ö);
	}
	
	/** Verilen yöneylerin çıkarıp buna yazar. Bu yöneyi döndürür. */
	public Yöney4 çıkar(final Yöney4 sol, final Yöney4 sağ) {
		return this.yaz(sol.x - sağ.x, sol.y - sağ.y, sol.z - sağ.z, sol.w - sağ.w);
	}
	
	/** Verilen yöneyi bu yöneyden çıkarır. Bu yöneyi döndürür. */
	public Yöney4 çıkar(final Yöney4 ö) {
		return this.çıkar(this, ö);
	}
	
	/** Verilen yöneyi sayıyla çarpıp buna yazar. Bu yöneyi döndürür. */
	public Yöney4 çarp(final Yöney4 sol, final float sağ) {
		return this.yaz(sol.x * sağ, sol.y * sağ, sol.z * sağ, sol.w * sağ);
	}
	
	/** Yöneyi sayıyla çarpar. Yöneyi döndürür. */
	public Yöney4 çarp(final float o) {
		return this.çarp(this, o);
	}
	
	/** Verilen yöneyi sayıya bölüp buna yazar. Bu yöneyi döndürür. */
	public Yöney4 böl(final Yöney4 sol, final float sağ) {
		return this.yaz(sol.x / sağ, sol.y / sağ, sol.z / sağ, sol.w / sağ);
	}
	
	/** Yöneyi sayıya böler. Yöneyi döndürür. */
	public Yöney4 böl(final float o) {
		return this.böl(this, o);
	}
	
	/** Verilen yöneylerin bileşenlerinden küçük olanlarını buna yazar. Bu yöneyi
	 * döndürür. */
	public Yöney4 küçüktür(final Yöney4 sol, final Yöney4 sağ) {
		return this.yaz(Hesaplayıcı.küçüktür(sol.x, sağ.x), Hesaplayıcı.küçüktür(sol.y, sağ.y),
				Hesaplayıcı.küçüktür(sol.z, sağ.z), Hesaplayıcı.küçüktür(sol.w, sağ.w));
	}
	
	/** Verilen yöneyin bileşenlerinden küçük olanlarını yazar. Bu yöneyi
	 * döndürür. */
	public Yöney4 küçüktür(final Yöney4 ö) {
		return this.küçüktür(this, ö);
	}
	
	/** Verilen yöneylerin bileşenlerinden büyük olanlarını buna yazar. Bu yöneyi
	 * döndürür. */
	public Yöney4 büyüktür(final Yöney4 sol, final Yöney4 sağ) {
		return this.yaz(Hesaplayıcı.büyüktür(sol.x, sağ.x), Hesaplayıcı.büyüktür(sol.y, sağ.y),
				Hesaplayıcı.büyüktür(sol.z, sağ.z), Hesaplayıcı.büyüktür(sol.w, sağ.w));
	}
	
	/** Verilen yöneyin bileşenlerinden büyük olanlarını yazar. Bu yöneyi
	 * döndürür. */
	public Yöney4 büyüktür(final Yöney4 ö) {
		return this.büyüktür(this, ö);
	}
	
	/** Verilen yöneyin bileşenlerini ayrı ayrı sıkıştırıp buna yazar. Bu yöneyi
	 * döndürür. */
	public Yöney4 sıkıştır(final Yöney4 ö, final Yöney4 alt, final Yöney4 üst) {
		return this.yaz(Hesaplayıcı.sıkıştır(ö.x, alt.x, üst.x), Hesaplayıcı.sıkıştır(ö.y, alt.y, üst.y),
				Hesaplayıcı.sıkıştır(ö.z, alt.z, üst.z), Hesaplayıcı.sıkıştır(ö.w, alt.w, üst.w));
	}
	
	/** Bu yöneyin bileşenlerini ayrı ayrı sıkıştırır. Bu yöneyi döndürür. */
	public Yöney4 sıkıştır(final Yöney4 alt, final Yöney4 üst) {
		return this.sıkıştır(this, alt, üst);
	}
	
	/** Verilen yöneyin bileşenlerini ayrı ayrı yuvarlayıp buna yazar. Bu yöneyi
	 * döndürür. */
	public Yöney4 yuvarla(final Yöney4 ö) {
		return this.yaz(Hesaplayıcı.yuvarla(ö.x), Hesaplayıcı.yuvarla(ö.y), Hesaplayıcı.yuvarla(ö.z),
				Hesaplayıcı.yuvarla(ö.w));
	}
	
	/** Yöneyin bileşenlerini ayrı ayrı yuvarlar. Yöneyi döndürür. */
	public Yöney4 yuvarla() {
		return this.yuvarla(this);
	}
	
	/** Verilen yöneyin bileşenlerini ayrı ayrı yukarı yuvarlayıp buna yazar. Bu
	 * yöneyi döndürür. */
	public Yöney4 tavan(final Yöney4 ö) {
		return this.yaz(Hesaplayıcı.tavan(ö.x), Hesaplayıcı.tavan(ö.y), Hesaplayıcı.tavan(ö.z), Hesaplayıcı.tavan(ö.w));
	}
	
	/** Yöneyin bileşenlerini ayrı ayrı yukarı yuvarlar. Yöneyi döndürür. */
	public Yöney4 tavan() {
		return this.tavan(this);
	}
	
	/** Verilen yöneyin bileşenlerini ayrı ayrı aşağı yuvarlayıp buna yazar. Bu
	 * yöneyi döndürür. */
	public Yöney4 taban(final Yöney4 ö) {
		return this.yaz(Hesaplayıcı.taban(ö.x), Hesaplayıcı.taban(ö.y), Hesaplayıcı.taban(ö.z), Hesaplayıcı.taban(ö.w));
	}
	
	/** Yöneyin bileşenlerini ayrı ayrı aşağı yuvarlar. Yöneyi döndürür. */
	public Yöney4 taban() {
		return this.taban(this);
	}
	
	/** Verilen yöneylerin aradeğerini buna yazar. Bu yöneyi döndürür. Mesafelerin
	 * toplamının bir olduğunu varsayar. */
	public Yöney4 aradeğer(final Yöney4 sol, final Yöney4 sağ, final float solaUzaklık, final float sağaUzaklık) {
		return this.yaz(Hesaplayıcı.aradeğer(sol.x, sağ.x, solaUzaklık, sağaUzaklık),
				Hesaplayıcı.aradeğer(sol.y, sağ.y, solaUzaklık, sağaUzaklık),
				Hesaplayıcı.aradeğer(sol.z, sağ.z, solaUzaklık, sağaUzaklık),
				Hesaplayıcı.aradeğer(sol.w, sağ.w, solaUzaklık, sağaUzaklık));
	}
	
	/** Verilen yöneyle bu yöneyin aradeğerini buna yazar. Bu yöneyi döndürür.
	 * Mesafelerin toplamının bir olduğunu varsayar. */
	public Yöney4 aradeğer(final Yöney4 ö, final float uzaklık, final float yakınlık) {
		return this.aradeğer(this, ö, uzaklık, yakınlık);
	}
	
	/** Verilen yöneyle bu yöneyin nokta çarpımını hesaplar. */
	public float nokta(final Yöney4 ö) {
		return x * ö.x + y * ö.y + z * ö.z + w * ö.w;
	}
	
	/** Yöneyin uzunluğunun karesini hesaplar. */
	public float uzunluğunKaresi() {
		return nokta(this);
	}
	
	/** Yöneyin uzunluğu hesaplar. */
	public float uzunluk() {
		return Hesaplayıcı.kökü(uzunluğunKaresi());
	}
	
	/** Verilen yöneyin doğrultusunu (birim yöneyini) buna yazar. Bu yöneyi
	 * döndürür. */
	public Yöney4 doğrultu(final Yöney4 ö) {
		return this.böl(ö, ö.uzunluk());
	}
	
	/** Yöneyin doğrultusunu (birim yöneyini) hesaplar. Bu yöneyi döndürür. */
	public Yöney4 doğrultu() {
		return this.böl(uzunluk());
	}
	
	/** Verilen bileşenlerin yöneyinkilere eşitliğini hesaplar. */
	public boolean eşittir(final float x, final float y, final float z, final float w) {
		return this.x == x && this.y == y && this.z == z && this.w == w;
	}
	
	/** Verilen yöneyin bu yöneye eşit olup olmadığını hesaplar. */
	public boolean eşittir(final Yöney4 ö) {
		return this.eşittir(ö.x, ö.y, ö.z, ö.w);
	}
	
	/** Yöneyi dizeye ekler. */
	public StringBuilder dize(final StringBuilder dize) {
		return dize.append('(').append(x).append(", ").append(y).append(", ").append(z).append(", ").append(w)
				.append(')');
	}
	
	/** Yöneyi dizeye çevirir. */
	public String dize() {
		return this.dize(new StringBuilder()).toString();
	}
	
	@Override
	public boolean equals(final Object obj) {
		return this.eşittir((Yöney4)obj);
	}
	
	@Override
	public String toString() {
		return this.dize();
	}
}
