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
	/** Çapraz olarak birlere sahip olan dizey. */
	public static final Dizey4 BİRİM = new Dizey4().birimDizey();
	/** Elemanlarının hepsi sıfır olan dizey. */
	public static final Dizey4 SIFIR = new Dizey4();
	
	/** Dizeyin elemanlarını içeren dizi. */
	public final float[] e;
	
	/** Sıfır dizeyi tanımlar. */
	public Dizey4() {
		e = new float[16];
	}
	
	/** Verilenle aynı tanımlar. */
	public Dizey4(final Dizey4 ö) {
		this();
		değiştir(ö);
	}
	
	/** Dizeyi birim dizeye dönüştürür. Bu dizeyi döndürür. */
	public Dizey4 birimDizey() {
		e[0] = 1.0F;
		e[1] = 0.0F;
		e[2] = 0.0F;
		e[3] = 0.0F;
		e[4] = 0.0F;
		e[5] = 1.0F;
		e[6] = 0.0F;
		e[7] = 0.0F;
		e[8] = 0.0F;
		e[9] = 0.0F;
		e[10] = 1.0F;
		e[11] = 0.0F;
		e[12] = 0.0F;
		e[13] = 0.0F;
		e[14] = 0.0F;
		e[15] = 1.0F;
		return this;
	}
	
	/** Verilen dizeyi bu dizeyle çarpar. Bu dizeyi döndürür. */
	public Dizey4 çarp(final Dizey4 ö) {
		synchronized (TAMPON) {
			return değiştir(TAMPON.çarp(this, ö));
		}
	}
	
	/** Verilen dizeyleri çarpıp buna yazar. Bu dizeyi döndürür. */
	public Dizey4 çarp(final Dizey4 sol, final Dizey4 sağ) {
		e[0] = sol.e[0] * sağ.e[0] +
			sol.e[4] * sağ.e[1] +
			sol.e[8] * sağ.e[2] +
			sol.e[12] * sağ.e[3];
		e[1] = sol.e[1] * sağ.e[0] +
			sol.e[5] * sağ.e[1] +
			sol.e[9] * sağ.e[2] +
			sol.e[13] * sağ.e[3];
		e[2] = sol.e[2] * sağ.e[0] +
			sol.e[6] * sağ.e[1] +
			sol.e[10] * sağ.e[2] +
			sol.e[14] * sağ.e[3];
		e[3] = sol.e[3] * sağ.e[0] +
			sol.e[7] * sağ.e[1] +
			sol.e[11] * sağ.e[2] +
			sol.e[15] * sağ.e[3];
		e[4] = sol.e[0] * sağ.e[4] +
			sol.e[4] * sağ.e[5] +
			sol.e[8] * sağ.e[6] +
			sol.e[12] * sağ.e[7];
		e[5] = sol.e[1] * sağ.e[4] +
			sol.e[5] * sağ.e[5] +
			sol.e[9] * sağ.e[6] +
			sol.e[13] * sağ.e[7];
		e[6] = sol.e[2] * sağ.e[4] +
			sol.e[6] * sağ.e[5] +
			sol.e[10] * sağ.e[6] +
			sol.e[14] * sağ.e[7];
		e[7] = sol.e[3] * sağ.e[4] +
			sol.e[7] * sağ.e[5] +
			sol.e[11] * sağ.e[6] +
			sol.e[15] * sağ.e[7];
		e[8] = sol.e[0] * sağ.e[8] +
			sol.e[4] * sağ.e[9] +
			sol.e[8] * sağ.e[10] +
			sol.e[12] * sağ.e[11];
		e[9] = sol.e[1] * sağ.e[8] +
			sol.e[5] * sağ.e[9] +
			sol.e[9] * sağ.e[10] +
			sol.e[13] * sağ.e[11];
		e[10] = sol.e[2] * sağ.e[8] +
			sol.e[6] * sağ.e[9] +
			sol.e[10] * sağ.e[10] +
			sol.e[14] * sağ.e[11];
		e[11] = sol.e[3] * sağ.e[8] +
			sol.e[7] * sağ.e[9] +
			sol.e[11] * sağ.e[10] +
			sol.e[15] * sağ.e[11];
		e[12] = sol.e[0] * sağ.e[12] +
			sol.e[4] * sağ.e[13] +
			sol.e[8] * sağ.e[14] +
			sol.e[12] * sağ.e[15];
		e[13] = sol.e[1] * sağ.e[12] +
			sol.e[5] * sağ.e[13] +
			sol.e[9] * sağ.e[14] +
			sol.e[13] * sağ.e[15];
		e[14] = sol.e[2] * sağ.e[12] +
			sol.e[6] * sağ.e[13] +
			sol.e[10] * sağ.e[14] +
			sol.e[14] * sağ.e[15];
		e[15] = sol.e[3] * sağ.e[12] +
			sol.e[7] * sağ.e[13] +
			sol.e[11] * sağ.e[14] +
			sol.e[15] * sağ.e[15];
		return this;
	}
	
	/** Verilen dizeyi buna yazar. Bu dizeyi döndürür. */
	public Dizey4 değiştir(final Dizey4 ö) {
		System.arraycopy(ö.e, 0, e, 0, 16);
		return this;
	}
	
	/** Dönüşüm dizeyini günceller. Dizeyin daha önceden de dönüşüm dizeyi
	 * olduğunu varsayar. Bu dizeyi döndürür. */
	public Dizey4 dönüşümDizeyiniGüncelle(
		final float x,
		final float y,
		final float z,
		float a,
		final float bx,
		final float by) {
		a = MatematikAracı.radyanaÇevir(a);
		final float sin = MatematikAracı.dikmeliğiniBul(a);
		final float cos = MatematikAracı.eşdikmeliğiniBul(a);
		
		e[0] = cos * bx;
		e[1] = sin * bx;
		e[4] = -sin * by;
		e[5] = cos * by;
		e[12] = x;
		e[13] = y;
		e[14] = z;
		
		return this;
	}
	
	/** Dizeyi dönüşüm dizeyine dönüştürür. Bu dizeyi döndürür. */
	public Dizey4 dönüşümDizeyiYaz(
		final float x,
		final float y,
		final float z,
		float a,
		final float bx,
		final float by) {
		a = MatematikAracı.radyanaÇevir(a);
		final float sin = MatematikAracı.dikmeliğiniBul(a);
		final float cos = MatematikAracı.eşdikmeliğiniBul(a);
		
		e[0] = cos * bx;
		e[1] = sin * bx;
		e[2] = 0.0F;
		e[3] = 0.0F;
		e[4] = -sin * by;
		e[5] = cos * by;
		e[6] = 0.0F;
		e[8] = 0.0F;
		e[7] = 0.0F;
		e[9] = 0.0F;
		e[10] = 0.0F;
		e[11] = 0.0F;
		e[12] = x;
		e[13] = y;
		e[14] = z;
		e[15] = 1.0F;
		
		return this;
	}
	
	/** Dizeyi izdüşüm dizeyine dönüştürür. Bu dizeyi döndürür. */
	public Dizey4 izdüşümDizeyi(
		final float genişlik,
		final float yükseklik,
		final float derinlik) {
		e[0] = 2.0F / genişlik;
		e[1] = 0.0F;
		e[2] = 0.0F;
		e[3] = 0.0F;
		e[4] = 0.0F;
		e[5] = 2.0F / yükseklik;
		e[6] = 0.0F;
		e[7] = 0.0F;
		e[8] = 0.0F;
		e[9] = 0.0F;
		e[10] = 2.0F / -derinlik;
		e[11] = 0.0F;
		e[12] = 0.0F;
		e[13] = 0.0F;
		e[14] = 0.0F;
		e[15] = 1.0F;
		return this;
	}
	
	/** Dizeyi sıfır dizeyine dönüştür. Bu dizeyi döndürür. */
	public Dizey4 sıfırDizeyi() {
		e[0] = 0.0F;
		e[1] = 0.0F;
		e[2] = 0.0F;
		e[3] = 0.0F;
		e[4] = 0.0F;
		e[5] = 0.0F;
		e[6] = 0.0F;
		e[7] = 0.0F;
		e[8] = 0.0F;
		e[9] = 0.0F;
		e[10] = 0.0F;
		e[11] = 0.0F;
		e[12] = 0.0F;
		e[13] = 0.0F;
		e[14] = 0.0F;
		e[15] = 0.0F;
		return this;
	}
}
