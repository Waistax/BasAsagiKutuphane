/**
 * başaşağıderebeyi.matematik.Yöney2.java
 * 0.2 / 16 Oca 2021 / 13:07:13
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 * 
 * BaşAşağıMotor'dan alındı.
 * 0.13 / 8 Eyl 2020 / 09:16:17
 */
package başaşağıderebeyi.matematik;

/** İki boyutlu bir yöney.
 * Bileşenler ondalıklı sayılar olarak saklanır. */
public class Yöney2 {
	/** Yöneyin birinci bileşeni. */
	public float x;
	/** Yöneyin ikinci bileşeni. */
	public float y;
	
	/** Sıfır yöneyi tanımlar. */
	public Yöney2() {
	}
	
	/** Bileşenlerle tanımlar. */
	public Yöney2(float x, float y) {
		yaz(
				x,
				y);
	}
	
	/** Verilenle aynı tanımlar. */
	public Yöney2(Yöney2 ö) {
		yaz(ö);
	}
	
	/** Yöneyin birinci bileşenini değiştirir.
	 * Yöneyi döndürür. */
	public Yöney2 yazX(float x) {
		this.x = x;
		return this;
	}
	
	/** Yöneyin ikinci bileşenini değiştirir.
	 * Yöneyi döndürür. */
	public Yöney2 yazY(float y) {
		this.y = y;
		return this;
	}
	
	/** Yöneyin bileşenlerini değiştirir.
	 * Yöneyi döndürür. */
	public Yöney2 yaz(float x, float y) {
		return
				yazX(x).
				yazY(y);
	}
	
	/** Verilen yöneyi buna yazar.
	 * Bu yöneyi döndürür. */
	public Yöney2 yaz(Yöney2 ö) {
		return yaz(
				ö.x,
				ö.y);
	}
	
	/** Verilen yöneyleri toplayıp buna yazar.
	 * Bu yöneyi döndürür. */
	public Yöney2 topla(Yöney2 sol, Yöney2 sağ) {
		return yaz(
				sol.x + sağ.x,
				sol.y + sağ.y);
	}
	
	/** Verilen yöneyi bu yöneye ekler.
	 * Bu yöneyi döndürür. */
	public Yöney2 topla(Yöney2 ö) {
		return topla(this, ö);
	}
	
	/** Verilen yöneyleri çıkarıp buna yazar.
	 * Bu yöneyi döndürür. */
	public Yöney2 çıkar(Yöney2 sol, Yöney2 sağ) {
		return yaz(
				sol.x - sağ.x,
				sol.y - sağ.y);
	}
	
	/** Verilen yöneyi bu yöneyden çıkarır.
	 * Bu yöneyi döndürür. */
	public Yöney2 çıkar(Yöney2 ö) {
		return çıkar(this, ö);
	}
	
	/** Verilen yöneyi sayıyla çarpıp buna yazar.
	 * Bu yöneyi döndürür. */
	public Yöney2 çarp(Yöney2 sol, float sağ) {
		return yaz(
				sol.x * sağ,
				sol.y * sağ);
	}
	
	/** Yöneyi sayıyla çarpar.
	 * Yöneyi döndürür. */
	public Yöney2 çarp(float o) {
		return çarp(this, o);
	}
	
	/** Verilen yöneyi sayıya bölüp buna yazar.
	 * Bu yöneyi döndürür. */
	public Yöney2 böl(Yöney2 sol, float sağ) {
		return yaz(
				sol.x / sağ,
				sol.y / sağ);
	}
	
	/** Yöneyi sayıya böler.
	 * Yöneyi döndürür. */
	public Yöney2 böl(float o) {
		return böl(this, o);
	}
	
	/** Verilen yöneylerin bileşenlerinden küçük olanlarını buna yazar.
	 * Bu yöneyi döndürür. */
	public Yöney2 küçüktür(Yöney2 sol, Yöney2 sağ) {
		return yaz(
				Hesaplayıcı.küçüktür(sol.x, sağ.x),
				Hesaplayıcı.küçüktür(sol.y, sağ.y));
	}
	
	/** Verilen yöneyin bileşenlerinden küçük olanlarını yazar.
	 * Bu yöneyi döndürür. */
	public Yöney2 küçüktür(Yöney2 ö) {
		return küçüktür(this, ö);
	}
	
	/** Verilen yöneylerin bileşenlerinden büyük olanlarını buna yazar.
	 * Bu yöneyi döndürür. */
	public Yöney2 büyüktür(Yöney2 sol, Yöney2 sağ) {
		return yaz(
				Hesaplayıcı.büyüktür(sol.x, sağ.x),
				Hesaplayıcı.büyüktür(sol.y, sağ.y));
	}
	
	/** Verilen yöneyin bileşenlerinden büyük olanlarını yazar.
	 * Bu yöneyi döndürür. */
	public Yöney2 büyüktür(Yöney2 ö) {
		return büyüktür(this, ö);
	}
	
