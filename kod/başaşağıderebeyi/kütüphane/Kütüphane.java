/**
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 * 0.12 / 14 Mar 2021 / 20:58:41
 */
package başaşağıderebeyi.kütüphane;

/** Kütüphane ile ilgili genel şeylerin bulunduğu sınıf. */
public class Kütüphane {
	/** Ana sürümü. */
	public static final int ANA_SÜRÜMÜ = 1;
	/** Ara sürümü. */
	public static final int ARA_SÜRÜMÜ = 0;
	/** Yaması. */
	public static final int YAMASI = 1;
	/** Bütün sürümü. */
	public static final String SÜRÜM =
		ANA_SÜRÜMÜ + "." + ARA_SÜRÜMÜ + "." + YAMASI;
	
	/** Bu sınıfın bir nesnesini tanımlamayı engeller. */
	private Kütüphane() {
	}
}
