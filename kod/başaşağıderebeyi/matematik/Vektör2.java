/**
 * başaşağıderebeyi.matematik.Vektör2.java
 * 0.2 / 16 Oca 2021 / 13:07:13
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 * 
 * BaşAşağıMotor'dan alındı.
 * 0.13 / 8 Eyl 2020 / 09:16:17
 */
package başaşağıderebeyi.matematik;

/**
 * İki boyutlu bir vektörü temsil eder.
 * Bileşenler ondalıklı sayılar olarak saklanır.
 */
public class Vektör2 {
	/** Vektörün birinci bileşenidir. */
	public float x;
	/** Vektörün ikinci bileşenidir. */
	public float y;
	
	/**
	 * Sıfır vektörü tanımlar.
	 */
	public Vektör2() {
	}
	
	/**
	 * Bileşenlerle tanımlar.
	 */
	public Vektör2(float x, float y) {
		yaz(
				x,
				y);
	}
	
	/**
	 * Verilenle aynı tanımlar.
	 */
	public Vektör2(Vektör2 v) {
		yaz(v);
	}
	
	/**
	 * Vektörün birinci bileşenini değiştirir.
	 * Vektörü döndürür.
	 */
	public Vektör2 yazX(float x) {
		this.x = x;
		return this;
	}
	
	/**
	 * Vektörün ikinci bileşenini değiştirir.
	 * Vektörü döndürür.
	 */
	public Vektör2 yazY(float y) {
		this.y = y;
		return this;
	}
	
	/**
	 * Vektörün bileşenlerini değiştirir.
	 * Vektörü döndürür.
	 */
	public Vektör2 yaz(float x, float y) {
		return
				yazX(x).
				yazY(y);
	}
	
	/**
	 * Verilen vektörü buna yazar.
	 * Bu vektörü döndürür.
	 */
	public Vektör2 yaz(Vektör2 v) {
		return yaz(
				v.x,
				v.y);
	}
	
	/**
	 * Verilen vektörleri toplayıp buna yazar.
	 * Bu vektörü döndürür.
	 */
	public Vektör2 topla(Vektör2 sol, Vektör2 sağ) {
		return yaz(
				sol.x + sağ.x,
				sol.y + sağ.y);
	}
	
	/**
	 * Verilen vektörü bu vektöre ekler.
	 * Bu vektörü döndürür.
	 */
	public Vektör2 topla(Vektör2 v) {
		return topla(this, v);
	}
	
	/**
	 * Verilen vektörlerin çıkarıp buna yazar.
	 * Bu vektörü döndürür.
	 */
	public Vektör2 çıkar(Vektör2 sol, Vektör2 sağ) {
		return yaz(
				sol.x - sağ.x,
				sol.y - sağ.y);
	}
	
	/**
	 * Verilen vektörü bu vektörden çıkarır.
	 * Bu vektörü döndürür.
	 */
	public Vektör2 çıkar(Vektör2 v) {
		return çıkar(this, v);
	}
	
	/**
	 * Verilen vektörü sayıyla çarpıp buna yazar.
	 * Bu vektörü döndürür.
	 */
	public Vektör2 çarp(Vektör2 sol, float sağ) {
		return yaz(
				sol.x * sağ,
				sol.y * sağ);
	}
	
	/**
	 * Vektörü sayıyla çarpar.
	 * Vektörü döndürür.
	 */
	public Vektör2 çarp(float o) {
		return çarp(this, o);
	}
	
	/**
	 * Verilen vektörü sayıya bölüp buna yazar.
	 * Bu vektörü döndürür.
	 */
	public Vektör2 böl(Vektör2 sol, float sağ) {
		return yaz(
				sol.x / sağ,
				sol.y / sağ);
	}
	
	/**
	 * Vektörü sayıya böler.
	 * Vektörü döndürür.
	 */
	public Vektör2 böl(float o) {
		return böl(this, o);
	}
	
	/**
	 * Verilen vektörlerin bileşenlerinden küçük olanlarını buna yazar.
	 * Bu vektörü döndürür.
	 */
	public Vektör2 küçüktür(Vektör2 sol, Vektör2 sağ) {
		return yaz(
				Hesaplayıcı.küçüktür(sol.x, sağ.x),
				Hesaplayıcı.küçüktür(sol.y, sağ.y));
	}
	
	/**
	 * Verilen vektörün bileşenlerinden küçük olanlarını yazar.
	 * Bu vektörü döndürür.
	 */
	public Vektör2 küçüktür(Vektör2 v) {
		return küçüktür(this, v);
	}
	
	/**
	 * Verilen vektörlerin bileşenlerinden büyük olanlarını buna yazar.
	 * Bu vektörü döndürür.
	 */
	public Vektör2 büyüktür(Vektör2 sol, Vektör2 sağ) {
		return yaz(
				Hesaplayıcı.büyüktür(sol.x, sağ.x),
				Hesaplayıcı.büyüktür(sol.y, sağ.y));
	}
	
	/**
	 * Verilen vektörün bileşenlerinden büyük olanlarını yazar.
	 * Bu vektörü döndürür.
	 */
	public Vektör2 büyüktür(Vektör2 v) {
		return büyüktür(this, v);
	}
	
