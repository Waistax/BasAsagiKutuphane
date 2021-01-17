/**
 * başaşağıderebeyi.matematik.Yöney3.java
 * 0.3 / 16 Oca 2021 / 20:20:09
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.matematik;

/** Üç boyutlu bir yöneydir.
 * Bileşenler ondalıklı sayılar olarak saklanır. */
public class Yöney3 {
	/** Yöneyin birinci bileşenidir. */
	public float x;
	/** Yöneyin ikinci bileşenidir. */
	public float y;
	/** Yöneyin üçüncü bileşenidir. */
	public float z;
	
	/** Sıfır yöneyi tanımlar. */
	public Yöney3() {
	}
	
	/** Bileşenlerle tanımlar. */
	public Yöney3(float x, float y, float z) {
		yaz(
				x,
				y,
				z);
	}
	
	/** Verilenle aynı tanımlar. */
	public Yöney3(Yöney3 ö) {
		yaz(ö);
	}
	
	/** Yöneyin birinci bileşenini değiştirir.
	 * Yöneyi döndürür. */
	public Yöney3 yazX(float x) {
		this.x = x;
		return this;
	}
	
	/** Yöneyin ikinci bileşenini değiştirir.
	 * Yöneyi döndürür. */
	public Yöney3 yazY(float y) {
		this.y = y;
		return this;
	}
	
	/** Yöneyin üçüncü bileşenini değiştirir.
	 * Yöneyi döndürür. */
	public Yöney3 yazZ(float z) {
		this.z = z;
		return this;
	}
	
	/** Yöneyin bileşenlerini değiştirir.
	 * Yöneyi döndürür. */
	public Yöney3 yaz(float x, float y, float z) {
		return
				yazX(x).
				yazY(y).
				yazZ(z);
	}
	
	/** Verilen yöneyi buna yazar.
	 * Bu yöneyi döndürür. */
	public Yöney3 yaz(Yöney3 ö) {
		return yaz(
				ö.x,
				ö.y,
				ö.z);
	}
	
	/** Verilen yöneyleri toplayıp buna yazar.
	 * Bu yöneyi döndürür. */
	public Yöney3 topla(Yöney3 sol, Yöney3 sağ) {
		return yaz(
				sol.x + sağ.x,
				sol.y + sağ.y,
				sol.z + sağ.z);
	}
	
	/** Verilen yöneyi bu yöneye ekler.
	 * Bu yöneyi döndürür. */
	public Yöney3 topla(Yöney3 ö) {
		return topla(this, ö);
	}
	
	/** Verilen yöneylerin çıkarıp buna yazar.
	 * Bu yöneyi döndürür. */
	public Yöney3 çıkar(Yöney3 sol, Yöney3 sağ) {
		return yaz(
				sol.x - sağ.x,
				sol.y - sağ.y,
				sol.z - sağ.z);
	}
	
	/** Verilen yöneyi bu yöneyden çıkarır.
	 * Bu yöneyi döndürür. */
	public Yöney3 çıkar(Yöney3 ö) {
		return çıkar(this, ö);
	}
	
	/** Verilen yöneyi sayıyla çarpıp buna yazar.
	 * Bu yöneyi döndürür. */
	public Yöney3 çarp(Yöney3 sol, float sağ) {
		return yaz(
				sol.x * sağ,
				sol.y * sağ,
				sol.z * sağ);
	}
	
	/** Yöneyi sayıyla çarpar.
	 * Yöneyi döndürür. */
	public Yöney3 çarp(float o) {
		return çarp(this, o);
	}
	
	/** Verilen yöneyi sayıya bölüp buna yazar.
	 * Bu yöneyi döndürür. */
	public Yöney3 böl(Yöney3 sol, float sağ) {
		return yaz(
				sol.x / sağ,
				sol.y / sağ,
				sol.z / sağ);
	}
	
	/** Yöneyi sayıya böler.
	 * Yöneyi döndürür. */
	public Yöney3 böl(float o) {
		return böl(this, o);
	}
	
	/** Verilen yöneylerin bileşenlerinden küçük olanlarını buna yazar.
	 * Bu yöneyi döndürür. */
	public Yöney3 küçüktür(Yöney3 sol, Yöney3 sağ) {
		return yaz(
				Hesaplayıcı.küçüktür(sol.x, sağ.x),
				Hesaplayıcı.küçüktür(sol.y, sağ.y),
				Hesaplayıcı.küçüktür(sol.z, sağ.z));
	}
	
	/** Verilen yöneyin bileşenlerinden küçük olanlarını yazar.
	 * Bu yöneyi döndürür. */
	public Yöney3 küçüktür(Yöney3 ö) {
		return küçüktür(this, ö);
	}
	
	/** Verilen yöneylerin bileşenlerinden büyük olanlarını buna yazar.
	 * Bu yöneyi döndürür. */
	public Yöney3 büyüktür(Yöney3 sol, Yöney3 sağ) {
		return yaz(
				Hesaplayıcı.büyüktür(sol.x, sağ.x),
				Hesaplayıcı.büyüktür(sol.y, sağ.y),
				Hesaplayıcı.büyüktür(sol.z, sağ.z));
	}
	
	/** Verilen yöneyin bileşenlerinden büyük olanlarını yazar.
	 * Bu yöneyi döndürür. */
	public Yöney3 büyüktür(Yöney3 ö) {
		return büyüktür(this, ö);
	}
	
