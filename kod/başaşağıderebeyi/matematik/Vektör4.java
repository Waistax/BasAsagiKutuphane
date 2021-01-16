/**
 * başaşağıderebeyi.matematik.Vektör4.java
 * 0.2 / 16 Oca 2021 / 14:13:24
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 * 
 * BaşAşağıMotor'dan alındı.
 * 0.22 / 4 Kas 2020 / 21:30:15
 */
package başaşağıderebeyi.matematik;

/**
 * Dört boyutlu bir vektörü temsil eder.
 * Bileşenler ondalıklı sayılar olarak saklanır.
 */
public class Vektör4 {
	/** Vektörün birinci bileşenidir. */
	public float x;
	/** Vektörün ikinci bileşenidir. */
	public float y;
	/** Vektörün üçüncü bileşenidir. */
	public float z;
	/** Vektörün dördüncü bileşenidir. */
	public float w;
	
	/**
	 * Sıfır vektörü tanımlar.
	 */
	public Vektör4() {
	}
	
	/**
	 * Bileşenlerle tanımlar.
	 */
	public Vektör4(float x, float y, float z, float w) {
		yaz(
				x,
				y,
				z,
				w);
	}
	
	/**
	 * Verilenle aynı tanımlar.
	 */
	public Vektör4(Vektör4 v) {
		yaz(v);
	}
	
	/**
	 * Vektörün birinci bileşenini değiştirir.
	 * Vektörü döndürür.
	 */
	public Vektör4 yazX(float x) {
		this.x = x;
		return this;
	}
	
	/**
	 * Vektörün ikinci bileşenini değiştirir.
	 * Vektörü döndürür.
	 */
	public Vektör4 yazY(float y) {
		this.y = y;
		return this;
	}
	
	/**
	 * Vektörün üçüncü bileşenini değiştirir.
	 * Vektörü döndürür.
	 */
	public Vektör4 yazZ(float z) {
		this.z = z;
		return this;
	}
	
	/**
	 * Vektörün dördüncü bileşenini değiştirir.
	 * Vektörü döndürür.
	 */
	public Vektör4 yazW(float w) {
		this.w = w;
		return this;
	}
	
	/**
	 * Vektörün bileşenlerini değiştirir.
	 * Vektörü döndürür.
	 */
	public Vektör4 yaz(float x, float y, float z, float w) {
		return
				yazX(x).
				yazY(y).
				yazZ(z).
				yazW(w);
	}
	
	/**
	 * Verilen vektörü buna yazar.
	 * Bu vektörü döndürür.
	 */
	public Vektör4 yaz(Vektör4 v) {
		return yaz(
				v.x,
				v.y,
				v.z,
				v.w);
	}
	
	/**
	 * Verilen vektörleri toplayıp buna yazar.
	 * Bu vektörü döndürür.
	 */
	public Vektör4 topla(Vektör4 sol, Vektör4 sağ) {
		return yaz(
				sol.x + sağ.x,
				sol.y + sağ.y,
				sol.z + sağ.z,
				sol.w + sağ.w);
	}
	
	/**
	 * Verilen vektörü bu vektöre ekler.
	 * Bu vektörü döndürür.
	 */
	public Vektör4 topla(Vektör4 v) {
		return topla(this, v);
	}
	
	/**
	 * Verilen vektörlerin çıkarıp buna yazar.
	 * Bu vektörü döndürür.
	 */
	public Vektör4 çıkar(Vektör4 sol, Vektör4 sağ) {
		return yaz(
				sol.x - sağ.x,
				sol.y - sağ.y,
				sol.z - sağ.z,
				sol.w - sağ.w);
	}
	
	/**
	 * Verilen vektörü bu vektörden çıkarır.
	 * Bu vektörü döndürür.
	 */
	public Vektör4 çıkar(Vektör4 v) {
		return çıkar(this, v);
	}
	
