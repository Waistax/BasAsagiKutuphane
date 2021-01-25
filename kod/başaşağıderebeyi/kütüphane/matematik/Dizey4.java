/**
 * başaşağıderebeyi.kütüphane.matematik.Matris.java
 * 0.3 / 16 Oca 2021 / 20:31:28
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 *
 * Waistax Framework'den biraz alındı.
 * ? / ? / ?
 */
package başaşağıderebeyi.kütüphane.matematik;

/** Dörde dört boyutlu bir dizey. Elemanlar ondalıklı sayılar olarak
 * saklanır. */
public class Dizey4 {
	/** Bazı işlemleri yaparkan ara bellek olarak kullanılan dizey. Bu dizey
	 * kullanılırken eşzamanlamaya dikkat edilmeli. */
	private static final Dizey4 TAMPON = new Dizey4();
	
	/** Dizeyin elemanlarını içeren dizi. */
	public float[] e;
	
	/** Sıfır dizeyi tanımlar. */
	public Dizey4() {
		this.e = new float[16];
	}
	
	/** Verilenle aynı tanımlar. */
	public Dizey4(final Dizey4 ö) {
		this.yaz(ö);
	}
	
	/** Verilen dizeyi buna yazar. Bu dizeyi döndürür. */
	public Dizey4 yaz(final Dizey4 ö) {
		System.arraycopy(ö.e, 0, this.e, 0, 16);
		return this;
	}
	
	/** Verilen dizeyleri çarpıp buna yazar. Bu dizeyi döndürür. */
	public Dizey4 çarp(final Dizey4 sol, final Dizey4 sağ) {
		this.e[0] = sol.e[0] * sağ.e[0] + sol.e[4] * sağ.e[1] + sol.e[8] * sağ.e[2] + sol.e[12] * sağ.e[3];
		this.e[1] = sol.e[1] * sağ.e[0] + sol.e[5] * sağ.e[1] + sol.e[9] * sağ.e[2] + sol.e[13] * sağ.e[3];
		this.e[2] = sol.e[2] * sağ.e[0] + sol.e[6] * sağ.e[1] + sol.e[10] * sağ.e[2] + sol.e[14] * sağ.e[3];
		this.e[3] = sol.e[3] * sağ.e[0] + sol.e[7] * sağ.e[1] + sol.e[11] * sağ.e[2] + sol.e[15] * sağ.e[3];
		this.e[4] = sol.e[0] * sağ.e[4] + sol.e[4] * sağ.e[5] + sol.e[8] * sağ.e[6] + sol.e[12] * sağ.e[7];
		this.e[5] = sol.e[1] * sağ.e[4] + sol.e[5] * sağ.e[5] + sol.e[9] * sağ.e[6] + sol.e[13] * sağ.e[7];
		this.e[6] = sol.e[2] * sağ.e[4] + sol.e[6] * sağ.e[5] + sol.e[10] * sağ.e[6] + sol.e[14] * sağ.e[7];
		this.e[7] = sol.e[3] * sağ.e[4] + sol.e[7] * sağ.e[5] + sol.e[11] * sağ.e[6] + sol.e[15] * sağ.e[7];
		this.e[8] = sol.e[0] * sağ.e[8] + sol.e[4] * sağ.e[9] + sol.e[8] * sağ.e[10] + sol.e[12] * sağ.e[11];
		this.e[9] = sol.e[1] * sağ.e[8] + sol.e[5] * sağ.e[9] + sol.e[9] * sağ.e[10] + sol.e[13] * sağ.e[11];
		this.e[10] = sol.e[2] * sağ.e[8] + sol.e[6] * sağ.e[9] + sol.e[10] * sağ.e[10] + sol.e[14] * sağ.e[11];
		this.e[11] = sol.e[3] * sağ.e[8] + sol.e[7] * sağ.e[9] + sol.e[11] * sağ.e[10] + sol.e[15] * sağ.e[11];
		this.e[12] = sol.e[0] * sağ.e[12] + sol.e[4] * sağ.e[13] + sol.e[8] * sağ.e[14] + sol.e[12] * sağ.e[15];
		this.e[13] = sol.e[1] * sağ.e[12] + sol.e[5] * sağ.e[13] + sol.e[9] * sağ.e[14] + sol.e[13] * sağ.e[15];
		this.e[14] = sol.e[2] * sağ.e[12] + sol.e[6] * sağ.e[13] + sol.e[10] * sağ.e[14] + sol.e[14] * sağ.e[15];
		this.e[15] = sol.e[3] * sağ.e[12] + sol.e[7] * sağ.e[13] + sol.e[11] * sağ.e[14] + sol.e[15] * sağ.e[15];
		return this;
	}
	
