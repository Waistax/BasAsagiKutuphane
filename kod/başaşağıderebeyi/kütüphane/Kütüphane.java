/**
 * başaşağıderebeyi.kütüphane.Kütüphane.java
 * 0.12 / 14 Mar 2021 / 20:58:41
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.kütüphane;

/** Kütüphane ile ilgili genel şeylerin bulunduğu sınıf. */
public class Kütüphane {
	/** Ana sürümü. */
	public static final int ANA_SÜRÜMÜ = 0;
	/** Ara sürümü. */
	public static final int ARA_SÜRÜMÜ = 12;
	/** Yaması. */
	public static final int YAMASI = 3;
	/** Bütün sürümü. */
	public static final String SÜRÜM =
		ANA_SÜRÜMÜ + "." + ARA_SÜRÜMÜ + "." + YAMASI;
	
	/** Bu sınıfın bir nesnesini tanımlamayı engeller. */
	private Kütüphane() {
	}
}