	/**
	 * Verilen vektörü sayıyla çarpıp buna yazar.
	 * Bu vektörü döndürür.
	 */
	public Vektör4 çarp(Vektör4 sol, float sağ) {
		return yaz(
				sol.x * sağ,
				sol.y * sağ,
				sol.z * sağ,
				sol.w * sağ);
	}
	
	/**
	 * Vektörü sayıyla çarpar.
	 * Vektörü döndürür.
	 */
	public Vektör4 çarp(float o) {
		return çarp(this, o);
	}
	
	/**
	 * Verilen vektörü sayıya bölüp buna yazar.
	 * Bu vektörü döndürür.
	 */
	public Vektör4 böl(Vektör4 sol, float sağ) {
		return yaz(
				sol.x / sağ,
				sol.y / sağ,
				sol.z / sağ,
				sol.w / sağ);
	}
	
	/**
	 * Vektörü sayıya böler.
	 * Vektörü döndürür.
	 */
	public Vektör4 böl(float o) {
		return böl(this, o);
	}
	
	/**
	 * Verilen vektörlerin bileşenlerinden küçük olanlarını buna yazar.
	 * Bu vektörü döndürür.
	 */
	public Vektör4 küçüktür(Vektör4 sol, Vektör4 sağ) {
		return yaz(
				Hesaplayıcı.küçüktür(sol.x, sağ.x),
				Hesaplayıcı.küçüktür(sol.y, sağ.y),
				Hesaplayıcı.küçüktür(sol.z, sağ.z),
				Hesaplayıcı.küçüktür(sol.w, sağ.w));
	}
	
	/**
	 * Verilen vektörün bileşenlerinden küçük olanlarını yazar.
	 * Bu vektörü döndürür.
	 */
	public Vektör4 küçüktür(Vektör4 v) {
		return küçüktür(this, v);
	}
	
	/**
	 * Verilen vektörlerin bileşenlerinden büyük olanlarını buna yazar.
	 * Bu vektörü döndürür.
	 */
	public Vektör4 büyüktür(Vektör4 sol, Vektör4 sağ) {
		return yaz(
				Hesaplayıcı.büyüktür(sol.x, sağ.x),
				Hesaplayıcı.büyüktür(sol.y, sağ.y),
				Hesaplayıcı.büyüktür(sol.z, sağ.z),
				Hesaplayıcı.büyüktür(sol.w, sağ.w));
	}
	
	/**
	 * Verilen vektörün bileşenlerinden büyük olanlarını yazar.
	 * Bu vektörü döndürür.
	 */
	public Vektör4 büyüktür(Vektör4 v) {
		return büyüktür(this, v);
	}
	
	/**
	 * Verilen vektörün bileşenlerini ayrı ayrı sıkıştırıp buna yazar.
	 * Bu vektörü döndürür.
	 */
	public Vektör4 sıkıştır(Vektör4 v, Vektör4 alt, Vektör4 üst) {
		return yaz(
				Hesaplayıcı.sıkıştır(v.x, alt.x, üst.x),
				Hesaplayıcı.sıkıştır(v.y, alt.y, üst.y),
				Hesaplayıcı.sıkıştır(v.z, alt.z, üst.z),
				Hesaplayıcı.sıkıştır(v.w, alt.w, üst.w));
	}
	
	/**
	 * Bu vektörün bileşenlerini ayrı ayrı sıkıştırır.
	 * Bu vektörü döndürür.
	 */
	public Vektör4 sıkıştır(Vektör4 alt, Vektör4 üst) {
		return sıkıştır(this, alt, üst);
	}
	
	/**
	 * Verilen vektörün bileşenlerini ayrı ayrı yuvarlayıp buna yazar.
	 * Bu vektörü döndürür.
	 */
	public Vektör4 yuvarla(Vektör4 v) {
		return yaz(
				Hesaplayıcı.yuvarla(v.x),
				Hesaplayıcı.yuvarla(v.y),
				Hesaplayıcı.yuvarla(v.z),
				Hesaplayıcı.yuvarla(v.w));
	}
	