	/**
	 * Verilen vektörün bileşenlerini ayrı ayrı sıkıştırıp buna yazar.
	 * Bu vektörü döndürür.
	 */
	public Vektör2 sıkıştır(Vektör2 v, Vektör2 alt, Vektör2 üst) {
		return yaz(
				Hesaplayıcı.sıkıştır(v.x, alt.x, üst.x),
				Hesaplayıcı.sıkıştır(v.y, alt.y, üst.y));
	}
	
	/**
	 * Bu vektörün bileşenlerini ayrı ayrı sıkıştırır.
	 * Bu vektörü döndürür.
	 */
	public Vektör2 sıkıştır(Vektör2 alt, Vektör2 üst) {
		return sıkıştır(this, alt, üst);
	}
	
	/**
	 * Verilen vektörün bileşenlerini ayrı ayrı yuvarlayıp buna yazar.
	 * Bu vektörü döndürür.
	 */
	public Vektör2 yuvarla(Vektör2 v) {
		return yaz(
				Hesaplayıcı.yuvarla(v.x),
				Hesaplayıcı.yuvarla(v.y));
	}
	
	/**
	 * Bu vektörün bileşenlerini ayrı ayrı yuvarlar.
	 * Bu vektörü döndürür.
	 */
	public Vektör2 yuvarla() {
		return yuvarla(this);
	}
	
	/**
	 * Verilen vektörün bileşenlerini ayrı ayrı yukarı yuvarlayıp buna yazar.
	 * Bu vektörü döndürür.
	 */
	public Vektör2 tavan(Vektör2 v) {
		return yaz(
				Hesaplayıcı.tavan(v.x),
				Hesaplayıcı.tavan(v.x));
	}
	
	/**
	 * Bu vektörün bileşenlerini ayrı ayrı yukarı yuvarlar.
	 * Bu vektörü döndürür.
	 */
	public Vektör2 tavan() {
		return tavan(this);
	}
	
	/**
	 * Verilen vektörün bileşenlerini ayrı ayrı aşağı yuvarlayıp buna yazar.
	 * Bu vektörü döndürür.
	 */
	public Vektör2 taban(Vektör2 v) {
		return yaz(
				Hesaplayıcı.taban(v.x),
				Hesaplayıcı.taban(v.x));
	}
	
	/**
	 * Bu vektörün bileşenlerini ayrı ayrı aşağı yuvarlar.
	 * Bu vektörü döndürür.
	 */
	public Vektör2 taban() {
		return taban(this);
	}
	
	/**
	 * Verilen vektörlerin aradeğerini buna yazar.
	 * Bu vektörü döndürür.
	 * Mesafelerin toplamının bir olduğunu varsayar.
	 */
	public Vektör2 aradeğer(Vektör2 sol, Vektör2 sağ, float solaUzaklık, float sağaUzaklık) {
		return yaz(
				Hesaplayıcı.aradeğer(sol.x, sağ.x, solaUzaklık, sağaUzaklık),
				Hesaplayıcı.aradeğer(sol.y, sağ.y, solaUzaklık, sağaUzaklık));
	}
	
	/**
	 * Verilen vektörle bu vektörün aradeğerini buna yazar.
	 * Bu vektörü döndürür.
	 * Mesafelerin toplamının bir olduğunu varsayar.
	 */
	public Vektör2 aradeğer(Vektör2 v, float uzaklık, float yakınlık) {
		return aradeğer(this, v, uzaklık, yakınlık);
	}
	
	/**
	 * Verilen vektörle bu vektörün nokta çarpımını hesaplar.
	 */
	public float nokta(Vektör2 v) {
		return
				x * v.x +
				y * v.y;
	}
	
	/**
	 * Vektörün uzunluğunun karesini hesaplar.
	 */
	public float uzunluğunKaresi() {
		return nokta(this);
	}
	
	/**
	 * Vektörün uzunluğu hesaplar.
	 */
	public float uzunluk() {
		return Hesaplayıcı.kökü(uzunluğunKaresi());
	}
	
	/**
	 * Verilen vektörün doğrultusunu (birim vektörünü) buna yazar.
	 * Bu vektörü döndürür.
	 */
	public Vektör2 doğrultu(Vektör2 v) {
		return böl(v, v.uzunluk());
	}
	
	/**
	 * Vektörün doğrultusunu (birim vektörünü) hesaplar.
	 * Bu vektörü döndürür.
	 */
	public Vektör2 doğrultu() {
		return böl(uzunluk());
	}
	
	/**
	 * Verilen bileşenlerin vektörünkilere eşitliğini hesaplar.
	 */
	public boolean eşittir(float x, float y) {
		return
				this.x == x &&
				this.y == y;
	}
	
	/**
	 * Verilen vektörün bu vektöre eşitliğini hesaplar.
	 */
	public boolean eşittir(Vektör2 v) {
		return eşittir(
				v.x,
				v.y);
	}
	
	/**
	 * Vektörü dizeye ekler.
	 */
	public StringBuilder dize(StringBuilder dize) {
		return dize
				.append('(')
				.append(x)
				.append(", ")
				.append(y)
				.append(')');
	}
	
	/**
	 * Vektörü dizeye çevirir.
	 */
	public String dize() {
		return dize(new StringBuilder()).toString();
	}
	
	@Override
	public boolean equals(Object obj) {
		return eşittir((Vektör2)obj);
	}
	
	@Override
	public String toString() {
		return dize();
	}
}