	/** Verilen yöneyin bileşenlerini ayrı ayrı sıkıştırıp buna yazar.
	 * Bu yöneyi döndürür. */
	public Yöney2 sıkıştır(Yöney2 ö, Yöney2 alt, Yöney2 üst) {
		return yaz(
				Hesaplayıcı.sıkıştır(ö.x, alt.x, üst.x),
				Hesaplayıcı.sıkıştır(ö.y, alt.y, üst.y));
	}
	
	/** Bu yöneyin bileşenlerini ayrı ayrı sıkıştırır.
	 * Bu yöneyi döndürür. */
	public Yöney2 sıkıştır(Yöney2 alt, Yöney2 üst) {
		return sıkıştır(this, alt, üst);
	}
	
	/** Verilen yöneyin bileşenlerini ayrı ayrı yuvarlayıp buna yazar.
	 * Bu yöneyi döndürür. */
	public Yöney2 yuvarla(Yöney2 ö) {
		return yaz(
				Hesaplayıcı.yuvarla(ö.x),
				Hesaplayıcı.yuvarla(ö.y));
	}
	
	/** Yöneyin bileşenlerini ayrı ayrı yuvarlar.
	 * Yöneyi döndürür. */
	public Yöney2 yuvarla() {
		return yuvarla(this);
	}
	
	/** Verilen yöneyin bileşenlerini ayrı ayrı yukarı yuvarlayıp buna yazar.
	 * Bu yöneyi döndürür. */
	public Yöney2 tavan(Yöney2 ö) {
		return yaz(
				Hesaplayıcı.tavan(ö.x),
				Hesaplayıcı.tavan(ö.x));
	}
	
	/** Yöneyin bileşenlerini ayrı ayrı yukarı yuvarlar.
	 * Yöneyi döndürür. */
	public Yöney2 tavan() {
		return tavan(this);
	}
	
	/** Verilen yöneyin bileşenlerini ayrı ayrı aşağı yuvarlayıp buna yazar.
	 * Bu yöneyi döndürür. */
	public Yöney2 taban(Yöney2 ö) {
		return yaz(
				Hesaplayıcı.taban(ö.x),
				Hesaplayıcı.taban(ö.x));
	}
	
	/** Yöneyin bileşenlerini ayrı ayrı aşağı yuvarlar.
	 * Yöneyi döndürür. */
	public Yöney2 taban() {
		return taban(this);
	}
	
	/** Verilen yöneylerin aradeğerini buna yazar.
	 * Bu yöneyi döndürür.
	 * Mesafelerin toplamının bir olduğunu varsayar. */
	public Yöney2 aradeğer(Yöney2 sol, Yöney2 sağ, float solaUzaklık, float sağaUzaklık) {
		return yaz(
				Hesaplayıcı.aradeğer(sol.x, sağ.x, solaUzaklık, sağaUzaklık),
				Hesaplayıcı.aradeğer(sol.y, sağ.y, solaUzaklık, sağaUzaklık));
	}
	
	/** Verilen yöneyle bu yöneyin aradeğerini buna yazar.
	 * Bu yöneyi döndürür.
	 * Mesafelerin toplamının bir olduğunu varsayar. */
	public Yöney2 aradeğer(Yöney2 ö, float uzaklık, float yakınlık) {
		return aradeğer(this, ö, uzaklık, yakınlık);
	}
	
	/** Verilen yöneyle bu yöneyin nokta çarpımını hesaplar. */
	public float nokta(Yöney2 ö) {
		return
				x * ö.x +
				y * ö.y;
	}
	
	/** Yöneyin uzunluğunun karesini hesaplar. */
	public float uzunluğunKaresi() {
		return nokta(this);
	}
	
	/** Yöneyin uzunluğu hesaplar. */
	public float uzunluk() {
		return Hesaplayıcı.kökü(uzunluğunKaresi());
	}
	
	/** Verilen yöneyin doğrultusunu (birim yöneyini) buna yazar.
	 * Bu yöneyi döndürür. */
	public Yöney2 doğrultu(Yöney2 ö) {
		return böl(ö, ö.uzunluk());
	}
	
	/** Yöneyin doğrultusunu (birim yöneyini) hesaplar.
	 * Bu yöneyi döndürür. */
	public Yöney2 doğrultu() {
		return böl(uzunluk());
	}
	
	/** Verilen bileşenlerin yöneyinkilere eşitliğini hesaplar. */
	public boolean eşittir(float x, float y) {
		return
				this.x == x &&
				this.y == y;
	}
	
	/** Verilen yöneyin bu yöneye eşit olup olmadığını hesaplar. */
	public boolean eşittir(Yöney2 ö) {
		return eşittir(
				ö.x,
				ö.y);
	}
	
	/** Yöneyi dizeye ekler. */
	public StringBuilder dize(StringBuilder dize) {
		return dize
				.append('(')
				.append(x)
				.append(", ")
				.append(y)
				.append(')');
	}
	
	/** Yöneyi dizeye çevirir. */
	public String dize() {
		return dize(new StringBuilder()).toString();
	}
	
	@Override
	public boolean equals(Object obj) {
		return eşittir((Yöney2)obj);
	}
	
	@Override
	public String toString() {
		return dize();
	}
}