	/**
	 * Bu vektörün bileşenlerini ayrı ayrı yuvarlar.
	 * Bu vektörü döndürür.
	 */
	public Vektör4 yuvarla() {
		return yuvarla(this);
	}
	
	/**
	 * Verilen vektörün bileşenlerini ayrı ayrı yukarı yuvarlayıp buna yazar.
	 * Bu vektörü döndürür.
	 */
	public Vektör4 tavan(Vektör4 v) {
		return yaz(
				Hesaplayıcı.tavan(v.x),
				Hesaplayıcı.tavan(v.y),
				Hesaplayıcı.tavan(v.z),
				Hesaplayıcı.tavan(v.w));
	}
	
	/**
	 * Bu vektörün bileşenlerini ayrı ayrı yukarı yuvarlar.
	 * Bu vektörü döndürür.
	 */
	public Vektör4 tavan() {
		return tavan(this);
	}
	
	/**
	 * Verilen vektörün bileşenlerini ayrı ayrı aşağı yuvarlayıp buna yazar.
	 * Bu vektörü döndürür.
	 */
	public Vektör4 taban(Vektör4 v) {
		return yaz(
				Hesaplayıcı.taban(v.x),
				Hesaplayıcı.taban(v.y),
				Hesaplayıcı.taban(v.z),
				Hesaplayıcı.taban(v.w));
	}
	
	/**
	 * Bu vektörün bileşenlerini ayrı ayrı aşağı yuvarlar.
	 * Bu vektörü döndürür.
	 */
	public Vektör4 taban() {
		return taban(this);
	}
	
	/**
	 * Verilen vektörlerin aradeğerini buna yazar.
	 * Bu vektörü döndürür.
	 * Mesafelerin toplamının bir olduğunu varsayar.
	 */
	public Vektör4 aradeğer(Vektör4 sol, Vektör4 sağ, float solaUzaklık, float sağaUzaklık) {
		return yaz(
				Hesaplayıcı.aradeğer(sol.x, sağ.x, solaUzaklık, sağaUzaklık),
				Hesaplayıcı.aradeğer(sol.y, sağ.y, solaUzaklık, sağaUzaklık),
				Hesaplayıcı.aradeğer(sol.z, sağ.z, solaUzaklık, sağaUzaklık),
				Hesaplayıcı.aradeğer(sol.w, sağ.w, solaUzaklık, sağaUzaklık));
	}
	
	/**
	 * Verilen vektörle bu vektörün aradeğerini buna yazar.
	 * Bu vektörü döndürür.
	 * Mesafelerin toplamının bir olduğunu varsayar.
	 */
	public Vektör4 aradeğer(Vektör4 v, float uzaklık, float yakınlık) {
		return aradeğer(this, v, uzaklık, yakınlık);
	}
	
	/**
	 * Verilen vektörle bu vektörün nokta çarpımını hesaplar.
	 */
	public float nokta(Vektör4 v) {
		return
				x * v.x +
				y * v.y +
				z * v.z +
				w * v.w;
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
	public Vektör4 doğrultu(Vektör4 v) {
		return böl(v, v.uzunluk());
	}
	
	/**
	 * Vektörün doğrultusunu (birim vektörünü) hesaplar.
	 * Bu vektörü döndürür.
	 */
	public Vektör4 doğrultu() {
		return böl(uzunluk());
	}
	
	/**
	 * Verilen bileşenlerin vektörünkilere eşitliğini hesaplar.
	 */
	public boolean eşittir(float x, float y, float z, float w) {
		return
				this.x == x &&
				this.y == y &&
				this.z == z &&
				this.w == w;
	}
	
	/**
	 * Verilen vektörün bu vektöre eşitliğini hesaplar.
	 */
	public boolean eşittir(Vektör4 v) {
		return eşittir(
				v.x,
				v.y,
				v.z,
				v.w);
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
				.append(", ")
				.append(z)
				.append(", ")
				.append(w)
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
		return eşittir((Vektör4)obj);
	}
	
	@Override
	public String toString() {
		return dize();
	}
}
