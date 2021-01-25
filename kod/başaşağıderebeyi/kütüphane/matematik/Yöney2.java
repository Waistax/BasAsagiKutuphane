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
	/** Yöneyin birinci bileşeni. */
	public float x;
	/** Yöneyin ikinci bileşeni. */
	public float y;
	
	/** Sıfır yöneyi tanımlar. */
	public Yöney2() {
	}
	
	/** Bileşenlerle tanımlar. */
	public Yöney2(final float x, final float y) {
		this.yaz(x, y);
	}
	
	/** Verilenle aynı tanımlar. */
	public Yöney2(final Yöney2 ö) {
		this.yaz(ö);
	}
	
	/** Yöneyin birinci bileşenini değiştirir. Yöneyi döndürür. */
	public Yöney2 yazX(final float x) {
		this.x = x;
		return this;
	}
	
	/** Yöneyin ikinci bileşenini değiştirir. Yöneyi döndürür. */
	public Yöney2 yazY(final float y) {
		this.y = y;
		return this;
	}
	
	/** Yöneyin bileşenlerini değiştirir. Yöneyi döndürür. */
	public Yöney2 yaz(final float x, final float y) {
		return this.yazX(x).yazY(y);
	}
	
	/** Verilen yöneyi buna yazar. Bu yöneyi döndürür. */
	public Yöney2 yaz(final Yöney2 ö) {
		return this.yaz(ö.x, ö.y);
	}
	
	/** Verilen yöneyleri toplayıp buna yazar. Bu yöneyi döndürür. */
	public Yöney2 topla(final Yöney2 sol, final Yöney2 sağ) {
		return this.yaz(sol.x + sağ.x, sol.y + sağ.y);
	}
	
	/** Verilen yöneyi bu yöneye ekler. Bu yöneyi döndürür. */
	public Yöney2 topla(final Yöney2 ö) {
		return this.topla(this, ö);
	}
	
	/** Verilen yöneyleri çıkarıp buna yazar. Bu yöneyi döndürür. */
	public Yöney2 çıkar(final Yöney2 sol, final Yöney2 sağ) {
		return this.yaz(sol.x - sağ.x, sol.y - sağ.y);
	}
	
	/** Verilen yöneyi bu yöneyden çıkarır. Bu yöneyi döndürür. */
	public Yöney2 çıkar(final Yöney2 ö) {
		return this.çıkar(this, ö);
	}
	
	/** Verilen yöneyi sayıyla çarpıp buna yazar. Bu yöneyi döndürür. */
	public Yöney2 çarp(final Yöney2 sol, final float sağ) {
		return this.yaz(sol.x * sağ, sol.y * sağ);
	}
	
	/** Yöneyi sayıyla çarpar. Yöneyi döndürür. */
	public Yöney2 çarp(final float o) {
		return this.çarp(this, o);
	}
	
	/** Verilen yöneyi sayıya bölüp buna yazar. Bu yöneyi döndürür. */
	public Yöney2 böl(final Yöney2 sol, final float sağ) {
		return this.yaz(sol.x / sağ, sol.y / sağ);
	}
	
	/** Yöneyi sayıya böler. Yöneyi döndürür. */
	public Yöney2 böl(final float o) {
		return this.böl(this, o);
	}
	
	/** Verilen yöneylerin bileşenlerinden küçük olanlarını buna yazar. Bu yöneyi
	 * döndürür. */
	public Yöney2 küçüktür(final Yöney2 sol, final Yöney2 sağ) {
		return this.yaz(Hesaplayıcı.küçüktür(sol.x, sağ.x), Hesaplayıcı.küçüktür(sol.y, sağ.y));
	}
	
	/** Verilen yöneyin bileşenlerinden küçük olanlarını yazar. Bu yöneyi
	 * döndürür. */
	public Yöney2 küçüktür(final Yöney2 ö) {
		return this.küçüktür(this, ö);
	}
	
	/** Verilen yöneylerin bileşenlerinden büyük olanlarını buna yazar. Bu yöneyi
	 * döndürür. */
	public Yöney2 büyüktür(final Yöney2 sol, final Yöney2 sağ) {
		return this.yaz(Hesaplayıcı.büyüktür(sol.x, sağ.x), Hesaplayıcı.büyüktür(sol.y, sağ.y));
	}
	
	/** Verilen yöneyin bileşenlerinden büyük olanlarını yazar. Bu yöneyi
	 * döndürür. */
	public Yöney2 büyüktür(final Yöney2 ö) {
		return this.büyüktür(this, ö);
	}
	
	/** Verilen yöneyin bileşenlerini ayrı ayrı sıkıştırıp buna yazar. Bu yöneyi
	 * döndürür. */
	public Yöney2 sıkıştır(final Yöney2 ö, final Yöney2 alt, final Yöney2 üst) {
		return this.yaz(Hesaplayıcı.sıkıştır(ö.x, alt.x, üst.x), Hesaplayıcı.sıkıştır(ö.y, alt.y, üst.y));
	}
	
	/** Bu yöneyin bileşenlerini ayrı ayrı sıkıştırır. Bu yöneyi döndürür. */
	public Yöney2 sıkıştır(final Yöney2 alt, final Yöney2 üst) {
		return this.sıkıştır(this, alt, üst);
	}
	
	/** Verilen yöneyin bileşenlerini ayrı ayrı yuvarlayıp buna yazar. Bu yöneyi
	 * döndürür. */
	public Yöney2 yuvarla(final Yöney2 ö) {
		return this.yaz(Hesaplayıcı.yuvarla(ö.x), Hesaplayıcı.yuvarla(ö.y));
	}
	
	/** Yöneyin bileşenlerini ayrı ayrı yuvarlar. Yöneyi döndürür. */
	public Yöney2 yuvarla() {
		return this.yuvarla(this);
	}
	
	/** Verilen yöneyin bileşenlerini ayrı ayrı yukarı yuvarlayıp buna yazar. Bu
	 * yöneyi döndürür. */
	public Yöney2 tavan(final Yöney2 ö) {
		return this.yaz(Hesaplayıcı.tavan(ö.x), Hesaplayıcı.tavan(ö.x));
	}
	
	/** Yöneyin bileşenlerini ayrı ayrı yukarı yuvarlar. Yöneyi döndürür. */
	public Yöney2 tavan() {
		return this.tavan(this);
	}
	
	/** Verilen yöneyin bileşenlerini ayrı ayrı aşağı yuvarlayıp buna yazar. Bu
	 * yöneyi döndürür. */
	public Yöney2 taban(final Yöney2 ö) {
		return this.yaz(Hesaplayıcı.taban(ö.x), Hesaplayıcı.taban(ö.x));
	}
	
	/** Yöneyin bileşenlerini ayrı ayrı aşağı yuvarlar. Yöneyi döndürür. */
	public Yöney2 taban() {
		return this.taban(this);
	}
	
	/** Verilen yöneylerin aradeğerini buna yazar. Bu yöneyi döndürür. Mesafelerin
	 * toplamının bir olduğunu varsayar. */
	public Yöney2 aradeğer(final Yöney2 sol, final Yöney2 sağ, final float solaUzaklık, final float sağaUzaklık) {
		return this.yaz(Hesaplayıcı.aradeğer(sol.x, sağ.x, solaUzaklık, sağaUzaklık),
				Hesaplayıcı.aradeğer(sol.y, sağ.y, solaUzaklık, sağaUzaklık));
	}
	
	/** Verilen yöneyle bu yöneyin aradeğerini buna yazar. Bu yöneyi döndürür.
	 * Mesafelerin toplamının bir olduğunu varsayar. */
	public Yöney2 aradeğer(final Yöney2 ö, final float uzaklık, final float yakınlık) {
		return this.aradeğer(this, ö, uzaklık, yakınlık);
	}
	
	/** Verilen yöneyle bu yöneyin nokta çarpımını hesaplar. */
	public float nokta(final Yöney2 ö) {
		return this.x * ö.x + this.y * ö.y;
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
	public Yöney2 doğrultu(final Yöney2 ö) {
		return this.böl(ö, ö.uzunluk());
	}
	
	/** Yöneyin doğrultusunu (birim yöneyini) hesaplar. Bu yöneyi döndürür. */
	public Yöney2 doğrultu() {
		return this.böl(this.uzunluk());
	}
	
	/** Verilen bileşenlerin yöneyinkilere eşitliğini hesaplar. */
	public boolean eşittir(final float x, final float y) {
		return this.x == x && this.y == y;
	}
	
	/** Verilen yöneyin bu yöneye eşit olup olmadığını hesaplar. */
	public boolean eşittir(final Yöney2 ö) {
		return this.eşittir(ö.x, ö.y);
	}
	
	/** Yöneyi dizeye ekler. */
	public StringBuilder dize(final StringBuilder dize) {
		return dize.append('(').append(this.x).append(", ").append(this.y).append(')');
	}
	
	/** Yöneyi dizeye çevirir. */
	public String dize() {
		return this.dize(new StringBuilder()).toString();
	}
	
	@Override
	public boolean equals(final Object obj) {
		return this.eşittir((Yöney2)obj);
	}
	
	@Override
	public String toString() {
		return this.dize();
	}
}
