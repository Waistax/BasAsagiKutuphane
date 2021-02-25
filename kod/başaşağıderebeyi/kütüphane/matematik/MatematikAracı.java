/**
 * başaşağıderebeyi.kütüphane.matematik.Hesaplayıcı.java
 * 0.1 / 16 Oca 2021 / 12:49:52
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 *
 * BaşAşağıMotor'dan alındı.
 * 0.24 / 6 Kas 2020 / 11:15:43
 */
package başaşağıderebeyi.kütüphane.matematik;

/** Ondalıklı ve tam sayıların aritmetiğiyle ilgili yardımcı yöntemler sağlar.
 * İkinci işlevi Java'nın Math sınıfındaki methodlardan float alıp da double
 * döndüren yöntemlerin sonuçlarını floata çevirmektir. Buradaki yöntemlerin
 * hespi sınıfa aittir. Bu sınıfın nesnesi oluşturulmaz. */
public class MatematikAracı {
	private static final float RADYANA_ÇEVİREN_ÇARPAN = (float)(Math.PI /
		180.0D);
	private static final float DERECEYE_ÇEVİREN_ÇARPAN = 1.0F /
		RADYANA_ÇEVİREN_ÇARPAN;
	private static final float DENK_SAYILACAK_ÖZÜR_PAYI = 0.1F;
	
	/** Benek biriminden verilen iki sayının denk sayılıp sayılmadığını
	 * döndürür. Denklik, tam olarak eşitlik değilse de aşırı yakınlıktır. */
	public static boolean
		denkSayılmalarınıBul(final float soldakiSayı, final float sağdakiSayı) {
		return Math.abs(soldakiSayı - sağdakiSayı) <= DENK_SAYILACAK_ÖZÜR_PAYI;
	}
	
	/** Verilen ondalık sayıyı aralıkta olacak şekilde döndürür. Sayı eğer
	 * aralıktaysa onu, taban değerin altındaysa taban değeri veya tavan değerin
	 * üstündeyse tavan değeri döndürür. */
	public static float sıkıştır(
		final float sayı,
		final float tabanDeğeri,
		final float tavanDeğeri) {
		return küçüğüBul(büyüğüBul(sayı, tabanDeğeri), tavanDeğeri);
	}
	
	/** Verilen iki ondalık sayıdan küçük olanı döndürür. */
	public static float
		küçüğüBul(final float soldakiSayı, final float sağdakiSayı) {
		return soldakiSayı < sağdakiSayı ? soldakiSayı : sağdakiSayı;
	}
	
	/** Verilen iki ondalık sayıdan büyük olanı döndürür. */
	public static float
		büyüğüBul(final float soldakiSayı, final float sağdakiSayı) {
		return soldakiSayı > sağdakiSayı ? soldakiSayı : sağdakiSayı;
	}
	
	/** Verilen ondalık sayıya en yakın tam sayıyı döndürür. */
	public static int yuvarla(final float sayı) {
		return Math.round(sayı);
	}
	
	/** Verilen ondalık sayıdan küçük, en yakın tam sayıyı döndürür. */
	public static float aşağıYuvarla(final float sayı) {
		return (float)Math.floor(sayı);
	}
	
	/** Verilen ondalık sayıdan büyük, en yakın tam sayıyı döndürür. */
	public static float yukarıYuvarla(final float sayı) {
		return (float)Math.ceil(sayı);
	}
	
	/** Verilen iki nesneden yakın olanı döndürür. */
	public static <T> T aradeğerleriniBul(
		final T soldakiNesne,
		final T sağdakiNesne,
		final float soldakineOlanUzaklık,
		final float sağdakineOlanUzaklık) {
		if (soldakineOlanUzaklık < sağdakineOlanUzaklık)
			return soldakiNesne;
		else
			return sağdakiNesne;
	}
	
	/** Verilen iki tam sayının verilen mesafelere göre aradeğerini döndürür.
	 * Mesafelerin toplamının bir olduğunu varsayar. */
	public static int aradeğerleriniBul(
		final int soldakiTamSayı,
		final int sağdakiTamSayı,
		final float soldakineOlanUzaklık,
		final float sağdakineOlanUzaklık) {
		return yuvarla(
			aradeğerleriniBul(
				(float)soldakiTamSayı,
				(float)sağdakiTamSayı,
				soldakineOlanUzaklık,
				sağdakineOlanUzaklık));
	}
	
	/** Verilen iki ondalık sayının verilen mesafelere göre aradeğerini
	 * döndürür. Mesafelerin toplamının bir olduğunu varsayar. */
	public static float aradeğerleriniBul(
		final float soldakiSayı,
		final float sağdakiSayı,
		final float soldakineOlanUzaklık,
		final float sağdakineOlanUzaklık) {
		return soldakiSayı * sağdakineOlanUzaklık +
			sağdakiSayı * soldakineOlanUzaklık;
	}
	
	/** Verilen ondalık sayının karesini döndürür. */
	public static float karesiniBul(final float sayı) {
		return sayı * sayı;
	}
	
	/** Verilen tam sayının karesini döndürür. */
	public static int karesiniBul(final int tamSayı) {
		return tamSayı * tamSayı;
	}
	
	/** Verilen ondalık sayının kare kökünü döndürür. */
	public static float kökünüBul(final float sayı) {
		return (float)Math.sqrt(sayı);
	}
	
	/** Derece biriminden verilen açının radyan biriminden değerini döndürür. */
	public static float radyanaÇevir(final float açı) {
		return açı * RADYANA_ÇEVİREN_ÇARPAN;
	}
	
	/** Radyan biriminden verilen açının derece biriminden değerini döndürür. */
	public static float dereceyeÇevir(final float açı) {
		return açı * DERECEYE_ÇEVİREN_ÇARPAN;
	}
	
	/** Radyan biriminden verilen açının dikmelik değerini döndürür. */
	public static float dikmeliğiniBul(final float açı) {
		return (float)Math.sin(açı);
	}
	
	/** Radyan biriminden verilen açının eşdikmelik değerini döndürür. */
	public static float eşdikmeliğiniBul(final float açı) {
		return (float)Math.cos(açı);
	}
	
	/** Radyan biriminden verilen açının teğetlik değerini döndürür. */
	public static float teğetliğiniBul(final float açı) {
		return (float)Math.tan(açı);
	}
	
	/** Dikmelik değeri verilen açının radyan biriminden değerini döndürür. */
	public static float dikmeliktenAçıyıBul(final float dikmelik) {
		return (float)Math.asin(dikmelik);
	}
	
	/** Eşdikmelik değeri verilen açının radyan biriminden değerini döndürür. */
	public static float eşdikmeliktenAçıyıBul(final float eşdikmelik) {
		return (float)Math.acos(eşdikmelik);
	}
	
	/** Teğetlik değeri verilen açının radyan biriminden değerini döndürür. */
	public static float teğetliktenAçıyıBul(final float teğetlik) {
		return (float)Math.atan(teğetlik);
	}
	
	/** Bu sınıfın bir nesnesini tanımlamayı engeller. */
	private MatematikAracı() {
	}
}
