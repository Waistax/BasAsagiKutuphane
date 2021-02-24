/**
 * başaşağıderebeyi.kütüphane.matematik.Hesaplayıcı.java
 * 0.1 / 16 Oca 2021 / 12:49:52
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 *
 * BaşAşağıMotor'dan alındı.
 * 0.24 / 6 Kas 2020 / 11:15:43
 */
package başaşağıderebeyi.kütüphane.matematik;

/** Ondalıklı ve tam sayılar döndüren hesaplamalar sağlar. Buradaki yöntemlerin hespi sınıfa aittir. Bu
 * sınıfın nesnesi oluşturulmaz. */
public class Hesaplayıcı {
	/** Radyan biriminden bir açı ile çarpıldığında onun derece biriminden değerini veren sayı. */
	public static final float DERECEYE_ÇEVİR = 1 / Hesaplayıcı.RADYANA_ÇEVİR;
	/** Derece biriminden bir açı ile çarpıldığında onun radyan biriminden değerini veren sayı. */
	public static final float RADYANA_ÇEVİR = (float)(Math.PI / 180.0);
	
	/** Cosinüs değerini veren açının radyan biriminden değerini hesaplar. */
	public static float acos(final float o) {
		return (float)Math.acos(o);
	}
	
	/** İki ondalık sayının mesafelere göre aradeğerini hesaplar. Mesafelerin toplamının bir olduğunu
	 * varsayar. */
	public static float aradeğer(	final float sol,
									final float sağ,
									final float solaUzaklık,
									final float sağaUzaklık) {
		return sol * sağaUzaklık + sağ * solaUzaklık;
	}
	
	/** İki tam sayının mesafelere göre aradeğerini hesaplar. Mesafelerin toplamının bir olduğunu
	 * varsayar. */
	public static int aradeğer(	final int sol,
								final int sağ,
								final float solaUzaklık,
								final float sağaUzaklık) {
		return (int)Hesaplayıcı.yuvarla(Hesaplayıcı.aradeğer(sol, sağ, solaUzaklık, sağaUzaklık));
	}
	
	/** İki nesneden yakın olanı döndürür. */
	public static <T> T aradeğer(	final T sol,
									final T sağ,
									final float solaUzaklık,
									final float sağaUzaklık) {
		if (solaUzaklık < sağaUzaklık)
			return sol;
		else
			return sağ;
	}
	
	/** Sinüs değerini veren açının radyan biriminden değerini hesaplar. */
	public static float asin(final float o) {
		return (float)Math.asin(o);
	}
	
	/** Tanjant değerini veren açının radyan biriminden değerini hesaplar. */
	public static float atan(final float o) {
		return (float)Math.atan(o);
	}
	
	/** İki sayıdan büyük olanı döndürür. */
	public static float büyüktür(final float sol, final float sağ) {
		return sol > sağ ? sol : sağ;
	}
	
	/** Radyan biriminden açının cosinüs değerini hesaplar. */
	public static float cos(final float o) {
		return (float)Math.cos(o);
	}
	
	/** Radyan biriminden açının derece biriminden değerini hesaplar. */
	public static float derece(final float o) {
		return o * Hesaplayıcı.DERECEYE_ÇEVİR;
	}
	
	/** Ondalıklı sayının karesini hesaplar. */
	public static float karesi(final float o) {
		return o * o;
	}
	
	/** Tam sayının karesini hesaplar. */
	public static int karesi(final int t) {
		return t * t;
	}
	
	/** Sayının kökünü hesaplar. */
	public static float kökü(final float o) {
		return (float)Math.sqrt(o);
	}
	
	/** İki sayıdan küçük olanı döndürür. */
	public static float küçüktür(final float sol, final float sağ) {
		return sol < sağ ? sol : sağ;
	}
	
	/** Derece biriminden açının radyan biriminden değerini hesaplar. */
	public static float radyan(final float o) {
		return o * Hesaplayıcı.RADYANA_ÇEVİR;
	}
	
	/** Sayıyı aralıkta olacak şekilde döndürür. Sayı eğer aralıktaysa onu, alt değerin altındaysa alt
	 * değeri ve üst değerin üstündeyse üst değeri döndürür. */
	public static float sıkıştır(final float o, final float alt, final float üst) {
		return Hesaplayıcı.küçüktür(Hesaplayıcı.büyüktür(0, alt), üst);
	}
	
	/** Radyan biriminden açının sinüs değerini hesaplar. */
	public static float sin(final float o) {
		return (float)Math.sin(o);
	}
	
	/** Ondalık sayıdan küçük en yakın tam sayıyı döndürür. */
	public static float taban(final float o) {
		return (float)Math.floor(o);
	}
	
	/** Radyan biriminden açının tanjant değerini hesaplar. */
	public static float tan(final float o) {
		return (float)Math.tan(o);
	}
	
	/** Ondalık sayıdan büyük en yakın tam sayıyı döndürür. */
	public static float tavan(final float o) {
		return (float)Math.ceil(o);
	}
	
	/** Ondalık sayıya en yakın tam sayıyı döndürür. */
	public static float yuvarla(final float o) {
		return Math.round(o);
	}
	
	/** Gizli yazılarak oluşturucuya erişim engellenmiştir. */
	private Hesaplayıcı() {
	}
}
