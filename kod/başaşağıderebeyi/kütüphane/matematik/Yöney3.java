/**
 * başaşağıderebeyi.kütüphane.matematik.Yöney3.java
 * 0.3 / 16 Oca 2021 / 20:20:09
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.kütüphane.matematik;

/** Üç boyutlu bir yöney. Bileşenler ondalıklı sayılar olarak saklanır. */
public class Yöney3 {
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
		this.yaz(x, y, z);
	}
	
	/** Verilenle aynı tanımlar. */
	public Yöney3(final Yöney3 ö) {
		this.yaz(ö);
	}
	
	/** Yöneyin birinci bileşenini değiştirir. Yöneyi döndürür. */
	public Yöney3 yazX(final float x) {
		this.x = x;
		return this;
	}
	
	/** Yöneyin ikinci bileşenini değiştirir. Yöneyi döndürür. */
	public Yöney3 yazY(final float y) {
		this.y = y;
		return this;
	}
	
	/** Yöneyin üçüncü bileşenini değiştirir. Yöneyi döndürür. */
	public Yöney3 yazZ(final float z) {
		this.z = z;
		return this;
	}
	
	/** Yöneyin bileşenlerini değiştirir. Yöneyi döndürür. */
	public Yöney3 yaz(final float x, final float y, final float z) {
		return this.yazX(x).yazY(y).yazZ(z);
	}
	
	/** Verilen yöneyi buna yazar. Bu yöneyi döndürür. */
	public Yöney3 yaz(final Yöney3 ö) {
		return this.yaz(ö.x, ö.y, ö.z);
	}
	
	/** Verilen yöneyleri toplayıp buna yazar. Bu yöneyi döndürür. */
	public Yöney3 topla(final Yöney3 sol, final Yöney3 sağ) {
		return this.yaz(sol.x + sağ.x, sol.y + sağ.y, sol.z + sağ.z);
	}
	
	/** Verilen yöneyi bu yöneye ekler. Bu yöneyi döndürür. */
	public Yöney3 topla(final Yöney3 ö) {
		return this.topla(this, ö);
	}
	
	/** Verilen yöneylerin çıkarıp buna yazar. Bu yöneyi döndürür. */
	public Yöney3 çıkar(final Yöney3 sol, final Yöney3 sağ) {
		return this.yaz(sol.x - sağ.x, sol.y - sağ.y, sol.z - sağ.z);
	}
	
	/** Verilen yöneyi bu yöneyden çıkarır. Bu yöneyi döndürür. */
	public Yöney3 çıkar(final Yöney3 ö) {
		return this.çıkar(this, ö);
	}
	
	/** Verilen yöneyi sayıyla çarpıp buna yazar. Bu yöneyi döndürür. */
	public Yöney3 çarp(final Yöney3 sol, final float sağ) {
		return this.yaz(sol.x * sağ, sol.y * sağ, sol.z * sağ);
	}
	
	/** Yöneyi sayıyla çarpar. Yöneyi döndürür. */
	public Yöney3 çarp(final float o) {
		return this.çarp(this, o);
	}
	
	/** Verilen yöneyi sayıya bölüp buna yazar. Bu yöneyi döndürür. */
	public Yöney3 böl(final Yöney3 sol, final float sağ) {
		return this.yaz(sol.x / sağ, sol.y / sağ, sol.z / sağ);
	}
	
	/** Yöneyi sayıya böler. Yöneyi döndürür. */
	public Yöney3 böl(final float o) {
		return this.böl(this, o);
	}
	
	/** Verilen yöneylerin bileşenlerinden küçük olanlarını buna yazar. Bu yöneyi
	 * döndürür. */
	public Yöney3 küçüktür(final Yöney3 sol, final Yöney3 sağ) {
		return this.yaz(Hesaplayıcı.küçüktür(sol.x, sağ.x), Hesaplayıcı.küçüktür(sol.y, sağ.y),
				Hesaplayıcı.küçüktür(sol.z, sağ.z));
	}
	
	/** Verilen yöneyin bileşenlerinden küçük olanlarını yazar. Bu yöneyi
	 * döndürür. */
	public Yöney3 küçüktür(final Yöney3 ö) {
		return this.küçüktür(this, ö);
	}
	
	/** Verilen yöneylerin bileşenlerinden büyük olanlarını buna yazar. Bu yöneyi
	 * döndürür. */
	public Yöney3 büyüktür(final Yöney3 sol, final Yöney3 sağ) {
		return this.yaz(Hesaplayıcı.büyüktür(sol.x, sağ.x), Hesaplayıcı.büyüktür(sol.y, sağ.y),
				Hesaplayıcı.büyüktür(sol.z, sağ.z));
	}
	
	/** Verilen yöneyin bileşenlerinden büyük olanlarını yazar. Bu yöneyi
	 * döndürür. */
	public Yöney3 büyüktür(final Yöney3 ö) {
		return this.büyüktür(this, ö);
	}
	
	/** Verilen yöneyin bileşenlerini ayrı ayrı sıkıştırıp buna yazar. Bu yöneyi
	 * döndürür. */
	public Yöney3 sıkıştır(final Yöney3 ö, final Yöney3 alt, final Yöney3 üst) {
		return this.yaz(Hesaplayıcı.sıkıştır(ö.x, alt.x, üst.x), Hesaplayıcı.sıkıştır(ö.y, alt.y, üst.y),
				Hesaplayıcı.sıkıştır(ö.z, alt.z, üst.z));
	}
	
	/** Bu yöneyin bileşenlerini ayrı ayrı sıkıştırır. Bu yöneyi döndürür. */
	public Yöney3 sıkıştır(final Yöney3 alt, final Yöney3 üst) {
		return this.sıkıştır(this, alt, üst);
	}
	
	/** Verilen yöneyin bileşenlerini ayrı ayrı yuvarlayıp buna yazar. Bu yöneyi
	 * döndürür. */
	public Yöney3 yuvarla(final Yöney3 ö) {
		return this.yaz(Hesaplayıcı.yuvarla(ö.x), Hesaplayıcı.yuvarla(ö.y), Hesaplayıcı.yuvarla(ö.z));
	}
	
	/** Yöneyin bileşenlerini ayrı ayrı yuvarlar. Yöneyi döndürür. */
	public Yöney3 yuvarla() {
		return this.yuvarla(this);
	}
	
	/** Verilen yöneyin bileşenlerini ayrı ayrı yukarı yuvarlayıp buna yazar. Bu
	 * yöneyi döndürür. */
	public Yöney3 tavan(final Yöney3 ö) {
		return this.yaz(Hesaplayıcı.tavan(ö.x), Hesaplayıcı.tavan(ö.y), Hesaplayıcı.tavan(ö.z));
	}
	
	/** Yöneyin bileşenlerini ayrı ayrı yukarı yuvarlar. Yöneyi döndürür. */
	public Yöney3 tavan() {
		return this.tavan(this);
	}
	
	/** Verilen yöneyin bileşenlerini ayrı ayrı aşağı yuvarlayıp buna yazar. Bu
	 * yöneyi döndürür. */
	public Yöney3 taban(final Yöney3 ö) {
		return this.yaz(Hesaplayıcı.taban(ö.x), Hesaplayıcı.taban(ö.y), Hesaplayıcı.taban(ö.z));
	}
	
	/** Yöneyin bileşenlerini ayrı ayrı aşağı yuvarlar. Yöneyi döndürür. */
	public Yöney3 taban() {
		return this.taban(this);
	}
	
	/** Verilen yöneylerin aradeğerini buna yazar. Bu yöneyi döndürür. Mesafelerin
	 * toplamının bir olduğunu öarsayar. */
	public Yöney3 aradeğer(final Yöney3 sol, final Yöney3 sağ, final float solaUzaklık, final float sağaUzaklık) {
		return this.yaz(Hesaplayıcı.aradeğer(sol.x, sağ.x, solaUzaklık, sağaUzaklık),
				Hesaplayıcı.aradeğer(sol.y, sağ.y, solaUzaklık, sağaUzaklık),
				Hesaplayıcı.aradeğer(sol.z, sağ.z, solaUzaklık, sağaUzaklık));
	}
	
	/** Verilen yöneyle bu yöneyin aradeğerini buna yazar. Bu yöneyi döndürür.
	 * Mesafelerin toplamının bir olduğunu öarsayar. */
	public Yöney3 aradeğer(final Yöney3 ö, final float uzaklık, final float yakınlık) {
		return this.aradeğer(this, ö, uzaklık, yakınlık);
	}
	
	/** Verilen yöneyle bu yöneyin nokta çarpımını hesaplar. */
	public float nokta(final Yöney3 ö) {
		return this.x * ö.x + this.y * ö.y + this.z * ö.z;
	}
	
	/** Yöneyin uzunluğunun karesini hesaplar. */
	public float uzunluğunKaresi() {
		return this.nokta(this);
	}
	
	/** Yöneyin uzunluğu hesaplar. */
	public float uzunluk() {
		return Hesaplayıcı.kökü(this.uzunluğunKaresi());
	}
	
	/** Verilen yöneyin doğrultusunu (birim yöneyini) buna yazar. Bu yöneyi
	 * döndürür. */
	public Yöney3 doğrultu(final Yöney3 ö) {
		return this.böl(ö, ö.uzunluk());
	}
	
	/** Yöneyin doğrultusunu (birim yöneyini) hesaplar. Bu yöneyi döndürür. */
	public Yöney3 doğrultu() {
		return this.böl(this.uzunluk());
	}
	
	/** Verilen bileşenlerin yöneyinkilere eşitliğini hesaplar. */
	public boolean eşittir(final float x, final float y, final float z) {
		return this.x == x && this.y == y && this.z == z;
	}
	
	/** Verilen yöneyin bu yöneye eşit olup olmadığını hesaplar. */
	public boolean eşittir(final Yöney3 ö) {
		return this.eşittir(ö.x, ö.y, ö.z);
	}
	
	/** Yöneyi dizeye ekler. */
	public StringBuilder dize(final StringBuilder dize) {
		return dize.append('(').append(this.x).append(", ").append(this.y).append(", ").append(this.z).append(')');
	}
	
	/** Yöneyi dizeye çevirir. */
	public String dize() {
		return this.dize(new StringBuilder()).toString();
	}
	
	@Override
	public boolean equals(final Object obj) {
		return this.eşittir((Yöney3)obj);
	}
	
	@Override
	public String toString() {
		return this.dize();
	}
}
