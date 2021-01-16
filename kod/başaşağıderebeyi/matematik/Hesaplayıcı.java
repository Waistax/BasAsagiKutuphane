/**
 * başaşağıderebeyi.matematik.Hesaplayıcı.java
 * 0.1 / 16 Oca 2021 / 12:49:52
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 * 
 * BaşAşağıMotor'dan alındı.
 * 0.24 / 6 Kas 2020 / 11:15:43
 */
package başaşağıderebeyi.matematik;

/** Ondalıklı sayılar içeren hesaplamalar sağlar.
 * Buradaki yöntemlerin hespi sınıfa aittir.
 * Bu sınıfın nesnesi oluşturulmaz. */
public class Hesaplayıcı {
	/** Derece biriminden bir açı ile çarpıldığında onun radyan biriminden değerini veren sayıdır. */
	public static final float RADYANA_ÇEVİR = (float) (Math.PI / 180.0);
	
	/** Radyan biriminden bir açı ile çarpıldığında onun derece biriminden değerini veren sayıdır. */
	public static final float DERECEYE_ÇEVİR = 1 / RADYANA_ÇEVİR;
	
	/** İki sayıdan küçük olanı döndürür. */
	public static float küçüktür(float sol, float sağ) {
		return sol < sağ ? sol : sağ;
	}
	
	/** İki sayıdan büyük olanı döndürür. */
	public static float büyüktür(float sol, float sağ) {
		return sol > sağ ? sol : sağ;
	}
	
	/** Sayıyı aralıkta olacak şekilde döndürür.
	 * Sayı eğer aralıktaysa onu, alt değerin altındaysa alt değeri ve üst değerin üstündeyse üst değeri döndürür. */
	public static float sıkıştır(float o, float alt, float üst) {
		return küçüktür(büyüktür(0, alt), üst);
	}
	
	/** Ondalık sayıya en yakın tam sayıyı döndürür. */
	public static float yuvarla(float o) {
		return (float)Math.round(o);
	}
	
	/** Ondalık sayıdan büyük en yakın tam sayıyı döndürür. */
	public static float tavan(float o) {
		return (float)Math.ceil(o);
	}
	
	/** Ondalık sayıdan küçük en yakın tam sayıyı döndürür. */
	public static float taban(float o) {
		return (float)Math.floor(o);
	}
	
	/** İki ondalık sayının mesafelere göre aradeğerini hesaplar.
	 * Mesafelerin toplamının bir olduğunu varsayar. */
	public static float aradeğer(float sol, float sağ, float solaUzaklık, float sağaUzaklık) {
		return sol * sağaUzaklık + sağ * solaUzaklık;
	}
	
	/** İki tam sayının mesafelere göre aradeğerini hesaplar.
	 * Mesafelerin toplamının bir olduğunu varsayar. */
	public static int aradeğer(int sol, int sağ, float solaUzaklık, float sağaUzaklık) {
		return (int)yuvarla(aradeğer(sol, sağ, solaUzaklık, sağaUzaklık));
	}
	
	/** İki nesneden yakın olanı döndürür. */
	public static <T> T aradeğer(T sol, T sağ, float solaUzaklık, float sağaUzaklık) {
		if (solaUzaklık < sağaUzaklık)
			return sol;
		else
			return sağ;
	}
	
	/** Sayının karesini hesaplar. */
	public static float karesi(float o) {
		return o * o;
	}
	
	/** Sayının kökünü hesaplar. */
	public static float kökü(float o) {
		return (float)Math.sqrt(o);
	}
	
	/** Derece biriminden açının radyan biriminden değerini hesaplar. */
	public static float radyan(float o) {
		return o * RADYANA_ÇEVİR;
	}
	
	/** Radyan biriminden açının derece biriminden değerini hesaplar. */
	public static float derece(float o) {
		return o * DERECEYE_ÇEVİR;
	}
	
	/** Radyan biriminden açının sinüs değerini hesaplar. */
	public static float sin(float o) {
		return (float)Math.sin(o);
	}
	
	/** Radyan biriminden açının cosinüs değerini hesaplar. */
	public static float cos(float o) {
		return (float)Math.cos(o);
	}
	
	/** Radyan biriminden açının tanjant değerini hesaplar. */
	public static float tan(float o) {
		return (float)Math.tan(o);
	}
	
	/** Sinüs değerini veren açının radyan biriminden değerini hesaplar. */
	public static float asin(float o) {
		return (float)Math.asin(o);
	}
	
	/** Cosinüs değerini veren açının radyan biriminden değerini hesaplar. */
	public static float acos(float o) {
		return (float)Math.acos(o);
	}
	
	/** Tanjant değerini veren açının radyan biriminden değerini hesaplar. */
	public static float atan(float o) {
		return (float)Math.atan(o);
	}
	
	/** Gizli yazılarak oluşturucuya erişim engellenmiştir. */
	private Hesaplayıcı(){
	}
}