	/** Verilen dizeyi bu dizeyle çarpar. Bu dizeyi döndürür. */
	public Dizey4 çarp(final Dizey4 ö) {
		synchronized (Dizey4.TAMPON) {
			return this.yaz(Dizey4.TAMPON.çarp(this, ö));
		}
	}
	
	/** Dizeyi birim dizeye dönüştürür. */
	public Dizey4 birimDizey() {
		this.e[0] = 1.0F;
		this.e[1] = 0.0F;
		this.e[2] = 0.0F;
		this.e[3] = 0.0F;
		this.e[4] = 0.0F;
		this.e[5] = 1.0F;
		this.e[6] = 0.0F;
		this.e[7] = 0.0F;
		this.e[8] = 0.0F;
		this.e[9] = 0.0F;
		this.e[10] = 1.0F;
		this.e[11] = 0.0F;
		this.e[12] = 0.0F;
		this.e[13] = 0.0F;
		this.e[14] = 0.0F;
		this.e[15] = 1.0F;
		return this;
	}
	
	/** Dizeyi izdüşüm dizeyine dönüştürür. */
	public Dizey4 izdüşümDizeyi(final float genişlik, final float yükseklik, final float derinlik) {
		this.e[0] = 2.0F / genişlik;
		this.e[1] = 0.0F;
		this.e[2] = 0.0F;
		this.e[3] = 0.0F;
		this.e[4] = 0.0F;
		this.e[5] = 2.0F / yükseklik;
		this.e[6] = 0.0F;
		this.e[7] = 0.0F;
		this.e[8] = 0.0F;
		this.e[9] = 0.0F;
		this.e[10] = 2.0F / -derinlik;
		this.e[11] = 0.0F;
		this.e[12] = 0.0F;
		this.e[13] = 0.0F;
		this.e[14] = 0.0F;
		this.e[15] = 1.0F;
		return this;
	}
	
	/** Dizeyi dönüşüm dizeyine dönüştürür. */
	public Dizey4 dönüşümDizeyiYaz(final float x, final float y, final float z, float a, final float bx,
			final float by) {
		a = Hesaplayıcı.radyan(a);
		final float sin = Hesaplayıcı.sin(a);
		final float cos = Hesaplayıcı.cos(a);
		
		this.e[0] = cos * bx;
		this.e[1] = sin * bx;
		this.e[2] = 0.0F;
		this.e[3] = 0.0F;
		this.e[4] = -sin * by;
		this.e[5] = cos * by;
		this.e[6] = 0.0F;
		this.e[8] = 0.0F;
		this.e[7] = 0.0F;
		this.e[9] = 0.0F;
		this.e[10] = 0.0F;
		this.e[11] = 0.0F;
		this.e[12] = x;
		this.e[13] = y;
		this.e[14] = z;
		this.e[15] = 1.0F;
		
		return this;
	}
	
	/** Dönüşüm dizeyini günceller. Dizeyin daha önceden de dönüşüm dizeyi olduğunu
	 * varsayar. */
	public Dizey4 dönüşümDizeyiniGüncelle(final float x, final float y, final float z, float a, final float bx,
			final float by) {
		a = Hesaplayıcı.radyan(a);
		final float sin = Hesaplayıcı.sin(a);
		final float cos = Hesaplayıcı.cos(a);
		
		this.e[0] = cos * bx;
		this.e[1] = sin * bx;
//		e[ 2] = 0.0F;
//		e[ 3] = 0.0F;
		this.e[4] = -sin * by;
		this.e[5] = cos * by;
//		e[ 6] = 0.0F;
//		e[ 8] = 0.0F;
//		e[ 7] = 0.0F;
//		e[ 9] = 0.0F;
//		e[10] = 0.0F;
//		e[11] = 0.0F;
		this.e[12] = x;
		this.e[13] = y;
		this.e[14] = z;
//		e[15] = 1.0F;
		
		return this;
	}
}