	/** Verilen yöneyin bileşenlerini ayrı ayrı sıkıştırıp buna yazar.
	 * Bu yöneyi döndürür. */
	public Yöney3 sıkıştır(Yöney3 ö, Yöney3 alt, Yöney3 üst) {
		return yaz(
				Hesaplayıcı.sıkıştır(ö.x, alt.x, üst.x),
				Hesaplayıcı.sıkıştır(ö.y, alt.y, üst.y),
				Hesaplayıcı.sıkıştır(ö.z, alt.z, üst.z));
	}
	
	/** Bu yöneyin bileşenlerini ayrı ayrı sıkıştırır.
	 * Bu yöneyi döndürür. */
	public Yöney3 sıkıştır(Yöney3 alt, Yöney3 üst) {
		return sıkıştır(this, alt, üst);
	}
	
	/** Verilen yöneyin bileşenlerini ayrı ayrı yuvarlayıp buna yazar.
	 * Bu yöneyi döndürür. */
	public Yöney3 yuvarla(Yöney3 ö) {
		return yaz(
				Hesaplayıcı.yuvarla(ö.x),
				Hesaplayıcı.yuvarla(ö.y),
				Hesaplayıcı.yuvarla(ö.z));
	}
	
	/** Yöneyin bileşenlerini ayrı ayrı yuvarlar.
	 * Yöneyi döndürür. */
	public Yöney3 yuvarla() {
		return yuvarla(this);
	}
	
	/** Verilen yöneyin bileşenlerini ayrı ayrı yukarı yuvarlayıp buna yazar.
	 * Bu yöneyi döndürür. */
	public Yöney3 tavan(Yöney3 ö) {
		return yaz(
				Hesaplayıcı.tavan(ö.x),
				Hesaplayıcı.tavan(ö.y),
				Hesaplayıcı.tavan(ö.z));
	}
	
	/** Yöneyin bileşenlerini ayrı ayrı yukarı yuvarlar.
	 * Yöneyi döndürür. */
	public Yöney3 tavan() {
		return tavan(this);
	}
	
	/** Verilen yöneyin bileşenlerini ayrı ayrı aşağı yuvarlayıp buna yazar.
	 * Bu yöneyi döndürür. */
	public Yöney3 taban(Yöney3 ö) {
		return yaz(
				Hesaplayıcı.taban(ö.x),
				Hesaplayıcı.taban(ö.y),
				Hesaplayıcı.taban(ö.z));
	}
	
	/** Yöneyin bileşenlerini ayrı ayrı aşağı yuvarlar.
	 * Yöneyi döndürür. */
	public Yöney3 taban() {
		return taban(this);
	}
	
	/** Verilen yöneylerin aradeğerini buna yazar.
	 * Bu yöneyi döndürür.
	 * Mesafelerin toplamının bir olduğunu öarsayar. */
	public Yöney3 aradeğer(Yöney3 sol, Yöney3 sağ, float solaUzaklık, float sağaUzaklık) {
		return yaz(
				Hesaplayıcı.aradeğer(sol.x, sağ.x, solaUzaklık, sağaUzaklık),
				Hesaplayıcı.aradeğer(sol.y, sağ.y, solaUzaklık, sağaUzaklık),
				Hesaplayıcı.aradeğer(sol.z, sağ.z, solaUzaklık, sağaUzaklık));
	}
	
	/** Verilen yöneyle bu yöneyin aradeğerini buna yazar.
	 * Bu yöneyi döndürür.
	 * Mesafelerin toplamının bir olduğunu öarsayar. */
	public Yöney3 aradeğer(Yöney3 ö, float uzaklık, float yakınlık) {
		return aradeğer(this, ö, uzaklık, yakınlık);
	}
	
	/** Verilen yöneyle bu yöneyin nokta çarpımını hesaplar. */
	public float nokta(Yöney3 ö) {
		return
				x * ö.x +
				y * ö.y +
				z * ö.z;
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
	public Yöney3 doğrultu(Yöney3 ö) {
		return böl(ö, ö.uzunluk());
	}
	
	/** Yöneyin doğrultusunu (birim yöneyini) hesaplar.
	 * Bu yöneyi döndürür. */
	public Yöney3 doğrultu() {
		return böl(uzunluk());
	}
	
	/** Verilen bileşenlerin yöneyinkilere eşitliğini hesaplar. */
	public boolean eşittir(float x, float y, float z) {
		return
				this.x == x &&
				this.y == y &&
				this.z == z;
	}
	
	/** Verilen yöneyin bu yöneye eşit olup olmadığını hesaplar. */
	public boolean eşittir(Yöney3 ö) {
		return eşittir(
				ö.x,
				ö.y,
				ö.z);
	}
	
	/** Yöneyi dizeye ekler. */
	public StringBuilder dize(StringBuilder dize) {
		return dize
				.append('(')
				.append(x)
				.append(", ")
				.append(y)
				.append(", ")
				.append(z)
				.append(')');
	}
	
	/** Yöneyi dizeye çevirir. */
	public String dize() {
		return dize(new StringBuilder()).toString();
	}
	
	@Override
	public boolean equals(Object obj) {
		return eşittir((Yöney3)obj);
	}
	
	@Override
	public String toString() {
		return dize();
	}
}
